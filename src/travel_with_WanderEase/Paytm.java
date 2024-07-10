package travel_with_WanderEase;

import javax.swing.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {

    Paytm() {
        //Adding frame
        setBounds(500, 200, 800, 600);

        //Adding text field
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);

        //Loading website on pane
        try {
            pane.setPage("https://paytm.com/rent-payment");

        } catch(Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
        }

        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);

        JButton back = new JButton("Back");
        back.setBounds(610, 20, 80, 40);
        back.addActionListener(this);
        pane.add(back);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Payments();
    }

    public static void main(String[] args) {
        new Paytm();
    }
}