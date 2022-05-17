package me.ultradev.api.player;

import me.ultradev.api.util.StringUtil;

import java.util.Scanner;

public class InputManager {

    /**
     * Asks an input from the player.
     * @param message the message to display
     * @return whatever the player answered
     */
    public static String getInput(String message) {
        StringUtil.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
