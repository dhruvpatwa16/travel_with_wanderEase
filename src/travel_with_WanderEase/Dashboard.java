package travel_with_WanderEase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton addPersonalDetails, viewPersonalDetails,updatePersonalDetails,checkpackages,bookpackages,viewpackage,viewhotels,destinations,bookhotel,viewbookedhotel,payments,calculator,notepad,about,deletePersonalDetails;
    Dashboard(String username){
        this.username = username;
        //setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);    //for full screen frame
        setLayout(null);

        //Dashboard background
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(6,41,55));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard1.png"));
        Image i2 = i1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,65);
        p1.add(icon);
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD, 30));
        p1.add(heading);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(6,41,55));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));  //Insets(top,left,bottom,right);
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(6,41,55));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));  //Insets(top,left,bottom,right);
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(6,41,55));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,130));  //Insets(top,left,bottom,right);
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(6,41,55));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,40));  //Insets(top,left,bottom,right);
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);
        
        checkpackages = new JButton("Check Packages");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(6,41,55));
        checkpackages.setForeground(Color.white);
        checkpackages.setFont(new Font("Tahoma", Font.PLAIN,20));
        checkpackages.setMargin(new Insets(0,0,0,110));  //Insets(top,left,bottom,right);
        checkpackages.addActionListener(this);
        p2.add(checkpackages);
        
        bookpackages = new JButton("Book Package");
        bookpackages.setBounds(0,250,300,50);
        bookpackages.setBackground(new Color(6,41,55));
        bookpackages.setForeground(Color.white);
        bookpackages.setFont(new Font("Tahoma", Font.PLAIN,20));
        bookpackages.setMargin(new Insets(0,0,0,120));  //Insets(top,left,bottom,right);
        bookpackages.addActionListener(this);
        p2.add(bookpackages);
        
        viewpackage = new JButton("View Package");
        viewpackage.setBounds(0,300,300,50);
        viewpackage.setBackground(new Color(6,41,55));
        viewpackage.setForeground(Color.white);
        viewpackage.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewpackage.setMargin(new Insets(0,0,0,120));  //Insets(top,left,bottom,right);
        viewpackage.addActionListener(this);        
        p2.add(viewpackage);
        
        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setBackground(new Color(6,41,55));
        viewhotels.setForeground(Color.white);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,130));  //Insets(top,left,bottom,right);
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0,400,300,50);
        bookhotel.setBackground(new Color(6,41,55));
        bookhotel.setForeground(Color.white);
        bookhotel.setFont(new Font("Tahoma", Font.PLAIN,20));
        bookhotel.setMargin(new Insets(0,0,0,140));  //Insets(top,left,bottom,right);
        bookhotel.addActionListener(this);
        p2.add(bookhotel);
        
        viewbookedhotel = new JButton("View Booked Hotel");
        viewbookedhotel.setBounds(0,450,300,50);
        viewbookedhotel.setBackground(new Color(6,41,55));
        viewbookedhotel.setForeground(Color.white);
        viewbookedhotel.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewbookedhotel.setMargin(new Insets(0,0,0,70));  //Insets(top,left,bottom,right);
        viewbookedhotel.addActionListener(this);
        p2.add(viewbookedhotel);
        
        destinations = new JButton("Destinations");
        destinations.setBounds(0,500,300,50);
        destinations.setBackground(new Color(6,41,55));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma", Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,125));  //Insets(top,left,bottom,right);
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payments = new JButton("Payments");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(6,41,55));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma", Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,155));  //Insets(top,left,bottom,right);
        payments.addActionListener(this);
        p2.add(payments);
        
        calculator = new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(new Color(6,41,55));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma", Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,145));  //Insets(top,left,bottom,right);
        calculator.addActionListener(this);
        p2.add(calculator);
        
        notepad = new JButton("Notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(6,41,55));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma", Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,155));  //Insets(top,left,bottom,right);
        notepad.addActionListener(this);
        p2.add(notepad);
        
        about = new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(6,41,55));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma", Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,175));  //Insets(top,left,bottom,right);
        about.addActionListener(this);
        p2.add(about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home1.png"));
        Image i5 = i4.getImage().getScaledInstance(1450, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,850);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == addPersonalDetails){
                new AddCustomer(username);
            }    
            else if(ae.getSource() == viewPersonalDetails){
                new ViewCustomer(username);
            }else if(ae.getSource()== updatePersonalDetails){
                new UpdateCustomer(username);
            }
            else if(ae.getSource()== checkpackages){
                new CheckPackage();
            }else if(ae.getSource()== bookpackages){
                new BookPackage(username);
            }else if(ae.getSource() == viewpackage){
                new ViewPackage(username);
            }else if(ae.getSource() == viewhotels){
                new CheckHotels();
            }else if(ae.getSource() == destinations){
                new Destinations();
            }else if(ae.getSource() == bookhotel){
                new BookHotel(username);
            }else if(ae.getSource() == viewbookedhotel){
                new ViewBookedHotel(username);
            }
            else if(ae.getSource() == payments){
                new Payments(username);
            }
            else if(ae.getSource() == calculator){
                try{
                    Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(ae.getSource() == notepad){
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            else if(ae.getSource() == about){
                new About();
            }
            else if(ae.getSource() == deletePersonalDetails){
                new DeleteDetails(username);
            }
    }    
    public static void main(String[]args){
        new Dashboard("dhruvpatwa16");
    }
}
