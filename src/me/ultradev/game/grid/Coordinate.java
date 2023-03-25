package me.ultradev.game.grid;

import me.ultradev.api.util.NumberUtil;

import static me.ultradev.game.grid.GridManager.*;

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

    public boolean isValid() {
        return x >= 0 && x <= GRID_WIDTH - 1 && y >= 0 && y <= GRID_HEIGHT - 1;
    }

    public int getGridIndex() {
        if (!isValid()) return -1;

        // Get the index of x:0 y:0
        int index = GRID.length() - (GRID_WIDTH * 2 + 4);
        // Add the x
        index += x;
        // Add the y
        index -= y * (GRID_WIDTH + 3);

        return index;
    }

    public Coordinate add(int x, int y) {
        this.x += x;
        this.y += y;
        return this;
    }

    @Override
    public Coordinate clone() {
        return new Coordinate(x, y);
    }

    public static Coordinate getRandom() {
        return new Coordinate(
                NumberUtil.getRandomBetween(0, GRID_WIDTH - 1),
                NumberUtil.getRandomBetween(0, GRID_HEIGHT - 1)
        );
    }

}
