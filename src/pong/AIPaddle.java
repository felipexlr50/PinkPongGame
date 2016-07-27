package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class AIPaddle {

	int x;
	int y;
	int largura = 20;
	int altura = 50;
	int speed = 2;
	public static int bug;
	int speedReset=0;
	int handcap=2;
	

	double veloAcr=0.3; 		//valor de acrescimo
	double speed2 = 2;
	double veloMax = 4;

	Rectangle boundingBox;
	

	boolean goingUp = false;
	boolean goingDown = false;
	private boolean isTwoPlayer = false;
	



	public AIPaddle(int x, int y) {
		this.x = x;
		this.y = y;
		

		boundingBox = new Rectangle(x, y, largura, altura);
		boundingBox.setBounds(x, y, largura, altura);
		speedReset = speed;

	}

	public void tick(Game game){
		
		
		
		boundingBox.setBounds(x, y, largura, altura);

		if(speed2>veloMax){
			speed2=veloMax;
		}

		if(handcap+game.p2Score<game.p1Score){
			speed2+=veloAcr;
			speed=(int)speed2;
		}
		else{
			speed=speedReset;
			speed=speedReset;
		}

		if(!isTwoPlayer()){	
			speed =speed+1;
			//Ai settings
			if(game.ball.x>bug){

				if(game.ball.y < y + altura && y > 0){
					y-=speed;
				}

				else if(game.ball.y > y  && y + altura < game.getHeight()){
					y+=speed;
				}
				
				System.out.println(bug);
			}

		}


		//player 2 settings
		else{
			if(goingUp && y>0){
				y-=speed;
			}
			if(goingDown && y < game.getHeight() - altura){
				y+=speed;
			}	
			setHandcap(2);
			setSpeed(2);
			setVeloAcr(0.3);
			setVeloMax(3);

		}

		//System.out.println(speed+" --- "+speed2);

	}

	public void render(Graphics g){
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
	
	


}
