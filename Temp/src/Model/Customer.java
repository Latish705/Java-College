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
 * Filename: Customer.java
 * @author:  Richard Joseph
 * /*  Overview: This class is created to store the attributes of Customer. It is a subclass of the class "Person" which inherits
some of the attributes from the Person class. And the class representing the "Person" object implements the interface named
"Table Member".
 *
 * Attribute comments:
 * id : Its Customer Id
 * Name :
 * DOB :
 *
 *
 */

public class Customer extends Person {

    String address;
    String state;
    String city;
    String postalCode;
    String Country;

    public Customer(int Id, String name,String last_name,String email,String mobile_no,String address,String state,String city,String Country)
    {
        super(Id,name,last_name,email,mobile_no);
        this.address=address;
        this.state=state;
        this.city=city;
//        this.postalCode=postalCode;
        this.Country=Country;
    }

    public String getAddress()
    {
        return this.address;
    }
    public String getState()
    {
        return this.state;
    }
    public String getCity()
    {
        return this.city;
    }
    public String getPostalCode()
    {
        return this.postalCode;
    }
    public String getCountry()
    {
        return this.Country;
    }

    public String displayCustomer()
    {
        return display();
    }

}
