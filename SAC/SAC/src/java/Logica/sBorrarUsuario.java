/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "sBorrarUsuario", urlPatterns = {"/BorrarUsuario"})
public class sBorrarUsuario extends HttpServlet {

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
        String head= UI.head("Borrar Usuario", "Clinicas, SAC, Admisnitración de Clinicas, Palabras clave","SAC te permite borrar tus usuario de manera confiable.");
        String header=UI.header(tipo_usuario);
        String footer=UI.footer();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(sesion_usuario.getAttribute("id_usuario")!=null && ( tipo_usuario.equals("0") || tipo_usuario.equals("2") || tipo_usuario.equals("5") ) )
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(head);
                out.println("<body>");
                out.println(header);
                if(request.getParameter("msj")!=null){                    
                    out.print("<h4>"+request.getParameter("msj")+"</h4><br><br>");
                }
                out.println("<div id='contenedor'>");
                if(!"2".equals(tipo_usuario)){
                    //Es una secretaría, solo puede borrar pacientes.
                    out.println("<div class='row center-block'><form action='BorrarBD' method='post'>"
                           + "<fieldset><legend>Dar de Baja Paciente:</legend>"
                           + "<label for='Curp'>Ingresa el Curp del paciente a dar de baja del sistema:</label>"
                           + "<input type='text' placeholder='Ejemplo: CURP123491HMDN' name='CURP' id='Curp' maxlenght='15' required/>"
                           + "</fieldset>"
                           + "<input type='submit' name='Borrar' class='button alert' value='Borrar'/>"
                           + "</form></div>");
                }else{
                    //Es un admi, o un doctor admi, puede borrar tanto pacientes como empleados.
                    out.println("<div class='row center-block'><form action='BorrarBD' method='post'>"
                        + "<fieldset><legend>Dar de Baja a un usuario:</legend>"
                            + "<label for='Tipo'>Seleccione al tipo de usuario que va a eliminar</label>"
                            + "<select name='Tipo' id='Tipo' onchange='baja_usuario()' autofocus required>"
                            + "<option value='' selected>Seleccione algun tipo</option>"
                            + "<option value='Empleado'>Empleado</option>"
                            + "<option value='Paciente'><Paciente</option>"
                            + "<div id='paciente' class='ocultar'>"
                                + "<label for='Curp'>Ingresa el Curp del paciente a borrar:</label>"
                                + "<input type='text' placeholder='Ejemplo: CURP1234556HMNC' name='CURP' id='Curp' maxlenght='15'/>"
                            + "</div>"
                            + "<div id='empleado' class='ocultar'>"
                            + "<label for='Correo'>Ingrese el correo eléctronico del usuario a eliminar:</label>"
                            + "<input type='email' name='Correo' id='Correo' maxlength='80' required>"
                            + "</div>"
                        + "</fieldset>"                            
                        + "<input type='submit' name='Borrar' class='button alert' value='Borrar'/>"
                        + "</form></div>");
                }
                out.println("</div>");
                out.println(footer);
                out.println("</body>");
                out.println("</html>");
            }
            else{
                System.out.println("Acceso denegado en BorrarUsuario");
                response.sendRedirect("login.jsp");
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
