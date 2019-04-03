package core.gameObjects;

import java.awt.Rectangle;

import core.Game;

public class GameObject {

    protected Integer x;
    protected Integer y;
    protected Integer largura;
    protected Integer altura;
    protected Double speed;
    protected Double speedReset;
    protected Double handcap;
    protected Double veloAcr;
    protected Double speed2;
    protected Double veloMax;
    protected Rectangle boundingBox;
    protected boolean goingUp;
    protected boolean goingDown;

    /**
     *
     */
    public GameObject() {
        setSpeed(2.0);
        setSpeedReset(speed);
        setSpeed2(speed);
    }

    public void checkMaxSpeed(Double deltaTime) {
        double auxVelMax = veloMax * deltaTime;
        if (speed2 > auxVelMax) {
            setSpeed2(auxVelMax);
        }
    }

    public void checkObjectMovement(Game game, Double deltaTime) {
        if (goingUp && (y > 0)) {
            y -= (int) (speed * deltaTime);
        }
        if (goingDown && (y < (game.getHeight() - altura))) {
            y += (int) (speed * deltaTime);
        }
    }

    public void checkObjectSpeed(Game game, Double deltaTime) {
        if ((handcap + game.p1Score) < game.p2Score) {
            speed2 += veloAcr * deltaTime;
            speed = speed2;
        }
        else {
            speed = (double) speedReset;
        }
    }

    /**
     * @return the x
     */
    public Integer getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public Integer getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * @return the largura
     */
    public Integer getLargura() {
        return largura;
    }

    /**
     * @param largura the largura to set
     */
    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    /**
     * @return the altura
     */
    public Integer getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    /**
     * @return the speed
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * @return the speedReset
     */
    public Double getSpeedReset() {
        return speedReset;
    }

    /**
     * @param speedReset the speedReset to set
     */
    public void setSpeedReset(Double speedReset) {
        this.speedReset = speedReset;
    }

    /**
     * @return the handcap
     */
    public Double getHandcap() {
        return handcap;
    }

    /**
     * @param handcap the handcap to set
     */
    public void setHandcap(Double handcap) {
        this.handcap = handcap;
    }

    /**
     * @return the veloAcr
     */
    public Double getVeloAcr() {
        return veloAcr;
    }

    /**
     * @param veloAcr the veloAcr to set
     */
    public void setVeloAcr(Double veloAcr) {
        this.veloAcr = veloAcr;
    }

    /**
     * @return the speed2
     */
    public Double getSpeed2() {
        return speed2;
    }

    /**
     * @param speed2 the speed2 to set
     */
    public void setSpeed2(Double speed2) {
        this.speed2 = speed2;
    }

    /**
     * @return the veloMax
     */
    public Double getVeloMax() {
        return veloMax;
    }

    /**
     * @param veloMax the veloMax to set
     */
    public void setVeloMax(Double veloMax) {
        this.veloMax = veloMax;
    }

    /**
     * @return the boundingBox
     */
    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    /**
     * @param boundingBox the boundingBox to set
     */
    public void setBoundingBox(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }

    /**
     * @return the goingUp
     */
    public boolean isGoingUp() {
        return goingUp;
    }

    /**
     * @param goingUp the goingUp to set
     */
    public void setGoingUp(boolean goingUp) {
        this.goingUp = goingUp;
    }

    /**
     * @return the goingDown
     */
    public boolean isGoingDown() {
        return goingDown;
    }

    /**
     * @param goingDown the goingDown to set
     */
    public void setGoingDown(boolean goingDown) {
        this.goingDown = goingDown;
    }

}
