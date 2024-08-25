package travel_with_WanderEase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.sql.*;

public class Payments extends JFrame implements ActionListener {
    JButton pay, back, lblfetchamt;
    JLabel lblamt;
    JLabel image;
    String username;
    String totalpayment;
    Payments(String username) {
        this.username = username;
        setBounds(400, 100, 800, 600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);

        pay = new JButton("Pay");
        pay.setBounds(370, 350, 60, 30);
        pay.setBackground(new Color(4, 46, 111));
        pay.setForeground(Color.white);
        pay.addActionListener(this);

        lblamt = new JLabel("");
        lblamt.setFont(new Font("Tahoma",Font.BOLD,14));
        lblamt.setBounds(300,315,300,25);
        image.add(lblamt);

        back = new JButton("Back");
        back.setBounds(25, 20, 80, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);

        lblfetchamt = new JButton("Fetch Amount");
        lblfetchamt.setBounds(340, 185, 120, 30);
        lblfetchamt.setBackground(new Color(4, 46, 111));
        lblfetchamt.setForeground(Color.white);
        lblfetchamt.addActionListener(this);
        image.add(lblfetchamt);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == lblfetchamt) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT totalprice FROM bookedpackage WHERE username = '" + username + "'");
                String packageint = "";
                while (rs.next()) {
                    packageint = rs.getString("totalprice");
                }
                ResultSet rs1 = c.s.executeQuery("SELECT totalcost FROM booked_hotel WHERE username = '" + username + "'");
                String hotelint = "";
                while (rs1.next()) {
                    hotelint = rs1.getString("totalcost");
                }
                totalpayment =  hotelint +" + "+ packageint;
                lblamt.setText("" + totalpayment);
                image.add(pay);

                // Display the total payment or open the payment URL
                System.out.println("Total payment: " + totalpayment);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }else if (ae.getSource() == pay) {
            setVisible(false);
            JOptionPane.showMessageDialog(null,"Payment Successful!");
        }
    }

    public static void main(String[] args) {
        new Payments(""); // Pass a sample username for testing
    }
}