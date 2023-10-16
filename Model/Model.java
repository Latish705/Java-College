package Model;

public class Model
{
    protected manage_Customer manageCustomerData = new manage_Customer();
    protected manage_Product manageProductData=new manage_Product();

    public Model()
    {
        manageCustomerData.setLinesBeingDisplayed(25);
        manageCustomerData.setFirstLineToDisplay(0);

        manageProductData.setLinesBeingDisplayed(25);
        manageProductData.setFirstLineToDisplay(0);

    }



    public manage_Customer getManageStudentData()
    {
        return manageCustomerData;
    }
    public manage_Product getManageProductData()
    {
        return manageProductData;
    }
    public void Data(Customer c)
    {
        manageCustomerData.update(c);
    }



}
