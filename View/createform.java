package View;

import Model.Customer;
import Model.manage_Customer;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class createform extends JFrame {
    private JTextField idTextField;

    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField phonetextfield;
    private JTextField addresstextfield;
    private JTextField citytextfiled;

    private JButton saveButton;
    private manage_Customer e;
    private Model model;
    private Customer c;
    ArrayList<Customer> Customers = new ArrayList<Customer>();


    public createform(Model m) {
        setTitle("Create Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 500);
        setLocationRelativeTo(null);

        initializeComponents();
        addComponentsToFrame();
        attachActionListeners(m);
    }


    private void initializeComponents() {
        idTextField = new JTextField();
        nameTextField = new JTextField();
        emailTextField = new JTextField();
        phonetextfield = new JTextField();
        addresstextfield = new JTextField();
        citytextfiled = new JTextField();
        saveButton = new JButton("Save");
    }

    private void addComponentsToFrame() {
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("ID:"));
        panel.add(idTextField);
        nameTextField.setSize(20, 10);

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

    private void attachActionListeners(Model m) {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the save button click event
                String id = idTextField.getText();

                String name = nameTextField.getText();
                String[] names = name.split(" ");
                String email = emailTextField.getText();
                String phone = phonetextfield.getText();
                String Address = addresstextfield.getText();
                //String nat = citytextfiled.getText();

                //String idText = id; // Ensure id is not null
                        // Continue with creating the new customer
                        Customer newCustomer = new Customer(Integer.parseInt(id), name, Address, Long.parseLong(phone), email);
                        //model.Data(newCustomer);
                        m.getManageStudentData().create(newCustomer);

                        System.out.println("Customer Successfully Created and edit with data" + newCustomer.getfirst_name() + newCustomer.getlast_ame() + newCustomer.getEmail() + newCustomer.getMobileNo() + newCustomer.getAddress());


                // Close the edit form
                dispose();
            }
        });


    }

}