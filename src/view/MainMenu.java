package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import core.Game;
import resourses.SoundSystem;

public class MainMenu extends JFrame {
    private static final long serialVersionUID = 1L;

    Botao sair;
    Botao jogar;
    Botao ajuda;
    JLabel fundo;
    SoundSystem music = new SoundSystem("/resourses/feelGood.wav");
    NewCheckBox chave;
    JLabel lbMsg, lbEasy, lbNormal, lbHard, lbMsg2;
    NewRadioButton facil;
    NewRadioButton normal;
    NewRadioButton dificil;
    public static RadioButtonHandler handler;
    ButtonGroup grupo;

    int width = 1200;
    int height = (width / 16) * 9;

    public MainMenu() {
        super("Pink Pong v1.5 2015 by Felipe M B");
        music.loopSom();

        setLayout(new BorderLayout());
        fundo = new JLabel(new ImageIcon(getClass().getResource("/resourses/pinkPong_bg.png")));
        add(fundo);
        fundo.setLayout(null);

        chave = new NewCheckBox(350, 400);
        jogar = new Botao("jogar", 100, 400);
        sair = new Botao("sair", 100, 500);
        ajuda = new Botao("comoJogar", 330, 500);
        lbMsg = new JLabel("2 jogaores?");
        lbEasy = new JLabel("Pelinha!");
        lbNormal = new JLabel("Meh!");
        lbHard = new JLabel("Não pode (C)!");
        lbMsg2 = new JLabel("Dificuldade");
        handler = new RadioButtonHandler(this);
        grupo = new ButtonGroup();

        facil = new NewRadioButton(470, 400);
        normal = new NewRadioButton(470, 450);
        dificil = new NewRadioButton(470, 500);

        lbEasy.setForeground(Color.WHITE);
        lbNormal.setForeground(Color.WHITE);
        lbHard.setForeground(Color.WHITE);
        lbMsg2.setForeground(Color.WHITE);
        lbMsg.setForeground(Color.WHITE);

        lbMsg.setBounds(360, 380, 100, 20);
        lbEasy.setBounds(530, 385, 100, 50);
        lbNormal.setBounds(530, 435, 100, 50);
        lbHard.setBounds(530, 485, 100, 50);
        lbMsg2.setBounds(500, 350, 100, 50);

        fundo.add(jogar);
        fundo.add(sair);
        fundo.add(ajuda);
        fundo.add(chave);
        fundo.add(lbMsg);
        fundo.add(facil);
        fundo.add(normal);
        fundo.add(dificil);
        fundo.add(lbEasy);
        fundo.add(lbNormal);
        fundo.add(lbHard);
        fundo.add(lbMsg2);

        grupo.add(facil);
        grupo.add(normal);
        grupo.add(dificil);

        facil.addItemListener(handler);
        normal.addItemListener(handler);
        dificil.addItemListener(handler);

        setResizable(false);

        setSize(width, height);
        setVisible(true);

        addActions();

    }

    private void addActions() {
        jogar.addActionListener(e -> {
            music.pararSom();
            dispose();
            Game game = new Game();
            game.getAi().setTwoPlayer(chave.isSelected() ? true : false);
            game.start();
        });

        sair.addActionListener(e -> System.exit(0));

        ajuda.addActionListener(e -> JOptionPane.showMessageDialog(rootPane, "1 jogador:\n Use 'w' e 's' para se mover.\n\n2 jogadores:\n"
                + "Use 'w' e 's' para o jogador 1 e as setas cima e baixo para o jogador 2.\n\nJogo Termina quando alguém fica com ZERO pontos"
                + "\n\nESC volta ao Menu Principal"));

    }

}
