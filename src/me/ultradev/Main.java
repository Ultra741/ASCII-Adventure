package me.ultradev;

import me.ultradev.api.data.DataManager;
import me.ultradev.api.grid.GridManager;
import me.ultradev.api.grid.room.wall.Wall;
import me.ultradev.api.grid.room.wall.WallType;
import me.ultradev.api.player.InputManager;

import static me.ultradev.api.grid.RoomManager.WALLS;
import static me.ultradev.api.player.PlayerManager.PLAYER_COORDINATE;

public class Main {

    public static void main(String[] args) {

        DataManager.createDataFile();
        if (!DataManager.getBoolean("has_played_before")) {
            InputManager.getInput("""
                       _    __    ___  _____ _____     _       _                 _                 \s
                      /_\\  / _\\  / __\\ \\_   \\\\_   \\   /_\\   __| |_   _____ _ __ | |_ _   _ _ __ ___\s
                     //_\\\\ \\ \\  / /     / /\\/ / /\\/  //_\\\\ / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _ \\
                    /  _  \\_\\ \\/ /___/\\/ /_/\\/ /_   /  _  \\ (_| |\\ V /  __/ | | | |_| |_| | | |  __/
                    \\_/ \\_/\\__/\\____/\\____/\\____/   \\_/ \\_/\\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\___|
                                                                                                   
                    Welcome to ASCII Adventure, a text-based dungeon crawler.
                    Press ENTER to start.""");
            DataManager.setBoolean("has_played_before", true);
        }

        while (true) {

            GridManager.resetGrid();
            GridManager.updateGrid();
            GridManager.printGrid();
            String wasd = InputManager.getInput("Use WASD to move around");
            if (wasd.equalsIgnoreCase("w")) {
                PLAYER_COORDINATE.add(0, 1);
            } else if (wasd.equalsIgnoreCase("a")) {
                PLAYER_COORDINATE.add(-1, 0);
            } else if (wasd.equalsIgnoreCase("s")) {
                PLAYER_COORDINATE.add(0, -1);
            } else if (wasd.equalsIgnoreCase("d")) {
                PLAYER_COORDINATE.add(1, 0);
            } else if (wasd.equalsIgnoreCase("r")) {
                WALLS.clear();
                for (int i = 0; i < 20; i++) {
                    WALLS.add(Wall.getRandom(WallType.HORIZONTAL));
                    WALLS.add(Wall.getRandom(WallType.VERTICAL));
                }
            }

        }

    }

}
