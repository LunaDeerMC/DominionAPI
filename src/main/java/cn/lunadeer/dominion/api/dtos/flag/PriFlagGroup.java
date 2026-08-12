package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

/** A type-safe group of privilege flags. */
public final class PriFlagGroup extends FlagGroup<PriFlag> {
    public PriFlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material,
                        @NotNull Collection<? extends PriFlag> flags) {
        super(id, displayName, description, material, PriFlag.class, flags);
    }

    public PriFlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material,
                        @Nullable String icon,
                        @NotNull Collection<? extends PriFlag> flags) {
        super(id, displayName, description, material, icon, PriFlag.class, flags);
    }

    public PriFlagGroup(@NotNull String id,
                        @NotNull String displayName,
                        @NotNull String description,
                        @NotNull Material material) {
        this(id, displayName, description, material, List.of());
    }

    @Override
    protected @NotNull String getLanguageNamespace() {
        return "privilege";
    }
}
