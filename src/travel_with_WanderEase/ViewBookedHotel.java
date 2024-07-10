package travel_with_WanderEase;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class ViewBookedHotel extends JFrame implements ActionListener{
    JButton back;
    JLabel lblpersons,labelhotelname;
    ViewBookedHotel(String username){
        setBounds(400,200,1000,550);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(30,5,350,30);
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("",Font.PLAIN,12));
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblhotelname = new JLabel("Hotel Name");
        lblhotelname.setFont(new Font("",Font.PLAIN,12));
        lblhotelname.setBounds(30,90,150,25);
        add(lblhotelname);
        
        labelhotelname = new JLabel();
        labelhotelname.setBounds(220,90,200,25);
        add(labelhotelname);
        
        lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("",Font.PLAIN,12));
        lblpersons.setBounds(30,130,150,25);
        add(lblpersons);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220,130,150,25);
        add(labelpersons);
        
        JLabel lbldays = new JLabel("No. of days");
        lbldays.setFont(new Font("",Font.PLAIN,12));       
        lbldays.setBounds(30,170,150,25);
        add(lbldays);
        
        JLabel labeldays = new JLabel();
        labeldays.setBounds(220,170,150,25);
        add(labeldays);
        
        JLabel lblroomtype = new JLabel("Room type");
        lblroomtype.setFont(new Font("",Font.PLAIN,12));
        lblroomtype.setBounds(30,210,150,25);
        add(lblroomtype);
        
        JLabel labelroomtype = new JLabel();
        labelroomtype.setBounds(220,210,150,25);
        add(labelroomtype);
        
        JLabel lblfoodinc = new JLabel("Food Inc.?");
        lblfoodinc.setFont(new Font("",Font.PLAIN,12));
        lblfoodinc.setBounds(30,250,150,25);
        add(lblfoodinc);
        
        JLabel labelfoodinc = new JLabel();
        labelfoodinc.setBounds(220,250,150,25);
        add(labelfoodinc);
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("",Font.PLAIN,12));
        lblid.setBounds(30,290,150,25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,290,150,25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("",Font.PLAIN,12));
        lblnumber.setBounds(30,330,150,25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,330,150,25);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("",Font.PLAIN,12));
        lblphone.setBounds(30,370,150,25);
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220,370,150,25);
        add(labelphone);
        
        JLabel lbltotprice = new JLabel("Total Cost");
        lbltotprice.setFont(new Font("",Font.PLAIN,12));
        lbltotprice.setBounds(30,410,150,25);
        add(lbltotprice);
        
        JLabel labeltotprice = new JLabel();
        labeltotprice.setBounds(220,410,150,25);
        add(labeltotprice);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(130,450,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(450,50,600,400);
        add(image1);
        
        try{
            Conn c = new Conn();
            String query = "select * from booked_hotel where username = '"+username+"'";
            ResultSet rs =c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelhotelname.setText(rs.getString("sel_hotel"));
                labelpersons.setText(rs.getString("persons")); 
                labelphone.setText(rs.getString("phone"));
                labeltotprice.setText(rs.getString("totalcost"));
                labeldays.setText(rs.getString("days"));
                labelroomtype.setText(rs.getString("roomtype"));
                labelfoodinc.setText(rs.getString("foodinc"));
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
           new ViewBookedHotel("dhruvpatwa16");
       }
}
