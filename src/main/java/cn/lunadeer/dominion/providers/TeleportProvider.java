package cn.lunadeer.dominion.providers;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * API entry point for local and cross-server dominion teleportation.
 * <p>
 * Teleports are scheduled on the player's entity thread and complete
 * asynchronously.
 */
public abstract class TeleportProvider {
    /** The provider instance initialized by Dominion. */
    protected static TeleportProvider instance;

    /**
     * Gets the initialized provider instance.
     *
     * @return the provider, or {@code null} before Dominion initialization
     */
    public static TeleportProvider getInstance() {
        return instance;
    }

    /**
     * Teleports a player to a dominion's configured teleport location.
     *
     * @param player   the player to teleport
     * @param dominion the destination dominion
     * @return a future containing {@code true} when the teleport succeeds and
     *         {@code false} when the teleport is rejected
     */
    public abstract CompletableFuture<Boolean> teleport(@NotNull Player player,
                                                        @NotNull DominionDTO dominion);
}
