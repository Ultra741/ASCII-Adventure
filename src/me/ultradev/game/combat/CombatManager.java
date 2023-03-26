package me.ultradev.game.combat;

public class CombatManager {

    public static void startFight(Monster monster) {
        int i = 0;
        int direction = 1;
        try {
            while (true) {
                char[] chars = "-".repeat(21).toCharArray();
                chars[i] = 'X';
                System.out.println(chars);
                System.out.println(" ".repeat(10) + "^");
                Thread.sleep(100);
                if (i == 0) direction = 1;
                else if (i == 20) direction = -1;
                i += direction;
            }
        } catch (InterruptedException ignored) {}
    }

}
