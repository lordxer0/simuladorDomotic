package Controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class HoraFecha extends Thread{
    JLabel hora;
    JLabel fecha;
    public HoraFecha(JLabel hora,JLabel fecha){
        this.hora=hora;
        this.fecha=fecha;
    }
    public String horaActual(){
        Date hora1= new Date();
        SimpleDateFormat horaActual=new SimpleDateFormat("h:mm:s a");
        return horaActual.format(hora1);
    }
     public String fechaActual(){
        Date fecha1= new Date();
        SimpleDateFormat fechaaActual=new SimpleDateFormat("dd/MM/YYYY");
        return fechaaActual.format(fecha1);
    }
    @Override
     public void run(){
         while(0<1){
             try {
                 fecha.setText(fechaActual());
                 hora.setText(horaActual());
                  Thread.sleep(1000);
             } catch (InterruptedException ex) {
                 Logger.getLogger(HoraFecha.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }
}
