package Model;
import java.lang.Math;

/**
 * Identification comments:
 *   Name: Ayush Verma
 *   Experiment No:3
 *   Experiment Title:function and constructor overloading.
 *   Experiment Date:
 *   @version 1.0
 *
 *
 * Beginning comments: 
 * Filename: Customer.java
 * @author:  Richard Joseph
 * /*  Overview: This class is created to store the attributes of customer. It is a subclass of the class "Person" which inherits
some of the attributes from the Person class. And the class representing the "Person" object implements the interface named 
"Table Member".
 *
 * Attribute comments: 
 * id : Its customer Id
 * first name :
 * middle name:
 * last name:
 * mobile no. :
 * email:
 * address:
 */

public class Customer extends person{
    /* Customer attributes */
    private int id;

    private String first_name;
    private String middle_name;
    private String last_name;
    private String Address;
    private long mobile_no;
    private String email;
    private int name_length;
   
    private String nationality="NULL";

    public Customer(){}
    public Customer(int id, String name, String Address, long mobile_no, String email) {
        setId(id);
        String[] split_name = name.split(" ");
        if(split_name.length==1)
        {
            setname(split_name[0]);
            name_length=1;
        }
        else if(split_name.length==2)
        {
            setname(split_name[0],split_name[1]);
            name_length=2;

        }
        else if(split_name.length==3)
        {
            setname(split_name[0],split_name[1],split_name[2]);
            name_length=3;

        }
        setMobileNo(mobile_no);
        setEmail(email);
        setAddress(Address);

    }

    public Customer(String name, long mobile_no, String email, String Address) {
        int custId = (int) Math.random();
        System.out.println("Customer Created with Id: " + custId);
        setId(custId);
        String[] split_name = name.split(" ");
        if(split_name.length==1)
        {
            setname(split_name[0]);
            name_length=1;
        }
        else if(split_name.length==2)
        {
            setname(split_name[0],split_name[1]);
            name_length=2;

        }
        else if(split_name.length==3)
        {
            setname(split_name[0],split_name[1],split_name[2]);
            name_length=3;

        }


        setMobileNo(mobile_no);
        setEmail(email);
        setAddress(Address);

    }

    public Customer(int id, String firstName, String middleName, String lastName,String Address, long mobileNo, String email, String nationality, int age) {
        super();
        setId(id);
        setname(firstName,middleName,lastName);

        setMobileNo(mobileNo);
        setEmail(email);
        setAddress(Address);
        set_nationality(nationality);
        set_age(age);


    }
    public void copy(Customer c)
    {
        this.id=c.getCustomerId();
        this.first_name=c.getfirst_name();
        this.middle_name=c.getmiddle_name();
        this.last_name=c.getlast_ame();
        this.Address=c.getAddress();
        this.email=c.getEmail();
        this.mobile_no=getMobileNo();
        this.nationality=c.get_nationality();
        this.set_age(c.get_age());
    }

    public void setId(int cust) {
        this.id = cust;
    }
    public void setname(String first_name) {
        set_first_name(first_name);
    }
    public void setname(String first_name,String last_name) {
        set_first_name(first_name);
        set_last_name(last_name);
    }
    public void setname(String first_name,String middle_name,String last_name) {
        this.set_first_name(first_name);
        this.set_middle_name(middle_name);
        this.set_last_name(last_name);
    }
    public void set_first_name(String s){this.first_name = s;}
    public void set_middle_name(String s){this.middle_name = s;}
    public void set_last_name(String s){this.last_name = s;}


    public void setMobileNo(long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public int getCustomerId() {
        return this.id;
    }

    public String getName() {
        if(name_length==1)
        {
            return (this.first_name);
        }
        else if (name_length==2)
        {
            return (this.first_name+" "+this.last_name);
        }
        else
        return (this.first_name+" "+this.middle_name+" "+this.last_name);
    }
    public String getfirst_name() {
        return this.first_name;
    }
    public String getmiddle_name() {
        return this.middle_name;
    }
    public String getlast_ame() {
        return this.last_name;
    }

    public long getMobileNo() {
        return this.mobile_no;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.Address;
    }
    //OVERTIDDEN FUNCTIONS:-

    @Override
    public void set_nationality(String nationality)
    {
        this.nationality=nationality;
    }
    @Override
    public String get_nationality()
    {
        return nationality;
    }
    final public String display_cust()
    {
        return ("id: "+getCustomerId()+ " \tName: "+getName()+ " \tMobile No : "+getMobileNo()+ "  \tEmail: "+getEmail()+  " \tNationality: "+get_nationality()+ " \tage: "+get_age());
}


}