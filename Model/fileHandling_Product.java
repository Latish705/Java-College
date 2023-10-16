package Model;

import java.util.ArrayList;

public abstract class fileHandling_Product {
    abstract public ArrayList<Product> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<Product> products, String filePath);

    public abstract void writeJsonFile(ArrayList<Product> Products);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}
