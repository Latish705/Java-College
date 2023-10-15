package Model;

import View.View;
import com.fasterxml.jackson.annotation.JsonCreator;
import Model.Model;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

abstract class fileHandlingCustomer {

    String Customer_parent_email;
    abstract public ArrayList<Customer> readJsonFile(String file_path);

    public abstract void overwriteJsonRow(String keyToOverwrite, ObjectNode newData);

    public abstract void writeJsonFile(ArrayList<Customer> Customers, String filePath);

    //    public void writeJsonFile(ArrayList<Customer> Customers, String filePath) {
    //        ObjectMapper objectMapper = new ObjectMapper();
    //
    //        try {
    //            // Write the ArrayList to a JSON file
    //            objectMapper.writeValue(new File(filePath), Customers);
    //            System.out.println("Data has been written to " + filePath);
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }
    //    }
        public abstract void writeJsonFile(ArrayNode customerArray, String filePath);

    //    abstract public void deleteRowJosn(int rowid);
    abstract public void writeJsonFile(ArrayList<Customer> Customers);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}
