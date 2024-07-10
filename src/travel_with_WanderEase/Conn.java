package travel_with_WanderEase;
import java.sql.*;
public class Conn {
        Connection c;
        Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","root123");
            s = c.createStatement();
        }catch(Exception e){
        e.printStackTrace();}
    }

//    public static void main(String[] args) {
//        new Conn();
//        System.out.println("Connection successful!");
//    }
}
