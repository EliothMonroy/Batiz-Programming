package Logica;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**** @author JuanDaniel */
@WebServlet(name = "sContra", urlPatterns = {"/sContra"})
public class sContra extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Obteniendo la pagina que deseamos imprimir
        String accion=request.getParameter("action");
        String destinatario="";
        //Conexion a la BD
        BD.cDatos base=new BD.cDatos();
        boolean envio;
        try (PrintWriter out = response.getWriter()) {
            base.Conexion();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Administración de Contraseñas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Adminsitración de Contraseñas</h1>");
        //OBTENCION DEL CORREO
            if(accion.equals("recover")){
                out.println("<h3>Recuepración del Contraseña</h3>");
                out.println("<p>Ingresa tu correo electrónico y pulsa en el botón envíar contraseña.</p>");
                out.println("<form action='sContra?action=forgot' method='post'>");
                    out.println("<input type='email' name='correo' placeholder='Correo Electrónico' maxlength='100'/>");
                    out.println("<input type='submit' value='Recuperar Contraseña'/>");
                out.println("</form>");
            }
        //ENVIANDO CORREO DE RECUPERACION
            if(accion.equals("forgot")){
                out.println("<h2>Al parecer olvidaste tu contraseña!</h2>");
                //Validando que el correoeste dado de alta
                destinatario=request.getParameter("correo");
                ResultSet correoBD=base.Consulta("call contraseña('"+destinatario+"', 0, 'contra');");
                if(correoBD.next()){
                    //Si el correo es valido
                    if(correoBD.getString("valido").equals("1")){
                        //Enviando correo
                        cMail correo= new cMail(destinatario,"Recuperación de Contraseña","Estimado usuario para poder recuperar la contraseña da click en el siguiente link: \n http://localhost:8080/SAC/sContra?action=modify&corr="+destinatario+"");
                        envio=correo.SendMail();
                        if(envio==true){
                            out.println("<p>Estimado usuario hemos enviado un correo electrónico para el reestablecimiento de tu contraseña.</p>");
                            out.println("<p>Revisa tu correo electrónico con el que fuiste dado de alta dentro de SAC y sigue las cinstrucciones correspondientes.</p>");
                        }else{
                            out.println("<p>Estimado usuario el servicio de recuperación de contraseña por correo esta deshabilitado por el momento.</p>");
                            out.println("<p>Para pdoer recuperar tu contraseña contácta a tu médico correspondiente.</p>");
                        }
                    }
                    //Si el correo es invalido
                    else{
                        out.println("<p>Algo salio mal :(</p>");
                        out.println("<p>No encontramos el correo ingresado, por favor ponte en contacto con tu médico correspondiente.</p>");
                    }
                }
            }
        //RESTABLECIMIENTO DE CONTRASEÑA
            if(accion.equals("modify")){
                String corr=request.getParameter("corr");
                out.println("<h2>Recuperación de Contraseña</h2>");
                out.println("<h3>Ingreso de contraseña.</h3>");
                out.println("<p>Ingresa una nueva contraseña:</p>");
                out.println("<form action='sContra?action=change' method='post'>");
                    out.println("<input type='text' name='contra' placeholder='Ingrese la nueva contraseña' maxlength='100'/>");
                    out.println("<input type='hidden' name='correo' value='"+corr+"'/>");
                    out.println("<input type='submit' value='Cambiar Contraseña'/>");
                out.println("</form>");
            }
        //CAMBIANDO LA CONTRASEÑA
            if(accion.equals("change")){
                String correo=request.getParameter("correo");
                String contra=request.getParameter("contra");
                ResultSet cambio=base.Consulta("call contraseña('"+correo+"', 1, '"+contra+"');");
                //Validando el cambio del servlet
                if(cambio.next()){
                    if(cambio.getString("valido").equals("3")){
                        out.println("<h3>Contraseña Actualizada</h3>");
                        out.println("<p>"+cambio.getString("msj")+"</p>");
                        out.println("<a href='login.jsp'>Iniciar Sesión</a>");
                    }else{
                        out.println("<h2>"+cambio.getString("msj")+"</h2>");
                    } 
                }else{
                    out.println("<h2>La contraseña no pudo ser actualizada, contacta a tu médico correspondiente para que realize tu cambio de contraseña</h2>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(sContra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
