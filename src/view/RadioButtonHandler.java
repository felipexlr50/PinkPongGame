package view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioButtonHandler implements ItemListener {

    MainMenu menu;
    boolean easyFlag, normalFlag, hardFlag;

    public RadioButtonHandler(MainMenu menu) {
        this.menu = menu;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (menu.facil.isSelected()) {
            setEasyFlag(true);
            setNormalFlag(false);
            setHardFlag(false);
            System.out.println("Facil");

        }

        else if (menu.normal.isSelected()) {
            setEasyFlag(false);
            setNormalFlag(true);
            setHardFlag(false);
            System.out.println("normal");
        }

        else if (menu.dificil.isSelected()) {
            setEasyFlag(false);
            setNormalFlag(false);
            setHardFlag(true);
            System.out.println("dificil");
        }

    }

    public boolean isEasyFlag() {
        return easyFlag;
    }

    public void setEasyFlag(boolean easyFlag) {
        this.easyFlag = easyFlag;
    }

    public boolean isNormalFlag() {
        return normalFlag;
    }

    public void setNormalFlag(boolean normalFlag) {
        this.normalFlag = normalFlag;
    }

    public boolean isHardFlag() {
        return hardFlag;
    }

    public void setHardFlag(boolean hardFlag) {
        this.hardFlag = hardFlag;
    }

}
