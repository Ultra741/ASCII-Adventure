package me.ultradev.api.data;

import java.io.*;

public class DataManager {

    /**
     * Creates the data file if it doesn't already exist.
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

    public static void setValue(String key, String value) {
        File file = new File("data.txt");
        try {

            String currentValue = getValue(key);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder buffer = new StringBuilder();
            String line = "";

            while(line != null) {
                line = reader.readLine();
                if(line != null) {
                    buffer.append(line.replaceAll(key + ": " + currentValue, key + ": " + value)).append("\n");
                }
            }

            if(currentValue == null) buffer.append(key).append(": ").append(value).append("\n");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(buffer.toString());
            writer.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String line = "";
            while(line != null) {
                line = reader.readLine();
                if(line != null) {
                    if(line.startsWith(key + ": ")) {
                        reader.close();
                        return line.replaceFirst(key + ": ", "");
                    }
                }
            }
            return null;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
