package me.ultradev;

import me.ultradev.game.data.DataManager;
import me.ultradev.api.util.NumberUtil;
import me.ultradev.game.TutorialManager;
import me.ultradev.game.data.Data;
import me.ultradev.game.KeyListener;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        DataManager.createDataFile();
        String username = DataManager.getString("username");

        Data.FRAME = new JFrame();
        Data.FRAME.setTitle("ASCIIAdventure");
        URL icon = Main.class.getResource("icon.png");
        if (icon == null) {
            System.out.println("Couldn't find icon.png!");
            return;
        }
        Data.FRAME.setIconImage(new ImageIcon(icon).getImage());
        Data.FRAME.setSize(1000, 500);
        Data.FRAME.setResizable(false);
        Data.FRAME.setLocationRelativeTo(null);
        Data.FRAME.addKeyListener(new KeyListener());
        Data.FRAME.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        Data.TEXT_PANE = new JTextPane();
        Data.TEXT_PANE.setFocusable(false);
        Data.TEXT_PANE.setFont(Data.FONT);

        StyledDocument doc = Data.TEXT_PANE.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        Data.INPUT_PANE = new JTextPane();
        Data.INPUT_PANE.setFont(Data.FONT);
        Data.INPUT_PANE.setVisible(false);

        doc = Data.INPUT_PANE.getStyledDocument();
        center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        Data.INPUT_PANE.setPreferredSize(new Dimension(400, 300));

        panel.add(Data.TEXT_PANE);
        panel.add(Data.INPUT_PANE);
        Data.FRAME.add(panel);

        CountDownLatch latch = new CountDownLatch(1);
        if (username == null) {
            Data.TEXT_PANE.setText("""
                       _    __    ___  _____ _____     _       _                 _                 \s
                      /_\\  / _\\  / __\\ \\_   \\\\_   \\   /_\\   __| |_   _____ _ __ | |_ _   _ _ __ ___\s
                     //_\\\\ \\ \\  / /     / /\\/ / /\\/  //_\\\\ / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _ \\
                    /  _  \\_\\ \\/ /___/\\/ /_/\\/ /_   /  _  \\ (_| |\\ V /  __/ | | | |_| |_| | | |  __/
                    \\_/ \\_/\\__/\\____/\\____/\\____/   \\_/ \\_/\\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\___|
                                                                                                   
                    Welcome to ASCII Adventure, a text-based dungeon crawler.
                    Press ENTER to start your adventure.""");
            KeyListener.waitForKey(KeyEvent.VK_ENTER);

            Data.TEXT_PANE.setText("Welcome to ASCII Adventure!\nEnter your username:\n(Username must be at least 3 characters long)");
            String[] names = new String[]{"John", "Peter", "Oliver", "William", "Lucas", "James", "Jack", "Jacob", "Samuel", "Luke", "Thomas"};
            Data.INPUT_PANE.setText(names[NumberUtil.getRandomBetween(0, names.length - 1)]);
            Data.INPUT_PANE.setVisible(true);

            Data.INPUT_PANE.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "ENTER");
            Data.INPUT_PANE.getActionMap().put("ENTER", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = Data.INPUT_PANE.getText();
                    if (username.length() >= 3) {
                        Data.USERNAME = username;
                        DataManager.set("username", username);
                        Data.FRAME.requestFocus();
                        Data.INPUT_PANE.setVisible(false);
                        latch.countDown();
                    }
                }
            });
            try {
                latch.await();
            } catch (InterruptedException ignored) {
            }
        }

        TutorialManager.startTutorial(DataManager.getInteger("tutorial"));

    }

}
