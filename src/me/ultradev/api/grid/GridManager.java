package me.ultradev.api.grid;

import me.ultradev.api.grid.room.wall.Wall;
import me.ultradev.api.grid.room.wall.WallType;
import me.ultradev.api.util.StringUtil;
import me.ultradev.game.Symbol;

import java.util.Arrays;
import java.util.List;

import static me.ultradev.api.grid.RoomManager.WALLS;
import static me.ultradev.api.player.PlayerManager.PLAYER_COORDINATE;

public class GridManager {

    public static String GRID;
    public static final int GRID_HEIGHT = 20;
    public static final int GRID_WIDTH = 170;

    public static void resetGrid() {
        GRID = Symbol.BORDER_TOP_LEFT + StringUtil.repeat(Symbol.BORDER_HORIZONTAL, GRID_WIDTH) + Symbol.BORDER_TOP_RIGHT
                + StringUtil.repeat("\n" + Symbol.BORDER_VERTICAL + StringUtil.repeat(" ", GRID_WIDTH) + Symbol.BORDER_VERTICAL, GRID_HEIGHT)
                + "\n" + Symbol.BORDER_BOTTOM_LEFT + StringUtil.repeat(Symbol.BORDER_HORIZONTAL, GRID_WIDTH) + Symbol.BORDER_BOTTOM_RIGHT;
    }

    /**
     * Updates the following things in the grid:
     * - Player
     * - Walls
     */
    public static void updateGrid() {

        // Player
        setCharacterAt(PLAYER_COORDINATE.clone().add(0, 1), Symbol.PLAYER_TOP);
        setCharacterAt(PLAYER_COORDINATE, Symbol.PLAYER_BOTTOM);

        // Walls
        for (Wall wall : WALLS) {
            if (wall.type().equals(WallType.HORIZONTAL)) {
                for (int i = 0; i < wall.length(); i++)
                    setCharacterAt(wall.coordinate().clone().add(i, 0), Symbol.HORIZONTAL_WALL);
            } else if (wall.type().equals(WallType.VERTICAL)) {
                for (int i = 0; i < wall.length(); i++)
                    setCharacterAt(wall.coordinate().clone().add(0, i), Symbol.VERTICAL_WALL);
            }
        }

    }

    /**
     * Sets the character at the specified location in the grid.
     *
     * @param coordinate the coordinate of the location
     * @param s          the character to change to
     * @return whether the character was successfully set
     */
    public static boolean setCharacterAt(Coordinate coordinate, String s) {

        int index = coordinate.getGridIndex();
        if (index == -1) return false;

        // Set character at index
        List<String> chars = Arrays.asList(GRID.split(""));
        chars.set(index, s);
        GRID = StringUtil.join(chars, "");

        return true;

    }

    /**
     * Prints the current grid.
     */
    public static void printGrid() {
        for (int i = 0; i < 10; i++) System.out.println();
        StringUtil.print(GRID);
    }

}
