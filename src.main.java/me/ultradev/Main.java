package me.ultradev;

import me.ultradev.api.grid.GridManager;
import me.ultradev.api.grid.InputManager;
import me.ultradev.api.player.PlayerManager;
import me.ultradev.game.Symbol;

public class Main {

    public static void main(String[] args) {
        while(true) {
            GridManager.setupGrid();
            GridManager.setCharacterAt(PlayerManager.x, PlayerManager.y, Symbol.PLAYER);
            GridManager.printGrid();
            String wasd = InputManager.getInput("Use WASD to move around");
            if(wasd.equalsIgnoreCase("w")) {
                PlayerManager.y += 3;
            } else if(wasd.equalsIgnoreCase("a")) {
                PlayerManager.x -= 3;
            } else if(wasd.equalsIgnoreCase("s")) {
                PlayerManager.y -= 3;
            } else if(wasd.equalsIgnoreCase("d")) {
                PlayerManager.x += 3;
            }
        }
    }

}
