package cn.lunadeer.dominion.api.dtos;

import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

/** A reusable set of member privilege values owned by a player. */
public interface TemplateDTO {
    @NotNull Integer getId();

    @NotNull UUID getCreator();

    @NotNull String getName();

    @NotNull Boolean getFlagValue(@NotNull PriFlag flag);

    @NotNull Map<PriFlag, Boolean> getFlagsValue();
}
