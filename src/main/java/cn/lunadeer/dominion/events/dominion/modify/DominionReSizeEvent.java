package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.CuboidDTO;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a Dominion's size is modified in the Dominion system.
 */
public class DominionReSizeEvent extends DominionModifyEvent {

    /**
     * Enum representing the type of size change.
     */
    public enum TYPE {
        /** Increase one boundary of the dominion. */
        EXPAND,
        /** Decrease one boundary of the dominion. */
        CONTRACT
    }

    /**
     * Enum representing the direction of size change.
     */
    public enum DIRECTION {
        /** The negative z direction. */
        NORTH,
        /** The positive x direction. */
        EAST,
        /** The positive z direction. */
        SOUTH,
        /** The negative x direction. */
        WEST,
        /** The positive y direction. */
        UP,
        /** The negative y direction. */
        DOWN
    }

    private boolean skipEconomy;
    private final CuboidDTO oldCuboid;
    private final TYPE type;
    private DIRECTION direction;
    private int size;

    /**
     * Constructs a new DominionReSizeEvent.
     *
     * @param operator  the command sender who initiated the event
     * @param dominion  the dominion whose size is being changed
     * @param type      the type of the size change
     * @param direction the direction of the size change
     * @param size      the size of the size change
     */
    public DominionReSizeEvent(@NotNull CommandSender operator,
                               @NotNull DominionDTO dominion,
                               @NotNull TYPE type,
                               @NotNull DIRECTION direction,
                               int size) {
        super(operator, dominion);
        this.skipEconomy = false;
        this.oldCuboid = dominion.getCuboid();
        this.type = type;
        this.direction = direction;
        this.size = size;
    }

    /**
     * Sets whether to skip the economy check.
     *
     * @param skipEconomy true to skip the economy check, false otherwise
     */
    public void setSkipEconomy(boolean skipEconomy) {
        this.skipEconomy = skipEconomy;
    }

    /**
     * Checks if the economy check is skipped.
     *
     * @return true if the economy check is skipped, false otherwise
     */
    public boolean isSkipEconomy() {
        return skipEconomy;
    }

    /**
     * Gets a snapshot of the dominion cuboid before the change.
     *
     * @return the old cuboid
     */
    public CuboidDTO getOldCuboid() {
        return oldCuboid;
    }

    /**
     * Gets the type of the size change.
     *
     * @return the type of the size change
     */
    public TYPE getType() {
        return type;
    }

    /**
     * Gets the direction of the size change.
     *
     * @return the direction of the size change
     */
    public DIRECTION getDirection() {
        return direction;
    }

    /**
     * Gets the size of the size change.
     *
     * @return the size of the size change
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the direction of the size change.
     *
     * @param direction the direction of the size change
     */
    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    /**
     * Sets the size of the size change.
     *
     * @param size the size of the size change
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Calculates the cuboid that would result from the current resize values.
     * This method does not modify the dominion.
     *
     * @return the new cuboid
     */
    public CuboidDTO getNewCuboid() {
        CuboidDTO newCuboid = new CuboidDTO(getOldCuboid());
        int addSize = size * (type == TYPE.EXPAND ? 1 : -1);
        switch (direction) {
            case UP -> newCuboid.addUp(addSize);
            case DOWN -> newCuboid.addDown(addSize);
            case NORTH -> newCuboid.addNorth(addSize);
            case SOUTH -> newCuboid.addSouth(addSize);
            case EAST -> newCuboid.addEast(addSize);
            case WEST -> newCuboid.addWest(addSize);
        }
        return newCuboid;
    }

}
