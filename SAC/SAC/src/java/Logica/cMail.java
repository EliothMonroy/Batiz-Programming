package Logica;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/*** @author JuanDaniel */
public class cMail {
//Datos del usuario
    //Texto del mensaje
        String cuerpoMsj = "";
    //correo del usuario al que le enviaremos la info
        String destinatario = "";
    //Titulo requerido para enviar un correo
        String titulo = "";
//Datos de la Clínica
    String usr = "clinicasSAC@gmail.com";
    String psw = "rociopalacios";
    
    //Constructor que incializa lo referente a los usuario destinatarios que son la varibles que me faltan 
    public cMail(String dest, String Titulo, String Mensaje)
    {
        this.cuerpoMsj = Mensaje;
        this.destinatario = dest;
        this.titulo = Titulo;
    }
    //Metodo para enviar un email devuelve true or false para dar feedback al usuario con un alert
     public boolean SendMail() {
        //Variable que valida si se envio el email, se retorna al final del metodo
         boolean salida = false;
        //Variable que retorna un error en caso de que exista
         String error = "";
        /*La clase properties es usada por mcuhas otras clases JAVA, nos permite, es utilizado para
          crear listas de 2 valores que estaran relacionados, recibe 2 strings*/
         Properties props = new Properties();
         /*El metodo put(String, String permite que dos propiedades se relacionene)*/
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.starttls.enable", "true");
         props.put("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.port", "587");
         
        javax.mail.Authenticator yeah;
        yeah = new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usr, psw);
            }
        }; 
                
        Session session = Session.getInstance(props,yeah);

         try {
 
             Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress("clinicassac@gmail.com"));
             message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
             message.setSubject(titulo);
             message.setText("SAC:\n"+cuerpoMsj);
 
             Transport.send(message);
             salida = true;
             
 
         } catch (MessagingException e) {
             //throw new RuntimeException(e);
            error = e.toString();
         }
         
         return salida;
    }
}
