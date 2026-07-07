package cn.lunadeer.dominion.api.dtos.flag;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public record FlagGroupDefinition(
        @NotNull String id,
        @NotNull FlagDomain domain,
        @NotNull String displayName,
        @NotNull String description,
        @NotNull List<FlagDefinition> children
) {
    public FlagGroupDefinition {
        children = List.copyOf(children);
    }

    public @NotNull List<String> childIds() {
        return children.stream().map(FlagDefinition::id).collect(Collectors.toUnmodifiableList());
    }
}
