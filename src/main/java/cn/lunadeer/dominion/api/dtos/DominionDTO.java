package cn.lunadeer.dominion.api.dtos;

import cn.lunadeer.dominion.api.dtos.flag.EnvFlag;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Public view of a Dominion and its persisted settings.
 * <p>
 * Mutating methods update the Dominion data store and return this dominion
 * instance when the update succeeds. Database failures are reported through
 * {@link SQLException}.
 */
public interface DominionDTO {
    /**
     * Gets the ID of the dominion.
     *
     * @return the ID of the dominion
     */
    @NotNull Integer getId();

    /**
     * Gets the UUID of the dominion owner.
     *
     * @return the UUID of the dominion owner
     */
    @NotNull UUID getOwner();

    /**
     * Gets the DTO of the dominion owner.
     * <p>
     * Implementations may return {@link PlayerDTO#UNKNOWN} when the owner is
     * not present in the player cache.
     *
     * @return the DTO of the dominion owner
     */
    @NotNull PlayerDTO getOwnerDTO();

    /**
     * Sets the owner of the dominion.
     *
     * @param owner the UUID of the dominion owner
     * @return this dominion after the owner has been updated
     * @throws SQLException if a database access error occurs
     */
    @NotNull DominionDTO setOwner(UUID owner) throws SQLException;

    /**
     * Sets the owner of the dominion using a Bukkit player.
     *
     * @param owner the dominion owner
     * @return this dominion after the owner has been updated
     * @throws SQLException if a database access error occurs
     */
    @NotNull DominionDTO setOwner(Player owner) throws SQLException;

    /**
     * Gets the name of the dominion.
     *
     * @return the name of the dominion
     */
    @NotNull String getName();

    /**
     * Sets the name of the dominion.
     *
     * @param name the name of the dominion
     * @return this dominion after the name has been updated
     * @throws SQLException if a database access error occurs
     */
    @NotNull DominionDTO setName(String name) throws SQLException;

    /**
     * Gets the world where the dominion is located. Returns null if the world does not exist.
     *
     * @return the world where the dominion is located
     */
    @Nullable World getWorld();

    /**
     * Gets the UUID of the world where the dominion is located. This method guarantees a non-null UUID, but does not guarantee the existence of the world.
     * To check if the world exists, use {@link #getWorld()}.
     *
     * @return the UUID of the world where the dominion is located
     */
    @NotNull UUID getWorldUid();

    /**
     * Gets the cuboid of the dominion.
     * <p>
     * The cuboid uses the coordinate conventions documented by
     * {@link CuboidDTO}.
     *
     * @return the cuboid of the dominion
     */
    @NotNull CuboidDTO getCuboid();

    /**
     * Sets the cuboid of the dominion.
     *
     * @param cuboid the cuboid of the dominion
     * @return this dominion after the cuboid has been updated
     * @throws SQLException if a database access error occurs
     */
    @NotNull DominionDTO setCuboid(@NotNull CuboidDTO cuboid) throws SQLException;

    /**
     * Gets the ID of the parent dominion.
     *
     * @return the ID of the parent dominion, or -1 if there is no parent dominion
     */
    @NotNull Integer getParentDomId();

    /**
     * Gets the message sent when a player enters the dominion.
     *
     * @return the enter message
     */
    @NotNull String getJoinMessage();

    /**
     * Sets the message sent when a player enters the dominion.
     *
     * @param joinMessage the enter message
     * @return this dominion after the message has been updated
     * @throws SQLException if a database access error occurs
     */
    @NotNull DominionDTO setJoinMessage(String joinMessage) throws SQLException;

    /**
     * Gets the message sent when a player leaves the dominion.
     *
     * @return the leave message
     */
    @NotNull String getLeaveMessage();

    /**
     * Sets the message sent when a player leaves the dominion.
     *
     * @param leaveMessage the leave message
     * @return this dominion after the message has been updated
     * @throws SQLException if a database access error occurs
     */
    @NotNull DominionDTO setLeaveMessage(String leaveMessage) throws SQLException;

    /**
     * Gets the environment flag values configured for the dominion.
     *
     * @return a map from environment flags to their configured values
     */
    @NotNull Map<EnvFlag, Boolean> getEnvironmentFlagValue();

    /**
     * Gets the value of a specific environment flag of the dominion.
     *
     * @param flag the environment flag
     * @return the value of the environment flag
     */
    boolean getEnvFlagValue(@NotNull EnvFlag flag);

    /**
     * Gets the privilege flag values applied to guests of the dominion.
     *
     * @return a map from privilege flags to their configured guest values
     */
    @NotNull Map<PriFlag, Boolean> getGuestPrivilegeFlagValue();

    /**
     * Gets the value of a specific guest privilege flag of the dominion.
     *
     * @param flag the guest privilege flag
     * @return the value of the guest privilege flag
     */
    boolean getGuestFlagValue(@NotNull PriFlag flag);

    /**
     * Sets the value of an environment flag for the dominion.
     *
     * @param flag  the flag
     * @param value the value of the flag
     * @return this dominion after the flag has been updated
     * @throws SQLException if a database access error occurs
     */
    @NotNull DominionDTO setEnvFlagValue(@NotNull EnvFlag flag, @NotNull Boolean value) throws SQLException;

    /**
     * Sets the value of a guest privilege flag for the dominion.
     *
     * @param flag  the flag
     * @param value the value of the flag
     * @return this dominion after the flag has been updated
     * @throws SQLException if a database access error occurs
     */
    @NotNull DominionDTO setGuestFlagValue(@NotNull PriFlag flag, @NotNull Boolean value) throws SQLException;

    /**
     * Gets the teleport location of the dominion.
     * <p>
     * If no custom location is configured, the center location of the cuboid
     * is returned.
     *
     * @return the teleport location of the dominion
     */
    @NotNull Location getTpLocation();

    /**
     * Sets the teleport location of the dominion.
     *
     * @param tpLocation the teleport location of the dominion
     * @return this dominion after the teleport location has been updated
     * @throws SQLException if a database access error occurs
     */
    @NotNull DominionDTO setTpLocation(Location tpLocation) throws SQLException;

    /**
     * Gets the red component of the dominion's color.
     *
     * @return the red component of the dominion's color
     */
    int getColorR();

    /**
     * Gets the green component of the dominion's color.
     *
     * @return the green component of the dominion's color
     */
    int getColorG();

    /**
     * Gets the blue component of the dominion's color.
     *
     * @return the blue component of the dominion's color
     */
    int getColorB();

    /**
     * Gets the color of the dominion as a hexadecimal string.
     *
     * @return a color in {@code #RRGGBB} form
     */
    @NotNull String getColor();

    /**
     * Gets the hexadecimal representation of the dominion's color.
     *
     * @return the RGB value in the range {@code 0x000000} to {@code 0xFFFFFF}
     */
    int getColorHex();

    /**
     * Sets the map color of the dominion.
     *
     * @param color the color
     * @return this dominion after the color has been updated
     * @throws SQLException if a database access error occurs
     */
    @NotNull DominionDTO setColor(@NotNull Color color) throws SQLException;

    /**
     * Gets all groups belonging to the dominion.
     *
     * @return the list of groups
     */
    List<GroupDTO> getGroups();

    /**
     * Gets all members belonging to the dominion.
     *
     * @return the list of members
     */
    List<MemberDTO> getMembers();

    /**
     * Gets the server ID associated with the dominion.
     *
     * @return the server ID associated with the dominion
     */
    Integer getServerId();

}
