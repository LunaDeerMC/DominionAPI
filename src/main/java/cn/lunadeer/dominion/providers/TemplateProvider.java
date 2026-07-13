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

/** API operations for player-owned privilege templates. */
public abstract class TemplateProvider {
    protected static TemplateProvider instance;

    public static TemplateProvider getInstance() {
        return instance;
    }

    public abstract @NotNull List<TemplateDTO> getTemplates(@NotNull UUID creator);

    public abstract @Nullable TemplateDTO getTemplate(@NotNull UUID creator, @NotNull String name);

    public abstract @Nullable TemplateDTO getTemplate(@NotNull UUID creator, @NotNull Integer id);

    public abstract CompletableFuture<TemplateDTO> createTemplate(@NotNull Player operator, @NotNull String name);

    public abstract CompletableFuture<TemplateDTO> renameTemplate(@NotNull Player operator,
                                                                   @NotNull TemplateDTO template,
                                                                   @NotNull String newName);

    public abstract CompletableFuture<TemplateDTO> deleteTemplate(@NotNull Player operator,
                                                                   @NotNull TemplateDTO template);

    public abstract CompletableFuture<TemplateDTO> setTemplateFlag(@NotNull Player operator,
                                                                    @NotNull TemplateDTO template,
                                                                    @NotNull PriFlag flag,
                                                                    boolean value);

    public abstract CompletableFuture<MemberDTO> applyTemplate(@NotNull Player operator,
                                                                @NotNull DominionDTO dominion,
                                                                @NotNull MemberDTO member,
                                                                @NotNull TemplateDTO template);
}
