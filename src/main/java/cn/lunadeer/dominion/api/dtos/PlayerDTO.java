package cn.lunadeer.dominion.api.dtos;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Public view of a player record stored by Dominion.
 * <p>
 * Player records contain the last known profile information used by the API;
 * they do not require the player to be online.
 */
public interface PlayerDTO {
    /**
     * Gets the ID of the player.
     *
     * @return the ID of the player
     */
    Integer getId();

    /**
     * Gets the UUID of the player.
     *
     * @return the UUID of the player
     */
    UUID getUuid();

    /**
     * Gets the last known name of the player.
     *
     * @return the last known name of the player
     */
    String getLastKnownName();

    /**
     * Updates the last known name and skin URL of the player.
     *
     * @param name the new last known name of the player
     * @param skinUrl the new skin URL, or {@code null} to use the default skin
     * @return this player record after the profile has been updated
     * @throws SQLException if the profile cannot be persisted
     * @throws MalformedURLException if the supplied or default skin URL is invalid
     */
    PlayerDTO updateLastKnownName(@NotNull String name, @Nullable URL skinUrl) throws SQLException, MalformedURLException;

    /**
     * Gets the ID of the group title the player is using.
     *
     * @return the ID of the group title the player is using
     */
    Integer getUsingGroupTitleID();

    /**
     * Gets the URL of the player's skin.
     * <p>
     * Implementations may return a default skin URL when no custom skin is stored.
     *
     * @return the URL of the player's skin
     * @throws MalformedURLException if the stored skin URL is malformed
     */
    @NotNull URL getSkinUrl() throws MalformedURLException;

    /**
     * Placeholder record used when a player cannot be resolved from the cache.
     * Its numeric identifiers are {@code -1}, its UUID is the all-zero UUID,
     * and its name is {@code "Unknown"}.
     */
    public static PlayerDTO UNKNOWN = new PlayerDTO() {
        @Override
        public Integer getId() {
            return -1;
        }

        @Override
        public UUID getUuid() {
            return new UUID(0, 0);
        }

        @Override
        public String getLastKnownName() {
            return "Unknown";
        }

        @Override
        public PlayerDTO updateLastKnownName(@NotNull String name, @Nullable URL skinUrl) {
            return this;
        }

        @Override
        public Integer getUsingGroupTitleID() {
            return -1;
        }

        @Override
        public @NotNull URL getSkinUrl() throws MalformedURLException {
            return new URL("https://example.com/default-skin.png");
        }
    };

}
