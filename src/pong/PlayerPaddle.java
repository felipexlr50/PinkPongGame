package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerPaddle {

    private int x;
    private int y;
    private int largura = 20;
    private int altura = 50;
    private int speed = 2;
    private int speedReset = 0;
    private int handcap = 2;

    private double veloAcr = 0.3;
    private double speed2 = speed;
    private double veloMax = 4;

    private Rectangle boundingBox;

    private boolean goingUp = false;
    private boolean goingDown = false;

    public PlayerPaddle(int x, int y) {
        this.x = x;
        this.y = y;

        boundingBox = new Rectangle(x, y, largura, altura);
        boundingBox.setBounds(x, y, largura, altura);
        speedReset = speed;

    }

    public void tick(Game game, Double deltaTime) {
        boundingBox.setBounds(x, y, largura, altura);

        double auxveloMax = veloMax * deltaTime;

        if (speed2 > auxveloMax) {
            speed2 = auxveloMax;
        }

        if (goingUp && (y > 0)) {
            y -= speed * deltaTime;
        }
        if (goingDown && (y < (game.getHeight() - altura))) {
            y += speed * deltaTime;
        }

        if ((handcap + game.p1Score) < game.p2Score) {
            speed2 += veloAcr * deltaTime;
            speed = (int) speed2;
        }
        else {
            speed = speedReset;
        }

    }

    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(x, y, largura, altura);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHandcap() {
        return handcap;
    }

    public void setHandcap(int handcap) {
        this.handcap = handcap;
    }

    public double getVeloAcr() {
        return veloAcr;
    }

    public void setVeloAcr(double veloAcr) {
        this.veloAcr = veloAcr;
    }

    public double getSpeed2() {
        return speed2;
    }

    public void setSpeed2(double speed2) {
        this.speed2 = speed2;
    }

    public double getVeloMax() {
        return veloMax;
    }

    public void setVeloMax(double veloMax) {
        this.veloMax = veloMax;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getSpeedReset() {
        return speedReset;
    }

    public void setSpeedReset(int speedReset) {
        this.speedReset = speedReset;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }

    public boolean isGoingUp() {
        return goingUp;
    }

    public void setGoingUp(boolean goingUp) {
        this.goingUp = goingUp;
    }

    public boolean isGoingDown() {
        return goingDown;
    }

    public void setGoingDown(boolean goingDown) {
        this.goingDown = goingDown;
    }

}
