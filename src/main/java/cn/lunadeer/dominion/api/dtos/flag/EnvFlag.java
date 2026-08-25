package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A flag controlling environmental behavior inside a dominion.
 * <p>
 * Environment flags use the {@code environment.<flag>} configuration
 * namespace.
 */
public class EnvFlag extends Flag {

    /**
     * Constructs a new EnvFlag with the specified parameters.
     *
     * @param flag_name     the name of the flag
     * @param display_name  the display name of the flag
     * @param description   the description of the flag
     * @param default_value the default value of the flag
     * @param enable        the enable status of the flag
     * @param material      the material of flag in CUI
     */
    public EnvFlag(@NotNull String flag_name, @NotNull String display_name, @NotNull String description, @NotNull Boolean default_value, @NotNull Boolean enable, @NotNull Material material) {
        super(flag_name, display_name, description, default_value, enable, material);
    }

    /**
     * Constructs an environment flag with an optional native Dialog UI icon.
     *
     * @param flag_name     the stable flag name
     * @param display_name  the default display name
     * @param description   the default description
     * @param default_value the default value
     * @param enable        whether the flag is enabled
     * @param material      the material used in chest UIs
     * @param icon          the Dialog UI sprite path, or {@code null} for no icon
     */
    public EnvFlag(@NotNull String flag_name, @NotNull String display_name, @NotNull String description,
                   @NotNull Boolean default_value, @NotNull Boolean enable, @NotNull Material material,
                   @Nullable String icon) {
        super(flag_name, display_name, description, default_value, enable, material, icon);
    }

    /**
     * Returns the configuration description key for this environment flag.
     *
     * @return the configuration description key
     */
    /** {@inheritDoc} */
    @Override
    public String getConfigurationDescKey() {
        return "environment." + getFlagName() + ".description";
    }

    /**
     * Returns the configuration default key for this environment flag.
     *
     * @return the configuration default key
     */
    /** {@inheritDoc} */
    @Override
    public String getConfigurationDefaultKey() {
        return "environment." + getFlagName() + ".default";
    }

    /**
     * Returns the configuration enable key for this environment flag.
     *
     * @return the configuration enable key
     */
    /** {@inheritDoc} */
    @Override
    public String getConfigurationEnableKey() {
        return "environment." + getFlagName() + ".enable";
    }

    /** {@inheritDoc} */
    @Override
    public String getConfigurationNameKey() {
        return "environment." + getFlagName();
    }

    /** {@inheritDoc} */
    @Override
    public String getConfigurationMaterialKey() {
        return "environment." + getFlagName() + ".material";
    }

}
