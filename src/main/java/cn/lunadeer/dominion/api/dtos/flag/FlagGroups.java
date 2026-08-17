package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Registry for logical flag groups.
 */
public final class FlagGroups {
    private static final Map<String, EnvFlagGroup> ENV_GROUPS = new LinkedHashMap<>();
    private static final Map<String, PriFlagGroup> PRI_GROUPS = new LinkedHashMap<>();
    private static final AtomicLong REVISION = new AtomicLong();

    private FlagGroups() {
    }

    public static synchronized boolean registerEnvFlagGroup(@NotNull JavaPlugin plugin,
                                                            @NotNull EnvFlagGroup group) {
        return register(ENV_GROUPS, group);
    }

    public static synchronized boolean registerPriFlagGroup(@NotNull JavaPlugin plugin,
                                                            @NotNull PriFlagGroup group) {
        return register(PRI_GROUPS, group);
    }

    public static synchronized @Nullable EnvFlagGroup unregisterEnvFlagGroup(@NotNull String id) {
        return unregister(ENV_GROUPS, id);
    }

    public static synchronized @Nullable PriFlagGroup unregisterPriFlagGroup(@NotNull String id) {
        return unregister(PRI_GROUPS, id);
    }

    public static synchronized @Nullable EnvFlagGroup getEnvFlagGroup(@NotNull String id) {
        return ENV_GROUPS.get(id);
    }

    public static synchronized @Nullable PriFlagGroup getPriFlagGroup(@NotNull String id) {
        return PRI_GROUPS.get(id);
    }

    public static synchronized @NotNull List<EnvFlagGroup> getEnvFlagGroups() {
        return List.copyOf(ENV_GROUPS.values());
    }

    public static synchronized @NotNull List<PriFlagGroup> getPriFlagGroups() {
        return List.copyOf(PRI_GROUPS.values());
    }

    public static synchronized @NotNull EnvFlagGroup getUngroupedEnvFlags() {
        LinkedHashSet<EnvFlag> grouped = new LinkedHashSet<>();
        ENV_GROUPS.values().forEach(group -> grouped.addAll(group.getFlags()));
        List<EnvFlag> flags = Flags.getAllEnvFlags().stream().filter(flag -> !grouped.contains(flag)).toList();
        return new EnvFlagGroup("ungrouped", "Ungrouped", "Flags that are not assigned to a configured group.",
                Material.PAPER, "minecraft:items/item/paper", flags);
    }

    public static synchronized @NotNull PriFlagGroup getUngroupedPriFlags() {
        LinkedHashSet<PriFlag> grouped = new LinkedHashSet<>();
        PRI_GROUPS.values().forEach(group -> grouped.addAll(group.getFlags()));
        List<PriFlag> flags = Flags.getAllPriFlags().stream().filter(flag -> !grouped.contains(flag)).toList();
        return new PriFlagGroup("ungrouped", "Ungrouped", "Flags that are not assigned to a configured group.",
                Material.PAPER, "minecraft:items/item/paper", flags);
    }

    public static long getRevision() {
        return REVISION.get();
    }

    @ApiStatus.Internal
    public static synchronized void replaceConfiguredGroups(@NotNull Collection<EnvFlagGroup> environment,
                                                            @NotNull Collection<PriFlagGroup> privilege) {
        detachAll(ENV_GROUPS.values());
        detachAll(PRI_GROUPS.values());
        ENV_GROUPS.clear();
        PRI_GROUPS.clear();
        for (EnvFlagGroup group : environment) putLoaded(ENV_GROUPS, group);
        for (PriFlagGroup group : privilege) putLoaded(PRI_GROUPS, group);
        REVISION.incrementAndGet();
    }

    @ApiStatus.Internal
    public static @NotNull List<EnvFlagGroup> defaultEnvironmentGroups() {
        return List.of(
                env("creature-spawning", "Creature Spawning", "Animal, villager and monster spawning.",
                        Material.SPAWNER, "minecraft:blocks/block/spawner", Flags.ANIMAL_SPAWN, Flags.ANIMAL_BREED, Flags.ANIMAL_SPAWNER,
                        Flags.ANIMAL_SPAWN_EGG, Flags.VILLAGER_SPAWN, Flags.VILLAGER_BREED,
                        Flags.VILLAGER_SPAWNER, Flags.VILLAGER_SPAWN_EGG, Flags.MONSTER_SPAWN,
                        Flags.MONSTER_SPAWNER, Flags.MONSTER_SPAWN_EGG, Flags.ENDER_MAN_SPAWN, Flags.WITHER_SPAWN),
                env("creature-behavior", "Creature Behavior", "Movement, damage and special creature behavior.",
                        Material.LEAD, "minecraft:items/item/lead", Flags.ANIMAL_MOVE, Flags.MONSTER_MOVE, Flags.MONSTER_DAMAGE, Flags.ENDER_MAN,
                        Flags.ENDER_MAN_TELEPORT, Flags.WITHER_BREAK_BLOCK, Flags.MOB_DROP_ITEM, Flags.MOB_TRAMPLE),
                env("explosions", "Explosions", "Explosion block damage and entity damage by source.",
                        Material.TNT, "minecraft:blocks/block/tnt_side", Flags.TNT_EXPLODE, Flags.TNT_DAMAGE_ENTITY, Flags.CREEPER_EXPLODE,
                        Flags.CREEPER_DAMAGE_ENTITY, Flags.WITHER_EXPLODE, Flags.WITHER_SKULL_EXPLODE,
                        Flags.WITHER_SKULL_DAMAGE_ENTITY, Flags.ENDER_CRYSTAL_EXPLODE,
                        Flags.ENDER_CRYSTAL_DAMAGE_ENTITY, Flags.FIREBALL_EXPLODE, Flags.FIREBALL_DAMAGE_ENTITY,
                        Flags.BLOCK_EXPLODE, Flags.DRAGON_BREAK_BLOCK),
                env("fire", "Fire and Burning", "Fire spread and heat damage.",
                        Material.FLINT_AND_STEEL, "minecraft:items/item/flint_and_steel", Flags.FIRE_SPREAD, Flags.BURN_BLOCK, Flags.BURN_ENTITY),
                env("natural-changes", "Natural Changes", "Fluids, gravity, weather and natural block changes.",
                        Material.GRASS_BLOCK, "minecraft:blocks/block/grass_block_side", Flags.FLOW_IN_PROTECTION, Flags.GRAVITY_BLOCK, Flags.ICE_MELT,
                        Flags.ICE_FORM, Flags.SNOW_ACCUMULATION, Flags.SNOW_MELT, Flags.TRAMPLE,
                        Flags.MOB_TRAMPLE, Flags.DECAY),
                env("mechanisms", "Mechanisms", "External redstone and pressure-trigger behavior.",
                        Material.REDSTONE, "minecraft:items/item/redstone", Flags.HOPPER_OUTSIDE, Flags.PISTON_OUTSIDE, Flags.TRIG_PRESSURE_PROJ,
                        Flags.TRIG_PRESSURE_MOB, Flags.TRIG_PRESSURE_DROP),
                env("entity-protection", "Entity Protection", "Protect decorative entities from projectiles and explosions.",
                        Material.ARMOR_STAND, "minecraft:items/item/armor_stand", Flags.ITEM_FRAME_PROJ_DAMAGE, Flags.TNT_DAMAGE_ENTITY,
                        Flags.CREEPER_DAMAGE_ENTITY, Flags.WITHER_SKULL_DAMAGE_ENTITY,
                        Flags.ENDER_CRYSTAL_DAMAGE_ENTITY, Flags.FIREBALL_DAMAGE_ENTITY),
                env("general", "General", "General dominion presentation behavior.",
                        Material.BEACON, "minecraft:blocks/block/beacon", Flags.SHOW_BORDER)
        );
    }

    @ApiStatus.Internal
    public static @NotNull List<PriFlagGroup> defaultPrivilegeGroups() {
        return List.of(
                pri("administration", "Administration", "Dominion administration privileges.",
                        Material.NETHER_STAR, "minecraft:items/item/nether_star", Flags.ADMIN, Flags.RESIZE, Flags.RENAME, Flags.CREATE_SUB, Flags.DELETE_SUB, Flags.RESIZE_SUB, Flags.RENAME_SUB),
                pri("movement", "Movement", "Movement and travel inside a dominion.",
                        Material.LEATHER_BOOTS, "minecraft:items/item/leather_boots", Flags.MOVE, Flags.TELEPORT, Flags.FLY, Flags.RIDING, Flags.ENDER_PEARL),
                pri("building", "Building", "Place and remove blocks, liquids and decorative entities.",
                        Material.BRICKS, "minecraft:blocks/block/bricks", Flags.PLACE, Flags.PLACE_LIQUID, Flags.PLACE_ENTITY, Flags.BREAK_BLOCK,
                        Flags.BREAK_LIQUID, Flags.BREAK_ENTITY, Flags.IGNITE),
                pri("item-management", "Item Management", "Pick up and drop items.",
                        Material.DIAMOND, "minecraft:items/item/diamond", Flags.PICK_UP, Flags.DROP_ITEM),
                pri("access", "Access", "Doors and simple access controls.",
                        Material.OAK_DOOR, "minecraft:items/item/oak_door", Flags.DOOR, Flags.BUTTON, Flags.LEVER, Flags.PRESSURE),
                pri("redstone", "Redstone", "Interact with redstone components.",
                        Material.REDSTONE, "minecraft:items/item/redstone", Flags.BUTTON, Flags.LEVER, Flags.PRESSURE, Flags.RED_STONE_POWDER,
                        Flags.REPEATER, Flags.COMPARER, Flags.NOTE_BLOCK),
                pri("storage", "Storage", "Containers and stored display items.",
                        Material.CHEST, "minecraft:chests/entity/chest/normal", Flags.CHEST, Flags.BARREL, Flags.SHULKER_BOX,
                        Flags.HOPPER, Flags.DROPPER, Flags.DISPENSER, Flags.FURNACE, Flags.BLAST_FURNACE,
                        Flags.SMOKER, Flags.FLOWER_POT, Flags.COPPER_CHEST, Flags.SHELF, Flags.ITEM_FRAME_CONTENT),
                pri("workstations", "Workstations", "Crafting and utility workstations.",
                        Material.CRAFTING_TABLE, "minecraft:blocks/block/crafting_table_side", Flags.CRAFT, Flags.CRAFTER, Flags.ANVIL, Flags.ENCHANT,
                        Flags.BREW, Flags.BEACON),
                pri("decoration", "Decoration", "Decorative blocks and entities.",
                        Material.ITEM_FRAME, "minecraft:items/item/item_frame", Flags.PLACE_ENTITY, Flags.BREAK_ENTITY, Flags.ARMOR_STAND_INTERACTIVE,
                        Flags.ITEM_FRAME_CONTENT, Flags.ITEM_FRAME_INTERACTIVE, Flags.JUKEBOX, Flags.LECTERN,
                        Flags.BOOKSHELF, Flags.DRAGON_EGG, Flags.EDIT_SIGN),
                pri("rest", "Rest and Respawn", "Beds and respawn anchors.",
                        Material.RED_BED, "minecraft:blocks/block/red_bed_foot_east", Flags.BED, Flags.ANCHOR),
                pri("vehicles", "Vehicles", "Ride, create and destroy vehicles.",
                        Material.MINECART, "minecraft:items/item/minecart", Flags.RIDING, Flags.VEHICLE_SPAWN, Flags.VEHICLE_DESTROY),
                pri("farming", "Farming", "Crops, trees and beekeeping.",
                        Material.WHEAT, "minecraft:items/item/wheat", Flags.HARVEST, Flags.SOWING, Flags.FERTILIZER, Flags.PLANT_TREE, Flags.HONEY),
                pri("animal-care", "Animal Care", "Feed and handle animals.",
                        Material.SADDLE, "minecraft:items/item/saddle", Flags.FEED, Flags.SHEAR, Flags.LEASH, Flags.DYE),
                pri("food-and-trade", "Food and Trade", "Food, honey and villager trading.",
                        Material.CAKE, "minecraft:items/item/cake", Flags.CAKE, Flags.HONEY, Flags.TRADE),
                pri("projectiles", "Projectiles", "Launch and use projectiles.",
                        Material.BOW, "minecraft:items/item/bow", Flags.SHOOT, Flags.TRIDENT, Flags.FIREBALL, Flags.WIND_CHARGE,
                        Flags.EGG, Flags.ENDER_PEARL, Flags.HOOK),
                pri("combat", "Combat", "Combat, raids and entity damage.",
                        Material.DIAMOND_SWORD, "minecraft:items/item/diamond_sword", Flags.PVP, Flags.MONSTER_KILLING, Flags.ANIMAL_KILLING,
                        Flags.VILLAGER_KILLING, Flags.RAID)
        );
    }

    private static <T extends FlagGroup<?>> boolean register(Map<String, T> groups, T group) {
        if (group.getId().equals("ungrouped")) return false;
        if (groups.containsKey(group.getId())) return false;
        putLoaded(groups, group);
        REVISION.incrementAndGet();
        return true;
    }

    private static <T extends FlagGroup<?>> T unregister(Map<String, T> groups, String id) {
        T removed = groups.remove(id);
        if (removed != null) {
            removed.detachChangeListener();
            REVISION.incrementAndGet();
        }
        return removed;
    }

    private static <T extends FlagGroup<?>> void putLoaded(Map<String, T> groups, T group) {
        if (group.getId().equals("ungrouped")) {
            throw new IllegalArgumentException("'ungrouped' is reserved for the dynamic fallback group");
        }
        if (groups.putIfAbsent(group.getId(), group) != null) {
            throw new IllegalArgumentException("Duplicate flag group id: " + group.getId());
        }
        group.attachChangeListener(REVISION::incrementAndGet);
    }

    private static void detachAll(Collection<? extends FlagGroup<?>> groups) {
        groups.forEach(FlagGroup::detachChangeListener);
    }

    private static EnvFlagGroup env(String id, String name, String description, Material material,
                                    String icon, EnvFlag... flags) {
        return new EnvFlagGroup(id, name, description, material, icon, List.of(flags));
    }

    private static PriFlagGroup pri(String id, String name, String description, Material material,
                                    String icon, PriFlag... flags) {
        return new PriFlagGroup(id, name, description, material, icon, List.of(flags));
    }
}
