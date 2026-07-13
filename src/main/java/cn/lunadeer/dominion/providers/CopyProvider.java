package cn.lunadeer.dominion.providers;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/** API operations for copying selected management data between dominions. */
public abstract class CopyProvider {
    protected static CopyProvider instance;

    public static CopyProvider getInstance() {
        return instance;
    }

    public abstract CompletableFuture<DominionDTO> copy(@NotNull CommandSender operator,
                                                        @NotNull DominionDTO source,
                                                        @NotNull DominionDTO target,
                                                        @NotNull CopyType type);
}
