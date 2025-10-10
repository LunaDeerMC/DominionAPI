package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a privilege flag in the Dominion system.
 * This class extends the Flag class and provides specific
 * configuration keys for privilege-related flags.
 */
public class PriFlag extends Flag {

    /**
     * Constructs a new PriFlag with the specified parameters.
     *
     * @param flag_name     the name of the flag
     * @param display_name  the display name of the flag
     * @param description   the description of the flag
     * @param default_value the default value of the flag
     * @param enable        the enable status of the flag
     * @param material      the material of flag in CUI
     */
    public PriFlag(@NotNull String flag_name, @NotNull String display_name, @NotNull String description, @NotNull Boolean default_value, @NotNull Boolean enable, @NotNull Material material) {
        super(flag_name, display_name, description, default_value, enable, material);
    }

    /**
     * Returns the configuration description key for this privilege flag.
     *
     * @return the configuration description key
     */
    @Override
    public String getConfigurationDescKey() {
        return "privilege." + getFlagName() + ".description";
    }

    /**
     * Returns the configuration default key for this privilege flag.
     *
     * @return the configuration default key
     */
    @Override
    public String getConfigurationDefaultKey() {
        return "privilege." + getFlagName() + ".default";
    }

    /**
     * Returns the configuration enable key for this privilege flag.
     *
     * @return the configuration enable key
     */
    @Override
    public String getConfigurationEnableKey() {
        return "privilege." + getFlagName() + ".enable";
    }

    @Override
    public String getConfigurationNameKey() {
        return "privilege." + getFlagName();
    }

    @Override
    public String getConfigurationMaterialKey() {
        return "privilege." + getFlagName() + ".material";
    }

}