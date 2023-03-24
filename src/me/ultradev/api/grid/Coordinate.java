package me.ultradev.api.grid;

import me.ultradev.api.util.NumberUtil;

import static me.ultradev.api.grid.GridManager.*;

/**
 * An object that represents a certain coordinate in the grid.
 */
public class Coordinate implements Cloneable {

    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Checks if this coordinate is valid.
     * The coordinate is invalid when it is outside the grid;
     * @return whether this coordinate is valid
     */
    public boolean isValid() {
        return !(x < 0 || x > GRID_WIDTH - 1 || y < 0 || y > GRID_HEIGHT - 1);
    }

    /**
     * Gets the string index of the character at this coordinate.
     * @return the string index, or -1 if this coordinate is invalid
     */
    public int getGridIndex() {

        if(!isValid()) return -1;

        // Get the index of x:0 y:0
        int index = GRID.length() - (GRID_WIDTH * 2 + 4);

        // Add the x
        index += x;

        // Add the y
        index -= y * (GRID_WIDTH + 3);

        return index;

    }

    /**
     * Adds the specified x and y values to this coordinate.
     * @param x the x value to add
     * @param y the y value to add
     */
    public Coordinate add(int x, int y) {
        this.x += x;
        this.y += y;
        return this;
    }

    /**
     * Returns a new instance of this coordinate.
     * @return the new instance
     */
    @Override
    public Coordinate clone() {
        try {
            return (Coordinate) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new Coordinate(x, y);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Returns a random coordinate.
     * @return the coordinate instance
     */
    public static Coordinate getRandom() {
        return new Coordinate(
            NumberUtil.getRandomBetween(0, GRID_WIDTH - 1),
            NumberUtil.getRandomBetween(0, GRID_HEIGHT -1)
        );
    }

}
