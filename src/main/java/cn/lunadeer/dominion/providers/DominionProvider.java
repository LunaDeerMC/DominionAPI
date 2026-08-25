package cn.lunadeer.dominion.providers;

import cn.lunadeer.dominion.api.dtos.CuboidDTO;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import cn.lunadeer.dominion.api.dtos.flag.EnvFlag;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import cn.lunadeer.dominion.events.dominion.modify.DominionReSizeEvent;
import cn.lunadeer.dominion.events.dominion.modify.DominionSetMessageEvent;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Provides asynchronous operations for creating, modifying, and managing dominions.
 * <p>
 * These methods are controlled by the Dominion system, including permission,
 * validation, economy, cache, and event processing.
 * A returned future normally completes with the updated DTO and completes
 * with {@code null} when the event is cancelled or the operation fails.
 * <p>
 * The operator parameter of each method defines who triggers the operation. If the operator is a specific player,
 * these methods will check permissions accordingly. For no-permission-required operations, you can pass
 * the console command sender {@link org.bukkit.Bukkit#getConsoleSender()}.
 *
 * @since 4.6.0
 */
public abstract class DominionProvider {
    /** The provider instance initialized by Dominion. */
    protected static DominionProvider instance;

    /**
     * Gets the singleton instance of the DominionProvider.
     *
     * @return the current provider instance, or {@code null} if not initialized
     */
    public static DominionProvider getInstance() {
        return instance;
    }

    /**
     * Creates a new dominion in the specified world with the given parameters.
     *
     * @param operator    the command sender performing this operation (for permission checks and logging)
     * @param name        the name of the new dominion (must be unique within the parent scope)
     * @param owner       the UUID of the player who will own this dominion
     * @param world       the world where the dominion will be created
     * @param cuboid      the 3D area that defines the dominion's boundaries
     * @param parent      the parent dominion, or null if this is a top-level dominion
     * @param skipEconomy whether to skip economy checks and charges for this operation
     * @return a future that completes with the created dominion, or {@code null}
     *         if the operation is cancelled or fails
     */
    public abstract CompletableFuture<DominionDTO> createDominion(@NotNull CommandSender operator,
                                                                  @NotNull String name, @NotNull UUID owner,
                                                                  @NotNull World world, @NotNull CuboidDTO cuboid,
                                                                  @Nullable DominionDTO parent, boolean skipEconomy);

    /**
     * Resizes an existing dominion by expanding or contracting it in a specified direction.
     *
     * @param operator  the command sender performing this operation
     * @param dominion  the dominion to be resized
     * @param type      the type of resize operation (expand or contract)
     * @param direction the direction in which to resize (north, south, east, west, up, down)
     * @param size      the number of blocks to resize by (positive integer)
     * @return a future that completes with the resized dominion, or {@code null}
     *         if the operation is cancelled or fails
     */
    public abstract CompletableFuture<DominionDTO> resizeDominion(@NotNull CommandSender operator,
                                                                  @NotNull DominionDTO dominion,
                                                                  @NotNull DominionReSizeEvent.TYPE type,
                                                                  @NotNull DominionReSizeEvent.DIRECTION direction,
                                                                  int size);

    /**
     * Deletes a dominion and optionally all of its sub-dominions.
     *
     * @param operator    the command sender performing this operation
     * @param dominion    the dominion to be deleted
     * @param skipEconomy whether to skip economy refunds for this operation
     * @param force       whether to force deletion even if there are sub-dominions or other dependencies
     * @return a future that completes with the deleted dominion, or {@code null}
     *         if the operation is cancelled, denied, or fails
     */
    public abstract CompletableFuture<DominionDTO> deleteDominion(@NotNull CommandSender operator,
                                                                  @NotNull DominionDTO dominion,
                                                                  boolean skipEconomy,
                                                                  boolean force);

    /**
     * Deletes a dominion with force enabled by default.
     * This is a convenience method that calls {@link #deleteDominion(CommandSender, DominionDTO, boolean, boolean)}
     * with force set to true.
     *
     * @param operator    the command sender performing this operation
     * @param dominion    the dominion to be deleted
     * @param skipEconomy whether to skip economy refunds for this operation
     * @return a future that completes with the deleted dominion, or {@code null}
     *         if the operation is cancelled, denied, or fails
     */
    public CompletableFuture<DominionDTO> deleteDominion(@NotNull CommandSender operator,
                                                         @NotNull DominionDTO dominion,
                                                         boolean skipEconomy) {
        return deleteDominion(operator, dominion, skipEconomy, true);
    }

    /**
     * Renames an existing dominion to a new name.
     *
     * @param operator the command sender performing this operation
     * @param dominion the dominion to be renamed
     * @param newName  the new name for the dominion (must be unique within the parent scope)
     * @return a future that completes with the renamed dominion, or {@code null}
     *         if the operation is cancelled or fails
     */
    public abstract CompletableFuture<DominionDTO> renameDominion(@NotNull CommandSender operator,
                                                                  @NotNull DominionDTO dominion,
                                                                  @NotNull String newName);

    /**
     * Transfers ownership of a dominion to a new player.
     *
     * @param operator the command sender performing this operation
     * @param dominion the dominion to be transferred
     * @param newOwner the player who will become the new owner
     * @param force    whether to force the transfer even if the new owner doesn't meet requirements
     * @return a future that completes with the transferred dominion, or {@code null}
     *         if the operation is cancelled, denied, or fails
     */
    public abstract CompletableFuture<DominionDTO> transferDominion(@NotNull CommandSender operator,
                                                                    @NotNull DominionDTO dominion,
                                                                    @NotNull PlayerDTO newOwner,
                                                                    boolean force);

    /**
     * Transfers ownership of a dominion to a new player with force enabled by default.
     * This is a convenience method that calls {@link #transferDominion(CommandSender, DominionDTO, PlayerDTO, boolean)}
     * with force set to true.
     *
     * @param operator the command sender performing this operation
     * @param dominion the dominion to be transferred
     * @param newOwner the player who will become the new owner
     * @return a future that completes with the updated dominion, or {@code null}
     *         if the operation is cancelled or fails
     */
    public CompletableFuture<DominionDTO> transferDominion(@NotNull CommandSender operator,
                                                           @NotNull DominionDTO dominion,
                                                           @NotNull PlayerDTO newOwner) {
        return transferDominion(operator, dominion, newOwner, true);
    }

    /**
     * Sets the teleport location for a dominion. This is where players will be teleported
     * when using the dominion teleport feature.
     *
     * @param operator      the command sender performing this operation
     * @param dominion      the dominion whose teleport location will be updated
     * @param newTpLocation the new teleport location within the dominion
     * @return a future that completes with the updated dominion, or {@code null}
     *         if the operation is cancelled or fails
     */
    public abstract CompletableFuture<DominionDTO> setDominionTpLocation(@NotNull CommandSender operator,
                                                                         @NotNull DominionDTO dominion,
                                                                         @NotNull Location newTpLocation);

    /**
     * Sets a message for the dominion (enter/leave messages, etc.).
     *
     * @param operator   the command sender performing this operation
     * @param dominion   the dominion whose message will be updated
     * @param type       the type of message to set (enter, leave, etc.)
     * @param newMessage the new message text
     * @return a future that completes with the updated dominion, or {@code null}
     *         if the operation is cancelled or fails
     */
    public abstract CompletableFuture<DominionDTO> setDominionMessage(@NotNull CommandSender operator,
                                                                      @NotNull DominionDTO dominion,
                                                                      @NotNull DominionSetMessageEvent.TYPE type,
                                                                      @NotNull String newMessage);

    /**
     * Sets the map display color for the dominion. This affects how the dominion
     * appears on dynmap or other mapping plugins.
     *
     * @param operator the command sender performing this operation
     * @param dominion the dominion whose map color will be updated
     * @param newColor the new color for the dominion on maps
     * @return a future that completes with the updated dominion, or {@code null}
     *         if the operation is cancelled or fails
     */
    public abstract CompletableFuture<DominionDTO> setDominionMapColor(@NotNull CommandSender operator,
                                                                       @NotNull DominionDTO dominion,
                                                                       @NotNull Color newColor);

    /**
     * Sets an environment flag for the dominion. Environment flags control various
     * world interactions within the dominion (like fire spread, mob spawning, etc.).
     *
     * @param operator the command sender performing this operation
     * @param dominion the dominion whose environment flag will be updated
     * @param flag     the specific environment flag to modify
     * @param newValue the new value for the flag (true to enable, false to disable)
     * @return a future that completes with the updated dominion, or {@code null}
     *         if the operation is cancelled or fails
     */
    public abstract CompletableFuture<DominionDTO> setDominionEnvFlag(@NotNull CommandSender operator,
                                                                      @NotNull DominionDTO dominion,
                                                                      @NotNull EnvFlag flag,
                                                                      boolean newValue);

    /**
     * Sets a guest privilege flag for the dominion. Guest flags control what actions
     * non-privileged players can perform within the dominion.
     *
     * @param operator the command sender performing this operation
     * @param dominion the dominion whose guest flag will be updated
     * @param flag     the specific privilege flag to modify
     * @param newValue the new value for the flag (true to allow, false to deny)
     * @return a future that completes with the updated dominion, or {@code null}
     *         if the operation is cancelled or fails
     */
    public abstract CompletableFuture<DominionDTO> setDominionGuestFlag(@NotNull CommandSender operator,
                                                                        @NotNull DominionDTO dominion,
                                                                        @NotNull PriFlag flag,
                                                                        boolean newValue);
                                                                        
}
