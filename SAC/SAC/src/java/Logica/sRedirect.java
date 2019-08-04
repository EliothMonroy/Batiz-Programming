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
@WebServlet(name = "sRedirect", urlPatterns = {"/sRedirect"})
public class sRedirect extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*Variable para obtener la redireccion a las paginas correspondientes*/
            HttpSession sesion_usuario=request.getSession();
            if(sesion_usuario.getAttribute("correo")!=null)
            {
                if(request.getParameter("redirect")!=null){
                    int redireccion=Integer.parseInt(request.getParameter("redirect"));
                    String msj="";
                    if(request.getParameter("msj")!=null){
                        msj=request.getParameter("msj");
                    }
                    out.print("<!DOCTYPE html>");
                    out.print("<head>");
                    out.print("<link rel='stylesheet' type='text/css' href='bower_components/sweetalert/dist/sweetalert.css'/>");
                    out.print("<noscript>");
                    if(redireccion==0){
                        out.print("<meta http-equiv='Refresh' content='.1;url=sRedirect2?redirect="+redireccion+"'/>");
                    }else{
                        out.print("<meta http-equiv='Refresh' content='.1;url=sRedirect2?redirect="+redireccion+"&msj="+msj+"'/>");
                    }
                    out.print("</noscript>");
                    out.print("</head>");
                    out.print("<body>");
                    out.print("<script type='text/javascript' src='bower_components/jquery/dist/jquery.min.js'></script>");
                    out.print("<script type='text/javascript' src='bower_components/sweetalert/dist/sweetalert.min.js'></script>");
                    out.print("<script type='text/javascript' src='JS/SAC.js'></script>");
                    out.print("<script>"
                        + "$(document).ready(function(){"
                        + "var envio=new redireccion("+redireccion+",'"+msj+"');"
                        + "});"
                        + "</script>");
                    out.print("</body>");
                    out.print("</html>");
                }else{
                    response.sendRedirect("MenuPrincipal");
                }                    
            }else{
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
