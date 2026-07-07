package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public interface FlagDefinition {
    @NotNull String id();

    @NotNull FlagDomain domain();

    @NotNull String displayName();

    @NotNull String description();

    boolean defaultValue();

    boolean enabled();

    @NotNull Material material();
}
