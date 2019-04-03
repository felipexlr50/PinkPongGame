package core.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import core.Game;
import core.interfaces.GameInterface;

public class AIPaddle extends GameObject implements GameInterface {

    private Integer bug;
    private Boolean isTwoPlayer = false;

    public AIPaddle(int x, int y) {
        setX(x);
        setY(y);
        setAltura(50);
        setLargura(20);
        setBug(1);

        boundingBox = new Rectangle(x, y, largura, altura);
        boundingBox.setBounds(x, y, largura, altura);
        speedReset = speed;

        if (isTwoPlayer) {
            setHandcap(2.0);
            setSpeed(2.0);
            setVeloAcr(0.3);
            setVeloMax(3.0);
        }
    }

    @Override
    public void tick(Game game, Double deltaTime) {

        boundingBox.setBounds(x, y, largura, altura);
        checkMaxSpeed(deltaTime);
        checkObjectSpeed(game, deltaTime);

        //Ai mode
        if (!isTwoPlayer() && (game.getBall().getX() > bug)) {
            AIMovement(game, deltaTime);
            speed++;
        }

        //player 2 mode
        else {
            checkObjectMovement(game, deltaTime);
        }

    }

    private void AIMovement(Game game, Double deltaTime) {
        if ((game.getBall().getY() < (y + altura)) && (y > 0)) {
            y -= (int) (speed * deltaTime);
        }

        else if ((game.getBall().getY() > y) && ((y + altura) < game.getHeight())) {
            y += (int) (speed * deltaTime);
        }
    }

    @Override
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

    /**
     * @return the bug
     */
    public Integer getBug() {
        return bug;
    }

    /**
     * @param bug the bug to set
     */
    public void setBug(Integer bug) {
        this.bug = bug;
    }

    /**
     * @return the isTwoPlayer
     */
    public Boolean getIsTwoPlayer() {
        return isTwoPlayer;
    }

    /**
     * @param isTwoPlayer the isTwoPlayer to set
     */
    public void setIsTwoPlayer(Boolean isTwoPlayer) {
        this.isTwoPlayer = isTwoPlayer;
    }

}
