package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

/** A type-safe group of environment flags. */
public final class EnvFlagGroup extends FlagGroup<EnvFlag> {
    /**
     * Constructs an environment flag group without a Dialog UI icon.
     *
     * @param id          the stable group identifier
     * @param displayName the default display name
     * @param description the default description
     * @param material    the material used in chest UIs
     * @param flags       the initial environment flags
     */
    public EnvFlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material,
                        @NotNull Collection<? extends EnvFlag> flags) {
        super(id, displayName, description, material, EnvFlag.class, flags);
    }

    /**
     * Constructs an environment flag group.
     *
     * @param id          the stable group identifier
     * @param displayName the default display name
     * @param description the default description
     * @param material    the material used in chest UIs
     * @param icon        the Dialog UI sprite path, or {@code null} for no icon
     * @param flags       the initial environment flags
     */
    public EnvFlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material,
                        @Nullable String icon,
                        @NotNull Collection<? extends EnvFlag> flags) {
        super(id, displayName, description, material, icon, EnvFlag.class, flags);
    }

    /**
     * Constructs an empty environment flag group.
     *
     * @param id          the stable group identifier
     * @param displayName the default display name
     * @param description the default description
     * @param material    the material used in chest UIs
     */
    public EnvFlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material) {
        this(id, displayName, description, material, List.of());
    }

    /** {@inheritDoc} */
    @Override
    protected @NotNull String getLanguageNamespace() {
        return "environment";
    }
}
