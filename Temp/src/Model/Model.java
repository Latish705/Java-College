package Model;

import java.util.ArrayList;

public class Model
{
    protected manageCustomer manageCustomerData = new manageCustomer();
    protected manageProduct manageProductData = new manageProduct();
    public Model()
    {
        manageCustomerData.setLinesBeingDisplayed(25);
        manageCustomerData.setFirstLineToDisplay(0);
        manageProductData.setLinesBeingDisplayed(25);
        manageProductData.setFirstLineToDisplay(0);
    }

    public manageCustomer getManageCustomerData()
    {
        return manageCustomerData;
    }

    public manageProduct getManageProductData() {
        return manageProductData;
    }


}
