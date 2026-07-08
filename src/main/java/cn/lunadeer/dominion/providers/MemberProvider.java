package cn.lunadeer.dominion.providers;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import cn.lunadeer.dominion.api.dtos.flag.PrivilegeFlagDefinition;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * This class provides the API interface for creating, modifying, and managing members within dominions.
 * All operations are asynchronous and return CompletableFuture objects for non-blocking execution.
 * <p>
 * Members are players who have been granted specific access permissions to a dominion. Each member
 * can have individual privilege flags that determine what actions they can perform within the dominion.
 * Members can also be part of groups, inheriting additional privileges from their group membership.
 * <p>
 * These methods are controlled by the Dominion system so they are safe to use in any context.
 * <p>
 * The operator parameter of each method defines who triggers the operation. If the operator is a specific player,
 * these methods will check permissions accordingly. For no-permission-required operations, you can pass
 * the console command sender {@link org.bukkit.Bukkit#getConsoleSender()}.
 *
 * @since 4.6.0
 */
public abstract class MemberProvider {
    protected static MemberProvider instance;

    /**
     * Gets the singleton instance of the MemberProvider.
     *
     * @return the current MemberProvider instance, or null if not initialized
     */
    public static MemberProvider getInstance() {
        return instance;
    }

    /**
     * Sets a privilege flag for a specific member within a dominion.
     *
     * @param operator the command sender performing this operation
     * @param dominion the dominion containing the member
     * @param member   the member whose flag will be updated
     * @param flag     the privilege flag definition to modify
     * @param newValue the new value for the flag
     * @return a CompletableFuture that resolves to the updated MemberDTO.
     * Use {@link CompletableFuture#get()} to get the result if null meaning the operation failed.
     */
    public abstract CompletableFuture<MemberDTO> setMemberFlag(@NotNull CommandSender operator,
                                                               @NotNull DominionDTO dominion,
                                                               @NotNull MemberDTO member,
                                                               @NotNull PrivilegeFlagDefinition flag,
                                                               boolean newValue);

    /**
     * Sets a privilege flag for a specific member within a dominion. Member flags control what actions
     * this individual member can perform within the dominion, independent of any group memberships.
     *
     * @param operator the command sender performing this operation (for permission checks and logging)
     * @param dominion the dominion containing the member
     * @param member   the member whose flag will be updated
     * @param flag     the specific privilege flag to modify
     * @param newValue the new value for the flag (true to allow, false to deny)
     * @return a CompletableFuture that resolves to the updated MemberDTO.
     * Use {@link CompletableFuture#get()} to get the result if null meaning the operation failed.
     * @deprecated use {@link #setMemberFlag(CommandSender, DominionDTO, MemberDTO, PrivilegeFlagDefinition, boolean)}
     * with {@code FlagDefinitions.X}.
     */
    @Deprecated
    public abstract CompletableFuture<MemberDTO> setMemberFlag(@NotNull CommandSender operator,
                                                               @NotNull DominionDTO dominion,
                                                               @NotNull MemberDTO member,
                                                               @NotNull PriFlag flag,
                                                               boolean newValue);

    /**
     * Adds a new member to the specified dominion. The player will be granted basic access to the dominion
     * and can then be assigned specific privileges or added to groups.
     *
     * @param operator the command sender performing this operation (for permission checks and logging)
     * @param dominion the dominion where the player will be added as a member
     * @param player   the player to be added as a member to the dominion
     * @return a CompletableFuture that resolves to the created MemberDTO.
     * Use {@link CompletableFuture#get()} to get the result if null meaning the operation failed.
     */
    public abstract CompletableFuture<MemberDTO> addMember(@NotNull CommandSender operator,
                                                           @NotNull DominionDTO dominion,
                                                           @NotNull PlayerDTO player);

    /**
     * Removes an existing member from the specified dominion. The member will lose all individual privileges
     * and group memberships within this dominion. This action is irreversible.
     *
     * @param operator the command sender performing this operation (for permission checks and logging)
     * @param dominion the dominion from which the member will be removed
     * @param member   the member to be removed from the dominion
     * @return a CompletableFuture that resolves to the removed MemberDTO.
     * Use {@link CompletableFuture#get()} to get the result if null meaning the operation failed.
     */
    public abstract CompletableFuture<MemberDTO> removeMember(@NotNull CommandSender operator,
                                                              @NotNull DominionDTO dominion,
                                                              @NotNull MemberDTO member);

}
