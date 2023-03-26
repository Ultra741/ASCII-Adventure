package me.ultradev.game.data;

import me.ultradev.game.GameStage;
import me.ultradev.game.grid.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Data {

    public static JFrame FRAME;
    public static JTextPane TEXT_PANE;
    public static JTextPane INPUT_PANE;
    public static Font FONT = new Font("Monospaced", Font.PLAIN, 14);

    public static String GRID;
    public static final int GRID_HEIGHT = 10;
    public static final int GRID_WIDTH = 50;
    public static boolean CONTROLS_ENABLED = false;
    public static GameStage GAME_STAGE = GameStage.NONE;
    public static String OBJECTIVE;
    public static final Map<Coordinate, String> CHARACTERS = new HashMap<>();

    public static final Coordinate PLAYER_COORDINATE = new Coordinate(0, 0);
    public static String USERNAME = DataManager.getString("username");
    public static int HEALTH;

}
