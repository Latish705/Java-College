package Model;

import java.util.ArrayList;

abstract class fileHandlingProduct {
    abstract public ArrayList<Course> readJsonFile(String file_path);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}
