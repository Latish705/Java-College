package View;

import javax.swing.*;
import java.awt.*;

public class InitialPanel extends JPanel {

//    private FirstButtonPanel Fbt;
    private CenterPanel cp;
    private ButtonPanel btn_p;

    public InitialPanel() {
        super();
        this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
        btn_p = new ButtonPanel();
        this.add(btn_p);
        validate();
        repaint();
        cp = new CenterPanel();
        this.add(cp);
        validate();
        repaint();
//        JFrame firstPanel=new JFrame("Main Button");
//        Fbt=new FirstButtonPanel();


    }
//    public FirstButtonPanel getFbt(){return Fbt;}
    public CenterPanel getCp() {
        return cp;
    }

    public void setCp(CenterPanel cp) {
        this.cp = cp;
    }

    public ButtonPanel getBp() {
        return btn_p;
    }


    public void setBp(ButtonPanel btn_p) {
        this.btn_p = btn_p;
    }


//    public FirstButtonPanel getFbt() {
//        return Fbt;
//    }
}
