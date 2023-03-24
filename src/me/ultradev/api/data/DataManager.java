package me.ultradev.api.data;

import me.ultradev.api.util.StringUtil;

import java.io.*;

public class DataManager {

    /**
     * Creates the data file if it doesn't already exist.
     *
     * @return whether the file was successfully created
     */
    public static boolean createDataFile() {
        File file = new File("data.txt");
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void setString(String key, String value) {
        File file = new File("data.txt");
        try {

            String currentValue = getString(key);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder buffer = new StringBuilder();
            String line = "";

            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    buffer.append(line.replaceAll(key + ": " + currentValue, key + ": " + value)).append("\n");
                }
            }

            if (currentValue == null) buffer.append(key).append(": ").append(value).append("\n");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(StringUtil.replaceLast(buffer.toString(), "\n", ""));
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setInteger(String key, int value) {
        setString(key, String.valueOf(value));
    }

    public static void setBoolean(String key, boolean value) {
        setString(key, value ? "true" : "false");
    }

    public static String getString(String key) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String line = "";
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    if (line.startsWith(key + ": ")) {
                        reader.close();
                        return line.replaceFirst(key + ": ", "");
                    }
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getInteger(String key) {
        String value = getString(key);
        if (value == null) return -1;
        try {
            return Integer.parseInt(key);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    public static boolean getBoolean(String key) {
        String value = getString(key);
        if (value == null) return false;
        return value.equals("true");
    }

}
