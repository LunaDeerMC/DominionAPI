package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.dtos.flag.Flag;
import org.bukkit.event.Cancellable;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @deprecated legacy custom flag registration event for {@link Flag}. Register new flags through
 * {@code FlagRegistry} with {@code FlagDefinition}.
 */
@Deprecated
public class FlagRegisterEvent extends CallableEvent implements Cancellable {

    private final JavaPlugin plugin;
    private Flag flag;

    @Deprecated
    public FlagRegisterEvent(JavaPlugin plugin, Flag flag) {
        this.plugin = plugin;
        this.flag = flag;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    @Deprecated
    public Flag getFlag() {
        return flag;
    }

    @Deprecated
    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    boolean cancelled;

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
