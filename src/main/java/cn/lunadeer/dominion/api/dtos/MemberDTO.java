package cn.lunadeer.dominion.api.dtos;

import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

/**
 * Public view of a player's membership in a dominion.
 * <p>
 * A member can have individual privilege values and can optionally belong to
 * a group whose privileges are evaluated alongside those values.
 */
public interface MemberDTO {
    /**
     * Gets the member ID.
     *
     * @return the member ID
     */
    Integer getId();

    /**
     * Gets the member UUID.
     *
     * @return the member UUID
     */
    UUID getPlayerUUID();

    /**
     * Gets the ID of the dominion to which the member belongs.
     *
     * @return the dominion ID
     */
    Integer getDomID();

    /**
     * Gets the ID of the group to which the member belongs.
     *
     * @return the group ID, or -1 if the member does not belong to any group
     */
    Integer getGroupId();

    /**
     * Gets the value of a specific flag for the member.
     * Legacy aliases read their replacement and use its default when no value is stored.
     *
     * @param flag the flag
     * @return the value of the flag, or the default value if the flag does not exist
     */
    @NotNull Boolean getFlagValue(PriFlag flag);

    /**
     * Gets all flag values for the member.
     * <p>
     * The returned map is a live view. Legacy alias keys are present whenever
     * their replacement has a stored value, and always read that value.
     * Active entries remain mutable; writes through legacy keys throw
     * {@link UnsupportedOperationException}.
     *
     * Collection views cannot remove entries; use map operations with active keys instead.
     * @return a live map of flag values, including read-only legacy aliases
     */
    @NotNull Map<PriFlag, Boolean> getFlagsValue();

    /**
     * Sets the value of a specific privilege flag for the member.
     *
     * @param flag  the flag
     * @param value the value of the flag
     * @return this member after the flag has been updated
     * @throws IllegalArgumentException if the flag is a read-only legacy alias
     * @throws SQLException if a database access error occurs
     */
    @Nullable MemberDTO setFlagValue(@NotNull PriFlag flag, @NotNull Boolean value) throws SQLException;

    /**
     * Gets the player object associated with the member.
     *
     * @return the player object
     */
    @NotNull PlayerDTO getPlayer();
}
