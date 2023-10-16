package Model;
import java.util.Calendar;

public class Purchases {
    private Customer c1;             // Customer object representing the customer who made the purchase
    private Product p1;              // Product object representing the purchased product
    private Calendar purchase_date;  // Calendar object representing the date of the purchase

    // Setter method to set the purchased details (customer, product, and purchase date)
    public void set_puchased(Customer c2, Product p2, Calendar temppurchase_data) {
        c1 = c2;                     // Assigning the provided customer object to the c1 variable
        p1 = p2;                     // Assigning the provided product object to the p1 variable
        purchase_date = temppurchase_data;  // Assigning the provided calendar object to the purchase_date variable
    }

    // Method to display the purchase details
    public void Display_Purchase_Detail() {
        System.out.println("Customer Name = " + c1.getfirst_name() + " " + c1.getlast_ame() + " Product Name = "+p1.getProductName()+" , Purchase Date is " + purchase_date.getTime());
        // Printing the customer's first name, last name, and the date of purchase using the Calendar object.
    }
}