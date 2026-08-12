package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

/**
 * A logical, ordered group of flags used for presentation and bulk editing.
 * Flag groups do not participate in permission evaluation.
 *
 * @param <T> the supported flag type
 */
public abstract class FlagGroup<T extends Flag> {
    private final String id;
    private final Class<T> flagType;
    private String displayName;
    private String description;
    private Material material;
    private String icon;
    private final LinkedHashSet<T> flags = new LinkedHashSet<>();
    private transient Runnable changeListener = () -> {
    };

    protected FlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material,
                        @NotNull Class<T> flagType,
                        @NotNull Collection<? extends T> flags) {
        this(id, displayName, description, material, null, flagType, flags);
    }

    protected FlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material,
                        @Nullable String icon,
                        @NotNull Class<T> flagType,
                        @NotNull Collection<? extends T> flags) {
        if (!id.matches("[a-z0-9_-]+")) {
            throw new IllegalArgumentException("Flag group id must match [a-z0-9_-]+: " + id);
        }
        this.id = id;
        this.displayName = Objects.requireNonNull(displayName);
        this.description = Objects.requireNonNull(description);
        this.material = Objects.requireNonNull(material);
        this.icon = normalizeIcon(icon);
        this.flagType = Objects.requireNonNull(flagType);
        for (T flag : flags) {
            requireType(flag);
            this.flags.add(flag);
        }
    }

    public final @NotNull String getId() {
        return id;
    }

    public synchronized @NotNull String getDisplayName() {
        return displayName;
    }

    public synchronized void setDisplayName(@NotNull String displayName) {
        this.displayName = Objects.requireNonNull(displayName);
        changed();
    }

    public synchronized @NotNull String getDescription() {
        return description;
    }

    public synchronized void setDescription(@NotNull String description) {
        this.description = Objects.requireNonNull(description);
        changed();
    }

    public synchronized @NotNull Material getMaterial() {
        return material;
    }

    public synchronized void setMaterial(@NotNull Material material) {
        this.material = Objects.requireNonNull(material);
        changed();
    }

    public synchronized @Nullable String getIcon() {
        return icon;
    }

    /** Null or blank means that this group has no Dialog UI icon. */
    public synchronized void setIcon(@Nullable String icon) {
        this.icon = normalizeIcon(icon);
        changed();
    }

    private static @Nullable String normalizeIcon(@Nullable String icon) {
        return icon == null || icon.isBlank() ? null : icon.trim();
    }

    public synchronized boolean addFlag(@NotNull T flag) {
        requireType(flag);
        boolean added = flags.add(flag);
        if (added) changed();
        return added;
    }

    public synchronized boolean removeFlag(@NotNull T flag) {
        boolean removed = flags.remove(flag);
        if (removed) changed();
        return removed;
    }

    public synchronized boolean containsFlag(@NotNull T flag) {
        return flags.contains(flag);
    }

    public synchronized @NotNull List<T> getFlags() {
        return List.copyOf(flags);
    }

    public final @NotNull Class<T> getFlagType() {
        return flagType;
    }

    /**
     * Returns the language key used for this group's display name.
     *
     * @return language key for the display name
     */
    public final @NotNull String getDisplayNameKey() {
        return "flag-groups." + getLanguageNamespace() + "." + id + ".display-name";
    }

    /**
     * Returns the language key used for this group's description.
     *
     * @return language key for the description
     */
    public final @NotNull String getDescriptionKey() {
        return "flag-groups." + getLanguageNamespace() + "." + id + ".description";
    }

    /** Returns the flags.yml key for this group's Dialog UI icon. */
    public final @NotNull String getConfigurationDialogUiIconKey() {
        return "groups." + getLanguageNamespace() + "." + id + ".dialog-ui-icon";
    }

    protected abstract @NotNull String getLanguageNamespace();

    synchronized void attachChangeListener(@NotNull Runnable listener) {
        changeListener = Objects.requireNonNull(listener);
    }

    synchronized void detachChangeListener() {
        changeListener = () -> {
        };
    }

    private void requireType(Flag flag) {
        if (!flagType.isInstance(flag)) {
            throw new IllegalArgumentException("Flag " + flag.getFlagName() + " is not a " + flagType.getSimpleName());
        }
    }

    private void changed() {
        changeListener.run();
    }
}
