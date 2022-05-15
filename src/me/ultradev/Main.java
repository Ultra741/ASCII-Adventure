package me.ultradev;

import me.ultradev.api.data.DataManager;
import me.ultradev.api.grid.GridManager;
import me.ultradev.api.player.InputManager;
import me.ultradev.api.player.PlayerManager;

public class Main {

    public static void main(String[] args) {
        while(true) {

            DataManager.createDataFile();

            GridManager.resetGrid();
            GridManager.updateGrid();
            GridManager.printGrid();
            String wasd = InputManager.getInput("Use WASD to move around");
            if(wasd.equalsIgnoreCase("w")) {
                PlayerManager.y += 1;
            } else if(wasd.equalsIgnoreCase("a")) {
                PlayerManager.x -= 1;
            } else if(wasd.equalsIgnoreCase("s")) {
                PlayerManager.y -= 1;
            } else if(wasd.equalsIgnoreCase("d")) {
                PlayerManager.x += 1;
            }

        }
    }

}
