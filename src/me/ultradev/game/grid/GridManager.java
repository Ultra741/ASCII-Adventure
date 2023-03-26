package me.ultradev.game.grid;

import me.ultradev.game.Symbol;
import me.ultradev.game.data.Data;

import java.util.Map;

public class GridManager {

    public static void updateGrid() {
        Data.GRID = Symbol.BORDER_TOP_LEFT + Symbol.BORDER_HORIZONTAL.repeat(Data.GRID_WIDTH) + Symbol.BORDER_TOP_RIGHT
                + ("\n" + Symbol.BORDER_VERTICAL + " ".repeat(Data.GRID_WIDTH) + Symbol.BORDER_VERTICAL).repeat(Data.GRID_HEIGHT)
                + "\n" + Symbol.BORDER_BOTTOM_LEFT + Symbol.BORDER_HORIZONTAL.repeat(Data.GRID_WIDTH) + Symbol.BORDER_BOTTOM_RIGHT;

        setCharacterAt(Data.PLAYER_COORDINATE.clone().add(0, 1), Symbol.PLAYER_TOP);
        setCharacterAt(Data.PLAYER_COORDINATE, Symbol.PLAYER_BOTTOM);
        for (Map.Entry<Coordinate, String> entry : Data.CHARACTERS.entrySet()) {
            setCharacterAt(entry.getKey(), entry.getValue());
        }
    }

    public static void displayGrid() {
        Data.TEXT_PANE.setText(Data.GRID + "\n" +
                (Data.OBJECTIVE != null ? "[OBJECTIVE] " + Data.OBJECTIVE + "\n" : "") +
                "Use WASD or arrow keys to move around.");
    }

    public static boolean setCharacterAt(Coordinate coordinate, String s) {
        if (!coordinate.isValid()) return false;
        String[] chars = Data.GRID.split("");
        chars[coordinate.getGridIndex()] = s;
        Data.GRID = String.join("", chars);
        return true;
    }

}
