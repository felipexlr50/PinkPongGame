package core.interfaces;

import java.awt.Graphics;

import core.Game;

public interface GameInterface {

    public default void tick(Game game, Double deltaTime) {
    }

    public default void render(Graphics g) {
    }
}
