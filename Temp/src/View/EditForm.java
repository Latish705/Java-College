package View;

import Model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditForm extends JFrame {
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField phonetextfield;
    private JTextField addresstextfield;
    private JTextField citytextfiled;

    private JButton saveButton;

    public EditForm(String  id) {
        setTitle("Edit Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 350);
        setLocationRelativeTo(null);

        initializeComponents();
        addComponentsToFrame();
        attachActionListeners(id);
    }


    private void initializeComponents() {
        nameTextField = new JTextField();
        emailTextField=new JTextField();
        phonetextfield=new JTextField();
        addresstextfield=new JTextField();
        citytextfiled=new JTextField();
        saveButton = new JButton("Save");
    }

    private void addComponentsToFrame() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameTextField);
        nameTextField.setSize(20,10);
        panel.add(new JLabel("Email"));
        panel.add(emailTextField);
        emailTextField.setSize(20,10);

        panel.add(new JLabel("Phone"));
        panel.add(phonetextfield);
        phonetextfield.setSize(20,10);

        panel.add(new JLabel("Address")); // Empty label for spacing
        panel.add(addresstextfield);
        addresstextfield.setSize(20,10);

        panel.add(new JLabel("City"));
        panel.add(citytextfiled);
//        panel.add()
        panel.add(saveButton);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void attachActionListeners(String id) {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the save button click event
                String name = nameTextField.getText();
                String[] names = name.split(" ");
                String email = emailTextField.getText();
                String phone = phonetextfield.getText();
                String Address = addresstextfield.getText();
                String City = citytextfiled.getText();

                String idText = id; // Ensure id is not null
                try {
                    if (idText != null && !idText.isEmpty()) {
                        int customerId = Integer.parseInt(idText);
                        // Continue with creating the new customer
                        Customer newCustomer = new Customer(customerId, name, email, phone, Address, City);
                        System.out.println("Customer Successfully Created and edit with data"+newCustomer.getFirstname()+newCustomer.getLastname()+newCustomer.getEmail()+newCustomer.getPhoneNo()+newCustomer.getAddress()+newCustomer.getCity());
                    } else {
                        // Display an error message
                        JOptionPane.showMessageDialog(EditForm.this, "Customer ID is required.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    // Handle the error when id is not a valid integer
                    JOptionPane.showMessageDialog(EditForm.this, "Invalid Customer ID. Please provide a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Close the edit form
                dispose();
            }
        });
    }



}
