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
@WebServlet(name = "sModificarUsuario", urlPatterns = {"/ModificarUsuario"})
public class sModificarUsuario extends HttpServlet {

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
        String head= UI.head("Modificar Usuario", "Clinicas, SAC, Admisnitración de Clinicas, Palabras clave","SAC te permite modificar los datos de los usuarios de manera segura y rápida.");
        String header=UI.header(tipo_usuario);
        String footer=UI.footer();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(sesion_usuario.getAttribute("id_usuario")!=null && sesion_usuario.getAttribute("tipo")!="4")
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(head);
                out.println("<body>");
                out.println(header);
                if(request.getParameter("msj")!=null){                    
                    out.print("<h4>"+request.getParameter("msj")+"</h4><br><br>");
                }
                out.println("<form action='ModificarUsuarioFormulario' method='post'>"
                        + "<input type='text' placeholder='XXX999' name='Curp'/>"
                        + "<input type='submit' class='button' name='Modificar' value='Modificar'/>"
                        + "</form>");
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
