package travel_with_WanderEase;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    public void run(){
        try{
            //done for progress bar
            for(int i = 0; i <= 101; i++){
                    int max = bar.getMaximum(); //100
                    int value = bar.getValue();
                    
                    if(value < max){  //101 < 100
                        bar.setValue(bar.getValue() + 1);
                    }else{
                          setVisible(false);
                          new Dashboard(username);  //for default name field in dashboard options
                          break;
                    }
                    Thread.sleep(50);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        this.username = username;       //local variable is stored in global variable
        t = new Thread(this);
        
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Travel with WanderEase App");
        text.setBounds(70,20,600,40);
        text.setForeground(new Color(24,91,117));
        text.setFont(new Font("Raleway", Font.BOLD,35));
        add(text);
        
        JLabel loading = new JLabel("Loading, Please wait...");
        loading.setBounds(220,130,200,30);
        loading.setForeground(new Color(50,111,124));
        loading.setFont(new Font("Raleway", Font.BOLD,16));
        add(loading);
        
        JLabel lblusername = new JLabel("Welcome "+ username);
        lblusername.setBounds(20,310,500,40);
        lblusername.setForeground(new Color(24,91,117));
        lblusername.setFont(new Font("Raleway", Font.BOLD,35));
        add(lblusername);
        
        bar = new JProgressBar();
        bar.setBounds(150,100,300,25);
        bar.setStringPainted(true);
        add(bar);
        
        t.start();
        setVisible(true);
    }
    public static void main(String []args){
        new Loading("");
    }
}
