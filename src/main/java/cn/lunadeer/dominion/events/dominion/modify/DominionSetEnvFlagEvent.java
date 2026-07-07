package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.flag.EnvFlag;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when an environmental flag is set for a Dominion in the Dominion system.
 *
 * @deprecated legacy event based on {@link EnvFlag}. New flag APIs use
 * {@code FlagDefinition}.
 */
@Deprecated
public class DominionSetEnvFlagEvent extends DominionModifyEvent {

    private final EnvFlag flag;
    private final boolean oldValue;
    private boolean newValue;

    /**
     * Constructs a new DominionSetEnvFlagEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion for which the flag is being set
     * @param flag     the environmental flag being set
     * @param newValue the new value of the flag
     */
    public DominionSetEnvFlagEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull EnvFlag flag, boolean newValue) {
        super(operator, dominion);
        this.flag = flag;
        this.oldValue = dominion.getEnvFlagValue(flag);
        this.newValue = newValue;
    }

    /**
     * Gets the environmental flag being set.
     *
     * @return the environmental flag
     */
    @Deprecated
    public EnvFlag getFlag() {
        return flag;
    }

    /**
     * Gets the old value of the environmental flag.
     *
     * @return the old value of the environmental flag
     */
    public boolean getOldValue() {
        return oldValue;
    }

    /**
     * Gets the new value of the environmental flag.
     *
     * @return the new value of the environmental flag
     */
    public boolean getNewValue() {
        return newValue;
    }

    /**
     * Sets the new value of the environmental flag.
     *
     * @param newValue the new value to set
     */
    public void setNewValue(boolean newValue) {
        this.newValue = newValue;
    }

}
