package travel_with_WanderEase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class Payments extends JFrame implements ActionListener{
    JButton pay,back;
    Payments(){
        setBounds(400,100,800,600);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,600);
        add(image);
        
        pay = new JButton("Pay");
        pay.setBounds(370,350,60,30);
        pay.setBackground(new Color(4,46,111));
        pay.setForeground(Color.white);
        pay.addActionListener(this);
        image.add(pay);
        
        back = new JButton("Back");
        back.setBounds(25,20,80,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == pay){
                try {
                    // Open the default browser with the specified URL
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/dhruv-patwa-701357230/"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }else{
                setVisible(false);
            }
        }
    
    public static void main(String[]args){
        new Payments();
    }
}
