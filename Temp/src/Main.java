import Controller.Controller;
import Model.Model;
import View.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Initialize your Model, View, and Controller here
                Model model = new Model();
                View view = new View();
                Controller controller = new Controller(model, view);

                // Call the initialize method to set up event listeners
                controller.initialize();

                // If your main method has additional code, you can add it here
            }
        });
    }
}
