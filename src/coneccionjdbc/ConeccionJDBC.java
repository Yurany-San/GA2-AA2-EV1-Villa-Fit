
package coneccionjdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConeccionJDBC {
  
    public static void main(String[] args) {
       String usuario = "root"; 
       String password = "";
       String url = "jdbc:mysql://localhost:3306/villa_fit";
       Connection conexion;
       Statement statement;
       ResultSet rs;     
       
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            
            //consulta a la DB
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre"));
            }
                        
            //Insertar datos
            statement.execute("INSERT INTO `clientes`(`idClientes`, `nombre`, `edad`, `numero contacto`) VALUES ('7','Camila Caicedo','27','6073956846')");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre"));
            }
            
            //Actialización de datos
            statement.execute("UPDATE `clientes` SET `nombre` = 'Rosario Triana' , WHERE `clientes`.`idClientes` = 5;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre"));
            }

            //Eliminar datos 
            statement.execute("DELETE FROM `clientes` WEHERE `idClientes`=7");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre"));
            }
              
            
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
    }
    
}
