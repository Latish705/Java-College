package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditForm extends JFrame {
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField phonetextfield;
    private JTextField addresstextfield;

    private JButton saveButton;

    public EditForm() {
        setTitle("Edit Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        initializeComponents();
        addComponentsToFrame();
        attachActionListeners();
    }

    private void initializeComponents() {
        nameTextField = new JTextField();
        emailTextField=new JTextField();
        phonetextfield=new JTextField();
        addresstextfield=new JTextField();
        saveButton = new JButton("Save");
    }

    private void addComponentsToFrame() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameTextField);
        panel.add(new JLabel("Email"));
        panel.add(emailTextField);
        panel.add(new JLabel("Phone"));
        panel.add(phonetextfield);
        panel.add(new JLabel("Address")); // Empty label for spacing
        panel.add(addresstextfield);
        panel.add(new JLabel("City"));
//        panel.add()
        panel.add(saveButton);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void attachActionListeners() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the save button click event
                String newName = nameTextField.getText();
                // Perform the save operation with the new name
                // You can add your logic here

                // Close the edit form
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EditForm editForm = new EditForm();
                editForm.setVisible(true);
            }
        });
    }
}
