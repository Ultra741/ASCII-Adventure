package me.ultradev.api.util;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringUtil {

    /**
     * Checks whether the given string should have "a" or "an" before it.
     * @param s the string to check for
     * @return the result of the check
     */
    public static String getAOrAn(String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        for(Character check : vowels) {
            if(s.toLowerCase().charAt(0) == check) {
                return "An";
            }
        }
        return "A";
    }

    public static String getLowerAOrAn(String s) {
        return getAOrAn(s).toLowerCase();
    }

    /**
     * Repeats the given string a certain number of times.
     * @param s the string to repeat
     * @param amount the amount of times to repeat
     * @return the specified string repeated the specified amount of times
     */
    public static String repeat(String s, int amount) {
        return String.join("", Collections.nCopies(amount, s));
    }

    public static String replaceLast(String string, String toReplace, String replaceWith) {
        StringBuilder builder = new StringBuilder(string);
        int index = builder.lastIndexOf(toReplace);
        builder.replace(index, index + toReplace.length(), replaceWith);
        return builder.toString();
    }

    /**
     * Joins a list, adding the specified string between each value from the list.
     * @param list the list to join
     * @param toAdd the string to add between each value
     * @return the joined list
     */
    public static String join(List<String> list, String toAdd) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            builder.append(element);
            if(i != list.size() - 1) builder.append(toAdd);
        }
        return builder.toString();
    }

    /**
     * Prints a message to the console.
     * @param s the string to print
     * @apiNote supports unicode characters, while System.out.println doesn't
     */
    public static void print(String s) {

        Charset UTF_8 = StandardCharsets.UTF_8;
        byte[] sourceBytes = s.getBytes(StandardCharsets.UTF_8);
        Charset defaultCharset = Charset.defaultCharset();
        try {
            String data = new String(sourceBytes, defaultCharset.name());
            PrintStream out = new PrintStream(System.out, true, UTF_8.name());
            out.println(data);
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
