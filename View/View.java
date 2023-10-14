package View;

import java.util.ArrayList;

public class View {

    private MainFrame mf;

    public View() {
        mf = new MainFrame();
    }

    /**
     * @return the mf
     */
    public MainFrame getMf() {
        return mf;
    }

    /**
     * @param mf the mf to set
     */
    public void setMf(MainFrame mf) {
        this.mf = mf;
    }

    public void centerInitialSetup(int linesBeingDisplayed, int size) {
        mf.getIp().getCp().createDisplay(linesBeingDisplayed, size);
    }
//    public void centerInitial2Setup(int linesBeingDisplayed, int size) {
//        mf.getIp().getCp().create2Display(linesBeingDisplayed, size);
//    }
    public void centerUpdate(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {

        mf.getIp().getCp().updateDisplay(lines,headers);

    }
//    public String id() {
//
//        return mf.getIp().getCp().getplayerButtonText();
//
//    }
//    public void centerUpdate(ArrayList<ArrayList<String>> lines) {
//
//        mf.getIp().getCp().updateDisplay(lines);
//    }
//    public void center2Update(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
//        mf.getIp().getCp().updateDisplay(lines,headers);
//    }

    public void clear() {
        //mf=null;
    }
}

