package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manageProduct extends fileHandlingProduct implements Displayable {
    ArrayList<Product> Products = new ArrayList<Product>();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageProduct(){
        readJsonFile("./Temp/src/Model/product.json");
    }

    public ArrayList<Product> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int id = node.get("product_id").asInt();
                    String name = node.get("product_name").asText();
                    String product_brand = node.get("Product_brand").asText();
                    String rating = node.get("product_rating").asText();
                    String price = String.valueOf(node.get("product_price").asText());
                    String availability = String.valueOf(node.get("product_availability").asBoolean());
                    String quantitty=node.get("product_quantity").asText();
                    Product prod = new Product(id,name,product_brand,price,availability,quantitty,rating);
                    Products.add(prod);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Products;
    }

    @Override
    public void writeJsonFile(ArrayList<Product> Products) {
        ObjectMapper Obj = new ObjectMapper();
        try {

            for (int i = 0; i < Products.size(); i++)
            {
                // Converting the Java object into a JSON string
                String stud_str = Obj.writeValueAsString(Products.get(i));
                // Displaying Java object into a JSON string
                System.out.println(stud_str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Override
//   Override public void deleteRowJson(int rowid) {
//
//    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Brand");
        headers.add("Price");
        headers.add("Rating");
        headers.add("Quantity");
//        header.add
//        headers.add("10th Percentage");
//        headers.add("12th/Diploma Percentage");

        return headers;
    }

    /*
    The getLine(int line) method returns an ArrayList of String objects that represent a single row of the table.
    The method takes an integer argument line that specifies which row to retrieve. The method retrieves the FootballPlayer object
    at the specified index in the Products list and then extracts the various attributes of the Product such as their name, height, weight,
    etc. These attributes are then added to the ArrayList and returned.
     */
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> Product_details = new ArrayList<String>();
        Product_details.add(String.valueOf(Products.get(line).getProduct_id()));
        Product_details.add(Products.get(line).getProductName());
        Product_details.add(Products.get(line).getProductBrand());
        Product_details.add(String.valueOf(Products.get(line).getProductPrice()));
        Product_details.add(String.valueOf(Products.get(line).getProductRating()));
        Product_details.add(String.valueOf(Products.get(line).getProductQuantity()));

        return Product_details;
    }

    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> Products_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            Products_subset.add(getLine(i));
        }
        return Products_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        linesBeingDisplayed = numberOfLines;
    }

    public ArrayList getTable() {
        return Products;
    }
}
