package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.flag.EnvFlag;
import cn.lunadeer.dominion.api.dtos.flag.EnvironmentFlagDefinition;
import cn.lunadeer.dominion.api.dtos.flag.LegacyFlagBridge;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Event triggered when an environment flag is set for a Dominion in the Dominion system.
 */
public class DominionSetEnvFlagEvent extends DominionModifyEvent {

    private final @Nullable EnvFlag legacyFlag;
    private final EnvironmentFlagDefinition flagDefinition;
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
    @Deprecated
    public DominionSetEnvFlagEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull EnvFlag flag, boolean newValue) {
        super(operator, dominion);
        this.legacyFlag = flag;
        this.flagDefinition = LegacyFlagBridge.definitionsFor(flag).get(0);
        this.oldValue = dominion.getEnvFlagValue(flag);
        this.newValue = newValue;
    }

    public DominionSetEnvFlagEvent(@NotNull CommandSender operator,
                                   @NotNull DominionDTO dominion,
                                   @NotNull EnvironmentFlagDefinition flagDefinition,
                                   boolean newValue) {
        super(operator, dominion);
        this.legacyFlag = LegacyFlagBridge.legacyFor(flagDefinition);
        this.flagDefinition = flagDefinition;
        this.oldValue = dominion.getEnvFlagValue(flagDefinition);
        this.newValue = newValue;
    }

    public @NotNull EnvironmentFlagDefinition getFlagDefinition() {
        return flagDefinition;
    }

    /**
     * Gets the environmental flag being set.
     *
     * @return the environmental flag
     */
    @Deprecated
    public @Nullable EnvFlag getFlag() {
        return legacyFlag;
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
