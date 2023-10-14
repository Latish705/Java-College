package Model;

import java.util.ArrayList;

public abstract class fileHandling_food_items {
    abstract public ArrayList<Food_item> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<Food_item> food_items, String filePath);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}
