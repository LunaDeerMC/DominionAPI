package cn.lunadeer.dominion.providers;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.TemplateDTO;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API operations for player-owned privilege templates.
 * <p>
 * Template lookups are synchronous cache/database reads. Mutations are
 * asynchronous and complete with the affected DTO, or {@code null} when the
 * operation is rejected or fails.
 */
public abstract class TemplateProvider {
    /** The provider instance initialized by Dominion. */
    protected static TemplateProvider instance;

    /**
     * Gets the initialized provider instance.
     *
     * @return the provider, or {@code null} before Dominion initialization
     */
    public static TemplateProvider getInstance() {
        return instance;
    }

    /**
     * Gets all templates owned by a player.
     *
     * @param creator the owner's UUID
     * @return the owner's templates, or an empty list when none are available
     */
    public abstract @NotNull List<TemplateDTO> getTemplates(@NotNull UUID creator);

    /**
     * Looks up a template by owner and name.
     *
     * @param creator the owner's UUID
     * @param name    the template name
     * @return the matching template, or {@code null} when it does not exist
     */
    public abstract @Nullable TemplateDTO getTemplate(@NotNull UUID creator, @NotNull String name);

    /**
     * Looks up a template by owner and numeric identifier.
     *
     * @param creator the owner's UUID
     * @param id      the template identifier
     * @return the matching template, or {@code null} when it does not exist
     */
    public abstract @Nullable TemplateDTO getTemplate(@NotNull UUID creator, @NotNull Integer id);

    /**
     * Creates a template owned by the operator.
     *
     * @param operator the player creating the template
     * @param name     the new template name
     * @return a future that completes with the created template, or {@code null}
     *         when validation or persistence fails
     */
    public abstract CompletableFuture<TemplateDTO> createTemplate(@NotNull Player operator, @NotNull String name);

    /**
     * Renames a template owned by the operator.
     *
     * @param operator the template owner
     * @param template the template to rename
     * @param newName  the new template name
     * @return a future that completes with the renamed template, or {@code null}
     *         when validation or ownership checks fail
     */
    public abstract CompletableFuture<TemplateDTO> renameTemplate(@NotNull Player operator,
                                                                   @NotNull TemplateDTO template,
                                                                   @NotNull String newName);

    /**
     * Deletes a template owned by the operator.
     *
     * @param operator the template owner
     * @param template the template to delete
     * @return a future that completes with the deleted template, or {@code null}
     *         when the operation fails
     */
    public abstract CompletableFuture<TemplateDTO> deleteTemplate(@NotNull Player operator,
                                                                   @NotNull TemplateDTO template);

    /**
     * Sets a privilege value in a template owned by the operator.
     *
     * @param operator the template owner
     * @param template the template to update
     * @param flag     the privilege flag
     * @param value    the new value
     * @return a future that completes with the updated template, or {@code null}
     *         when the operation fails
     */
    public abstract CompletableFuture<TemplateDTO> setTemplateFlag(@NotNull Player operator,
                                                                    @NotNull TemplateDTO template,
                                                                    @NotNull PriFlag flag,
                                                                    boolean value);

    /**
     * Applies a template's privilege values to a dominion member.
     * The operator must own the template and have the required dominion
     * management privilege.
     *
     * @param operator the player applying the template
     * @param dominion the dominion containing the member
     * @param member   the member to update
     * @param template the template to apply
     * @return a future that completes with the updated member, or {@code null}
     *         when authorization or persistence fails
     */
    public abstract CompletableFuture<MemberDTO> applyTemplate(@NotNull Player operator,
                                                                @NotNull DominionDTO dominion,
                                                                @NotNull MemberDTO member,
                                                                @NotNull TemplateDTO template);
}
