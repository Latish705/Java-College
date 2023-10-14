package Model;

import java.util.ArrayList;

abstract class fileHandling_Customer{

    String alternate_email;
    abstract public ArrayList<Customer> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<Customer> Customers, String filePath);


}
