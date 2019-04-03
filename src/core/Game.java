package core;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.gameObjects.AIPaddle;
import core.gameObjects.Ball;
import core.gameObjects.PlayerPaddle;
import core.interfaces.GameInterface;
import resourses.SoundSystem;
import view.MainMenu;

public class Game extends Canvas implements Runnable, GameInterface {

    private static final long serialVersionUID = 1L;
    private final Integer TARGET_FPS = 60;
    private final Long OPTIMAL_TIME = 1000000000L / (long) TARGET_FPS;
    private Integer scoreFlag = 0;
    private Integer maxScore = 5;
    private Double baseSpeed = 1.5;
    private String ganhador;
    private Boolean gameRunning = false;

    public Integer p1Score;
    public Integer p2Score;
    private PlayerPaddle player;
    private AIPaddle ai;
    private Ball ball;
    private JFrame frame;
    private final Integer LARGURA = 1200;
    private final Integer ALTURA = (LARGURA / 16) * 9;
    private final Dimension gameSize = new Dimension(LARGURA, ALTURA);
    private final String TITTLE = "Pong 2";
    private Font font = new Font("Calibri", Font.TRUETYPE_FONT, 30);
    private SoundSystem music = new SoundSystem("/resourses/whatIsLove.wav");
    private InputHandler IH;
    private Boolean hasRightScored = false;
    private Boolean hasLeftScored = false;
    private BufferedImage image = new BufferedImage(LARGURA, ALTURA, BufferedImage.TYPE_INT_RGB);
    private Thread gameThread;

    public Game() {
        p1Score = p2Score = maxScore;
        frame = new JFrame();
        setMinimumSize(gameSize);
        setPreferredSize(gameSize);
        setMaximumSize(gameSize);

        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle(TITTLE);

        player = new PlayerPaddle(10, (getHeight() / 2) - 40);
        ai = new AIPaddle(getWidth() - 25, (getHeight() / 2) - 40);
        ball = new Ball(getWidth() / 2, (getHeight() / 2) - 40);

        IH = new InputHandler(this);
        frame.addKeyListener(IH);
        music.loopSom();

    }

    public void gameloop() {

        long lastLoopTime = System.nanoTime();
        new DifficultChanger(player, ai, ball);

        while (gameRunning) {

            try {
                long now = System.nanoTime();
                long updateLength = now - lastLoopTime;
                lastLoopTime = now;
                double delta = updateLength / ((double) OPTIMAL_TIME);

                delta = (delta == 0 ? delta + 0.2 : delta) * baseSpeed;

                tick(delta);
                render();

                Thread.sleep(((lastLoopTime - System.nanoTime()) + OPTIMAL_TIME) / 1000000);
            }
            catch (Throwable e) {
                e.getMessage();
            }

        }
    }

    @Override
    public void run() {

        gameloop();

    }

    public synchronized void start() {
        gameRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public synchronized void stop() throws Throwable {
        gameRunning = false;
        JOptionPane.showMessageDialog(frame, getGanhador() + " Ganhou!");
        music.pararSom();
        this.frame.dispose();
        this.image.flush();
        //System.exit(0);
        new MainMenu();
    }

    public void tick(double deltaTime) throws Throwable {

        player.tick(this, deltaTime);
        ai.tick(this, deltaTime);
        ball.tick(this, deltaTime);
        scoreHandler();
        endGame();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setFont(font);
        g.setColor(Color.cyan);
        g.drawString("Player 1: " + p1Score, 25, 50);
        g.setColor(Color.pink);
        g.drawString("Player 2: " + p2Score, getWidth() - 150, 50);

        if (scoreFlag == 1) {
            g.setColor(Color.cyan);
            g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
            bs.contentsRestored();
        }
        else if (scoreFlag == 2) {
            g.setColor(Color.pink);
            g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
            bs.contentsRestored();
        }
        else {
            g.setColor(Color.white);
            g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
            bs.contentsRestored();

        }

        player.render(g);
        ai.render(g);
        ball.render(g);

        g.dispose();
        bs.show();

    }

    private void scoreHandler() {
        if (hasLeftScored || hasRightScored) {

            if (hasLeftScored) {
                p2Score--;
                hasLeftScored = false;
            }

            if (hasRightScored) {
                p1Score--;
                hasRightScored = false;
            }

            if (p1Score > p2Score) {
                scoreFlag = 1;
                ball.setBallFlag(1);
            }
            else if (p2Score > p1Score) {
                scoreFlag = 2;
                ball.setBallFlag(2);
            }
            else {
                scoreFlag = 0;
                ball.setBallFlag(0);
            }

            resetGame();
        }
    }

    private void resetGame() {
        ball.setX(getWidth() / 2);
        ball.setY((getHeight() / 2) - 40);

        player.setX(10);
        player.setY((getHeight() / 2) - 40);

        ai.setX(getWidth() - 25);
        ai.setY((getHeight() / 2) - 40);

        try {
            gameThread.wait(1000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void endGame() throws Throwable {

        if ((p1Score == 0) || (p2Score == 0)) {
            if (p1Score == 0) {
                setGanhador("Player 2");
            }
            else if (p2Score == 0) {
                setGanhador("Player 1");
            }
            stop();
        }

    }

    public int getP1Score() {
        return p1Score;
    }

    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }

    public String getGanhador() {
        return ganhador;
    }

    public void setGanhador(String ganhador) {
        this.ganhador = ganhador;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public Integer getScoreFlag() {
        return scoreFlag;
    }

    public void setScoreFlag(Integer scoreFlag) {
        this.scoreFlag = scoreFlag;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Double getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(Double baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public Boolean getGameRunning() {
        return gameRunning;
    }

    public void setGameRunning(Boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public PlayerPaddle getPlayer() {
        return player;
    }

    public void setPlayer(PlayerPaddle player) {
        this.player = player;
    }

    public AIPaddle getAi() {
        return ai;
    }

    public void setAi(AIPaddle ai) {
        this.ai = ai;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public Font getFont() {
        return font;
    }

    @Override
    public void setFont(Font font) {
        this.font = font;
    }

    public SoundSystem getMusic() {
        return music;
    }

    public void setMusic(SoundSystem music) {
        this.music = music;
    }

    public InputHandler getIH() {
        return IH;
    }

    public void setIH(InputHandler iH) {
        IH = iH;
    }

    public Boolean getHasRightScored() {
        return hasRightScored;
    }

    public void setHasRightScored(Boolean hasRightScored) {
        this.hasRightScored = hasRightScored;
    }

    public Boolean getHasLeftScored() {
        return hasLeftScored;
    }

    public void setHasLeftScored(Boolean hasLefttScored) {
        this.hasLeftScored = hasLefttScored;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Thread getGameThread() {
        return gameThread;
    }

    public void setGameThread(Thread gameThread) {
        this.gameThread = gameThread;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getTARGET_FPS() {
        return TARGET_FPS;
    }

    public Long getOPTIMAL_TIME() {
        return OPTIMAL_TIME;
    }

    public Integer getLARGURA() {
        return LARGURA;
    }

    public Integer getALTURA() {
        return ALTURA;
    }

    public Dimension getGameSize() {
        return gameSize;
    }

    public String getTITTLE() {
        return TITTLE;
    }

    public void setP1Score(Integer p1Score) {
        this.p1Score = p1Score;
    }

    public void setP2Score(Integer p2Score) {
        this.p2Score = p2Score;
    }

}
