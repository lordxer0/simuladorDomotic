package Controlador;

import Modelo.Alarma;
import Modelo.Ambiente;
import Modelo.Componentes;
import Modelo.Movimiento;
import Modelo.Sede;
import Modelo.Sensores;
import Vista.Ambientev;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Crud extends Thread {

    static JTable c;
    static JTable ca;
    JTextField e;
    JTextField n;

    public Crud() {
    }

    public Crud(JTextField e, JTextField n) {
        this.e = e;
        this.n = n;

    }

    public Crud(JTable ca) {

        Crud.ca = ca;

    }

    Conexion co = new Conexion();

    /*
    public void llenarTabla(){
        
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("COMPONENTE");
        modelo.addColumn("ESTADO_COMPONENTE");
        modelo.addColumn("TIPO");
        modelo.addColumn("AMBIENTE");
        modelo.addColumn("UBICACION");
        modelo.addColumn("ESTADO_AMBIENTE");
        modelo.addColumn("TIPO_AMBIENTE");
        modelo.addColumn("SEDE");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("CIUDAD");
        modelo.addColumn("TELEFONO");
        
        
        ArrayList<Componentes> resultado = consultaCom();
        for (Componentes componente : resultado) {
            modelo.addRow(new String[]{String.valueOf(componente.getNombre()),
               componente.getEstado()+"",
               componente.getTipo() + "",
               componente.getIdambiente().getNombre()+"",
               componente.getIdambiente().getUbicacion()+"",
               componente.getIdambiente().getEstado()+"",
               componente.getIdambiente().getTipoambiente()+"",
               componente.getIdambiente().getIdsede().getNombre()+"",
               componente.getIdambiente().getIdsede().getDireccion()+"",
               componente.getIdambiente().getIdsede().getCiudad()+"",
               componente.getIdambiente().getIdsede().getTelefono()});
           
        }
        
        c.setModel(modelo);
    }
     */
    public void llenarTabla2() {
        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("TIPO_ALARMA");
        modelo1.addColumn("DESCRIPCION_ALARMA");
        modelo1.addColumn("NOMBRE_ALARMA");
        modelo1.addColumn("TIPO_SENSOR");
        modelo1.addColumn("NOMBRE_SENSOR");
        modelo1.addColumn("HORA");
        modelo1.addColumn("TIPO_MOVIMIENTO");
        modelo1.addColumn("FECHA");
        ArrayList<Movimiento> resultado = conCompo();
        for (Movimiento movimiento : resultado) {
            modelo1.addRow(new String[]{String.valueOf(movimiento.getIdalarma().getTipoalarma()),
                movimiento.getIdalarma().getDescripcionalarma() + "",
                movimiento.getIdalarma().getNombrealarma() + "",
                movimiento.getIdsensores().getTiposensor() + "",
                movimiento.getIdsensores().getNombresensor() + "",
                movimiento.getHora() + "",
                movimiento.getTipomovimiento() + "",
                movimiento.getFecha()});
        }
        ca.setModel(modelo1);
    }

    public ArrayList<Movimiento> conCompo() {
        Conexion.getConector();
        ArrayList<Movimiento> res = new ArrayList();

        String sql = "select a.tipoalarma,a.descripcionalarma,a.nombrealarma,"
                + "sen.tiposensor,sen.nombresensor,"
                + "mo.hora,mo.tipomovimiento,mo.fecha from movimiento mo "
                + " INNER JOIN alarma a "
                + " on a.ID_Alarma=mo.ID_Alarma"
                + " INNER JOIN sensores sen "
                + " on sen.ID_Sensor=mo.ID_Sensores";

        try {
            Statement st = Conexion.getConector().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Modelo.Movimiento mo = new Movimiento();
                Modelo.Alarma al = new Alarma();
                Modelo.Sensores sen = new Sensores();
                al.setTipoalarma(rs.getString("tipoalarma"));
                al.setDescripcionalarma(rs.getString("descripcionalarma"));
                al.setNombrealarma(rs.getString("nombrealarma"));
                sen.setTiposensor(rs.getString("tiposensor"));
                sen.setNombresensor(rs.getString("nombresensor"));
                mo.setHora(rs.getString("Hora"));
                mo.setTipomovimiento(rs.getString("tipomovimiento"));
                mo.setFecha(rs.getString("fecha"));
                mo.setIdalarma(al);
                mo.setIdsensores(sen);
                res.add(mo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public ArrayList<Componentes> componente() {
        //Conexion co= new Conexion();
        ArrayList<Componentes> cons = new ArrayList();
        try {
            String sql = "select * from componentes where abrir_cerrar='abrir'";
            Statement st = Conexion.getConector().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Componentes p = new Componentes();
                p.setEstado(rs.getString("estado"));
                p.setNombre(rs.getString("nombre"));
                p.setTipo(rs.getString("tipo"));
                p.setIdentificador(rs.getInt("identificador"));
                p.setAbrir_cerrar(rs.getString("abrir_cerrar"));
                cons.add(p);
                System.out.println("componente activo " + rs.getString("nombre"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("error");
        } catch (NullPointerException ex) {
            System.out.println("array nulo " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("hola");
        }
        return cons;
    }

    public ArrayList<Componentes> componenteCerrar() {
        //Conexion co= new Conexion();
        ArrayList<Componentes> cons = new ArrayList();
        try {
            String sql = "select * from componentes where abrir_cerrar='cerrar'";
            Statement st = Conexion.getConector().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Componentes c = new Componentes();
                c.setEstado(rs.getString("estado"));
                c.setNombre(rs.getString("nombre"));
                c.setTipo(rs.getString("tipo"));
                c.setIdentificador(rs.getInt("identificador"));
                c.setAbrir_cerrar(rs.getString("abrir_cerrar"));
                cons.add(c);
                System.out.println("componente activo " + rs.getString("nombre"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("error");
        } catch (NullPointerException ex) {
            System.out.println("array nulo " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("hola");
        }
        return cons;
    }

    public ArrayList<Componentes> componenteAll() {
        //Conexion co= new Conexion();
        ArrayList<Componentes> cons = new ArrayList();
        try {
            String sql = "select * from componentes";
            Statement st = Conexion.getConector().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Componentes c = new Componentes();
                c.setIdcomponente(rs.getInt("ID_Componentes"));
                c.setEstado(rs.getString("estado"));
                c.setNombre(rs.getString("nombre"));
                c.setTipo(rs.getString("tipo"));
                c.setIdentificador(rs.getInt("identificador"));
                c.setAbrir_cerrar(rs.getString("abrir_cerrar"));
                cons.add(c);
                System.out.println("componente activo " + rs.getString("nombre"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("error");
        } catch (NullPointerException ex) {
            System.out.println("array nulo " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("hola");
        }
        return cons;
    }

    @Override
    public void run() {
        //EstadoVentilador es= new EstadoVentilador();
        Ambientev amv = new Ambientev();
        amv.fondo.setVisible(true);
        amv.abrirPuerta.setVisible(false);
        amv.abrirPuertaAire.setVisible(false);
        amv.apagarLUZ.setVisible(false);
        amv.apagarLUZaire.setVisible(false);
        amv.cerrarPuerta.setVisible(false);
        amv.cerrarPuertaAire.setVisible(false);
        amv.encenderLUZ.setVisible(false);
        amv.encenderLUZaire.setVisible(false);

        String estado = "";
        while (0 < 1) {
            try {
                ArrayList<Componentes> componenteAll1 = componenteAll();
                amv.setVisible(true);
                llenarTabla2();

                if ((componenteAll1.get(0).getIdcomponente() == 1) && (componenteAll1.get(0).getAbrir_cerrar().equals("ON"))) {
                    if ((componenteAll1.get(1).getIdcomponente() == 2) && (componenteAll1.get(1).getAbrir_cerrar().equals("ON"))) {
                        if ((componenteAll1.get(2).getIdcomponente() == 3) && (componenteAll1.get(2).getAbrir_cerrar().equals("ON"))) {

                            amv.fondo.setVisible(false);
                            amv.abrirPuerta.setVisible(false);
                            amv.apagarLUZ.setVisible(false);
                            amv.apagarLUZaire.setVisible(false);
                            amv.cerrarPuerta.setVisible(false);
                            amv.cerrarPuertaAire.setVisible(false);
                            amv.encenderLUZ.setVisible(false);
                            amv.encenderLUZaire.setVisible(false);
                            amv.abrirPuertaAire.setVisible(true);

                        }
                    }
                }
                
                if ((componenteAll1.get(0).getIdcomponente() == 1) && (componenteAll1.get(0).getAbrir_cerrar().equals("ON"))) {
                    if ((componenteAll1.get(1).getIdcomponente() == 2) && (componenteAll1.get(1).getAbrir_cerrar().equals("ON"))) {
                        if ((componenteAll1.get(2).getIdcomponente() == 3) && (componenteAll1.get(2).getAbrir_cerrar().equals("OFF"))) {

                            amv.fondo.setVisible(false);
                            amv.abrirPuerta.setVisible(false);
                            amv.apagarLUZ.setVisible(false);
                            amv.apagarLUZaire.setVisible(false);
                            amv.cerrarPuerta.setVisible(false);
                            amv.cerrarPuertaAire.setVisible(false);
                            amv.encenderLUZ.setVisible(false);
                            amv.abrirPuertaAire.setVisible(false);
                            amv.encenderLUZaire.setVisible(true);

                        }
                    }
                }
                
                if ((componenteAll1.get(0).getIdcomponente() == 1) && (componenteAll1.get(0).getAbrir_cerrar().equals("ON"))) {
                    if ((componenteAll1.get(1).getIdcomponente() == 2) && (componenteAll1.get(1).getAbrir_cerrar().equals("OFF"))) {
                        if ((componenteAll1.get(2).getIdcomponente() == 3) && (componenteAll1.get(2).getAbrir_cerrar().equals("ON"))) {

                            amv.fondo.setVisible(false);
                            amv.apagarLUZ.setVisible(false);
                            amv.apagarLUZaire.setVisible(false);
                            amv.cerrarPuerta.setVisible(false);
                            amv.cerrarPuertaAire.setVisible(false);
                            amv.abrirPuertaAire.setVisible(false);
                            amv.encenderLUZaire.setVisible(false);
                            amv.encenderLUZ.setVisible(false);
                            amv.abrirPuerta.setVisible(true);
                        }
                    }
                }
                
                if ((componenteAll1.get(0).getIdcomponente() == 1) && (componenteAll1.get(0).getAbrir_cerrar().equals("ON"))) {
                    if ((componenteAll1.get(1).getIdcomponente() == 2) && (componenteAll1.get(1).getAbrir_cerrar().equals("OFF"))) {
                        if ((componenteAll1.get(2).getIdcomponente() == 3) && (componenteAll1.get(2).getAbrir_cerrar().equals("OFF"))) {

                            amv.fondo.setVisible(false);
                            amv.apagarLUZ.setVisible(false);
                            amv.apagarLUZaire.setVisible(false);
                            amv.cerrarPuerta.setVisible(false);
                            amv.cerrarPuertaAire.setVisible(false);
                            amv.abrirPuertaAire.setVisible(false);
                            amv.encenderLUZaire.setVisible(false);
                            amv.abrirPuerta.setVisible(false);
                            amv.encenderLUZ.setVisible(true);
                        }
                    }
                }
                
                if ((componenteAll1.get(0).getIdcomponente() == 1) && (componenteAll1.get(0).getAbrir_cerrar().equals("OFF"))) {
                    if ((componenteAll1.get(1).getIdcomponente() == 2) && (componenteAll1.get(1).getAbrir_cerrar().equals("ON"))) {
                        if ((componenteAll1.get(2).getIdcomponente() == 3) && (componenteAll1.get(2).getAbrir_cerrar().equals("OFF"))) {

                            amv.fondo.setVisible(false);
                            amv.apagarLUZ.setVisible(false);
                            amv.cerrarPuerta.setVisible(false);
                            amv.cerrarPuertaAire.setVisible(false);
                            amv.abrirPuertaAire.setVisible(false);
                            amv.encenderLUZaire.setVisible(false);
                            amv.abrirPuerta.setVisible(false);
                            amv.encenderLUZ.setVisible(false);
                            amv.apagarLUZaire.setVisible(true);
                        }
                    }
                }
                
                if ((componenteAll1.get(0).getIdcomponente() == 1) && (componenteAll1.get(0).getAbrir_cerrar().equals("OFF"))) {
                    if ((componenteAll1.get(1).getIdcomponente() == 2) && (componenteAll1.get(1).getAbrir_cerrar().equals("OFF"))) {
                        if ((componenteAll1.get(2).getIdcomponente() == 3) && (componenteAll1.get(2).getAbrir_cerrar().equals("OFF"))) {

                            amv.fondo.setVisible(false);
                            amv.cerrarPuerta.setVisible(false);
                            amv.cerrarPuertaAire.setVisible(false);
                            amv.abrirPuertaAire.setVisible(false);
                            amv.encenderLUZaire.setVisible(false);
                            amv.abrirPuerta.setVisible(false);
                            amv.encenderLUZ.setVisible(false);
                            amv.apagarLUZaire.setVisible(false);
                            amv.apagarLUZ.setVisible(true);
                        }
                    }
                }
                
                if ((componenteAll1.get(0).getIdcomponente() == 1) && (componenteAll1.get(0).getAbrir_cerrar().equals("OFF"))) {
                    if ((componenteAll1.get(1).getIdcomponente() == 2) && (componenteAll1.get(1).getAbrir_cerrar().equals("ON"))) {
                        if ((componenteAll1.get(2).getIdcomponente() == 3) && (componenteAll1.get(2).getAbrir_cerrar().equals("ON"))) {

                            amv.fondo.setVisible(false);
                            amv.cerrarPuerta.setVisible(false);
                            amv.cerrarPuertaAire.setVisible(false);
                            amv.abrirPuertaAire.setVisible(false);
                            amv.encenderLUZaire.setVisible(false);
                            amv.abrirPuerta.setVisible(false);
                            amv.encenderLUZ.setVisible(false);
                            amv.apagarLUZ.setVisible(false);
                            amv.apagarLUZaire.setVisible(true);
                        }
                    }
                }
                
                if ((componenteAll1.get(0).getIdcomponente() == 1) && (componenteAll1.get(0).getAbrir_cerrar().equals("OFF"))) {
                    if ((componenteAll1.get(1).getIdcomponente() == 2) && (componenteAll1.get(1).getAbrir_cerrar().equals("OFF"))) {
                        if ((componenteAll1.get(2).getIdcomponente() == 3) && (componenteAll1.get(2).getAbrir_cerrar().equals("ON"))) {

                            amv.cerrarPuerta.setVisible(false);
                            amv.cerrarPuertaAire.setVisible(false);
                            amv.abrirPuertaAire.setVisible(false);
                            amv.encenderLUZaire.setVisible(false);
                            amv.abrirPuerta.setVisible(false);
                            amv.encenderLUZ.setVisible(false);
                            amv.apagarLUZaire.setVisible(false);
                            amv.apagarLUZ.setVisible(false);
                            amv.fondo.setVisible(true);
                        }
                    }
                }

                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                System.out.println("Error en el hilo");
            } catch (IndexOutOfBoundsException | NullPointerException ex) {
                System.out.println("no pasa nada");
            } catch (Exception ex) {
                System.out.println("funsiona como full HD");
            }
        }
    }

    public static void main(String[] args) {
        Crud cr = new Crud(ca);
        cr.start();
    }
}
//
/*
switch (h1) {
                case 0:
                    if(componente().size()>0){
                        if((componente().get(0).getIdentificador()==1)&&componente().get(0).getAbrir_cerrar().equals("abrir")){
                            
                        }if( (componente().get(0).getIdentificador()==2)&&componente().get(0).getAbrir_cerrar().equals("abrir")){
                            
                        }if((componente().get(0).getIdentificador()==3)&&componente().get(0).getAbrir_cerrar().equals("abrir")){
                            
                        }if((componente().get(0).getIdentificador()==4)&&componente().get(0).getAbrir_cerrar().equals("abrir")){
                            amv.lblFondo.setVisible(false);
                            amv.lblTres.setVisible(true);
                            amv.setVisible(true);
                            amv.panel1.setVisible(true);
                            JOptionPane.showMessageDialog(null,"abrio bien hola");
                        }
                        amv.setVisible(true);
                        llenarTabla2();
                        h1=1;
                    }else{
                        h1=1;
                    } break;
                case 1:
                    if(componenteCerrar().size()>0) {
                        if((componenteCerrar().get(0).getIdentificador()==1)&&componenteCerrar().get(0).getAbrir_cerrar().equals("cerrar")){
                            
                        }if( (componenteCerrar().get(0).getIdentificador()==2)&&componenteCerrar().get(0).getAbrir_cerrar().equals("cerrar")){
                            
                        }if((componenteCerrar().get(0).getIdentificador()==3)&&componenteCerrar().get(0).getAbrir_cerrar().equals("cerrar")){
                            
                        }if((componenteCerrar().get(0).getIdentificador()==4)&&componenteCerrar().get(0).getAbrir_cerrar().equals("cerrar")){                  
                       
                            JOptionPane.showMessageDialog(null,"cerro bien");
                            amv.setVisible(true);
                            amv.lblFondo.setVisible(true);
                            amv.lblTres.setVisible(false);
                            amv.panel1.setVisible(true);
                        }
                        amv.setVisible(true);
                        llenarTabla2();
                        h1=0;
                    }else{
                        h1=0;
                    }    
                    break;
                default:
                    h1=0;
                    break;
            }

 */

 /*if(h1==2){
                          if(!abierto.equals(componente())){
                              abierto=componente();
                               h1=0;
                          }if(!cerrado.equals(componenteCerrar())){
                              cerrado=componenteCerrar();
                              h1=1;
                          }
                      }     */
