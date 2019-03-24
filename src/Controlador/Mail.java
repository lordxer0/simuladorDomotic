package Controlador;

import java.awt.HeadlessException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail extends Thread{
    
    
    public void enviarEmail(Modelo.Movimiento m){
        Controlador.CrudAlarma cr= new CrudAlarma();
        Properties propiedad= new Properties();
         propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
         propiedad.setProperty("mail.smtp.starttls.enable", "true");
         propiedad.setProperty("mail.smtp.port", "587");
         propiedad.setProperty("mail.smtp.auth", "true");
         
         Session sesion= Session.getDefaultInstance(propiedad);
         
        String correoEnvia = "DomoticSena@gmail.com";
        String contrasena = "Domotica154";
        String receptor = cr.conTipoUsuario();
        String asunto = "Alerta Ambiente";
        String mensaje="Es posible que alguien haya ingresado al ambiente el dia: "+m.getFecha()+"\n"+
                "a las "+m.getHora();
        
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia,contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();
            
             System.out.println("Listo, revise su correo");
            
        } catch (HeadlessException | MessagingException ex) {
            System.out.println("error " + ex.getMessage());
        }
    }
}
