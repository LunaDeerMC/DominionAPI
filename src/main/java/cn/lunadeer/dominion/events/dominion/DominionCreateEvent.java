package cn.lunadeer.dominion.events.dominion;

import cn.lunadeer.dominion.api.dtos.CuboidDTO;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Event triggered when a Dominion is created in the Dominion system.
 * Setting setSkipEconomy(true) can skip the economic system processing.
 */
public class DominionCreateEvent extends ResultEvent {

    private boolean skipEconomy;
    private String name;
    /** The world in which the dominion will be created. */
    public World world;
    private CuboidDTO cuboid;
    private DominionDTO parent;
    private UUID owner;
    private final CompletableFuture<DominionDTO> future = new CompletableFuture<>();

    /**
     * Constructs a new DominionCreateEvent.
     *
     * @param operator the command sender who initiated the event
     * @param name     the name of the dominion
     * @param owner    the owner of the dominion
     * @param world    the world where the dominion is located
     * @param cuboid   the cuboid representing the dominion's boundaries
     * @param parent   the parent dominion, or null if there is no parent
     */
    public DominionCreateEvent(@NotNull CommandSender operator,
                               @NotNull String name, @NotNull UUID owner,
                               @NotNull World world, @NotNull CuboidDTO cuboid,
                               @Nullable DominionDTO parent) {
        super(operator);
        this.skipEconomy = false;
        this.name = name;
        this.world = world;
        this.cuboid = cuboid;
        this.parent = parent;
        this.owner = owner;
    }

    /**
     * Sets whether to skip the economic system processing.
     *
     * @param skipEconomy true to skip the economic system processing, false otherwise
     */
    public void setSkipEconomy(boolean skipEconomy) {
        this.skipEconomy = skipEconomy;
    }

    /**
     * Gets whether the economic system processing is skipped.
     *
     * @return true if the economic system processing is skipped, false otherwise
     */
    public boolean isSkipEconomy() {
        return skipEconomy;
    }

    /**
     * Gets the name of the dominion.
     *
     * @return the name of the dominion
     */
    public @NotNull String getName() {
        return name;
    }

    /**
     * Sets the name of the dominion.
     *
     * @param name the name of the dominion
     */
    public void setName(@NotNull String name) {
        this.name = name;
    }

    /**
     * Gets the cuboid representing the dominion's boundaries.
     *
     * @return the cuboid representing the dominion's boundaries
     */
    public @NotNull CuboidDTO getCuboid() {
        return cuboid;
    }

    /**
     * Sets the cuboid representing the dominion's boundaries.
     *
     * @param cuboid the cuboid representing the dominion's boundaries
     */
    public void setCuboid(@NotNull CuboidDTO cuboid) {
        this.cuboid = cuboid;
    }

    /**
     * Gets the world where the dominion is located.
     *
     * @return the world where the dominion is located
     */
    public @NotNull World getWorld() {
        return world;
    }

    /**
     * Sets the world where the dominion is located.
     *
     * @param world the world where the dominion is located
     */
    public void setWorld(@NotNull World world) {
        this.world = world;
    }

    /**
     * Gets the parent dominion, or null if there is no parent.
     *
     * @return the parent dominion, or null if there is no parent
     */
    public @Nullable DominionDTO getParent() {
        return parent;
    }

    /**
     * Sets the parent dominion.
     *
     * @param parent the parent dominion
     */
    public void setParent(@Nullable DominionDTO parent) {
        this.parent = parent;
    }

    /**
     * Gets the owner of the dominion.
     *
     * @return the owner of the dominion
     */
    public @NotNull UUID getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the dominion.
     *
     * @param owner the owner of the dominion
     */
    public void setOwner(@NotNull UUID owner) {
        this.owner = owner;
    }

    /**
     * Gets the future that will be completed with the created dominion.
     * <p>
     * Under most circumstances, you should not need to use this method directly. If you
     * need to perform actions after the dominion is created, you should use the
     * {@link #afterCreated(Consumer)} method instead.
     *
     * @return the future; its result is the created dominion, or {@code null} when
     *         the operation fails
     */
    public CompletableFuture<DominionDTO> getFutureToComplete() {
        return future;
    }

    /**
     * Registers a callback to run after the dominion creation operation finishes.
     * <p>
     * The callback receives the created dominion, or {@code null} when the
     * operation fails.
     *
     * @param consumer the consumer to handle the created dominion
     * @return a future that completes when the consumer has been executed
     */
    public CompletableFuture<Void> afterCreated(Consumer<DominionDTO> consumer) {
        return future.thenAccept(consumer);
    }

    /**
     * This compatibility method is a no-op and always returns {@code null}.
     * Use {@link #afterCreated(Consumer)} to observe the asynchronous result.
     *
     * @return always {@code null}
     * @deprecated since 4.6.0; use {@link #afterCreated(Consumer)} instead
     */
    @Deprecated(since = "4.6.0", forRemoval = true)
    public @Nullable DominionDTO getDominion() {
        return null;
    }

    /**
     * This compatibility method does nothing; the created dominion is delivered
     * through {@link #afterCreated(Consumer)}.
     *
     * @param dominion ignored
     * @deprecated since 4.6.0; use {@link #afterCreated(Consumer)} instead
     */
    @Deprecated(since = "4.6.0", forRemoval = true)
    public void setDominion(@NotNull DominionDTO dominion) {
    }
}
