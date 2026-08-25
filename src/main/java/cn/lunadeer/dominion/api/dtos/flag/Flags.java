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

/**
 * Built-in environment and privilege flags and the flag registry.
 * <p>
 * The public constants are the canonical flag instances. Custom flags can be
 * registered with {@link #registerEnvFlag(JavaPlugin, EnvFlag)} or
 * {@link #registerPriFlag(JavaPlugin, PriFlag)}. Legacy constants are kept
 * for migration and are not returned by the active-flag lookup methods.
 */
public class Flags {
        // ================================== ENV(Environment)

        // animals
        /** Controls natural or world-generated animal spawning. */
        public static final EnvFlag ANIMAL_SPAWN = new EnvFlag("animal_spawn", "Animal Spawn",
                        "Whether animals can spawn through natural or world-generated spawning (not breeding, spawners or spawn eggs).", true, false,
                        Material.COW_SPAWN_EGG, "minecraft:items/item/cow_spawn_egg");
        /** Controls animal breeding. */
        public static final EnvFlag ANIMAL_BREED = new EnvFlag("animal_breed", "Animal Breeding",
                        "Whether animal breeding can create offspring.", true, false, Material.WHEAT, "minecraft:items/item/wheat");
        /** Controls animal spawning from monster spawners. */
        public static final EnvFlag ANIMAL_SPAWNER = new EnvFlag("animal_spawner", "Animal Spawner",
                        "Whether animals can spawn from monster spawners.", true, false, Material.SPAWNER, "minecraft:blocks/block/spawner");
        /** Controls creation of animals with spawn eggs. */
        public static final EnvFlag ANIMAL_SPAWN_EGG = new EnvFlag("animal_spawn_egg", "Animal Spawn Egg",
                        "Whether animals can be created with spawn eggs.", true, false, Material.COW_SPAWN_EGG, "minecraft:items/item/cow_spawn_egg");
        /** Controls animal movement inside a dominion. */
        public static final EnvFlag ANIMAL_MOVE = new EnvFlag("animal_move", "Animal Move",
                        "Whether animals can move in dominion.", true, false, Material.CHERRY_FENCE, "minecraft:blocks/block/cherry_planks");
        /** Controls natural or world-generated villager spawning. */
        public static final EnvFlag VILLAGER_SPAWN = new EnvFlag("villager_spawn", "Villager Spawn",
                        "Whether villagers can spawn through natural or world-generated spawning (not breeding, spawners or spawn eggs).", true, false,
                        Material.VILLAGER_SPAWN_EGG, "minecraft:items/item/villager_spawn_egg");
        /** Controls villager breeding. */
        public static final EnvFlag VILLAGER_BREED = new EnvFlag("villager_breed", "Villager Breeding",
                        "Whether villager breeding can create children.", true, false, Material.BREAD, "minecraft:items/item/bread");
        /** Controls villager spawning from monster spawners. */
        public static final EnvFlag VILLAGER_SPAWNER = new EnvFlag("villager_spawner", "Villager Spawner",
                        "Whether villagers can spawn from monster spawners.", true, false, Material.SPAWNER, "minecraft:blocks/block/spawner");
        /** Controls creation of villagers with spawn eggs. */
        public static final EnvFlag VILLAGER_SPAWN_EGG = new EnvFlag("villager_spawn_egg", "Villager Spawn Egg",
                        "Whether villagers can be created with spawn eggs.", true, false, Material.VILLAGER_SPAWN_EGG, "minecraft:items/item/villager_spawn_egg");

        // monster
        /** Controls natural or world-generated monster spawning. */
        public static final EnvFlag MONSTER_SPAWN = new EnvFlag("monster_spawn", "Monster Spawn",
                        "Whether monsters can spawn through natural or world-generated spawning (not spawners or spawn eggs).", false, false, Material.ZOMBIE_SPAWN_EGG, "minecraft:items/item/zombie_spawn_egg");
        /** Controls monster spawning from monster spawners. */
        public static final EnvFlag MONSTER_SPAWNER = new EnvFlag("monster_spawner", "Monster Spawner",
                        "Whether monsters can spawn from monster spawners.", false, false, Material.SPAWNER, "minecraft:blocks/block/spawner");
        /** Controls creation of monsters with spawn eggs. */
        public static final EnvFlag MONSTER_SPAWN_EGG = new EnvFlag("monster_spawn_egg", "Monster Spawn Egg",
                        "Whether monsters can be created with spawn eggs.", true, false, Material.ZOMBIE_SPAWN_EGG, "minecraft:items/item/zombie_spawn_egg");
        /** Controls monster movement inside a dominion. */
        public static final EnvFlag MONSTER_MOVE = new EnvFlag("monster_move", "Monster Move",
                        "Whether monster can move in dominion.", true, false, Material.CRIMSON_FENCE, "minecraft:blocks/block/crimson_planks");
        /** Controls damage dealt to players by monsters. */
        public static final EnvFlag MONSTER_DAMAGE = new EnvFlag("monster_damage", "Monster Kill Player",
                        "Whether monster can do harm to player.", true, false, Material.SKELETON_SPAWN_EGG, "minecraft:items/item/skeleton_spawn_egg");
        /** Former combined Enderman block movement flag retained for migration. */
        @Deprecated
        public static final EnvFlag ENDER_MAN = new EnvFlag("ender_man", "Enderman Block Movement",
                        "Former combined permission for Endermen picking up or placing blocks.", false, true, Material.ENDERMAN_SPAWN_EGG, "minecraft:items/item/enderman_spawn_egg");
        /** Controls Endermen picking up blocks. */
        public static final EnvFlag ENDER_MAN_PICKUP_BLOCK = new EnvFlag("ender_man_pickup_block", "Enderman Pick Up Block",
                        "Whether Endermen can pick up blocks.", false, true, Material.ENDERMAN_SPAWN_EGG, "minecraft:items/item/enderman_spawn_egg");
        /** Controls Endermen placing blocks. */
        public static final EnvFlag ENDER_MAN_PLACE_BLOCK = new EnvFlag("ender_man_place_block", "Enderman Place Block",
                        "Whether Endermen can place blocks.", false, true, Material.ENDERMAN_SPAWN_EGG, "minecraft:items/item/enderman_spawn_egg");
        /** Controls Enderman spawning. */
        public static final EnvFlag ENDER_MAN_SPAWN = new EnvFlag("ender_man_spawn", "Enderman Spawn",
                        "Whether endermen can spawn.", false, true, Material.ENDERMAN_SPAWN_EGG, "minecraft:items/item/enderman_spawn_egg");
        /** Controls Enderman teleportation. */
        public static final EnvFlag ENDER_MAN_TELEPORT = new EnvFlag("ender_man_teleport", "Enderman Teleport",
                        "Whether endermen can teleport.", false, true, Material.ENDER_PEARL, "minecraft:items/item/ender_pearl");

        // explode
        /** Controls TNT explosion block damage. */
        public static final EnvFlag TNT_EXPLODE = new EnvFlag("tnt_explode", "TNT Block Damage",
                        "Whether TNT explosions can destroy blocks.", false, true, Material.TNT, "minecraft:blocks/block/tnt_side");
        /** Controls TNT explosion damage to ordinary entities. */
        public static final EnvFlag TNT_DAMAGE_ENTITY = new EnvFlag("tnt_damage_entity", "TNT Entity Damage",
                        "Whether TNT explosions can damage entities other than armor stands and hanging entities.", false, true, Material.TNT, "minecraft:blocks/block/tnt_side");
        /** Controls Wither spawning. */
        public static final EnvFlag WITHER_SPAWN = new EnvFlag("wither_spawn", "Wither Spawn",
                        "Whether withers can spawn.", false, true, Material.WITHER_SKELETON_SKULL, "minecraft:blocks/block/stone");
        /** Controls block damage caused by a Wither spawning explosion. */
        public static final EnvFlag WITHER_EXPLODE = new EnvFlag("wither_explode", "Wither Spawn Explosion",
                        "Whether a spawning wither can destroy blocks.", false, true, Material.NETHER_STAR, "minecraft:items/item/nether_star");
        /** Controls block breaking caused by an injured Wither. */
        public static final EnvFlag WITHER_BREAK_BLOCK = new EnvFlag("wither_break_block", "Wither Block Breaking",
                        "Whether a harmed wither can break blocks.", false, true, Material.WITHER_SKELETON_SKULL, "minecraft:blocks/block/stone");
        /** Controls Creeper explosion block damage. */
        public static final EnvFlag CREEPER_EXPLODE = new EnvFlag("creeper_explode", "Creeper Block Damage",
                        "Whether creeper explosions can destroy blocks.", false, true, Material.CREEPER_HEAD, "minecraft:blocks/block/stone");
        /** Controls Creeper explosion damage to ordinary entities. */
        public static final EnvFlag CREEPER_DAMAGE_ENTITY = new EnvFlag("creeper_damage_entity",
                        "Creeper Entity Damage",
                        "Whether creeper explosions can damage entities other than armor stands and hanging entities.", false, true,
                        Material.CREEPER_HEAD, "minecraft:blocks/block/stone");
        /** Controls Wither Skull explosion block damage. */
        public static final EnvFlag WITHER_SKULL_EXPLODE = new EnvFlag("wither_skull_explode",
                        "Wither Skull Block Damage", "Whether wither skull explosions can destroy blocks.", false, true,
                        Material.WITHER_SKELETON_SKULL, "minecraft:blocks/block/stone");
        /** Controls Wither Skull explosion damage to ordinary entities. */
        public static final EnvFlag WITHER_SKULL_DAMAGE_ENTITY = new EnvFlag("wither_skull_damage_entity",
                        "Wither Skull Entity Damage",
                        "Whether wither skull explosions can damage entities other than armor stands and hanging entities.", false, true,
                        Material.WITHER_SKELETON_SKULL, "minecraft:blocks/block/stone");
        /** Controls End Crystal explosion block damage. */
        public static final EnvFlag ENDER_CRYSTAL_EXPLODE = new EnvFlag("ender_crystal_explode",
                        "End Crystal Block Damage", "Whether end crystal explosions can destroy blocks.", false, true,
                        Material.END_CRYSTAL, "minecraft:items/item/end_crystal");
        /** Controls End Crystal explosion damage to ordinary entities. */
        public static final EnvFlag ENDER_CRYSTAL_DAMAGE_ENTITY = new EnvFlag("ender_crystal_damage_entity",
                        "End Crystal Entity Damage",
                        "Whether end crystal explosions can damage entities other than armor stands and hanging entities.", false, true,
                        Material.END_CRYSTAL, "minecraft:items/item/end_crystal");
        /** Controls Fireball explosion block damage. */
        public static final EnvFlag FIREBALL_EXPLODE = new EnvFlag("fireball_explode", "Fireball Block Damage",
                        "Whether fireball explosions can destroy blocks.", false, true, Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Controls Fireball explosion damage to ordinary entities. */
        public static final EnvFlag FIREBALL_DAMAGE_ENTITY = new EnvFlag("fireball_damage_entity",
                        "Fireball Entity Damage",
                        "Whether fireball explosions can damage entities other than armor stands and hanging entities.", false, true,
                        Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Controls TNT explosion damage to armor stands. */
        public static final EnvFlag TNT_DAMAGE_ARMOR_STAND = new EnvFlag("tnt_damage_armor_stand",
                        "TNT Armor Stand Damage", "Whether TNT explosions can damage armor stands.", false, true,
                        Material.TNT, "minecraft:blocks/block/tnt_side");
        /** Controls TNT explosion damage to hanging entities. */
        public static final EnvFlag TNT_DAMAGE_HANGING_ENTITY = new EnvFlag("tnt_damage_hanging_entity",
                        "TNT Hanging Entity Damage", "Whether TNT explosions can damage hanging entities.", false, true,
                        Material.TNT, "minecraft:blocks/block/tnt_side");
        /** Controls Creeper explosion damage to armor stands. */
        public static final EnvFlag CREEPER_DAMAGE_ARMOR_STAND = new EnvFlag("creeper_damage_armor_stand",
                        "Creeper Armor Stand Damage", "Whether creeper explosions can damage armor stands.", false, true,
                        Material.CREEPER_HEAD, "minecraft:blocks/block/stone");
        /** Controls Creeper explosion damage to hanging entities. */
        public static final EnvFlag CREEPER_DAMAGE_HANGING_ENTITY = new EnvFlag("creeper_damage_hanging_entity",
                        "Creeper Hanging Entity Damage", "Whether creeper explosions can damage hanging entities.", false, true,
                        Material.CREEPER_HEAD, "minecraft:blocks/block/stone");
        /** Controls Wither Skull explosion damage to armor stands. */
        public static final EnvFlag WITHER_SKULL_DAMAGE_ARMOR_STAND = new EnvFlag("wither_skull_damage_armor_stand",
                        "Wither Skull Armor Stand Damage", "Whether wither skull explosions can damage armor stands.", false, true,
                        Material.WITHER_SKELETON_SKULL, "minecraft:blocks/block/stone");
        /** Controls Wither Skull explosion damage to hanging entities. */
        public static final EnvFlag WITHER_SKULL_DAMAGE_HANGING_ENTITY = new EnvFlag("wither_skull_damage_hanging_entity",
                        "Wither Skull Hanging Entity Damage", "Whether wither skull explosions can damage hanging entities.", false, true,
                        Material.WITHER_SKELETON_SKULL, "minecraft:blocks/block/stone");
        /** Controls End Crystal explosion damage to armor stands. */
        public static final EnvFlag ENDER_CRYSTAL_DAMAGE_ARMOR_STAND = new EnvFlag("ender_crystal_damage_armor_stand",
                        "End Crystal Armor Stand Damage", "Whether end crystal explosions can damage armor stands.", false, true,
                        Material.END_CRYSTAL, "minecraft:items/item/end_crystal");
        /** Controls End Crystal explosion damage to hanging entities. */
        public static final EnvFlag ENDER_CRYSTAL_DAMAGE_HANGING_ENTITY = new EnvFlag("ender_crystal_damage_hanging_entity",
                        "End Crystal Hanging Entity Damage", "Whether end crystal explosions can damage hanging entities.", false, true,
                        Material.END_CRYSTAL, "minecraft:items/item/end_crystal");
        /** Controls Fireball explosion damage to armor stands. */
        public static final EnvFlag FIREBALL_DAMAGE_ARMOR_STAND = new EnvFlag("fireball_damage_armor_stand",
                        "Fireball Armor Stand Damage", "Whether fireball explosions can damage armor stands.", false, true,
                        Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Controls Fireball explosion damage to hanging entities. */
        public static final EnvFlag FIREBALL_DAMAGE_HANGING_ENTITY = new EnvFlag("fireball_damage_hanging_entity",
                        "Fireball Hanging Entity Damage", "Whether fireball explosions can damage hanging entities.", false, true,
                        Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Controls bed explosions and their block damage. */
        public static final EnvFlag BED_EXPLODE = new EnvFlag("bed_explode", "Bed Explosion Block Damage",
                        "Whether beds can explode and destroy blocks in this dominion.", false, true,
                        Material.RED_BED, "minecraft:blocks/block/red_bed_foot_east");
        /** Controls respawn-anchor explosions and their block damage. */
        public static final EnvFlag ANCHOR_EXPLODE = new EnvFlag("anchor_explode", "Respawn Anchor Explosion Block Damage",
                        "Whether respawn anchors can explode and destroy blocks in this dominion.", false, true,
                        Material.RESPAWN_ANCHOR, "minecraft:blocks/block/respawn_anchor_top");
        /** Former combined bed and respawn-anchor explosion flag retained for migration. */
        @Deprecated
        public static final EnvFlag BLOCK_EXPLODE = new EnvFlag("block_explode", "Bed and Anchor Block Damage",
                        "Former combined permission for bed and respawn-anchor explosions destroying blocks.", false, true,
                        Material.RESPAWN_ANCHOR, "minecraft:blocks/block/respawn_anchor_top");
        /** Controls Ender Dragon block breaking. */
        public static final EnvFlag DRAGON_BREAK_BLOCK = new EnvFlag("dragon_break_block", "Ender Dragon Break Block",
                        "Whether ender dragon can break blocks.", false, true, Material.ENDER_DRAGON_SPAWN_EGG, "minecraft:items/item/ender_dragon_spawn_egg");

        // natural
        /** Controls fire spreading. */
        public static final EnvFlag FIRE_SPREAD = new EnvFlag("fire_spread", "Fire Spread",
                        "Prevent fire spread in dominion.", false, true, Material.FLINT_AND_STEEL, "minecraft:items/item/flint_and_steel");
        /** Former combined burn flag from before block/entity burning was split. */
        @Deprecated
        public static final EnvFlag BURN = new EnvFlag("burn", "Burn (Legacy)",
                        "Former combined permission for blocks burning and entities taking heat damage.", false, true,
                        Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Controls blocks burning. */
        public static final EnvFlag BURN_BLOCK = new EnvFlag("burn_block", "Burn Block", "Whether blocks can burn.",
                        false, true, Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Former combined fire/lava entity damage flag retained for migration. */
        @Deprecated
        public static final EnvFlag BURN_ENTITY = new EnvFlag("burn_entity", "Burn Entity",
                        "Former combined permission for fire and lava damage to entities (not players).", true, true,
                        Material.CAMPFIRE, "minecraft:items/item/campfire");
        /** Controls non-player entities taking fire damage. */
        public static final EnvFlag BURN_ENTITY_FIRE = new EnvFlag("burn_entity_fire", "Burn Entity (Fire)",
                        "Whether entities other than players can burn or take fire damage.", true, true,
                        Material.CAMPFIRE, "minecraft:items/item/campfire");
        /** Controls non-player entities taking lava or hot-floor damage. */
        public static final EnvFlag BURN_ENTITY_LAVA = new EnvFlag("burn_entity_lava", "Burn Entity (Lava)",
                        "Whether entities other than players can take lava or hot-floor damage.", true, true,
                        Material.LAVA_BUCKET, "minecraft:items/item/lava_bucket");
        /** Controls external water flowing into the dominion. */
        public static final EnvFlag FLOW_IN_WATER = new EnvFlag("flow_in_water", "Water Flow In",
                        "Whether external water can flow into this dominion.", false, true, Material.WATER_BUCKET, "minecraft:items/item/water_bucket");
        /** Controls external lava flowing into the dominion. */
        public static final EnvFlag FLOW_IN_LAVA = new EnvFlag("flow_in_lava", "Lava Flow In",
                        "Whether external lava can flow into this dominion.", false, true, Material.LAVA_BUCKET, "minecraft:items/item/lava_bucket");
        /** Former combined water/lava flow flag retained for migration. */
        @Deprecated
        public static final EnvFlag FLOW_IN_PROTECTION = new EnvFlag("flow_in_protection", "Water and Lava Flow In",
                        "Former combined permission for external water and lava flow into this dominion.", false, true, Material.WATER_BUCKET, "minecraft:items/item/water_bucket");
        /** Controls gravity-affected blocks falling inside the dominion. */
        public static final EnvFlag GRAVITY_BLOCK = new EnvFlag("gravity_block", "Falling Block",
                        "Whether gravity block can fall in dominion (false will make them to item).", false, true,
                        Material.SAND, "minecraft:blocks/block/sand");
        /** Controls ice melting. */
        public static final EnvFlag ICE_MELT = new EnvFlag("ice_melt", "Ice Melt", "Whether to allow ice to melt.",
                        false, false, Material.ICE, "minecraft:blocks/block/ice");
        /** Controls natural ice formation. */
        public static final EnvFlag ICE_FORM_NATURAL = new EnvFlag("ice_form_natural", "Natural Ice Form",
                        "Whether ice can form through natural environmental changes.", false, true, Material.ICE, "minecraft:blocks/block/ice");
        /** Controls ice formation caused by Frost Walker. */
        public static final EnvFlag ICE_FORM_FROST_WALKER = new EnvFlag("ice_form_frost_walker", "Frost Walker Ice Form",
                        "Whether Frost Walker can create ice.", false, true, Material.PACKED_ICE, "minecraft:blocks/block/packed_ice");
        /** Former combined natural and Frost Walker ice formation flag retained for migration. */
        @Deprecated
        public static final EnvFlag ICE_FORM = new EnvFlag("ice_form", "Ice Form",
                        "Former combined permission for natural ice formation and Frost Walker.", false, true, Material.PACKED_ICE, "minecraft:blocks/block/packed_ice");
        /** Controls snow accumulation. */
        public static final EnvFlag SNOW_ACCUMULATION = new EnvFlag("snow_accumulation", "Snow Accumulation",
                        "Whether to allow snow accumulation.", false, false, Material.SNOW, "minecraft:blocks/block/snow");
        /** Controls snow melting. */
        public static final EnvFlag SNOW_MELT = new EnvFlag("snow_melt", "Snow Melt", "Whether to allow snow to melt.",
                        false, false, Material.SNOW_BLOCK, "minecraft:blocks/block/stone");
        /** Controls player trampling of farmland. */
        public static final EnvFlag TRAMPLE = new EnvFlag("trample", "Player Trample Farmland",
                        "Whether players can trample farmland.", false, true, Material.FARMLAND, "minecraft:blocks/block/farmland");
        /** Controls non-player entities trampling farmland. */
        public static final EnvFlag MOB_TRAMPLE = new EnvFlag("mob_trample", "Mob Trample Farmland",
                        "Whether non-player entities can trample farmland.", false, true, Material.FARMLAND, "minecraft:blocks/block/farmland");
        /** Controls leaf decay. */
        public static final EnvFlag DECAY = new EnvFlag("decay", "Leaf Decay", "Whether leaves can decay.", false, true,
                        Material.OAK_LEAVES, "minecraft:blocks/block/oak_leaves");

        // red stone stuff
        /** Controls an outside hopper pulling from containers in the dominion. */
        public static final EnvFlag HOPPER_OUTSIDE = new EnvFlag("hopper_outside", "Hopper (Outside)",
                        "False to prevent outside hopper from sucking container in dominion.", false, true,
                        Material.HOPPER, "minecraft:items/item/hopper");
        /** Controls pistons crossing the dominion boundary. */
        public static final EnvFlag PISTON_OUTSIDE = new EnvFlag("piston_outside", "Piston",
                        "False to prevent piston from pushing/pulling blocks across dominion.", false, true,
                        Material.PISTON, "minecraft:blocks/block/piston_side");
        /** Controls projectile-triggered pressure plates. */
        public static final EnvFlag TRIG_PRESSURE_PROJ = new EnvFlag("trig_pressure_proj",
                        "Pressure Plate (Projectile)", "When projectile (arrow/snowball) can trigger pressure plate.",
                        false, true, Material.BIRCH_PRESSURE_PLATE, "minecraft:blocks/block/birch_planks");
        /** Controls mob-triggered pressure plates. */
        public static final EnvFlag TRIG_PRESSURE_MOB = new EnvFlag("trig_pressure_mob", "Pressure Plate (Mob)",
                        "Whether mob (player not included) can trigger pressure plate.", false, true,
                        Material.HEAVY_WEIGHTED_PRESSURE_PLATE, "minecraft:blocks/block/iron_block");
        /** Controls dropped-item-triggered pressure plates. */
        public static final EnvFlag TRIG_PRESSURE_DROP = new EnvFlag("trig_pressure_drop", "Pressure Plate (Dropping)",
                        "Whether dropping items can trigger pressure plate.", false, true,
                        Material.LIGHT_WEIGHTED_PRESSURE_PLATE, "minecraft:blocks/block/gold_block");

        // other
        /**
         * The former coarse hanging-entity projectile flag. It is retained as
         * a migration source for existing configuration and database columns,
         * but is not registered as an active flag anymore.
         */
        @Deprecated
        public static final EnvFlag ITEM_FRAME_PROJ_DAMAGE = new EnvFlag("item_frame_proj_damage",
                        "Projectile Damage Item Frame", "Whether projectile (arrow/snowball) can break item frame.",
                        false, true, Material.ITEM_FRAME, "minecraft:items/item/item_frame");
        /** Controls non-player entities damaging armor stands. */
        public static final EnvFlag ARMOR_STAND_MOB_DAMAGE = new EnvFlag("armor_stand_mob_damage",
                        "Armor Stand Mob Damage", "Whether non-player entities can damage armor stands.",
                        false, true, Material.ARMOR_STAND, "minecraft:items/item/armor_stand");
        /** Controls non-player entities damaging hanging entities. */
        public static final EnvFlag HANGING_ENTITY_MOB_DAMAGE = new EnvFlag("hanging_entity_mob_damage",
                        "Hanging Entity Mob Damage", "Whether non-player entities can damage hanging entities.",
                        false, true, Material.ITEM_FRAME, "minecraft:items/item/item_frame");
        /** Former source-agnostic explosion damage flag retained for migration. */
        @Deprecated
        public static final EnvFlag ARMOR_STAND_EXPLOSION_DAMAGE = new EnvFlag("armor_stand_explosion_damage",
                        "Armor Stand Explosion Damage (Legacy)", "Former source-agnostic permission for explosions damaging armor stands.",
                        false, true, Material.ARMOR_STAND, "minecraft:items/item/armor_stand");
        /** Former source-agnostic explosion damage flag retained for migration. */
        @Deprecated
        public static final EnvFlag HANGING_ENTITY_EXPLOSION_DAMAGE = new EnvFlag("hanging_entity_explosion_damage",
                        "Hanging Entity Explosion Damage (Legacy)", "Former source-agnostic permission for explosions damaging hanging entities.",
                        false, true, Material.ITEM_FRAME, "minecraft:items/item/item_frame");
        /** Controls whether mobs drop items when killed. */
        public static final EnvFlag MOB_DROP_ITEM = new EnvFlag("mob_drop_item", "Mob Drop Item",
                        "Whether mob drop item when killed.", true, true, Material.DIAMOND, "minecraft:items/item/diamond");
        /** Controls whether a dominion border is shown to entering players. */
        public static final EnvFlag SHOW_BORDER = new EnvFlag("show_border", "Show Border",
                        "Show dominion border to player when walking in.", true, true, Material.BRICK_WALL, "minecraft:blocks/block/bricks");

        // ================================== PRI(Privilege)

        // administration
        /** Allows managing ordinary members and groups. */
        public static final PriFlag ADMIN = new PriFlag("admin", "Administrator",
                        "Member with this flag can manage normal members and groups.", false, true,Material.NETHER_STAR, "minecraft:items/item/nether_star");
        /** Allows resizing a dominion. */
        public static final PriFlag RESIZE = new PriFlag("resize", "Resize Dominion",
                        "Member with this flag can resize dominion.", false, true, Material.OAK_SIGN, "minecraft:items/item/oak_sign");
        /** Allows renaming a dominion. */
        public static final PriFlag RENAME = new PriFlag("rename_dominion", "Rename Dominion",
                        "Member with this flag can rename dominion.", false, true, Material.NAME_TAG, "minecraft:items/item/name_tag");
        /** Allows creating sub-dominions. */
        public static final PriFlag CREATE_SUB = new PriFlag("create_sub", "Create Sub-Dominion",
                        "Member with this flag can create sub-dominion.", false, true, Material.GREEN_DYE, "minecraft:items/item/green_dye");
        /** Allows deleting sub-dominions. */
        public static final PriFlag DELETE_SUB = new PriFlag("delete_sub", "Delete Sub-Dominion",
                        "Member with this flag can delete sub-dominion.", false, true, Material.RED_DYE, "minecraft:items/item/red_dye");
        /** Allows resizing sub-dominions. */
        public static final PriFlag RESIZE_SUB = new PriFlag("resize_sub", "Resize Sub-Dominion",
                        "Member with this flag can resize sub-dominion.", false, true, Material.BAMBOO_SIGN, "minecraft:items/item/bamboo_sign");
        /** Allows renaming sub-dominions. */
        public static final PriFlag RENAME_SUB = new PriFlag("rename_sub", "Rename Sub-Dominion",
                        "Member with this flag can rename sub-dominion.", false, true, Material.WRITABLE_BOOK, "minecraft:items/item/writable_book");

        // movement and teleportation
        /** Controls player movement inside a dominion. */
        public static final PriFlag MOVE = new PriFlag("move", "Player Move", "Whether player can move in dominion.",
                        true, true, Material.LEATHER_BOOTS, "minecraft:items/item/leather_boots");
        /** Controls teleportation to the dominion. */
        public static final PriFlag TELEPORT = new PriFlag("teleport", "Teleportation",
                        "False means can't teleport to this dominion.", false, true, Material.ENDER_EYE, "minecraft:items/item/ender_eye");
        /** Controls creative-style flight; it does not control elytra flight. */
        public static final PriFlag FLY = new PriFlag("fly", "Fly", "NOT elytra fly, it's like creative mode fly.",
                        false, false, Material.ELYTRA, "minecraft:items/item/elytra");
        /** Controls riding vehicles and rideable entities. */
        public static final PriFlag RIDING = new PriFlag("riding", "Riding",
                        "Whether can ride vehicle (boat, minecart, horse etc.).", false, true, Material.SADDLE, "minecraft:items/item/saddle");
        /** Controls throwing ender pearls. */
        public static final PriFlag ENDER_PEARL = new PriFlag("ender_pearl", "End Pearl",
                        "Whether can throw ender pearl.", false, true, Material.ENDER_PEARL, "minecraft:items/item/ender_pearl");
        /** Controls triggering raids. */
        public static final PriFlag RAID = new PriFlag("raid", "Raid", "Whether can trigger raid.", false, true,
                        Material.IRON_AXE, "minecraft:items/item/iron_axe");

        // building and placing
        /** Controls ordinary block placement. */
        public static final PriFlag PLACE = new PriFlag("place", "Place Block",
                        "Whether normal blocks can be placed (not flower-pot contents).", false, true,
                        Material.GRASS_BLOCK, "minecraft:blocks/block/grass_block_side");
        /** Controls placing contents into flower pots. */
        public static final PriFlag PLACE_FLOWER_POT_CONTENT = new PriFlag("place_flower_pot_content", "Place Flower Pot Content",
                        "Whether flowers and other contents can be placed into flower pots.", false, true,
                        Material.FLOWER_POT, "minecraft:blocks/block/flower_pot");
        /** Controls placing water and lava. */
        public static final PriFlag PLACE_LIQUID = new PriFlag("place_liquid", "Place Liquid",
                        "Whether water and lava can be placed.", false, true, Material.WATER_BUCKET, "minecraft:items/item/water_bucket");
        /** Former coarse decorative-entity placement flag retained for migration. */
        @Deprecated
        public static final PriFlag PLACE_ENTITY = new PriFlag("place_entity", "Place Decorative Entity",
                        "Whether armor stands and item frames can be placed.", false, true, Material.ARMOR_STAND, "minecraft:items/item/armor_stand");
        /** Controls placing armor stands. */
        public static final PriFlag PLACE_ARMOR_STAND = new PriFlag("place_armor_stand", "Place Armor Stand",
                        "Whether armor stands can be placed.", false, true, Material.ARMOR_STAND, "minecraft:items/item/armor_stand");
        /** Controls placing hanging entities. */
        public static final PriFlag PLACE_HANGING_ENTITY = new PriFlag("place_hanging_entity", "Place Hanging Entity",
                        "Whether hanging entities can be placed.", false, true, Material.ITEM_FRAME, "minecraft:items/item/item_frame");
        /** Controls ordinary block breaking. */
        public static final PriFlag BREAK_BLOCK = new PriFlag("break", "Break Block",
                        "Whether normal blocks can be removed (not flower-pot contents).", false, true,
                        Material.IRON_PICKAXE, "minecraft:items/item/iron_pickaxe");
        /** Controls removing contents from flower pots. */
        public static final PriFlag BREAK_FLOWER_POT_CONTENT = new PriFlag("break_flower_pot_content", "Break Flower Pot Content",
                        "Whether flowers and other contents can be removed from flower pots.", false, true,
                        Material.FLOWER_POT, "minecraft:blocks/block/flower_pot");
        /** Controls collecting water and lava. */
        public static final PriFlag BREAK_LIQUID = new PriFlag("break_liquid", "Collect Liquid",
                        "Whether water and lava can be collected.", false, true, Material.BUCKET, "minecraft:items/item/bucket");
        /** Former coarse decorative-entity breaking flag retained for migration. */
        @Deprecated
        public static final PriFlag BREAK_ENTITY = new PriFlag("break_entity", "Break Decorative Entity",
                        "Whether armor stands and item frames can be broken.", false, true, Material.IRON_AXE, "minecraft:items/item/iron_axe");
        /** Controls directly breaking armor stands. */
        public static final PriFlag ARMOR_STAND_DIRECT_BREAK = new PriFlag("armor_stand_direct_break",
                        "Directly Break Armor Stand", "Whether players can directly break armor stands.", false, true,
                        Material.ARMOR_STAND, "minecraft:items/item/armor_stand");
        /** Controls player-fired projectiles breaking armor stands. */
        public static final PriFlag ARMOR_STAND_PROJECTILE_BREAK = new PriFlag("armor_stand_projectile_break",
                        "Projectile Break Armor Stand", "Whether player-fired projectiles can break armor stands.", false, true,
                        Material.BOW, "minecraft:items/item/bow");
        /** Controls directly breaking hanging entities. */
        public static final PriFlag HANGING_ENTITY_DIRECT_BREAK = new PriFlag("hanging_entity_direct_break",
                        "Directly Break Hanging Entity", "Whether players can directly break hanging entities.", false, true,
                        Material.ITEM_FRAME, "minecraft:items/item/item_frame");
        /** Controls player-fired projectiles breaking hanging entities. */
        public static final PriFlag HANGING_ENTITY_PROJECTILE_BREAK = new PriFlag("hanging_entity_projectile_break",
                        "Projectile Break Hanging Entity", "Whether player-fired projectiles can break hanging entities.", false, true,
                        Material.BOW, "minecraft:items/item/bow");
        /** Former combined player damage flag retained for migration. */
        @Deprecated
        public static final PriFlag ARMOR_STAND_PLAYER_DAMAGE = new PriFlag("armor_stand_player_damage",
                        "Armor Stand Player Damage (Legacy)", "Former combined permission for direct and projectile damage to armor stands.", false, true,
                        Material.ARMOR_STAND, "minecraft:items/item/armor_stand");
        /** Former combined player damage flag retained for migration. */
        @Deprecated
        public static final PriFlag HANGING_ENTITY_PLAYER_DAMAGE = new PriFlag("hanging_entity_player_damage",
                        "Hanging Entity Player Damage (Legacy)", "Former combined permission for direct and projectile damage to hanging entities.", false, true,
                        Material.ITEM_FRAME, "minecraft:items/item/item_frame");
        /** Controls igniting fire. */
        public static final PriFlag IGNITE = new PriFlag("ignite", "Ignite", "Whether can ignite fire.", false, true,
                        Material.FLINT_AND_STEEL, "minecraft:items/item/flint_and_steel");

        // item management
        /** Controls picking up dropped items. */
        public static final PriFlag PICK_UP = new PriFlag("pick_up", "Pick Up Item",
                        "Whether player can pick up items in dominion.", true, true, Material.DIAMOND_PICKAXE, "minecraft:items/item/diamond_pickaxe");
        /** Controls dropping items. */
        public static final PriFlag DROP_ITEM = new PriFlag("drop_item", "Drop Item",
                        "Whether player can drop item in dominion.", true, true, Material.IRON_INGOT, "minecraft:items/item/iron_ingot");

        // doors and access
        /** Controls interaction with ordinary doors. */
        public static final PriFlag DOOR = new PriFlag("door", "Door",
                        "Whether can interact with normal doors.", false, true,
                        Material.OAK_DOOR, "minecraft:items/item/oak_door");
        /** Controls interaction with trapdoors. */
        public static final PriFlag TRAPDOOR = new PriFlag("trapdoor", "Trapdoor",
                        "Whether can interact with trapdoors.", false, true,
                        Material.OAK_TRAPDOOR, "minecraft:items/item/oak_trapdoor");
        /** Controls interaction with fence gates. */
        public static final PriFlag FENCE_GATE = new PriFlag("fence_gate", "Fence Gate",
                        "Whether can interact with fence gates.", false, true,
                        Material.OAK_FENCE_GATE, "minecraft:items/item/oak_fence_gate");
        /** Controls clicking buttons. */
        public static final PriFlag BUTTON = new PriFlag("button", "Button", "Whether can click button.", false, true,
                        Material.STONE_BUTTON, "minecraft:blocks/block/stone");
        /** Controls switching levers. */
        public static final PriFlag LEVER = new PriFlag("lever", "Lever", "Whether can switch lever.", false, true,
                        Material.LEVER, "minecraft:blocks/block/lever");
        /** Controls player-triggered pressure plates. */
        public static final PriFlag PRESSURE = new PriFlag("pressure", "Pressure Plate (Player)",
                        "Whether player can trigger pressure plate.", false, true, Material.STONE_PRESSURE_PLATE, "minecraft:blocks/block/stone");

        // red stone
        /** Controls interaction with redstone dust. */
        public static final PriFlag RED_STONE_POWDER = new PriFlag("red_stone_powder", "Red Stone Powder",
                        "Whether can interact with red stone powder.", false, true, Material.REDSTONE, "minecraft:items/item/redstone");
        /** Controls interaction with repeaters. */
        public static final PriFlag REPEATER = new PriFlag("repeater", "Repeater",
                        "Whether can change (interact with) repeater.", false, true, Material.REPEATER, "minecraft:items/item/repeater");
        /** Controls interaction with comparators. */
        public static final PriFlag COMPARER = new PriFlag("comparer", "Comparer",
                        "Whether can interact with comparer.", false, true, Material.COMPARATOR, "minecraft:items/item/comparator");
        /** Controls interaction with note blocks. */
        public static final PriFlag NOTE_BLOCK = new PriFlag("note_block", "Note Block",
                        "Whether can interact with note block.", false, true, Material.NOTE_BLOCK, "minecraft:blocks/block/note_block");

        // containers and storage
        /**
         * The former coarse container flag. It is retained as a migration source
         * for existing configuration and database columns, but is not registered
         * as an active flag anymore.
         */
        @Deprecated
        public static final PriFlag CONTAINER = new PriFlag("container", "Storage Container",
                        "Whether chest-like storage containers can be opened.", false, true, Material.CHEST, "minecraft:chests/entity/chest/normal");
        /** Controls opening chests. */
        public static final PriFlag CHEST = new PriFlag("chest", "Chest",
                        "Whether chests can be opened.", false, true, Material.CHEST, "minecraft:chests/entity/chest/normal");
        /** Controls opening barrels. */
        public static final PriFlag BARREL = new PriFlag("barrel", "Barrel",
                        "Whether barrels can be opened.", false, true, Material.BARREL, "minecraft:blocks/block/barrel_side");
        /** Controls opening shulker boxes. */
        public static final PriFlag SHULKER_BOX = new PriFlag("shulker_box", "Shulker Box",
                        "Whether shulker boxes can be opened.", false, true, Material.SHULKER_BOX, "minecraft:blocks/block/shulker_box");
        /** Controls changing equipment on armor stands. */
        public static final PriFlag ARMOR_STAND_INTERACTIVE = new PriFlag("armor_stand_interactive",
                        "Armor Stand Interaction", "Whether equipment on armor stands can be changed.", false, true,
                        Material.ARMOR_STAND, "minecraft:items/item/armor_stand");
        /** Controls inserting and removing items in item frames. */
        public static final PriFlag ITEM_FRAME_CONTENT = new PriFlag("item_frame_content", "Item Frame Content",
                        "Whether items can be inserted into or removed from item frames.", false, true,
                        Material.ITEM_FRAME, "minecraft:items/item/item_frame");
        /** Controls opening hoppers. */
        public static final PriFlag HOPPER = new PriFlag("hopper", "Hopper",
                        "Whether hoppers can be opened.", false, true,
                        Material.HOPPER, "minecraft:items/item/hopper");
        /** Controls opening droppers. */
        public static final PriFlag DROPPER = new PriFlag("dropper", "Dropper",
                        "Whether droppers can be opened.", false, true, Material.DROPPER, "minecraft:blocks/block/dropper_front");
        /** Controls opening dispensers. */
        public static final PriFlag DISPENSER = new PriFlag("dispenser", "Dispenser",
                        "Whether dispensers can be opened.", false, true, Material.DISPENSER, "minecraft:blocks/block/dispenser_front");
        /** Controls opening furnaces. */
        public static final PriFlag FURNACE = new PriFlag("furnace", "Furnace",
                        "Whether furnaces can be opened.", false, true, Material.FURNACE, "minecraft:blocks/block/furnace_front");
        /** Controls opening blast furnaces. */
        public static final PriFlag BLAST_FURNACE = new PriFlag("blast_furnace", "Blast Furnace",
                        "Whether blast furnaces can be opened.", false, true, Material.BLAST_FURNACE, "minecraft:blocks/block/blast_furnace_front");
        /** Controls opening smokers. */
        public static final PriFlag SMOKER = new PriFlag("smoker", "Smoker",
                        "Whether smokers can be opened.", false, true, Material.SMOKER, "minecraft:blocks/block/smoker_front");
        /** Controls opening flower pots. */
        public static final PriFlag FLOWER_POT = new PriFlag("flower_pot", "Flower Pot",
                        "Whether flower pots can be opened.", false, true, Material.FLOWER_POT, "minecraft:blocks/block/flower_pot");
        /** Controls opening copper chests. */
        public static final PriFlag COPPER_CHEST = new PriFlag("copper_chest", "Copper Chest",
                        "Whether copper chests can be opened.", false, true, Material.CHEST, "minecraft:chests/entity/chest/normal");
        /** Controls opening shelves. */
        public static final PriFlag SHELF = new PriFlag("shelf", "Shelf",
                        "Whether shelves can be opened.", false, true, Material.BOOKSHELF, "minecraft:blocks/block/chiseled_bookshelf_side");

        // crafting and utilities
        /** Controls using crafting tables. */
        public static final PriFlag CRAFT = new PriFlag("craft", "Crafting Table", "Whether can use crafting table.",
                        false, true, Material.CRAFTING_TABLE, "minecraft:blocks/block/crafting_table_side");
        /** Controls interacting with crafters. */
        public static final PriFlag CRAFTER = new PriFlag("crafter", "Crafter",
                        "Whether can interact with crafter (1.21).", false, true, Material.CRAFTING_TABLE, "minecraft:blocks/block/crafting_table_side");
        /** Controls using anvils. */
        public static final PriFlag ANVIL = new PriFlag("anvil", "Anvil", "Whether can use anvil.", false, true,
                        Material.ANVIL, "minecraft:blocks/block/anvil");
        /** Controls using enchanting tables. */
        public static final PriFlag ENCHANT = new PriFlag("enchant", "Enchant Table", "Whether can use enchant table.",
                        false, true, Material.ENCHANTING_TABLE, "minecraft:blocks/block/enchanting_table_side");
        /** Controls using brewing stands. */
        public static final PriFlag BREW = new PriFlag("brew", "Brewing Stand", "Whether can use brewing stand.", false,
                        true, Material.BREWING_STAND, "minecraft:items/item/brewing_stand");
        /** Controls interacting with beacons. */
        public static final PriFlag BEACON = new PriFlag("beacon", "Beacon", "Whether can interact with beacon.", false,
                        true, Material.BEACON, "minecraft:blocks/block/beacon");
        /** Controls interacting with jukeboxes. */
        public static final PriFlag JUKEBOX = new PriFlag("jukebox", "Jukebox", "Whether can interact with jukebox.",
                        false, true, Material.JUKEBOX, "minecraft:blocks/block/jukebox_side");
        /** Controls interacting with lecterns. */
        public static final PriFlag LECTERN = new PriFlag("lectern", "Lectern", "Whether can interact with lectern.",
                        false, true, Material.LECTERN, "minecraft:blocks/block/lectern_front");
        /** Controls interacting with chiseled bookshelves. */
        public static final PriFlag BOOKSHELF = new PriFlag("bookshelf", "Chiseled Bookshelf",
                        "Whether can interact with chiseled bookshelf.", false, true, Material.CHISELED_BOOKSHELF, "minecraft:blocks/block/chiseled_bookshelf_side");

        // special items and interactions
        /** Controls interacting with dragon eggs. */
        public static final PriFlag DRAGON_EGG = new PriFlag("dragon_egg", "Dragon Egg",
                        "Whether can interact with dragon egg.", false, true, Material.DRAGON_EGG, "minecraft:blocks/block/dragon_egg");
        /** Controls rotating items in item frames. */
        public static final PriFlag ITEM_FRAME_INTERACTIVE = new PriFlag("item_frame_interactive",
                        "Item Frame Interactive", "Whether can interact with item frame (rotate item).", false, true,
                        Material.ITEM_FRAME, "minecraft:items/item/item_frame");
        /** Controls editing signs. */
        public static final PriFlag EDIT_SIGN = new PriFlag("edit_sign", "Edit Sign", "Whether can edit sign.", false,
                        true, Material.OAK_SIGN, "minecraft:items/item/oak_sign");

        // rest and respawn
        /** Controls sleeping in beds and setting a spawn point. */
        public static final PriFlag BED = new PriFlag("bed", "Bed", "Weather can sleep in bed (set spawn point).",
                        false, true, Material.RED_BED, "minecraft:blocks/block/red_bed_foot_east");
        /** Controls setting and using respawn anchors. */
        public static final PriFlag ANCHOR = new PriFlag("anchor", "Respawn Anchor",
                        "Weather can set/use respawn anchor.", false, true, Material.RESPAWN_ANCHOR, "minecraft:blocks/block/respawn_anchor_top");

        // vehicles
        /** Controls spawning vehicles. */
        public static final PriFlag VEHICLE_SPAWN = new PriFlag("vehicle_spawn", "Vehicle Spawn",
                        "Whether can spawn vehicle (boat, minecart).", false, true, Material.MINECART, "minecraft:items/item/minecart");
        /** Controls destroying vehicles. */
        public static final PriFlag VEHICLE_DESTROY = new PriFlag("vehicle_destroy", "Vehicle Destroy",
                        "Whether can destroy vehicle (boat, minecart).", false, true, Material.IRON_AXE, "minecraft:items/item/iron_axe");

        // farming and animals
        /** Controls harvesting crops. */
        public static final PriFlag HARVEST = new PriFlag("harvest", "Harvest", "Whether player can harvest crops.",
                        false, true, Material.WHEAT, "minecraft:items/item/wheat");
        /** Controls planting crops. */
        public static final PriFlag SOWING = new PriFlag("sowing", "Sowing", "Whether crops can be planted.", false,
                        true, Material.WHEAT_SEEDS, "minecraft:items/item/wheat_seeds");
        /** Controls using bone meal and other fertilizer. */
        public static final PriFlag FERTILIZER = new PriFlag("fertilizer", "Fertilizer",
                        "Whether bone meal and other fertilizer can be used.", false, true, Material.BONE_MEAL, "minecraft:items/item/bone_meal");
        /** Controls planting saplings and similar tree plants. */
        public static final PriFlag PLANT_TREE = new PriFlag("plant_tree", "Plant Tree",
                        "Whether saplings and similar tree plants can be planted.", false, true, Material.OAK_SAPLING, "minecraft:blocks/block/oak_sapling");
        /** Controls feeding animals. */
        public static final PriFlag FEED = new PriFlag("feed", "Feed Animal", "Whether can feed animals.", false, true,
                        Material.WHEAT, "minecraft:items/item/wheat");
        /** Controls shearing sheep. */
        public static final PriFlag SHEAR = new PriFlag("shear", "Shear", "Whether can cut wool from sheep.", false,
                        true, Material.SHEARS, "minecraft:items/item/shears");
        /** Controls leashing entities. */
        public static final PriFlag LEASH = new PriFlag("leash", "Leash",
                        "Whether to allow leashing animals/mobs/entities.", false, true, Material.LEAD, "minecraft:items/item/lead");
        /** Controls dyeing animals and their accessories. */
        public static final PriFlag DYE = new PriFlag("dye", "Dye", "What can dye (sheep, dog collar, cat collar).",
                        false, true, Material.LIGHT_BLUE_DYE, "minecraft:items/item/light_blue_dye");
        /** Controls collecting honey from hives. */
        public static final PriFlag HONEY = new PriFlag("honey", "Honey",
                        "Whether can interact with hive (to get honey).", false, true, Material.HONEY_BOTTLE, "minecraft:items/item/honey_bottle");

        // food and consumption
        /** Controls eating cake. */
        public static final PriFlag CAKE = new PriFlag("cake", "Cake", "Whether can eat cake.", false, true,
                        Material.CAKE, "minecraft:items/item/cake");

        // trading and interaction
        /** Controls trading with villagers. */
        public static final PriFlag TRADE = new PriFlag("trade", "Villager Trade", "Whether can trade with villager.",
                        false, true, Material.EMERALD, "minecraft:items/item/emerald");

        // projectiles and throwing
        /** Controls charging bows and crossbows. */
        public static final PriFlag PROJECTILE_CHARGE = new PriFlag("projectile_charge", "Charge Bow or Crossbow",
                        "Whether players can charge bows and crossbows.", false, true, Material.BOW, "minecraft:items/item/bow");
        /** Controls launching arrows. */
        public static final PriFlag ARROW_LAUNCH = new PriFlag("arrow_launch", "Launch Arrow",
                        "Whether players can launch arrows.", false, true, Material.ARROW, "minecraft:items/item/arrow");
        /** Controls impacts caused by player-fired arrows. */
        public static final PriFlag ARROW_HIT = new PriFlag("arrow_hit", "Arrow Impact",
                        "Whether player-fired arrows can impact blocks or entities.", false, true, Material.ARROW, "minecraft:items/item/arrow");
        /** Controls damage caused by player-fired arrows. */
        public static final PriFlag ARROW_DAMAGE = new PriFlag("arrow_damage", "Arrow Damage",
                        "Whether player-fired arrows can damage entities.", false, true, Material.ARROW, "minecraft:items/item/arrow");
        /** Former combined bow/crossbow and arrow flag retained for migration. */
        @Deprecated
        public static final PriFlag SHOOT = new PriFlag("shoot", "Shoot Arrows",
                        "Former combined permission for charging bows/crossbows and launching or using arrows.", false, true, Material.BOW, "minecraft:items/item/bow");
        /** Controls launching tridents. */
        public static final PriFlag TRIDENT_LAUNCH = new PriFlag("trident_launch", "Launch Trident",
                        "Whether players can launch tridents.", false, true, Material.TRIDENT, "minecraft:items/item/trident");
        /** Controls impacts caused by player-fired tridents. */
        public static final PriFlag TRIDENT_HIT = new PriFlag("trident_hit", "Trident Impact",
                        "Whether player-fired tridents can impact blocks or entities.", false, true, Material.TRIDENT, "minecraft:items/item/trident");
        /** Former combined trident launch and impact flag retained for migration. */
        @Deprecated
        public static final PriFlag TRIDENT = new PriFlag("trident", "Throw Trident", "Whether tridents can be thrown.",
                        false, true, Material.TRIDENT, "minecraft:items/item/trident");
        /** Controls launching fireballs. */
        public static final PriFlag FIREBALL_LAUNCH = new PriFlag("fireball_launch", "Launch Fireball",
                        "Whether players can launch fireballs.", false, true, Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Controls impacts caused by player-fired fireballs. */
        public static final PriFlag FIREBALL_HIT = new PriFlag("fireball_hit", "Fireball Impact",
                        "Whether player-fired fireballs can impact blocks or entities.", false, true, Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Former combined fireball launch and impact flag retained for migration. */
        @Deprecated
        public static final PriFlag FIREBALL = new PriFlag("fireball", "Launch Fireball",
                        "Former combined permission for launching and impacting with fireballs.", false, true, Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Controls launching wind charges. */
        public static final PriFlag WIND_CHARGE_LAUNCH = new PriFlag("wind_charge_launch", "Launch Wind Charge",
                        "Whether players can launch wind charges.", false, true, Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Controls impacts caused by player-fired wind charges. */
        public static final PriFlag WIND_CHARGE_HIT = new PriFlag("wind_charge_hit", "Wind Charge Impact",
                        "Whether player-fired wind charges can impact blocks or entities.", false, true, Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Controls explosions caused by player-fired wind charges. */
        public static final PriFlag WIND_CHARGE_EXPLODE = new PriFlag("wind_charge_explode", "Wind Charge Explosion",
                        "Whether player-fired wind charges can explode.", false, true, Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Former combined wind charge launch, impact and explosion flag retained for migration. */
        @Deprecated
        public static final PriFlag WIND_CHARGE = new PriFlag("wind_charge", "Use Wind Charge",
                        "Former combined permission for launching, impacting and exploding wind charges.", false, true, Material.FIRE_CHARGE, "minecraft:items/item/fire_charge");
        /** Controls throwing eggs. */
        public static final PriFlag EGG = new PriFlag("egg", "Throw Egg", "Whether can throw egg.", false, true,
                        Material.EGG, "minecraft:items/item/egg");
        /** Controls using fishing rods. */
        public static final PriFlag HOOK = new PriFlag("hook", "Hook", "Whether can use fishing rod.", false, true,
                        Material.FISHING_ROD, "minecraft:items/item/fishing_rod");

        // combat
        /** Controls player-versus-player damage. */
        public static final PriFlag PVP = new PriFlag("pvp", "PVP", "Damage between players.", false, true,
                        Material.DIAMOND_SWORD, "minecraft:items/item/diamond_sword");
        /** Controls damaging monsters. */
        public static final PriFlag MONSTER_KILLING = new PriFlag("monster_killing", "Monster Killing",
                        "Whether can do harm to monsters.", false, true, Material.IRON_SWORD, "minecraft:items/item/iron_sword");
        /** Controls damaging animals. */
        public static final PriFlag ANIMAL_KILLING = new PriFlag("animal_killing", "Animal Killing",
                        "Whether can do harm to animals.", false, true, Material.COOKED_BEEF, "minecraft:items/item/cooked_beef");
        /** Controls damaging villagers. */
        public static final PriFlag VILLAGER_KILLING = new PriFlag("villager_killing", "Villager Killing",
                        "Whether can do harm to villager.", false, true, Material.WOODEN_SWORD, "minecraft:items/item/wooden_sword");

        private static final List<Flag> legacy_flags = List.of(
                        BURN, BURN_ENTITY, ENDER_MAN, BLOCK_EXPLODE, FLOW_IN_PROTECTION, ICE_FORM,
                        ARMOR_STAND_EXPLOSION_DAMAGE, HANGING_ENTITY_EXPLOSION_DAMAGE,
                        ARMOR_STAND_PLAYER_DAMAGE, HANGING_ENTITY_PLAYER_DAMAGE,
                        SHOOT, TRIDENT, FIREBALL, WIND_CHARGE,
                        CONTAINER, PLACE_ENTITY, BREAK_ENTITY, ITEM_FRAME_PROJ_DAMAGE
        );
        private static final List<EnvFlag> env_flags = new ArrayList<>();
        private static final List<PriFlag> pri_flags = new ArrayList<>();
        private static final List<Flag> all_flags = new ArrayList<>();
        private static final AtomicLong revision = new AtomicLong();

        static {
                for (java.lang.reflect.Field field : Flags.class.getDeclaredFields()) {
                        try {
                                Object obj = field.get(null);
                                if (obj instanceof Flag flag && !legacy_flags.contains(flag)) {
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
         * Returns all active flags, including both environment and privilege flags.
         *
         * @return the active flag list; callers should treat it as read-only
         */
        public static List<Flag> getAllFlags() {
                return all_flags;
        }

        /**
         * Returns all active environment flags.
         *
         * @return the active environment flag list; callers should treat it as read-only
         */
        public static List<EnvFlag> getAllEnvFlags() {
                return env_flags;
        }

        /**
         * Returns all active privilege flags.
         *
         * @return the active privilege flag list; callers should treat it as read-only
         */
        public static List<PriFlag> getAllPriFlags() {
                return pri_flags;
        }

        /**
         * Filters a list of flags to the flags currently marked enabled.
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
         * Returns all enabled environment flags.
         *
         * @return a new list containing the enabled environment flags
         */
        public static List<EnvFlag> getAllEnvFlagsEnable() {
                return getEnabledFlags(env_flags);
        }

        /**
         * Returns all enabled privilege flags.
         *
         * @return a new list containing the enabled privilege flags
         */
        public static List<PriFlag> getAllPriFlagsEnable() {
                return getEnabledFlags(pri_flags);
        }

        /**
         * Returns all enabled environment and privilege flags.
         *
         * @return a new list containing the enabled flags
         */
        public static List<Flag> getAllFlagsEnable() {
                return getEnabledFlags(all_flags);
        }

        /**
         * Finds a flag by its stable name in a list.
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
         * Finds an active flag by its stable name.
         *
         * @param name the name of the flag
         * @return the flag with the given name, or null if not found
         */
        public static Flag getFlag(String name) {
                return getFlagByName(all_flags, name);
        }

        /**
         * Finds an active environment flag by its stable name.
         *
         * @param name the name of the environment flag
         * @return the environment flag with the given name, or null if not found
         */
        public static EnvFlag getEnvFlag(String name) {
                return getFlagByName(env_flags, name);
        }

        /**
         * Finds an active privilege flag by its stable name.
         *
         * @param name the name of the privilege flag
         * @return the privilege flag with the given name, or {@code null} if not found
         */
        public static PriFlag getPreFlag(String name) {
                return getFlagByName(pri_flags, name);
        }

        /**
         * Registers a flag.
         *
         * <p>This internal helper adds the flag to the in-memory active-flag lists.
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
         * Registers a custom environment flag.
         * <p>
         * Call {@link #applyChanges()} after registration so the new flag and its
         * configured groups are applied asynchronously.
         *
         * @param plugin the plugin registering the flag
         * @param flag   the environment flag to register
         * @return {@code true} if the flag was accepted by the registration
         *         event, {@code false} if the event was cancelled
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
         * Registers a custom privilege flag.
         * <p>
         * Call {@link #applyChanges()} after registration so the new flag and its
         * configured groups are applied asynchronously.
         *
         * @param plugin the plugin registering the flag
         * @param flag   the privilege flag to register
         * @return {@code true} if the flag was accepted by the registration
         *         event, {@code false} if the event was cancelled
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
         * Queues pending custom flag and flag-group changes for application.
         * Use the returned future to observe completion of the asynchronous pass.
         * Calls made in the same server tick may be coalesced.
         *
         * @return a future completed after the pending changes have been applied
         */
        public static CompletableFuture<Void> applyChanges() {
                return DominionAPI.getInstance().applyFlagChanges();
        }

        /**
         * Queues registered flag and flag-group changes for application without
         * exposing the completion future.
         *
         * @deprecated use {@link #applyChanges()} and observe the returned future
         * @throws Exception retained for source compatibility; current implementations
         *                   report asynchronous failures through the returned future of
         *                   {@link #applyChanges()}
         */
        @Deprecated
        public static void applyNewCustomFlags() throws Exception {
                applyChanges();
        }

        /**
         * Gets the revision of the active custom-flag registry.
         *
         * @return the current flag revision
         */
        public static long getRevision() {
                return revision.get();
        }

        /**
         * Returns the legacy flag whose value should seed a newly split flag.
         *
         * @param flag the active flag being migrated
         * @return the legacy source flag, or {@code null} when no source exists
         */
        @ApiStatus.Internal
        public static Flag getLegacySource(Flag flag) {
                if (flag == ANIMAL_BREED || flag == ANIMAL_SPAWNER || flag == ANIMAL_SPAWN_EGG)
                        return ANIMAL_SPAWN;
                if (flag == VILLAGER_BREED || flag == VILLAGER_SPAWNER || flag == VILLAGER_SPAWN_EGG)
                        return VILLAGER_SPAWN;
                if (flag == MONSTER_SPAWNER || flag == MONSTER_SPAWN_EGG)
                        return MONSTER_SPAWN;
                if (flag == ENDER_MAN_PICKUP_BLOCK || flag == ENDER_MAN_PLACE_BLOCK
                                || flag == ENDER_MAN_SPAWN || flag == ENDER_MAN_TELEPORT)
                        return ENDER_MAN;
                if (flag == WITHER_EXPLODE || flag == WITHER_BREAK_BLOCK)
                        return WITHER_SPAWN;
                if (flag == BED_EXPLODE || flag == ANCHOR_EXPLODE)
                        return BLOCK_EXPLODE;
                if (flag == CREEPER_DAMAGE_ENTITY
                                || flag == WITHER_SKULL_EXPLODE || flag == WITHER_SKULL_DAMAGE_ENTITY
                                || flag == ENDER_CRYSTAL_EXPLODE || flag == ENDER_CRYSTAL_DAMAGE_ENTITY
                                || flag == FIREBALL_EXPLODE || flag == FIREBALL_DAMAGE_ENTITY)
                        return CREEPER_EXPLODE;
                if (flag == TNT_DAMAGE_ENTITY)
                        return TNT_EXPLODE;
                if (flag == TNT_DAMAGE_ARMOR_STAND || flag == CREEPER_DAMAGE_ARMOR_STAND
                                || flag == WITHER_SKULL_DAMAGE_ARMOR_STAND
                                || flag == ENDER_CRYSTAL_DAMAGE_ARMOR_STAND
                                || flag == FIREBALL_DAMAGE_ARMOR_STAND)
                        return ARMOR_STAND_EXPLOSION_DAMAGE;
                if (flag == TNT_DAMAGE_HANGING_ENTITY || flag == CREEPER_DAMAGE_HANGING_ENTITY
                                || flag == WITHER_SKULL_DAMAGE_HANGING_ENTITY
                                || flag == ENDER_CRYSTAL_DAMAGE_HANGING_ENTITY
                                || flag == FIREBALL_DAMAGE_HANGING_ENTITY)
                        return HANGING_ENTITY_EXPLOSION_DAMAGE;
                if (flag == BURN_BLOCK)
                        return BURN;
                if (flag == BURN_ENTITY_FIRE || flag == BURN_ENTITY_LAVA)
                        return BURN_ENTITY;
                if (flag == FLOW_IN_WATER || flag == FLOW_IN_LAVA)
                        return FLOW_IN_PROTECTION;
                if (flag == ICE_FORM_NATURAL || flag == ICE_FORM_FROST_WALKER)
                        return ICE_FORM;
                if (flag == MOB_TRAMPLE)
                        return TRAMPLE;
                if (flag == PLACE_LIQUID || flag == PLACE_FLOWER_POT_CONTENT || flag == PLACE_ENTITY)
                        return PLACE;
                if (flag == PLACE_ARMOR_STAND || flag == PLACE_HANGING_ENTITY)
                        return PLACE_ENTITY;
                if (flag == BREAK_LIQUID || flag == BREAK_FLOWER_POT_CONTENT || flag == BREAK_ENTITY)
                        return BREAK_BLOCK;
                if (flag == ARMOR_STAND_DIRECT_BREAK || flag == ARMOR_STAND_PROJECTILE_BREAK)
                        return ARMOR_STAND_PLAYER_DAMAGE;
                if (flag == HANGING_ENTITY_DIRECT_BREAK || flag == HANGING_ENTITY_PROJECTILE_BREAK)
                        return HANGING_ENTITY_PLAYER_DAMAGE;
                if (flag == TRAPDOOR || flag == FENCE_GATE)
                        return DOOR;
                if (flag == HANGING_ENTITY_MOB_DAMAGE)
                        return ITEM_FRAME_PROJ_DAMAGE;
                if (flag == ARMOR_STAND_INTERACTIVE || flag == ITEM_FRAME_CONTENT)
                        return CONTAINER;
                if (flag == CHEST || flag == BARREL || flag == SHULKER_BOX
                                || flag == COPPER_CHEST || flag == SHELF)
                        return CONTAINER;
                if (flag == DROPPER || flag == DISPENSER || flag == FURNACE
                                || flag == BLAST_FURNACE || flag == SMOKER || flag == FLOWER_POT)
                        return HOPPER;
                if (flag == FERTILIZER || flag == PLANT_TREE)
                        return SOWING;
                if (flag == PROJECTILE_CHARGE || flag == ARROW_LAUNCH || flag == ARROW_HIT || flag == ARROW_DAMAGE
                                || flag == TRIDENT_LAUNCH || flag == TRIDENT_HIT
                                || flag == FIREBALL_LAUNCH || flag == FIREBALL_HIT
                                || flag == WIND_CHARGE_LAUNCH || flag == WIND_CHARGE_HIT || flag == WIND_CHARGE_EXPLODE)
                        return SHOOT;
                return null;
        }

        /**
         * Returns all legacy flags whose values should seed a newly split flag.
         * Most split flags have one source. The historical {@code burn} flag
         * is included as a fallback for installations that never had the
         * intermediate {@code burn_entity} column.
         *
         * @param flag the active flag being migrated
         * @return the legacy source flags, in fallback order
         */
        @ApiStatus.Internal
        public static List<Flag> getLegacySources(Flag flag) {
                if (flag == BURN_ENTITY_FIRE || flag == BURN_ENTITY_LAVA) {
                        return List.of(BURN_ENTITY, BURN);
                }
                Flag source = getLegacySource(flag);
                return source == null ? List.of() : List.of(source);
        }

        /**
         * Checks whether migration should preserve a spawn-egg flag's existing
         * allowed value instead of applying the normal legacy default.
         *
         * @param flag the flag being migrated
         * @return {@code true} for animal and monster spawn-egg flags
         */
        @ApiStatus.Internal
        public static boolean preserveAllowedSpawnEggValue(Flag flag) {
                return flag == ANIMAL_SPAWN_EGG || flag == MONSTER_SPAWN_EGG;
        }
}
