
package me.ultradev.api.data;

import me.ultradev.api.util.StringUtil;

import java.io.*;

public class DataManager {

    public static void createDataFile() {
        try {
            File file = new File("data.txt");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(String key) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String line = "";
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    if (!line.startsWith("#") && line.startsWith(key + ": ")) {
                        reader.close();
                        return line.replaceFirst(key + ": ", "");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getInteger(String key) {
        String value = getString(key);
        if (value == null) return -1;
        else try {
            return Integer.parseInt(key);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    public static boolean getBoolean(String key) {
        String value = getString(key);
        if (value == null) return false;
        else return value.equals("true");
    }

    public static void set(String key, String value) {
        File file = new File("data.txt");
        try {
            String currentValue = getString(key);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder buffer = new StringBuilder();
            String line = "";

            if (currentValue != null) {
                while (line != null) {
                    line = reader.readLine();
                    if (line != null) {
                        if (!line.startsWith("#")) {
                            buffer.append(line.replaceAll(key + ": " + currentValue, key + ": " + value)).append("\n");
                        }
                    }
                }
            } else {
                buffer.append(key).append(": ").append(value).append("\n");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("# This file is used to store your game data.\n" +
                    "# Please don't manually edit this file!\n\n" +
                    StringUtil.replaceLast(buffer.toString(), "\n", ""));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void set(String key, int value) {
        set(key, String.valueOf(value));
    }

    public static void set(String key, boolean value) {
        set(key, value ? "true" : "false");
    }

}
