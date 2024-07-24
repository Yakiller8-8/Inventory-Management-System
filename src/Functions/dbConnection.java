/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author yali_il
 */
public class dbConnection {
    
    public static Connection getConnection(){
    Connection con = null;
    try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryManagementSystem","root","admin12345");
            
    }catch(Exception e){
        
    JOptionPane.showMessageDialog(null,e);
    }
    return con;
    }
}
    
