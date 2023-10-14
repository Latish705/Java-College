package Model;

import java.util.ArrayList;

public class Model
{
    protected manage_Customer manageCustomerData = new manage_Customer();
    protected Manage_food_items managefoodData=new Manage_food_items();

    public Model()
    {
        manageCustomerData.setLinesBeingDisplayed(25);
        manageCustomerData.setFirstLineToDisplay(0);

        managefoodData.setLinesBeingDisplayed(25);
        managefoodData.setFirstLineToDisplay(0);

    }



    public manage_Customer getManageStudentData()
    {
        return manageCustomerData;
    }
    public Manage_food_items getManagefoodData()
    {
        return managefoodData;
    }
    public void Data(Customer c)
    {
        manageCustomerData.update(c);
    }



}
