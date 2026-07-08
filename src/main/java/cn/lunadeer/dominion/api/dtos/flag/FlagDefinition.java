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

    default @NotNull String configurationNameKey() {
        return switch (domain()) {
            case ENVIRONMENT -> "environment." + id();
            case PRIVILEGE -> "privilege." + id();
        };
    }

    default @NotNull String configurationDefaultKey() {
        return configurationNameKey() + ".default";
    }

    default @NotNull String configurationEnableKey() {
        return configurationNameKey() + ".enable";
    }

    default @NotNull String configurationMaterialKey() {
        return configurationNameKey() + ".material";
    }

    default @NotNull String displayNameKey() {
        return "flags." + id() + ".display-name";
    }

    default @NotNull String descriptionKey() {
        return "flags." + id() + ".description";
    }
}
