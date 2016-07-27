package pong;

import view.MainMenu;

public class DifficultChanger {
	
	
	public DifficultChanger() {
		mudarDificuldade();
	}
	
	
	public void mudarDificuldade(){
		
		if(MainMenu.handler.isEasyFlag()){
			//ball settings overhaul
			Game.ball.setBallVeloAcr(0.1);
			Game.ball.setSpeed(2);
			Game.ball.setVeloMax(3);
			
			//ai settings overhaul
			Game.ai.setVeloAcr(0);
			Game.ai.setSpeed(1);
			Game.ai.setHandcap(0);
			Game.ai.setVeloMax(2);
			
			//Player settings overhaul
			Game.player.setHandcap(2);
			Game.player.setSpeed(2);
			Game.player.setVeloAcr(0.3);
			Game.player.setVeloMax(3);
			
			
		}
		
		else if(MainMenu.handler.isNormalFlag()){
			//ball settings overhaul
			Game.ball.setBallVeloAcr(0.2);
			Game.ball.setSpeed(2);
			Game.ball.setVeloMax(4);
			
			//ai settings overhaul
			Game.ai.setVeloAcr(0.3);
			Game.ai.setSpeed(2);
			Game.ai.setHandcap(2);
			Game.ai.setVeloMax(3);
			
			//Player settings overhaul
			Game.player.setHandcap(2);
			Game.player.setSpeed(2);
			Game.player.setVeloAcr(0.3);
			Game.player.setVeloMax(3);
		}
		
		else if(MainMenu.handler.isHardFlag()){
			//ball settings overhaul
			Game.ball.setBallVeloAcr(0.3);
			Game.ball.setSpeed(2);
			Game.ball.setVeloMax(6);
			
			//ai settings overhaul
			Game.ai.setVeloAcr(0.5);
			Game.ai.setSpeed(3);
			Game.ai.setHandcap(5);
			Game.ai.setVeloMax(5);
			
			//Player settings overhaul
			Game.player.setHandcap(5);
			Game.player.setSpeed(3);
			Game.player.setVeloAcr(0.3);
			Game.player.setVeloMax(4);
		}
		
	}

}
