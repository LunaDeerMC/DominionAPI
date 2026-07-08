package cn.lunadeer.dominion.events.member;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.flag.LegacyFlagBridge;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import cn.lunadeer.dominion.api.dtos.flag.PrivilegeFlagDefinition;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Event triggered when a member's privilege flag is changed.
 */
public class MemberSetFlagEvent extends ResultEvent {

    private final DominionDTO dominion;
    private final @Nullable PriFlag legacyFlag;
    private final PrivilegeFlagDefinition flagDefinition;
    private final boolean oldValue;
    private boolean newValue;
    private final MemberDTO member;
    private final CompletableFuture<MemberDTO> future = new CompletableFuture<>();

    /**
     * Constructs a new MemberSetFlagEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion to which the member belongs
     * @param member   the member whose flag is being set
     * @param flag     the flag being set
     * @param newValue the new value of the flag
     */
    @Deprecated
    public MemberSetFlagEvent(@NotNull CommandSender operator,
                              @NotNull DominionDTO dominion,
                              @NotNull MemberDTO member,
                              @NotNull PriFlag flag,
                              boolean newValue) {
        super(operator);
        this.dominion = dominion;
        this.legacyFlag = flag;
        this.flagDefinition = LegacyFlagBridge.definitionsFor(flag).get(0);
        this.oldValue = member.getFlagValue(flag);
        this.newValue = newValue;
        this.member = member;
    }

    public MemberSetFlagEvent(@NotNull CommandSender operator,
                              @NotNull DominionDTO dominion,
                              @NotNull MemberDTO member,
                              @NotNull PrivilegeFlagDefinition flagDefinition,
                              boolean newValue) {
        super(operator);
        this.dominion = dominion;
        this.legacyFlag = LegacyFlagBridge.legacyFor(flagDefinition);
        this.flagDefinition = flagDefinition;
        this.oldValue = member.getFlagValue(flagDefinition);
        this.newValue = newValue;
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
     * Gets the flag being set.
     *
     * @return the flag being set
     */
    @Deprecated
    public @Nullable PriFlag getFlag() {
        return legacyFlag;
    }

    public @NotNull PrivilegeFlagDefinition getFlagDefinition() {
        return flagDefinition;
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
     * Gets the member whose flag is being set.
     *
     * @return the member whose flag is being set
     */
    public MemberDTO getMember() {
        return member;
    }

    /**
     * Gets the CompletableFuture that will be completed with the MemberDTO.
     * <p>
     * Under most circumstances, you should not need to use this method directly. If you
     * need to perform actions after the member is set, you should use the
     * {@link #afterSet(Consumer)} method instead.
     *
     * @return the CompletableFuture to be completed
     */
    public CompletableFuture<MemberDTO> getFutureToComplete() {
        return future;
    }

    /**
     * Call back after the member is set.
     * <p>
     * Use this method to perform actions after the member has been set (may fail),
     * if you need to do something with the set member,
     *
     * @param consumer the consumer to handle the set member
     * @return a CompletableFuture that completes when the consumer has been executed
     */
    public CompletableFuture<Void> afterSet(Consumer<MemberDTO> consumer) {
        return future.thenAccept(consumer);
    }
}
