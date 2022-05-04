package me.ultradev.api.grid;

import me.ultradev.api.util.StringUtil;
import me.ultradev.game.Symbol;

import java.util.Arrays;
import java.util.List;

public class GridManager {

    public static String GRID;

    public static void setupGrid() {
        System.out.println((Symbol.BORDER_TOP_LEFT + StringUtil.repeat(Symbol.BORDER_HORIZONTAL, 170) + Symbol.BORDER_TOP_RIGHT).length());
        GRID = Symbol.BORDER_TOP_LEFT + StringUtil.repeat(Symbol.BORDER_HORIZONTAL, 170) + Symbol.BORDER_TOP_RIGHT
            + StringUtil.repeat("\n" + Symbol.BORDER_VERTICAL + StringUtil.repeat(" ", 170) + Symbol.BORDER_VERTICAL, 20)
            + "\n" + Symbol.BORDER_BOTTOM_LEFT + StringUtil.repeat(Symbol.BORDER_HORIZONTAL, 170) + Symbol.BORDER_BOTTOM_RIGHT;
    }

    public static void setCharacterAt(int x, int y, String s) {

        // Get the index of x:0 y:0
        int index = GRID.length() - 344;

        // Add the x
        index += x;

        // Add the y
        index -= y * 172;

        // Set character at index
        List<String> chars = Arrays.asList(GRID.replaceAll("\n", "").split(""));
        chars.set(index, s);
        GRID = StringUtil.join(chars, "");

    }

    public static void printGrid() {
        for(int i = 0; i < 10; i++) System.out.println("");
        StringUtil.print(GRID);
    }

}
