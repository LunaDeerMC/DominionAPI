package cn.lunadeer.dominion.api.dtos.flag;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static cn.lunadeer.dominion.api.dtos.flag.FlagDefinitions.*;

/**
 * Compatibility bridge from legacy {@link EnvFlag}/{@link PriFlag} values to new flag ids.
 *
 * @deprecated this is an internal compatibility layer for legacy APIs. New code should use
 * {@link FlagDefinitions}, {@link FlagRegistry}, and {@link FlagValueSet} directly.
 */
@Deprecated
public final class LegacyFlagBridge {
    private static final Map<String, List<EnvironmentFlagDefinition>> ENV_MAPPING = new LinkedHashMap<>();
    private static final Map<String, List<PrivilegeFlagDefinition>> PRI_MAPPING = new LinkedHashMap<>();

    static {
        env(Flags.ANIMAL_SPAWN, SPAWN_ANIMAL);
        env(Flags.ANIMAL_MOVE, MOVE_ANIMAL);
        env(Flags.VILLAGER_SPAWN, SPAWN_VILLAGER);
        env(Flags.MONSTER_SPAWN, SPAWN_MONSTER);
        env(Flags.MONSTER_MOVE, MOVE_MONSTER);
        env(Flags.MONSTER_DAMAGE, DAMAGE_PLAYER_BY_MONSTER_MELEE, DAMAGE_PLAYER_BY_MONSTER_PROJECTILE);
        env(Flags.ENDER_MAN, SPAWN_ENDERMAN, MOVE_BLOCK_BY_ENDERMAN, TELEPORT_ENDERMAN);
        env(Flags.TNT_EXPLODE, EXPLODE_TNT, EXPLODE_TNT_MINECART);
        env(Flags.WITHER_SPAWN, SPAWN_WITHER, EXPLODE_WITHER, BREAK_BLOCK_BY_WITHER);
        env(Flags.CREEPER_EXPLODE,
                EXPLODE_CREEPER, EXPLODE_WITHER_SKULL, EXPLODE_END_CRYSTAL, EXPLODE_FIREBALL,
                EXPLODE_SMALL_FIREBALL, EXPLODE_DRAGON_FIREBALL, EXPLODE_BED, EXPLODE_RESPAWN_ANCHOR,
                DAMAGE_ARMOR_STAND_BY_NON_PLAYER, DAMAGE_BOAT_BY_NON_PLAYER, DAMAGE_MINECART_BY_NON_PLAYER);
        env(Flags.DRAGON_BREAK_BLOCK, BREAK_BLOCK_BY_ENDER_DRAGON);
        env(Flags.FIRE_SPREAD, SPREAD_FIRE);
        env(Flags.BURN_BLOCK, BURN_BLOCK);
        env(Flags.BURN_ENTITY, BURN_ENTITY);
        env(Flags.FLOW_IN_PROTECTION, FLOW_LIQUID_INTO);
        env(Flags.GRAVITY_BLOCK, FALL_GRAVITY_BLOCK);
        env(Flags.ICE_MELT, MELT_ICE);
        env(Flags.ICE_FORM, FORM_ICE);
        env(Flags.SNOW_ACCUMULATION, ACCUMULATE_SNOW);
        env(Flags.SNOW_MELT, MELT_SNOW);
        env(Flags.TRAMPLE, TRAMPLE_FARMLAND_BY_PLAYER, TRAMPLE_FARMLAND_BY_MOB);
        env(Flags.DECAY, DECAY_LEAVES);
        env(Flags.HOPPER_OUTSIDE, TRANSFER_HOPPER_OUTSIDE);
        env(Flags.PISTON_OUTSIDE, PUSH_PISTON_CROSS_BORDER);
        env(Flags.TRIG_PRESSURE_PROJ, TRIGGER_PRESSURE_BY_PROJECTILE);
        env(Flags.TRIG_PRESSURE_MOB, TRIGGER_PRESSURE_BY_MOB);
        env(Flags.TRIG_PRESSURE_DROP, TRIGGER_PRESSURE_BY_ITEM);
        env(Flags.ITEM_FRAME_PROJ_DAMAGE, DAMAGE_ITEM_FRAME_BY_NON_PLAYER);
        env(Flags.MOB_DROP_ITEM, DROP_ITEM_BY_MOB);
        env(Flags.SHOW_BORDER, SHOW_BORDER);

        pri(Flags.ADMIN, MANAGE_MEMBERS, MANAGE_GROUPS, MANAGE_FLAGS);
        pri(Flags.MOVE, MOVE_PLAYER);
        pri(Flags.TELEPORT, TELEPORT_TO_DOMINION);
        pri(Flags.FLY, FLY_PLAYER);
        pri(Flags.RIDING, RIDE_VEHICLE);
        pri(Flags.ENDER_PEARL, THROW_ENDER_PEARL);
        pri(Flags.RAID, TRIGGER_RAID);
        pri(Flags.PLACE, PLACE_BLOCK, PLACE_LIQUID, PLACE_FLOWER_POT_ITEM, PLACE_ITEM_FRAME, PLACE_ARMOR_STAND);
        pri(Flags.BREAK_BLOCK, BREAK_BLOCK, BREAK_LIQUID, BREAK_FLOWER_POT_ITEM, BREAK_ITEM_FRAME, BREAK_ITEM_FRAME_BY_PROJECTILE, BREAK_ARMOR_STAND);
        pri(Flags.IGNITE, IGNITE_FIRE);
        pri(Flags.PICK_UP, PICKUP_ITEM);
        pri(Flags.DROP_ITEM, DROP_ITEM);
        pri(Flags.DOOR, USE_DOOR);
        pri(Flags.BUTTON, USE_BUTTON);
        pri(Flags.LEVER, USE_LEVER);
        pri(Flags.PRESSURE, TRIGGER_PRESSURE_PLATE);
        pri(Flags.REPEATER, USE_REPEATER);
        pri(Flags.COMPARER, USE_COMPARATOR);
        pri(Flags.NOTE_BLOCK, USE_NOTE_BLOCK);
        pri(Flags.CONTAINER, OPEN_CHEST, OPEN_BARREL, OPEN_SHULKER_BOX, OPEN_COPPER_CHEST, EDIT_ITEM_FRAME_ITEM, EDIT_ARMOR_STAND, USE_SHELF);
        pri(Flags.HOPPER, OPEN_HOPPER, OPEN_DROPPER, OPEN_DISPENSER, OPEN_FURNACE, OPEN_BLAST_FURNACE, OPEN_SMOKER);
        pri(Flags.CRAFT, USE_CRAFTING_TABLE);
        pri(Flags.CRAFTER, USE_CRAFTER);
        pri(Flags.ANVIL, USE_ANVIL);
        pri(Flags.ENCHANT, USE_ENCHANTING_TABLE);
        pri(Flags.BREW, USE_BREWING_STAND);
        pri(Flags.BEACON, USE_BEACON);
        pri(Flags.JUKEBOX, USE_JUKEBOX);
        pri(Flags.LECTERN, USE_LECTERN);
        pri(Flags.BOOKSHELF, USE_CHISELED_BOOKSHELF);
        pri(Flags.DRAGON_EGG, USE_DRAGON_EGG);
        pri(Flags.ITEM_FRAME_INTERACTIVE, ROTATE_ITEM_FRAME);
        pri(Flags.EDIT_SIGN, EDIT_SIGN);
        pri(Flags.BED, USE_BED);
        pri(Flags.ANCHOR, USE_RESPAWN_ANCHOR);
        pri(Flags.VEHICLE_SPAWN, SPAWN_VEHICLE);
        pri(Flags.VEHICLE_DESTROY, DESTROY_VEHICLE);
        pri(Flags.HARVEST, HARVEST_CROP, HARVEST_BLOCK);
        pri(Flags.SOWING, PLANT_CROP, PLANT_TREE, USE_FERTILIZER);
        pri(Flags.FEED, FEED_ANIMAL);
        pri(Flags.SHEAR, SHEAR_ENTITY);
        pri(Flags.LEASH, LEASH_ENTITY);
        pri(Flags.DYE, DYE_ENTITY);
        pri(Flags.HONEY, HARVEST_HONEY);
        pri(Flags.CAKE, EAT_CAKE);
        pri(Flags.TRADE, TRADE_VILLAGER);
        pri(Flags.SHOOT, SHOOT_ARROW, THROW_TRIDENT, SHOOT_FIREBALL, SHOOT_WIND_CHARGE);
        pri(Flags.EGG, THROW_EGG);
        pri(Flags.HOOK, USE_FISHING_HOOK);
        pri(Flags.PVP, DAMAGE_PLAYER_MELEE, DAMAGE_PLAYER_PROJECTILE, DAMAGE_PLAYER_EFFECT);
        pri(Flags.MONSTER_KILLING, DAMAGE_MONSTER);
        pri(Flags.ANIMAL_KILLING, DAMAGE_ANIMAL);
        pri(Flags.VILLAGER_KILLING, DAMAGE_VILLAGER);
    }

    private LegacyFlagBridge() {
    }

    public static @NotNull List<String> idsFor(@NotNull EnvFlag flag) {
        return definitionsFor(flag).stream().map(FlagDefinition::id).toList();
    }

    public static @NotNull List<String> idsFor(@NotNull PriFlag flag) {
        return definitionsFor(flag).stream().map(FlagDefinition::id).toList();
    }

    public static @NotNull List<EnvironmentFlagDefinition> definitionsFor(@NotNull EnvFlag flag) {
        return ENV_MAPPING.getOrDefault(flag.getFlagName(), List.of());
    }

    public static @NotNull List<PrivilegeFlagDefinition> definitionsFor(@NotNull PriFlag flag) {
        return PRI_MAPPING.getOrDefault(flag.getFlagName(), List.of());
    }

    public static @NotNull Map<String, List<EnvironmentFlagDefinition>> environmentMappings() {
        return Collections.unmodifiableMap(ENV_MAPPING);
    }

    public static @NotNull Map<String, List<PrivilegeFlagDefinition>> privilegeMappings() {
        return Collections.unmodifiableMap(PRI_MAPPING);
    }

    public static @Nullable EnvFlag legacyFor(@NotNull EnvironmentFlagDefinition definition) {
        for (EnvFlag flag : Flags.getAllEnvFlags()) {
            if (definitionsFor(flag).contains(definition)) {
                return flag;
            }
        }
        return null;
    }

    public static @Nullable PriFlag legacyFor(@NotNull PrivilegeFlagDefinition definition) {
        for (PriFlag flag : Flags.getAllPriFlags()) {
            if (definitionsFor(flag).contains(definition)) {
                return flag;
            }
        }
        return null;
    }

    public static boolean get(@NotNull FlagValueSet values, @NotNull EnvFlag flag) {
        return get(values, definitionsFor(flag), flag.getDefaultValue());
    }

    public static boolean get(@NotNull FlagValueSet values, @NotNull PriFlag flag) {
        return get(values, definitionsFor(flag), flag.getDefaultValue());
    }

    public static void set(@NotNull FlagValueSet values, @NotNull EnvFlag flag, boolean value) {
        values.setAll(definitionsFor(flag), value);
    }

    public static void set(@NotNull FlagValueSet values, @NotNull PriFlag flag, boolean value) {
        values.setAll(definitionsFor(flag), value);
    }

    public static @NotNull Map<EnvFlag, Boolean> envView(@NotNull FlagValueSet values) {
        Map<EnvFlag, Boolean> result = new LinkedHashMap<>();
        for (EnvFlag flag : Flags.getAllEnvFlagsEnable()) {
            result.put(flag, get(values, flag));
        }
        return result;
    }

    public static @NotNull Map<PriFlag, Boolean> priView(@NotNull FlagValueSet values) {
        Map<PriFlag, Boolean> result = new LinkedHashMap<>();
        for (PriFlag flag : Flags.getAllPriFlagsEnable()) {
            result.put(flag, get(values, flag));
        }
        return result;
    }

    public static @NotNull FlagValueSet envValuesFromLegacy(Map<EnvFlag, Boolean> flags) {
        FlagValueSet values = new FlagValueSet(FlagDomain.ENVIRONMENT);
        if (flags != null) {
            for (Map.Entry<EnvFlag, Boolean> entry : flags.entrySet()) {
                if (entry.getValue() != null) {
                    set(values, entry.getKey(), entry.getValue());
                }
            }
        }
        return values;
    }

    public static @NotNull FlagValueSet priValuesFromLegacy(Map<PriFlag, Boolean> flags) {
        FlagValueSet values = new FlagValueSet(FlagDomain.PRIVILEGE);
        if (flags != null) {
            for (Map.Entry<PriFlag, Boolean> entry : flags.entrySet()) {
                if (entry.getValue() != null) {
                    set(values, entry.getKey(), entry.getValue());
                }
            }
        }
        return values;
    }

    private static boolean get(FlagValueSet values, List<? extends FlagDefinition> definitions, boolean defaultValue) {
        if (definitions.isEmpty()) {
            return defaultValue;
        }
        for (FlagDefinition definition : definitions) {
            if (!values.get(definition.id())) {
                return false;
            }
        }
        return true;
    }

    private static void env(EnvFlag flag, EnvironmentFlagDefinition... definitions) {
        ENV_MAPPING.put(flag.getFlagName(), List.of(definitions));
    }

    private static void pri(PriFlag flag, PrivilegeFlagDefinition... definitions) {
        PRI_MAPPING.put(flag.getFlagName(), List.of(definitions));
    }
}
