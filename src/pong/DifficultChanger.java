package pong;

import view.MainMenu;

public class DifficultChanger {
	
	
	public DifficultChanger(PlayerPaddle player, AIPaddle ai, Ball ball) {
		mudarDificuldade(player, ai, ball);
	}
	
	
	public void mudarDificuldade(PlayerPaddle player, AIPaddle ai, Ball ball){
		
		if(MainMenu.handler.isEasyFlag()){
			//ball settings overhaul
			ball.setBallVeloAcr(0.1);
			ball.setSpeed(2);
			ball.setVeloMax(3);
			
			//ai settings overhaul
			ai.setVeloAcr(0);
			ai.setSpeed(1);
			ai.setHandcap(1);
			ai.setVeloMax(2.0);
			
			//Player settings overhaul
			player.setVeloAcr(0.3);
			player.setSpeed(2);
			player.setHandcap(2);
			player.setVeloMax(3);
						
		}
		
		else if(MainMenu.handler.isNormalFlag()){
			//ball settings overhaul
			ball.setBallVeloAcr(0.2);
			ball.setSpeed(2);
			ball.setVeloMax(4);
			
			//ai settings overhaul
			ai.setVeloAcr(0.3);
			ai.setSpeed(2);
			ai.setHandcap(2);
			ai.setVeloMax(3.0);
			
			//Player settings overhaul
			player.setVeloAcr(0.3);
			player.setSpeed(2);
			player.setHandcap(2);
			player.setVeloMax(3);

		}
		
		else if(MainMenu.handler.isHardFlag()){
			
			//ball settings overhaul
			ball.setBallVeloAcr(0.3);
			ball.setSpeed(2);
			ball.setVeloMax(6);
			
			//ai settings overhaul
			ai.setVeloAcr(0.5);
			ai.setSpeed(3);
			ai.setHandcap(5);
			ai.setVeloMax(5.0);
			
			//Player settings overhaul
			player.setVeloAcr(0.3);
			player.setSpeed(3);
			player.setHandcap(5);
			player.setVeloMax(4.0);

		}
		
	}

}
