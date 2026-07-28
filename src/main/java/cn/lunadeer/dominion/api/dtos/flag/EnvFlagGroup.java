package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/** A type-safe group of environment flags. */
public final class EnvFlagGroup extends FlagGroup<EnvFlag> {
    public EnvFlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material,
                        @NotNull Collection<? extends EnvFlag> flags) {
        super(id, displayName, description, material, EnvFlag.class, flags);
    }

    public EnvFlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material) {
        this(id, displayName, description, material, List.of());
    }

    @Override
    protected @NotNull String getLanguageNamespace() {
        return "environment";
    }
}
