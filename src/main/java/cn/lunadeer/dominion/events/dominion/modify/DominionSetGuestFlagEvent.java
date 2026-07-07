package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a guest flag is set for a Dominion in the Dominion system.
 *
 * @deprecated legacy event based on {@link PriFlag}. New flag APIs use
 * {@code FlagDefinition}.
 */
@Deprecated
public class DominionSetGuestFlagEvent extends DominionModifyEvent {

    private final PriFlag flag;
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
    public DominionSetGuestFlagEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull PriFlag flag, boolean newValue) {
        super(operator, dominion);
        this.flag = flag;
        this.oldValue = dominion.getGuestFlagValue(flag);
        this.newValue = newValue;
    }

    /**
     * Gets the guest flag being set.
     *
     * @return the guest flag
     */
    @Deprecated
    public PriFlag getFlag() {
        return flag;
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
