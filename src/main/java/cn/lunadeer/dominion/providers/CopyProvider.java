package cn.lunadeer.dominion.providers;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * API operations for copying selected management data between dominions.
 * <p>
 * Copy operations run asynchronously and return the target dominion when the
 * copy succeeds. A {@code null} result indicates cancellation or failure.
 */
public abstract class CopyProvider {
    /** The provider instance initialized by Dominion. */
    protected static CopyProvider instance;

    /**
     * Gets the initialized provider instance.
     *
     * @return the provider, or {@code null} before Dominion initialization
     */
    public static CopyProvider getInstance() {
        return instance;
    }

    /**
     * Copies one category of settings or membership data from one dominion to another.
     *
     * @param operator the command sender performing the operation
     * @param source   the dominion to copy from
     * @param target   the dominion to copy to
     * @param type     the category of data to copy
     * @return a future that completes with the target dominion, or {@code null}
     *         when authorization, validation, or copying fails
     */
    public abstract CompletableFuture<DominionDTO> copy(@NotNull CommandSender operator,
                                                        @NotNull DominionDTO source,
                                                        @NotNull DominionDTO target,
                                                        @NotNull CopyType type);
}
