package View;

import Model.Customer;
import Model.manage_Customer;
import Model.Model;
import Model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditForm extends JFrame {
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField phonetextfield;
    private JTextField addresstextfield;
    private JTextField citytextfiled;
    private JTextField product_name;
    private JTextField product_brand;
    private JTextField price;
    private JTextField rating;
    private JTextField quantity;

    private JButton saveButton;
    private manage_Customer e;
    private Model model;
    private Customer c;
    ArrayList<Customer> Customers = new ArrayList<Customer>();

//    public EditForm(String id,Model m) {
//        setTitle("Edit Form");
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setSize(1000, 500);
//        setLocationRelativeTo(null);
//
//        initializeComponents();
//        addComponentsToFrame();
//        attachActionListeners(id,m);
//    }

    public EditForm(String id, Model m, Product p) {
        setTitle("Edit Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);

        ProductinitializeComponents();
        ProductaddComponentsToFrame();
        ProductattachActionListeners(id,m);
    }
    public EditForm(String id, Model m) {
        setTitle("Edit Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);

        initializeComponents();
        addComponentsToFrame();
        attachActionListeners(id,m);
    }


    private void initializeComponents() {
        nameTextField = new JTextField();
        emailTextField = new JTextField();
        phonetextfield = new JTextField();
        addresstextfield = new JTextField();
        citytextfiled = new JTextField();
        saveButton = new JButton("Save");
    }
    private void ProductinitializeComponents() {
        nameTextField = new JTextField();
        emailTextField = new JTextField();
        phonetextfield = new JTextField();
        addresstextfield = new JTextField();
        citytextfiled = new JTextField();
        saveButton = new JButton("Save");
    }

    private void ProductaddComponentsToFrame() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameTextField);
        nameTextField.setSize(20, 10);
        panel.add(new JLabel("Email"));
        panel.add(emailTextField);
        emailTextField.setSize(20, 10);

        panel.add(new JLabel("Phone"));
        panel.add(phonetextfield);
        phonetextfield.setSize(20, 10);

        panel.add(new JLabel("Address")); // Empty label for spacing
        panel.add(addresstextfield);
        addresstextfield.setSize(20, 10);

//        panel.add(new JLabel("Nationality"));
//        panel.add(citytextfiled);
//        panel.add()
        panel.add(saveButton);

        getContentPane().add(panel, BorderLayout.CENTER);
    }
    private void addComponentsToFrame() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameTextField);
        nameTextField.setSize(20, 10);
        panel.add(new JLabel("Email"));
        panel.add(emailTextField);
        emailTextField.setSize(20, 10);

        panel.add(new JLabel("Phone"));
        panel.add(phonetextfield);
        phonetextfield.setSize(20, 10);

        panel.add(new JLabel("Address")); // Empty label for spacing
        panel.add(addresstextfield);
        addresstextfield.setSize(20, 10);

//        panel.add(new JLabel("Nationality"));
//        panel.add(citytextfiled);
//        panel.add()
        panel.add(saveButton);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void ProductattachActionListeners(String id,Model m) {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the save button click event
                String name = nameTextField.getText();
                String[] names = name.split(" ");
                String email = emailTextField.getText();
                String phone = phonetextfield.getText();
                String Address = addresstextfield.getText();
                //String nat = citytextfiled.getText();

                String idText = id; // Ensure id is not null
                try {
                    if (idText != null && !idText.isEmpty()) {
                        int customerId = Integer.parseInt(idText);
                        // Continue with creating the new customer
                        Customer newCustomer = new Customer(customerId, name, Address, Long.parseLong(phone), email);
                        //model.Data(newCustomer);
                        m.getManageStudentData().update(newCustomer);

                        System.out.println("Customer Successfully Created and edit with data" + newCustomer.getfirst_name() + newCustomer.getlast_ame() + newCustomer.getEmail() + newCustomer.getMobileNo() + newCustomer.getAddress());
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
    private void attachActionListeners(String id,Model m) {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the save button click event
                String name = nameTextField.getText();
                String[] names = name.split(" ");
                String email = emailTextField.getText();
                String phone = phonetextfield.getText();
                String Address = addresstextfield.getText();
                 //String nat = citytextfiled.getText();

                String idText = id; // Ensure id is not null
                try {
                    if (idText != null && !idText.isEmpty()) {
                        int customerId = Integer.parseInt(idText);
                        // Continue with creating the new customer
                        Customer newCustomer = new Customer(customerId, name, Address, Long.parseLong(phone), email);
                        //model.Data(newCustomer);
                        m.getManageStudentData().update(newCustomer);

                        System.out.println("Customer Successfully Created and edit with data" + newCustomer.getfirst_name() + newCustomer.getlast_ame() + newCustomer.getEmail() + newCustomer.getMobileNo() + newCustomer.getAddress());
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