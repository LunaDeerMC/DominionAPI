package cn.lunadeer.dominion.events.member;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Event triggered when a member is removed from a Dominion.
 * <p>
 * This event is triggered when a player removes a member.
 */
public class MemberRemovedEvent extends ResultEvent {
    private DominionDTO dominion;
    private MemberDTO member;
    private final CompletableFuture<MemberDTO> future = new CompletableFuture<>();

    /**
     * Constructs a new MemberRemovedEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion from which the member is removed
     * @param member   the member being removed
     */
    public MemberRemovedEvent(@NotNull CommandSender operator,
                              @NotNull DominionDTO dominion,
                              @NotNull MemberDTO member) {
        super(operator);
        this.dominion = dominion;
        this.member = member;
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
     * Sets the member.
     *
     * @param member the member to set
     */
    public void setMember(@NotNull MemberDTO member) {
        this.member = member;
    }

    /**
     * Gets the member.
     *
     * @return the member
     */
    public @NotNull MemberDTO getMember() {
        return member;
    }

    /**
     * Gets the CompletableFuture that will be completed with the removed MemberDTO.
     * <p>
     * Under most circumstances, you should not need to use this method directly. If you
     * need to perform actions after the member is removed, you should use the
     * {@link #afterRemoved(Consumer)} method instead.
     *
     * @return the future; its result is the removed member, or {@code null} when the
     *         operation fails
     */
    public CompletableFuture<MemberDTO> getFutureToComplete() {
        return future;
    }

    /**
     * Call back after the member is removed.
     * <p>
     * Use this method to perform actions after the member has been removed (may fail),
     * if you need to do something with the removed member.
     *
     * @param consumer the consumer to handle the removed member
     * @return a CompletableFuture that completes when the consumer has been executed
     */
    public CompletableFuture<Void> afterRemoved(Consumer<MemberDTO> consumer) {
        return future.thenAccept(consumer);
    }
}
