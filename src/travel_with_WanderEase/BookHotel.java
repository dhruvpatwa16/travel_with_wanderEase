package travel_with_WanderEase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class BookHotel extends JFrame implements ActionListener{
    Choice chotel,cac,cfood;
    JTextField tfpersons,tfdays;
    JLabel labelusername,labelnumber,labelid,labelphone,labelprice;
    JButton checkprice,bookhotel,back;
    String username;
    
    BookHotel(String username){
        this.username = username;
       setBounds(350,200,1100,600);
       setLayout(null);
       getContentPane().setBackground(Color.white);
       
       JLabel text = new JLabel("BOOK HOTEL");
       text.setBounds(40,20,200,30);
       text.setFont(new Font("Tahoma",Font.BOLD,25));
       add(text);
       
       JLabel lblusername = new JLabel("Username");
       lblusername.setFont(new Font("Tahoma",Font.BOLD,16));
       lblusername.setBounds(40,70,100,25);
       add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelusername.setBounds(250,70,200,25);
        add(labelusername);
        
        JLabel lblhotels = new JLabel("Select Hotel");
        lblhotels.setFont(new Font("Tahoma",Font.BOLD,16));
        lblhotels.setBounds(40,110,150,25);
        add(lblhotels);
        
        chotel = new Choice();
        chotel.setBounds(250,110,200,25);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("hotel_name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        chotel.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(chotel);
        
        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setFont(new Font("Tahoma",Font.BOLD,16));
        lblperson.setBounds(40,150,150,25);
        add(lblperson);
        
        tfpersons = new JTextField("1");
        tfpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma",Font.BOLD,16));
        lbldays.setBounds(40,190,150,25);
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setFont(new Font("Tahoma",Font.PLAIN,16));
        tfdays.setBounds(250,190,200,25);
        add(tfdays);
        
        JLabel lblcac = new JLabel("AC/Non-AC");
        lblcac.setFont(new Font("Tahoma",Font.BOLD,16));
        lblcac.setBounds(40,230,150,25);
        add(lblcac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,200,25);
        cac.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma",Font.BOLD,16));
        lblfood.setBounds(40,270,150,25);
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,25);
        cfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cfood);
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma",Font.BOLD,16));
        lblid.setBounds(40,310,150,25);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelid.setBounds(250,310,150,25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        lblnumber.setBounds(40,350,150,25);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelnumber.setBounds(250,350,150,25);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.BOLD,16));
        lblphone.setBounds(40,390,150,25);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelphone.setBounds(250,390,150,25);
        add(labelphone);
        
        JLabel lbltotalpirce = new JLabel("Total Price");
        lbltotalpirce.setFont(new Font("Tahoma",Font.BOLD,16));
        lbltotalpirce.setBounds(40,430,150,25);
        add(lbltotalpirce);
        
        labelprice = new JLabel();
        labelprice.setFont(new Font("Tahoma",Font.BOLD,18));
        labelprice.setBounds(250,430,150,25);
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
        checkprice.setBounds(50,480,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBackground(Color.black);
        bookhotel.setForeground(Color.white);
        bookhotel.setBounds(190,480,120,25);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(330,480,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(550,120,500,300);
        add(image1);
        
       setVisible(true); 
        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == checkprice){
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from hotel where hotel_name = '"+chotel.getSelectedItem()+"'");
                    while(rs.next()){
                        int costpp = Integer.parseInt(rs.getString("costperperson"));
                        int food = Integer.parseInt(rs.getString("foodinc"));
                        int ac = Integer.parseInt(rs.getString("acroom"));
                        
                        int persons = Integer.parseInt(tfpersons.getText());
                        int days = Integer.parseInt(tfdays.getText());
                        
                        String acsel = cac.getSelectedItem();
                        String foodsel = cfood.getSelectedItem();
                        
                        if(persons * days > 0){
                            int totalcost = 0;
                            if(acsel.equals("AC")){
                                totalcost += ac;       //pp
                            }
                            if(foodsel.equals("Yes")){
                                totalcost += food;  //pp
                            }
                            totalcost += costpp; //for base price of hotel pp     
                            totalcost = totalcost * persons * days;
                            labelprice.setText("INR "+ totalcost);
                        }else{
                            JOptionPane.showMessageDialog(null,"Please enter a valid number!");
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(ae.getSource() == bookhotel) {
      try {
        // Check if labelprice has a value
        if (!labelprice.getText().isEmpty()) {
            Conn c = new Conn();
            c.s.executeUpdate("insert into booked_hotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
            JOptionPane.showMessageDialog(null,"Hotel Booked Successfully!");
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null,"Please select a hotel and calculate the price first!");
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
}
else{
                setVisible(false);
            }
        }
    public static void main(String[]args){
        new BookHotel("dhruvpatwa16");
    }
}
