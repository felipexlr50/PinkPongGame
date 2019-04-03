package core.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import core.Game;
import core.interfaces.GameInterface;

public class PlayerPaddle extends GameObject implements GameInterface {

    public PlayerPaddle(int x, int y) {
        setX(x);
        setY(y);
        setSpeedReset(0.0);
        setLargura(20);
        setAltura(50);
        speedReset = speed;
        setBoundingBox(new Rectangle(x, y, largura, altura));
        boundingBox.setBounds(x, y, largura, altura);

    }

    @Override
    public void tick(Game game, Double deltaTime) {
        boundingBox.setBounds(x, y, largura, altura);

        checkMaxSpeed(deltaTime);
        checkObjectMovement(game, deltaTime);
        checkObjectSpeed(game, deltaTime);

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(x, y, largura, altura);
    }

}
