package Controller;

import Model.Model;
import View.View;
import View.EditForm;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.swing.*;
import java.awt.event.*;

//public class Controller<EditForm> {
//    Model model;
//    View view;
//
//    public Controller(Model m, View v) {
//        model = m;
//        view = v;
//        view.centerInitialSetup(model.getManageCustomerData().getLinesBeingDisplayed(), model.getManageCustomerData().getHeaders().size());
//        view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
////        view.centerInitialSetup(model.getManageCustomerData().getLinesBeingDisplayed(), model.getManageCustomerData().getHeaders().size());
////        view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
//
//        addScrolling1();
//        // Add other event listeners and initialization as needed
//
//
//        addScrolling1();
//
//        view.getMf().getIp().getCp().getCustomerButton().get(0).addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Edit Button Clicked for Customer 0");
//                // Code to open the edit form goes here
//                openEditForm();
//            }
//
//
//        });
//
//
//
////        addScrolling();
////        addButtonClick();
//    }
//
//    public void initialize()  {
//        view.centerInitialSetup(model.getManageCustomerData().getLinesBeingDisplayed(), model.getManageCustomerData().getHeaders().size());
//        view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
//
//        // Add ActionListener for the specific customer button
//        view.getMf().getIp().getCp().getCustomerButton().get(0).addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Edit Button Clicked for Customer 0");
//                // Code to open the edit form goes here
//                openEditForm();
//            }
//        });
//
//
//
//        view.getMf().getIp().getBp().getBtn_course().addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                System.out.println("Course Pressed");
//                view.centerUpdate(model.getManageProductData().getLines(model.getManageProductData().getFirstLineToDisplay(), model.getManageProductData().getLastLineToDisplay()), model.getManageProductData().getHeaders());
//                addScrolling();
//            }
//        });
//    }
//
//
////    private void addEditButtonClick() {
////
////        view.getMf().getIp().getCp().get().addMouseListener(new MouseAdapter() {
////            public void mousePressed(MouseEvent me) {
////                System.out.println("Student Pressed");
////
////                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
////                addScrolling1();
////            }
////        });
////
////        view.getMf().getIp().getBp().getBtn_course().addMouseListener(new MouseAdapter() {
////            public void mousePressed(MouseEvent me) {
////                System.out.println("Course Pressed");
////                view.centerUpdate(model.getManageProductData().getLines(model.getManageProductData().getFirstLineToDisplay(), model.getManageProductData().getLastLineToDisplay()), model.getManageProductData().getHeaders());
////                addScrolling();
////            }
////        });
////    }
//
//
////    private void addScrolling1() {
////
////    }
//
////    private void addScrolling1()
////    {
////        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
////            @Override
////            public void mouseWheelMoved(MouseWheelEvent e) {
////                int units = e.getUnitsToScroll();
////                System.out.println(units);
////                int current_first_line = model.getManageCustomerData().getFirstLineToDisplay();
////                int current_last_line = model.getManageCustomerData().getLastLineToDisplay();
////                int no_of_players = model.getManageCustomerData().getTable().size();
////                int no_of_display_lines = model.getManageCustomerData().getLinesBeingDisplayed();
////                if(units <= 0 && current_first_line == 0)
////                {
////                    model.getManageCustomerData().setFirstLineToDisplay(0);
////                }
////                else if(units <= 0 && current_first_line > 0)
////                {
////                    int new_first_line = current_first_line + units;
////                    if(new_first_line <= 0)
////                    {
////                        model.getManageCustomerData().setFirstLineToDisplay(0);
////                    }
////                    else
////                    {
////                        model.getManageCustomerData().setFirstLineToDisplay(new_first_line);
////                    }
////                }
////                else if(units > 0 && current_last_line == no_of_players-1)
////                {
////                    model.getManageCustomerData().setFirstLineToDisplay(current_first_line);
////                }
////                else if (units > 0 && current_last_line < no_of_players-1)
////                {
////                    int new_first_line = current_first_line + units;
////                    if(new_first_line > no_of_players - no_of_display_lines)
////                    {
////                        new_first_line = no_of_players-no_of_display_lines;
////                        model.getManageCustomerData().setFirstLineToDisplay(new_first_line);
////                    }
////                    else
////                    {
////                        model.getManageCustomerData().setFirstLineToDisplay(new_first_line);
////                    }
////                }
////
////                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
////            }
////        });
////    }
////    private void addScrolling()
////    {
////
////    }
//
//
////    public void initialize() {
////    }
//}
//
//    private void openEditForm() {
//        // Create and display the edit form
//        EditForm editForm = new EditForm();
//        editForm.setVisible(true);
//    }
//
//    private void addScrolling() {

//    }
//
//    private void addScrolling1() {
//
//    }


public class Controller {
    Model model;
    View view;
    private String  passId;

    public Controller(Model m, View v) {
        model = m;
        view = v;
//        view.centerInitialSetup(model.getManageCustomerData().getLinesBeingDisplayed(), model.getManageCustomerData().getHeaders().size());
//        view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());

        addScrolling1();
        addButtonClick();
        view.centerInitialSetup(model.getManageCustomerData().getLinesBeingDisplayed(), model.getManageCustomerData().getHeaders().size());

        getId();
//        int i;
        for (int i = 0; i < 25; i++) {
            final int customerNumber = (i * 8)+6; // Calculate the customer number
            view.getMf().getIp().getCp().getCustomerButton().get(customerNumber).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Edit Button Clicked for Customer " + customerNumber);
                    // Code to open the edit form goes here
                    openEditForm(passId);

                }
            });
        }
        for (int i = 0; i < 25; i++) {
            final int customerNumber = (i * 8)+7; // Calculate the customer number
            view.getMf().getIp().getCp().getCustomerButton().get(customerNumber).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Delete Button Clicked for Customer " + customerNumber);
                    // Code to open the edit form goes here
//                    getIdToDelete();

//                    view.centerInitialSetup(model.getManageCustomerData().getLinesBeingDisplayed(), model.getManageCustomerData().getHeaders().size());
//                    view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());

                }
            });
//            view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());

        }
//        view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());


        // Add other listeners and initializations as needed
    }

    private void addButtonClick()
    {

        view.getMf().getIp().getBp().getBtn_student().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Student Pressed");
                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
                addScrolling1();
            }
        });

        view.getMf().getIp().getBp().getBtn_course().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Course Pressed");
                view.centerUpdate(model.getManageProductData().getLines(model.getManageProductData().getFirstLineToDisplay(), model.getManageProductData().getLastLineToDisplay()), model.getManageProductData().getHeaders());
                addScrolling();
            }
        });
    }

    private void getId() {
        for (int i = 1; i < 171; i++) {
            final int customerNumber = (i + 9) + 3;
            JButton customerButton = view.getMf().getIp().getCp().getCustomerButton().get(customerNumber);

            // Add an ActionListener to the button
            customerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Get the text or data associated with the button
                    String buttonText = customerButton.getText();
                    System.out.println("Delete Button Clicked for Customer " + customerNumber);

                    // Code to delete the data from the model
                    model.getManageCustomerData().DeleteSpecificNode(buttonText);
                    model.getManageCustomerData().readJsonFile("./Temp/src/Model/customer.json");
//                    view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
                    Model model1=new Model();
                    view.centerUpdate(model1.getManageCustomerData().getLines(model1.getManageCustomerData().getFirstLineToDisplay(), model1.getManageCustomerData().getLastLineToDisplay()), model1.getManageCustomerData().getHeaders());
                    passId=String.valueOf(customerNumber);
                    // Update the GUI to reflect the changes
                    view.refreshCustomerData(model);
                }
            });
        }
    }




    private void openEditForm(String passId) {
        JFrame fromFrame=new JFrame("Edit Form");
        fromFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fromFrame.setSize(800, 500);
        EditForm editForm = new EditForm(passId);
        editForm.setVisible(true);
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

    public void initialize() {
        // Add any additional initialization code here
    }
}
