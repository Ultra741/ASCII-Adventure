package me.ultradev.api.grid.room.wall;

import me.ultradev.api.grid.Coordinate;
import me.ultradev.api.util.NumberUtil;

import static me.ultradev.api.grid.GridManager.GRID_HEIGHT;
import static me.ultradev.api.grid.GridManager.GRID_WIDTH;

public record Wall(WallType type, Coordinate coordinate, int length) {

    /**
     * Returns a random wall.
     * @param type the type of the wall to generate
     * @return the wall instance
     */
    public static Wall getRandom(WallType type) {

        Coordinate coordinate;
        if(type.equals(WallType.HORIZONTAL)) {
            coordinate = new Coordinate(
                    NumberUtil.getRandomBetween(0, GRID_HEIGHT - 1),
                    0);
        } else if(type.equals(WallType.VERTICAL)) {
            coordinate = new Coordinate(
                    NumberUtil.getRandomBetween(0, GRID_WIDTH - 1),
                    0);
        } else {
            coordinate = new Coordinate(0, 0);
        }

        return new Wall(type, coordinate, NumberUtil.getRandomBetween(1,
                (type.equals(WallType.HORIZONTAL) ? 85
                : (type.equals(WallType.VERTICAL) ? 10
                : 30))));

    }

}