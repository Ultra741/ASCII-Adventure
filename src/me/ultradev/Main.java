package me.ultradev;

import me.ultradev.api.data.DataManager;
import me.ultradev.api.dialogue.Dialogue;
import me.ultradev.api.dialogue.DialogueOption;
import me.ultradev.game.grid.GridManager;
import me.ultradev.game.player.ConsoleManager;

import static me.ultradev.game.player.PlayerManager.PLAYER_COORDINATE;

public class Main {

    public static void main(String[] args) {
        DataManager.createDataFile();
        String username = DataManager.getString("username");

        if (username == null) {
            ConsoleManager.waitForEnter("""
                       _    __    ___  _____ _____     _       _                 _                 \s
                      /_\\  / _\\  / __\\ \\_   \\\\_   \\   /_\\   __| |_   _____ _ __ | |_ _   _ _ __ ___\s
                     //_\\\\ \\ \\  / /     / /\\/ / /\\/  //_\\\\ / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _ \\
                    /  _  \\_\\ \\/ /___/\\/ /_/\\/ /_   /  _  \\ (_| |\\ V /  __/ | | | |_| |_| | | |  __/
                    \\_/ \\_/\\__/\\____/\\____/\\____/   \\_/ \\_/\\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\___|
                                                                                                   
                    Welcome to ASCII Adventure, a text-based dungeon crawler.
                    Press ENTER to start your adventure.""");
            ConsoleManager.clear();
            while (true) {
                System.out.println("Welcome to ASCII Adventure!\nEnter your username:" + "\n".repeat(10));
                username = ConsoleManager.getInput("");
                if (username.isBlank()) {
                    ConsoleManager.clear();
                    System.out.println("Please enter a valid name!\n");
                } else if (username.length() < 3) {
                    ConsoleManager.clear();
                    System.out.println("Please enter a name that is at least 3 characters long!\n");
                } else break;
            }
            ConsoleManager.clear();
            DataManager.set("username", username);
        }

        int tutorial = DataManager.getInteger("tutorial");
        if (tutorial == -1) {
            GridManager.resetGrid();
            GridManager.updateGrid();
            new Dialogue("Guy")
                    .pin(GridManager.GRID)
                    .option("do you like cheese?",
                            new DialogueOption.Option("Yes!", new Dialogue()
                                    .line("awesome")
                                    .line("you are very cool")),
                            new DialogueOption.Option("No :(", new Dialogue("Angry Guy")
                                    .line("what????")
                                    .option("are you sure????",
                                            new DialogueOption.Option("Yes?", new Dialogue("Very Angry Guy")
                                                    .line("WTF IS WRONG WITH YOU")),
                                            new DialogueOption.Option("No", new Dialogue("Guy")
                                                    .line("thank god")
                                                    .line("i love you")))))
                    .send();
            return;
        }

        while (true) {
            GridManager.resetGrid();
            GridManager.updateGrid();
            GridManager.printGrid();

            String wasd = ConsoleManager.getInput("Use WASD to move around");
            if (wasd.equalsIgnoreCase("w")) {
                PLAYER_COORDINATE.add(0, 1);
            } else if (wasd.equalsIgnoreCase("a")) {
                PLAYER_COORDINATE.add(-1, 0);
            } else if (wasd.equalsIgnoreCase("s")) {
                PLAYER_COORDINATE.add(0, -1);
            } else if (wasd.equalsIgnoreCase("d")) {
                PLAYER_COORDINATE.add(1, 0);
            }
        }

    }

}
