package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.command.CommandSender;

public class DominionSetOwnerGlowEvent extends DominionModifyEvent {

    private final boolean oldValue;
    private boolean newValue;

    public DominionSetOwnerGlowEvent(CommandSender operator, DominionDTO dominion, boolean newValue) {
        super(operator, dominion);
        this.oldValue = dominion.getOwnerGlow();
        this.newValue = newValue;
    }

    public boolean getOldValue() {
        return oldValue;
    }

    public boolean getNewValue() {
        return newValue;
    }

    public void setNewValue(boolean newValue) {
        this.newValue = newValue;
    }
    
}
