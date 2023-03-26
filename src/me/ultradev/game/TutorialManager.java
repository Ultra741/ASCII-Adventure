package me.ultradev.game;

import me.ultradev.api.dialogue.Dialogue;
import me.ultradev.game.data.Data;
import me.ultradev.game.grid.Coordinate;
import me.ultradev.game.grid.GridManager;

public class TutorialManager {

    public static void startTutorial(int stage) {
        if (stage == -1) {
            Data.CHARACTERS.put(new Coordinate(25, 5), "X");
            Data.OBJECTIVE = "Move towards the X.";
            GridManager.updateGrid();
            new Dialogue("Bob")
                    .pin(Data.GRID)
                    .line("Welcome, " + Data.USERNAME + ".")
                    .line("I am Bob. I will be your guide on this awesome adventure.")
                    .line("I mean, ASCII Adventure.")
                    .line("As you can see, you are currently standing in a small room.")
                    .line("Try moving towards the X.")
                    .send();
            GridManager.displayGrid();
            Data.GAME_STAGE = GameStage.TUTORIAL_1;
            Data.CONTROLS_ENABLED = true;
        } else if (stage == 1) {
            Data.CHARACTERS.clear();
            GridManager.updateGrid();
            new Dialogue("Bob")
                    .pin(Data.GRID)
                    .line("Good job!")
                    .line("In your adventure you'll be exploring rooms, slaying monsters and solving puzzles.")
                    .line("The further you get, the harder it'll become.")
                    .line("Now, it's time to battle your first monster.")
                    .line("Say hello to Skelly, the skeleton.")
                    .line("(Skelly doesn't exist yet, I need to code the combat system first)")
                    .send();
            Data.HEALTH = 10;
            //CombatManager.startFight(Monster.SKELLIE);
        }
    }

}
