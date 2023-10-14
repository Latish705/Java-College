package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonPanel  extends JPanel {
    JButton btn_customer = new JButton();
    JButton btn_food = new JButton();
    JButton btn_create = new JButton();

    JButton update = new JButton();

    public ButtonPanel(){
        btn_customer.setBackground(Color.cyan);
        btn_customer.setPreferredSize(new Dimension(80,25));
        btn_customer.setText("Customer");
        this.add(btn_customer);
        validate();
        repaint();
        btn_food.setBackground(Color.cyan);
        btn_food.setPreferredSize(new Dimension(80,25));
        btn_food.setText("Food Item");
        this.add(btn_food);
        validate();
        repaint();
        btn_create.setBackground(Color.cyan);
        btn_create.setPreferredSize(new Dimension(80,25));
        btn_create.setText("Create");
        this.add(btn_create);
        validate();
        repaint();
    }

    public JButton getBtn_student() {
        return btn_customer;
    }

    public JButton getBtn_course() {
        return btn_food;
    }
    public JButton getBtn_create() {
        return btn_create;
    }
    public JButton getUpdate() {
        return update;
    }



}
