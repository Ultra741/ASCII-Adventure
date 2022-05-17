package me.ultradev;

import me.ultradev.api.data.DataManager;
import me.ultradev.api.grid.GridManager;
import me.ultradev.api.grid.RoomGenerator;
import me.ultradev.api.grid.WallType;
import me.ultradev.api.player.InputManager;
import me.ultradev.api.player.PlayerManager;
import me.ultradev.api.util.NumberUtil;

public class Main {

    public static void main(String[] args) {

        DataManager.createDataFile();
        if(!DataManager.getBoolean("has_played_before")) {
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

        while(true) {

            GridManager.resetGrid();
            GridManager.updateGrid();
            RoomGenerator.generateWall(WallType.HORIZONTAL,
                    NumberUtil.getRandomBetween(0, GridManager.GRID_HEIGHT - 1),
                    NumberUtil.getRandomBetween(10, 30));
            RoomGenerator.generateWall(WallType.VERTICAL,
                    NumberUtil.getRandomBetween(0, GridManager.GRID_WIDTH - 1),
                    NumberUtil.getRandomBetween(10, 30));
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
