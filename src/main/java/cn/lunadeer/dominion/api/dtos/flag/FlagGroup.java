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

    /**
     * Constructs a flag group without a Dialog UI icon.
     *
     * @param id          the stable group identifier
     * @param displayName the default display name
     * @param description the default description
     * @param material    the material used to represent the group in chest UIs
     * @param flagType    the concrete flag type accepted by the group
     * @param flags       the initial flags, kept in iteration order
     */
    protected FlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material,
                        @NotNull Class<T> flagType,
                        @NotNull Collection<? extends T> flags) {
        this(id, displayName, description, material, null, flagType, flags);
    }

    /**
     * Constructs a flag group.
     *
     * @param id          the stable group identifier; it must match {@code [a-z0-9_-]+}
     * @param displayName the default display name
     * @param description the default description
     * @param material    the material used to represent the group in chest UIs
     * @param icon        the Dialog UI sprite path, or {@code null} for no icon
     * @param flagType    the concrete flag type accepted by the group
     * @param flags       the initial flags, kept in iteration order
     * @throws IllegalArgumentException if {@code id} is not a valid group identifier
     */
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

    /**
     * Gets the stable identifier of this group.
     *
     * @return the group identifier
     */
    public final @NotNull String getId() {
        return id;
    }

    /**
     * Gets the group's display name.
     *
     * @return the display name
     */
    public synchronized @NotNull String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the group's display name.
     *
     * @param displayName the new display name
     */
    public synchronized void setDisplayName(@NotNull String displayName) {
        this.displayName = Objects.requireNonNull(displayName);
        changed();
    }

    /**
     * Gets the group's description.
     *
     * @return the description
     */
    public synchronized @NotNull String getDescription() {
        return description;
    }

    /**
     * Sets the group's description.
     *
     * @param description the new description
     */
    public synchronized void setDescription(@NotNull String description) {
        this.description = Objects.requireNonNull(description);
        changed();
    }

    /**
     * Gets the material used to represent this group in chest UIs.
     *
     * @return the group's material
     */
    public synchronized @NotNull Material getMaterial() {
        return material;
    }

    /**
     * Sets the material used to represent this group in chest UIs.
     *
     * @param material the new material
     */
    public synchronized void setMaterial(@NotNull Material material) {
        this.material = Objects.requireNonNull(material);
        changed();
    }

    /**
     * Gets the native Dialog UI sprite path for this group.
     *
     * @return the sprite path, or {@code null} when the group has no icon
     */
    public synchronized @Nullable String getIcon() {
        return icon;
    }

    /**
     * Sets the native Dialog UI sprite path.
     * Null or blank means that this group has no Dialog UI icon.
     *
     * @param icon the sprite path, or {@code null} to remove the icon
     */
    public synchronized void setIcon(@Nullable String icon) {
        this.icon = normalizeIcon(icon);
        changed();
    }

    private static @Nullable String normalizeIcon(@Nullable String icon) {
        return icon == null || icon.isBlank() ? null : icon.trim();
    }

    /**
     * Adds a flag to this group.
     *
     * @param flag the flag to add
     * @return {@code true} if the flag was not already present
     * @throws IllegalArgumentException if the flag is not an instance of this group's flag type
     */
    public synchronized boolean addFlag(@NotNull T flag) {
        requireType(flag);
        boolean added = flags.add(flag);
        if (added) changed();
        return added;
    }

    /**
     * Removes a flag from this group.
     *
     * @param flag the flag to remove
     * @return {@code true} if the flag was present
     */
    public synchronized boolean removeFlag(@NotNull T flag) {
        boolean removed = flags.remove(flag);
        if (removed) changed();
        return removed;
    }

    /**
     * Checks whether this group contains a flag.
     *
     * @param flag the flag to look up
     * @return {@code true} if the flag is in this group
     */
    public synchronized boolean containsFlag(@NotNull T flag) {
        return flags.contains(flag);
    }

    /**
     * Gets the flags in their configured order.
     *
     * @return an immutable snapshot of the group's flags
     */
    public synchronized @NotNull List<T> getFlags() {
        return List.copyOf(flags);
    }

    /**
     * Gets the flag type accepted by this group.
     *
     * @return the concrete flag class
     */
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

    /**
     * Returns the {@code flags.yml} key for this group's Dialog UI icon.
     *
     * @return the configuration key for the group's icon
     */
    public final @NotNull String getConfigurationDialogUiIconKey() {
        return "groups." + getLanguageNamespace() + "." + id + ".dialog-ui-icon";
    }

    /**
     * Gets the language-file namespace used by this group type.
     *
     * @return the language namespace
     */
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
