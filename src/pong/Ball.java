package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

	int x, y;
	int size = 10;
	int speed = 2;
	double ballVeloAcr=0.3; 		//valor de acrescimo da velocidade da bola
	double speed2 = 2;
	double veloMax = 5;
	Game game;
	int vx, vy;

	int ballFlag=0;

	Rectangle boundingBox;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;

		vx = speed;
		vy = speed;

		boundingBox = new Rectangle(x, y, size, size);
		boundingBox.setBounds(x, y, size, size);


	}

	public void tick(Game game){
		boundingBox.setBounds(x, y, size, size);
		
		this.game = game;
		
		if(Game.ai.isTwoPlayer()){
			ballVeloAcr=0;
		}

		if(speed2>veloMax){
			speed2=veloMax;
		}

		if(x <= 0){
			game.p1Score--;
			//BallVeloAcr();
			vx = speed;
		}
		else if(x + size >= game.getWidth()){

			game.p2Score--;

			//BallVeloAcr();
			vx = -speed;
		}

		if(y <= 0){
			vy = speed;
		}
		else if(y + size >= game.getHeight()){

			vy = -speed;
		}

		if(game.p1Score>game.p2Score){
			game.scoreFlag=1;
			ballFlag=1;
		}
		else if(game.p2Score>game.p1Score){
			game.scoreFlag=2;
			ballFlag=2;
		}
		else{
			game.scoreFlag=0;
			ballFlag=0;
		}


		x+= vx;
		y+= vy;

		paddleCollide(game);


	}

	private void paddleCollide(Game game){


		if(boundingBox.intersects(game.player.boundingBox)){
			BallVeloAcr();
			aiBug();
			vx = speed;

		}
		else if(boundingBox.intersects(game.ai.boundingBox)){
			BallVeloAcr();
			aiBug();
			vx = -speed;
		}
	}

	public void render(Graphics g){
		//		g.setColor(Color.white);
		//		g.fillRect(x, y, size, size);

		if(ballFlag==1){
			g.setColor(Color.cyan);
			g.fillRect(x, y, size, size);
		}
		else if(ballFlag==2){
			g.setColor(Color.pink);
			g.fillRect(x, y, size, size);
		}
		else{
			g.setColor(Color.white);
			g.fillRect(x, y, size, size);
		}


	}

	private void BallVeloAcr(){
		speed2+=ballVeloAcr;
		speed=(int)speed2;
	}
	
	public void aiBug(){
		Random aibug = new Random();
		AIPaddle.bug = game.getWidth()/2 - aibug.nextInt(200);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getBallVeloAcr() {
		return ballVeloAcr;
	}

	public void setBallVeloAcr(double ballVeloAcr) {
		this.ballVeloAcr = ballVeloAcr;
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
