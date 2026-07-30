package cn.lunadeer.dominion.api.dtos.flag;

import cn.lunadeer.dominion.api.DominionAPI;
import cn.lunadeer.dominion.events.FlagRegisterEvent;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;

public class Flags {
        // ================================== ENV(Environment)

        // animals
        public static final EnvFlag ANIMAL_SPAWN = new EnvFlag("animal_spawn", "Animal Spawn (Breeding)",
                        "Whether animals can spawn (including spawn egg & breeding).", true, false,
                        Material.COW_SPAWN_EGG);
        public static final EnvFlag ANIMAL_BREED = new EnvFlag("animal_breed", "Animal Breeding",
                        "Whether animal breeding can create offspring.", true, false, Material.WHEAT);
        public static final EnvFlag ANIMAL_SPAWNER = new EnvFlag("animal_spawner", "Animal Spawner",
                        "Whether animals can spawn from monster spawners.", true, false, Material.SPAWNER);
        public static final EnvFlag ANIMAL_SPAWN_EGG = new EnvFlag("animal_spawn_egg", "Animal Spawn Egg",
                        "Whether animals can be created with spawn eggs.", true, false, Material.COW_SPAWN_EGG);
        public static final EnvFlag ANIMAL_MOVE = new EnvFlag("animal_move", "Animal Move",
                        "Whether animals can move in dominion.", true, false, Material.CHERRY_FENCE);
        public static final EnvFlag VILLAGER_SPAWN = new EnvFlag("villager_spawn", "Villager Breed",
                        "Whether villager can breeding (including spawn egg).", true, false,
                        Material.VILLAGER_SPAWN_EGG);
        public static final EnvFlag VILLAGER_BREED = new EnvFlag("villager_breed", "Villager Breeding",
                        "Whether villager breeding can create children.", true, false, Material.BREAD);
        public static final EnvFlag VILLAGER_SPAWNER = new EnvFlag("villager_spawner", "Villager Spawner",
                        "Whether villagers can spawn from monster spawners.", true, false, Material.SPAWNER);
        public static final EnvFlag VILLAGER_SPAWN_EGG = new EnvFlag("villager_spawn_egg", "Villager Spawn Egg",
                        "Whether villagers can be created with spawn eggs.", true, false, Material.VILLAGER_SPAWN_EGG);

        // monster
        public static final EnvFlag MONSTER_SPAWN = new EnvFlag("monster_spawn", "Monster Spawn",
                        "Whether monster can spawn (including spawn egg).", false, false, Material.ZOMBIE_SPAWN_EGG);
        public static final EnvFlag MONSTER_SPAWNER = new EnvFlag("monster_spawner", "Monster Spawner",
                        "Whether monsters can spawn from monster spawners.", false, false, Material.SPAWNER);
        public static final EnvFlag MONSTER_SPAWN_EGG = new EnvFlag("monster_spawn_egg", "Monster Spawn Egg",
                        "Whether monsters can be created with spawn eggs.", true, false, Material.ZOMBIE_SPAWN_EGG);
        public static final EnvFlag MONSTER_MOVE = new EnvFlag("monster_move", "Monster Move",
                        "Whether monster can move in dominion.", true, false, Material.CRIMSON_FENCE);
        public static final EnvFlag MONSTER_DAMAGE = new EnvFlag("monster_damage", "Monster Kill Player",
                        "Whether monster can do harm to player.", true, false, Material.SKELETON_SPAWN_EGG);
        public static final EnvFlag ENDER_MAN = new EnvFlag("ender_man", "Enderman Block Movement",
                        "Whether endermen can pick up or place blocks.", false, true, Material.ENDERMAN_SPAWN_EGG);
        public static final EnvFlag ENDER_MAN_SPAWN = new EnvFlag("ender_man_spawn", "Enderman Spawn",
                        "Whether endermen can spawn.", false, true, Material.ENDERMAN_SPAWN_EGG);
        public static final EnvFlag ENDER_MAN_TELEPORT = new EnvFlag("ender_man_teleport", "Enderman Teleport",
                        "Whether endermen can teleport.", false, true, Material.ENDER_PEARL);

        // explode
        public static final EnvFlag TNT_EXPLODE = new EnvFlag("tnt_explode", "TNT Block Damage",
                        "Whether TNT explosions can destroy blocks.", false, true, Material.TNT);
        public static final EnvFlag TNT_DAMAGE_ENTITY = new EnvFlag("tnt_damage_entity", "TNT Entity Damage",
                        "Whether TNT explosions can damage entities and hanging objects.", false, true, Material.TNT);
        public static final EnvFlag WITHER_SPAWN = new EnvFlag("wither_spawn", "Wither Spawn",
                        "Whether withers can spawn.", false, true, Material.WITHER_SKELETON_SKULL);
        public static final EnvFlag WITHER_EXPLODE = new EnvFlag("wither_explode", "Wither Spawn Explosion",
                        "Whether a spawning wither can destroy blocks.", false, true, Material.NETHER_STAR);
        public static final EnvFlag WITHER_BREAK_BLOCK = new EnvFlag("wither_break_block", "Wither Block Breaking",
                        "Whether a harmed wither can break blocks.", false, true, Material.WITHER_SKELETON_SKULL);
        public static final EnvFlag CREEPER_EXPLODE = new EnvFlag("creeper_explode", "Creeper Block Damage",
                        "Whether creeper explosions can destroy blocks.", false, true, Material.CREEPER_HEAD);
        public static final EnvFlag CREEPER_DAMAGE_ENTITY = new EnvFlag("creeper_damage_entity",
                        "Creeper Decoration Damage",
                        "Whether creeper explosions can damage armor stands and hanging objects.", false, true,
                        Material.CREEPER_HEAD);
        public static final EnvFlag WITHER_SKULL_EXPLODE = new EnvFlag("wither_skull_explode",
                        "Wither Skull Block Damage", "Whether wither skull explosions can destroy blocks.", false, true,
                        Material.WITHER_SKELETON_SKULL);
        public static final EnvFlag WITHER_SKULL_DAMAGE_ENTITY = new EnvFlag("wither_skull_damage_entity",
                        "Wither Skull Decoration Damage",
                        "Whether wither skull explosions can damage armor stands and hanging objects.", false, true,
                        Material.WITHER_SKELETON_SKULL);
        public static final EnvFlag ENDER_CRYSTAL_EXPLODE = new EnvFlag("ender_crystal_explode",
                        "End Crystal Block Damage", "Whether end crystal explosions can destroy blocks.", false, true,
                        Material.END_CRYSTAL);
        public static final EnvFlag ENDER_CRYSTAL_DAMAGE_ENTITY = new EnvFlag("ender_crystal_damage_entity",
                        "End Crystal Decoration Damage",
                        "Whether end crystal explosions can damage armor stands and hanging objects.", false, true,
                        Material.END_CRYSTAL);
        public static final EnvFlag FIREBALL_EXPLODE = new EnvFlag("fireball_explode", "Fireball Block Damage",
                        "Whether fireball explosions can destroy blocks.", false, true, Material.FIRE_CHARGE);
        public static final EnvFlag FIREBALL_DAMAGE_ENTITY = new EnvFlag("fireball_damage_entity",
                        "Fireball Decoration Damage",
                        "Whether fireball explosions can damage armor stands and hanging objects.", false, true,
                        Material.FIRE_CHARGE);
        public static final EnvFlag BLOCK_EXPLODE = new EnvFlag("block_explode", "Bed and Anchor Block Damage",
                        "Whether bed and respawn-anchor explosions can destroy blocks.", false, true,
                        Material.RESPAWN_ANCHOR);
        public static final EnvFlag DRAGON_BREAK_BLOCK = new EnvFlag("dragon_break_block", "Ender Dragon Break Block",
                        "Whether ender dragon can break blocks.", false, true, Material.ENDER_DRAGON_SPAWN_EGG);

        // natural
        public static final EnvFlag FIRE_SPREAD = new EnvFlag("fire_spread", "Fire Spread",
                        "Prevent fire spread in dominion.", false, true, Material.FLINT_AND_STEEL);
        public static final EnvFlag BURN_BLOCK = new EnvFlag("burn_block", "Burn Block", "Whether blocks can burn.",
                        false, true, Material.FIRE_CHARGE);
        public static final EnvFlag BURN_ENTITY = new EnvFlag("burn_entity", "Burn Entity",
                        "Whether entity can burn or take high-temperature damage (not including player).", false, true,
                        Material.CAMPFIRE);
        public static final EnvFlag FLOW_IN_PROTECTION = new EnvFlag("flow_in_protection", "Flow In",
                        "Prevent external water/lava flow into dominion.", false, true, Material.WATER_BUCKET);
        public static final EnvFlag GRAVITY_BLOCK = new EnvFlag("gravity_block", "Falling Block",
                        "Whether gravity block can fall in dominion (false will make them to item).", false, true,
                        Material.SAND);
        public static final EnvFlag ICE_MELT = new EnvFlag("ice_melt", "Ice Melt", "Whether to allow ice to melt.",
                        false, false, Material.ICE);
        public static final EnvFlag ICE_FORM = new EnvFlag("ice_form", "Ice Form",
                        "Whether to allow ice to form (prevents Frost Walker).", false, true, Material.PACKED_ICE);
        public static final EnvFlag SNOW_ACCUMULATION = new EnvFlag("snow_accumulation", "Snow Accumulation",
                        "Whether to allow snow accumulation.", false, false, Material.SNOW);
        public static final EnvFlag SNOW_MELT = new EnvFlag("snow_melt", "Snow Melt", "Whether to allow snow to melt.",
                        false, false, Material.SNOW_BLOCK);
        public static final EnvFlag TRAMPLE = new EnvFlag("trample", "Player Trample Farmland",
                        "Whether players can trample farmland.", false, true, Material.FARMLAND);
        public static final EnvFlag MOB_TRAMPLE = new EnvFlag("mob_trample", "Mob Trample Farmland",
                        "Whether non-player entities can trample farmland.", false, true, Material.FARMLAND);
        public static final EnvFlag DECAY = new EnvFlag("decay", "Leaf Decay", "Whether leaves can decay.", false, true,
                        Material.OAK_LEAVES);

        // red stone stuff
        public static final EnvFlag HOPPER_OUTSIDE = new EnvFlag("hopper_outside", "Hopper (Outside)",
                        "False to prevent outside hopper from sucking container in dominion.", false, true,
                        Material.HOPPER);
        public static final EnvFlag PISTON_OUTSIDE = new EnvFlag("piston_outside", "Piston",
                        "False to prevent piston from pushing/pulling blocks across dominion.", false, true,
                        Material.PISTON);
        public static final EnvFlag TRIG_PRESSURE_PROJ = new EnvFlag("trig_pressure_proj",
                        "Pressure Plate (Projectile)", "When projectile (arrow/snowball) can trigger pressure plate.",
                        false, true, Material.BIRCH_PRESSURE_PLATE);
        public static final EnvFlag TRIG_PRESSURE_MOB = new EnvFlag("trig_pressure_mob", "Pressure Plate (Mob)",
                        "Whether mob (player not included) can trigger pressure plate.", false, true,
                        Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        public static final EnvFlag TRIG_PRESSURE_DROP = new EnvFlag("trig_pressure_drop", "Pressure Plate (Dropping)",
                        "Whether dropping items can trigger pressure plate.", false, true,
                        Material.LIGHT_WEIGHTED_PRESSURE_PLATE);

        // other
        public static final EnvFlag ITEM_FRAME_PROJ_DAMAGE = new EnvFlag("item_frame_proj_damage",
                        "Projectile Damage Item Frame", "Whether projectile (arrow/snowball) can break item frame.",
                        false, true, Material.ITEM_FRAME);
        public static final EnvFlag MOB_DROP_ITEM = new EnvFlag("mob_drop_item", "Mob Drop Item",
                        "Whether mob drop item when killed.", true, true, Material.DIAMOND);
        public static final EnvFlag SHOW_BORDER = new EnvFlag("show_border", "Show Border",
                        "Show dominion border to player when walking in.", true, true, Material.BRICK_WALL);

        // ================================== PRI(Privilege)

        // administration
        public static final PriFlag ADMIN = new PriFlag("admin", "Administrator",
                        "Member with this flag can manage normal members and groups.", false, true,Material.NETHER_STAR);
        public static final PriFlag RESIZE = new PriFlag("resize", "Resize Dominion",
                        "Member with this flag can resize dominion.", false, true, Material.OAK_SIGN);
        public static final PriFlag RENAME = new PriFlag("rename", "Rename Dominion",
                        "Member with this flag can rename dominion.", false, true, Material.NAME_TAG);
        public static final PriFlag CREATE_SUB = new PriFlag("create_sub", "Create Sub-Dominion",
                        "Member with this flag can create sub-dominion.", false, true, Material.GREEN_DYE);
        public static final PriFlag DELETE_SUB = new PriFlag("delete_sub", "Delete Sub-Dominion",
                        "Member with this flag can delete sub-dominion.", false, true, Material.RED_DYE);
        public static final PriFlag RESIZE_SUB = new PriFlag("resize_sub", "Resize Sub-Dominion",
                        "Member with this flag can resize sub-dominion.", false, true, Material.BAMBOO_SIGN);
        public static final PriFlag RENAME_SUB = new PriFlag("rename_sub", "Rename Sub-Dominion",
                        "Member with this flag can rename sub-dominion.", false, true, Material.WRITABLE_BOOK);

        // movement and teleportation
        public static final PriFlag MOVE = new PriFlag("move", "Player Move", "Whether player can move in dominion.",
                        true, true, Material.LEATHER_BOOTS);
        public static final PriFlag TELEPORT = new PriFlag("teleport", "Teleportation",
                        "False means can't teleport to this dominion.", false, true, Material.ENDER_EYE);
        public static final PriFlag FLY = new PriFlag("fly", "Fly", "NOT elytra fly, it's like creative mode fly.",
                        false, false, Material.ELYTRA);
        public static final PriFlag RIDING = new PriFlag("riding", "Riding",
                        "Whether can ride vehicle (boat, minecart, horse etc.).", false, true, Material.SADDLE);
        public static final PriFlag ENDER_PEARL = new PriFlag("ender_pearl", "End Pearl",
                        "Whether can throw ender pearl.", false, true, Material.ENDER_PEARL);
        public static final PriFlag RAID = new PriFlag("raid", "Raid", "Whether can trigger raid.", false, true,
                        Material.IRON_AXE);

        // building and placing
        public static final PriFlag PLACE = new PriFlag("place", "Place Block",
                        "Whether normal blocks and flower-pot contents can be placed.", false, true,
                        Material.GRASS_BLOCK);
        public static final PriFlag PLACE_LIQUID = new PriFlag("place_liquid", "Place Liquid",
                        "Whether water and lava can be placed.", false, true, Material.WATER_BUCKET);
        public static final PriFlag PLACE_ENTITY = new PriFlag("place_entity", "Place Decorative Entity",
                        "Whether armor stands and item frames can be placed.", false, true, Material.ARMOR_STAND);
        public static final PriFlag BREAK_BLOCK = new PriFlag("break", "Break Block",
                        "Whether normal blocks and flower-pot contents can be removed.", false, true,
                        Material.IRON_PICKAXE);
        public static final PriFlag BREAK_LIQUID = new PriFlag("break_liquid", "Collect Liquid",
                        "Whether water and lava can be collected.", false, true, Material.BUCKET);
        public static final PriFlag BREAK_ENTITY = new PriFlag("break_entity", "Break Decorative Entity",
                        "Whether armor stands and item frames can be broken.", false, true, Material.IRON_AXE);
        public static final PriFlag IGNITE = new PriFlag("ignite", "Ignite", "Whether can ignite fire.", false, true,
                        Material.FLINT_AND_STEEL);

        // item management
        public static final PriFlag PICK_UP = new PriFlag("pick_up", "Pick Up Item",
                        "Whether player can pick up items in dominion.", true, true, Material.DIAMOND_PICKAXE);
        public static final PriFlag DROP_ITEM = new PriFlag("drop_item", "Drop Item",
                        "Whether player can drop item in dominion.", true, true, Material.IRON_INGOT);

        // doors and access
        public static final PriFlag DOOR = new PriFlag("door", "Door",
                        "Whether can interact with door (including trapdoor, fence gate).", false, true,
                        Material.OAK_DOOR);
        public static final PriFlag BUTTON = new PriFlag("button", "Button", "Whether can click button.", false, true,
                        Material.STONE_BUTTON);
        public static final PriFlag LEVER = new PriFlag("lever", "Lever", "Whether can switch lever.", false, true,
                        Material.LEVER);
        public static final PriFlag PRESSURE = new PriFlag("pressure", "Pressure Plate (Player)",
                        "Whether player can trigger pressure plate.", false, true, Material.STONE_PRESSURE_PLATE);

        // red stone
        public static final PriFlag RED_STONE_POWDER = new PriFlag("red_stone_powder", "Red Stone Powder",
                        "Whether can interact with red stone powder.", false, true, Material.REDSTONE);
        public static final PriFlag REPEATER = new PriFlag("repeater", "Repeater",
                        "Whether can change (interact with) repeater.", false, true, Material.REPEATER);
        public static final PriFlag COMPARER = new PriFlag("comparer", "Comparer",
                        "Whether can interact with comparer.", false, true, Material.COMPARATOR);
        public static final PriFlag NOTE_BLOCK = new PriFlag("note_block", "Note Block",
                        "Whether can interact with note block.", false, true, Material.NOTE_BLOCK);

        // containers and storage
        public static final PriFlag CONTAINER = new PriFlag("container", "Storage Container",
                        "Whether chest-like storage containers can be opened.", false, true, Material.CHEST);
        public static final PriFlag ARMOR_STAND_INTERACTIVE = new PriFlag("armor_stand_interactive",
                        "Armor Stand Interaction", "Whether equipment on armor stands can be changed.", false, true,
                        Material.ARMOR_STAND);
        public static final PriFlag ITEM_FRAME_CONTENT = new PriFlag("item_frame_content", "Item Frame Content",
                        "Whether items can be inserted into or removed from item frames.", false, true,
                        Material.ITEM_FRAME);
        public static final PriFlag HOPPER = new PriFlag("hopper", "Special Container",
                        "Such as hopper, furnace, dropper, dispenser, blast furnace, smoker.", false, true,
                        Material.HOPPER);

        // crafting and utilities
        public static final PriFlag CRAFT = new PriFlag("craft", "Crafting Table", "Whether can use crafting table.",
                        false, true, Material.CRAFTING_TABLE);
        public static final PriFlag CRAFTER = new PriFlag("crafter", "Crafter",
                        "Whether can interact with crafter (1.21).", false, true, Material.CRAFTING_TABLE);
        public static final PriFlag ANVIL = new PriFlag("anvil", "Anvil", "Whether can use anvil.", false, true,
                        Material.ANVIL);
        public static final PriFlag ENCHANT = new PriFlag("enchant", "Enchant Table", "Whether can use enchant table.",
                        false, true, Material.ENCHANTING_TABLE);
        public static final PriFlag BREW = new PriFlag("brew", "Brewing Stand", "Whether can use brewing stand.", false,
                        true, Material.BREWING_STAND);
        public static final PriFlag BEACON = new PriFlag("beacon", "Beacon", "Whether can interact with beacon.", false,
                        true, Material.BEACON);
        public static final PriFlag JUKEBOX = new PriFlag("jukebox", "Jukebox", "Whether can interact with jukebox.",
                        false, true, Material.JUKEBOX);
        public static final PriFlag LECTERN = new PriFlag("lectern", "Lectern", "Whether can interact with lectern.",
                        false, true, Material.LECTERN);
        public static final PriFlag BOOKSHELF = new PriFlag("bookshelf", "Chiseled Bookshelf",
                        "Whether can interact with chiseled bookshelf.", false, true, Material.CHISELED_BOOKSHELF);

        // special items and interactions
        public static final PriFlag DRAGON_EGG = new PriFlag("dragon_egg", "Dragon Egg",
                        "Whether can interact with dragon egg.", false, true, Material.DRAGON_EGG);
        public static final PriFlag ITEM_FRAME_INTERACTIVE = new PriFlag("item_frame_interactive",
                        "Item Frame Interactive", "Whether can interact with item frame (rotate item).", false, true,
                        Material.ITEM_FRAME);
        public static final PriFlag EDIT_SIGN = new PriFlag("edit_sign", "Edit Sign", "Whether can edit sign.", false,
                        true, Material.OAK_SIGN);

        // rest and respawn
        public static final PriFlag BED = new PriFlag("bed", "Bed", "Weather can sleep in bed (set spawn point).",
                        false, true, Material.RED_BED);
        public static final PriFlag ANCHOR = new PriFlag("anchor", "Respawn Anchor",
                        "Weather can set/use respawn anchor.", false, true, Material.RESPAWN_ANCHOR);

        // vehicles
        public static final PriFlag VEHICLE_SPAWN = new PriFlag("vehicle_spawn", "Vehicle Spawn",
                        "Whether can spawn vehicle (boat, minecart).", false, true, Material.MINECART);
        public static final PriFlag VEHICLE_DESTROY = new PriFlag("vehicle_destroy", "Vehicle Destroy",
                        "Whether can destroy vehicle (boat, minecart).", false, true, Material.IRON_AXE);

        // farming and animals
        public static final PriFlag HARVEST = new PriFlag("harvest", "Harvest", "Whether player can harvest crops.",
                        false, true, Material.WHEAT);
        public static final PriFlag SOWING = new PriFlag("sowing", "Sowing", "Whether crops can be planted.", false,
                        true, Material.WHEAT_SEEDS);
        public static final PriFlag FERTILIZER = new PriFlag("fertilizer", "Fertilizer",
                        "Whether bone meal and other fertilizer can be used.", false, true, Material.BONE_MEAL);
        public static final PriFlag PLANT_TREE = new PriFlag("plant_tree", "Plant Tree",
                        "Whether saplings and similar tree plants can be planted.", false, true, Material.OAK_SAPLING);
        public static final PriFlag FEED = new PriFlag("feed", "Feed Animal", "Whether can feed animals.", false, true,
                        Material.WHEAT);
        public static final PriFlag SHEAR = new PriFlag("shear", "Shear", "Whether can cut wool from sheep.", false,
                        true, Material.SHEARS);
        public static final PriFlag LEASH = new PriFlag("leash", "Leash",
                        "Whether to allow leashing animals/mobs/entities.", false, true, Material.LEAD);
        public static final PriFlag DYE = new PriFlag("dye", "Dye", "What can dye (sheep, dog collar, cat collar).",
                        false, true, Material.LIGHT_BLUE_DYE);
        public static final PriFlag HONEY = new PriFlag("honey", "Honey",
                        "Whether can interact with hive (to get honey).", false, true, Material.HONEY_BOTTLE);

        // food and consumption
        public static final PriFlag CAKE = new PriFlag("cake", "Cake", "Whether can eat cake.", false, true,
                        Material.CAKE);

        // trading and interaction
        public static final PriFlag TRADE = new PriFlag("trade", "Villager Trade", "Whether can trade with villager.",
                        false, true, Material.EMERALD);

        // projectiles and throwing
        public static final PriFlag SHOOT = new PriFlag("shoot", "Shoot Arrows",
                        "Whether bows and crossbows can shoot arrows.", false, true, Material.BOW);
        public static final PriFlag TRIDENT = new PriFlag("trident", "Throw Trident", "Whether tridents can be thrown.",
                        false, true, Material.TRIDENT);
        public static final PriFlag FIREBALL = new PriFlag("fireball", "Launch Fireball",
                        "Whether players can launch fireballs.", false, true, Material.FIRE_CHARGE);
        public static final PriFlag WIND_CHARGE = new PriFlag("wind_charge", "Use Wind Charge",
                        "Whether players can launch wind charges.", false, true, Material.FIRE_CHARGE);
        public static final PriFlag EGG = new PriFlag("egg", "Throw Egg", "Whether can throw egg.", false, true,
                        Material.EGG);
        public static final PriFlag HOOK = new PriFlag("hook", "Hook", "Whether can use fishing rod.", false, true,
                        Material.FISHING_ROD);

        // combat
        public static final PriFlag PVP = new PriFlag("pvp", "PVP", "Damage between players.", false, true,
                        Material.DIAMOND_SWORD);
        public static final PriFlag MONSTER_KILLING = new PriFlag("monster_killing", "Monster Killing",
                        "Whether can do harm to monsters.", false, true, Material.IRON_SWORD);
        public static final PriFlag ANIMAL_KILLING = new PriFlag("animal_killing", "Animal Killing",
                        "Whether can do harm to animals.", false, true, Material.COOKED_BEEF);
        public static final PriFlag VILLAGER_KILLING = new PriFlag("villager_killing", "Villager Killing",
                        "Whether can do harm to villager.", false, true, Material.WOODEN_SWORD);

        private static final List<EnvFlag> env_flags = new ArrayList<>();
        private static final List<PriFlag> pri_flags = new ArrayList<>();
        private static final List<Flag> all_flags = new ArrayList<>();
        private static final AtomicLong revision = new AtomicLong();

        static {
                for (java.lang.reflect.Field field : Flags.class.getDeclaredFields()) {
                        try {
                                Object obj = field.get(null);
                                if (obj instanceof Flag flag) {
                                        all_flags.add(flag);
                                        if (flag instanceof EnvFlag envFlag) {
                                                env_flags.add(envFlag);
                                        } else if (flag instanceof PriFlag priFlag) {
                                                pri_flags.add(priFlag);
                                        }
                                }
                        } catch (IllegalAccessException ignored) {
                        }
                }
        }

        /**
         * Returns a list of all flags.
         *
         * @return a list of all flags
         */
        public static List<Flag> getAllFlags() {
                return all_flags;
        }

        /**
         * Returns a list of all environment flags.
         *
         * @return a list of all environment flags
         */
        public static List<EnvFlag> getAllEnvFlags() {
                return env_flags;
        }

        /**
         * Returns a list of all privilege flags.
         *
         * @return a list of all privilege flags
         */
        public static List<PriFlag> getAllPriFlags() {
                return pri_flags;
        }

        /**
         * Returns a list of enabled flags from the given list of flags.
         *
         * @param flags the list of flags to filter
         * @param <T>   the type of the flags
         * @return a list of enabled flags
         */
        private static <T extends Flag> List<T> getEnabledFlags(List<T> flags) {
                List<T> enabledFlags = new ArrayList<>();
                for (T flag : flags) {
                        if (flag.getEnable()) {
                                enabledFlags.add(flag);
                        }
                }
                return enabledFlags;
        }

        /**
         * Returns a list of all enabled environment flags.
         *
         * @return a list of all enabled environment flags
         */
        public static List<EnvFlag> getAllEnvFlagsEnable() {
                return getEnabledFlags(env_flags);
        }

        /**
         * Returns a list of all enabled privilege flags.
         *
         * @return a list of all enabled privilege flags
         */
        public static List<PriFlag> getAllPriFlagsEnable() {
                return getEnabledFlags(pri_flags);
        }

        /**
         * Returns a list of all enabled flags.
         *
         * @return a list of all enabled flags
         */
        public static List<Flag> getAllFlagsEnable() {
                return getEnabledFlags(all_flags);
        }

        /**
         * Returns a flag by its name from the given list of flags.
         *
         * @param flags the list of flags to search
         * @param name  the name of the flag
         * @param <T>   the type of the flags
         * @return the flag with the given name, or null if not found
         */
        private static <T extends Flag> T getFlagByName(List<T> flags, String name) {
                for (T flag : flags) {
                        if (flag.getFlagName().equals(name)) {
                                return flag;
                        }
                }
                return null;
        }

        /**
         * Returns a flag by its name from all flags.
         *
         * @param name the name of the flag
         * @return the flag with the given name, or null if not found
         */
        public static Flag getFlag(String name) {
                return getFlagByName(all_flags, name);
        }

        /**
         * Returns an environment flag by its name.
         *
         * @param name the name of the environment flag
         * @return the environment flag with the given name, or null if not found
         */
        public static EnvFlag getEnvFlag(String name) {
                return getFlagByName(env_flags, name);
        }

        /**
         * Returns a privilege flag by its name.
         *
         * @param name the name of the privilege flag
         * @return the privilege flag with the given name, or null if not found
         */
        public static PriFlag getPreFlag(String name) {
                return getFlagByName(pri_flags, name);
        }

        /**
         * Registers a flag.
         * <p>
         * Need to run {@link #applyNewCustomFlags()} to make the new flag work.
         *
         * @param flag the flag to register
         */
        private static void registerFlag(Flag flag) {
                if (flag instanceof EnvFlag) {
                        env_flags.add((EnvFlag) flag);
                } else if (flag instanceof PriFlag) {
                        pri_flags.add((PriFlag) flag);
                }
                all_flags.add(flag);
        }

        /**
         * Registers an environment flag.
         * <p>
         * Need to run {@link #applyNewCustomFlags()} to make the new flag work.
         *
         * @param plugin the plugin registering the flag
         * @param flag   the environment flag to register
         * @return true if the flag was successfully registered, false otherwise
         */
        public static boolean registerEnvFlag(JavaPlugin plugin, EnvFlag flag) {
                if (new FlagRegisterEvent(plugin, flag).call()) {
                        all_flags.add(flag);
                        env_flags.add(flag);
                        revision.incrementAndGet();
                        return true;
                }
                return false;
        }

        /**
         * Registers a privilege flag.
         * <p>
         * Need to run {@link #applyNewCustomFlags()} to make the new flag work.
         *
         * @param plugin the plugin registering the flag
         * @param flag   the privilege flag to register
         * @return true if the flag was successfully registered, false otherwise
         */
        public static boolean registerPriFlag(JavaPlugin plugin, PriFlag flag) {
                if (new FlagRegisterEvent(plugin, flag).call()) {
                        all_flags.add(flag);
                        pri_flags.add(flag);
                        revision.incrementAndGet();
                        return true;
                }
                return false;
        }

        /**
         * Applies new custom flags by reloading the configuration and cache.
         * This should be called after registering new flags to ensure they take effect.
         *
         */
        public static CompletableFuture<Void> applyChanges() {
                return DominionAPI.getInstance().applyFlagChanges();
        }

        /**
         * Queues registered flag and flag-group changes for application.
         *
         * @deprecated use {@link #applyChanges()} and observe the returned future
         */
        @Deprecated
        public static void applyNewCustomFlags() throws Exception {
                applyChanges();
        }

        public static long getRevision() {
                return revision.get();
        }

        /**
         * Returns the legacy flag whose value should seed a newly split flag.
         */
        @ApiStatus.Internal
        public static Flag getLegacySource(Flag flag) {
                if (flag == ANIMAL_BREED || flag == ANIMAL_SPAWNER || flag == ANIMAL_SPAWN_EGG)
                        return ANIMAL_SPAWN;
                if (flag == VILLAGER_BREED || flag == VILLAGER_SPAWNER || flag == VILLAGER_SPAWN_EGG)
                        return VILLAGER_SPAWN;
                if (flag == MONSTER_SPAWNER || flag == MONSTER_SPAWN_EGG)
                        return MONSTER_SPAWN;
                if (flag == ENDER_MAN_SPAWN || flag == ENDER_MAN_TELEPORT)
                        return ENDER_MAN;
                if (flag == WITHER_EXPLODE || flag == WITHER_BREAK_BLOCK)
                        return WITHER_SPAWN;
                if (flag == BLOCK_EXPLODE || flag == CREEPER_DAMAGE_ENTITY
                                || flag == WITHER_SKULL_EXPLODE || flag == WITHER_SKULL_DAMAGE_ENTITY
                                || flag == ENDER_CRYSTAL_EXPLODE || flag == ENDER_CRYSTAL_DAMAGE_ENTITY
                                || flag == FIREBALL_EXPLODE || flag == FIREBALL_DAMAGE_ENTITY)
                        return CREEPER_EXPLODE;
                if (flag == TNT_DAMAGE_ENTITY)
                        return TNT_EXPLODE;
                if (flag == MOB_TRAMPLE)
                        return TRAMPLE;
                if (flag == PLACE_LIQUID || flag == PLACE_ENTITY)
                        return PLACE;
                if (flag == BREAK_LIQUID || flag == BREAK_ENTITY)
                        return BREAK_BLOCK;
                if (flag == ARMOR_STAND_INTERACTIVE || flag == ITEM_FRAME_CONTENT)
                        return CONTAINER;
                if (flag == FERTILIZER || flag == PLANT_TREE)
                        return SOWING;
                if (flag == TRIDENT || flag == FIREBALL || flag == WIND_CHARGE)
                        return SHOOT;
                return null;
        }

        @ApiStatus.Internal
        public static boolean preserveAllowedSpawnEggValue(Flag flag) {
                return flag == ANIMAL_SPAWN_EGG || flag == MONSTER_SPAWN_EGG;
        }
}
