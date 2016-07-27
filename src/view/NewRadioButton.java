package view;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class NewRadioButton extends JRadioButton {


	private static final long serialVersionUID = 1L;

	String aux1 = "/resourses/1.1.png";
	String aux2 = "/resourses/2.2.png";
	String aux3 = "/resourses/3.1.png";
	String aux4 = "/resourses/4.1.png";

	private int width = 50;
	private int height = 25;

	ImageIcon switchOffN = new ImageIcon(getClass().getResource(aux1));
	ImageIcon switchOffM = new ImageIcon(getClass().getResource(aux2));
	ImageIcon switchOnN = new ImageIcon(getClass().getResource(aux3));
	ImageIcon switchOnM = new ImageIcon(getClass().getResource(aux4));

	public NewRadioButton(int x, int y) {

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
