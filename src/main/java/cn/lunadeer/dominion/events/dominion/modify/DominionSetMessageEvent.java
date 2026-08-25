package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a message is set for a Dominion in the Dominion system.
 */
public class DominionSetMessageEvent extends DominionModifyEvent {

    /**
     * Enum representing the type of message being set.
     */
    public enum TYPE {
        /** Message sent when entering the dominion. */
        ENTER,
        /** Message sent when leaving the dominion. */
        LEAVE
    }

    private final String oldMessage;
    private final TYPE type;
    private String newMessage;

    /**
     * Constructs a new DominionSetMessageEvent.
     *
     * @param operator   the command sender who initiated the event
     * @param dominion   the dominion for which the message is being set
     * @param type       the type of the message being set
     * @param newMessage the new message content
     */
    public DominionSetMessageEvent(@NotNull CommandSender operator,
                                   @NotNull DominionDTO dominion,
                                   @NotNull DominionSetMessageEvent.TYPE type,
                                   @NotNull String newMessage) {
        super(operator, dominion);
        this.oldMessage = type == TYPE.ENTER ? dominion.getJoinMessage() : dominion.getLeaveMessage();
        this.type = type;
        this.newMessage = newMessage;
    }

    /**
     * Gets the old message content.
     *
     * @return the old message content
     */
    public @NotNull String getOldMessage() {
        return oldMessage;
    }

    /**
     * Gets the type of the message being set.
     *
     * @return the type of the message
     */
    public @NotNull DominionSetMessageEvent.TYPE getType() {
        return type;
    }

    /**
     * Gets the new message content.
     *
     * @return the new message content
     */
    public @NotNull String getNewMessage() {
        return newMessage;
    }

    /**
     * Sets the new message content.
     * <p>
     * Changes made in {@link org.bukkit.event.EventPriority} HIGH or higher {@link org.bukkit.event.EventHandler} will not take effect.
     * (Default is {@link org.bukkit.event.EventPriority#NORMAL})
     *
     * @param newMessage the new message content
     */
    public void setNewMessage(@NotNull String newMessage) {
        this.newMessage = newMessage;
    }
}
