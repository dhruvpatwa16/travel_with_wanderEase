package travel_with_WanderEase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class BookPackage extends JFrame implements ActionListener{
    Choice cpackage;
    JTextField tfpersons;
    JLabel labelusername,labelnumber,labelid,labelphone,labelprice;
    JButton checkprice,bookpackage,back;
    String username;
    
    BookPackage(String username){
        this.username = username;
       setBounds(350,200,1100,500);
       setLayout(null);
       getContentPane().setBackground(Color.white);
       
       JLabel text = new JLabel("BOOK PACKAGE");
       text.setBounds(40,20,200,30);
       text.setFont(new Font("Tahoma",Font.BOLD,20));
       add(text);
       
       JLabel lblusername = new JLabel("Username");
       lblusername.setFont(new Font("Tahoma",Font.BOLD,16));
       lblusername.setBounds(40,70,100,25);
       add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelusername.setBounds(250,70,200,25);
        add(labelusername);
        
        JLabel lblackage = new JLabel("Select Package");
        lblackage.setFont(new Font("Tahoma",Font.BOLD,16));
        lblackage.setBounds(40,110,150,25);
        add(lblackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,25);
        cpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cpackage);
        
        
        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setFont(new Font("Tahoma",Font.BOLD,16));
        lblperson.setBounds(40,150,150,25);
        add(lblperson);
        
        tfpersons = new JTextField("1");
        tfpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma",Font.BOLD,16));
        lblid.setBounds(40,190,150,25);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelid.setBounds(250,190,150,25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        lblnumber.setBounds(40,230,150,25);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.BOLD,16));
        lblphone.setBounds(40,270,150,25);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelphone.setBounds(250,270,150,25);
        add(labelphone);
        
        JLabel lbltotalpirce = new JLabel("Total Price");
        lbltotalpirce.setFont(new Font("Tahoma",Font.BOLD,16));
        lbltotalpirce.setBounds(40,310,150,25);
        add(lbltotalpirce);
        
        labelprice = new JLabel();
        labelprice.setFont(new Font("Tahoma",Font.BOLD,18));
        labelprice.setBounds(250,310,150,25);
        add(labelprice);
        
        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs =c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));      
                labelphone.setText(rs.getString("phone"));              
            }      
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(40,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(180,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(320,380,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(550,50,500,300);
        add(image1);
        
       setVisible(true); 
        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == checkprice){
                int cost = 0;
                String pack = cpackage.getSelectedItem();
                if(pack == "Gold Package"){
                    cost += 299999;
                }else if(pack == "Silver Package"){
                    cost += 199999;
                }else{
                    cost += 130999;
                }
                int count = Integer.parseInt(tfpersons.getText()) ;
                cost *= count;
                labelprice.setText("INR "+cost);
            }else if(ae.getSource() == bookpackage){
                try{
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into bookedpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                    JOptionPane.showMessageDialog(null,"Package Added for Checkout Successfully!");
                    setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                setVisible(false);
            }
        }
    public static void main(String[]args){
        new BookPackage("dhruvpatwa16");
    }
}
