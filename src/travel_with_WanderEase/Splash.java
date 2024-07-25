package travel_with_WanderEase;

import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame implements Runnable{
    Thread thread; //declaration
    Splash(){
        //setSize(1200,600);
        //setLocation(200,100);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); //Only ImageIcon object can be used here and not Image object
        add(image);
        
        setVisible(true);
        thread = new Thread(this);
        thread.start(); //will call run() method (for multithreading)
    }
    public void run(){
        //overridden from Runnable interface
        //either override this or make Splash class 'abstract'
        try{
            Thread.sleep(7000);  //to close the opened frame and go to Login page.
            setVisible(false);
            new Login(); // Call the Login class here
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arsg){
        Splash frame = new Splash();
        int x = 1;
        for(int i = 1; i<=500; x+= 7, i+=6) {
            frame.setLocation(750 - (x + i) / 2, 400 - (i / 2));
            frame.setSize(x + i, i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
   }
}
