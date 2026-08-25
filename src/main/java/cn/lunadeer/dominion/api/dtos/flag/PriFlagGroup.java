package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

/** A type-safe group of privilege flags. */
public final class PriFlagGroup extends FlagGroup<PriFlag> {
    /**
     * Constructs a privilege flag group without a Dialog UI icon.
     *
     * @param id          the stable group identifier
     * @param displayName the default display name
     * @param description the default description
     * @param material    the material used in chest UIs
     * @param flags       the initial privilege flags
     */
    public PriFlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material,
                        @NotNull Collection<? extends PriFlag> flags) {
        super(id, displayName, description, material, PriFlag.class, flags);
    }

    /**
     * Constructs a privilege flag group.
     *
     * @param id          the stable group identifier
     * @param displayName the default display name
     * @param description the default description
     * @param material    the material used in chest UIs
     * @param icon        the Dialog UI sprite path, or {@code null} for no icon
     * @param flags       the initial privilege flags
     */
    public PriFlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material,
                        @Nullable String icon,
                        @NotNull Collection<? extends PriFlag> flags) {
        super(id, displayName, description, material, icon, PriFlag.class, flags);
    }

    /**
     * Constructs an empty privilege flag group.
     *
     * @param id          the stable group identifier
     * @param displayName the default display name
     * @param description the default description
     * @param material    the material used in chest UIs
     */
    public PriFlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material) {
        this(id, displayName, description, material, List.of());
    }

    /** {@inheritDoc} */
    @Override
    protected @NotNull String getLanguageNamespace() {
        return "privilege";
    }
}
