
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
            
           

        }    //Insertar datos
            statement.execute("INSERT INTO `clientes` (`nombre`, `edad`) VALUES ('Camila Caicedo','27')");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre")+" "+rs.getInt("edad"));
            }
     
            //Actialización de datos
            statement.execute("UPDATE `clientes` SET `nombre` = 'Maria' , `edad` = '18' WHERE `clientes`.`idClientes` = 7; ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre")+" "+rs.getInt("edad"));
            }
            
            //Eliminar Datos 
            statement.execute("DELETE FROM `clientes` WHERE `clientes`.`idClientes`= 11 ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre")+" "+rs.getInt("edad"));
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
