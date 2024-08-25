package travel_with_WanderEase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Checkout extends JFrame implements ActionListener {
    JButton checkout, fetch;
    JLabel labeltotalpayableamt,packagename,labelusername,labelphone,labeltotalpersonsp,labeltotalpricep,labeltotalpersonsh,labeltotalpriceh,lblhotelname,labeldays,labelroomtype,labelfood;
    JLabel image;
    String username;
    String totalpayment;
    Checkout(String username) {
        this.username = username;
        setBounds(400, 100, 800, 600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Checkout1.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);

        JLabel mainlabel = new JLabel("Checkout");
        mainlabel.setBounds(45,30,150,25);
        mainlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        image.add(mainlabel);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(120,92,150,25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        image.add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(200,92,150,25);
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        image.add(labelusername);

        JLabel lblphone = new JLabel("Phone: ");
        lblphone.setBounds(500,92,150,25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 15));
        image.add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(560,92,150,25);
        labelphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        image.add(labelphone);

        //Package details
        JLabel lblpackagetype = new JLabel("Package Type:");
        lblpackagetype.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblpackagetype.setBounds(120,170,150,25);
        image.add(lblpackagetype);

        packagename = new JLabel();
        packagename.setFont(new Font("Tahoma", Font.BOLD, 18));
        packagename.setBounds(500,170,150,25);
        image.add(packagename);

        JLabel lbltotpersonsp = new JLabel("Total Persons: ");
        lbltotpersonsp.setBounds(120,220,150,25);
        lbltotpersonsp.setFont(new Font("Tahoma", Font.PLAIN, 15));
        image.add(lbltotpersonsp);

        labeltotalpersonsp = new JLabel();
        labeltotalpersonsp.setBounds(220,220,150,25);
        labeltotalpersonsp.setFont(new Font("Tahoma", Font.BOLD, 15));
        image.add(labeltotalpersonsp);

        JLabel lbltotpricep = new JLabel("Total Price: ");
        lbltotpricep.setBounds(500,220,150,25);
        lbltotpricep.setFont(new Font("Tahoma", Font.PLAIN, 15));
        image.add(lbltotpricep);

        labeltotalpricep = new JLabel();
        labeltotalpricep.setBounds(580,220,150,25);
        labeltotalpricep.setFont(new Font("Tahoma", Font.BOLD, 15));
        image.add(labeltotalpricep);

        //Hotel details
        JLabel lblhotelDetails = new JLabel("Hotel Details: ");
        lblhotelDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblhotelDetails.setBounds(120,320,120,25);
        image.add(lblhotelDetails);

        lblhotelname = new JLabel();
        lblhotelname.setBounds(320,320,400,25);
        lblhotelname.setFont(new Font("Tahoma", Font.BOLD, 18));
        image.add(lblhotelname);

        JLabel lbldays = new JLabel("No. of days: ");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbldays.setBounds(120,370,150,25);
        image.add(lbldays);

        labeldays = new JLabel();
        labeldays.setFont(new Font("Tahoma", Font.BOLD, 15));
        labeldays.setBounds(210,370,150,25);
        image.add(labeldays);

        JLabel lblfood = new JLabel("Food Inc.: ");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblfood.setBounds(320,370,150,25);
        image.add(lblfood);

        labelfood = new JLabel();
        labelfood.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelfood.setBounds(400,370,150,25);
        image.add(labelfood);

        JLabel lblac = new JLabel("Room type: ");
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblac.setBounds(500,370,150,25);
        image.add(lblac);

        labelroomtype = new JLabel();
        labelroomtype.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelroomtype.setBounds(585,370,150,25);
        image.add(labelroomtype);

        JLabel lbltotpersonsh = new JLabel("Total Persons: ");
        lbltotpersonsh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbltotpersonsh.setBounds(120,420,150,25);
        image.add(lbltotpersonsh);

        labeltotalpersonsh = new JLabel();
        labeltotalpersonsh.setFont(new Font("Tahoma", Font.BOLD, 15));
        labeltotalpersonsh.setBounds(220,420,150,25);
        image.add(labeltotalpersonsh);

        JLabel lbltotpriceh = new JLabel("Total Price: ");
        lbltotpriceh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbltotpriceh.setBounds(500,420,150,25);
        image.add(lbltotpriceh);

        labeltotalpriceh = new JLabel();
        labeltotalpriceh.setFont(new Font("Tahoma", Font.BOLD, 15));
        labeltotalpriceh.setBounds(580,420,150,25);
        image.add(labeltotalpriceh);

        JLabel lbltotalpayableamt = new JLabel("Total Payable :");
        lbltotalpayableamt.setBounds(120,497,200,40);
        lbltotalpayableamt.setFont(new Font("Tahoma",Font.PLAIN,17));
        image.add(lbltotalpayableamt);


        labeltotalpayableamt = new JLabel();
        labeltotalpayableamt.setFont(new Font("Tahoma",Font.BOLD,17));
        labeltotalpayableamt.setBounds(280,497,300,40);
        image.add(labeltotalpayableamt);

        checkout = new JButton("Checkout");
        checkout.setBounds(605, 505, 105, 30);
        checkout.setBackground(new Color(49,135,215));
        checkout.setForeground(Color.white);
        checkout.setFont(new Font("Tahoma", Font.BOLD, 15));
        checkout.setBorderPainted(false); // Remove the button border
        checkout.setFocusPainted(false); // Optional: Remove the focus border
        checkout.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand pointer
        checkout.addActionListener(this);
        image.add(checkout);

        fetch = new JButton("Fetch");
        fetch.setBounds(620, 34, 70, 30);
        fetch.setBackground(new Color(49,135,215));
        fetch.setForeground(Color.WHITE);
        fetch.setFont(new Font("Tahoma", Font.BOLD, 13));
        fetch.setBorderPainted(false); // Remove the button border
        fetch.setFocusPainted(false); // Optional: Remove the focus border
        fetch.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand pointer
        fetch.addActionListener(this);
        image.add(fetch);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetch) {
            try {
                Conn c = new Conn();
                //fetch package details
                ResultSet rs = c.s.executeQuery("SELECT * FROM bookedpackage WHERE username = '" + username + "'");
                String packageprice = "";
                while (rs.next()) {
                    packagename.setText(rs.getString("package"));
                    labelusername.setText(rs.getString("username"));
                    labelphone.setText(rs.getString("phone"));
                    labeltotalpersonsp.setText(rs.getString("persons"));

                    packageprice = rs.getString("totalprice");
                    labeltotalpricep.setText(packageprice);
                }

                //fetch hotel details
                ResultSet rs1 = c.s.executeQuery("SELECT * FROM booked_hotel WHERE username = '" + username + "'");
                String hotelprice = "";
                while (rs1.next()) {
                    lblhotelname.setText(rs1.getString("sel_hotel"));
                    labeldays.setText(rs1.getString("days"));
                    labelroomtype.setText(rs1.getString("roomtype"));
                    labelfood.setText(rs1.getString("foodinc"));
                    labeltotalpersonsh.setText(rs1.getString("persons"));

                    hotelprice = rs1.getString("totalcost");
                    labeltotalpriceh.setText(hotelprice);
                }

                //display total amount
                String finalamt = packageprice + " + " + hotelprice;
                labeltotalpayableamt.setText(finalamt);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if (ae.getSource() == checkout) {
            JOptionPane.showMessageDialog(null,"Checkout Successful!");
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Checkout("dhruvpatwa16"); // Pass a sample username for testing
    }
}