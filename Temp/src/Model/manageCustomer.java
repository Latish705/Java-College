package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manageCustomer extends fileHandlingCustomer implements Displayable {
    ArrayList<Customer> Customers = new ArrayList<Customer>();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageCustomer(){
        readJsonFile("C:/Users/vinee/Downloads/Javamini/Temp/src/Model/customer.json");
    }

    public ArrayList<Customer> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int id = node.get("customer_id").asInt();
                    String name = node.get("first_name").asText();
                    String lastName = node.get("last_name").asText();
                    String email = node.get("email").asText();
                    String phone = String.valueOf(node.get("phoneno").asLong());
                    String address = node.get("customer_address").asText();
                    String city = node.get("city").asText();
//                    String postal = node.get("postal").asText();
                    String state = node.get("state").asText();
                    String Country = node.get("Country").asText();
                    Customer stud = new Customer(id,name,lastName,email,phone,address,state,city,Country);
                    Customers.add(stud);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Customers;
    }

    @Override
    public void writeJsonFile(ArrayList<Customer> Customers) {
        ObjectMapper Obj = new ObjectMapper();
        try {

            for (int i = 0; i < Customers.size(); i++)
            {
                // Converting the Java object into a JSON string
                String stud_str = Obj.writeValueAsString(Customers.get(i));
                // Displaying Java object into a JSON string
                System.out.println(stud_str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Email");
        headers.add("Gender");
        headers.add("MobileNo");
        headers.add("Category");
//        headers.add("10th Percentage");
//        headers.add("12th/Diploma Percentage");

        return headers;
    }

    /*
    The getLine(int line) method returns an ArrayList of String objects that represent a single row of the table.
    The method takes an integer argument line that specifies which row to retrieve. The method retrieves the FootballPlayer object
    at the specified index in the Customers list and then extracts the various attributes of the Customer such as their name, height, weight,
    etc. These attributes are then added to the ArrayList and returned.
     */
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> Customer_details = new ArrayList<String>();

        Customer_details.add(String.valueOf(Customers.get(line).getcustomer_id()));
        Customer_details.add(Customers.get(line).getFirstname()+" "+Customers.get(line).getLastname());
        Customer_details.add(Customers.get(line).getEmail());
        Customer_details.add(Customers.get(line).getPhoneNo());
        Customer_details.add(String.valueOf(Customers.get(line).getAddress()));
        Customer_details.add(Customers.get(line).getCity());

        return Customer_details;
    }

    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> Customers_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            Customers_subset.add(getLine(i));
        }
        return Customers_subset;
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
        return Customers;
    }
}
