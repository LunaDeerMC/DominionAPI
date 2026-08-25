package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Event triggered when a group's privilege flag is changed.
 */
public class GroupSetFlagEvent extends ResultEvent {

    private final DominionDTO dominion;
    private final PriFlag flag;
    private final boolean oldValue;
    private boolean newValue;
    private final GroupDTO group;
    private final CompletableFuture<GroupDTO> future = new CompletableFuture<>();

    /**
     * Constructs a new GroupSetFlagEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion to which the group belongs
     * @param group    the group for which the flag is being set
     * @param flag     the flag being set
     * @param newValue the new value of the flag
     */
    public GroupSetFlagEvent(@NotNull CommandSender operator,
                             @NotNull DominionDTO dominion,
                             @NotNull GroupDTO group,
                             @NotNull PriFlag flag,
                             boolean newValue) {
        super(operator);
        this.dominion = dominion;
        this.flag = flag;
        this.oldValue = group.getFlagValue(flag);
        this.newValue = newValue;
        this.group = group;
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
     * Gets the flag being set.
     *
     * @return the flag
     */
    public PriFlag getFlag() {
        return flag;
    }

    /**
     * Gets the old value of the flag.
     *
     * @return the old value of the flag
     */
    public boolean getOldValue() {
        return oldValue;
    }

    /**
     * Gets the new value of the flag.
     *
     * @return the new value of the flag
     */
    public boolean getNewValue() {
        return newValue;
    }

    /**
     * Sets the new value of the flag.
     *
     * @param newValue the new value to set
     */
    public void setNewValue(boolean newValue) {
        this.newValue = newValue;
    }

    /**
     * Gets the group for which the flag is being set.
     *
     * @return the group
     */
    public GroupDTO getGroup() {
        return group;
    }

    /**
     * Gets the CompletableFuture that will be completed with the GroupDTO.
     * <p>
     * Under most circumstances, you should not need to use this method directly. If you
     * need to perform actions after the group is set, you should use the
     * {@link #afterSet(Consumer)} method instead.
     *
     * @return the future; its result is the modified group, or {@code null} when the
     *         operation fails
     */
    public CompletableFuture<GroupDTO> getFutureToComplete() {
        return future;
    }

    /**
     * Registers a callback to run after the group flag is set.
     * <p>
     * The callback receives the updated group, or {@code null} when the
     * operation fails.
     *
     * @param consumer the consumer to handle the set group
     * @return a future that completes when the consumer has been executed
     */
    public CompletableFuture<Void> afterSet(Consumer<GroupDTO> consumer) {
        return future.thenAccept(consumer);
    }
}
