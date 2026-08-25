package cn.lunadeer.dominion.api.dtos;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.Vector;

/**
 * Represents an axis-aligned cuboid in block coordinates.
 * <p>
 * The lower and upper coordinates are normalized independently on each axis.
 * Containment of a block coordinate uses a half-open range: the lower bound is
 * inclusive and the upper bound is exclusive.
 */
public class CuboidDTO {

    /**
     * A cuboid whose coordinate extents are all zero.
     */
    public static CuboidDTO ZERO = new CuboidDTO(0, 0, 0, 0, 0, 0);

    private int[] pos1 = new int[3];
    private int[] pos2 = new int[3];

    /**
     * Constructs a cuboid from two three-element coordinate arrays.
     *
     * @param pos1 the first position as {@code [x, y, z]}
     * @param pos2 the second position as {@code [x, y, z]}
     */
    public CuboidDTO(int[] pos1, int[] pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        sortPos();
    }

    /**
     * Constructs a copy of the specified cuboid.
     *
     * @param cuboid the cuboid whose coordinates are copied
     */
    public CuboidDTO(CuboidDTO cuboid) {
        this.pos1 = cuboid.getPos1().clone();
        this.pos2 = cuboid.getPos2().clone();
    }

    /**
     * Constructs a CuboidDTO with the specified coordinates.
     *
     * @param x1 the x-coordinate of the first position
     * @param y1 the y-coordinate of the first position
     * @param z1 the z-coordinate of the first position
     * @param x2 the x-coordinate of the second position
     * @param y2 the y-coordinate of the second position
     * @param z2 the z-coordinate of the second position
     */
    public CuboidDTO(int x1, int y1, int z1, int x2, int y2, int z2) {
        this.pos1[0] = x1;
        this.pos1[1] = y1;
        this.pos1[2] = z1;
        this.pos2[0] = x2;
        this.pos2[1] = y2;
        this.pos2[2] = z2;
        sortPos();
    }

    /**
     * Constructs a cuboid from two three-element coordinate vectors.
     *
     * @param pos1 the first position as {@code [x, y, z]}
     * @param pos2 the second position as {@code [x, y, z]}
     */
    public CuboidDTO(Vector<Integer> pos1, Vector<Integer> pos2) {
        this.pos1[0] = pos1.get(0);
        this.pos1[1] = pos1.get(1);
        this.pos1[2] = pos1.get(2);
        this.pos2[0] = pos2.get(0);
        this.pos2[1] = pos2.get(1);
        this.pos2[2] = pos2.get(2);
        sortPos();
    }

    /**
     * Constructs a cuboid from the block coordinates of two Bukkit locations.
     * The world associated with either location is not stored by this class.
     *
     * @param loc1 the first location of the cuboid
     * @param loc2 the second location of the cuboid
     */
    public CuboidDTO(Location loc1, Location loc2) {
        this.pos1[0] = loc1.getBlockX();
        this.pos1[1] = loc1.getBlockY();
        this.pos1[2] = loc1.getBlockZ();
        this.pos2[0] = loc2.getBlockX();
        this.pos2[1] = loc2.getBlockY();
        this.pos2[2] = loc2.getBlockZ();
        sortPos();
    }

    /**
     * Normalizes the two corners so that {@code pos1[i] <= pos2[i]} for every axis.
     */
    private void sortPos() {
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            if (pos1[i] > pos2[i]) {
                temp[i] = pos1[i];
                pos1[i] = pos2[i];
                pos2[i] = temp[i];
            }
        }
    }

    /**
     * Gets a copy of the lower corner of the cuboid.
     *
     * @return a three-element array in {@code [x, y, z]} order
     */
    public int[] getPos1() {
        return pos1.clone();
    }

    /**
     * Sets the first corner of the cuboid.
     * <p>
     * The supplied array is copied. This method does not automatically
     * normalize the second corner after the assignment.
     *
     * @param pos1 the new corner as {@code [x, y, z]}
     */
    public void setPos1(int[] pos1) {
        this.pos1 = pos1.clone();
    }

    /**
     * Gets a copy of the upper corner of the cuboid.
     *
     * @return a three-element array in {@code [x, y, z]} order
     */
    public int[] getPos2() {
        return pos2.clone();
    }

    /**
     * Sets the second corner of the cuboid.
     * <p>
     * The supplied array is copied. This method does not automatically
     * normalize the first corner after the assignment.
     *
     * @param pos2 the new corner as {@code [x, y, z]}
     */
    public void setPos2(int[] pos2) {
        this.pos2 = pos2.clone();
    }

    /**
     * Converts the lower corner to a Bukkit location in the specified world.
     *
     * @param world the world in which the cuboid is located
     * @return the first location of the cuboid
     */
    public Location getLoc1(World world) {
        return new Location(world, pos1[0], pos1[1], pos1[2]);
    }

    /**
     * Converts the upper corner to a Bukkit location in the specified world.
     *
     * @param world the world in which the cuboid is located
     * @return the second location of the cuboid
     */
    public Location getLoc2(World world) {
        return new Location(world, pos2[0], pos2[1], pos2[2]);
    }

    /**
     * Gets the x-coordinate of the first position.
     *
     * @return the x-coordinate of the first position
     */
    public int x1() {
        return pos1[0];
    }

    /**
     * Gets the y-coordinate of the first position.
     *
     * @return the y-coordinate of the first position
     */
    public int y1() {
        return pos1[1];
    }

    /**
     * Gets the z-coordinate of the first position.
     *
     * @return the z-coordinate of the first position
     */
    public int z1() {
        return pos1[2];
    }

    /**
     * Gets the x-coordinate of the second position.
     *
     * @return the x-coordinate of the second position
     */
    public int x2() {
        return pos2[0];
    }

    /**
     * Gets the y-coordinate of the second position.
     *
     * @return the y-coordinate of the second position
     */
    public int y2() {
        return pos2[1];
    }

    /**
     * Gets the z-coordinate of the second position.
     *
     * @return the z-coordinate of the second position
     */
    public int z2() {
        return pos2[2];
    }

    /**
     * Gets the coordinate extent of the cuboid along the x-axis.
     *
     * @return {@code x2 - x1}
     */
    public long xLength() {
        return pos2[0] - pos1[0];
    }

    /**
     * Gets the coordinate extent of the cuboid along the y-axis.
     *
     * @return {@code y2 - y1}
     */
    public long yLength() {
        return pos2[1] - pos1[1];
    }

    /**
     * Gets the coordinate extent of the cuboid along the z-axis.
     *
     * @return {@code z2 - z1}
     */
    public long zLength() {
        return pos2[2] - pos1[2];
    }

    /**
     * Gets the area of the cuboid's horizontal base (x and z extents).
     *
     * @return {@link #xLength()} multiplied by {@link #zLength()}
     */
    public long getSquare() {
        return xLength() * zLength();
    }

    /**
     * Gets the cuboid volume from its three coordinate extents.
     *
     * @return {@link #xLength()} multiplied by {@link #yLength()} and {@link #zLength()}
     */
    public long getVolume() {
        return xLength() * yLength() * zLength();
    }

    /**
     * Checks whether this cuboid has a non-zero-volume intersection with another cuboid.
     * Cuboids that only touch at a face, edge, or corner do not intersect.
     *
     * @param cuboid the other cuboid to check for intersection
     * @return true if the cuboids intersect, false otherwise
     */
    public boolean intersectWith(CuboidDTO cuboid) {
        return x1() < cuboid.x2() && x2() > cuboid.x1() &&
                y1() < cuboid.y2() && y2() > cuboid.y1() &&
                z1() < cuboid.z2() && z2() > cuboid.z1();
    }

    /**
     * Checks whether this cuboid contains another cuboid, including coincident boundaries.
     *
     * @param cuboid the other cuboid to check for containment
     * @return true if this cuboid contains the other cuboid, false otherwise
     */
    public boolean contain(CuboidDTO cuboid) {
        return contain(cuboid, false);
    }

    /**
     * Checks whether this cuboid contains another cuboid, optionally ignoring the y-axis.
     *
     * @param cuboid  the other cuboid to check for containment
     * @param ignoreY if true, ignores the y-dimension in the containment check
     * @return true if this cuboid contains the other cuboid, false otherwise
     */
    public boolean contain(CuboidDTO cuboid, boolean ignoreY) {
        if (ignoreY) {
            return x1() <= cuboid.x1() && x2() >= cuboid.x2() && z1() <= cuboid.z1() && z2() >= cuboid.z2();
        } else {
            return x1() <= cuboid.x1() && x2() >= cuboid.x2() && y1() <= cuboid.y1() && y2() >= cuboid.y2() && z1() <= cuboid.z1() && z2() >= cuboid.z2();
        }
    }

    /**
     * Checks whether the specified block coordinate is inside this cuboid.
     * The lower bounds are inclusive and the upper bounds are exclusive.
     *
     * @param x the x-coordinate to check
     * @param y the y-coordinate to check
     * @param z the z-coordinate to check
     * @return true if this cuboid contains the specified coordinates, false otherwise
     */
    public boolean contain(int x, int y, int z) {
        return x1() <= x && x2() > x && y1() <= y && y2() > y && z1() <= z && z2() > z;
    }

    /**
     * Checks whether this cuboid is contained by another cuboid.
     *
     * @param cuboid the other cuboid to check for containment
     * @return true if this cuboid is contained by the other cuboid, false otherwise
     */
    public boolean containedBy(CuboidDTO cuboid) {
        return cuboid.contain(this);
    }

    /**
     * Calculates this cuboid's horizontal area minus another cuboid's area.
     *
     * @param cuboid the other cuboid to compare with
     * @return {@code this.getSquare() - cuboid.getSquare()}
     */
    public long minusSquareWith(CuboidDTO cuboid) {
        return getSquare() - cuboid.getSquare();
    }

    /**
     * Calculates this cuboid's volume minus another cuboid's volume.
     *
     * @param cuboid the other cuboid to compare with
     * @return {@code this.getVolume() - cuboid.getVolume()}
     */
    public long minusVolumeWith(CuboidDTO cuboid) {
        return getVolume() - cuboid.getVolume();
    }

    /**
     * Moves the upper y-boundary by the specified amount.
     * A negative amount contracts the cuboid; the implementation preserves a
     * minimum one-coordinate-unit extent when a boundary would cross.
     *
     * @param size the number of coordinate units to add to the upper y-boundary
     */
    public void addUp(int size) {
        if (pos2[1] + size < pos1[1]) {
            pos2[1] = pos1[1] + 1;
        } else {
            pos2[1] += size;
        }
    }

    /**
     * Moves the lower y-boundary by the specified amount.
     *
     * @param size the number of coordinate units to subtract from the lower y-boundary
     */
    public void addDown(int size) {
        if (pos1[1] - size > pos2[1]) {
            pos1[1] = pos2[1] - 1;
        } else {
            pos1[1] -= size;
        }
    }

    /**
     * Moves the lower z-boundary by the specified amount (north).
     *
     * @param size the number of coordinate units to subtract from the lower z-boundary
     */
    public void addNorth(int size) {
        if (pos1[2] - size > pos2[2]) {
            pos1[2] = pos2[2] - 1;
        } else {
            pos1[2] -= size;
        }
    }

    /**
     * Moves the upper z-boundary by the specified amount (south).
     *
     * @param size the number of coordinate units to add to the upper z-boundary
     */
    public void addSouth(int size) {
        if (pos2[2] + size < pos1[2]) {
            pos2[2] = pos1[2] + 1;
        } else {
            pos2[2] += size;
        }
    }

    /**
     * Moves the upper x-boundary by the specified amount (east).
     *
     * @param size the number of coordinate units to add to the upper x-boundary
     */
    public void addEast(int size) {
        if (pos2[0] + size < pos1[0]) {
            pos2[0] = pos1[0] + 1;
        } else {
            pos2[0] += size;
        }
    }

    /**
     * Moves the lower x-boundary by the specified amount (west).
     *
     * @param size the number of coordinate units to subtract from the lower x-boundary
     */
    public void addWest(int size) {
        if (pos1[0] - size > pos2[0]) {
            pos1[0] = pos2[0] - 1;
        } else {
            pos1[0] -= size;
        }
    }
}
