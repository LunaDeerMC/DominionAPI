package cn.lunadeer.dominion.api.dtos;

import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Public view of a permission group belonging to a dominion.
 * <p>
 * A group's name may contain Dominion color syntax. Its privilege values are
 * evaluated for members assigned to the group.
 */
public interface GroupDTO {
    /**
     * Gets the ID of the group.
     *
     * @return the ID of the group
     */
    @NotNull Integer getId();

    /**
     * Gets the ID of the dominion to which the group belongs.
     *
     * @return the ID of the dominion
     */
    @NotNull Integer getDomID();

    /**
     * Sets the name of the group. The name may include Dominion color codes.
     *
     * @param name the name of the group
     * @return this group after the name has been updated
     * @throws SQLException if a database access error occurs
     */
    @NotNull GroupDTO setName(@NotNull String name) throws SQLException;

    /**
     * Gets the name of the group in plain text (without color codes).
     * This method should be used in most cases to get the group name.
     *
     * @return the plain text name of the group
     */
    @NotNull String getNamePlain();

    /**
     * Gets the raw name of the group, including Dominion color codes.
     *
     * @return the raw name of the group
     */
    @NotNull String getNameRaw();

    /**
     * Gets the formatted group title as an Adventure {@link Component}.
     *
     * @return the formatted group title
     */
    @NotNull Component getNameColoredComponent();

    /**
     * Gets the formatted group title as a Bukkit legacy color-code string.
     *
     * @return the formatted group title
     */
    @NotNull String getNameColoredBukkit();

    /**
     * Gets the value of a specific flag for the group.
     *
     * @param flag the flag
     * @return the value of the flag, or the default value if the flag does not exist
     */
    @NotNull Boolean getFlagValue(@NotNull PriFlag flag);

    /**
     * Gets all flag values for the group.
     *
     * @return a map of flag values
     */
    @NotNull Map<PriFlag, Boolean> getFlagsValue();

    /**
     * Sets the value of a specific privilege flag for the group.
     *
     * @param flag  the flag
     * @param value the value of the flag
     * @return this group after the flag has been updated
     * @throws SQLException if a database access error occurs
     */
    @NotNull GroupDTO setFlagValue(@NotNull PriFlag flag, @NotNull Boolean value) throws SQLException;

    /**
     * Gets all members of the group.
     *
     * @return a list of members
     * @throws SQLException if a database access error occurs
     */
    List<MemberDTO> getMembers() throws SQLException;
}
