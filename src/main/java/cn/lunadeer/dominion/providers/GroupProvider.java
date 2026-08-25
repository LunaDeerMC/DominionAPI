package cn.lunadeer.dominion.providers;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * Provides asynchronous operations for creating, modifying, and managing groups
 * within dominions.
 * <p>
 * Groups allow dominion owners to organize players with similar permissions and manage their access
 * to the dominion collectively. Each group can have its own set of privilege flags that determine
 * what actions group members can perform within the dominion.
 * <p>
 * These methods are controlled by the Dominion system, including permission,
 * validation, cache, and event processing. A returned future normally completes
 * with the updated DTO and completes with {@code null} when the operation is
 * cancelled or fails.
 * <p>
 * The operator parameter of each method defines who triggers the operation. If the operator is a specific player,
 * these methods will check permissions accordingly. For no-permission-required operations, you can pass
 * the console command sender {@link org.bukkit.Bukkit#getConsoleSender()}.
 *
 * @since 4.6.0
 */
public abstract class GroupProvider {
    /** The provider instance initialized by Dominion. */
    protected static GroupProvider instance;

    /**
     * Gets the singleton instance of the GroupProvider.
     *
     * @return the current GroupProvider instance, or null if not initialized
     */
    public static GroupProvider getInstance() {
        return instance;
    }

    /**
     * Sets a privilege flag for a specific group within a dominion. Group flags control what actions
     * members of this group can perform within the dominion.
     *
     * @param operator the command sender performing this operation (for permission checks and logging)
     * @param dominion the dominion containing the group
     * @param group    the group whose flag will be updated
     * @param flag     the specific privilege flag to modify
     * @param newValue the new value for the flag (true to allow, false to deny)
     * @return a future that completes with the updated group, or {@code null} if
     *         the operation is cancelled or fails
     */
    public abstract CompletableFuture<GroupDTO> setGroupFlag(@NotNull CommandSender operator,
                                                             @NotNull DominionDTO dominion,
                                                             @NotNull GroupDTO group,
                                                             @NotNull PriFlag flag,
                                                             boolean newValue);

    /**
     * Creates a new group within the specified dominion.
     *
     * @param operator  the command sender performing this operation (for permission checks and logging)
     * @param dominion  the dominion where the group will be created
     * @param groupName the name of the new group (must be unique within the dominion)
     * @return a future that completes with the created group, or {@code null} if
     *         the operation is cancelled or fails
     */
    public abstract CompletableFuture<GroupDTO> createGroup(@NotNull CommandSender operator,
                                                            @NotNull DominionDTO dominion,
                                                            @NotNull String groupName);

    /**
     * Deletes an existing group from the specified dominion. All members will be removed
     * from the group when it is deleted.
     *
     * @param operator the command sender performing this operation (for permission checks and logging)
     * @param dominion the dominion containing the group to be deleted
     * @param group    the group to be deleted
     * @return a future that completes with the deleted group, or {@code null} if
     *         the operation is cancelled or fails
     */
    public abstract CompletableFuture<GroupDTO> deleteGroup(@NotNull CommandSender operator,
                                                            @NotNull DominionDTO dominion,
                                                            @NotNull GroupDTO group);

    /**
     * Renames an existing group within the specified dominion.
     *
     * @param operator the command sender performing this operation (for permission checks and logging)
     * @param dominion the dominion containing the group to be renamed
     * @param group    the group to be renamed
     * @param newName  the new name for the group (must be unique within the dominion)
     * @return a future that completes with the renamed group, or {@code null} if
     *         the operation is cancelled or fails
     */
    public abstract CompletableFuture<GroupDTO> renameGroup(@NotNull CommandSender operator,
                                                            @NotNull DominionDTO dominion,
                                                            @NotNull GroupDTO group,
                                                            @NotNull String newName);

    /**
     * Adds a member to the specified group within a dominion. The member will inherit
     * all privileges assigned to the group.
     *
     * @param operator the command sender performing this operation (for permission checks and logging)
     * @param dominion the dominion containing the group
     * @param group    the group to which the member will be added
     * @param member   the member to be added to the group
     * @return a future that completes with the updated member, or {@code null} if
     *         the operation is cancelled or fails
     */
    public abstract CompletableFuture<MemberDTO> addMember(@NotNull CommandSender operator,
                                                           @NotNull DominionDTO dominion,
                                                           @NotNull GroupDTO group,
                                                           @NotNull MemberDTO member);

    /**
     * Removes a member from the specified group within a dominion. The member will lose
     * all privileges that were granted through group membership, but may retain individual
     * member privileges if any were assigned directly.
     *
     * @param operator the command sender performing this operation (for permission checks and logging)
     * @param dominion the dominion containing the group
     * @param group    the group from which the member will be removed
     * @param member   the member to be removed from the group
     * @return a future that completes with the updated member, or {@code null} if
     *         the operation is cancelled or fails
     */
    public abstract CompletableFuture<MemberDTO> removeMember(@NotNull CommandSender operator,
                                                              @NotNull DominionDTO dominion,
                                                              @NotNull GroupDTO group,
                                                              @NotNull MemberDTO member);
}
