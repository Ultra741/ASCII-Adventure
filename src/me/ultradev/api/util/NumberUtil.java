package me.ultradev.api.util;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class NumberUtil {

    public static final Random RANDOM = new Random();

    public static String toFancyNumber(int num) {
        return NumberFormat.getInstance(Locale.US).format((Integer) num);
    }

    public static String toFancyNumber(double num) {
        return NumberFormat.getInstance(Locale.US).format(num);
    }

    /**
     * Converts an integer to a Roman numeral.
     * @param input the number to convert
     * @return the input converted to a roman numeral
     * @apiNote does not support numbers lower than 1 or higher than 3999
     */
    public static String toRoman(int input) {

        if(input < 1 || input > 3999) {
            return "Invalid Roman Number Value";
        }

        StringBuilder s = new StringBuilder();

        while(input >= 1000) {
            s.append("M");
            input -= 1000;
        }

        while(input >= 900) {
            s.append("CM");
            input -= 900;
        }

        while(input >= 500) {
            s.append("D");
            input -= 500;
        }

        while(input >= 400) {
            s.append("CD");
            input -= 400;
        }

        while(input >= 100) {
            s.append("C");
            input -= 100;
        }

        while(input >= 90) {
            s.append("XC");
            input -= 90;
        }

        while(input >= 50) {
            s.append("L");
            input -= 50;
        }

        while(input >= 40) {
            s.append("XL");
            input -= 40;
        }

        while(input >= 10) {
            s.append("X");
            input -= 10;
        }

        while(input >= 9) {
            s.append("IX");
            input -= 9;
        }

        while(input >= 5) {
            s.append("V");
            input -= 5;
        }

        while(input >= 4) {
            s.append("IV");
            input -= 4;
        }

        while(input >= 1) {
            s.append("I");
            input -= 1;
        }

        return s.toString();

    }

    /**
     * Gets a random number between two specified bounds.
     * @param min the minimum value
     * @param max the maximum value
     * @return a random number between the minimum and maximum values
     */
    public static int getRandomBetween(int min, int max) {
        return RANDOM.nextInt(max + 1 - min) + min;
    }

}
