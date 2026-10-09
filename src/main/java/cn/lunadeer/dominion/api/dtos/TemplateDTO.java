package cn.lunadeer.dominion.api.dtos;

import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

/**
 * A reusable set of member privilege values owned by a player.
 * <p>
 * Templates can be applied to a member through
 * {@link cn.lunadeer.dominion.providers.TemplateProvider}.
 */
public interface TemplateDTO {
    /**
     * Gets the template identifier.
     *
     * @return the template identifier
     */
    @NotNull Integer getId();

    /**
     * Gets the UUID of the player who owns the template.
     *
     * @return the creator's UUID
     */
    @NotNull UUID getCreator();

    /**
     * Gets the template name.
     *
     * @return the template name
     */
    @NotNull String getName();

    /**
     * Gets the value of a privilege flag in this template.
     * Legacy aliases read their replacement and use its default when no value is stored.
     *
     * @param flag the privilege flag
     * @return the configured value, or the flag's default value when no value is stored
     */
    @NotNull Boolean getFlagValue(@NotNull PriFlag flag);

    /**
     * Gets a snapshot of all explicitly stored privilege values in this template.
     * The snapshot includes read-only legacy aliases for stored replacement flags;
     * each alias has its replacement's value at the time of this call.
     * Later template changes do not update the returned map.
     *
     * @return an unmodifiable snapshot, including read-only legacy aliases
     */
    @NotNull Map<PriFlag, Boolean> getFlagsValue();
}
