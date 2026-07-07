package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public record PrivilegeFlagDefinition(
        @NotNull String id,
        @NotNull String displayName,
        @NotNull String description,
        boolean defaultValue,
        boolean enabled,
        @NotNull Material material
) implements FlagDefinition {
    @Override
    public @NotNull FlagDomain domain() {
        return FlagDomain.PRIVILEGE;
    }
}
