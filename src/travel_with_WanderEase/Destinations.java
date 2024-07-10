package travel_with_WanderEase;
import java.awt.*;
import javax.swing.*;

public class Destinations extends JFrame implements Runnable {
    Thread t1;
    JLabel[] label = new JLabel[10];
    JLabel caption;

    public void run() {
        String[] text = new String[]{
            "Darjeeling", 
            "Goa", 
            "Ladakh", 
            "Varanasi", 
            "Kerala", 
            "Agra",  
            "Delhi", 
            "Jammu & Kashmir", 
            "Alleppy"
        };

        try {
            for (int i = 0; i < 9; i++) { // Adjusted loop to iterate up to 9
                label[i].setVisible(true);
                caption.setText(text[i]);
                Thread.sleep(2500);
                label[i].setVisible(false);               
            }       
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Destinations() {
        setBounds(320,130, 900, 600);
        
        caption = new JLabel();
        caption.setBounds(50,470,1000,70);
        caption.setFont(new Font("Tahoma",Font.BOLD,40));
        caption.setForeground(Color.white);
        add(caption);
        
        ImageIcon[] image = new ImageIcon[10];
        Image[] jimage = new Image[10];
        ImageIcon[] kimage = new ImageIcon[10];

        for (int i = 0; i < 9; i++) {
            image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest" + (i + 1) + ".jpg"));
            jimage[i] = image[i].getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            label[i] = new JLabel(kimage[i]);
            label[i].setBounds(0, 0, 900, 600);
            add(label[i]);
        }
        t1 = new Thread(this);
        t1.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Destinations();
    }
}
