package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Represents a flag in the Dominion system.
 * This abstract class provides the basic structure and methods
 * for flags, including their name, display name, description,
 * default value, and enable status.
 */
public abstract class Flag {
    private final String flag_name;
    private String display_name;
    private String description;
    private Boolean default_value;
    private Boolean enable;
    private Material material;
    private String icon;

    /**
     * Constructs a new Flag with the specified parameters.
     *
     * @param flag_name     the name of the flag
     * @param display_name  the display name of the flag
     * @param description   the description of the flag
     * @param default_value the default value of the flag
     * @param enable        the enable status of the flag
     */
    public Flag(@NotNull String flag_name, @NotNull String display_name, @NotNull String description, @NotNull Boolean default_value, @NotNull Boolean enable, @NotNull Material material) {
        this(flag_name, display_name, description, default_value, enable, material, null);
    }

    /**
     * Constructs a Flag with an explicit native Dialog UI sprite path.
     *
     * @param icon resource path in {@code namespace:atlas/sprite} form; null or blank means no icon
     */
    public Flag(@NotNull String flag_name, @NotNull String display_name, @NotNull String description,
                @NotNull Boolean default_value, @NotNull Boolean enable, @NotNull Material material,
                @Nullable String icon) {
        this.flag_name = flag_name;
        this.display_name = display_name;
        this.description = description;
        this.default_value = default_value;
        this.enable = enable;
        this.material = Objects.requireNonNull(material, "material");
        this.icon = normalizeIcon(icon);
    }

    /**
     * Returns the name of the flag.
     *
     * @return the name of the flag
     */
    public @NotNull String getFlagName() {
        return flag_name;
    }

    /**
     * Returns the display name of the flag.
     * This is the name that will be displayed to the user.
     * Can be translated in language files.
     *
     * @return the display name of the flag
     */
    public @NotNull String getDisplayName() {
        return display_name;
    }

    /**
     * Returns the description of the flag.
     * Can be translated in language files.
     *
     * @return the description of the flag
     */
    public @NotNull String getDescription() {
        return description;
    }

    /**
     * Returns the default value of the flag.
     *
     * @return the default value of the flag
     */
    public @NotNull Boolean getDefaultValue() {
        return default_value;
    }

    /**
     * Returns the enable status of the flag.
     *
     * @return the enable status of the flag
     */
    public @NotNull Boolean getEnable() {
        return enable;
    }


    /**
     * Returns the material used by this flag in chest user interfaces.
     *
     * @return the material used by this flag
     */
    public @NotNull Material getMaterial() {
        return material;
    }

    /**
     * Returns the native Dialog UI sprite path for this flag.
     *
     * @return resource path in {@code namespace:atlas/sprite} form
     */
    public @Nullable String getIcon() {
        return icon;
    }

    /**
     * Sets the display name of the flag.
     *
     * @param displayName the new display name of the flag
     */
    public void setDisplayName(String displayName) {
        this.display_name = displayName;
    }

    /**
     * Sets the description of the flag.
     *
     * @param description the new description of the flag
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the default value of the flag.
     *
     * @param defaultValue the new default value of the flag
     */
    public void setDefaultValue(Boolean defaultValue) {
        this.default_value = defaultValue;
    }

    /**
     * Sets the enable status of the flag.
     *
     * @param enable the new enable status of the flag
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * Sets the material used by this flag in chest user interfaces.
     *
     * @param material the new material used by this flag
     */
    public void setMaterial(String material) {
        Material matched = Material.matchMaterial(material);
        if (matched != null) {
            this.material = matched;
        }
    }

    /**
     * Sets the native Dialog UI sprite path. Null or blank means no icon.
     *
     * @param icon resource path in {@code namespace:atlas/sprite} form
     */
    public void setIcon(@Nullable String icon) {
        this.icon = normalizeIcon(icon);
    }

    private static @Nullable String normalizeIcon(@Nullable String icon) {
        return icon == null || icon.isBlank() ? null : icon.trim();
    }

    /**
     * Returns the configuration key for the display name of the flag.
     *
     * @return the configuration key for the display name
     */
    public String getDisplayNameKey() {
        return "flags." + flag_name + ".display-name";
    }

    /**
     * Returns the configuration key for the description of the flag.
     *
     * @return the configuration key for the description
     */
    public String getDescriptionKey() {
        return "flags." + flag_name + ".description";
    }

    /**
     * Returns the configuration key for the description of this flag.
     *
     * @return the configuration key for the description
     */
    public abstract String getConfigurationDescKey();

    /**
     * Returns the configuration key for the default value of this flag.
     *
     * @return the configuration key for the default value
     */
    public abstract String getConfigurationDefaultKey();

    /**
     * Returns the configuration key for the enable status of this flag.
     *
     * @return the configuration key for the enable status
     */
    public abstract String getConfigurationEnableKey();

    /**
     * Returns the configuration key for the name of this flag.
     *
     * @return the configuration key for the name
     */
    public abstract String getConfigurationNameKey();

    /**
     * Returns the configuration key for the material of this flag.
     *
     * @return the configuration key for the material
     */
    public abstract String getConfigurationMaterialKey();

    /**
     * Returns the flags.yml key for this flag's Dialog UI icon.
     * This method is concrete so existing custom Flag subclasses remain valid.
     *
     * @return configuration key for the Dialog UI icon
     */
    public String getConfigurationDialogUiIconKey() {
        return getConfigurationNameKey() + ".dialog-ui-icon";
    }

}
