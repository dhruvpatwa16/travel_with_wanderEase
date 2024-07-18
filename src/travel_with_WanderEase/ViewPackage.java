package travel_with_WanderEase;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
    JLabel lblpersons,labelpackage;
    ViewPackage(String username){
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(30,5,300,30);
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("",Font.PLAIN,12));
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Package");
        lblpackage.setFont(new Font("",Font.PLAIN,12));
        lblpackage.setBounds(30,90,150,25);
        add(lblpackage);
        
        labelpackage = new JLabel();
        labelpackage.setBounds(220,90,150,25);
        labelpackage.setFont(new Font("",Font.BOLD,16));
        add(labelpackage);
        
        lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("",Font.PLAIN,12));
        lblpersons.setBounds(30,130,150,25);
        add(lblpersons);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220,130,150,25);
        labelpersons.setFont(new Font("",Font.BOLD,16));
        add(labelpersons);
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("",Font.PLAIN,12));       
        lblid.setBounds(30,170,150,25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,170,150,25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("",Font.PLAIN,12));
        lblnumber.setBounds(30,210,150,25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,210,150,25);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("",Font.PLAIN,12));
        lblphone.setBounds(30,250,150,25);
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220,250,150,25);
        add(labelphone);
        
        JLabel lbltotprice = new JLabel("Price");
        lbltotprice.setFont(new Font("",Font.PLAIN,12));
        lbltotprice.setBounds(30,290,150,25);
        add(lbltotprice);
        
        JLabel labeltotprice = new JLabel();
        labeltotprice.setBounds(220,295,150,25);
        labeltotprice.setFont(new Font("",Font.BOLD,16));
        add(labeltotprice);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(130,350,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewpackage1.png"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(450,10,400,400);
        add(image1);
        
        try{
            Conn c = new Conn();
            String query = "select * from bookedpackage where username = '"+username+"'";
            ResultSet rs =c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelpersons.setText(rs.getString("persons")); 
                labelphone.setText(rs.getString("phone"));
                labeltotprice.setText(rs.getString("totalprice"));                  
            }      
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
       public void actionPerformed(ActionEvent ae){
           setVisible(false);     
       }
       public static void main(String[]args){
           new ViewPackage("dhruvpatwa16");
       }
}
