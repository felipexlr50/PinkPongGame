package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

    private int x, y;
    private int size = 10;
    private int speed = 2;
    private double ballVeloAcr = 0.3;
    private double speed2 = 2;
    private double veloMax = 5;
    private int vx;
    private int vy;

    private int ballFlag = 0;

    private Rectangle boundingBox;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;

        vx = speed;
        vy = speed;

        boundingBox = new Rectangle(x, y, size, size);
        boundingBox.setBounds(x, y, size, size);
    }

    public void tick(Game game, Double deltaTime) {
        boundingBox.setBounds(x, y, size, size);

        double auxVelMax = veloMax * deltaTime;

        if (game.ai.isTwoPlayer()) {
            ballVeloAcr = 0;
        }

        if (speed2 > auxVelMax) {
            speed2 = auxVelMax;
        }

        if (x <= 0) {
            game.p1Score--;
            //BallVeloAcr();
            vx = (int) (speed * deltaTime);
        }
        else if ((x + size) >= game.getWidth()) {

            game.p2Score--;

            //BallVeloAcr();
            vx = (int) (-speed * deltaTime);
        }

        if (y <= 0) {
            vy = (int) (speed * deltaTime);
        }
        else if ((y + size) >= game.getHeight()) {

            vy = (int) (-speed * deltaTime);
        }

        if (game.p1Score > game.p2Score) {
            game.scoreFlag = 1;
            ballFlag = 1;
        }
        else if (game.p2Score > game.p1Score) {
            game.scoreFlag = 2;
            ballFlag = 2;
        }
        else {
            game.scoreFlag = 0;
            ballFlag = 0;
        }

        x += vx * deltaTime;
        y += vy * deltaTime;

        paddleCollide(game, deltaTime);

    }

    private void paddleCollide(Game game, Double deltaTime) {

        if (boundingBox.intersects(game.player.getBoundingBox())) {
            BallVeloAcr(deltaTime);
            aiBug(game);
            vx = (int) (speed * deltaTime);

        }
        else if (boundingBox.intersects(game.ai.getBoundingBox())) {
            BallVeloAcr(deltaTime);
            aiBug(game);
            vx = (int) (-speed * deltaTime);
        }
    }

    public void render(Graphics g) {

        if (ballFlag == 1) {
            g.setColor(Color.cyan);
            g.fillRect(x, y, size, size);
        }
        else if (ballFlag == 2) {
            g.setColor(Color.pink);
            g.fillRect(x, y, size, size);
        }
        else {
            g.setColor(Color.white);
            g.fillRect(x, y, size, size);
        }

    }

    private void BallVeloAcr(Double deltaTime) {
        speed2 += ballVeloAcr * deltaTime;
        speed = (int) speed2;
    }

    public void aiBug(Game game) {
        Random aibug = new Random();
        game.ai.setBug((game.getWidth() / 2) - aibug.nextInt(200));
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getBallVeloAcr() {
        return ballVeloAcr;
    }

    public void setBallVeloAcr(double ballVeloAcr) {
        this.ballVeloAcr = ballVeloAcr;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getBallFlag() {
        return ballFlag;
    }

    public void setBallFlag(int ballFlag) {
        this.ballFlag = ballFlag;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }

}
