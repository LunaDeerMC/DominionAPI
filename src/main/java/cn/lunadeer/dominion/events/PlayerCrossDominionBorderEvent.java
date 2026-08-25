package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Event triggered when a player crosses a dominion border, which includes entering, leaving, or moving from one dominion to another.
 * When a player moves from a location without a dominion to inside a dominion, `from` is null.
 * When a player moves from inside a dominion to a location without a dominion, `to` is null.
 * At least one of `from` and `to` is normally non-null; when both are non-null,
 * they represent different dominions.
 * For listening to player entering dominion events, refer to {@link PlayerMoveInDominionEvent}.
 * For listening to player leaving dominion events, refer to {@link PlayerMoveOutDominionEvent}.
 */
public class PlayerCrossDominionBorderEvent extends CallableEvent {

    private final Player player;
    private final DominionDTO from;
    private final DominionDTO to;

    /**
     * Constructs a new PlayerCrossDominionBorderEvent.
     *
     * @param player the player who crossed the border
     * @param from   the dominion the player moved from, null if the player entered a dominion
     * @param to     the dominion the player moved to, null if the player left a dominion
     */
    public PlayerCrossDominionBorderEvent(@NotNull Player player, @Nullable DominionDTO from, @Nullable DominionDTO to) {
        this.player = player;
        this.from = from;
        this.to = to;
    }

    /**
     * Gets the player who crossed the border.
     *
     * @return the player
     */
    public @NotNull Player getPlayer() {
        return player;
    }

    /**
     * Gets the dominion the player moved from.
     *
     * @return the dominion, or null if the player entered a dominion
     */
    public @Nullable DominionDTO getFrom() {
        return from;
    }

    /**
     * Gets the dominion the player moved to.
     *
     * @return the dominion, or null if the player left a dominion
     */
    public @Nullable DominionDTO getTo() {
        return to;
    }

}
