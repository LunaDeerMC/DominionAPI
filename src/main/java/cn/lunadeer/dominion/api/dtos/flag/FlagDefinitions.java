package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;

import java.util.List;

public final class FlagDefinitions {
    private FlagDefinitions() {
    }

    public static final EnvironmentFlagDefinition SPAWN_ANIMAL = env("spawn_animal", "Animal Spawn", "Whether animals and bats can spawn.", Flags.ANIMAL_SPAWN, Material.COW_SPAWN_EGG);
    public static final EnvironmentFlagDefinition SPAWN_VILLAGER = env("spawn_villager", "Villager Spawn", "Whether villagers can spawn or breed.", Flags.VILLAGER_SPAWN, Material.VILLAGER_SPAWN_EGG);
    public static final EnvironmentFlagDefinition SPAWN_MONSTER = env("spawn_monster", "Monster Spawn", "Whether monsters can spawn.", Flags.MONSTER_SPAWN, Material.ZOMBIE_SPAWN_EGG);
    public static final EnvironmentFlagDefinition SPAWN_ENDERMAN = env("spawn_enderman", "Enderman Spawn", "Whether endermen can spawn.", Flags.ENDER_MAN, Material.ENDERMAN_SPAWN_EGG);
    public static final EnvironmentFlagDefinition SPAWN_WITHER = env("spawn_wither", "Wither Spawn", "Whether withers can spawn.", Flags.WITHER_SPAWN, Material.WITHER_SKELETON_SKULL);
    public static final EnvironmentFlagDefinition MOVE_ANIMAL = env("move_animal", "Animal Move", "Whether animals can move.", Flags.ANIMAL_MOVE, Material.CHERRY_FENCE);
    public static final EnvironmentFlagDefinition MOVE_MONSTER = env("move_monster", "Monster Move", "Whether monsters can move.", Flags.MONSTER_MOVE, Material.CRIMSON_FENCE);
    public static final EnvironmentFlagDefinition MOVE_BLOCK_BY_ENDERMAN = env("move_block_by_enderman", "Enderman Move Block", "Whether endermen can pick up or place blocks.", Flags.ENDER_MAN, Material.GRASS_BLOCK);
    public static final EnvironmentFlagDefinition TELEPORT_ENDERMAN = env("teleport_enderman", "Enderman Teleport", "Whether endermen can teleport.", Flags.ENDER_MAN, Material.ENDER_PEARL);
    public static final EnvironmentFlagDefinition DAMAGE_PLAYER_BY_MONSTER_MELEE = env("damage_player_by_monster_melee", "Monster Melee Damage", "Whether monsters can melee damage players.", Flags.MONSTER_DAMAGE, Material.SKELETON_SPAWN_EGG);
    public static final EnvironmentFlagDefinition DAMAGE_PLAYER_BY_MONSTER_PROJECTILE = env("damage_player_by_monster_projectile", "Monster Projectile Damage", "Whether monster projectiles can damage players.", Flags.MONSTER_DAMAGE, Material.ARROW);
    public static final EnvironmentFlagDefinition DROP_ITEM_BY_MOB = env("drop_item_by_mob", "Mob Drop Item", "Whether mobs can drop items when killed.", Flags.MOB_DROP_ITEM, Material.DIAMOND);
    public static final EnvironmentFlagDefinition EXPLODE_TNT = env("explode_tnt", "TNT Explode", "Whether TNT can explode.", Flags.TNT_EXPLODE, Material.TNT);
    public static final EnvironmentFlagDefinition EXPLODE_TNT_MINECART = env("explode_tnt_minecart", "TNT Minecart Explode", "Whether TNT minecarts can explode.", Flags.TNT_EXPLODE, Material.TNT_MINECART);
    public static final EnvironmentFlagDefinition EXPLODE_CREEPER = env("explode_creeper", "Creeper Explode", "Whether creepers can explode.", Flags.CREEPER_EXPLODE, Material.CREEPER_HEAD);
    public static final EnvironmentFlagDefinition EXPLODE_WITHER = env("explode_wither", "Wither Explode", "Whether wither body explosions can break blocks.", Flags.WITHER_SPAWN, Material.WITHER_SKELETON_SKULL);
    public static final EnvironmentFlagDefinition EXPLODE_WITHER_SKULL = env("explode_wither_skull", "Wither Skull Explode", "Whether wither skulls can explode.", Flags.CREEPER_EXPLODE, Material.WITHER_SKELETON_SKULL);
    public static final EnvironmentFlagDefinition EXPLODE_END_CRYSTAL = env("explode_end_crystal", "End Crystal Explode", "Whether end crystals can explode.", Flags.CREEPER_EXPLODE, Material.END_CRYSTAL);
    public static final EnvironmentFlagDefinition EXPLODE_FIREBALL = env("explode_fireball", "Fireball Explode", "Whether fireballs can explode.", Flags.CREEPER_EXPLODE, Material.FIRE_CHARGE);
    public static final EnvironmentFlagDefinition EXPLODE_SMALL_FIREBALL = env("explode_small_fireball", "Small Fireball Explode", "Whether small fireballs can explode.", Flags.CREEPER_EXPLODE, Material.FIRE_CHARGE);
    public static final EnvironmentFlagDefinition EXPLODE_DRAGON_FIREBALL = env("explode_dragon_fireball", "Dragon Fireball Explode", "Whether dragon fireballs can explode.", Flags.CREEPER_EXPLODE, Material.DRAGON_BREATH);
    public static final EnvironmentFlagDefinition EXPLODE_BED = env("explode_bed", "Bed Explode", "Whether beds can explode.", Flags.CREEPER_EXPLODE, Material.RED_BED);
    public static final EnvironmentFlagDefinition EXPLODE_RESPAWN_ANCHOR = env("explode_respawn_anchor", "Respawn Anchor Explode", "Whether respawn anchors can explode.", Flags.CREEPER_EXPLODE, Material.RESPAWN_ANCHOR);
    public static final EnvironmentFlagDefinition BREAK_BLOCK_BY_ENDER_DRAGON = env("break_block_by_ender_dragon", "Ender Dragon Break Block", "Whether ender dragons can break blocks.", Flags.DRAGON_BREAK_BLOCK, Material.ENDER_DRAGON_SPAWN_EGG);
    public static final EnvironmentFlagDefinition BREAK_BLOCK_BY_WITHER = env("break_block_by_wither", "Wither Break Block", "Whether withers can break blocks when harmed.", Flags.WITHER_SPAWN, Material.WITHER_SKELETON_SKULL);
    public static final EnvironmentFlagDefinition SPREAD_FIRE = env("spread_fire", "Fire Spread", "Whether fire can spread.", Flags.FIRE_SPREAD, Material.FLINT_AND_STEEL);
    public static final EnvironmentFlagDefinition BURN_BLOCK = env("burn_block", "Burn Block", "Whether blocks can burn.", Flags.BURN_BLOCK, Material.FIRE_CHARGE);
    public static final EnvironmentFlagDefinition BURN_ENTITY = env("burn_entity", "Burn Entity", "Whether non-player entities can burn or take high-temperature damage.", Flags.BURN_ENTITY, Material.CAMPFIRE);
    public static final EnvironmentFlagDefinition FLOW_LIQUID_INTO = env("flow_liquid_into", "Flow Liquid Into", "Whether outside water or lava can flow into dominion.", Flags.FLOW_IN_PROTECTION, Material.WATER_BUCKET);
    public static final EnvironmentFlagDefinition FALL_GRAVITY_BLOCK = env("fall_gravity_block", "Falling Block", "Whether gravity blocks can fall.", Flags.GRAVITY_BLOCK, Material.SAND);
    public static final EnvironmentFlagDefinition MELT_ICE = env("melt_ice", "Ice Melt", "Whether ice can melt.", Flags.ICE_MELT, Material.ICE);
    public static final EnvironmentFlagDefinition FORM_ICE = env("form_ice", "Ice Form", "Whether ice can form.", Flags.ICE_FORM, Material.PACKED_ICE);
    public static final EnvironmentFlagDefinition ACCUMULATE_SNOW = env("accumulate_snow", "Snow Accumulate", "Whether snow can accumulate.", Flags.SNOW_ACCUMULATION, Material.SNOW);
    public static final EnvironmentFlagDefinition MELT_SNOW = env("melt_snow", "Snow Melt", "Whether snow can melt.", Flags.SNOW_MELT, Material.SNOW_BLOCK);
    public static final EnvironmentFlagDefinition DECAY_LEAVES = env("decay_leaves", "Leaf Decay", "Whether leaves can decay.", Flags.DECAY, Material.OAK_LEAVES);
    public static final EnvironmentFlagDefinition TRAMPLE_FARMLAND_BY_PLAYER = env("trample_farmland_by_player", "Player Trample Farmland", "Whether players can trample farmland.", Flags.TRAMPLE, Material.FARMLAND);
    public static final EnvironmentFlagDefinition TRAMPLE_FARMLAND_BY_MOB = env("trample_farmland_by_mob", "Mob Trample Farmland", "Whether mobs can trample farmland.", Flags.TRAMPLE, Material.FARMLAND);
    public static final EnvironmentFlagDefinition TRANSFER_HOPPER_OUTSIDE = env("transfer_hopper_outside", "Outside Hopper Transfer", "Whether outside hoppers can pull from dominion containers.", Flags.HOPPER_OUTSIDE, Material.HOPPER);
    public static final EnvironmentFlagDefinition PUSH_PISTON_CROSS_BORDER = env("push_piston_cross_border", "Piston Cross Border", "Whether pistons can push or pull blocks across dominion borders.", Flags.PISTON_OUTSIDE, Material.PISTON);
    public static final EnvironmentFlagDefinition TRIGGER_PRESSURE_BY_PROJECTILE = env("trigger_pressure_by_projectile", "Projectile Trigger Pressure Plate", "Whether projectiles can trigger pressure plates.", Flags.TRIG_PRESSURE_PROJ, Material.BIRCH_PRESSURE_PLATE);
    public static final EnvironmentFlagDefinition TRIGGER_PRESSURE_BY_MOB = env("trigger_pressure_by_mob", "Mob Trigger Pressure Plate", "Whether mobs can trigger pressure plates.", Flags.TRIG_PRESSURE_MOB, Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final EnvironmentFlagDefinition TRIGGER_PRESSURE_BY_ITEM = env("trigger_pressure_by_item", "Item Trigger Pressure Plate", "Whether dropped items can trigger pressure plates.", Flags.TRIG_PRESSURE_DROP, Material.LIGHT_WEIGHTED_PRESSURE_PLATE);
    public static final EnvironmentFlagDefinition DAMAGE_ITEM_FRAME_BY_NON_PLAYER = env("damage_item_frame_by_non_player", "Non-player Damage Item Frame", "Whether non-player behavior can damage item frames.", Flags.ITEM_FRAME_PROJ_DAMAGE, Material.ITEM_FRAME);
    public static final EnvironmentFlagDefinition DAMAGE_ARMOR_STAND_BY_NON_PLAYER = env("damage_armor_stand_by_non_player", "Non-player Damage Armor Stand", "Whether non-player behavior can damage armor stands.", Flags.CREEPER_EXPLODE, Material.ARMOR_STAND);
    public static final EnvironmentFlagDefinition DAMAGE_BOAT_BY_NON_PLAYER = env("damage_boat_by_non_player", "Non-player Damage Boat", "Whether non-player behavior can damage boats.", Flags.CREEPER_EXPLODE, Material.OAK_BOAT);
    public static final EnvironmentFlagDefinition DAMAGE_MINECART_BY_NON_PLAYER = env("damage_minecart_by_non_player", "Non-player Damage Minecart", "Whether non-player behavior can damage minecarts.", Flags.CREEPER_EXPLODE, Material.MINECART);
    public static final EnvironmentFlagDefinition SHOW_BORDER = env("show_border", "Show Border", "Show dominion border to players crossing it.", Flags.SHOW_BORDER, Material.BRICK_WALL);

    public static final PrivilegeFlagDefinition MANAGE_MEMBERS = pri("manage_members", "Manage Members", "Whether members can manage normal members.", Flags.ADMIN, Material.PLAYER_HEAD);
    public static final PrivilegeFlagDefinition MANAGE_GROUPS = pri("manage_groups", "Manage Groups", "Whether members can manage groups.", Flags.ADMIN, Material.NETHER_STAR);
    public static final PrivilegeFlagDefinition MANAGE_FLAGS = pri("manage_flags", "Manage Flags", "Whether members can modify flags.", Flags.ADMIN, Material.COMMAND_BLOCK);
    public static final PrivilegeFlagDefinition MOVE_PLAYER = pri("move_player", "Move", "Whether players can move.", Flags.MOVE, Material.LEATHER_BOOTS);
    public static final PrivilegeFlagDefinition TELEPORT_TO_DOMINION = pri("teleport_to_dominion", "Teleport", "Whether players can teleport to this dominion.", Flags.TELEPORT, Material.ENDER_EYE);
    public static final PrivilegeFlagDefinition FLY_PLAYER = pri("fly_player", "Fly", "Whether players can fly.", Flags.FLY, Material.ELYTRA);
    public static final PrivilegeFlagDefinition RIDE_VEHICLE = pri("ride_vehicle", "Ride", "Whether players can ride vehicles or entities.", Flags.RIDING, Material.SADDLE);
    public static final PrivilegeFlagDefinition THROW_ENDER_PEARL = pri("throw_ender_pearl", "Throw Ender Pearl", "Whether players can throw ender pearls.", Flags.ENDER_PEARL, Material.ENDER_PEARL);
    public static final PrivilegeFlagDefinition TRIGGER_RAID = pri("trigger_raid", "Trigger Raid", "Whether players can trigger raids.", Flags.RAID, Material.IRON_AXE);
    public static final PrivilegeFlagDefinition PLACE_BLOCK = pri("place_block", "Place Block", "Whether players can place normal blocks.", Flags.PLACE, Material.GRASS_BLOCK);
    public static final PrivilegeFlagDefinition PLACE_LIQUID = pri("place_liquid", "Place Liquid", "Whether players can pour water or lava.", Flags.PLACE, Material.WATER_BUCKET);
    public static final PrivilegeFlagDefinition PLACE_FLOWER_POT_ITEM = pri("place_flower_pot_item", "Place Flower Pot Item", "Whether players can put items into flower pots.", Flags.PLACE, Material.FLOWER_POT);
    public static final PrivilegeFlagDefinition BREAK_BLOCK = pri("break_block", "Break Block", "Whether players can break normal blocks.", Flags.BREAK_BLOCK, Material.IRON_PICKAXE);
    public static final PrivilegeFlagDefinition BREAK_LIQUID = pri("break_liquid", "Break Liquid", "Whether players can pick up water or lava.", Flags.BREAK_BLOCK, Material.BUCKET);
    public static final PrivilegeFlagDefinition BREAK_FLOWER_POT_ITEM = pri("break_flower_pot_item", "Break Flower Pot Item", "Whether players can remove items from flower pots.", Flags.BREAK_BLOCK, Material.FLOWER_POT);
    public static final PrivilegeFlagDefinition IGNITE_FIRE = pri("ignite_fire", "Ignite Fire", "Whether players can ignite fire.", Flags.IGNITE, Material.FLINT_AND_STEEL);
    public static final PrivilegeFlagDefinition PLACE_ITEM_FRAME = pri("place_item_frame", "Place Item Frame", "Whether players can place item frames.", Flags.PLACE, Material.ITEM_FRAME);
    public static final PrivilegeFlagDefinition BREAK_ITEM_FRAME = pri("break_item_frame", "Break Item Frame", "Whether players can break item frames.", Flags.BREAK_BLOCK, Material.ITEM_FRAME);
    public static final PrivilegeFlagDefinition BREAK_ITEM_FRAME_BY_PROJECTILE = pri("break_item_frame_by_projectile", "Projectile Break Item Frame", "Whether player projectiles can break item frames.", Flags.BREAK_BLOCK, Material.BOW);
    public static final PrivilegeFlagDefinition EDIT_ITEM_FRAME_ITEM = pri("edit_item_frame_item", "Edit Item Frame Item", "Whether players can put or take items from item frames.", Flags.CONTAINER, Material.ITEM_FRAME);
    public static final PrivilegeFlagDefinition ROTATE_ITEM_FRAME = pri("rotate_item_frame", "Rotate Item Frame", "Whether players can rotate item frames.", Flags.ITEM_FRAME_INTERACTIVE, Material.ITEM_FRAME);
    public static final PrivilegeFlagDefinition PLACE_ARMOR_STAND = pri("place_armor_stand", "Place Armor Stand", "Whether players can place armor stands.", Flags.PLACE, Material.ARMOR_STAND);
    public static final PrivilegeFlagDefinition BREAK_ARMOR_STAND = pri("break_armor_stand", "Break Armor Stand", "Whether players can break armor stands.", Flags.BREAK_BLOCK, Material.ARMOR_STAND);
    public static final PrivilegeFlagDefinition EDIT_ARMOR_STAND = pri("edit_armor_stand", "Edit Armor Stand", "Whether players can edit armor stands.", Flags.CONTAINER, Material.ARMOR_STAND);
    public static final PrivilegeFlagDefinition OPEN_CHEST = pri("open_chest", "Open Chest", "Whether players can open chests.", Flags.CONTAINER, Material.CHEST);
    public static final PrivilegeFlagDefinition OPEN_BARREL = pri("open_barrel", "Open Barrel", "Whether players can open barrels.", Flags.CONTAINER, Material.BARREL);
    public static final PrivilegeFlagDefinition OPEN_SHULKER_BOX = pri("open_shulker_box", "Open Shulker Box", "Whether players can open shulker boxes.", Flags.CONTAINER, Material.SHULKER_BOX);
    public static final PrivilegeFlagDefinition OPEN_COPPER_CHEST = pri("open_copper_chest", "Open Copper Chest", "Whether players can open copper chests.", Flags.CONTAINER, Material.CHEST);
    public static final PrivilegeFlagDefinition OPEN_HOPPER = pri("open_hopper", "Open Hopper", "Whether players can open hoppers.", Flags.HOPPER, Material.HOPPER);
    public static final PrivilegeFlagDefinition OPEN_DROPPER = pri("open_dropper", "Open Dropper", "Whether players can open droppers.", Flags.HOPPER, Material.DROPPER);
    public static final PrivilegeFlagDefinition OPEN_DISPENSER = pri("open_dispenser", "Open Dispenser", "Whether players can open dispensers.", Flags.HOPPER, Material.DISPENSER);
    public static final PrivilegeFlagDefinition OPEN_FURNACE = pri("open_furnace", "Open Furnace", "Whether players can open furnaces.", Flags.HOPPER, Material.FURNACE);
    public static final PrivilegeFlagDefinition OPEN_BLAST_FURNACE = pri("open_blast_furnace", "Open Blast Furnace", "Whether players can open blast furnaces.", Flags.HOPPER, Material.BLAST_FURNACE);
    public static final PrivilegeFlagDefinition OPEN_SMOKER = pri("open_smoker", "Open Smoker", "Whether players can open smokers.", Flags.HOPPER, Material.SMOKER);
    public static final PrivilegeFlagDefinition USE_SHELF = pri("use_shelf", "Use Shelf", "Whether players can use shelves.", Flags.CONTAINER, Material.BOOKSHELF);
    public static final PrivilegeFlagDefinition USE_DOOR = pri("use_door", "Use Door", "Whether players can use doors, trapdoors, and fence gates.", Flags.DOOR, Material.OAK_DOOR);
    public static final PrivilegeFlagDefinition USE_BUTTON = pri("use_button", "Use Button", "Whether players can use buttons.", Flags.BUTTON, Material.STONE_BUTTON);
    public static final PrivilegeFlagDefinition USE_LEVER = pri("use_lever", "Use Lever", "Whether players can use levers.", Flags.LEVER, Material.LEVER);
    public static final PrivilegeFlagDefinition TRIGGER_PRESSURE_PLATE = pri("trigger_pressure_plate", "Trigger Pressure Plate", "Whether players can trigger pressure plates.", Flags.PRESSURE, Material.STONE_PRESSURE_PLATE);
    public static final PrivilegeFlagDefinition USE_REPEATER = pri("use_repeater", "Use Repeater", "Whether players can use repeaters.", Flags.REPEATER, Material.REPEATER);
    public static final PrivilegeFlagDefinition USE_COMPARATOR = pri("use_comparator", "Use Comparator", "Whether players can use comparators.", Flags.COMPARER, Material.COMPARATOR);
    public static final PrivilegeFlagDefinition USE_NOTE_BLOCK = pri("use_note_block", "Use Note Block", "Whether players can use note blocks.", Flags.NOTE_BLOCK, Material.NOTE_BLOCK);
    public static final PrivilegeFlagDefinition USE_CRAFTING_TABLE = pri("use_crafting_table", "Use Crafting Table", "Whether players can use crafting tables.", Flags.CRAFT, Material.CRAFTING_TABLE);
    public static final PrivilegeFlagDefinition USE_CRAFTER = pri("use_crafter", "Use Crafter", "Whether players can use crafters.", Flags.CRAFTER, Material.CRAFTING_TABLE);
    public static final PrivilegeFlagDefinition USE_ANVIL = pri("use_anvil", "Use Anvil", "Whether players can use anvils.", Flags.ANVIL, Material.ANVIL);
    public static final PrivilegeFlagDefinition USE_ENCHANTING_TABLE = pri("use_enchanting_table", "Use Enchanting Table", "Whether players can use enchanting tables.", Flags.ENCHANT, Material.ENCHANTING_TABLE);
    public static final PrivilegeFlagDefinition USE_BREWING_STAND = pri("use_brewing_stand", "Use Brewing Stand", "Whether players can use brewing stands.", Flags.BREW, Material.BREWING_STAND);
    public static final PrivilegeFlagDefinition USE_BEACON = pri("use_beacon", "Use Beacon", "Whether players can use beacons.", Flags.BEACON, Material.BEACON);
    public static final PrivilegeFlagDefinition USE_JUKEBOX = pri("use_jukebox", "Use Jukebox", "Whether players can use jukeboxes.", Flags.JUKEBOX, Material.JUKEBOX);
    public static final PrivilegeFlagDefinition USE_LECTERN = pri("use_lectern", "Use Lectern", "Whether players can use lecterns.", Flags.LECTERN, Material.LECTERN);
    public static final PrivilegeFlagDefinition USE_CHISELED_BOOKSHELF = pri("use_chiseled_bookshelf", "Use Chiseled Bookshelf", "Whether players can use chiseled bookshelves.", Flags.BOOKSHELF, Material.CHISELED_BOOKSHELF);
    public static final PrivilegeFlagDefinition USE_DRAGON_EGG = pri("use_dragon_egg", "Use Dragon Egg", "Whether players can use dragon eggs.", Flags.DRAGON_EGG, Material.DRAGON_EGG);
    public static final PrivilegeFlagDefinition EDIT_SIGN = pri("edit_sign", "Edit Sign", "Whether players can edit signs.", Flags.EDIT_SIGN, Material.OAK_SIGN);
    public static final PrivilegeFlagDefinition USE_BED = pri("use_bed", "Use Bed", "Whether players can sleep in beds or set spawn points.", Flags.BED, Material.RED_BED);
    public static final PrivilegeFlagDefinition USE_RESPAWN_ANCHOR = pri("use_respawn_anchor", "Use Respawn Anchor", "Whether players can use respawn anchors.", Flags.ANCHOR, Material.RESPAWN_ANCHOR);
    public static final PrivilegeFlagDefinition EAT_CAKE = pri("eat_cake", "Eat Cake", "Whether players can eat cake.", Flags.CAKE, Material.CAKE);
    public static final PrivilegeFlagDefinition SPAWN_VEHICLE = pri("spawn_vehicle", "Spawn Vehicle", "Whether players can spawn vehicles.", Flags.VEHICLE_SPAWN, Material.MINECART);
    public static final PrivilegeFlagDefinition DESTROY_VEHICLE = pri("destroy_vehicle", "Destroy Vehicle", "Whether players can destroy vehicles.", Flags.VEHICLE_DESTROY, Material.IRON_AXE);
    public static final PrivilegeFlagDefinition HARVEST_CROP = pri("harvest_crop", "Harvest Crop", "Whether players can harvest crops.", Flags.HARVEST, Material.WHEAT);
    public static final PrivilegeFlagDefinition HARVEST_BLOCK = pri("harvest_block", "Harvest Block", "Whether players can harvest blocks.", Flags.HARVEST, Material.WHEAT);
    public static final PrivilegeFlagDefinition PLANT_CROP = pri("plant_crop", "Plant Crop", "Whether players can plant crops.", Flags.SOWING, Material.WHEAT_SEEDS);
    public static final PrivilegeFlagDefinition PLANT_TREE = pri("plant_tree", "Plant Tree", "Whether players can plant saplings.", Flags.SOWING, Material.OAK_SAPLING);
    public static final PrivilegeFlagDefinition USE_FERTILIZER = pri("use_fertilizer", "Use Fertilizer", "Whether players can use fertilizer.", Flags.SOWING, Material.BONE_MEAL);
    public static final PrivilegeFlagDefinition FEED_ANIMAL = pri("feed_animal", "Feed Animal", "Whether players can feed animals.", Flags.FEED, Material.WHEAT);
    public static final PrivilegeFlagDefinition SHEAR_ENTITY = pri("shear_entity", "Shear Entity", "Whether players can shear entities.", Flags.SHEAR, Material.SHEARS);
    public static final PrivilegeFlagDefinition LEASH_ENTITY = pri("leash_entity", "Leash Entity", "Whether players can leash entities.", Flags.LEASH, Material.LEAD);
    public static final PrivilegeFlagDefinition DYE_ENTITY = pri("dye_entity", "Dye Entity", "Whether players can dye entities.", Flags.DYE, Material.LIGHT_BLUE_DYE);
    public static final PrivilegeFlagDefinition HARVEST_HONEY = pri("harvest_honey", "Harvest Honey", "Whether players can harvest honey.", Flags.HONEY, Material.HONEY_BOTTLE);
    public static final PrivilegeFlagDefinition TRADE_VILLAGER = pri("trade_villager", "Trade Villager", "Whether players can trade with villagers.", Flags.TRADE, Material.EMERALD);
    public static final PrivilegeFlagDefinition SHOOT_ARROW = pri("shoot_arrow", "Shoot Arrow", "Whether players can shoot arrows.", Flags.SHOOT, Material.BOW);
    public static final PrivilegeFlagDefinition THROW_TRIDENT = pri("throw_trident", "Throw Trident", "Whether players can throw tridents.", Flags.SHOOT, Material.TRIDENT);
    public static final PrivilegeFlagDefinition SHOOT_FIREBALL = pri("shoot_fireball", "Shoot Fireball", "Whether players can shoot fireballs.", Flags.SHOOT, Material.FIRE_CHARGE);
    public static final PrivilegeFlagDefinition SHOOT_WIND_CHARGE = pri("shoot_wind_charge", "Shoot Wind Charge", "Whether players can shoot wind charges.", Flags.SHOOT, Material.FIRE_CHARGE);
    public static final PrivilegeFlagDefinition THROW_EGG = pri("throw_egg", "Throw Egg", "Whether players can throw eggs.", Flags.EGG, Material.EGG);
    public static final PrivilegeFlagDefinition USE_FISHING_HOOK = pri("use_fishing_hook", "Use Fishing Hook", "Whether players can use fishing hooks.", Flags.HOOK, Material.FISHING_ROD);
    public static final PrivilegeFlagDefinition DAMAGE_PLAYER_MELEE = pri("damage_player_melee", "Melee Damage Player", "Whether players can melee damage players.", Flags.PVP, Material.DIAMOND_SWORD);
    public static final PrivilegeFlagDefinition DAMAGE_PLAYER_PROJECTILE = pri("damage_player_projectile", "Projectile Damage Player", "Whether players can projectile damage players.", Flags.PVP, Material.BOW);
    public static final PrivilegeFlagDefinition DAMAGE_PLAYER_EFFECT = pri("damage_player_effect", "Effect Damage Player", "Whether players can damage players with effects.", Flags.PVP, Material.SPLASH_POTION);
    public static final PrivilegeFlagDefinition DAMAGE_MONSTER = pri("damage_monster", "Damage Monster", "Whether players can damage monsters.", Flags.MONSTER_KILLING, Material.IRON_SWORD);
    public static final PrivilegeFlagDefinition DAMAGE_ANIMAL = pri("damage_animal", "Damage Animal", "Whether players can damage animals.", Flags.ANIMAL_KILLING, Material.COOKED_BEEF);
    public static final PrivilegeFlagDefinition DAMAGE_VILLAGER = pri("damage_villager", "Damage Villager", "Whether players can damage villagers.", Flags.VILLAGER_KILLING, Material.WOODEN_SWORD);
    public static final PrivilegeFlagDefinition PICKUP_ITEM = pri("pickup_item", "Pick Up Item", "Whether players can pick up items.", Flags.PICK_UP, Material.DIAMOND_PICKAXE);
    public static final PrivilegeFlagDefinition DROP_ITEM = pri("drop_item", "Drop Item", "Whether players can drop items.", Flags.DROP_ITEM, Material.IRON_INGOT);
    public static final PrivilegeFlagDefinition TRUST = pri("trust", "Trust", "Player will be able to by pass any flag restrictions (Except for admin flags).", Flags.ADMIN, Material.PLAYER_HEAD);
    
    public static List<EnvironmentFlagDefinition> environmentFlags() {
        return List.of(SPAWN_ANIMAL, SPAWN_VILLAGER, SPAWN_MONSTER, SPAWN_ENDERMAN, SPAWN_WITHER, MOVE_ANIMAL, MOVE_MONSTER,
                MOVE_BLOCK_BY_ENDERMAN, TELEPORT_ENDERMAN, DAMAGE_PLAYER_BY_MONSTER_MELEE, DAMAGE_PLAYER_BY_MONSTER_PROJECTILE,
                DROP_ITEM_BY_MOB, EXPLODE_TNT, EXPLODE_TNT_MINECART, EXPLODE_CREEPER, EXPLODE_WITHER, EXPLODE_WITHER_SKULL,
                EXPLODE_END_CRYSTAL, EXPLODE_FIREBALL, EXPLODE_SMALL_FIREBALL, EXPLODE_DRAGON_FIREBALL, EXPLODE_BED,
                EXPLODE_RESPAWN_ANCHOR, BREAK_BLOCK_BY_ENDER_DRAGON, BREAK_BLOCK_BY_WITHER, SPREAD_FIRE, BURN_BLOCK,
                BURN_ENTITY, FLOW_LIQUID_INTO, FALL_GRAVITY_BLOCK, MELT_ICE, FORM_ICE, ACCUMULATE_SNOW, MELT_SNOW,
                DECAY_LEAVES, TRAMPLE_FARMLAND_BY_PLAYER, TRAMPLE_FARMLAND_BY_MOB, TRANSFER_HOPPER_OUTSIDE,
                PUSH_PISTON_CROSS_BORDER, TRIGGER_PRESSURE_BY_PROJECTILE, TRIGGER_PRESSURE_BY_MOB, TRIGGER_PRESSURE_BY_ITEM,
                DAMAGE_ITEM_FRAME_BY_NON_PLAYER, DAMAGE_ARMOR_STAND_BY_NON_PLAYER, DAMAGE_BOAT_BY_NON_PLAYER,
                DAMAGE_MINECART_BY_NON_PLAYER, SHOW_BORDER);
    }

    public static List<PrivilegeFlagDefinition> privilegeFlags() {
        return List.of(MANAGE_MEMBERS, MANAGE_GROUPS, MANAGE_FLAGS, MOVE_PLAYER, TELEPORT_TO_DOMINION, FLY_PLAYER,
                RIDE_VEHICLE, THROW_ENDER_PEARL, TRIGGER_RAID, PLACE_BLOCK, PLACE_LIQUID, PLACE_FLOWER_POT_ITEM,
                BREAK_BLOCK, BREAK_LIQUID, BREAK_FLOWER_POT_ITEM, IGNITE_FIRE, PLACE_ITEM_FRAME, BREAK_ITEM_FRAME,
                BREAK_ITEM_FRAME_BY_PROJECTILE, EDIT_ITEM_FRAME_ITEM, ROTATE_ITEM_FRAME, PLACE_ARMOR_STAND,
                BREAK_ARMOR_STAND, EDIT_ARMOR_STAND, OPEN_CHEST, OPEN_BARREL, OPEN_SHULKER_BOX, OPEN_COPPER_CHEST,
                OPEN_HOPPER, OPEN_DROPPER, OPEN_DISPENSER, OPEN_FURNACE, OPEN_BLAST_FURNACE, OPEN_SMOKER, USE_SHELF,
                USE_DOOR, USE_BUTTON, USE_LEVER, TRIGGER_PRESSURE_PLATE, USE_REPEATER, USE_COMPARATOR, USE_NOTE_BLOCK,
                USE_CRAFTING_TABLE, USE_CRAFTER, USE_ANVIL, USE_ENCHANTING_TABLE, USE_BREWING_STAND, USE_BEACON,
                USE_JUKEBOX, USE_LECTERN, USE_CHISELED_BOOKSHELF, USE_DRAGON_EGG, EDIT_SIGN, USE_BED, USE_RESPAWN_ANCHOR,
                EAT_CAKE, SPAWN_VEHICLE, DESTROY_VEHICLE, HARVEST_CROP, HARVEST_BLOCK, PLANT_CROP, PLANT_TREE,
                USE_FERTILIZER, FEED_ANIMAL, SHEAR_ENTITY, LEASH_ENTITY, DYE_ENTITY, HARVEST_HONEY, TRADE_VILLAGER,
                SHOOT_ARROW, THROW_TRIDENT, SHOOT_FIREBALL, SHOOT_WIND_CHARGE, THROW_EGG, USE_FISHING_HOOK,
                DAMAGE_PLAYER_MELEE, DAMAGE_PLAYER_PROJECTILE, DAMAGE_PLAYER_EFFECT, DAMAGE_MONSTER, DAMAGE_ANIMAL,
                DAMAGE_VILLAGER, PICKUP_ITEM, DROP_ITEM, TRUST);
    }

    private static EnvironmentFlagDefinition env(String id, String displayName, String description, Flag parent, Material material) {
        return new EnvironmentFlagDefinition(id, displayName, description, parent.getDefaultValue(), parent.getEnable(), material);
    }

    private static PrivilegeFlagDefinition pri(String id, String displayName, String description, Flag parent, Material material) {
        return new PrivilegeFlagDefinition(id, displayName, description, parent.getDefaultValue(), parent.getEnable(), material);
    }
}
