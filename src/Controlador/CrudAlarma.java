package Controlador;
import Modelo.Alarma;
import Modelo.Movimiento;
import Modelo.Sensores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudAlarma {
    
    
     
     public int registrarAlarma(Alarma a){
          Conexion co= new Conexion();
         int resultado=0;
         Alarma alarma= new Alarma();
         String sql="insert into alarma values (?,?,?,?)";
         try {
             PreparedStatement ps=co.getConector().prepareStatement(sql);
             ps.setInt(1,consultarId());
             ps.setString(2,a.getTipoalarma());
             ps.setString(3,a.getDescripcionalarma());
             ps.setString(4,a.getNombrealarma());
             resultado= ps.executeUpdate();
             co.CerrarCon();
         } catch (SQLException ex) {
             System.out.println("Error al tratar de insertar nueva alarma " + ex.getMessage());
         }
         return resultado;         
     }
     
     public String conTipoUsuario(){
         String resultado="";
             Conexion co = new Conexion();
             String sql= "select email from usuario where cargo='administrador'";
         try {
             Statement st= co.getConector().createStatement();
             ResultSet rs=st.executeQuery(sql);
             while(rs.next()){
                 resultado=rs.getString("email");
             }
         } catch (SQLException ex) {
             System.out.println("Error al consultar el correo del administrador "+ ex.getMessage());
         }
         return resultado;
     }
     
     public int conIdMovimiento(){
         Conexion co= new Conexion();
          String sql="select ID_Movimiento from movimiento";
          int n=0;
         try {
             Statement st= co.getConector().createStatement();
             ResultSet rs= st.executeQuery(sql);
             if(rs!=null){
             while (rs.next()) {
                 if (rs.getInt("ID_Movimiento")>n){
                     n=rs.getInt("ID_Movimiento");
                 }else{
                     n=0;
                 }
             }
             }
         } catch (SQLException ex) {
             System.out.println("Error al tratar de consultar id_Alarma " + ex.getMessage());
         }
         co.CerrarCon();
         return n+1;
     }
     
     
     public int reMovimiento(Movimiento m, Alarma a, Sensores se){
            Conexion co= new Conexion();
            int resultado=0;
             String sql="insert into movimiento values(?,?,?,?,?,?)";
         try {             
             PreparedStatement ps=co.getConector().prepareStatement(sql);
             ps.setInt(1,conIdMovimiento());
             ps.setString(2,m.getHora());
             ps.setString(3,m.getTipomovimiento());
             ps.setString(4,m.getFecha());
             ps.setInt(5,se.getIdsensor());
             ps.setInt(6,a.getIdalarma());
             resultado=ps.executeUpdate();
             
             System.out.println(conIdMovimiento()+"\n"+
                     m.getHora()+"\n"+
                     m.getTipomovimiento()+"\n"+
                     m.getFecha()+"\n"+
                     se.getIdsensor()+"\n"+
                     a.getIdalarma());
             co.CerrarCon();
         } catch (SQLException ex) {
             System.out.println("Error al registrar movimiento " + ex.getMessage());
         }
         return resultado;
     }
     
     
     
     
     
     
     public int consultarId(){
          Conexion co= new Conexion();
          String sql="select ID_Alarma from alarma";
          int n=0;
         try {
             Statement st= co.getConector().createStatement();
             ResultSet rs= st.executeQuery(sql);
             if(rs!=null){
             while (rs.next()) {
                 if (rs.getInt("ID_Alarma")>n){
                     n=rs.getInt("ID_Alarma");
                 }else{
                     n=0;
                 }
             }
             }
         } catch (SQLException ex) {
             System.out.println("Error al tratar de consultar id_Alarma " + ex.getMessage());
         }
         co.CerrarCon();
         return n+1;
     }
}
