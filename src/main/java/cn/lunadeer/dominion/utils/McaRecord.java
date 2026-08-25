package cn.lunadeer.dominion.utils;

/**
 * Identifies an MCA region file by its region coordinates and world name.
 *
 * @param x     the region x-coordinate, not a block coordinate
 * @param z     the region z-coordinate, not a block coordinate
 * @param world the name of the world containing the region
 */
public record McaRecord(int x, int z, String world) {
}
