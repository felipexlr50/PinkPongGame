package pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.MainMenu;

public class InputHandler implements KeyListener  {
	Game game;
	
	public InputHandler(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		//player 1
		if(keyCode == KeyEvent.VK_W){

			game.player.setGoingUp(true);
			
		}

		if(keyCode == KeyEvent.VK_S){

			game.player.setGoingDown(true);
		}
		
		//player 2
		if(keyCode == KeyEvent.VK_UP){

			game.ai.setGoingUp(true);
		}

		if(keyCode == KeyEvent.VK_DOWN){

			game.ai.setGoingDown(true);
		}
		
		//other controls
		
		if(keyCode == KeyEvent.VK_ESCAPE){
			game.setGameRunning(false);
			game.music.pararSom();
			game.frame.dispose();
			game.image.flush();
			
			new MainMenu();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		//player 1
		if(keyCode == KeyEvent.VK_W){

			game.player.setGoingUp(false);
		}

		if(keyCode == KeyEvent.VK_S){

			game.player.setGoingDown(false);
		}
		
		
		//player 2
		if(keyCode == KeyEvent.VK_UP){

			game.ai.setGoingUp(false);
		}

		if(keyCode == KeyEvent.VK_DOWN){

			game.ai.setGoingDown(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
