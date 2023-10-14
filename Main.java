import Model.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/*
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int currentCustomerCount = 0;
        int currentfood_itemCount = 0;
        int currentOrdersCount = 0;
        Scanner scanner = new Scanner(System.in);
        Customer[] cust_array;
        cust_array = new Customer[100];
        Food_item[] food_items_array;
        food_items_array = new Food_item[20];
        Orders[] orders_array;
        orders_array = new Orders[200];
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.MONTH, 11);
        cal1.set(Calendar.DATE, 5);
        cal1.set(Calendar.YEAR, 1996);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        //System.out.println("hi");
        manage_Customer mgc = new manage_Customer();
        ArrayList<Food_item> food_items = new ArrayList<Food_item>();
        //System.out.println("hi");
        Manage_food_items mgf = new Manage_food_items();
        food_items = mgf.readJsonFile("C:/Users/DELL/Downloads/teamp/Temp/src/Model/food_item.json");

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add a new Customer");
            System.out.println("2. Display a Customer");
            System.out.println("3. Add a new Food_item");
            System.out.println("4. Display a Food_item");
            System.out.println("5. Add an Order");
            System.out.println("6. Display all Orders");
            System.out.println("7. Add food item specification");
            System.out.println("8. Remove a specification");
            System.out.println("9. Display all spcifications");
            System.out.println("10. Update a customer");
            System.out.println("11. Delete a customer");
            System.out.println("12. Display all customers");
            System.out.println("13. Update a food item");
            System.out.println("14. Delete a food item");
            System.out.println("15. Display all food items");
            System.out.println("20. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            //scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    if (currentCustomerCount < cust_array.length)
                    {

                        scanner.nextLine();
                        System.out.print("\nEnter Customer Name: ");
                        String name = scanner.nextLine();


                        System.out.print("Enter Mobile No: ");
                        long mobile_no = scanner.nextLong();

                        System.out.print("Enter Email Id: ");
                        String email = scanner.next();

                        System.out.print("Enter Address: ");
                        String address = scanner.next();


                        //System.out.print("Do you wish for a Customer Id in sequence or random (Type S for Sequence or Type R for Random): ");
                        //String seq_ran = scanner.next();

                        int custId = currentCustomerCount + 1;

                        // if (seq_ran.equals("S")) {
                            System.out.println("id Chosen");
                            cust_array[currentCustomerCount] = new Customer(custId, name, address, mobile_no, email);

                        // } else if (seq_ran.equals("R")) {
                        //    System.out.println("Random Chosen");
                        //    cust_array[currentCustomerCount] = new Customer(name, mobile_no, email, address);

                       // }
                        scanner.nextLine();
                        System.out.println("do you want to add nationaliy and age of customer,enter Y for yes anf N for no");
                        String option= scanner.nextLine();
                        if(option.equals("Y"))
                        {
                            System.out.println("enter nationatlity");
                            String nationality=scanner.nextLine();
                            cust_array[currentCustomerCount].set_nationality(nationality);
                            System.out.println("enter age:");
                            int age= scanner.nextInt();
                            cust_array[currentCustomerCount].set_age(age);
                        }

                        System.out.println("\n id is:"+ cust_array[currentCustomerCount].getCustomerId());
                        currentCustomerCount++;


                        System.out.println("Customer created and added to the array.");
                    } else {
                        System.out.println("Array is full. Cannot create more Customers.");
                    }
                    break;
                case 2:

                    System.out.print("Enter Id of the Customer to Display: ");
                    int cust_id_to_display = scanner.nextInt();
                    int j=0;
                    while(cust_array[j].getCustomerId()!=cust_id_to_display){j++;}
                    System.out.println("CustomerId : " + cust_array[j].getCustomerId());
                    System.out.println("Name : " + cust_array[j].getName());
                    System.out.println("MobileNo : " + cust_array[j].getMobileNo());
                    System.out.println("Email : " + cust_array[j].getEmail());
                    System.out.println("Address : " + cust_array[j].getAddress());
                    if(cust_array[j].get_nationality()!="NULL")
                        System.out.println("Nationality : "+ cust_array[j].get_nationality());
                    if(cust_array[j].get_age()!=0)
                        System.out.println("Age : "+ cust_array[j].get_age());
                    System.out.println("--------------------------------------------------------");
                    break;

                case 3:
                    if (currentfood_itemCount < food_items_array.length) {
                        scanner.nextLine();
                        int idf = currentfood_itemCount + 1;
                        System.out.print("Current food id is: " + idf);
                        scanner.nextLine();
                        System.out.print("\nEnter Food_item Name: ");
                        String food_item_name = scanner.nextLine();
                        System.out.println("do you want to add  ingridients, type yes or no");
                        String decision = scanner.nextLine();
                        if(decision.equals("yes"))
                        {
                            System.out.print("Enter Food_item_ingredients: ");
                            String food_item_ingredients = scanner.nextLine();
                            System.out.print("Enter food item cost: ");
                            float food_item_cost = scanner.nextFloat();
                            System.out.print("Enter Food item discount: ");
                            float food_item_discount = scanner.nextFloat();
                            // Create the object dynamically
                            food_items_array[currentfood_itemCount] = new Food_item(idf, food_item_name, food_item_ingredients, food_item_cost, food_item_discount);
                        }
                        else if(decision.equals("no"))
                        {
                            System.out.print("Enter food item cost: ");
                            float food_item_cost = scanner.nextFloat();
                            System.out.print("Enter Food item discount: ");
                            float food_item_discount = scanner.nextFloat();
                            // Create the object dynamically
                            food_items_array[currentfood_itemCount] = new Food_item(idf, food_item_name, food_item_cost, food_item_discount);

                        }
                        System.out.println("enter gst:");
                        int gst=scanner.nextInt();
                        food_items_array[currentfood_itemCount].set_gst(gst);
                        currentfood_itemCount++;

                        System.out.println("Food_item created and added to the array.");
                    } else {
                        System.out.println("Array is full. Cannot create more Food_items.");
                    }
                    break;
                case 4:

                    System.out.print("Enter Id of the Food_item to Display: ");
                    int food_item_id_to_display = scanner.nextInt();

                    System.out.println("Food_item_Id : " + food_items_array[food_item_id_to_display - 1].getId());
                    System.out.println("Food_item Name : " + food_items_array[food_item_id_to_display - 1].getFood_item_name());
                    System.out.println("Food_item_ingredients : " + food_items_array[food_item_id_to_display - 1].getFood_item_ingredients());
                    System.out.println("Food item cost : " + food_items_array[food_item_id_to_display - 1].getFood_item_cost());
                    System.out.println("Food_item_discount : " + food_items_array[food_item_id_to_display - 1].getFood_item_discount());
                    System.out.println("Food_tem_gst : "+food_items_array[food_item_id_to_display-1].get_gst());
                    System.out.println("--------------------------------------------------------");
                    break;
                case 5:
                    if (currentOrdersCount < orders_array.length) {

                        System.out.print("Enter Id of the Customer to Order: ");
                        int selected_customer_id = scanner.nextInt();
                        int i=0;
                        while(cust_array[i].getCustomerId()!=selected_customer_id){i++;}

                        System.out.print("Enter Id of the Food item to Order: ");
                        int selected_food_item_id = scanner.nextInt();
                        int f=0;
                        while(food_items_array[f].getId()!=selected_food_item_id){f++;}

                        System.out.println("Enter the date (year month day) of Order:");
                        int year = scanner.nextInt();
                        int month = scanner.nextInt();
                        int day = scanner.nextInt();

                        // Create a Calendar object and set the input date
                        Calendar enroll_date = Calendar.getInstance();
                        enroll_date.set(Calendar.YEAR, year);
                        // Calendar months are zero-based (0 - January, 1 - February, ...)

                        enroll_date.set(Calendar.MONTH, month - 1);
                        enroll_date.set(Calendar.DAY_OF_MONTH, day);
                        orders_array[currentOrdersCount] = new Orders();
                        currentOrdersCount++;
                        orders_array[currentOrdersCount - 1].orders_customer_food_item(cust_array[i],
                                food_items_array[f], enroll_date);
                        System.out.println("Order created and added to the array.");
                    } else {
                        System.out.println("Array is full. Cannot create more Orders.");
                    }
                    break;
                case 6:
                    for (int i = 0; i <= currentOrdersCount - 1; i++) {
                        orders_array[i].display_customer_orders();
                    }
                    break;
                case 7:
                    System.out.println("Enter id of food item: ");
                    int food_id= scanner.nextInt();
                    if(food_id < food_items_array.length)
                    {
                        scanner.nextLine();
                        System.out.print("Enter specifications for the Food item "+ food_items_array[food_id-1].getFood_item_name() +": ");
                        String specification = scanner.nextLine();
                        food_items_array[food_id-1].add_specifications(specification);

                    }
                    else
                    {
                        System.out.println("Enter Proper Index. Index entered does not exist");
                    }
                    break;
                case 8:
                    System.out.print("Enter Index of the food item: ");
                    int food_id1 = scanner.nextInt();
                    if(food_id1 < food_items_array.length)
                    {
                        System.out.print("Enter index of the specification to be removed for the food item "+ food_items_array[food_id1-1].getFood_item_name() +": ");
                        int specification_no = Integer.parseInt(String.valueOf(scanner.nextInt()));
                        food_items_array[food_id1-1].remove_specification(specification_no);
                    }
                    else {
                        System.out.println("Enter Proper Index. Index entered does not exist");
                    }
                    break;
                case 9:
                    System.out.println("enter index of food item: ");
                    int food_id2 = scanner.nextInt();
                    if(food_id2 < food_items_array.length)
                    {
                        System.out.println("specifications of food item "+food_items_array[food_id2-1].getFood_item_name() +"are : ");
                        food_items_array[food_id2-1].display_specificatons();
                    }
                    else {
                        System.out.println("Enter Proper Index. Index entered does not exist");
                    }
                    break;
                case 10:

                    Customer temp =new Customer();
                    customers= mgc.readJsonFile("C://Users//DELL//Documents//temp//Model//MOCK_DATA.json");
                    System.out.print("Enter customer Id to Update: ");
                    int cust_id_update = scanner.nextInt();
                    for(int i=0;i<customers.size();i++)
                    {
                        if(customers.get(i).getCustomerId()==cust_id_update)
                        {
                             temp.copy(customers.get(i));
                            System.out.println(customers.get(i).display_cust());
                        }
                    }

                    scanner.nextLine();
                    int choice_to_change;
                    do {
                        System.out.println("1. Change first Name");
                        System.out.println("2. Change middle Name");
                        System.out.println("3. Change last Name");
                        System.out.println("4. Change Address");
                        System.out.println("5. Change Mobile No");
                        System.out.println("6. Change Email Id");
                        System.out.println("7. Change nationality");
                        System.out.println("8. Change age");
                        System.out.println("9. Exit Update");

                        System.out.print("Enter your choice: ");
                        choice_to_change = scanner.nextInt();
                        temp.setId(cust_id_update);

                        switch (choice_to_change){
                            case 1:
                                scanner.nextLine();
                                System.out.print("Enter new first Name: ");
                                String fname_update = scanner.nextLine();
                                temp.set_first_name(fname_update);
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.print("Enter new middle Name: ");
                                String mname_update = scanner.nextLine();
                                temp.set_middle_name(mname_update);
                                break;
                            case 3:
                                scanner.nextLine();
                                System.out.print("Enter new last Name: ");
                                String lname_update = scanner.nextLine();
                                temp.set_last_name(lname_update);
                                break;
                            case 4:
                                System.out.print("Enter new address: ");
                                String address_update = scanner.next();
                                temp.setAddress(address_update);
                                break;
                            case 5:
                                System.out.print("Enter Mobile No: ");
                                long mobile_no_update = scanner.nextLong();
                                temp.setMobileNo(mobile_no_update);
                                break;
                            case 6:
                                System.out.print("Enter Email Id: ");
                                String email_update = scanner.next();
                                temp.setEmail(email_update);
                                break;

                            case 7:
                                System.out.print("Enter nationality: ");
                                String nationality_update = scanner.next();
                                temp.set_nationality(nationality_update);
                                break;
                            case 8:
                                System.out.print("Enter new age: ");
                                int age_update = scanner.nextInt();
                                temp.set_age(age_update);
                                break;

                          /*  default:
                                System.out.println("Invalid choice. Try again.");
                                break;*/
/*
                        }
                    } while (choice_to_change != 9);
                    System.out.println(temp.display_cust());
                    for(int i=0;i<customers.size();i++)
                    {
                        if(customers.get(i).getCustomerId()==cust_id_update)
                        {
                            customers.get(i).copy(temp);
                            mgc.writeJsonFile(customers,"C://Users//DELL//Documents//temp//Model//MOCK_DATA.json");
                        }
                    }//C:\Users\DELL\Downloads\teamp\Temp\src\Model\2nd_cust_data.json
                    break;

                case 11:

                    customers= mgc.readJsonFile("C://Users//DELL//Documents//temp//Model//MOCK_DATA.json");
                    System.out.print("Enter customer row to be deleted:  ");
                    int cust_row_delete = scanner.nextInt();
                    customers.remove(cust_row_delete-1);
                    mgc.writeJsonFile(customers,"C://Users//DELL//Documents//temp//Model//MOCK_DATA.json");
                    break;
                case 12:
                    customers = mgc.readJsonFile("C://Users//DELL//Documents//temp//Model//MOCK_DATA.json");


                    for(int i = 0; i < customers.size(); i++)
                    {
                        System.out.println(customers.get(i).display_cust());
                        System.out.println("\n");
                    }
                    break;
                case 13:

                    Food_item tempo =new Food_item();
                    food_items= mgf.readJsonFile("C://Users//DELL//Documents//temp//Model//food_item.json");
                    System.out.print("Enter Food item Id to Update: ");
                    int food_id_update = scanner.nextInt();
                    for(int i=0;i<food_items.size();i++)
                    {
                        if(food_items.get(i).getId()==food_id_update)
                        {
                            tempo= food_items.get(i);
                        }
                    }
                    scanner.nextLine();
                    int choice_for_change;
                    do {
                        System.out.println("1. Change Food item  Name");
                        System.out.println("2. Change Ingredients");
                        System.out.println("3. Change Cost ");
                        System.out.println("4. Change Discount");
                        System.out.println("5. Exit Update");

                        System.out.print("Enter your choice: ");
                        choice_for_change = scanner.nextInt();

                        switch (choice_for_change){
                            case 1:
                                scanner.nextLine();
                                System.out.print("Enter new food item Name: ");
                                String fname_update = scanner.nextLine();
                                tempo.setFood_item_name(fname_update);
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.print("Enter new ingredientd: ");
                                String mname_update = scanner.nextLine();
                                tempo.setFood_item_ingredients(mname_update);
                                break;
                            case 3:
                                scanner.nextLine();
                                System.out.print("Enter new Cost: ");
                                double Cost_update = scanner.nextDouble();
                                tempo.setFood_item_cost(Cost_update);
                                break;
                            case 4:
                                System.out.print("Enter new Discount: ");
                                int discount_update = scanner.nextInt();
                                tempo.setFood_item_discount(discount_update);
                                break;

                                default:
                                System.out.println("Invalid choice. Try again.");
                                break;
                        }
                    } while (choice_for_change != 5);
                    for(int i=0;i<food_items.size();i++)
                    {
                        if(food_items.get(i).getId()==food_id_update)
                        {
                            food_items.get(i).copy(tempo);
                           mgf.writeJsonFile(food_items,"C://Users//DELL//Documents//temp//Model//food_item.json");
                        }
                    }
                    break;

                case 14:
                    food_items= mgf.readJsonFile("C://Users//DELL//Documents//temp//Model//food_item.json");
                    System.out.print("Enter food item row to be deleted:  ");
                    int food_row_delete = scanner.nextInt();
                    food_items.remove(food_row_delete-1);
                    mgc.writeJsonFile(customers,"C://Users//DELL//Documents//temp//Model//food_item.json");
                    break;
                case 15:
                    food_items = mgf.readJsonFile("C://Users//DELL//Documents//temp//Model//food_item.json");

                    for(int i = 0; i < food_items.size(); i++)
                    {
                        System.out.println(food_items.get(i).display_food());
                        System.out.println("\n");
                    }
                    break;


                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 20);
        scanner.close();
    }
}*/
import Controller.Controller;
import Model.*;
import View.View;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller Controller = new Controller(model, view);
    }
}