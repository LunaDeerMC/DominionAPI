package cn.lunadeer.dominion.providers;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/** API entry point for local and cross-server dominion teleportation. */
public abstract class TeleportProvider {
    protected static TeleportProvider instance;

    public static TeleportProvider getInstance() {
        return instance;
    }

    public abstract CompletableFuture<Boolean> teleport(@NotNull Player player,
                                                        @NotNull DominionDTO dominion);
}
