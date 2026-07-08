package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class EnvironmentFlagDefinition implements FlagDefinition {
    private final @NotNull String id;
    private @NotNull String displayName;
    private @NotNull String description;
    private boolean defaultValue;
    private boolean enabled;
    private @NotNull Material material;

    public EnvironmentFlagDefinition(
            @NotNull String id,
            @NotNull String displayName,
            @NotNull String description,
            boolean defaultValue,
            boolean enabled,
            @NotNull Material material
    ) {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
        this.defaultValue = defaultValue;
        this.enabled = enabled;
        this.material = material;
    }

    @Override
    public @NotNull String id() {
        return id;
    }

    @Override
    public @NotNull FlagDomain domain() {
        return FlagDomain.ENVIRONMENT;
    }

    @Override
    public @NotNull String displayName() {
        return displayName;
    }

    public void setDisplayName(@NotNull String displayName) {
        this.displayName = displayName;
    }

    @Override
    public @NotNull String description() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    @Override
    public boolean defaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean enabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public @NotNull Material material() {
        return material;
    }

    public void setMaterial(@NotNull Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "EnvironmentFlagDefinition{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", defaultValue=" + defaultValue +
                ", enabled=" + enabled +
                ", material=" + material +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof EnvironmentFlagDefinition that)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
