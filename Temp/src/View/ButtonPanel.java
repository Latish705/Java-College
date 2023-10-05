package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonPanel  extends JPanel {
    JButton btn_student = new JButton();
    JButton btn_course = new JButton();

    public ButtonPanel(){
        btn_student.setBackground(Color.cyan);
        btn_student.setPreferredSize(new Dimension(80,25));
        btn_student.setText("Student");
        this.add(btn_student);
        validate();
        repaint();
        btn_course.setBackground(Color.cyan);
        btn_course.setPreferredSize(new Dimension(80,25));
        btn_course.setText("Course");
        this.add(btn_course);
        validate();
        repaint();
    }

    public JButton getBtn_student() {
        return btn_student;
    }

    public JButton getBtn_course() {
        return btn_course;
    }
}
