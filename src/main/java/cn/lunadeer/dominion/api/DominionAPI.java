package cn.lunadeer.dominion.api;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import cn.lunadeer.dominion.api.dtos.flag.EnvFlag;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import cn.lunadeer.dominion.providers.DominionProvider;
import cn.lunadeer.dominion.providers.GroupProvider;
import cn.lunadeer.dominion.providers.MemberProvider;
import cn.lunadeer.dominion.providers.CopyProvider;
import cn.lunadeer.dominion.providers.PlayerProvider;
import cn.lunadeer.dominion.providers.TeleportProvider;
import cn.lunadeer.dominion.providers.TemplateProvider;
import cn.lunadeer.dominion.utils.McaRecord;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Entry point for the public Dominion API.
 * <p>
 * The API exposes read-only cache access, privilege checks, provider instances,
 * and a small number of maintenance operations. It is initialized by the
 * Dominion plugin during startup.
 * <p>
 * Use the {@link #getInstance()} method to retrieve the singleton instance of the DominionAPI.
 */
public abstract class DominionAPI {

    /** The API instance initialized by the Dominion plugin. */
    protected static DominionAPI instance;

    /**
     * Returns the Dominion API instance initialized by the plugin.
     * <p>
     * This method does not load or enable the Dominion plugin. Call it after
     * declaring Dominion as a dependency in {@code plugin.yml} and after the
     * plugin has been enabled.
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
     * Retrieves the cached name of a player by their UUID.
     *
     * @param uuid the UUID of the player
     * @return the cached name, or an implementation-defined placeholder when the player is unknown
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
     * Retrieves all dominions owned by a specific player.
     * <p>
     * In multi-server mode, the result can include dominions cached for other servers.
     *
     * @param player the UUID of the player
     * @return a list of DominionDTO objects owned by the specified player
     */
    public abstract List<DominionDTO> getAllDominionsOfPlayer(@NotNull UUID player);

    /**
     * Retrieves the direct child dominions of a given parent dominion.
     * <p>
     * In multi-server mode, the result can include children cached for other servers.
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
     * Retrieves a member by a Bukkit player object.
     * <p>
     * This overload uses the player's UUID and is equivalent to the UUID overload.
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
     * Retrieves the group to which a member belongs.
     * <p>
     * A member whose group ID is {@code -1}, or whose group cannot be found,
     * produces a {@code null} result.
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
     * Resolves and updates the dominion currently containing a player.
     * <p>
     * The lookup is based on the player's current location. When the result
     * changes, the corresponding enter, leave, or border-crossing events are
     * fired and the cached current-dominion value is updated.
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
     * Retrieves the total number of dominions visible to this server.
     * <p>
     * This method calculates the total number of dominions by summing the count of dominions on this server and, if
     * multi-servers mode is enabled, the counts from other servers.
     *
     * @return the total count of dominions
     */
    public abstract Integer dominionCount();

    /**
     * Retrieves the total number of groups visible to this server.
     * <p>
     * This method calculates the total number of groups by summing the count of groups on this server and, if
     * multi-servers mode is enabled, the counts from other servers.
     *
     * @return the total count of groups
     */
    public abstract Integer groupCount();

    /**
     * Retrieves the total number of members visible to this server.
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
     */
    public abstract boolean checkPrivilegeFlag(@NotNull Location location, @NotNull PriFlag flag, @NotNull Player player);

    /**
     * Checks if a player has a specific privilege flag for the given dominion.
     * <p>
     * This method verifies whether the player has permission for the specified privilege flag
     * within the provided dominion. If the dominion is null, the check may be performed in a global or default context.
     * <p>
     * Since 4.5.0 you should use {@link #checkPrivilegeFlag(Location, PriFlag, Player)} instead,
     * because this method does not check the
     * <a href="https://dominion.lunadeer.cn/notes/doc/owner/config-ref/world-wide/">world-wide privilege</a> flag,
     * which is not recommended to use.
     *
     * @param dom    the DominionDTO to check the privilege flag in, or null if not applicable
     * @param flag   the privilege flag to check
     * @param player the player whose privileges are being checked
     * @return true if the player has the privilege flag in the dominion, false otherwise
     */
    public abstract boolean checkPrivilegeFlag(@Nullable DominionDTO dom, @NotNull PriFlag flag, @NotNull Player player);

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
     */
    public abstract boolean checkPrivilegeFlagSilence(@NotNull Location location, @NotNull PriFlag flag, @NotNull Player player);

    /**
     * Checks if a player has a specific privilege flag for the given dominion without triggering messages or events.
     * <p>
     * This method performs a silent privilege check for the specified dominion, privilege flag, and player.
     * No messages are sent and no events are triggered, making it suitable for internal permission checks.
     * <p>
     * Since 4.5.0 you should use {@link #checkPrivilegeFlagSilence(Location, PriFlag, Player)} instead,
     * because this method does not check the
     * <a href="https://dominion.lunadeer.cn/notes/doc/owner/config-ref/world-wide/">world-wide privilege</a> flag,
     * which is not recommended to use.
     *
     * @param dom    the DominionDTO to check the privilege flag in, or null if not applicable
     * @param flag   the privilege flag to check
     * @param player the player whose privileges are being checked
     * @return true if the player has the privilege flag in the dominion, false otherwise
     */
    public abstract boolean checkPrivilegeFlagSilence(@Nullable DominionDTO dom, @NotNull PriFlag flag, @NotNull Player player);

    /**
     * Checks if the specified environment flag is set at the given location.
     * <p>
     * This method determines whether the provided environment flag is enabled at the specified location,
     * considering the dominion (if any) that covers the location.
     *
     * @param location the location to check for the environment flag
     * @param flag     the environment flag to check
     * @return true if the environment flag is set at the location, false otherwise
     */
    public abstract boolean checkEnvironmentFlag(@NotNull Location location, @NotNull EnvFlag flag);

    /**
     * Checks if the specified environment flag is set for the given dominion.
     * <p>
     * This method determines whether the provided environment flag is enabled for the specified dominion.
     * <p>
     * Since 4.5.0 you should use {@link #checkEnvironmentFlag(Location, EnvFlag)} instead,
     * because this method does not check the
     * <a href="https://dominion.lunadeer.cn/notes/doc/owner/config-ref/world-wide/">world-wide privilege</a> flag,
     * which is not recommended to use.
     *
     * @param dom  the DominionDTO to check for the environment flag, or null if not applicable
     * @param flag the environment flag to check
     * @return true if the environment flag is set for the dominion, false otherwise
     */
    public abstract boolean checkEnvironmentFlag(@Nullable DominionDTO dom, @NotNull EnvFlag flag);

    /**
     * Retrieves the provider for dominion operations.
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
     * Retrieves the provider for group operations.
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
     * Retrieves the provider for member operations.
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
     * Retrieves the provider for player-owned privilege templates.
     *
     * @return the singleton {@link TemplateProvider} instance
     */
    public static TemplateProvider getTemplateProvider() {
        return TemplateProvider.getInstance();
    }

    /**
     * Retrieves the provider for copying management data between dominions.
     *
     * @return the singleton {@link CopyProvider} instance
     */
    public static CopyProvider getCopyProvider() {
        return CopyProvider.getInstance();
    }

    /**
     * Retrieves the provider for player data and group-title operations.
     *
     * @return the singleton {@link PlayerProvider} instance
     */
    public static PlayerProvider getPlayerProvider() {
        return PlayerProvider.getInstance();
    }

    /**
     * Retrieves the provider for dominion teleportation.
     *
     * @return the singleton {@link TeleportProvider} instance
     */
    public static TeleportProvider getTeleportProvider() {
        return TeleportProvider.getInstance();
    }

    /**
     * Reloads the dominion cache.
     * <p>
     * This method refreshes all cached dominion data, ensuring the latest state is loaded from the data source.
     * Use this when external changes may have affected the cache.
     */
    public abstract void reloadCache();

    /**
     * Reloads the Dominion configuration and related runtime state.
     * <p>
     * This method reloads configuration files and settings for the dominion system.
     * Use this to apply changes made to configuration files without restarting the server.
     *
     * @throws Exception if configuration or database reloading fails
     */
    public abstract void reloadConfig() throws Exception;

    /**
     * Applies pending custom flag and flag-group changes. Calls made in the same
     * server tick may share one application pass.
     *
     * @return a future completed after the pass containing this request finishes
     */
    public abstract CompletableFuture<Void> applyFlagChanges();

    /**
     * Exports and retrieves the active MCA whitelist.
     * <p>
     * The active whitelist is regenerated by the plugin before it is returned.
     *
     * @return the current list of whitelisted MCA regions
     */
    public abstract List<McaRecord> getMcaWhiteListInitiative();

    /**
     * Retrieves the passive MCA whitelist from the cache.
     * <p>
     * This method does not trigger an export. The returned value depends on
     * whether the cache has already been populated, for example by
     * {@code /dom export mca}.
     *
     * @return the cached list of whitelisted MCA regions
     */
    public abstract List<McaRecord> getMcaWhiteListPassive();
}
