package me.ultradev.api.util;

public class StringUtil {

    private StringUtil() {}

    public static final char[] VOWELS = new char[]{'a', 'e', 'i', 'o', 'u'};

    public static String getAOrAn(String s) {
        char firstChar = s.charAt(0);
        for (Character check : VOWELS) {
            if (firstChar == check) {
                return "an";
            }
        }
        return "a";
    }

    public static String getUpperAOrAn(String s) {
        return getAOrAn(s).toUpperCase();
    }

    public static String replaceLast(String string, String toReplace, String replaceWith) {
        StringBuilder builder = new StringBuilder(string);
        int index = builder.lastIndexOf(toReplace);
        builder.replace(index, index + toReplace.length(), replaceWith);
        return builder.toString();
    }

}
