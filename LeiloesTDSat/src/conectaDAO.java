
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    
    public static Connection conn;
    
    public boolean conectar(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11", "root", "Ag20140166");
            System.out.println("Sucesso ao conectar ao banco de dados");    
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha nao conectar ao banco de dados");
            return false;
        }
    }
}
