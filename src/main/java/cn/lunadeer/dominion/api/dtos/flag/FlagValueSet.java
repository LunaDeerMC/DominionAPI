package cn.lunadeer.dominion.api.dtos.flag;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class FlagValueSet {
    private final FlagDomain domain;
    private final Map<String, Boolean> values = new LinkedHashMap<>();

    public FlagValueSet(@NotNull FlagDomain domain) {
        this.domain = domain;
    }

    public FlagValueSet(@NotNull FlagDomain domain, Map<String, Boolean> values) {
        this.domain = domain;
        if (values != null) {
            this.values.putAll(values);
        }
    }

    public @NotNull FlagDomain getDomain() {
        return domain;
    }

    public boolean get(@NotNull FlagDefinition definition) {
        return get(definition.id(), definition.defaultValue());
    }

    /**
     * @deprecated use {@link #get(FlagDefinition)} for public API usage.
     */
    @Deprecated
    public boolean get(@NotNull String flagId) {
        FlagDefinition definition = FlagRegistry.defaultRegistry().getFlag(flagId);
        boolean fallback = definition == null ? false : definition.defaultValue();
        return get(flagId, fallback);
    }

    /**
     * @deprecated use {@link #get(FlagDefinition)} for public API usage.
     */
    @Deprecated
    public boolean get(@NotNull String flagId, boolean defaultValue) {
        return values.getOrDefault(flagId, defaultValue);
    }

    public void set(@NotNull FlagDefinition definition, boolean value) {
        set(definition.id(), value);
    }

    /**
     * @deprecated use {@link #set(FlagDefinition, boolean)} for public API usage.
     */
    @Deprecated
    public void set(@NotNull String flagId, boolean value) {
        values.put(flagId, value);
    }

    public void setAll(Iterable<? extends FlagDefinition> definitions, boolean value) {
        for (FlagDefinition definition : definitions) {
            set(definition, value);
        }
    }

    public @NotNull FlagGroupState getGroupState(@NotNull FlagGroupDefinition group) {
        boolean sawTrue = false;
        boolean sawFalse = false;
        for (FlagDefinition definition : group.children()) {
            if (get(definition)) {
                sawTrue = true;
            } else {
                sawFalse = true;
            }
            if (sawTrue && sawFalse) {
                return FlagGroupState.MIXED;
            }
        }
        return sawTrue ? FlagGroupState.ON : FlagGroupState.OFF;
    }

    public void setGroup(@NotNull FlagGroupDefinition group, boolean value) {
        setAll(group.children(), value);
    }

    public @NotNull Map<String, Boolean> explicitValues() {
        return Collections.unmodifiableMap(values);
    }

    public @NotNull FlagValueSet copy() {
        return new FlagValueSet(domain, values);
    }
}
