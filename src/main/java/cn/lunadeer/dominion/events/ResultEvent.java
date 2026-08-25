package cn.lunadeer.dominion.events;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;

/**
 * Base event for an operation initiated by a command sender.
 * <p>
 * Subclasses are cancellable and can use the operator for permission checks,
 * notifications, or audit logging.
 */
public class ResultEvent extends CallableEvent implements Cancellable {

    private boolean cancelled;

    private final CommandSender operator;

    /**
     * Constructs a new ResultEvent.
     *
     * @param operator the command sender who initiated the event
     */
    public ResultEvent(CommandSender operator) {
        this.operator = operator;
        this.cancelled = false;
    }

    /**
     * Gets the command sender who initiated the event.
     *
     * @return the command sender
     */
    public CommandSender getOperator() {
        return operator;
    }

    /**
     * Checks if the event is cancelled.
     *
     * @return true if the event is cancelled, false otherwise
     */
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    /**
     * Sets the cancellation state of the event.
     *
     * @param b true to cancel the event, false to uncancel
     */
    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }
}
