package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.dtos.flag.Flag;
import org.bukkit.event.Cancellable;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Fired before a custom flag is registered.
 * <p>
 * Listeners may replace the flag with {@link #setFlag(Flag)} or cancel the
 * event to reject registration.
 */
public class FlagRegisterEvent extends CallableEvent implements Cancellable {

    private final JavaPlugin plugin;
    private Flag flag;

    /**
     * Creates a flag registration event.
     *
     * @param plugin the plugin requesting registration
     * @param flag   the flag proposed for registration
     */
    public FlagRegisterEvent(JavaPlugin plugin, Flag flag) {
        this.plugin = plugin;
        this.flag = flag;
    }

    /**
     * Gets the plugin requesting registration.
     *
     * @return the requesting plugin
     */
    public JavaPlugin getPlugin() {
        return plugin;
    }

    /**
     * Gets the flag currently proposed for registration.
     *
     * @return the proposed flag
     */
    public Flag getFlag() {
        return flag;
    }

    /**
     * Replaces the flag proposed for registration.
     *
     * @param flag the replacement flag
     */
    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    boolean cancelled;

    /**
     * Checks whether registration has been cancelled.
     *
     * @return {@code true} when the flag must not be registered
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets whether registration is cancelled.
     *
     * @param cancel {@code true} to reject registration
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
