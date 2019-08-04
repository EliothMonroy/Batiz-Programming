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
@WebServlet(name = "sMenu", urlPatterns = {"/MenuPrincipal"})
public class sMenu extends HttpServlet {

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
        //SESIONES
        HttpSession sesion_usuario=request.getSession();
        if(sesion_usuario.getAttribute("id_usuario")!=null && sesion_usuario.getAttribute("tipo")!=null)
            {        
        String tipo_usuario=(String)sesion_usuario.getAttribute("tipo");
        //USANDO Clases para html
        cHTML UI= new cHTML();
        String head= UI.head("Menu Principal", "Clinicas, SAC, Admisnitración de Clinicas, Palabras clave","Descripcion de la pagina");
        String header=UI.header(tipo_usuario);
        String footer=UI.footer();
        String redireccion=request.getParameter("redirect");
        String msj=request.getParameter("msj");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(head);
            out.println("<body>");
            out.println(header);
            out.println("<h1 id='Bienvenido'>SAC: Bienvenido!</h1><div class='body'></div>");
            
            out.println(footer);
            out.println("        <script>\n" +
"        // Initialize the tour\n" +
"        tour.init();\n" +
"        // Start the tour\n" +
"        tour.start(true);\n" +
"        </script>");
            out.println("</body>");
            out.println("</html>");
        }
            }else{
            System.out.println("Sin variables de sesión");
            response.sendRedirect("login.jsp?msj=Primero inicie Sesión");
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
