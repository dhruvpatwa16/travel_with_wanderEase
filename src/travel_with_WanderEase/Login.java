package travel_with_WanderEase;
import java.awt.Color;
import java.awt.Image;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*; //border is sub-package of swing so it needs to be imported separately.
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    JTextField tfusername, tfpassword;
    JButton login, signup,forgotpassword;
    Login(){
    setSize(900,400);
    setLocation(350,200);
    setLayout(null);
    
    getContentPane().setBackground(Color.WHITE); //TAKES WHOLE PANEL
    
    JPanel p1 = new JPanel();
    p1.setBackground(new Color(131,193,233));
    p1.setBounds(0, 0, 400, 400);  // won't work if set Layout isn't null
    p1.setLayout(null);
    add(p1);
    
    JPanel p2 = new JPanel();
    p2.setLayout(null);
    p2.setBounds(400,30,450,300);
    add(p2);
    
    JLabel lblusername = new JLabel("Username");
    lblusername.setBounds(60,20,100,25);
    lblusername.setFont(new Font("SAN SERIF",Font.BOLD, 20));
    p2.add(lblusername);
    
    tfusername = new JTextField();
    tfusername.setBounds(60,60,300,30);
    tfusername.setBorder(BorderFactory.createEmptyBorder());
    tfusername.setFont(new Font("SAN SERIF",Font.PLAIN, 20));
    p2.add(tfusername);
    
    JLabel lblpassword = new JLabel("Password");
    lblpassword.setBounds(60,110,100,25);
    lblpassword.setFont(new Font("SAN SERIF",Font.BOLD, 20));
    p2.add(lblpassword);
    
    tfpassword = new JTextField();
    tfpassword.setBounds(60,150,300,30);
    tfpassword.setFont(new Font("SAN SERIF",Font.PLAIN, 20));
    tfpassword.setBorder(BorderFactory.createEmptyBorder());
    p2.add(tfpassword);
    
    login = new JButton("Login");
    login.setBounds(60,200,130,30);
    login.setBackground(new Color(133,193,233));
    login.setForeground(Color.WHITE);
    login.setBorder(new LineBorder(new Color(133,193,233)));
    login.addActionListener(this);
    p2.add(login);
    
    signup = new JButton("Signup");
    signup.setBounds(230,200,130,30);
    signup.setBackground(new Color(133,193,233));
    signup.setForeground(Color.WHITE);
    signup.setBorder(new LineBorder(new Color(133,193,233)));
    signup.addActionListener(this);
    p2.add(signup);
    
    forgotpassword = new JButton("Forgot Password?");
    forgotpassword.setBounds(140,250,130,30);
    forgotpassword.setBackground(new Color(133,193,233));
    forgotpassword.setForeground(Color.WHITE);
    forgotpassword.setBorder(new LineBorder(new Color(133,193,233)));
    forgotpassword.addActionListener(this);
    p2.add(forgotpassword);

    JLabel text = new JLabel("Login");
    text.setBounds(40,50,200,30);
    text.setFont(new Font("Tahoma",Font.BOLD,20));
    p1.add(text);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
    Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(100,120,200,200);
    p1.add(image);
    
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
            if(ae.getSource() == login){
            try{
                String username = tfusername.getText();
                String password = tfpassword.getText();
                
                String query = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);  //for displaying the name on Loading frame
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
                
            }catch(Exception e){
            e.printStackTrace();
        }
            }
            else if(ae.getSource() == signup){
                setVisible(false);
                new Signup();
            }else{
                setVisible(false);
              new ForgetPassword();
            }
        }
    public static void main(String[]args){
        new Login(); //annonymous object
    }
}
