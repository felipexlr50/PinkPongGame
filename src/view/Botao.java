package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botao extends JButton {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int width = 124;
    private int height = 44;

    public Botao(String botao, int x, int y) {
        String aux = "/resourses/" + botao + "_normal.png";
        String aux2 = "/resourses/" + botao + "_mouse.png";
        String aux3 = "/resourses/" + botao + "_click.png";

        ImageIcon iNormal = new ImageIcon(getClass().getResource(aux));
        ImageIcon iMouse = new ImageIcon(getClass().getResource(aux2));
        ImageIcon iClick = new ImageIcon(getClass().getResource(aux3));
        setBounds(x, y, width, height);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setIcon(iNormal);
        setRolloverIcon(iMouse);
        setPressedIcon(iClick);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

}
