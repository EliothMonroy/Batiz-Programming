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
 * @author JuanDaniel
 */
@WebServlet(name = "sConsultarBD", urlPatterns = {"/ConsultarBD"})
public class sConsultarBD extends HttpServlet {

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
        
        String CURP=request.getParameter("CURP");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /* TODO output your page here. You may use following sample code. */
            if(sesion_usuario.getAttribute("id_usuario")!=null && sesion_usuario.getAttribute("tipo")!="4" && request.getParameter("Consultar").equals("Consultar"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(head);
                out.println("<body>");
                out.println(header);
                out.println("<p>Consulta de: "+CURP+"</p><br><br>");
                    cDatos BD= new cDatos();
                    try{
                        BD.Conexion();
                        ResultSet r=BD.Consulta("call sp_ConsultaUsuario('"+CURP+"');");
                        if(r.next()){
                            if(r.getInt("id_usuario")==0){
                                response.sendRedirect("sRedirect?redirect=8&msj=Usuario No Encontrado");
                            }else{
                                if(r.getInt("tipo")==4){
                                    out.println("<form action='ModificarUsuarioFormulario' method='post'>"
                                        + "<ul><input type='text' name='Curp' value='"+CURP+"' hidden>"
                                        + "<li>Correo: "+(String)r.getString("correo")+"</li>"
                                        + "<li>Contraseña: "+r.getString("contraseña")+"</li>"
                                        + "<li>Tipo de Usuario: Paciente</li>"
                                        + "<li>Curp: "+CURP+"</li>"
                                        + "<li>Nombre: "+(String)r.getString("nombre")+"</li>"
                                        + "<li>Apellido Paterno: "+r.getString("apellido_p")+"</li>"
                                        + "<li>Apellido Materno: "+r.getString("apellido_m")+"</li>"
                                        + "<li>Fecha de nacimiento: "+r.getDate("fecha_nacimiento")+"</li>"
                                        + "<li>Sexo: "+r.getInt("sexo")+"</li>"
                                        + "<li>Tipo de Sangre: "+r.getString("tipo_sangre")+"</li>"    
                                        + "</ul><br><br>"
                                        + "<input type='submit' name='Modificar' class='button' value='Modificar'></form>");
                                }else{
                                    out.println("<form action='ModificarUsuarioFormulario' method='post'>"
                                    + "<ul><input type='text' name='Curp' value='"+CURP+"' hidden>"
                                    + "<li>Correo: "+(String)r.getString("correo")+"</li>"
                                    + "<li>Contraseña: "+r.getString("contraseña")+"</li>"
                                    + "<li>Tipo de Usuario: Paciente</li>"
                                    + "<li>Curp: "+CURP+"</li>"
                                    + "<li>Nombre: "+(String)r.getString("nombre")+"</li>"
                                    + "<li>Apellido Paterno: "+r.getString("apellido_p")+"</li>"
                                    + "<li>Apellido Materno: "+r.getString("apellido_m")+"</li>"
                                    + "<li>Fecha de nacimiento: "+r.getDate("fecha_nacimiento")+"</li>"
                                    + "<li>Sexo: "+r.getInt("sexo")+"</li>"
                                    + "<li>Tipo de Sangre: "+r.getString("tipo_sangre")+"</li>"
                                    + "<li>Grado de Estudios: "+r.getString("grado_estudios")+"</li>"
                                    + "<li>Especialidad: "+r.getString("especialidad")+"</li>"
                                    + "<li>Institucion: "+r.getString("institucion")+"</li>"
                                    + "<li>Cedula Profesional: "+r.getString("cedula_profesional")+"</li>"        
                                    + "</ul><br><br>"
                                    + "<input type='submit' name='Modificar' class='button' value='Modificar'></form>");
                                }
                                } 
                        }else{
                            response.sendRedirect("sRedirect?redirect=0");
                        }
                           
                    }catch(SQLException e){
                        out.print(e);
                    }                    
            }else{
                response.sendRedirect("login.jsp?msj=Acceso Denegado");
            }
            out.println(footer);
            out.println("</body>");
            out.println("</html>");
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
