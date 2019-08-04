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
import javax.servlet.http.HttpSession;

/** @author JuanDaniel */
@WebServlet(name = "sLoginFamiliar", urlPatterns = {"/sLoginFamiliar"})
public class sLoginFamiliar extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Correo familiar
        String email=request.getParameter("correo");
        String tipo=request.getParameter("tipo");
        //BD
        BD.cDatos BD= new BD.cDatos();
        if(tipo.equals("0")){
            try (PrintWriter out = response.getWriter()) {
            BD.Conexion();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Familiar</title>");
            out.println("<link rel='stylesheet' type='text/css' href='CSS/normalize.css'/>");
            out.println("<link rel='stylesheet' type='text/css' href='CSS/SAC.css'/>");
            out.println("</head>");
            out.println("<body>");
            ResultSet familia=BD.Consulta("call sp_familia('"+email+"');");
            if(familia.next()){
                do{
                    out.println("<article class='vista_previa'>");
                     ResultSet llenado=BD.Consulta("call sp_DatosPersonales("+familia.getString("id_paciente")+");");
                     out.println("<h3>Datos del Familiar</h3>");
                     ResultSet relacion=BD.Consulta("select parentesco from parentescos where id_parentesco="+familia.getString("id_parentesco")+";");
                     if(relacion.next()){
                         out.println("<h4>Perfil: "+relacion.getString("parentesco")+"</h4>");
                     }
                     if(llenado.next()){
                        out.println("<p>Nombre: "+llenado.getString("nombre")+"</p>");
                        out.println("<p>Fecha de Nacimiento: "+llenado.getString("fecha_nac")+"</p>");
                        out.println("<p>Curp: "+llenado.getString("curp")+"</p>");
                        out.println("<p>Correo: "+llenado.getString("correo")+"</p>");
                     }//Ya aceptado
                     if(familia.getString("solicitud").equals("1")){
                       out.println("<form method='post' action='sLoginFamiliar?tipo=1' class='green'>");
                        out.println("<input type='hidden' value='"+familia.getString("id_paciente")+"' name='id_pac'/>");
                        out.println("<input type='hidden' value='"+email+"' name='correus'/>");
                        out.println("<input type='submit' value='Iniciar Sesion'/>");
                        out.println("</form>");
                       out.println("</article>");  
                     }//Solicitud enviada
                     else{
                       //Acpetar Solicitud
                       out.println("<form method='post' action='sLogicaAltas' class='red'>");
                        out.println("<input type='hidden' value='"+familia.getString("id_paciente")+"' name='id_pac'/>");
                        out.println("<input type='hidden' value='"+email+"' name='correus'/>");
                        out.println("<input type='hidden' value='familiaA' name='servlet'/>");//Manda el procedure a utilizar
                        out.println("<input type='submit' value='Aceptar Solicitud'/>");
                        out.println("</form>");
                        //Rechazar solicitud
                        out.println("<form method='post' action='sLogicaAltas' class='red'>");
                        out.println("<input type='hidden' value='"+familia.getString("id_paciente")+"' name='id_pac'/>");
                        out.println("<input type='hidden' value='"+email+"' name='correus'/>");
                        out.println("<input type='hidden' value='familiaR' name='servlet'/>");//Manda el procedure a utilizar
                        out.println("<input type='submit' value='Rechazar Solicitud'/>");
                        out.println("</form>");
                       out.println("</article>");
                     }
                }while(familia.next());
            }
            out.println("</body>");
            out.println("</html>"); 
        } catch (SQLException ex) {Logger.getLogger(sLoginFamiliar.class.getName()).log(Level.SEVERE, null, ex);        }
        }//if
        else{
            try {
            //Crea la sesion y redirige
            HttpSession sesion_usuario=request.getSession();
            sesion_usuario.setMaxInactiveInterval(14400);//segundos=4 horas
            String paciente=request.getParameter("id_pac");
            String correus=request.getParameter("correus");
            BD.Conexion();
            ResultSet tipo_usuario=BD.Consulta("select tipo from usuario where id_usuario="+paciente+";");
            sesion_usuario.setAttribute("id_usuario",paciente);
            sesion_usuario.setAttribute("correo",correus);
            if(tipo_usuario.next()){
               sesion_usuario.setAttribute("tipo",tipo_usuario.getString("tipo")); 
            }     
            response.sendRedirect("./sRedirect?redirect=1&msj=Bienvenido");//Todo bien
            } //else
            catch (SQLException ex) {Logger.getLogger(sLoginFamiliar.class.getName()).log(Level.SEVERE, null, ex);}
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
