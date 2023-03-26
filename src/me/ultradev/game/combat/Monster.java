package me.ultradev.game.combat;

import me.ultradev.game.grid.Coordinate;
import me.ultradev.game.grid.GridManager;

import java.util.function.Consumer;

public enum Monster {

    SKELLY("Skelly", 1, 1,
            coord -> GridManager.setCharacterAt(coord, "\uD83D\uDC80")),

    ;

    private final String name;
    private final int health;
    private final int damage;
    private final Consumer<Coordinate> drawConsumer;

    Monster(String name, int health, int damage, Consumer<Coordinate> drawConsumer) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.drawConsumer = drawConsumer;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public Consumer<Coordinate> getDrawConsumer() {
        return drawConsumer;
    }

}
