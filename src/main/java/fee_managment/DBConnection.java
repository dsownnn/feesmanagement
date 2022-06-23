/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fee_managment;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author dsown
 */
public class DBConnection {
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fees_management", "root", "son123456");
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return con;
    }
}
