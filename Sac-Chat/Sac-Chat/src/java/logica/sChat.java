/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

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
 * @author ELITH
 */
@WebServlet(name = "sChat", urlPatterns = {"/sChat"})
public class sChat extends HttpServlet {

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
        //String tipo_usuario=(String)sesion_usuario.getAttribute("tipo");
        String tipo_usuario="0";
        //USANDO Clases para html
        cHTML UI= new cHTML();
        String head= UI.head("SAC-VideoConsulta", "Clinicas, SAC, Admisnitración de Clinicas, Palabras clave","Descripcion de la pagina");
        String header=UI.header(tipo_usuario);
        String footer=UI.footer();
        String tipo=request.getParameter("id");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(head);
            out.println("<body>");
            out.println(header);
            if(tipo.equals("en_vivo")){
                out.print("	<div class='col-md-2 center center-block no-float'>\n" +
"		<h3 class=''>En comunicación con el Doctor.</h3><br><br>\n" +
"		<video src='../sources/M4H02554.MP4' weight='500' width='500'></video><br><br>\n" +
"	\n" +
"	<button type='button' class='btn btn-sm btn-warning'>Visitar Perfil Doctor</button><br><br>\n" +
"	<button type='button' class='btn btn-sm btn-danger'>Terminar Chat</button>\n" +
"	</div>");
            }else{
                if(tipo.equals("escrito")){
                    out.print("<div class=\"col-md-3 center center-block no-float\">\n" +
"		<h3>En comunicación con el doctor</h3><br><br>\n" +
"		<div>Historial de mensajes</div><br><br>\n" +
"		<textarea name=\"\" id=\"input\" class=\"form-control\" rows=\"3\" required=\"required\" placeholder=\"Escriba su Mensaje\"></textarea><br><br>\n" +
"		<button type=\"submit\" class=\"btn btn-primary\">Enviar mensaje</button><br><br>\n" +
"		<button type='button' class='btn btn-sm btn-warning'>Visitar Perfil Doctor</button><br><br>\n" +
"		<button type='button' class='btn btn-sm btn-danger'>Terminar Chat</button>\n" +
"	</div>");
                }
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
