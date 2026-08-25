package cn.lunadeer.dominion.providers;

import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API operations for player data and group-title selection.
 * <p>
 * Read operations return snapshots. The title mutation is asynchronous and
 * completes with the updated player record, or {@code null} when validation or
 * permission checks fail.
 */
public abstract class PlayerProvider {
    /** The provider instance initialized by Dominion. */
    protected static PlayerProvider instance;

    /**
     * Gets the initialized provider instance.
     *
     * @return the provider, or {@code null} before Dominion initialization
     */
    public static PlayerProvider getInstance() {
        return instance;
    }

    /**
     * Gets all player records known to Dominion.
     *
     * @return known players, sorted by last known name
     */
    public abstract @NotNull List<PlayerDTO> getKnownPlayers();

    /**
     * Gets group titles available to a player.
     * <p>
     * This includes titles granted through memberships and titles from the
     * player's own dominions.
     *
     * @param player the player's UUID
     * @return available group titles, sorted by plain group name
     */
    public abstract @NotNull List<GroupDTO> getAvailableGroupTitles(@NotNull UUID player);

    /**
     * Selects or clears the group title displayed for the operator.
     * Passing {@code null} clears the currently selected title.
     *
     * @param operator the player selecting the title
     * @param group    the title to select, or {@code null} to clear it
     * @return a future that completes with the updated player record, or
     *         {@code null} if the title cannot be selected
     */
    public abstract CompletableFuture<PlayerDTO> setGroupTitle(@NotNull Player operator,
                                                                @Nullable GroupDTO group);
}
