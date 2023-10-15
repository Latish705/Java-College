package View;
import Model.Model;

import java.util.ArrayList;

public class View {

//    private Model model=;
    private MainFrame mf;

    public View() {
        mf = new MainFrame();
    }
    public MainFrame getMf() {
        return mf;
    }
    public void setMf(MainFrame mf) {
        this.mf = mf;
    }
//    public void firstButtonSetup()
//    {
//        mf.getIp().getFbt();
//    }
    public void centerInitialSetup(int linesBeingDisplayed, int size) {
        mf.getIp().getCp().createDisplay(linesBeingDisplayed, size);
    }

    public void centerUpdate(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        mf.getIp().getCp().updateDisplay(lines,headers);
    }

        // ...

        public void refreshCustomerData(Model model) {
            // Update your GUI components to reflect the changes in the data

            centerUpdate(model.getManageCustomerData().getLines(model.getManageCustomerData().getFirstLineToDisplay(), model.getManageCustomerData().getLastLineToDisplay()), model.getManageCustomerData().getHeaders());
        }

        // ...


}

