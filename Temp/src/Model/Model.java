package Model;

import java.util.ArrayList;

public class Model
{
    protected manageCustomer manageCustomerData = new manageCustomer();

    public Model()
    {
        manageCustomerData.setLinesBeingDisplayed(25);
        manageCustomerData.setFirstLineToDisplay(0);
    }

    public manageCustomer getManageCustomerData()
    {
        return manageCustomerData;
    }

}
