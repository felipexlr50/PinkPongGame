package view;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class NewCheckBox extends JCheckBox {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int width = 100;
    private int height = 90;

    public NewCheckBox(int x, int y) {
        String aux = "/resourses/1.png";
        String aux2 = "/resourses/2.png";
        String aux3 = "/resourses/3.png";
        String aux4 = "/resourses/4.png";

        ImageIcon switchOffN = new ImageIcon(getClass().getResource(aux));
        ImageIcon switchOffM = new ImageIcon(getClass().getResource(aux2));
        ImageIcon switchOnN = new ImageIcon(getClass().getResource(aux3));
        ImageIcon switchOnM = new ImageIcon(getClass().getResource(aux4));
        setBounds(x, y, width, height);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setIcon(switchOffN);
        setRolloverIcon(switchOffM);
        setSelectedIcon(switchOnN);
        setRolloverSelectedIcon(switchOnM);
        setPressedIcon(switchOnM);
    }

}
