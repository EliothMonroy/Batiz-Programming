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
 * @author JuanDaniel
 */
@WebServlet(name = "sOnline", urlPatterns = {"/sOnline"})
public class sOnline extends HttpServlet {

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
        String tipo=request.getParameter("c");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(head);
            out.println("<body>");
            out.println(header);
            if(tipo.equals("1")){//Si es chat en vivo
                out.print("<div class='col-md-2 center center-block no-float'>"
        +"<h3 class=''>Chat En vivo</h3><br><br>"
        +"<h5>Seleccione a alguno de los doctores disponibles</h5><br><br>"
        +"<div class='seccion de los botones' id='Doctores'>"
            +"<a href='sChat?id=en_vivo'><button type='button' class='btn btn-sm btn-default'>Dr. Juan Perez</button></a><br><br>"
            +"<a href='sChat?id=en_vivo'><button type='button' class='btn btn-sm btn-default'>Dr. Pedro Maldonado</button></a>"
        +"</div>"
        +"<label for='Doctores' class='right'>Tip: De click sobre el nombre de algun doctor :D (Voy a la Derecha)</label>"
   +" </div>");
            }else{
                if(tipo.equals("0")){
                    out.print("<div class='col-md-2 center center-block no-float'>"
        +"<h3 class=''>Chat Escrito</h3><br><br>"
        +"<h5>Seleccione a alguno de los doctores disponibles</h5><br><br>"
        +"<div class='seccion de los botones' id='Doctores'>"
            +"<a href='sChat?id=escrito'><button type='button' class='btn btn-sm btn-default'>Dr. José Zuñiga</button></a><br><br>"
            +"<a href='sChat?id=escrito'><button type='button' class='btn btn-sm btn-default'>Dr. Hernan Hernandez</button></a>"
        +"</div>"
        +"<label for='Doctores' class='right'>Tip: De click sobre el nombre de algun doctor :D (Voy a la Derecha)</label>"
   +" </div>");
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
