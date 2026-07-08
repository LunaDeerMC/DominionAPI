package cn.lunadeer.dominion.api.dtos.flag;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static cn.lunadeer.dominion.api.dtos.flag.FlagDefinitions.*;

public class FlagRegistry {
    private static FlagRegistry defaultRegistry;

    private final Map<String, FlagDefinition> flags = new LinkedHashMap<>();
    private final Map<String, FlagGroupDefinition> groups = new LinkedHashMap<>();

    public static synchronized @NotNull FlagRegistry defaultRegistry() {
        if (defaultRegistry == null) {
            defaultRegistry = createDefault();
        }
        return defaultRegistry;
    }

    public static synchronized void resetDefaultRegistry() {
        defaultRegistry = null;
    }

    public void registerFlag(@NotNull FlagDefinition definition) {
        if (flags.containsKey(definition.id())) {
            throw new IllegalArgumentException("Duplicate flag id: " + definition.id());
        }
        flags.put(definition.id(), definition);
    }

    public void registerGroup(@NotNull FlagGroupDefinition group) {
        if (groups.containsKey(group.id())) {
            throw new IllegalArgumentException("Duplicate flag group id: " + group.id());
        }
        for (FlagDefinition definition : group.children()) {
            if (!flags.containsKey(definition.id())) {
                throw new IllegalArgumentException("Unknown flag id " + definition.id() + " in group " + group.id());
            }
            if (definition.domain() != group.domain()) {
                throw new IllegalArgumentException("Flag " + definition.id() + " belongs to " + definition.domain() + " but group " + group.id() + " belongs to " + group.domain());
            }
        }
        groups.put(group.id(), group);
    }

    public @Nullable FlagDefinition getFlag(@NotNull String id) {
        return flags.get(id);
    }

    public @Nullable EnvironmentFlagDefinition getEnvironmentFlag(@NotNull String id) {
        FlagDefinition definition = flags.get(id);
        return definition instanceof EnvironmentFlagDefinition environmentFlag ? environmentFlag : null;
    }

    public @Nullable PrivilegeFlagDefinition getPrivilegeFlag(@NotNull String id) {
        FlagDefinition definition = flags.get(id);
        return definition instanceof PrivilegeFlagDefinition privilegeFlag ? privilegeFlag : null;
    }

    public @Nullable FlagGroupDefinition getGroup(@NotNull String id) {
        return groups.get(id);
    }

    public @Nullable FlagGroupDefinition getGroup(@NotNull FlagDefinition flag) {
        for (FlagGroupDefinition group : groups.values()) {
            if (group.children().contains(flag)) {
                return group;
            }
        }
        return null;
    }

    public @NotNull String getConfigurationNameKey(@NotNull FlagDefinition flag) {
        FlagGroupDefinition group = getGroup(flag);
        if (group == null) {
            return flag.configurationNameKey();
        }
        return group.id() + "." + flag.id();
    }

    public @NotNull String getConfigurationDefaultKey(@NotNull FlagDefinition flag) {
        return getConfigurationNameKey(flag) + ".default";
    }

    public @NotNull String getConfigurationEnableKey(@NotNull FlagDefinition flag) {
        return getConfigurationNameKey(flag) + ".enable";
    }

    public @NotNull String getConfigurationMaterialKey(@NotNull FlagDefinition flag) {
        return getConfigurationNameKey(flag) + ".material";
    }

    public @NotNull List<EnvironmentFlagDefinition> getEnvironmentGroupChildren(@NotNull String id) {
        FlagGroupDefinition group = groups.get(id);
        if (group == null || group.domain() != FlagDomain.ENVIRONMENT) {
            return List.of();
        }
        return group.children().stream()
                .filter(EnvironmentFlagDefinition.class::isInstance)
                .map(EnvironmentFlagDefinition.class::cast)
                .toList();
    }

    public @NotNull List<PrivilegeFlagDefinition> getPrivilegeGroupChildren(@NotNull String id) {
        FlagGroupDefinition group = groups.get(id);
        if (group == null || group.domain() != FlagDomain.PRIVILEGE) {
            return List.of();
        }
        return group.children().stream()
                .filter(PrivilegeFlagDefinition.class::isInstance)
                .map(PrivilegeFlagDefinition.class::cast)
                .toList();
    }

    public @NotNull List<FlagDefinition> getFlags(@NotNull FlagDomain domain) {
        List<FlagDefinition> result = new ArrayList<>();
        for (FlagDefinition definition : flags.values()) {
            if (definition.domain() == domain) {
                result.add(definition);
            }
        }
        return result;
    }

    public @NotNull List<FlagDefinition> getEnabledFlags(@NotNull FlagDomain domain) {
        return getFlags(domain).stream().filter(FlagDefinition::enabled).toList();
    }

    public @NotNull List<EnvironmentFlagDefinition> getEnvironmentFlags() {
        return flags.values().stream()
                .filter(EnvironmentFlagDefinition.class::isInstance)
                .map(EnvironmentFlagDefinition.class::cast)
                .toList();
    }

    public @NotNull List<EnvironmentFlagDefinition> getEnabledEnvironmentFlags() {
        return getEnvironmentFlags().stream().filter(EnvironmentFlagDefinition::enabled).toList();
    }

    public @NotNull List<PrivilegeFlagDefinition> getPrivilegeFlags() {
        return flags.values().stream()
                .filter(PrivilegeFlagDefinition.class::isInstance)
                .map(PrivilegeFlagDefinition.class::cast)
                .toList();
    }

    public @NotNull List<PrivilegeFlagDefinition> getEnabledPrivilegeFlags() {
        return getPrivilegeFlags().stream().filter(PrivilegeFlagDefinition::enabled).toList();
    }

    public @NotNull List<FlagGroupDefinition> getGroups(@NotNull FlagDomain domain) {
        List<FlagGroupDefinition> result = new ArrayList<>();
        for (FlagGroupDefinition group : groups.values()) {
            if (group.domain() == domain) {
                result.add(group);
            }
        }
        return result;
    }

    public @NotNull Map<String, FlagDefinition> allFlags() {
        return Collections.unmodifiableMap(flags);
    }

    public @NotNull Map<String, FlagGroupDefinition> allGroups() {
        return Collections.unmodifiableMap(groups);
    }

    private static FlagRegistry createDefault() {
        FlagRegistry registry = new FlagRegistry();
        FlagDefinitions.environmentFlags().forEach(registry::registerFlag);
        FlagDefinitions.privilegeFlags().forEach(registry::registerFlag);
        registerGroups(registry);
        return registry;
    }

    private static void registerGroups(FlagRegistry registry) {
        group(registry, "environment.spawning", FlagDomain.ENVIRONMENT, "Spawning", "Entity spawning controls", SPAWN_ANIMAL, SPAWN_VILLAGER, SPAWN_MONSTER, SPAWN_ENDERMAN, SPAWN_WITHER);
        group(registry, "environment.mob_behavior", FlagDomain.ENVIRONMENT, "Mob Behavior", "Mob movement, attack, and drops", MOVE_ANIMAL, MOVE_MONSTER, MOVE_BLOCK_BY_ENDERMAN, TELEPORT_ENDERMAN, DAMAGE_PLAYER_BY_MONSTER_MELEE, DAMAGE_PLAYER_BY_MONSTER_PROJECTILE, DROP_ITEM_BY_MOB);
        group(registry, "environment.explosion", FlagDomain.ENVIRONMENT, "Explosion", "Explosion and boss block damage controls", EXPLODE_TNT, EXPLODE_TNT_MINECART, EXPLODE_CREEPER, EXPLODE_WITHER, EXPLODE_WITHER_SKULL, EXPLODE_END_CRYSTAL, EXPLODE_FIREBALL, EXPLODE_SMALL_FIREBALL, EXPLODE_DRAGON_FIREBALL, EXPLODE_BED, EXPLODE_RESPAWN_ANCHOR, BREAK_BLOCK_BY_ENDER_DRAGON, BREAK_BLOCK_BY_WITHER);
        group(registry, "environment.nature", FlagDomain.ENVIRONMENT, "Nature", "Natural block and weather-related changes", SPREAD_FIRE, BURN_BLOCK, BURN_ENTITY, FLOW_LIQUID_INTO, FALL_GRAVITY_BLOCK, MELT_ICE, FORM_ICE, ACCUMULATE_SNOW, MELT_SNOW, DECAY_LEAVES, TRAMPLE_FARMLAND_BY_PLAYER, TRAMPLE_FARMLAND_BY_MOB);
        group(registry, "environment.redstone", FlagDomain.ENVIRONMENT, "Redstone", "Environment redstone controls", TRANSFER_HOPPER_OUTSIDE, PUSH_PISTON_CROSS_BORDER, TRIGGER_PRESSURE_BY_PROJECTILE, TRIGGER_PRESSURE_BY_MOB, TRIGGER_PRESSURE_BY_ITEM);
        group(registry, "environment.entity_block", FlagDomain.ENVIRONMENT, "Entity Block", "Non-player entity-block damage controls", DAMAGE_ITEM_FRAME_BY_NON_PLAYER, DAMAGE_ARMOR_STAND_BY_NON_PLAYER, DAMAGE_BOAT_BY_NON_PLAYER, DAMAGE_MINECART_BY_NON_PLAYER);
        group(registry, "environment.others", FlagDomain.ENVIRONMENT, "Others", "Other environment controls", SHOW_BORDER);
        group(registry, "privilege.admin", FlagDomain.PRIVILEGE, "Admin", "Administrative controls", MANAGE_MEMBERS, MANAGE_GROUPS, MANAGE_FLAGS);
        group(registry, "privilege.movement", FlagDomain.PRIVILEGE, "Movement", "Movement and teleport controls", MOVE_PLAYER, TELEPORT_TO_DOMINION, FLY_PLAYER, RIDE_VEHICLE, THROW_ENDER_PEARL, TRIGGER_RAID);
        group(registry, "privilege.build", FlagDomain.PRIVILEGE, "Build", "Block build controls", PLACE_BLOCK, PLACE_LIQUID, PLACE_FLOWER_POT_ITEM, BREAK_BLOCK, BREAK_LIQUID, BREAK_FLOWER_POT_ITEM, IGNITE_FIRE);
        group(registry, "privilege.entity_block", FlagDomain.PRIVILEGE, "Entity Block", "Item frame and armor stand controls", PLACE_ITEM_FRAME, BREAK_ITEM_FRAME, BREAK_ITEM_FRAME_BY_PROJECTILE, EDIT_ITEM_FRAME_ITEM, ROTATE_ITEM_FRAME, PLACE_ARMOR_STAND, BREAK_ARMOR_STAND, EDIT_ARMOR_STAND);
        group(registry, "privilege.storage", FlagDomain.PRIVILEGE, "Storage", "Storage block controls", OPEN_CHEST, OPEN_BARREL, OPEN_SHULKER_BOX, OPEN_COPPER_CHEST, OPEN_HOPPER, OPEN_DROPPER, OPEN_DISPENSER, OPEN_FURNACE, OPEN_BLAST_FURNACE, OPEN_SMOKER, USE_SHELF);
        group(registry, "privilege.redstone", FlagDomain.PRIVILEGE, "Redstone", "Player redstone controls", USE_DOOR, USE_BUTTON, USE_LEVER, TRIGGER_PRESSURE_PLATE, USE_REPEATER, USE_COMPARATOR, USE_NOTE_BLOCK);
        group(registry, "privilege.workstation", FlagDomain.PRIVILEGE, "Workstation", "Workstation controls", USE_CRAFTING_TABLE, USE_CRAFTER, USE_ANVIL, USE_ENCHANTING_TABLE, USE_BREWING_STAND, USE_BEACON, USE_JUKEBOX, USE_LECTERN, USE_CHISELED_BOOKSHELF);
        group(registry, "privilege.special", FlagDomain.PRIVILEGE, "Special", "Special interaction controls", USE_DRAGON_EGG, EDIT_SIGN, USE_BED, USE_RESPAWN_ANCHOR, EAT_CAKE);
        group(registry, "privilege.vehicle", FlagDomain.PRIVILEGE, "Vehicle", "Vehicle controls", SPAWN_VEHICLE, DESTROY_VEHICLE);
        group(registry, "privilege.farming", FlagDomain.PRIVILEGE, "Farming", "Farming and animal interaction controls", HARVEST_CROP, HARVEST_BLOCK, PLANT_CROP, PLANT_TREE, USE_FERTILIZER, FEED_ANIMAL, SHEAR_ENTITY, LEASH_ENTITY, DYE_ENTITY, HARVEST_HONEY, TRADE_VILLAGER);
        group(registry, "privilege.projectile", FlagDomain.PRIVILEGE, "Projectile", "Projectile controls", SHOOT_ARROW, THROW_TRIDENT, SHOOT_FIREBALL, SHOOT_WIND_CHARGE, THROW_EGG, USE_FISHING_HOOK);
        group(registry, "privilege.combat", FlagDomain.PRIVILEGE, "Combat", "Combat controls", DAMAGE_PLAYER_MELEE, DAMAGE_PLAYER_PROJECTILE, DAMAGE_PLAYER_EFFECT, DAMAGE_MONSTER, DAMAGE_ANIMAL, DAMAGE_VILLAGER);
    }

    private static void group(FlagRegistry registry, String id, FlagDomain domain, String displayName, String description, FlagDefinition... children) {
        registry.registerGroup(new FlagGroupDefinition(id, domain, displayName, description, List.of(children)));
    }
}
