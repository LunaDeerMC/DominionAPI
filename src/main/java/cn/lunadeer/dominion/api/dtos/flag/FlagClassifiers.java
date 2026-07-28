package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** Pure classifiers shared by version-specific event listeners. */
public final class FlagClassifiers {
    private FlagClassifiers() {
    }

    public static @NotNull EnvFlag animalSpawn(@NotNull CreatureSpawnEvent.SpawnReason reason) {
        return switch (reason) {
            case BREEDING -> Flags.ANIMAL_BREED;
            case SPAWNER -> Flags.ANIMAL_SPAWNER;
            case SPAWNER_EGG -> Flags.ANIMAL_SPAWN_EGG;
            default -> Flags.ANIMAL_SPAWN;
        };
    }

    public static @NotNull EnvFlag villagerSpawn(@NotNull CreatureSpawnEvent.SpawnReason reason) {
        return switch (reason) {
            case BREEDING -> Flags.VILLAGER_BREED;
            case SPAWNER -> Flags.VILLAGER_SPAWNER;
            case SPAWNER_EGG -> Flags.VILLAGER_SPAWN_EGG;
            default -> Flags.VILLAGER_SPAWN;
        };
    }

    public static @NotNull EnvFlag monsterSpawn(@NotNull CreatureSpawnEvent.SpawnReason reason) {
        return switch (reason) {
            case SPAWNER -> Flags.MONSTER_SPAWNER;
            case SPAWNER_EGG -> Flags.MONSTER_SPAWN_EGG;
            default -> Flags.MONSTER_SPAWN;
        };
    }

    public static @Nullable EnvFlag explosionBlock(@NotNull EntityType type) {
        return explosion(type, false);
    }

    public static @Nullable EnvFlag explosionEntity(@NotNull EntityType type) {
        return explosion(type, true);
    }

    private static EnvFlag explosion(EntityType type, boolean entityDamage) {
        return switch (type.name()) {
            case "CREEPER", "SULFUR_CUBE" ->
                    entityDamage ? Flags.CREEPER_DAMAGE_ENTITY : Flags.CREEPER_EXPLODE;
            case "WITHER_SKULL" -> entityDamage ? Flags.WITHER_SKULL_DAMAGE_ENTITY : Flags.WITHER_SKULL_EXPLODE;
            case "ENDER_CRYSTAL", "END_CRYSTAL" ->
                    entityDamage ? Flags.ENDER_CRYSTAL_DAMAGE_ENTITY : Flags.ENDER_CRYSTAL_EXPLODE;
            case "FIREBALL", "SMALL_FIREBALL", "DRAGON_FIREBALL" ->
                    entityDamage ? Flags.FIREBALL_DAMAGE_ENTITY : Flags.FIREBALL_EXPLODE;
            default -> null;
        };
    }
}
