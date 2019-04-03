package core.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import core.Game;
import core.interfaces.GameInterface;

public class Ball extends GameObject implements GameInterface {

    private Integer size;
    private Integer ballFlag;
    private Double ballVeloAcr;
    private Double vx;
    private Double vy;
    private Rectangle boundingBox;

    public Ball(int x, int y) {
        setX(x);
        setY(y);
        vx = speed;
        vy = speed;

        size = 10;
        ballFlag = 0;
        ballVeloAcr = 0.3;

        boundingBox = new Rectangle(x, y, size, size);
        boundingBox.setBounds(x, y, size, size);

    }

    @Override
    public void tick(Game game, Double deltaTime) {
        boundingBox.setBounds(x, y, size, size);

        checkMaxSpeed(deltaTime);
        checkBallXSpeed(game, deltaTime);
        checkBallYSpeed(game, deltaTime);
        calcBallMovement(deltaTime);
        paddleCollide(game, deltaTime);

        //System.out.println("ball y: " + y + " || ball vy: " + vy);
    }

    private void calcBallMovement(Double deltaTime) {
        vx = vx == 0 ? vx + 1 : vx;
        vy = vy == 0 ? vy + 1 : vy;

        x += (int) (vx * deltaTime);
        y += (int) (vy * deltaTime);
    }

    private void checkBallXSpeed(Game game, Double deltaTime) {
        if (x <= 0) {
            game.setHasRightScored(true);
            BallVeloAcr(deltaTime);
            vx = (speed * deltaTime);
        }
        else if ((x + size) >= game.getWidth()) {
            game.setHasLeftScored(true);
            BallVeloAcr(deltaTime);
            vx = (-speed * deltaTime);
        }
    }

    private void checkBallYSpeed(Game game, Double deltaTime) {
        if (y <= 0) {
            vy = (speed * deltaTime);
        }
        else if ((y + size) >= game.getHeight()) {

            vy = (-speed * deltaTime);
        }
    }

    private void paddleCollide(Game game, Double deltaTime) {

        if (boundingBox.intersects(game.getPlayer().getBoundingBox())) {
            BallVeloAcr(deltaTime);
            aiBug(game);
            vx = (speed * deltaTime);

        }
        else if (boundingBox.intersects(game.getAi().getBoundingBox())) {
            BallVeloAcr(deltaTime);
            aiBug(game);
            vx = (-speed * deltaTime);
        }
    }

    @Override
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
        speed = speed2;
    }

    public void aiBug(Game game) {
        Random aibug = new Random();
        game.getAi().setBug((game.getWidth() / 2) - aibug.nextInt(200));
    }

    public double getBallVeloAcr() {
        return ballVeloAcr;
    }

    public void setBallVeloAcr(double ballVeloAcr) {
        this.ballVeloAcr = ballVeloAcr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(Double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(Double vy) {
        this.vy = vy;
    }

    public int getBallFlag() {
        return ballFlag;
    }

    public void setBallFlag(int ballFlag) {
        this.ballFlag = ballFlag;
    }

}
