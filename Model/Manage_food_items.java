package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class Manage_food_items extends fileHandling_food_items{
    ArrayList<Food_item> Food_items = new ArrayList<Food_item>();
    private int linesBeingDisplayed=25;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

//    public Manage_food_items(){
//        Food_items= readJsonFile("F://oopm//temp//Model//food_item.json");
//        ArrayList<Food_item> t = new ArrayList<Food_item>();
//        t=Food_items;
//        writeJsonFile(Food_items,"F://oopm//temp//Model//food_item.json");
//
//    }
    public ArrayList<Food_item> loadJsonFile(String file_path) {
        return readJsonFile(file_path);
    }
    @Override
    public ArrayList<Food_item> readJsonFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Food_item> food_items = new ArrayList<>();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    JsonNode idNode = node.get("id");
                    if (idNode != null && idNode.isInt()) {
                        int id = idNode.asInt();
                        String food_item_name = node.get("food_item_name").asText(); // Match JSON field name
                        String ingredients = node.get("food_item_ingredients").asText(); // Match JSON field name
                        int cost = node.get("food_item_cost").asInt();
                        int discount = node.get("food_item_discount").asInt();
                        Food_item food = new Food_item(id, food_item_name, ingredients, cost,discount);
                        food_items.add(food);
                    } else {
                        System.out.println("ERROR: JSON data is missing or has incorrect types for a Food_item.");
                        // Handle the error more gracefully, e.g., throw an exception or log it.
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return food_items;
    }

    @Override
    public void writeJsonFile(ArrayList<Food_item> food_items, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Write the ArrayList to a JSON file
            objectMapper.writeValue(new File(filePath), food_items);
            System.out.println("Data has been written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public ArrayList<String> getHeaders() {
//        ArrayList<String> headers = new ArrayList<String>();
//        headers.add("Id");
//        headers.add("Name");
//        headers.add("Email");
//        headers.add("Address");
//        headers.add("MobileNo");
//        headers.add("Nationality");
//        headers.add("Age");
//        //headers.add("12th/Diploma Percentage");
//
//        return headers;
//    }
    public ArrayList<String> getfoodHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("cost");
        headers.add("discount");
        headers.add("ingredient");
        headers.add("update");


        return headers;
    }

    /*
    The getLine(int line) method returns an ArrayList of String objects that represent a single row of the table.
    The method takes an integer argument line that specifies which row to retrieve. The method retrieves the FootballPlayer object
    at the specified index in the students list and then extracts the various attributes of the student such as their name, height, weight,
    etc. These attributes are then added to the ArrayList and returned.
     */

    public ArrayList<String> getLine(int line) {
        ArrayList<String> student_details = new ArrayList<String>();
        Food_items= readJsonFile("C:/Users/DELL/Downloads/temp/Model/food_item.json");
        student_details.add(String.valueOf(Food_items.get(line).getId()));
        student_details.add(Food_items.get(line).getFood_item_name());
        student_details.add(String.valueOf(Food_items.get(line).getFood_item_cost()));
        student_details.add(String.valueOf(Food_items.get(line).getFood_item_discount()));
        student_details.add(String.valueOf(Food_items.get(line).getFood_item_ingredients()));
       // writeJsonFile(Food_items,"F://oopm//temp//Model//food_item.json");

        return student_details;
    }

    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */

    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> customers_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            customers_subset.add(getLine(i));
        }
        return customers_subset;
    }


    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }


    public int getLineToHighlight() {
        return highlightedLine;
    }


    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }


    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }


    public void setFirstLineToDisplay(int firstLine) {
        firstLineIndex = firstLine;
    }


    public void setLineToHighlight(int highlightedLine) {
        highlightedLine = highlightedLine;
    }


    public void setLastLineToDisplay(int lastLine) {
        lastLineIndex = lastLine;
    }


    public void setLinesBeingDisplayed(int numberOfLines) {
        linesBeingDisplayed = numberOfLines;
    }

    public ArrayList getTable() {
        return Food_items;
    }
    public ArrayList<Food_item> tempfood(){
        ArrayList<Food_item> tfood = new ArrayList<Food_item>();
        tfood= readJsonFile("F://oopm//temp//Model//food_item.json");
        writeJsonFile(tfood,"F://oopm//temp//Model//food_item.json");
        return tfood;

    }
}



