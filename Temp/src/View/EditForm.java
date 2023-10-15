package View;

import Model.Customer;
import Model.Model;
import Model.manageCustomer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditForm extends JFrame {
    private JTextField idTextField;
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
    public EditForm(Model m) {
        setTitle("Edit Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 350);
        setLocationRelativeTo(null);

        initializeComponents();
        addComponentsToFrame();
        attachActionListeners(m);
    }


    private void initializeComponents() {
        idTextField=new JTextField();
        nameTextField = new JTextField();
        emailTextField=new JTextField();
        phonetextfield=new JTextField();
        addresstextfield=new JTextField();
        citytextfiled=new JTextField();
        saveButton = new JButton("Save");
    }

    private void addComponentsToFrame() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Id:"));
        panel.add(idTextField);
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
    private void attachActionListeners(Model m) {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=idTextField.getText();
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String phone = phonetextfield.getText();
                String address = addresstextfield.getText();
                String city = citytextfiled.getText();

                // Check if 'id' is not null or empty
                String customerIdStr = idTextField.getText();

                if (!customerIdStr.isEmpty()) {
                    try {
                        Customer newCustomer=new Customer(Integer.parseInt(id),name,email,phone,address,city);
                        m.getManageCustomerData().appendToJson(newCustomer,"./Temp/src/Model/customer.json");
                        System.out.println("Customer Successfully Appended with data: " + name + " " + email + " " + phone + " " + address + " " + city);
                    } catch (NumberFormatException ex) {
                        // Handle the case where customerIdStr is not a valid integer
                        JOptionPane.showMessageDialog(EditForm.this, "Invalid Customer ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Display an error message
                    JOptionPane.showMessageDialog(EditForm.this, "Customer ID is required.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Close the edit form
                dispose();
            }
        });
    }


    private void attachActionListeners(String id) {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the save button click event
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String phone = phonetextfield.getText();
                String Address = addresstextfield.getText();
                String City = citytextfiled.getText();

                // Check if 'id' is not null or empty
                if (id != null && !id.isEmpty()) {
                    int customerId = Integer.parseInt(id);

                    // Create an ObjectNode with the updated data
                    ObjectNode updatedCustomerNode = createCustomerObjectNode(customerId, name, email, phone, Address, City);

                    // Get the instance of manageCustomer and call the overwriteJsonRow function
                    manageCustomer customerManager = new manageCustomer();
                    customerManager.overwriteJsonRow(id, updatedCustomerNode);

                    System.out.println("Customer Successfully Updated with data: " + name + " " + email + " " + phone + " " + Address + " " + City);
                } else {
                    // Display an error message
                    JOptionPane.showMessageDialog(EditForm.this, "Customer ID is required.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Close the edit form
                dispose();
            }
        });
    }

    // Create an ObjectNode with customer data
    private ObjectNode createCustomerObjectNode(int customerId, String name, String email, String phone, String address, String city) {
        ObjectMapper mapper = new ObjectMapper();
        String[] splits=name.split(" ");
        String firstname=splits[0];
        String lastname=splits[1];
        ObjectNode customerNode = mapper.createObjectNode();
        customerNode.put("customer_id", customerId);
        customerNode.put("first_name", firstname);
        customerNode.put("last_name",lastname);
        customerNode.put("email", email);
        customerNode.put("phoneno", phone);
        customerNode.put("customer_address", address);
        customerNode.put("city", city);
        return customerNode;
    }




}
