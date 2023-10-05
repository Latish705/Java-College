package Model;

import java.awt.*;

public class Person {
    int customer_id;
    String first_name;
    String last_name;
    String email;
    String phone;
    Person()
    {

    }

    Person(int customer_id,String fullname,String email)
    {
        this.customer_id=customer_id;
        String[] split=fullname.split(" ");
        this.first_name=split[0];
        this.last_name=split[1];
        this.email=email;
    }
    Person(int Id, String name,String last_name,String email,String mobile_no)
    {
        this.customer_id=Id;
        this.first_name=name;
        this.last_name=last_name;
        this.email=email;
        this.phone=mobile_no;
    }
    Person(int customer_id,String fullname,String phone,String email)
    {
        this.customer_id=customer_id;
        String[] split=fullname.split(" ");
        this.first_name=split[0];
        this.last_name=split[1];
//        this.phone=phone;
        this.email=email;
    }
    public void setname(String fullname)
    {
        String[] split=fullname.split(" ");
        setFirstName(split[0]);
        setLastname(split[1]);
    }

    // Setter and Getter methods for customer_id
    public void setCustomerId(int customer_id) {
        this.customer_id=customer_id;
    }

    public int getcustomer_id() {
        return customer_id;
    }

    // Setter and Getter methods for first_name
    public void setFirstName(String first_name) {
        this.first_name=first_name;
    }

    public String getFirstname() {
        return first_name;
    }

    // Setter and Getter methods for last_name
    public void setLastname(String last_name) {
        this.last_name=last_name;
    }

    public String getLastname() {
        return last_name;
    }

    // Setter and Getter methods for email
    public void setEmail(String email) {
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    // Setter and Getter methods for phone
    public void setPhoneNo(String phone) {
        this.phone=phone;
    }

    public void setPhoneNo() {
        phone="1233455323";
    }

    public String getPhoneNo() {
        return this.phone;
    }

    public String display() {
        return getFirstname()+getLastname()+getPhoneNo()+getEmail();
    }
}

