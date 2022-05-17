package me.ultradev.api.grid;

import me.ultradev.game.Symbol;

public class RoomGenerator {

    public static void generateWall(WallType type, int coordinate, int length) {
        if(type.equals(WallType.HORIZONTAL)) {
            for(int i = 0; i < length; i++) GridManager.setCharacterAt(i, coordinate, Symbol.HORIZONTAL_WALL);
        } else if(type.equals(WallType.VERTICAL)) {
            for(int i = 0; i < length; i++) GridManager.setCharacterAt(coordinate, i, Symbol.VERTICAL_WALL);
        } else if(type.equals(WallType.DIAGONAL)) {
            // TODO diagonal walls
        }
    }

}
