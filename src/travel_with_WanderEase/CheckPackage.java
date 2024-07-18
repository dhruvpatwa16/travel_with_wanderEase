package travel_with_WanderEase;
import javax.swing.*;
import java.awt.*;
public class CheckPackage extends JFrame{
    CheckPackage(){
        setBounds(450,200,900,560);
        
        String [] package3 = {"BRONZE PACKAGE","4N/5D","Exotic Bali Summer Tour","-Balinese Massage","-Kintamani and Handara Gate Tour","-Bali Swing at Alas Harums","-Indian Meals (Lunch and Dinner)","-Cretya Day Club Entrance","-English Speaking Guide","-Nusa Penida West Island Tour","Summer Special Price @WanderEase : INR 1,30,999*","Bali","package3.png"};
        String [] package2 = {"SILVER PACKAGE","5N/6D","Spectacular Phuket Getaway","-Round Trip Flights","-4 Star Hotels","-Airport Transfers","-5 Activities","-Selected Meals","-Island Tour","-Ferry Transfer","Summer Special Price @WanderEase : INR 1,99,999*","Phuket","package2-1.jpg"};
        String[] package1 = {
                "GOLD PACKAGE",
                "6N/7D",
                "Exotic London Winter Tour",
                "- Thames River Cruise",
                "- Buckingham Palace Tour",
                "- London Eye Experience",
                "- English Meals (Lunch and Dinner)",
                "- Entrance to Madame Tussauds",
                "- English Speaking Guide",
                "- Day Trip to Stonehenge and Bath",
                "Winter Special Price @WanderEase : INR 2,99,999*",
                "London",
                "package1.jpg"
        };
        
        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null , p1);
        
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null , p2);
        
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null , p3);
        
        add(tab);
        setVisible(true);
    }
    public JPanel createPackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);
        
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(30,20,300,30);
        l1.setForeground(new Color(16, 44, 87));
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l1);
        
        JLabel d = new JLabel(pack[1]);
        d.setBounds(30,70,300,30);
        d.setForeground(new Color(16, 44, 87));
        d.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(d);
        
        JLabel l2 = new JLabel(pack[2]);
        l2.setBounds(30,115,300,30);
        l2.setForeground (new Color(37, 150, 190));
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l2);
        
        JLabel l3 = new JLabel(pack[3]);
        l3.setBounds(60,160,300,25);
        l3.setForeground (new Color(22,90,114));
        l3.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(l3);
        
        JLabel l4 = new JLabel(pack[4]);
        l4.setBounds(60,190,300,25);
        l4.setForeground (new Color(22,90,114));
        l4.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(l4);
        
        JLabel l5 = new JLabel(pack[5]);
        l5.setBounds(60,220,300,25);
        l5.setForeground (new Color(22,90,114));
        l5.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(l5);
             
        JLabel l6 = new JLabel(pack[6]);
        l6.setBounds(60,250,300,25);
        l6.setForeground (new Color(22,90,114));
        l6.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(l6);
        
        JLabel l7 = new JLabel(pack[7]);
        l7.setBounds(60,280,300,25);
        l7.setForeground (new Color(22,90,114));  
        l7.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(l7);
        
        JLabel l8 = new JLabel(pack[8]);
        l8.setBounds(60,310,300,25);
        l8.setForeground (new Color(22,90,114));
        l8.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(l8);
        
        JLabel l9 = new JLabel(pack[9]);
        l9.setBounds(60,340,300,25);
        l9.setForeground (new Color(22,90,114));
        l9.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(l9);
        
        //price description
        JLabel l10 = new JLabel(pack[10]);
        l10.setBounds(35,400,900,40);
        l10.setForeground (new Color(22,90,114));
        l10.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l10);

        //IMAGE DESC
        JLabel l11 = new JLabel(pack[11]);
        l11.setBounds(500,330,200,30);
        l11.setForeground (new Color(22,90,114));
        l11.setFont(new Font("Tahoma",Font.BOLD,30));
        l11.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(l11);
              
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+ pack[12]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,20,525,300);
        p1.add(image);
        
        return p1;
    }  
    public static void main(String[]args){
        new CheckPackage();
    }
}
