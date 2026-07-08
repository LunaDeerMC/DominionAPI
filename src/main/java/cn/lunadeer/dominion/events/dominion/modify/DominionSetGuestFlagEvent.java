package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.flag.LegacyFlagBridge;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import cn.lunadeer.dominion.api.dtos.flag.PrivilegeFlagDefinition;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Event triggered when a guest privilege flag is set for a Dominion in the Dominion system.
 */
public class DominionSetGuestFlagEvent extends DominionModifyEvent {

    private final @Nullable PriFlag legacyFlag;
    private final PrivilegeFlagDefinition flagDefinition;
    private final boolean oldValue;
    private boolean newValue;

    /**
     * Constructs a new DominionSetGuestFlagEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion for which the flag is being set
     * @param flag     the guest flag being set
     * @param newValue the new value of the flag
     */
    @Deprecated
    public DominionSetGuestFlagEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull PriFlag flag, boolean newValue) {
        super(operator, dominion);
        this.legacyFlag = flag;
        this.flagDefinition = LegacyFlagBridge.definitionsFor(flag).get(0);
        this.oldValue = dominion.getGuestFlagValue(flag);
        this.newValue = newValue;
    }

    public DominionSetGuestFlagEvent(@NotNull CommandSender operator,
                                     @NotNull DominionDTO dominion,
                                     @NotNull PrivilegeFlagDefinition flagDefinition,
                                     boolean newValue) {
        super(operator, dominion);
        this.legacyFlag = LegacyFlagBridge.legacyFor(flagDefinition);
        this.flagDefinition = flagDefinition;
        this.oldValue = dominion.getGuestFlagValue(flagDefinition);
        this.newValue = newValue;
    }

    public @NotNull PrivilegeFlagDefinition getFlagDefinition() {
        return flagDefinition;
    }

    /**
     * Gets the guest flag being set.
     *
     * @return the guest flag
     */
    @Deprecated
    public @Nullable PriFlag getFlag() {
        return legacyFlag;
    }

    /**
     * Gets the old value of the guest flag.
     *
     * @return the old value of the guest flag
     */
    public boolean getOldValue() {
        return oldValue;
    }

    /**
     * Gets the new value of the guest flag.
     *
     * @return the new value of the guest flag
     */
    public boolean getNewValue() {
        return newValue;
    }

    /**
     * Sets the new value of the guest flag.
     *
     * @param newValue the new value to set
     */
    public void setNewValue(boolean newValue) {
        this.newValue = newValue;
    }

}
