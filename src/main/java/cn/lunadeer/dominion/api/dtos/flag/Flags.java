package cn.lunadeer.dominion.api.dtos.flag;

import cn.lunadeer.dominion.api.DominionAPI;
import cn.lunadeer.dominion.events.FlagRegisterEvent;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Flags {
    // ================================== ENV(Environment)

    // animals
    public static final EnvFlag ANIMAL_SPAWN
            = new EnvFlag("animal_spawn", "Animal Spawn (Breeding)", "Whether animals can spawn (including spawn egg & breeding).", true, false, Material.COW_SPAWN_EGG);
    public static final EnvFlag ANIMAL_MOVE
            = new EnvFlag("animal_move", "Animal Move", "Whether animals can move in dominion.", true, false, Material.CHERRY_FENCE);
    public static final EnvFlag VILLAGER_SPAWN
            = new EnvFlag("villager_spawn", "Villager Breed", "Whether villager can breeding (including spawn egg).", true, false, Material.VILLAGER_SPAWN_EGG);

    // monster
    public static final EnvFlag MONSTER_SPAWN
            = new EnvFlag("monster_spawn", "Monster Spawn", "Whether monster can spawn (including spawn egg).", false, false, Material.ZOMBIE_SPAWN_EGG);
    public static final EnvFlag MONSTER_MOVE
            = new EnvFlag("monster_move", "Monster Move", "Whether monster can move in dominion.", true, false, Material.CRIMSON_FENCE);
    public static final EnvFlag MONSTER_DAMAGE
            = new EnvFlag("monster_damage", "Monster Kill Player", "Whether monster can do harm to player.", true, false, Material.SKELETON_SPAWN_EGG);
    public static final EnvFlag ENDER_MAN
            = new EnvFlag("ender_man", "Ender Man", "False to prevent ender-man from picking up blocks, spawning, teleporting.", false, true, Material.ENDERMAN_SPAWN_EGG);

    // explode
    public static final EnvFlag TNT_EXPLODE
            = new EnvFlag("tnt_explode", "TNT Explode", "Whether TNT can explode.", false, true, Material.TNT);
    public static final EnvFlag WITHER_SPAWN
            = new EnvFlag("wither_spawn", "Wither Spawn", "Whether can spawn wither, and wither' explode.", false, true, Material.WITHER_SKELETON_SKULL);
    public static final EnvFlag CREEPER_EXPLODE
            = new EnvFlag("creeper_explode", "Entity Explode (No-TNT)", "Creeper/Wither Skull/Ender Crystal/Fireball/Bed/Respawn Anchor.", false, true, Material.CREEPER_HEAD);
    public static final EnvFlag DRAGON_BREAK_BLOCK
            = new EnvFlag("dragon_break_block", "Ender Dragon Break Block", "Whether ender dragon can break blocks.", false, true, Material.ENDER_DRAGON_SPAWN_EGG);

    // natural
    public static final EnvFlag FIRE_SPREAD
            = new EnvFlag("fire_spread", "Fire Spread", "Prevent fire spread in dominion.", false, true, Material.CAMPFIRE);
    public static final EnvFlag FLOW_IN_PROTECTION
            = new EnvFlag("flow_in_protection", "Flow In", "Prevent external water/lava flow into dominion.", false, true, Material.WATER_BUCKET);
    public static final EnvFlag GRAVITY_BLOCK
            = new EnvFlag("gravity_block", "Falling Block", "Whether gravity block can fall in dominion (false will make them to item).", false, true, Material.SAND);
    public static final EnvFlag ICE_MELT
            = new EnvFlag("ice_melt", "Ice Melt", "Whether to allow ice to melt.", false, false, Material.ICE);
    public static final EnvFlag ICE_FORM
            = new EnvFlag("ice_form", "Ice Form", "Whether to allow ice to form (prevents Frost Walker).", false, true, Material.PACKED_ICE);
    public static final EnvFlag SNOW_ACCUMULATION
            = new EnvFlag("snow_accumulation", "Snow Accumulation", "Whether to allow snow accumulation.", false, false, Material.SNOW);
    public static final EnvFlag SNOW_MELT
            = new EnvFlag("snow_melt", "Snow Melt", "Whether to allow snow to melt.", false, false, Material.SNOW_BLOCK);
    public static final EnvFlag TRAMPLE
            = new EnvFlag("trample", "Trample Farmland", "Whether farmland can be trampled (false means protect farmland).", false, true, Material.FARMLAND);
    public static final EnvFlag DECAY
            = new EnvFlag("decay", "Leaf Decay", "Whether leaves can decay.", false, true, Material.OAK_LEAVES);

    // red stone stuff
    public static final EnvFlag HOPPER_OUTSIDE
            = new EnvFlag("hopper_outside", "Hopper (Outside)", "False to prevent outside hopper from sucking container in dominion.", false, true, Material.HOPPER);
    public static final EnvFlag PISTON_OUTSIDE
            = new EnvFlag("piston_outside", "Piston", "False to prevent piston from pushing/pulling blocks across dominion.", false, true, Material.PISTON);
    public static final EnvFlag TRIG_PRESSURE_PROJ
            = new EnvFlag("trig_pressure_proj", "Pressure Plate (Projectile)", "When projectile (arrow/snowball) can trigger pressure plate.", false, true, Material.BIRCH_PRESSURE_PLATE);
    public static final EnvFlag TRIG_PRESSURE_MOB
            = new EnvFlag("trig_pressure_mob", "Pressure Plate (Mob)", "Whether mob (player not included) can trigger pressure plate.", false, true, Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final EnvFlag TRIG_PRESSURE_DROP
            = new EnvFlag("trig_pressure_drop", "Pressure Plate (Dropping)", "Whether dropping items can trigger pressure plate.", false, true, Material.LIGHT_WEIGHTED_PRESSURE_PLATE);

    // other
    public static final EnvFlag ITEM_FRAME_PROJ_DAMAGE
            = new EnvFlag("item_frame_proj_damage", "Projectile Damage Item Frame", "Whether projectile (arrow/snowball) can break item frame.", false, true, Material.ITEM_FRAME);
    public static final EnvFlag MOB_DROP_ITEM
            = new EnvFlag("mob_drop_item", "Mob Drop Item", "Whether mob drop item when killed.", true, true, Material.DIAMOND);
    public static final EnvFlag SHOW_BORDER
            = new EnvFlag("show_border", "Show Border", "Show dominion border to player when walking in.", true, true, Material.BRICK_WALL);


    // ================================== PRI(Privilege)

    // administration
    public static final PriFlag ADMIN =
            new PriFlag("admin", "Administrator", "Member with this flag can manage normal members and groups.", false, true, Material.NETHER_STAR);

    // movement and teleportation
    public static final PriFlag MOVE =
            new PriFlag("move", "Player Move", "Whether player can move in dominion.", true, true, Material.LEATHER_BOOTS);
    public static final PriFlag JUMP =
            new PriFlag("jump", "Player Jump", "Whether player can jump in dominion.", true, true, Material.LEATHER_BOOTS);
    public static final PriFlag TELEPORT =
            new PriFlag("teleport", "Teleportation", "False means can't teleport to this dominion.", false, true, Material.ENDER_EYE);
    public static final PriFlag FLY =
            new PriFlag("fly", "Fly", "NOT elytra fly, it's like creative mode fly.", false, false, Material.ELYTRA);
    public static final PriFlag RIDING =
            new PriFlag("riding", "Riding", "Whether can ride vehicle (boat, minecart, horse etc.).", false, true, Material.SADDLE);
    public static final PriFlag ENDER_PEARL =
            new PriFlag("ender_pearl", "End Pearl", "Whether can throw ender pearl.", false, true, Material.ENDER_PEARL);

    // building and placing
    public static final PriFlag PLACE =
            new PriFlag("place", "Place Block", "Whether can place blocks (normal blocks, item frame, lava, water).", false, true, Material.GRASS_BLOCK);
    public static final PriFlag BREAK_BLOCK =
            new PriFlag("break", "Break Block", "Whether can break blocks (including item frame, armor stand).", false, true, Material.IRON_PICKAXE);
    public static final PriFlag IGNITE =
            new PriFlag("ignite", "Ignite", "Whether can ignite fire.", false, true, Material.FLINT_AND_STEEL);

    // item management
    public static final PriFlag PICK_UP =
            new PriFlag("pick_up", "Pick Up Item", "Whether player can pick up items in dominion.", true, true, Material.DIAMOND_PICKAXE);
    public static final PriFlag DROP_ITEM =
            new PriFlag("drop_item", "Drop Item", "Whether player can drop item in dominion.", true, true, Material.IRON_INGOT);

    // doors and access
    public static final PriFlag DOOR =
            new PriFlag("door", "Door", "Whether can interact with door (including trapdoor, fence gate).", false, true, Material.OAK_DOOR);
    public static final PriFlag BUTTON =
            new PriFlag("button", "Button", "Whether can click button.", false, true, Material.STONE_BUTTON);
    public static final PriFlag LEVER =
            new PriFlag("lever", "Lever", "Whether can switch lever.", false, true, Material.LEVER);
    public static final PriFlag PRESSURE =
            new PriFlag("pressure", "Pressure Plate (Player)", "Whether player can trigger pressure plate.", false, true, Material.STONE_PRESSURE_PLATE);

    // red stone
    public static final PriFlag REPEATER =
            new PriFlag("repeater", "Repeater", "Whether can change (interact with) repeater.", false, true, Material.REPEATER);
    public static final PriFlag COMPARER =
            new PriFlag("comparer", "Comparer", "Whether can interact with comparer.", false, true, Material.COMPARATOR);
    public static final PriFlag NOTE_BLOCK =
            new PriFlag("note_block", "Note Block", "Whether can interact with note block.", false, true, Material.NOTE_BLOCK);

    // containers and storage
    public static final PriFlag CONTAINER =
            new PriFlag("container", "Special Container", "Such as hopper, furnace, dropper, dispenser, blast furnace, smoker.", false, true, Material.CHEST);
    public static final PriFlag HOPPER =
            new PriFlag("hopper", "Special Container", "Such as hopper, furnace, dropper, dispenser, blast furnace, smoker.", false, true, Material.HOPPER);

    // crafting and utilities
    public static final PriFlag CRAFT =
            new PriFlag("craft", "Crafting Table", "Whether can use crafting table.", false, true, Material.CRAFTING_TABLE);
    public static final PriFlag CRAFTER =
            new PriFlag("crafter", "Crafter", "Whether can interact with crafter (1.21).", false, true, Material.CRAFTING_TABLE);
    public static final PriFlag ANVIL =
            new PriFlag("anvil", "Anvil", "Whether can use anvil.", false, true, Material.ANVIL);
    public static final PriFlag ENCHANT =
            new PriFlag("enchant", "Enchant Table", "Whether can use enchant table.", false, true, Material.ENCHANTING_TABLE);
    public static final PriFlag BREW =
            new PriFlag("brew", "Brewing Stand", "Whether can use brewing stand.", false, true, Material.BREWING_STAND);
    public static final PriFlag BEACON =
            new PriFlag("beacon", "Beacon", "Whether can interact with beacon.", false, true, Material.BEACON);
    public static final PriFlag JUKEBOX =
            new PriFlag("jukebox", "Jukebox", "Whether can interact with jukebox.", false, true, Material.JUKEBOX);
    public static final PriFlag LECTERN =
            new PriFlag("lectern", "Lectern", "Whether can interact with lectern.", false, true, Material.LECTERN);
    public static final PriFlag BOOKSHELF =
            new PriFlag("bookshelf", "Chiseled Bookshelf", "Whether can interact with chiseled bookshelf.", false, true, Material.CHISELED_BOOKSHELF);

    // special items and interactions
    public static final PriFlag DRAGON_EGG =
            new PriFlag("dragon_egg", "Dragon Egg", "Whether can interact with dragon egg.", false, true, Material.DRAGON_EGG);
    public static final PriFlag ITEM_FRAME_INTERACTIVE =
            new PriFlag("item_frame_interactive", "Item Frame Interactive", "Whether can interact with item frame (rotate item).", false, true, Material.ITEM_FRAME);
    public static final PriFlag EDIT_SIGN =
            new PriFlag("edit_sign", "Edit Sign", "Whether can edit sign.", false, true, Material.OAK_SIGN);

    // rest and respawn
    public static final PriFlag BED =
            new PriFlag("bed", "Bed", "Weather can sleep in bed (set spawn point).", false, true, Material.RED_BED);
    public static final PriFlag ANCHOR =
            new PriFlag("anchor", "Respawn Anchor", "Weather can set/use respawn anchor.", false, true, Material.RESPAWN_ANCHOR);

    // vehicles
    public static final PriFlag VEHICLE_SPAWN =
            new PriFlag("vehicle_spawn", "Vehicle Spawn", "Whether can spawn vehicle (boat, minecart).", false, true, Material.MINECART);
    public static final PriFlag VEHICLE_DESTROY =
            new PriFlag("vehicle_destroy", "Vehicle Destroy", "Whether can destroy vehicle (boat, minecart).", false, true, Material.IRON_AXE);

    // farming and animals
    public static final PriFlag HARVEST =
            new PriFlag("harvest", "Harvest", "Whether player can harvest crops.", false, true, Material.WHEAT);
    public static final PriFlag SOWING =
            new PriFlag("sowing", "Sowing", "Whether to allow sowing crops (wheat, carrot etc.).", false, true, Material.WHEAT_SEEDS);
    public static final PriFlag FEED =
            new PriFlag("feed", "Feed Animal", "Whether can feed animals.", false, true, Material.WHEAT);
    public static final PriFlag SHEAR =
            new PriFlag("shear", "Shear", "Whether can cut wool from sheep.", false, true, Material.SHEARS);
    public static final PriFlag LEASH =
            new PriFlag("leash", "Leash", "Whether to allow leashing animals/mobs/entities.", false, true, Material.LEAD);
    public static final PriFlag DYE =
            new PriFlag("dye", "Dye", "What can dye (sheep, dog collar, cat collar).", false, true, Material.LIGHT_BLUE_DYE);
    public static final PriFlag HONEY =
            new PriFlag("honey", "Honey", "Whether can interact with hive (to get honey).", false, true, Material.HONEY_BOTTLE);

    // food and consumption
    public static final PriFlag CAKE =
            new PriFlag("cake", "Cake", "Whether can eat cake.", false, true, Material.CAKE);

    // trading and interaction
    public static final PriFlag TRADE =
            new PriFlag("trade", "Villager Trade", "Whether can trade with villager.", false, true, Material.EMERALD);

    // projectiles and throwing
    public static final PriFlag SHOOT =
            new PriFlag("shoot", "Shooting", "Include arrow/snowball/trident/fireball/wind-charge(1.21).", false, true, Material.BOW);
    public static final PriFlag EGG =
            new PriFlag("egg", "Throw Egg", "Whether can throw egg.", false, true, Material.EGG);
    public static final PriFlag HOOK =
            new PriFlag("hook", "Hook", "Whether can use fishing rod.", false, true, Material.FISHING_ROD);

    // combat
    public static final PriFlag PVP =
            new PriFlag("pvp", "PVP", "Damage between players.", false, true, Material.DIAMOND_SWORD);
    public static final PriFlag MONSTER_KILLING =
            new PriFlag("monster_killing", "Monster Killing", "Whether can do harm to monsters.", false, true, Material.IRON_SWORD);
    public static final PriFlag ANIMAL_KILLING =
            new PriFlag("animal_killing", "Animal Killing", "Whether can do harm to animals.", false, true, Material.COOKED_BEEF);
    public static final PriFlag VILLAGER_KILLING =
            new PriFlag("villager_killing", "Villager Killing", "Whether can do harm to villager.", false, true, Material.WOODEN_SWORD);

    // special effects
    public static final PriFlag GLOW =
            new PriFlag("glow", "Glow", "Like glowing arrow effect.", false, true, Material.SPECTRAL_ARROW);

    private static final List<EnvFlag> env_flags = new ArrayList<>();
    private static final List<PriFlag> pri_flags = new ArrayList<>();
    private static final List<Flag> all_flags = new ArrayList<>();

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
            return true;
        }
        return false;
    }

    /**
     * Applies new custom flags by reloading the configuration and cache.
     * This should be called after registering new flags to ensure they take effect.
     *
     * @throws Exception if reloading the config or cache fails
     */
    public static void applyNewCustomFlags() throws Exception {
        DominionAPI.getInstance().reloadConfig();
        DominionAPI.getInstance().reloadCache();
    }
}
