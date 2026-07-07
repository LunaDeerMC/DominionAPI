package cn.lunadeer.dominion.api.dtos;

import cn.lunadeer.dominion.api.dtos.flag.PrivilegeFlagDefinition;
import cn.lunadeer.dominion.api.dtos.flag.FlagValueSet;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

/**
 * Interface representing a Member Data Transfer Object (DTO).
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
     *
     * @param flag the flag
     * @return the value of the flag, or the default value if the flag does not exist
     * @deprecated use {@link #getFlagValue(PrivilegeFlagDefinition)} with {@code FlagDefinitions.X}.
     */
    @Deprecated
    @NotNull Boolean getFlagValue(PriFlag flag);

    @NotNull Boolean getFlagValue(@NotNull PrivilegeFlagDefinition flag);

    /**
     * Gets all flag values for the member.
     *
     * @return a map of flag values
     * @deprecated use {@link #getFlags()}.
     */
    @Deprecated
    @NotNull Map<PriFlag, Boolean> getFlagsValue();

    @NotNull FlagValueSet getFlags();

    /**
     * Sets the value of a specific flag for the member.
     * Returns the member object if successful, otherwise returns null.
     *
     * @param flag  the flag
     * @param value the value of the flag
     * @return the member object, or null if the operation fails
     * @throws SQLException if a database access error occurs
     * @deprecated use {@link #setFlagValue(PrivilegeFlagDefinition, Boolean)} with {@code FlagDefinitions.X}.
     */
    @Deprecated
    @Nullable MemberDTO setFlagValue(@NotNull PriFlag flag, @NotNull Boolean value) throws SQLException;

    @Nullable MemberDTO setFlagValue(@NotNull PrivilegeFlagDefinition flag, @NotNull Boolean value) throws SQLException;

    /**
     * Gets the player object associated with the member.
     *
     * @return the player object
     */
    @NotNull PlayerDTO getPlayer();
}
