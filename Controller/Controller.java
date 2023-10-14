package Controller;

import Model.Model;
import View.View;
import javax.swing.*;
import java.awt.event.*;


import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import Model.Customer;
import Model.Food_item;
import Model.manage_Customer;
import Model.Manage_food_items;
import View.EditForm;
import View.createform;

public class Controller {
    Model model;
    View view;
    String del_id;

    String what_clicked = "";
    //Customer c1;
//    ArrayList<Customer> c1 = new ArrayList<Customer>();
//
//    c1=manage_Customer.tempcust(c1);
    Manage_food_items f1;
    ArrayList<Food_item> f2 = new ArrayList<>();
    //  f2=f1.tempfood();
    ArrayList<ArrayList<String>> data=new ArrayList<>();
    ArrayList<String> head =new ArrayList<>();


    public Controller(Model m, View v) {
        model = m;
        view = v;
        //view.centerInitialSetup(model.getManageFoodData().getLinesBeingDisplayed(), model.getManageFoodData().getHeaders().size());
        //view.centerUpdate(model.getManageStudentData().getLines(model.getManageStudentData().getFirstLineToDisplay(), model.getManageStudentData().getLastLineToDisplay()), model.getManageStudentData().getHeaders());
        addButtonClick();
        addScrolling();

      //  id();
      //  addfoodScrolling();
//        int i;
//        for(i=1;i<25;i++)
//        {
//            view.getMf().getIp().getCp().getPlayerButtons().get(i+7).addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    System.out.println("Edit Button Clicked for Customer 0");
//                    // Code to open the edit form goes here
//                    openEditForm();
//                }
//            });
//        }


    }

    private void addButtonClick()
    {
        view.getMf().getIp().getBp().getBtn_student().addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent me) {

              //  data=model.getManageStudentData().getLines(model.getManageStudentData().getFirstLineToDisplay(), model.getManageStudentData().getLastLineToDisplay());
                //System.out.println(data.size());
                //head=model.getManageStudentData().getHeaders();
                System.out.println("Student Pressed");
                what_clicked = "Student";
                System.out.println(what_clicked);
                view.centerInitialSetup(model.getManageStudentData().getLinesBeingDisplayed(), model.getManageStudentData().getHeaders().size());

                view.centerUpdate(model.getManageStudentData().getLines(model.getManageStudentData().getFirstLineToDisplay(), model.getManageStudentData().getLastLineToDisplay()), model.getManageStudentData().getHeaders());
                int i=0;
                int b=0;
                int c=0;
                int d=0;
//                id();
//                up();
                for (int j = 0; j < 2000; j++) {
                    view.getMf().getIp().getCp().getPlayerButtons().get(d).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton clickedButton = (JButton) e.getSource();
                            String buttonText = clickedButton.getText();
                            del_id=buttonText;
                            System.out.println("Text inside the button: " + buttonText);
                        }
                    });
                    d = d + 9;
                    view.getMf().getIp().getCp().getPlayerButtons().get(b+7).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Code to open the edit form goes here
                            openEditForm(del_id);
                        }
                    });
                    b=b+9;
                    view.getMf().getIp().getCp().getPlayerButtons().get(c+8).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // System.out.println("Edit Button Clicked for Customer 0");
                            // Code to open the edit form goes here
                            model.getManageStudentData().delete(del_id);
                        }
                    });
                    c=c+9;

                }


//                for(int k = 0; k < 900; k++)
//                {
//                    view.getMf().getIp().getCp().getPlayerButtons().get(b+7).addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            // Code to open the edit form goes here
//                            openEditForm();
//                        }
//                    });
//                    b=b+9;
//                }
//                for(int l = 0; l < 900; l++)
//                {
//                    view.getMf().getIp().getCp().getPlayerButtons().get(c+8).addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                           // System.out.println("Edit Button Clicked for Customer 0");
//                            // Code to open the edit form goes here
//                            model.getManageStudentData().delete(del_id);
//                        }
//                    });
//                    c=c+9;
//                    view.centerInitialSetup(model.getManageStudentData().getLinesBeingDisplayed(), model.getManageStudentData().getHeaders().size());
//
//                    view.centerUpdate(model.getManageStudentData().getLines(model.getManageStudentData().getFirstLineToDisplay(), model.getManageStudentData().getLastLineToDisplay()), model.getManageStudentData().getHeaders());
//                }
            }

        });

        view.getMf().getIp().getBp().getBtn_course().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
             //   data=model.getManagefoodData().getLines(model.getManagefoodData().getFirstLineToDisplay(), model.getManagefoodData().getLastLineToDisplay());
                //head=model.getManagefoodData().getfoodHeaders();
                //System.out.println("Course Pressed");
                what_clicked = "Food";
                System.out.println(what_clicked);

                view.centerInitialSetup(model.getManagefoodData().getLinesBeingDisplayed(), model.getManagefoodData().getfoodHeaders().size());
//                view.clear();
                view.centerUpdate(model.getManagefoodData().getLines(model.getManagefoodData().getFirstLineToDisplay(), model.getManagefoodData().getLastLineToDisplay()), model.getManagefoodData().getfoodHeaders());


            }

        });

        view.getMf().getIp().getBp().getBtn_create().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                //   data=model.getManagefoodData().getLines(model.getManagefoodData().getFirstLineToDisplay(), model.getManagefoodData().getLastLineToDisplay());
                //head=model.getManagefoodData().getfoodHeaders();
                //System.out.println("Course Pressed");
                what_clicked = "Student";
                System.out.println(what_clicked);
                opencreateform();

                view.centerInitialSetup(model.getManageStudentData().getLinesBeingDisplayed(), model.getManageStudentData().getHeaders().size());

                view.centerUpdate(model.getManageStudentData().getLines(model.getManageStudentData().getFirstLineToDisplay(), model.getManageStudentData().getLastLineToDisplay()), model.getManageStudentData().getHeaders());
                //addScrolling();

            }

        });
//


    }



    private void openEditForm(String d) {
        JFrame fromFrame=new JFrame("Edit Form");
        fromFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fromFrame.setSize(800, 500);
        EditForm editForm = new EditForm(d,model);
        editForm.setVisible(true);
    }
    private void opencreateform() {
        JFrame fromFrame=new JFrame("Edit Form");
        fromFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fromFrame.setSize(800, 500);
        createform editForm = new createform(model);
        editForm.setVisible(true);
        addScrolling();
    }
    private void addScrolling()
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                if(what_clicked == "Student")
                {
                    int current_first_line = model.getManageStudentData().getFirstLineToDisplay();
                    int current_last_line = model.getManageStudentData().getLastLineToDisplay();
                    int no_of_players = model.getManageStudentData().getTable().size();
                    // System.out.println(data.size());
                    int no_of_display_lines = model.getManageStudentData().getLinesBeingDisplayed();
                    if(units <= 0 && current_first_line == 0)
                    {
                        model.getManageStudentData().setFirstLineToDisplay(0);
                    }
                    else if(units <= 0 && current_first_line > 0)
                    {
                        int new_first_line = current_first_line + units;
                        if(new_first_line <= 0)
                        {
                            model.getManageStudentData().setFirstLineToDisplay(0);
                        }
                        else
                        {
                            model.getManageStudentData().setFirstLineToDisplay(new_first_line);
                        }
                    }
                    else if(units > 0 && current_last_line == no_of_players-1)
                    {
                        model.getManageStudentData().setFirstLineToDisplay(current_first_line);
                    }
                    else if (units > 0 && current_last_line < no_of_players-1)
                    {
                        int new_first_line = current_first_line + units;
                        if(new_first_line > no_of_players - no_of_display_lines)
                        {
                            new_first_line = no_of_players-no_of_display_lines;
                            model.getManageStudentData().setFirstLineToDisplay(new_first_line);
                        }
                        else
                        {
                            model.getManageStudentData().setFirstLineToDisplay(new_first_line);
                        }
                    }

                    view.centerUpdate(model.getManageStudentData().getLines(model.getManageStudentData().getFirstLineToDisplay(), model.getManageStudentData().getLastLineToDisplay()), model.getManageStudentData().getHeaders());
                }
                else if(what_clicked == "Food")
                {
                    int current_first_line = model.getManagefoodData().getFirstLineToDisplay();
                    int current_last_line = model.getManagefoodData().getLastLineToDisplay();
                    int no_of_players = model.getManagefoodData().getTable().size();
                    // System.out.println(data.size());
                    int no_of_display_lines = model.getManagefoodData().getLinesBeingDisplayed();
                    if(units <= 0 && current_first_line == 0)
                    {
                        model.getManagefoodData().setFirstLineToDisplay(0);
                    }
                    else if(units <= 0 && current_first_line > 0)
                    {
                        int new_first_line = current_first_line + units;
                        if(new_first_line <= 0)
                        {
                            model.getManagefoodData().setFirstLineToDisplay(0);
                        }
                        else
                        {
                            model.getManagefoodData().setFirstLineToDisplay(new_first_line);
                        }
                    }
                    else if(units > 0 && current_last_line == no_of_players-1)
                    {
                        model.getManagefoodData().setFirstLineToDisplay(current_first_line);
                    }
                    else if (units > 0 && current_last_line < no_of_players-1)
                    {
                        int new_first_line = current_first_line + units;
                        if(new_first_line > no_of_players - no_of_display_lines)
                        {
                            new_first_line = no_of_players-no_of_display_lines;
                            model.getManagefoodData().setFirstLineToDisplay(new_first_line);
                        }
                        else
                        {
                            model.getManagefoodData().setFirstLineToDisplay(new_first_line);
                        }
                    }

                    view.centerUpdate(model.getManagefoodData().getLines(model.getManagefoodData().getFirstLineToDisplay(), model.getManagefoodData().getLastLineToDisplay()), model.getManagefoodData().getfoodHeaders());
                }

            }
        });
    }

    private void add2Scrolling()
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getManagefoodData().getFirstLineToDisplay();
                int current_last_line = model.getManageStudentData().getLastLineToDisplay();
                int no_of_players = data.size();
                // System.out.println(data.size());
                int no_of_display_lines = model.getManageStudentData().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getManageStudentData().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getManageStudentData().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getManageStudentData().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_players-1)
                {
                    model.getManageStudentData().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_players-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_players - no_of_display_lines)
                    {
                        new_first_line = no_of_players-no_of_display_lines;
                        model.getManageStudentData().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getManageStudentData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(data, head);
            }
        });
    }
    private void addScrolling(ArrayList<ArrayList<String>> data,ArrayList<String> head)
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getManageStudentData().getFirstLineToDisplay();
                int current_last_line = model.getManageStudentData().getLastLineToDisplay();
                int no_of_players =data.size();
                int no_of_display_lines = model.getManageStudentData().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getManageStudentData().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getManageStudentData().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getManageStudentData().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_players-1)
                {
                    model.getManageStudentData().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_players-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_players - no_of_display_lines)
                    {
                        new_first_line = no_of_players-no_of_display_lines;
                        model.getManageStudentData().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getManageStudentData().setFirstLineToDisplay(new_first_line);
                    }
                }
                    view.centerUpdate(data,head);
               // view.centerUpdate(model.getManageStudentData().getLines(model.getManageStudentData().getFirstLineToDisplay(), model.getManageStudentData().getLastLineToDisplay()));
            }
        });
    }
    public void id(){
        int d=0;
        for (int j = 0; j < 900; j++) {
            view.getMf().getIp().getCp().getPlayerButtons().get(d).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    String buttonText = clickedButton.getText();
                    del_id=buttonText;
                    System.out.println("Text inside the button: " + buttonText);
                }
            });
            d = d + 9;
        }
    }
    public void up(){
        int b=0;
        for(int k = 0; k < 25; k++)
        {
            view.getMf().getIp().getCp().getPlayerButtons().get(b+7).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Code to open the edit form goes here
                    openEditForm(del_id);
                }
            });
            b=b+9;
        }
    }

    public void dl(){
        int c=0;

            view.getMf().getIp().getCp().getPlayerButtons().get(c+8).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // System.out.println("Edit Button Clicked for Customer 0");
                    // Code to open the edit form goes here
                    model.getManageStudentData().delete(del_id);
                }
            });
            c=c+9;
            view.centerInitialSetup(model.getManageStudentData().getLinesBeingDisplayed(), model.getManageStudentData().getHeaders().size());

            view.centerUpdate(model.getManageStudentData().getLines(model.getManageStudentData().getFirstLineToDisplay(), model.getManageStudentData().getLastLineToDisplay()), model.getManageStudentData().getHeaders());
        }
    }


//