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

			Game.player.goingUp = true;
			
		}

		if(keyCode == KeyEvent.VK_S){

			Game.player.goingDown = true;
		}
		
		//player 2
		if(keyCode == KeyEvent.VK_UP){

			Game.ai.goingUp = true;
		}

		if(keyCode == KeyEvent.VK_DOWN){

			Game.ai.goingDown = true;
		}
		
		//other controls
		
		if(keyCode == KeyEvent.VK_ESCAPE){
			game.setGameRunning(false);
			game.music.pararSom();
			game.frame.dispose();
			game.image.flush();
			
			
			MainMenu menu = new MainMenu();
		}
		
	
		
		
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		//player 1
		if(keyCode == KeyEvent.VK_W){

			Game.player.goingUp = false;
		}

		if(keyCode == KeyEvent.VK_S){

			Game.player.goingDown = false;
		}
		
		
		//player 2
		if(keyCode == KeyEvent.VK_UP){

			Game.ai.goingUp = false;
		}

		if(keyCode == KeyEvent.VK_DOWN){

			Game.ai.goingDown = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {


	}

}
