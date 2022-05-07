package me.ultradev.api.grid;

import me.ultradev.api.player.PlayerManager;
import me.ultradev.api.util.StringUtil;
import me.ultradev.game.Symbol;

import java.util.Arrays;
import java.util.List;

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
     */
    public static void updateGrid() {
        setCharacterAt(PlayerManager.x, PlayerManager.y, Symbol.PLAYER);
    }

    /**
     * Sets the character at the specified location in the grid.
     * @param x the x coordinate of the location
     * @param y the y coordinate of the location
     * @param s the character to change to
     * @return whether the character was successfully set
     */
    public static boolean setCharacterAt(int x, int y, String s) {

        if(x < 0 || x > GRID_WIDTH - 1 || y < 0 || y > GRID_HEIGHT - 1) return false;

        // Get the index of x:0 y:0
        int index = GRID.length() - (GRID_WIDTH * 2 + 4);

        // Add the x
        index += x;

        // Add the y
        index -= y * (GRID_WIDTH + 3);

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
        for(int i = 0; i < 10; i++) System.out.println("");
        StringUtil.print(GRID);
    }

}
