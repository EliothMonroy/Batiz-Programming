/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import BD.cDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ELITH
 */
@WebServlet(name = "sModificarUsuarioFormulario", urlPatterns = {"/ModificarUsuarioFormulario"})
public class sModificarUsuarioFormulario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion_usuario=request.getSession();
        String tipo_usuario=(String)sesion_usuario.getAttribute("tipo");
        cHTML UI= new cHTML();
        String head= UI.head("Consulta Usuario", "Clinicas, SAC, Admisnitración de Clinicas, Palabras clave","SAC te permite consultar cada los datos de tus usuarios.");
        String header= UI.header(tipo_usuario);
        String footer=UI.footer();        
        String CURP=request.getParameter("Curp");
        
        try (PrintWriter out = response.getWriter()) {
            if(sesion_usuario.getAttribute("id_usuario")!=null && sesion_usuario.getAttribute("tipo")!="4" && request.getParameter("Modificar").equals("Modificar"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(head);
                out.println("<body>");
                out.println(header);
                out.println("<p>MOdificando a: "+CURP+"</p><br><br>");
                    cDatos BD= new cDatos();
                    try{
                        BD.Conexion();
                        ResultSet r=BD.Consulta("call sp_ConsultaUsuario('"+CURP+"');");
                        if(r.next()){
                            if(r.getInt("id_usuario")==0){
                                response.sendRedirect("sRedirect?redirect=8&msj=Usuario No Encontrado");
                            }else{
                                if(r.getInt("tipo")==4){
                                   out.print("<div class=\"row display\">"
                                           + "<div class=\"small-6 large-1 columns\"><span class=\"hide-for-large\"></span><span class=\"show-for-large\"><span> </span></div>"
                                           + "<div class=\"small-6 large-10 columns\">"
                                                + "<form action=\"ModificarBD\" method=\"post\">\n" +
                                            "            <input type=\"hidden\" name=\"ID\" value='"+r.getInt("id_usuario")+"' required maxlength=\"50\" placeholder=\"Nombre del Usuario\"><br><br>\n" +  
                                            "            <label for='Nombre'>Nombre del Usuario</label>" + 
                                            "            <input type=\"text\" name=\"Nombre\" value='"+r.getString("nombre")+"' id='Nombre' required maxlength=\"50\" placeholder='"+r.getString("nombre")+"'><br><br>\n" +
                                            "            Apellido Paterno:\n" +
                                            "            <input type=\"text\" name=\"Apellido_p\" value='"+r.getString("apellido_p")+"' required maxlength=\"50\" placeholder='"+r.getString("apellido_p")+"'><br><br>\n" +
                                            "            Apellido Materno:\n" +
                                            "            <input type=\"text\" name=\"Apellido_m\" value='"+r.getString("apellido_m")+"' required maxlength=\"50\" placeholder='"+r.getString("apellido_m")+"'><br><br>\n" +
                                            "            Correo electronico:\n" +
                                            "            <input type=\"email\" name=\"Correo\" value='"+r.getString("correo")+"' maxlength=\"100\" placeholder='"+r.getString("correo")+"' required><br><br>\n" +
                                            "            Contraseña (Que usara para ingresar al sistema):\n" +
                                            "            <input type=\"text\" name=\"Contra\" value='"+r.getString("contraseña")+"' maxlength=\"50\" placeholder='"+r.getString("contraseña")+"' required><br><br>\n" +
                                            "            Curp: \n" +
                                            "            <input type=\"text\" name=\"Curp\" value='"+r.getString("curp")+"' maxlength=\"100\" placeholder='"+r.getString("curp")+"' required><br><br>\n" +
                                            "            Fecha de nacimiento:\n" +
                                            "            <input type=\"date\" value='"+r.getDate("fecha_nacimiento")+"' name=\"Nacimiento\" required><br><br>\n" +
                                            "            Tipo de Sangre:\n" +
                                            "            <input type=\"text\" name=\"Sangre\" value='"+r.getString("tipo_sangre")+"' maxlength=\"10\" placeholder='"+r.getString("tipo_sangre")+"' required><br><br>\n" +
                                            "            <input type=\"submit\" name=\"Modificar\" value=\"Modificar\">  \n" +
                                                " </form>"
                                           + "<div class=\"small-6 large-1 columns\"><span class=\"hide-for-large\"></span><span class=\"show-for-large\">2</span></div>"
                                           + "</div></div>");
                                }else{
                                    out.print("<form action=\"ModificarBD\" method=\"post\">\n" +
"            Nombre:\n" +
"            <input type=\"text\" name=\"ID\" value='"+r.getInt("id_usuario")+"' hidden required maxlength=\"50\" placeholder=\"Nombre del Usuario\"><br><br>\n" +                                            
"            <input type=\"text\" name=\"Nombre\" value='"+r.getString("nombre")+"' required maxlength=\"50\" placeholder='"+r.getString("nombre")+"'><br><br>\n" +
"            Apellido Paterno:\n" +
"            <input type=\"text\" name=\"Apellido_p\" value='"+r.getString("apellido_p")+"' required maxlength=\"50\" placeholder='"+r.getString("apellido_p")+"'><br><br>\n" +
"            Apellido Materno:\n" +
"            <input type=\"text\" name=\"Apellido_m\" value='"+r.getString("apellido_m")+"' required maxlength=\"50\" placeholder='"+r.getString("apellido_m")+"'><br><br>\n" +
"            Correo electronico:\n" +
"            <input type=\"email\" name=\"Correo\" value='"+r.getString("correo")+"' maxlength=\"100\" placeholder='"+r.getString("correo")+"' required><br><br>\n" +
"            Contraseña (Que usara para ingresar al sistema):\n" +
"            <input type=\"text\" name=\"Contra\" value='"+r.getString("contraseña")+"' maxlength=\"50\" placeholder='"+r.getString("contraseña")+"' required><br><br>\n" +
"            Curp: \n" +
"            <input type=\"text\" name=\"Curp\" value='"+r.getString("curp")+"' maxlength=\"100\" placeholder='"+r.getString("curp")+"' required><br><br>\n" +
"            Fecha de nacimiento:\n" +
"            <input type=\"date\" value='"+r.getDate("fecha_nacimiento")+"' name=\"Nacimiento\" required><br><br>\n" +
"            Tipo de Sangre:\n" +
"            <input type=\"text\" name=\"Sangre\" value='"+r.getString("tipo_sangre")+"' maxlength=\"10\" placeholder='"+r.getString("tipo_sangre")+"' required><br><br>\n" +
"                Grado de Estudios:\n" +
"                <input type=\"text\" name=\"Estudios\" value='"+r.getString("grado_estudios")+"' maxlength=\"100\" placeholder='"+r.getString("grado_estudios")+"' required><br><br>\n" +
"                Especialidad:\n" +
"                <input type=\"text\" name=\"Especialidad\" value='"+r.getString("especialidad")+"' maxlength=\"100\" placeholder='"+r.getString("especialidad")+"'><br><br>\n" +
"                Institución:\n" +
"                <input type=\"text\" name=\"Institucion\" value='"+r.getString("institucion")+"' maxlength=\"100\" placeholder='"+r.getString("institucion")+"' required><br><br>\n" +
"                Cedula Profesional:\n" +
"                <input type=\"text\" name=\"Cedula\" value='"+r.getString("cedula_profesional")+"' maxlength=\"100\" placeholder='"+r.getString("cedula_profesional")+"'>\n" +
"            <br><br>  \n" +
"            <input type=\"submit\" name=\"Modificar\" value=\"Modificar\">  \n" +
"        </form>");
                                }
                                } 
                        }else{
                            response.sendRedirect("sRedirect?redirect=0");
                        }                           
                    }catch(SQLException e){
                        out.print(e);
                    }                    
            out.println(footer);
            out.println("</body>");
            out.println("</html>");
            }else{
                response.sendRedirect("login.jsp?msj=Acceso Denegado");
            }
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
