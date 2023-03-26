package me.ultradev.game.grid;

import me.ultradev.api.util.NumberUtil;
import me.ultradev.game.data.Data;

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

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(Coordinate coordinate) {
        this.x = coordinate.getX();
        this.y = coordinate.getY();
    }

    public boolean isValid() {
        return x >= 0 && x <= Data.GRID_WIDTH - 1 && y >= 0 && y <= Data.GRID_HEIGHT - 1;
    }

    public int getGridIndex() {
        if (!isValid()) return -1;

        int index = Data.GRID.length() - (Data.GRID_WIDTH * 2 + 4);
        index += x;
        index -= y * (Data.GRID_WIDTH + 3);
        return index;
    }

    public Coordinate add(int x, int y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public boolean equals(int x, int y) {
        return this.x == x && this.y == y;
    }

    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double distance(Coordinate coordinate) {
        return distance(coordinate.getX(), coordinate.getY());
    }

    @Override
    public Coordinate clone() {
        return new Coordinate(x, y);
    }

    public static Coordinate getRandom() {
        return new Coordinate(
                NumberUtil.getRandomBetween(0, Data.GRID_WIDTH - 1),
                NumberUtil.getRandomBetween(0, Data.GRID_HEIGHT - 1)
        );
    }

}
