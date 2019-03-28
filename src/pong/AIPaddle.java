package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AIPaddle {

    private int x;
    private int y;
    private int largura = 20;
    private int altura = 50;
    private int speed = 2;
    private int bug;
    private int speedReset = 0;
    private int handcap = 2;

    private double veloAcr = 0.3;
    private double speed2 = 2;
    private double veloMax = 4;

    private Rectangle boundingBox;

    private boolean goingUp = false;
    private boolean goingDown = false;
    private boolean isTwoPlayer = false;

    public AIPaddle(int x, int y) {
        this.x = x;
        this.y = y;

        boundingBox = new Rectangle(x, y, largura, altura);
        boundingBox.setBounds(x, y, largura, altura);
        speedReset = speed;

        if (isTwoPlayer) {
            setHandcap(2);
            setSpeed(2);
            setVeloAcr(0.3);
            setVeloMax(3);
        }
    }

    public void tick(Game game, Double deltaTime) {

        boundingBox.setBounds(x, y, largura, altura);

        double auxVeloMax = veloMax * deltaTime;

        if (speed2 > auxVeloMax) {
            speed2 = auxVeloMax;
        }

        if ((handcap + game.p2Score) < game.p1Score) {
            speed2 += veloAcr * deltaTime;
            speed = (int) speed2;
        }
        else {
            speed = speedReset;
        }

        if (!isTwoPlayer()) {
            speed = speed + 1;
            //Ai settings
            if (game.ball.getX() > bug) {

                if ((game.ball.getY() < (y + altura)) && (y > 0)) {
                    y -= speed * deltaTime;
                }

                else if ((game.ball.getY() > y) && ((y + altura) < game.getHeight())) {
                    y += speed * deltaTime;
                }

                //System.out.println(bug);
            }

        }

        //player 2 settings
        else {
            if (goingUp && (y > 0)) {
                y -= speed * deltaTime;
            }
            if (goingDown && (y < (game.getHeight() - altura))) {
                y += speed * deltaTime;
            }
        }

    }

    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(x, y, largura, altura);
    }

    public boolean isTwoPlayer() {
        return isTwoPlayer;
    }

    public void setTwoPlayer(boolean isTwoPlayer) {
        this.isTwoPlayer = isTwoPlayer;
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

    public int getBug() {
        return bug;
    }

    public void setBug(int bug) {
        this.bug = bug;
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
