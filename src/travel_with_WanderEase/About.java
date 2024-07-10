package travel_with_WanderEase;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    JButton back;
    About(){
        setBounds(600,200,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel l1 = new JLabel("About us:");
        l1.setBounds(20,40,100,40);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);

        String s = "About Our App\n" +
                "Welcome to WanderEase!\n" +
                "\n" +
                "At WanderEase, we're passionate about making travel and tourism seamless, enjoyable, and memorable. Whether you're a seasoned traveler or planning your first adventure, our app is designed to be your ultimate travel companion.\n" +
                "\n" +
                "Our Mission\n" +
                "To provide travelers with a comprehensive, user-friendly platform that simplifies planning, booking, and experiencing travel, all while offering personalized recommendations and insights to create unforgettable journeys.\n" +
                "\n" +
                "Features\n" +
                "Destination Discovery: Explore new and exciting destinations with our extensive database of travel guides, photos, and videos.\n" +
                "Itinerary Planner: Plan your trip with ease using our intuitive itinerary planner that allows you to organize your day-by-day activities.\n" +
                "Booking Services: Find and book flights, hotels, and tours directly through our app, ensuring you get the best deals.\n" +
                "Local Insights: Get insider tips and recommendations from locals and fellow travelers, including the best places to eat, visit, and stay.\n" +
                "Real-Time Updates: Stay informed with real-time updates on flight statuses, weather conditions, and travel advisories.\n" +
                "Reviews and Ratings: Read and write reviews on destinations, accommodations, and attractions to help the travel community make informed decisions.\n" +
                "Travel Community: Connect with other travelers, share your experiences, and find travel buddies through our social features.\n" +
                "Why Choose Us?\n" +
                "User-Friendly Interface: Our app is designed with simplicity and ease of use in mind, ensuring a smooth experience from start to finish.\n" +
                "Comprehensive Resources: We offer a wide range of resources to help you plan every aspect of your trip, all in one place.\n" +
                "Trusted by Travelers: Join thousands of satisfied users who rely on us for their travel needs.\n" +
                "Personalized Recommendations: Our app learns your preferences and provides tailored recommendations to enhance your travel experience.\n" +
                "Our Story\n" +
                "WanderEase was founded by a group of travel enthusiasts who wanted to create a better way to explore the world. Frustrated with the hassle of planning and booking travel, we set out to develop an app that would make the process easier, more enjoyable, and more efficient.\n" +
                "\n" +
                "Since our launch, we have been dedicated to continuously improving our app based on user feedback and the latest technology trends. Our goal is to be your go-to travel app, offering everything you need for a perfect trip in the palm of your hand.\n" +
                "\n" +
                "Get in Touch\n" +
                "We love hearing from our users! If you have any questions, feedback, or suggestions, please reach out to us at support.travelwithwanderease@hotmail.com. Follow us on social media to stay updated with the latest travel tips, news, and exclusive offers.\n" +
                "\n" +
                "Happy Travels!\n" +
                "\n" +
                "WanderEase Team.";

        TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(200,420,100,25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args) {
        new About();
    }
}
