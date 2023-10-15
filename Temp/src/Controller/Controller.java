

//version 3
package Controller;

import Model.Model;
import View.View;
import View.EditForm;
import javax.swing.*;
import java.awt.event.*;

public class Controller{
    Model model;
    View view;

    private int passId;

    public Controller(Model m,View v){
        model=m;
        view=v;
//        view.centerInitialSetup(model.getManageCustomerData().getLinesBeingDisplayed(), model.getManageCustomerData().getHeaders().size());
//        view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
        addScrolling1();
        addButtonClick();


        //now we are writing code to select id button on which user to want to perform operation

    }
    private void getId() {
        for (int i = 1; i < 25; i++) {
            final int customerNumber = i*6;
            JButton customerButton = view.getMf().getIp().getCp().getCustomerButton().get(customerNumber);

            // Add an ActionListener to the button
            customerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("button pressed");
                    // Get the text or data associated with the button
                    String buttonText = customerButton.getText();
                    System.out.println("Selected Button is " + buttonText);

                    // Code to delete the data from the model
                    model.getManageCustomerData().readJsonFile("./Temp/src/Model/customer.json");
                    //                    view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
                    Model model1=new Model();
                    view.centerUpdate(model1.getManageCustomerData().getLines(model1.getManageCustomerData().getFirstLineToDisplay(), model1.getManageCustomerData().getLastLineToDisplay()), model1.getManageCustomerData().getHeaders());
                    passId= Integer.parseInt(buttonText);
                    // Update the GUI to reflect the changes
                    view.refreshCustomerData(model);
                }
            });
        }
    }

    private void addScrolling() {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getManageProductData().getFirstLineToDisplay();
                int current_last_line = model.getManageProductData().getLastLineToDisplay();
                int no_of_players = model.getManageProductData().getTable().size();
                int no_of_display_lines = model.getManageProductData().getLinesBeingDisplayed();
                if (units <= 0 && current_first_line == 0) {
                    model.getManageProductData().setFirstLineToDisplay(0);
                } else if (units <= 0 && current_first_line > 0) {
                    int new_first_line = current_first_line + units;
                    if (new_first_line <= 0) {
                        model.getManageProductData().setFirstLineToDisplay(0);
                    } else {
                        model.getManageProductData().setFirstLineToDisplay(new_first_line);
                    }
                } else if (units > 0 && current_last_line == no_of_players - 1) {
                    model.getManageProductData().setFirstLineToDisplay(current_first_line);
                } else if (units > 0 && current_last_line < no_of_players - 1) {
                    int new_first_line = current_first_line + units;
                    if (new_first_line > no_of_players - no_of_display_lines) {
                        new_first_line = no_of_players - no_of_display_lines;
                        model.getManageProductData().setFirstLineToDisplay(new_first_line);
                    } else {
                        model.getManageProductData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(model.getManageProductData().getLines(model.getManageProductData().getFirstLineToDisplay(), model.getManageProductData().getLastLineToDisplay()), model.getManageProductData().getHeaders());
            }
        });
    }
    private void addScrolling1() {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getManageCustomerData().getFirstLineToDisplay();
                int current_last_line = model.getManageCustomerData().getLastLineToDisplay();
                int no_of_players = model.getManageCustomerData().getTable().size();
                int no_of_display_lines = model.getManageCustomerData().getLinesBeingDisplayed();
                if (units <= 0 && current_first_line == 0) {
                    model.getManageCustomerData().setFirstLineToDisplay(0);
                } else if (units <= 0 && current_first_line > 0) {
                    int new_first_line = current_first_line + units;
                    if (new_first_line <= 0) {
                        model.getManageCustomerData().setFirstLineToDisplay(0);
                    } else {
                        model.getManageCustomerData().setFirstLineToDisplay(new_first_line);
                    }
                } else if (units > 0 && current_last_line == no_of_players - 1) {
                    model.getManageCustomerData().setFirstLineToDisplay(current_first_line);
                } else if (units > 0 && current_last_line < no_of_players - 1) {
                    int new_first_line = current_first_line + units;
                    if (new_first_line > no_of_players - no_of_display_lines) {
                        new_first_line = no_of_players - no_of_display_lines;
                        model.getManageCustomerData().setFirstLineToDisplay(new_first_line);
                    } else {
                        model.getManageCustomerData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
            }
        });

    }
    private void addButtonClick()
    {

        view.getMf().getIp().getBp().getBtn_student().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Customer Pressed");
                view.centerInitialSetup(model.getManageCustomerData().getLinesBeingDisplayed(), model.getManageCustomerData().getHeaders().size());
                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
                addScrolling1();
                getId();

            }
        });

        view.getMf().getIp().getBp().getBtn_course().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Product Pressed");
                view.centerUpdate(model.getManageProductData().getLines(model.getManageProductData().getFirstLineToDisplay(), model.getManageProductData().getLastLineToDisplay()), model.getManageProductData().getHeaders());
                addScrolling();
            }
        });
        view.getMf().getIp().getBp().getCreate_button().addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                System.out.println("Create ");
                getId();
                openEditForm(model);
                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
                addScrolling1();
            }
    });
        view.getMf().getIp().getBp().getEdit_button().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Edit Pressed");
                getId();
                openEditForm(String.valueOf(passId));
                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
                addScrolling1();
            }
        });
        view.getMf().getIp().getBp().getDelete_button().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Delete Pressed");
//                getId();
                model.getManageCustomerData().DeleteSpecificNode(String.valueOf(passId));
                model.getManageCustomerData().refreshDataFromJsonFile("./Temp/src/Model/customer.json");
                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
                model.getManageCustomerData().refreshDataFromJsonFile("./Temp/src/Model/customer.json");
                model.getManageCustomerData().writeJsonFile(model.getManageCustomerData().readJsonFile("./Temp/src/Model/customer.json"));
                addScrolling1();

            }
        });

    }
    private void openEditForm(String passId) {
        JFrame fromFrame=new JFrame("Edit Form");
        fromFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fromFrame.setSize(800, 500);
        EditForm editForm = new EditForm(passId);
        editForm.setVisible(true);
    }
    private void openEditForm(Model m) {
        JFrame fromFrame=new JFrame("Edit Form");
        fromFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fromFrame.setSize(800, 500);
        EditForm editForm = new EditForm(m);
        editForm.setVisible(true);
    }





}
