package me.ultradev.api.grid;

import me.ultradev.api.util.StringUtil;

import java.util.Scanner;

public class InputManager {

    public static String getInput(String message) {
        StringUtil.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
