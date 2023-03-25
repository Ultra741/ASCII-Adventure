package me.ultradev.game.grid;

import me.ultradev.game.Symbol;
import me.ultradev.game.player.ConsoleManager;

import static me.ultradev.game.player.PlayerManager.PLAYER_COORDINATE;

public class GridManager {

    public static String GRID;
    public static final int GRID_HEIGHT = 15;
    public static final int GRID_WIDTH = 80;

    public static void resetGrid() {
        GRID = Symbol.BORDER_TOP_LEFT + Symbol.BORDER_HORIZONTAL.repeat(GRID_WIDTH) + Symbol.BORDER_TOP_RIGHT
                + ("\n" + Symbol.BORDER_VERTICAL + " ".repeat(GRID_WIDTH) + Symbol.BORDER_VERTICAL).repeat(GRID_HEIGHT)
                + "\n" + Symbol.BORDER_BOTTOM_LEFT + Symbol.BORDER_HORIZONTAL.repeat(GRID_WIDTH) + Symbol.BORDER_BOTTOM_RIGHT;
    }

    public static void updateGrid() {
        setCharacterAt(PLAYER_COORDINATE.clone().add(0, 1), Symbol.PLAYER_TOP);
        setCharacterAt(PLAYER_COORDINATE, Symbol.PLAYER_BOTTOM);
    }

    public static boolean setCharacterAt(Coordinate coordinate, String s) {
        if (!coordinate.isValid()) return false;

        // Set character at index
        String[] chars = GRID.split("");
        chars[coordinate.getGridIndex()] = s;
        GRID = String.join("", chars);
        return true;
    }

    public static void printGrid() {
        ConsoleManager.clear();
        System.out.println(GRID);
    }

}
