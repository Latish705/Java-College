package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manage_Customer extends fileHandling_Customer {
    ArrayList<Customer> Customers = new ArrayList<Customer>();
    ArrayList<Customer> t= new ArrayList<Customer>();
    /*public ArrayList<Customer> loadJsonFile(String file_path) {
        return readJsonFile(file_path);
    }*/
       String alternate_no;
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;


    public manage_Customer() {
        Customers= readJsonFile("C:/Users/DELL/Downloads/temp/Model/MOCK_DATA.json");
//        t=Customers;
//        writeJsonFile(Customers,"F://oopm//temp//Model//MOCK_DATA.json");

    }


    @Override

    public ArrayList<Customer> readJsonFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    JsonNode idNode = node.get("customerId");
                    if (idNode != null && idNode.isInt()) {
                        int id = idNode.asInt();
                        String firstName = node.get("first_name").asText();
                        String middleName = node.get("middle_name").asText();
                        String lastName = node.get("last_ame").asText(); // Corrected field name
                        String address = node.get("address").asText();
                        long mobileNo = node.get("mobileNo").asLong();
                       // System.out.println(node.get("mobileNo").asLong());
                        String email = node.get("email").asText();
                        String nationality = node.get("_nationality").asText();
                        int age = node.get("_age").asInt(); // Corrected field name

                        Customer cust = new Customer(id, firstName, middleName, lastName, address, mobileNo, email, nationality, age);
                        customers.add(cust);
                    } else {
                        // Handle the error more gracefully, e.g., throw an exception or log it.
                        System.err.println("ERROR: JSON data is missing or has incorrect types for a customer.");
                    }
                }
            }
        } catch (IOException e) {
            // Handle the exception, e.g., log it or throw a custom exception.
            e.printStackTrace();
        }

        return customers;
    }


    @Override
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

    public ArrayList tempcust(ArrayList tcust){
        //ArrayList<Customer> tcust = new ArrayList<Customer>();
        tcust= readJsonFile("G://oopm//temp//Model//MOCK_DATA.json");
        ArrayList<Customer> t = new ArrayList<Customer>();
        t=tcust;
        writeJsonFile(tcust,"G://oopm//temp//Model//MOCK_DATA.json");
        return tcust;
    }



    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Email");
        headers.add("Address");
        headers.add("MobileNo");
        headers.add("Nationality");
        headers.add("Age");
        //headers.add("Create");
        headers.add("update");
        headers.add("Delete");


        //headers.add("12th/Diploma Percentage");

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
        Customers= readJsonFile("C:/Users/DELL/Downloads/temp/Model/MOCK_DATA.json");
        student_details.add(String.valueOf(Customers.get(line).getCustomerId()));
        student_details.add(Customers.get(line).getName());
        student_details.add(Customers.get(line).getEmail());
        student_details.add(Customers.get(line).getAddress());
        student_details.add(String.valueOf(Customers.get(line).getMobileNo()));
        student_details.add(Customers.get(line).get_nationality());
        student_details.add(String.valueOf(Customers.get(line).get_age()));
        //student_details.add(String.valueOf(Customers.get(line).getPer_12_dip()));
//       writeJsonFile(Customers,"F://oopm//temp//Model//MOCK_DATA.json");
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

    public void delete(String id) {
        // Read data from the JSON file and store it in an ArrayList
        Customers = readJsonFile("C:/Users/DELL/Downloads/temp/Model/MOCK_DATA.json");

        // Find the index of the object with the specified 'id' and remove it
        int indexToDelete = -1;
        for (int i = 0; i < Customers.size(); i++) {
            Customer customer = Customers.get(i);
            if (customer.getCustomerId() == Integer.parseInt(id)) { // Convert id to an integer for comparison
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete != -1) {
            Customers.remove(indexToDelete);
            System.out.println("Customer with id " + id + " removed successfully.");
        } else {
            System.out.println("Customer with id " + id + " not found.");
        }

        // Write the updated ArrayList back to the JSON file
        writeJsonFile(Customers, "C:/Users/DELL/Downloads/temp/Model/MOCK_DATA.json");
    }

    public void update(Customer c){
        Customer temp =new Customer();
        Customers= readJsonFile("C:/Users/DELL/Downloads/temp/Model/MOCK_DATA.json");

        System.out.println(c.display_cust());
        for(int i=0;i<Customers.size();i++)
        {
            if(Customers.get(i).getCustomerId()==c.getCustomerId())
            {
                Customers.get(i).copy(c);
                writeJsonFile(Customers,"C:/Users/DELL/Downloads/temp/Model/MOCK_DATA.json");
            }
        }

    }
    public void create(Customer c) {
        Customers = readJsonFile("C:/Users/DELL/Downloads/temp/Model/MOCK_DATA.json");

        System.out.println(c.display_cust());
       // for (int i = 0; i < Customers.size(); i++) {}

        Customers.add(c);
        writeJsonFile(Customers,"C:/Users/DELL/Downloads/temp/Model/MOCK_DATA.json");



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
        return Customers;
    }


}


