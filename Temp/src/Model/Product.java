package Model;

/**
 * Identification comments:
 *   Name: Richard Joseph
 *   Experiment No:
 *   Experiment Title:
 *   Experiment Date:
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: Product.java
 * @author:  Richard Joseph
 * /*  Overview: This class is created to store the attributes of Product. It is a subclass of the class "Person" which inherits
some of the attributes from the Person class. And the class representing the "Person" object implements the interface named
"Table Member".
 *
 * Attribute comments:
 * id : Its Product Id
 * Name :
 * DOB :
 *
 *
 */

public class Product {

    private int product_id;             // Unique identifier for the product
    private String product_name;        // Name of the product
    private String product_brand;       // Brand name of the product
    private int product_price;        // Price of the product
    private int product_quantity;       // Quantity of the product available
    private float product_rating;       // Rating of the product (e.g., average customer rating)
    private boolean product_availability;  // Availability status of the product (true if available, false otherwise)
    private String DeliveryStatus;
    private String DeliveryFeedback;
    public Product(){}
    //constructor overloading
//    public Product(int product_price,int product_id,float product_rating,String product_name,String product_brand,boolean product_availability,int product_quantity){
//        setPrice(product_price);
//        setProduct_availability(product_availability);
//        setProductName(product_name);
//        setProduct_id(product_id);
//        setProductName(product_name);
//        setBrand(product_brand);
//        setProduct_quantity(product_quantity);
//    }
    public Product(int product_id,String name,String product_brand,String price,String product_availabillity,int product_quantity){
        setProduct_quantity(product_quantity);
        setProductName(product_name);
        setBrand(product_brand);
        setProduct_quantity(product_quantity);
        setProduct_rating(product_rating);
        setProduct_id(product_id);
        setProduct_availability(product_availability);


    }



    // Setter method for product_id
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    // Getter method for product_id
    public int getProduct_id() {
        return product_id;
    }

    // Setter method for product_name
    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    // Getter method for product_name
    public String getProductName() {
        return product_name;
    }

    // Setter method for product_brand
    public void setBrand(String product_brand) {
        this.product_brand = product_brand;
    }

    // Getter method for product_brand
    public String getProductBrand() {
        return product_brand;
    }

    // Setter method for product_price
    public void setPrice(int product_price) {
        this.product_price = product_price;
    }

    // Getter method for product_price
    public float getProductPrice() {
        return product_price;
    }

    // Setter method for product_quantity
    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    // Getter method for product_quantity
    public int getProductQuantity() {
        return product_quantity;
    }

    // Setter method for product_rating
    public void setProduct_rating(float product_rating) {
        this.product_rating = product_rating;
    }

    // Getter method for product_rating
    public float getProductRating() {
        return product_rating;
    }

    // Setter method for product_availability
    public void setProduct_availability(boolean product_availability) {
        this.product_availability = product_availability;
    }

// Getter method for
//    product_availability    public boolean getProductAvailability() {
//        return product_availability;    }
    public void addDeliveryStatus(String DeliveryStatus)    {
        this.DeliveryStatus=DeliveryStatus;    }
    public void removeDeliveryStatus()    {
        DeliveryStatus="Not set";    }
    public void addDeliveryFeedback(String DeliveryFeedback)    {
        this.DeliveryFeedback=DeliveryFeedback;    }
    public void removeDeliveryFeedback() {
        DeliveryFeedback = "Feedback Not Set";    }
    public void displayPurchase()    {
    }
}