package me.ultradev.game;

import me.ultradev.game.data.Data;
import me.ultradev.game.data.DataManager;
import me.ultradev.game.grid.Coordinate;
import me.ultradev.game.grid.GridManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.CountDownLatch;

public class KeyListener extends KeyAdapter {

    public static void waitForKey(int keyCode) {
        CountDownLatch latch = new CountDownLatch(1);
        Data.FRAME.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == keyCode) {
                    latch.countDown();
                }
            }
        });

        try {
            latch.await();
        } catch (InterruptedException ignored) {}
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (Data.CONTROLS_ENABLED) {
            System.out.println("Key pressed: " + e.getKeyCode());
            Coordinate coordinate = Data.PLAYER_COORDINATE.clone();
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                coordinate.add(0, 1);
            } else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
                coordinate.add(-1, 0);
            } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                coordinate.add(0, -1);
            } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                coordinate.add(1, 0);
            } else return;

            // Tutorial stuff
            if (Data.GAME_STAGE.equals(GameStage.TUTORIAL_1)) {
                if (coordinate.distance(25, 5) <= 1.5) {
                    Data.CONTROLS_ENABLED = false;
                    Data.PLAYER_COORDINATE.set(0, 0);
                    DataManager.set("tutorial", 1);
                    new Thread(() -> TutorialManager.startTutorial(1)).start();
                    return;
                }
            }

            if (coordinate.isValid() && coordinate.clone().add(0, 1).isValid()) {
                Data.PLAYER_COORDINATE.set(coordinate);
            }
            GridManager.updateGrid();
            GridManager.displayGrid();
        }
    }

}