package View;

import javax.swing.*;
import java.awt.*;
import java.time.temporal.JulianFields;
import java.util.ArrayList;

public class ButtonPanel  extends JPanel {
    JButton btn_student = new JButton();
    JButton btn_course = new JButton();
    JButton edit_button=new JButton();

    JButton delete_button=new JButton();
    JButton Create_button=new JButton();

    public ButtonPanel(){
        btn_student.setBackground(Color.cyan);
        btn_student.setPreferredSize(new Dimension(120,25));
        btn_student.setText("Customer");
        this.add(btn_student);
        validate();
        repaint();
        btn_course.setBackground(Color.cyan);
        btn_course.setPreferredSize(new Dimension(120,25));
        btn_course.setText("Product");
        this.add(btn_course);
        validate();
        repaint();
        Create_button.setBackground(Color.cyan);
        Create_button.setPreferredSize(new Dimension(120,25));
        Create_button.setText("Create");
        this.add(Create_button);
        validate();
        repaint();
        edit_button.setBackground(Color.cyan);
        edit_button.setPreferredSize(new Dimension(120,25));
        edit_button.setText("Edit");
        this.add(edit_button);
        validate();
        repaint();
        delete_button.setBackground(Color.cyan);
        delete_button.setPreferredSize(new Dimension(120,25));
        delete_button.setText("Delete");
        this.add(delete_button);
        validate();
        repaint();

    }

    public JButton getBtn_student() {
        return btn_student;
    }

    public JButton getBtn_course() {
        return btn_course;
    }
    public JButton getEdit_button(){return edit_button;}
    public JButton getDelete_button(){return delete_button;}
    public JButton getCreate_button(){return Create_button;}
}
