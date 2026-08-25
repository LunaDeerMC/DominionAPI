package cn.lunadeer.dominion.events.member;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Event triggered when a member is added to a Dominion.
 */
public class MemberAddedEvent extends ResultEvent {
    private DominionDTO dominion;
    private PlayerDTO player;
    private final CompletableFuture<MemberDTO> future = new CompletableFuture<>();

    /**
     * Constructs a new MemberAddedEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion to which the member is added
     * @param player   the player record being added as a member
     */
    public MemberAddedEvent(@NotNull CommandSender operator,
                            @NotNull DominionDTO dominion,
                            @NotNull PlayerDTO player) {
        super(operator);
        this.dominion = dominion;
        this.player = player;
    }

    /**
     * Sets the dominion.
     *
     * @param dominion the dominion to set
     */
    public void setDominion(@NotNull DominionDTO dominion) {
        this.dominion = dominion;
    }

    /**
     * Gets the dominion.
     *
     * @return the dominion
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    /**
     * Sets the player.
     *
     * @param player the player to set
     */
    public void setPlayer(@NotNull PlayerDTO player) {
        this.player = player;
    }

    /**
     * Gets the player.
     *
     * @return the player
     */
    public @NotNull PlayerDTO getPlayer() {
        return player;
    }

    /**
     * Gets the CompletableFuture that will be completed with the added MemberDTO.
     * <p>
     * Under most circumstances, you should not need to use this method directly. If you
     * need to perform actions after the member is added, you should use the
     * {@link #afterAdded(Consumer)} method instead.
     *
     * @return the future; its result is the added member, or {@code null} when the
     *         operation fails
     */
    public CompletableFuture<MemberDTO> getFutureToComplete() {
        return future;
    }

    /**
     * Call back after the member is added.
     * <p>
     * Use this method to perform actions after the member has been added (the
     * callback receives {@code null} when the operation fails).
     *
     * @param consumer the consumer to handle the added member
     * @return a future that completes when the consumer has been executed
     */
    public CompletableFuture<Void> afterAdded(Consumer<MemberDTO> consumer) {
        return future.thenAccept(consumer);
    }

    /**
     * This compatibility method does nothing.
     *
     * @param member ignored
     */
    @Deprecated(since = "4.6.0", forRemoval = true)
    public void setMember(@Nullable MemberDTO member) {

    }

    /**
     * This compatibility method always returns {@code null}. Use
     * {@link #afterAdded(Consumer)} to observe the asynchronous result.
     *
     * @return always {@code null}
     */
    @Deprecated(since = "4.6.0", forRemoval = true)
    public @Nullable MemberDTO getMember() {
        return null;
    }
}
