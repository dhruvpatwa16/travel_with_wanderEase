package travel_with_WanderEase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;
    JButton search,retrieve,back;
    ForgetPassword() {
        setBounds(350,250,850,380);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN SERIF",Font.BOLD, 20));
        lblusername.setBounds(40,20,100,25);
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setFont(new Font("SAN SERIF",Font.PLAIN, 18));
        tfusername.setBounds(160,20,200,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search = new JButton("Search");
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("SAN SERIF",Font.BOLD, 20));
        lblname.setBounds(40,60,100,25);
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setFont(new Font("SAN SERIF",Font.PLAIN, 18));
        tfname.setBounds(160,60,200,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblquestion = new JLabel("Security Q");
        lblquestion.setFont(new Font("SAN SERIF",Font.BOLD, 20));
        lblquestion.setBounds(40,100,100,25);
        p1.add(lblquestion);
        
        tfquestion = new JTextField();
        tfquestion.setFont(new Font("SAN SERIF",Font.PLAIN, 18));
        tfquestion.setBounds(160,100,200,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("SAN SERIF",Font.BOLD, 20));
        lblanswer.setBounds(40,140,100,25);
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setFont(new Font("SAN SERIF",Font.PLAIN, 18));
        tfanswer.setBounds(160,140,200,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.black);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("SAN SERIF",Font.BOLD, 20));
        lblpassword.setBounds(40,180,100,25);
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setFont(new Font("SAN SERIF",Font.BOLD, 18));
        tfpassword.setBounds(160,180,200,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(200,220,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        System.out.println("Action performed: " + ae.getActionCommand()); // Debug statement
        if(ae.getSource() == search){
               try{
                   String query = "select * from account where username = '"+tfusername.getText()+"'";
                   System.out.println("Query: " + query); // Debug statement
                   Conn c = new Conn();
                   ResultSet rs = c.s.executeQuery(query);  //method for DDL Commands
                   //ResultSet belongs to 'sql' package.
                   //rs stores whole row returned by the sql query.
                   while(rs.next()){
                       tfname.setText(rs.getString("name"));
                       tfquestion.setText(rs.getString("security"));
                   }
               }catch(Exception e){
                   e.printStackTrace();
                   JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());  //optional
               }
        }else if(ae.getSource() == retrieve){
             try{
                   String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
                   System.out.println("Query: " + query); // Debug statement
                   Conn c = new Conn();
                   ResultSet rs = c.s.executeQuery(query);  //method for DDL Commands
                   //ResultSet belongs to 'sql' package.
                   //rs stores whole row returned by the sql query.
                   while(rs.next()){
                       tfpassword.setText(rs.getString("password"));     
                   }
               }catch(Exception e){
                   e.printStackTrace();
                   JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());  //optional
               }
        }else{
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[]args){
        new ForgetPassword();
    }
}
