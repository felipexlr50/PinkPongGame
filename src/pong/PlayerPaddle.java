package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerPaddle {

	int x;
	int y;
	int largura = 20;
	int altura = 50;
	int speed = 2;
	int speedReset=0;
	int handcap = 2;

	double veloAcr=0.3; 		//valor de acrescimo
	double speed2 = speed;
	double veloMax = 4;

	Rectangle boundingBox;

	boolean goingUp = false;
	boolean goingDown = false;

	public PlayerPaddle(int x, int y) {
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

		if(goingUp && y>0){
			y-=speed;
		}
		if(goingDown && y < game.getHeight() - altura){
			y+=speed;
		}

		if(handcap+game.p1Score<game.p2Score){
			speed2+=veloAcr;
			speed=(int)speed2;
		}
		else{
			speed=speedReset;
			speed=speedReset;
		}



	}

	public void render(Graphics g){
		g.setColor(Color.cyan);
		g.fillRect(x, y, largura, altura);
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



}
