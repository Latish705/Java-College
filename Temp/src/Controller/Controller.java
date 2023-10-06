package Controller;

import Model.Model;
import View.View;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
    Model model;
    View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        view.centerInitialSetup(model.getManageCustomerData().getLinesBeingDisplayed(), model.getManageCustomerData().getHeaders().size());
        view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
//        view.centerInitialSetup(model.getManageCustomerData().getLinesBeingDisplayed(), model.getManageCustomerData().getHeaders().size());
//        view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
        addScrolling1();
//        addScrolling();
        addButtonClick();
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
    // Create an instance of your CenterPanel
//    CenterPanel centerPanel = new CenterPanel();
//
//    // Create a JScrollPane and add the CenterPanel to it
//    JScrollPane scrollPane = centerPanel.createScrollPane();
//
//// Add the JScrollPane to your JFrame or other container
//frame.add(scrollPane);

// Now, your CenterPanel is scrollable within the JScrollPane


    private void addScrolling1()
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getManageCustomerData().getFirstLineToDisplay();
                int current_last_line = model.getManageCustomerData().getLastLineToDisplay();
                int no_of_players = model.getManageCustomerData().getTable().size();
                int no_of_display_lines = model.getManageCustomerData().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getManageCustomerData().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getManageCustomerData().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getManageCustomerData().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_players-1)
                {
                    model.getManageCustomerData().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_players-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_players - no_of_display_lines)
                    {
                        new_first_line = no_of_players-no_of_display_lines;
                        model.getManageCustomerData().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getManageCustomerData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
            }
        });
    }
    private void addScrolling()
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getManageProductData().getFirstLineToDisplay();
                int current_last_line = model.getManageProductData().getLastLineToDisplay();
                int no_of_players = model.getManageProductData().getTable().size();
                int no_of_display_lines = model.getManageProductData().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getManageProductData().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getManageProductData().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getManageProductData().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_players-1)
                {
                    model.getManageProductData().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_players-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_players - no_of_display_lines)
                    {
                        new_first_line = no_of_players-no_of_display_lines;
                        model.getManageProductData().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getManageProductData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(model.getManageProductData().getLines(model.getManageProductData().getFirstLineToDisplay(), model.getManageProductData().getLastLineToDisplay()), model.getManageProductData().getHeaders());
            }
        });
    }


}