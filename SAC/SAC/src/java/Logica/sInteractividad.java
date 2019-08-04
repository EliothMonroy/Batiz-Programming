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

/** @author JuanDaniel */
@WebServlet(name = "sInteractividad", urlPatterns = {"/sInteractividad"})
public class sInteractividad extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Tipo de interactividad
        String tipo=request.getParameter("tipo_interaccion");
        try (PrintWriter out = response.getWriter()) {
            //Conexion a la BD
            BD.cDatos BD=new BD.cDatos();
            BD.Conexion();
        //INTERACTIVIDAD PARA EL CORREO
            if(tipo.equals("correo")){
                String mail=request.getParameter("mail");
                ResultSet existe_correo=BD.Consulta("call existecorreo('"+mail+"');");
                if(existe_correo.next()){
                    //Si el correo no esta disponible
                    if(existe_correo.getString("valido").equals("0")){
                        //Resultados
                        out.println("<p>"+existe_correo.getString("msj")+"</p>"); 
                        out.println("<p>Selecciona una relación para el paciente con el correo:</p>");
                        out.println("<select name='r_relacion' required>"
                                + "<option value='0' selected>Padre</option>"
                                + "<option value='1'>Madre</option>"
                                + "<option value='2'>Hijo</option>"
                                + "<option value='3'>Pareja</option>"
                                + "<option value='5'>Titular del correo</option>"
                                + "<option value='4'>Otro</option>"
                                + "</select>");
                        out.println("<input type='hidden' value='1' name='relacion'/>");
                    }
                    //Si el correo esta disponible
                    else{
                        out.println("<p>El correo esta disponible pudes continuar con tu registro</p>"); 
                    }
                }else{
                    out.println("<p>Correo disponible</p>");
                }
            }//CORREO
            if(tipo.equals("solicitud")){
                String mail=request.getParameter("mail");
                ResultSet existe_correo=BD.Consulta("call existecorreo('"+mail+"');");
                if(existe_correo.next()){
                    //Si el correo no esta disponible
                    if(existe_correo.getString("valido").equals("0")){
                        out.println("<p>Para enviar una solicitud deberás selccionar una relación.</p>");
                        out.println("<p>Relación:</p>");
                        out.println("<select name='r_relacion' required>"
                                + "<option value='0' selected>Padre</option>"
                                + "<option value='1'>Madre</option>"
                                + "<option value='2'>Hijo</option>"
                                + "<option value='3'>Pareja</option>"
                                + "<option value='5'>Titular del correo</option>"
                                + "<option value='4'>Otro</option>"
                                + "</select>");
                         out.println("<input type='hidden' value='1' name='relacion'/>");
                         out.println("<input type='hidden' value='familiaN' name='servlet'/>");
                         out.println("<input type='submit' value='Mandar Solicitud'/>");                        
                    }else{
                        out.println("<p>Este correo no tiene ninguna cuenta asociada!</p>");
                    }
                }
            }
        //Catch para la bd
        } catch (SQLException ex) {Logger.getLogger(sInteractividad.class.getName()).log(Level.SEVERE, null, ex);}
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
