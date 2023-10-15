package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class manageCustomer extends fileHandlingCustomer implements Displayable {
    ArrayList<Customer> Customers = new ArrayList<Customer>();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageCustomer(){
    readJsonFile("./Temp/src/Model/customer.json");
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
                    String phone = String.valueOf(node.get("phoneno").asText());
                    String address = node.get("customer_address").asText();
                    String city = node.get("city").asText();
//                    String postal = node.get("postal").asText();
                    String state = null;
                    String Country = null;
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
    public void overwriteJsonRow(String keyToOverwrite, ObjectNode newData) {
        String jsonFilePath = "./Temp/src/Model/customer.json"; // Replace with your JSON file path

        try {
            // Read the JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            if (rootNode instanceof ArrayNode) {
                ArrayNode arrayNode = (ArrayNode) rootNode;

                // Search for the node with the specified key
                for (int i = 0; i < arrayNode.size(); i++) {
                    JsonNode node = arrayNode.get(i);
                    if (node.has("customer_id") && node.get("customer_id").asText().equals(keyToOverwrite)) {
                        // Replace the row with the new data
                        arrayNode.set(i, newData);

                        // Write the updated JSON back to the file
                        objectMapper.writeValue(new File(jsonFilePath), rootNode);
                        System.out.println("Row with key " + keyToOverwrite + " updated successfully.");
                        return;
                    }
                }

                System.out.println("Key '" + keyToOverwrite + "' not found in JSON data.");
            } else {
                System.out.println("JSON file should contain an array as the root node.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void refreshDataFromJsonFile(String filePath) {
        // Re-read the JSON file
        readJsonFile(filePath);

        // Update any other data or perform any necessary processing
    }

    public void writeJsonFile(ArrayList<Customer> Customers, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Write the ArrayList to a JSON file
            objectMapper.writeValue(new File(filePath), Customers);
            System.out.println("Data has been written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void writeJsonFile(ArrayNode customerArray, String filePath) {
        File jsonFile = new File(filePath);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, customerArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void DeleteSpecificNode(String  row_id)
    {
        String jsonFilePath = "./Temp/src/Model/customer.json"; // Replace with your JSON file path
        String nodeIdToDelete = row_id;  // Replace with the 'id' of the node to delete

        try {
            // Read the JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            if (rootNode instanceof ArrayNode) {
                ArrayNode arrayNode = (ArrayNode) rootNode;

                // Search for the node with the specified 'id'
                for (int i = 0; i < arrayNode.size(); i++) {
                    JsonNode node = arrayNode.get(i);
                    if (node.has("customer_id") && node.get("customer_id").asText().equals(nodeIdToDelete)) {
                        // Remove the node from the array
                        arrayNode.remove(i);
                        break;
                    }
                }

                // Write the updated JSON back to the file
                objectMapper.writeValue(new File(jsonFilePath), rootNode);
                System.out.println("Node with id " + nodeIdToDelete + " deleted successfully.");
//                view.centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());

            } else {
                System.out.println("JSON file should contain an array as the root node.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeJsonFile(ArrayList<Customer> Customers) {
        ObjectMapper Obj = new ObjectMapper();
//        String jsonFilePath = "./Temp/src/Model/customer.json"; // Replace with your JSON
        try {

            for (int i = 0; i < Customers.size(); i++)
            {
                // Converting the Java object into a JSON string
                Obj.writeValueAsString(Customers.get(i));
                // Displaying Java object into a JSON string
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void appendToJson(Customer data, String fileName) {
        try {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the existing JSON data from the file (if it exists)
            List<Customer> dataList = new ArrayList<>();
            File file = new File(fileName);

            if (file.exists()) {
                dataList = objectMapper.readValue(file, List.class);
            }

            // Append the new data
            dataList.add(data);

            // Write the updated data back to the file, overwriting it
            objectMapper.writeValue(file, dataList);

            System.out.println("Data appended to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Email");
        headers.add("MobileNo");
        headers.add("Address");
        headers.add("City");
//        headers.add("Edit Option");
//        headers.add("Delete Option");
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
//        Customer_details.add("Edit");
//        Customer_details.add("Delete");

        return Customer_details;
    }
//    public void CreateJsonRow(ObjectNode customerNode) {
//        try {
//
//            // Read the existing JSON data from the file
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
//            File jsonFile = new File("./Temp/src/Model/customer.json");
//
//            JsonNode rootNode;
//            if (jsonFile.exists()) {
//                rootNode = objectMapper.readTree(jsonFile);
//            } else {
//                rootNode = objectMapper.createObjectNode();
//            }
//
//            // Extract the customer ID from the new data
//            String customerId = customerNode.get("customer_id").asText();
//
//            // Check if the ID already exists in the JSON data
//            if (rootNode.has("customer" + customerId)) {
//                System.out.println("Customer with ID " + customerId + " already exists. Cannot append.");
//            } else {
//                // Add the new customer node to the JSON data
//                ((ObjectNode) rootNode).set("customer" + customerId, customerNode);
//
//                // Write the updated JSON data back to the file
//                ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
//                objectWriter.writeValue(jsonFile, rootNode);
//
//                System.out.println("Customer Successfully Appended: " + customerNode.toString());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            // Handle exceptions as needed
//        }
//    }


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
