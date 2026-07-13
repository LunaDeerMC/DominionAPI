package cn.lunadeer.dominion.providers;

import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/** API operations for player data used by management surfaces. */
public abstract class PlayerProvider {
    protected static PlayerProvider instance;

    public static PlayerProvider getInstance() {
        return instance;
    }

    public abstract @NotNull List<PlayerDTO> getKnownPlayers();

    public abstract @NotNull List<GroupDTO> getAvailableGroupTitles(@NotNull UUID player);

    public abstract CompletableFuture<PlayerDTO> setGroupTitle(@NotNull Player operator,
                                                               @Nullable GroupDTO group);
}
