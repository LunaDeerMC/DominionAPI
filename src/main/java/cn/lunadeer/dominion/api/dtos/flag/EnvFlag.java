package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a legacy environment flag in the Dominion system.
 * This class extends the Flag class and provides specific
 * configuration keys for environment-related flags.
 *
 * @deprecated use environment {@link FlagDefinition}s from {@link FlagDefinitions}.
 */
@Deprecated
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
     * Returns the configuration description key for this environment flag.
     *
     * @return the configuration description key
     */
    @Override
    public String getConfigurationDescKey() {
        return "environment." + getFlagName() + ".description";
    }

    /**
     * Returns the configuration default key for this environment flag.
     *
     * @return the configuration default key
     */
    @Override
    public String getConfigurationDefaultKey() {
        return "environment." + getFlagName() + ".default";
    }

    /**
     * Returns the configuration enable key for this environment flag.
     *
     * @return the configuration enable key
     */
    @Override
    public String getConfigurationEnableKey() {
        return "environment." + getFlagName() + ".enable";
    }

    @Override
    public String getConfigurationNameKey() {
        return "environment." + getFlagName();
    }

    @Override
    public String getConfigurationMaterialKey() {
        return "environment." + getFlagName() + ".material";
    }

}
