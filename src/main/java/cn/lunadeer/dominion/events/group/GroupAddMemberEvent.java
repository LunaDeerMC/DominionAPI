package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Event triggered when a member is added to a group within a dominion.
 */
public class GroupAddMemberEvent extends ResultEvent {

    private final DominionDTO dominion;
    private final GroupDTO group;
    private MemberDTO member;
    private final CompletableFuture<MemberDTO> future = new CompletableFuture<>();

    /**
     * Constructs a new GroupAddMemberEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion to which the group belongs
     * @param group    the group to which the member is being added
     * @param member   the member being added to the group
     */
    public GroupAddMemberEvent(@NotNull CommandSender operator,
                               @NotNull DominionDTO dominion,
                               @NotNull GroupDTO group,
                               @NotNull MemberDTO member) {
        super(operator);
        this.dominion = dominion;
        this.group = group;
        this.member = member;
    }

    /**
     * Gets the group to which the member is being added.
     *
     * @return the group
     */
    public @NotNull GroupDTO getGroup() {
        return group;
    }

    /**
     * Gets the member being added to the group.
     * <p>
     * This method returns the member that will be added to the group. If you want to
     * get the member after it has been added (which may fail), you should use the
     * {@link #afterAdded(Consumer)} method instead.
     *
     * @return the member
     */
    public @NotNull MemberDTO getMember() {
        return member;
    }

    /**
     * Sets the member being added to the group.
     *
     * @param member the member to set
     */
    public void setMember(@NotNull MemberDTO member) {
        this.member = member;
    }

    /**
     * Gets the dominion to which the group belongs.
     *
     * @return the dominion
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
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
     * Use this method to perform actions after the member has been added (may fail),
     * if you need to do something with the added member.
     *
     * @param consumer the consumer to handle the created member
     * @return a CompletableFuture that completes when the consumer has been executed
     */
    public CompletableFuture<Void> afterAdded(Consumer<MemberDTO> consumer) {
        return future.thenAccept(consumer);
    }
}
