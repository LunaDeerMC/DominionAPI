package cn.lunadeer.dominion.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility methods for converting Dominion hex color syntax.
 * <p>
 * Hex colors use the form {@code &#RRGGBB}; the Bukkit conversion method also
 * emits the legacy {@code &x&r&r&g&g&b&b} representation.
 */
public class ColorParser {

    /**
     * Converts a string with color codes into a TextComponent.
     *
     * @param text the string with color codes
     * @return the TextComponent with the parsed colors
     */
    public static TextComponent getComponentType(String text) {
        String[] parts = text.split("&#");
        List<TextComponent> components = new ArrayList<>();
        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }
            TextColor color = TextColor.fromHexString("#ffffff");
            String content;
            if (part.length() >= 6 && part.substring(0, 6).matches("^[0-9a-fA-F]{6}$")) {
                String color_str = part.substring(0, 6);
                color = TextColor.fromHexString("#" + color_str);
                content = part.substring(6);
            } else {
                content = part;
            }
            components.add(Component.text(content, color));
        }
        TextComponent.Builder title_component = Component.text();
        for (TextComponent component : components) {
            title_component.append(component);
        }
        return title_component.build();
    }

    /**
     * Converts a string with color codes into a Bukkit-compatible color string.
     *
     * @param text the string with color codes
     * @return the Bukkit-compatible color string
     */
    public static String getBukkitType(String text) {
        String title = "&f" + text + "&f";
        title = title.replaceAll("&#", "#");
        Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
        Matcher matcher = pattern.matcher(title);
        while (matcher.find()) {
            String hexCode = matcher.group();
            StringBuilder builder = new StringBuilder("&x");
            for (char c : hexCode.substring(1).toCharArray()) {
                builder.append('&').append(c);
            }
            title = title.replace(hexCode, builder.toString());
        }
        return ChatColor.translateAlternateColorCodes('&', title);
    }

    /**
     * Removes color codes from a string, returning plain text.
     *
     * @param text the string with color codes
     * @return the plain text string
     */
    public static String getPlainText(String text) {
        String[] parts = text.split("&#");
        StringBuilder res = new StringBuilder();
        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }
            String content;
            if (part.length() >= 6 && part.substring(0, 6).matches("^[0-9a-fA-F]{6}$")) {
                content = part.substring(6);
            } else {
                content = part;
            }
            res.append(content);
        }
        return res.toString();
    }

}
