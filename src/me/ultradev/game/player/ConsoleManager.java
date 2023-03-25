package me.ultradev.game.player;

import java.util.Scanner;

public class ConsoleManager {

    public static void clear(int lines) {
        for (int i = 0; i < lines; i++) {
            System.out.println();
        }
    }

    public static void clear() {
        clear(20);
    }

    public static String getInput(String message) {
        System.out.println(message);
        return new Scanner(System.in).nextLine();
    }

    public static void waitForEnter(String message) {
        getInput(message);
    }

}
