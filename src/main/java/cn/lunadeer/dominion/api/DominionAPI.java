package cn.lunadeer.dominion.api;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import cn.lunadeer.dominion.api.dtos.flag.EnvFlag;
import cn.lunadeer.dominion.api.dtos.flag.EnvironmentFlagDefinition;
import cn.lunadeer.dominion.api.dtos.flag.PrivilegeFlagDefinition;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import cn.lunadeer.dominion.providers.DominionProvider;
import cn.lunadeer.dominion.providers.GroupProvider;
import cn.lunadeer.dominion.providers.MemberProvider;
import cn.lunadeer.dominion.utils.McaRecord;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * Interface representing the Dominion API.
 * <p>
 * This interface provides methods to interact with the Dominion plugin.
 * <p>
 * Use the {@link #getInstance()} method to retrieve the singleton instance of the DominionAPI.
 */
public abstract class DominionAPI {

    protected static DominionAPI instance;

    /**
     * Retrieves the singleton instance of the DominionAPI.
     * This method checks if the Dominion plugin is enabled and if the version is compatible.
     * If these checks pass, it retrieves the instance of the DominionAPI from the DominionInterface class.
     *
     * @return the singleton instance of the DominionAPI
     */
    public static DominionAPI getInstance() {
        return instance;
    }

    /**
     * Retrieves a PlayerDTO by the player's name.
     *
     * @param name the name of the player
     * @return the PlayerDTO associated with the given name, or null if not found
     */
    public abstract @Nullable PlayerDTO getPlayer(String name);

    /**
     * Retrieves a PlayerDTO by the player's UUID.
     *
     * @param player the UUID of the player
     * @return the PlayerDTO associated with the given UUID, or null if not found
     */
    public abstract @Nullable PlayerDTO getPlayer(@NotNull UUID player);

    /**
     * Retrieves the name of a player by their UUID.
     *
     * @param uuid the UUID of the player
     * @return the name of the player associated with the given UUID
     */
    public abstract @NotNull String getPlayerName(@NotNull UUID uuid);

    /**
     * Retrieves all DominionDTO objects.
     * <p>
     * This method retrieves all dominions from the cache of this server. If multi-servers mode is enabled,
     * it also retrieves dominions from the caches of other servers.
     *
     * @return a list of all DominionDTO objects
     */
    public abstract List<DominionDTO> getAllDominions();

    /**
     * Retrieves all DominionDTO objects owned by a specific player.
     * <p>
     * This method retrieves the dominions owned by the specified player from the cache of this server.
     *
     * @param player the UUID of the player
     * @return a list of DominionDTO objects owned by the specified player
     */
    public abstract List<DominionDTO> getAllDominionsOfPlayer(@NotNull UUID player);

    /**
     * Retrieves the child dominions of a given parent dominion.
     * <p>
     * This method retrieves the child dominions of the specified parent dominion from the cache of this server.
     * If multi-servers mode is enabled, it also retrieves child dominions from the caches of other servers.
     *
     * @param parent the parent DominionDTO whose children are to be retrieved
     * @return a list of child DominionDTO objects
     */
    public abstract List<DominionDTO> getChildrenDominionOf(DominionDTO parent);

    /**
     * Retrieves a DominionDTO by its ID.
     * <p>
     * This method will first attempt to retrieve the DominionDTO from the cache of this server. If the DominionDTO
     * is not found, it will then attempt to retrieve the DominionDTO from the caches of other servers.
     *
     * @param id the ID of the dominion to retrieve
     * @return the DominionDTO associated with the given ID
     */
    public abstract @Nullable DominionDTO getDominion(Integer id);

    /**
     * Retrieves a DominionDTO by its name.
     * <p>
     * This method will first attempt to retrieve the DominionDTO from the cache of this server. If the DominionDTO
     * is not found, it will then attempt to retrieve the DominionDTO from the caches of other servers.
     *
     * @param name the name of the dominion to retrieve
     * @return the DominionDTO associated with the given name
     */
    public abstract @Nullable DominionDTO getDominion(String name);

    /**
     * Retrieves a DominionDTO by its location.
     * <p>
     * This method retrieves the DominionDTO associated with the given location from the cache of this server.
     *
     * @param location the location to retrieve the dominion for
     * @return the DominionDTO associated with the given location, or null if not found
     */
    public abstract @Nullable DominionDTO getDominion(Location location);

    /**
     * Retrieves the dominions owned by a player.
     * <p>
     * This method retrieves the dominions owned by the player from the cache of this server. If multi-servers mode is enabled,
     * it also retrieves the dominions owned by the player from the caches of other servers.
     *
     * @param player the UUID of the player
     * @return a list of DominionDTO objects representing the dominions owned by the player
     */
    public abstract List<DominionDTO> getPlayerOwnDominionDTOs(UUID player);

    /**
     * Retrieves the dominions where a player is an admin.
     * <p>
     * This method retrieves the dominions where the player is an admin from the cache of this server. If multi-servers mode is enabled,
     * it also retrieves the dominions where the player is an admin from the caches of other servers.
     *
     * @param player the UUID of the player
     * @return a list of DominionDTO objects representing the dominions where the player is an admin
     */
    public abstract List<DominionDTO> getPlayerAdminDominionDTOs(UUID player);

    /**
     * Retrieves a MemberDTO by the player's UUID.
     * <p>
     * This method retrieves the MemberDTO associated with the given player from the specified dominion.
     *
     * @param dominion the DominionDTO to retrieve the member from
     * @param player   the Player object representing the player
     * @return the MemberDTO associated with the given player, or null if not found
     */
    public abstract @Nullable MemberDTO getMember(@Nullable DominionDTO dominion, @NotNull Player player);

    /**
     * Retrieves a MemberDTO by the player's UUID.
     * <p>
     * This method retrieves the MemberDTO associated with the given player from the specified dominion. If the member is not found
     * in the cache of this server, it will attempt to retrieve the member from the caches of other servers if multi-servers mode is enabled.
     *
     * @param dominion the DominionDTO to retrieve the member from
     * @param player   the UUID of the player
     * @return the MemberDTO associated with the given player, or null if not found
     */
    public abstract @Nullable MemberDTO getMember(@Nullable DominionDTO dominion, @NotNull UUID player);

    /**
     * Retrieves a GroupDTO by the member's group ID.
     * <p>
     * This method retrieves the GroupDTO associated with the group ID of the given member.
     *
     * @param member the MemberDTO whose group ID is to be used for retrieval
     * @return the GroupDTO associated with the given member's group ID, or null if not found
     */
    public abstract @Nullable GroupDTO getGroup(MemberDTO member);

    /**
     * Retrieves a GroupDTO by its ID.
     * <p>
     * This method retrieves the GroupDTO associated with the given ID from the cache of this server. If the GroupDTO
     * is not found, it will then attempt to retrieve the GroupDTO from the caches of other servers if multi-servers mode is enabled.
     *
     * @param id the ID of the group to retrieve
     * @return the GroupDTO associated with the given ID, or null if not found
     */
    public abstract @Nullable GroupDTO getGroup(Integer id);

    /**
     * Retrieves the current dominion of a player.
     * <p>
     * This method retrieves the current dominion of the player based on their location. It checks if the player is still
     * in the same dominion and if the dominion has no children. If the player has moved to a different dominion, it triggers
     * the appropriate events and updates the player's current dominion ID.
     *
     * @param player the Player object representing the player
     * @return the DominionDTO associated with the player's current location, or null if not found
     */
    public abstract @Nullable DominionDTO getPlayerCurrentDominion(@NotNull Player player);

    /**
     * Resets the current dominion ID for a player.
     * <p>
     * This method removes the current dominion ID associated with the player from the cache.
     *
     * @param player the Player object representing the player
     */
    public abstract void resetPlayerCurrentDominionId(@NotNull Player player);

    /**
     * Retrieves the total count of dominions.
     * <p>
     * This method calculates the total number of dominions by summing the count of dominions on this server and, if
     * multi-servers mode is enabled, the counts from other servers.
     *
     * @return the total count of dominions
     */
    public abstract Integer dominionCount();

    /**
     * Retrieves the total count of groups.
     * <p>
     * This method calculates the total number of groups by summing the count of groups on this server and, if
     * multi-servers mode is enabled, the counts from other servers.
     *
     * @return the total count of groups
     */
    public abstract Integer groupCount();

    /**
     * Retrieves the total count of members.
     * <p>
     * This method calculates the total number of members by summing the count of members on this server and, if
     * multi-servers mode is enabled, the counts from other servers.
     *
     * @return the total count of members
     */
    public abstract Integer memberCount();

    /**
     * Checks if a player has a specific privilege flag at the given location.
     * <p>
     * This method verifies whether the player has permission for the specified privilege flag
     * at the given location, considering the dominion (if any) that covers the location.
     * If the player lacks the required privilege, appropriate messages or events may be triggered.
     *
     * @param location the location to check the privilege flag at
     * @param flag     the privilege flag to check
     * @param player   the player whose privileges are being checked
     * @return true if the player has the privilege flag at the location, false otherwise
     * @deprecated use {@link #checkPrivilegeFlag(Location, PrivilegeFlagDefinition, Player)} with {@code FlagDefinitions.X}.
     */
    @Deprecated
    public abstract boolean checkPrivilegeFlag(@NotNull Location location, @NotNull PriFlag flag, @NotNull Player player);

    /**
     * Checks if a player has a specific privilege flag at the given location.
     *
     * @param location the location to check the privilege flag at
     * @param flag     the new flag definition, usually from {@code FlagDefinitions.X}
     * @param player   the player whose privileges are being checked
     * @return true if the player has the privilege flag at the location, false otherwise
     */
    public abstract boolean checkPrivilegeFlag(@NotNull Location location, @NotNull PrivilegeFlagDefinition flag, @NotNull Player player);

    /**
     * Checks if a player has a specific privilege flag for the given dominion.
     * <p>
     * This method verifies whether the player has permission for the specified privilege flag
     * within the provided dominion. If the dominion is null, the check may be performed in a global or default context.
     * <p>
     * You should use {@link #checkPrivilegeFlag(Location, PrivilegeFlagDefinition, Player)} instead,
     * because this method does not check the
     * <a href="https://dominion.lunadeer.cn/notes/doc/owner/config-ref/world-wide/">world-wide privilege</a> flag,
     * which is not recommended to use.
     * <p>
     *
     * @param dom    the DominionDTO to check the privilege flag in, or null if not applicable
     * @param flag   the privilege flag to check
     * @param player the player whose privileges are being checked
     * @return true if the player has the privilege flag in the dominion, false otherwise
     * @deprecated use {@link #checkPrivilegeFlag(DominionDTO, PrivilegeFlagDefinition, Player)} with {@code FlagDefinitions.X}.
     */
    @Deprecated
    public abstract boolean checkPrivilegeFlag(@Nullable DominionDTO dom, @NotNull PriFlag flag, @NotNull Player player);

    /**
     * Checks if a player has a specific privilege flag for the given dominion.
     *
     * @param dom    the DominionDTO to check the privilege flag in, or null if not applicable
     * @param flag   the new flag definition, usually from {@code FlagDefinitions.X}
     * @param player the player whose privileges are being checked
     * @return true if the player has the privilege flag in the dominion, false otherwise
     */
    public abstract boolean checkPrivilegeFlag(@Nullable DominionDTO dom, @NotNull PrivilegeFlagDefinition flag, @NotNull Player player);

    /**
     * Checks if a player has a specific privilege flag at the given location without triggering messages or events.
     * <p>
     * This method performs the same privilege check as {@link #checkPrivilegeFlag(Location, PriFlag, Player)}
     * but operates silently, without sending any messages to the player or triggering related events.
     * This is useful for internal checks where user feedback is not desired.
     *
     * @param location the location to check the privilege flag at
     * @param flag     the privilege flag to check
     * @param player   the player whose privileges are being checked
     * @return true if the player has the privilege flag at the location, false otherwise
     * @deprecated use {@link #checkPrivilegeFlagSilence(Location, PrivilegeFlagDefinition, Player)} with {@code FlagDefinitions.X}.
     */
    @Deprecated
    public abstract boolean checkPrivilegeFlagSilence(@NotNull Location location, @NotNull PriFlag flag, @NotNull Player player);

    /**
     * Checks if a player has a specific privilege flag at the given location without triggering messages or events.
     *
     * @param location the location to check the privilege flag at
     * @param flag     the new flag definition, usually from {@code FlagDefinitions.X}
     * @param player   the player whose privileges are being checked
     * @return true if the player has the privilege flag at the location, false otherwise
     */
    public abstract boolean checkPrivilegeFlagSilence(@NotNull Location location, @NotNull PrivilegeFlagDefinition flag, @NotNull Player player);

    /**
     * Checks if a player has a specific privilege flag for the given dominion without triggering messages or events.
     * <p>
     * This method performs a silent privilege check for the specified dominion, privilege flag, and player.
     * No messages are sent and no events are triggered, making it suitable for internal permission checks.
     * <p>
     * You should use {@link #checkPrivilegeFlagSilence(Location, PrivilegeFlagDefinition, Player)} instead,
     * because this method does not check the
     * <a href="https://dominion.lunadeer.cn/notes/doc/owner/config-ref/world-wide/">world-wide privilege</a> flag,
     * which is not recommended to use.
     * <p>
     *
     * @param dom    the DominionDTO to check the privilege flag in, or null if not applicable
     * @param flag   the privilege flag to check
     * @param player the player whose privileges are being checked
     * @return true if the player has the privilege flag in the dominion, false otherwise
     * @deprecated use {@link #checkPrivilegeFlagSilence(DominionDTO, PrivilegeFlagDefinition, Player)} with {@code FlagDefinitions.X}.
     */
    @Deprecated
    public abstract boolean checkPrivilegeFlagSilence(@Nullable DominionDTO dom, @NotNull PriFlag flag, @NotNull Player player);

    /**
     * Checks if a player has a specific privilege flag for the given dominion without triggering messages or events.
     *
     * @param dom    the DominionDTO to check the privilege flag in, or null if not applicable
     * @param flag   the new flag definition, usually from {@code FlagDefinitions.X}
     * @param player the player whose privileges are being checked
     * @return true if the player has the privilege flag in the dominion, false otherwise
     */
    public abstract boolean checkPrivilegeFlagSilence(@Nullable DominionDTO dom, @NotNull PrivilegeFlagDefinition flag, @NotNull Player player);

    /**
     * Checks if the specified environment flag is set at the given location.
     * <p>
     * This method determines whether the provided environment flag is enabled at the specified location,
     * considering the dominion (if any) that covers the location.
     *
     * @param location the location to check for the environment flag
     * @param flag     the environment flag to check
     * @return true if the environment flag is set at the location, false otherwise
     * @deprecated use {@link #checkEnvironmentFlag(Location, EnvironmentFlagDefinition)} with {@code FlagDefinitions.X}.
     */
    @Deprecated
    public abstract boolean checkEnvironmentFlag(@NotNull Location location, @NotNull EnvFlag flag);

    /**
     * Checks if the specified environment flag is set at the given location.
     *
     * @param location the location to check for the environment flag
     * @param flag     the new flag definition, usually from {@code FlagDefinitions.X}
     * @return true if the environment flag is set at the location, false otherwise
     */
    public abstract boolean checkEnvironmentFlag(@NotNull Location location, @NotNull EnvironmentFlagDefinition flag);

    /**
     * Checks if the specified environment flag is set for the given dominion.
     * <p>
     * This method determines whether the provided environment flag is enabled for the specified dominion.
     * <p>
     * You should use {@link #checkEnvironmentFlag(Location, EnvironmentFlagDefinition)} instead,
     * because this method does not check the
     * <a href="https://dominion.lunadeer.cn/notes/doc/owner/config-ref/world-wide/">world-wide privilege</a> flag,
     * which is not recommended to use.
     * <p>
     *
     * @param dom  the DominionDTO to check for the environment flag, or null if not applicable
     * @param flag the environment flag to check
     * @return true if the environment flag is set for the dominion, false otherwise
     * @deprecated use {@link #checkEnvironmentFlag(DominionDTO, EnvironmentFlagDefinition)} with {@code FlagDefinitions.X}.
     */
    @Deprecated
    public abstract boolean checkEnvironmentFlag(@Nullable DominionDTO dom, @NotNull EnvFlag flag);

    /**
     * Checks if the specified environment flag is set for the given dominion.
     *
     * @param dom    the DominionDTO to check for the environment flag, or null if not applicable
     * @param flag the new flag definition, usually from {@code FlagDefinitions.X}
     * @return true if the environment flag is set for the dominion, false otherwise
     */
    public abstract boolean checkEnvironmentFlag(@Nullable DominionDTO dom, @NotNull EnvironmentFlagDefinition flag);

    /**
     * Retrieves the DominionProvider instance.
     * <p>
     * This method provides access to the DominionProvider, which handles dominion-related operations
     * such as creating, updating, and deleting dominions.
     *
     * @return the singleton instance of DominionProvider
     */
    public static DominionProvider getDominionProvider() {
        return DominionProvider.getInstance();
    }

    /**
     * Retrieves the GroupProvider instance.
     * <p>
     * This method provides access to the GroupProvider, which handles group-related operations
     * such as creating, updating, and deleting groups within dominions.
     *
     * @return the singleton instance of GroupProvider
     */
    public static GroupProvider getGroupProvider() {
        return GroupProvider.getInstance();
    }

    /**
     * Retrieves the MemberProvider instance.
     * <p>
     * This method provides access to the MemberProvider, which handles member-related operations
     * such as adding, updating, and removing members from dominions and groups.
     *
     * @return the singleton instance of MemberProvider
     */
    public static MemberProvider getMemberProvider() {
        return MemberProvider.getInstance();
    }

    /**
     * Reloads the dominion cache.
     * <p>
     * This method refreshes all cached dominion data, ensuring the latest state is loaded from the data source.
     * Use this when external changes may have affected the cache.
     */
    public abstract void reloadCache();

    /**
     * Reloads the dominion configuration.
     * <p>
     * This method reloads configuration files and settings for the dominion system.
     * Use this to apply changes made to configuration files without restarting the server.
     */
    public abstract void reloadConfig() throws Exception;

    /**
     * Retrieves the whitelist of MCA initiative.
     * <p>
     * This method will generate a list of McaRecord objects representing the coordinates of MCA initiative areas that are whitelisted.
     *
     * @return a list of McaRecord objects representing the MCA whitelist coordinates
     */
    public abstract List<McaRecord> getMcaWhiteListInitiative();

    /**
     * Retrieves the whitelist of MCA passive from cache.
     * <p>
     * If not in cache (generated by /dom export mca), it will return an empty list.
     * 
     * @return a list of McaRecord objects representing the MCA passive whitelist coordinates, or an empty list if not in cache
     */
    public abstract List<McaRecord> getMcaWhiteListPassive();
}
