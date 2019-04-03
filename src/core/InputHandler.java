package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.MainMenu;

public class InputHandler implements KeyListener {
    Game game;

    public InputHandler(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        //player 1
        if (keyCode == KeyEvent.VK_W) {

            game.getPlayer().setGoingUp(true);

        }

        if (keyCode == KeyEvent.VK_S) {

            game.getPlayer().setGoingDown(true);
        }

        //player 2
        if (keyCode == KeyEvent.VK_UP) {

            game.getAi().setGoingUp(true);
        }

        if (keyCode == KeyEvent.VK_DOWN) {

            game.getAi().setGoingDown(true);
        }

        //other controls

        if (keyCode == KeyEvent.VK_ESCAPE) {
            game.setGameRunning(false);
            game.getMusic().pararSom();
            game.getFrame().dispose();
            game.getImage().flush();

            new MainMenu();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        //player 1
        if (keyCode == KeyEvent.VK_W) {

            game.getPlayer().setGoingUp(false);
        }

        if (keyCode == KeyEvent.VK_S) {

            game.getPlayer().setGoingDown(false);
        }

        //player 2
        if (keyCode == KeyEvent.VK_UP) {

            game.getAi().setGoingUp(false);
        }

        if (keyCode == KeyEvent.VK_DOWN) {

            game.getAi().setGoingDown(false);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
