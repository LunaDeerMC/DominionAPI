package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Event triggered when a player moves out of a dominion.
 */
public class PlayerMoveOutDominionEvent extends CallableEvent {

    private final Player player;
    private final DominionDTO dominion;

    /**
     * Constructs a new PlayerMoveOutDominionEvent.
     *
     * @param player   the player who moved out
     * @param dominion the dominion the player moved out of
     */
    public PlayerMoveOutDominionEvent(@NotNull Player player, @Nullable DominionDTO dominion) {
        this.player = player;
        this.dominion = dominion;
    }

    /**
     * Gets the player who moved out.
     *
     * @return the player
     */
    public @NotNull Player getPlayer() {
        return player;
    }

    /**
     * Gets the dominion the player moved out of.
     * <p>
     * It may be null when the event is fired because the dominion was deleted.
     *
     * @return the dominion
     */
    public @Nullable DominionDTO getDominion() {
        return dominion;
    }
}
