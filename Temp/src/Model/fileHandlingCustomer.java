package Model;

import View.View;
import com.fasterxml.jackson.annotation.JsonCreator;
import Model.Model;
import java.util.ArrayList;

abstract class fileHandlingCustomer {

    String Customer_parent_email;
    abstract public ArrayList<Customer> readJsonFile(String file_path);
//    abstract public void deleteRowJosn(int rowid);
    abstract public void writeJsonFile(ArrayList<Customer> Customers);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}
