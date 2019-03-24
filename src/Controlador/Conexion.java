package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
   private final String USER="root";
   private final String PASS="";
   private final String DB="proyecto";
   private final String URL="jdbc:mysql://localhost:3306/"+DB; 
   private final String Driver="com.mysql.jdbc.Driver";
   
   
   static Connection co;
   int con = 0;
   
   public Conexion() {
       
       try {
           Class.forName(Driver);
           co=DriverManager.getConnection(URL,USER,PASS);
           System.out.println("Conexion Exitosa "+con++);
       } catch (ClassNotFoundException ex) {
            
            System.out.println("Clase no encontrada, revise el conector "+ex.getMessage());
        } catch (SQLException ex) {
            
            System.out.println("Error al conectar "+ex.getMessage());
        } catch (Exception ex){
           System.out.println("tenemos algunos problemas " + ex.getMessage());
       }
   }
   
    public static Connection getConector() {
        return co;
    }
   
   public void CerrarCon(){
       try {
            co.close();
            //conectar().close();
       } catch (SQLException ex) {
           System.out.println("Error al cerrar la conexion");
       }
   }
  
}

