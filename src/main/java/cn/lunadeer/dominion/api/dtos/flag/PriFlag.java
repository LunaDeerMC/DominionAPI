package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A flag controlling an action that players may perform in a dominion.
 * <p>
 * Privilege flags use the {@code privilege.<flag>} configuration namespace.
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
     * Constructs a privilege flag with an optional native Dialog UI icon.
     *
     * @param flag_name     the stable flag name
     * @param display_name  the default display name
     * @param description   the default description
     * @param default_value the default value
     * @param enable        whether the flag is enabled
     * @param material      the material used in chest UIs
     * @param icon          the Dialog UI sprite path, or {@code null} for no icon
     */
    public PriFlag(@NotNull String flag_name, @NotNull String display_name, @NotNull String description,
                   @NotNull Boolean default_value, @NotNull Boolean enable, @NotNull Material material,
                   @Nullable String icon) {
        super(flag_name, display_name, description, default_value, enable, material, icon);
    }

    /**
     * Returns the configuration description key for this privilege flag.
     *
     * @return the configuration description key
     */
    /** {@inheritDoc} */
    @Override
    public String getConfigurationDescKey() {
        return "privilege." + getFlagName() + ".description";
    }

    /**
     * Returns the configuration default key for this privilege flag.
     *
     * @return the configuration default key
     */
    /** {@inheritDoc} */
    @Override
    public String getConfigurationDefaultKey() {
        return "privilege." + getFlagName() + ".default";
    }

    /**
     * Returns the configuration enable key for this privilege flag.
     *
     * @return the configuration enable key
     */
    /** {@inheritDoc} */
    @Override
    public String getConfigurationEnableKey() {
        return "privilege." + getFlagName() + ".enable";
    }

    /** {@inheritDoc} */
    @Override
    public String getConfigurationNameKey() {
        return "privilege." + getFlagName();
    }

    /** {@inheritDoc} */
    @Override
    public String getConfigurationMaterialKey() {
        return "privilege." + getFlagName() + ".material";
    }

}
