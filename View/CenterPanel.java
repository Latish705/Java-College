package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class CenterPanel extends JPanel {

    ArrayList<JButton> header_buttons = new ArrayList<>();
    ArrayList<JButton> Customer_buttons = new ArrayList<>();
    ArrayList<JButton> Product_buttons = new ArrayList<>();
    int button_no;

    public CenterPanel()
    {
        super();
    }

    public void createDisplay(int rows, int cols)
    {
        ArrayList<JButton> buttons = new ArrayList<>();
        ArrayList<JButton> c = new ArrayList<>();

        this.removeAll();
        this.revalidate();
        this.repaint();
        this.setLayout(new GridLayout(rows+1,cols));
        for (int i = 0; i < cols; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.cyan);
            b.setPreferredSize(new Dimension(80,25));
            buttons.add(b);
            this.add(b);
           // validate();
            //repaint();
            header_buttons=buttons;
        }
        for (int i = 0; i < rows * (cols); i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.cyan);
            b.setPreferredSize(new Dimension(120,25));
            c.add(b);
            this.add(b);
//            validate();
//            repaint();
            Customer_buttons=c;
        }
//        for (int i = 1; i <= rows * cols; i++)
//        {
//            JButton b = new JButton();
//            b.setBackground(Color.cyan);
//            b.setPreferredSize(new Dimension(120,25));
//            Product_buttons.add(b);
//            this.add(b);
//            validate();
//            repaint();
//        }
    }
//    public void create2Display(int rows, int cols)
//    {
//        this.removeAll();
//        this.revalidate();
//        this.repaint();
//        this.setLayout(new GridLayout(rows+1,cols));
//        for (int i = 1; i <= cols; i++)
//        {
//            JButton b = new JButton();
//            b.setBackground(Color.cyan);
//            b.setPreferredSize(new Dimension(80,25));
//            header_buttons.add(b);
//            this.add(b);
//            validate();
//            repaint();
//        }/*
//        for (int i = 1; i <= rows * cols; i++)
//        {
//            JButton b = new JButton();
//            b.setBackground(Color.cyan);
//            b.setPreferredSize(new Dimension(120,25));
//            Customer_buttons.add(b);
//            this.add(b);
//            validate();
//            repaint();
//        }*/
//       for (int i = 1; i <= rows * cols; i++)
//        {
//            JButton b = new JButton();
//            b.setBackground(Color.cyan);
//            b.setPreferredSize(new Dimension(120,25));
//            Product_buttons.add(b);
//            this.add(b);
//            validate();
//            repaint();
//        }
//    }

    public void updateDisplay(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {

        int player_col_no = 0;
        int i = 0;
        int button_no;
        for (i = 0; i < headers.size(); i++)
        {
            setHeaderButtonText(i,headers.get(i));
        }
     //   setHeaderButtonText(i,"update");

        for (int player_no = 0; player_no < lines.size(); player_no++)
        {
            for (  player_col_no = 0; player_col_no < headers.size()-2; player_col_no++)
            {
                 button_no = player_no * headers.size() + player_col_no;
                String button_txt = lines.get(player_no).get(player_col_no);
                setPlayerButtonText(button_no,button_txt);
                //setPlayer2ButtonText(button_no,button_txt);
            }
             button_no = player_no * headers.size() + player_col_no;
         //   String button_txt = "*";
            setPlayerButtonText(button_no,"update");
            button_no = player_no * headers.size() + player_col_no+1;
            //   String button_txt = "*";
            setPlayerButtonText(button_no,"Delete");

        }
    }

    public void updateDisplay(ArrayList<ArrayList<String>> lines) {


//        for (int i = 0; i < headers.size(); i++)
//        {
//            setHeaderButtonText(i,headers.get(i));
//        }

        for (int player_no = 0; player_no < lines.size(); player_no++)
        {
            for (int player_col_no = 0; player_col_no < 7; player_col_no++)
            {
                int button_no = player_no * 7 + player_col_no;
                String button_txt = lines.get(player_no).get(player_col_no);
                setPlayerButtonText(button_no,button_txt);
                //setPlayer2ButtonText(button_no,button_txt);
            }
        }
    }
//    public void updatefoodDisplay(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
//        for (int i = 0; i < headers.size(); i++) {
//            setHeaderButtonText(i, headers.get(i));
//        }
//
//
//        for (int player_no = 0; player_no < lines.size(); player_no++) {
//            for (int player_col_no = 0; player_col_no < headers.size(); player_col_no++) {
//                int button_no = player_no * headers.size() + player_col_no;
//                String button_txt = lines.get(player_no).get(player_col_no);
//                //setPlayerButtonText(button_no, button_txt);
//                setPlayer2ButtonText(button_no,button_txt);
//            }
//        }
//    }

    public void setHeaderButtonText(int button_no, String button_text) {
        header_buttons.get(button_no).setText(button_text);
    }
    public String getplayerButtonText(int no) {
        return Customer_buttons.get(no).getText();
    }
    public void setPlayerButtonText(int button_no, String button_text) {
        Customer_buttons.get(button_no).setText(button_text);
    }
    public void setPlayer2ButtonText(int button_no, String button_text) {
        Product_buttons.get(button_no).setText(button_text);
    }

    public ArrayList<JButton> getHeaderButtons()
    {
        return header_buttons;
    }

    public ArrayList<JButton> getPlayerButtons()
    {
        return Customer_buttons;
    }
    public ArrayList<JButton> getPlayer2Buttons()
    {
        return Product_buttons;
    }

}
