
package travel_with_WanderEase;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //for ActionListener
public class Signup extends JFrame implements ActionListener{
    
    JButton create,back;
    JTextField tfusername,tfname,tfpassword,tfanswer;
    Choice security;
    
    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(68,161,189));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        JLabel text = new JLabel("Sign up");
        text.setBounds(20,17,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,24));
        p1.add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN SERIF",Font.BOLD, 20));
        lblusername.setBounds(50,60,125,25);
        p1.add(lblusername);
        
        //JTextField tfusername = new JTextField(); // local declaration
        tfusername = new JTextField();  //global declaration
        tfusername.setBounds(190, 60, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setFont(new Font("SAN SERIF",Font.PLAIN, 18));
        p1.add(tfusername);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("SAN SERIF",Font.BOLD, 20));
        lblname.setBounds(50,100,125,25);
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(190, 100, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        tfname.setFont(new Font("SAN SERIF",Font.PLAIN, 18));
        p1.add(tfname);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("SAN SERIF",Font.BOLD, 20));
        lblpassword.setBounds(50,140,125,25);
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(190, 140, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.setFont(new Font("SAN SERIF",Font.PLAIN, 18));
        p1.add(tfpassword);
        
        JLabel lblsecurity = new JLabel("Security Q.");
        lblsecurity.setFont(new Font("SAN SERIF",Font.BOLD, 20));
        lblsecurity.setBounds(50,180,125,25);
        p1.add(lblsecurity);
        
        security = new Choice();
        security.add("Favourite Color");
        security.add("Best Friend");
        security.add("Favourite Teacher");
        security.setBounds(190,180,180,25);
        security.setFont(new Font("Arial", Font.PLAIN, 16));
        p1.add(security);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("SAN SERIF",Font.BOLD, 20));
        lblanswer.setBounds(50,220,125,25);
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(190, 220, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        tfanswer.setFont(new Font("SAN SERIF",Font.PLAIN, 18));
        p1.add(tfanswer);
        
        //JButton create = new JButton("Create");    //local declaration
        create = new JButton("Create");             //global declaration
        create.setBackground(Color.WHITE);
        create.setForeground(Color.BLACK);
        create.setFont(new Font("Tahoma", Font.PLAIN, 16));
        create.setBounds(80,270,100,30);
        create.addActionListener(this); //internally calls actionPerformed() function
        p1.add(create);
        
        //JButton back = new JButton("Back");      //local declaration
        back = new JButton("Back");                //global declaration
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Tahoma", Font.PLAIN, 16));
        back.setBounds(250,270,100,30);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        back.addActionListener(this);
        add(image);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();
            
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')"; 
            try{
                
                Conn c = new Conn();
                c.s.executeUpdate(query);   //to execute the mysql query.//METHOD FOR DML COMMANDS
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Login();  //object of Login class is created and class Constructor will be called 
        }
    }
    
    public static void main(String[]args){
        new Signup();
    }
}
