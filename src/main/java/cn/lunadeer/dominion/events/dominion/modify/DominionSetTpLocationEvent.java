package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a teleport location is set for a Dominion in the Dominion system.
 */
public class DominionSetTpLocationEvent extends DominionModifyEvent {

    private final Location oldTpLocation;
    private Location newTpLocation;

    /**
     * Constructs a new DominionSetTpLocationEvent.
     *
     * @param operator      the command sender who initiated the event
     * @param dominion      the dominion for which the teleport location is being set
     * @param newTpLocation the new teleport location
     */
    public DominionSetTpLocationEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull Location newTpLocation) {
        super(operator, dominion);
        this.oldTpLocation = dominion.getTpLocation();
        this.newTpLocation = newTpLocation;
    }

    /**
     * Gets the old teleport location.
     *
     * @return the old teleport location
     */
    public @NotNull Location getOldTpLocation() {
        return oldTpLocation;
    }

    /**
     * Gets the new teleport location.
     *
     * @return the new teleport location
     */
    public @NotNull Location getNewTpLocation() {
        return newTpLocation;
    }

    /**
     * Sets the new teleport location.
     *
     * @param newTpLocation the new teleport location to set
     */
    public void setNewTpLocation(@NotNull Location newTpLocation) {
        this.newTpLocation = newTpLocation;
    }
}
