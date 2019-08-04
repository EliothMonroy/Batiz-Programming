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
@WebServlet(name = "sModificarBD", urlPatterns = {"/ModificarBD"})
public class sModificarBD extends HttpServlet {

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
            if(sesion_usuario.getAttribute("id_usuario")!=null && sesion_usuario.getAttribute("tipo")!="4" && request.getParameter("Modificar").equals("Modificar"))
            {
                cDatos BD= new cDatos();
                    try{
                        BD.Conexion();
                        if(request.getParameter("Estudios")==null){
                            ResultSet r=BD.Consulta("call sp_CambiaUsuario("+request.getParameter("ID")+", '"+request.getParameter("Contra")+"', "
                                    + "'"+request.getParameter("Curp")+"','"+request.getParameter("Correo")+"','"+request.getParameter("Nombre")+"',"
                                    + "'"+request.getParameter("Apellido_p")+"','"+request.getParameter("Apellido_m")+"',"
                                    + "'"+request.getParameter("Nacimiento")+"', '"+request.getParameter("Sangre")+"','','','','', '"+sesion_usuario.getAttribute("id_usuario")+"');");
                            if(r.next()){
                                if(r.getInt("valido")==1){
                                    response.sendRedirect("sRedirect?redirect=6&msj="+r.getString("msj"));
                                }else{
                                    response.sendRedirect("sRedirect?redirect=7&msj="+r.getString("msj"));
                                }                            
                            }else{
                                response.sendRedirect("sRedirect?redirect=0");
                            }
                        }else{
                            ResultSet r=BD.Consulta("call sp_CambiaUsuario("+request.getParameter("ID")+", '"+request.getParameter("Contra")+"', "
                                    + "'"+request.getParameter("Curp")+"','"+request.getParameter("Correo")+"','"+request.getParameter("Nombre")+"',"
                                    + "'"+request.getParameter("Apellido_p")+"','"+request.getParameter("Apellido_m")+"',"
                                    + "'"+request.getParameter("Nacimiento")+"', '"+request.getParameter("Sangre")+"',"
                                    + "'"+request.getParameter("Estudios")+"', '"+request.getParameter("Especialidad")+"',"
                                    + " '"+request.getParameter("Institucion")+"', '"+request.getParameter("Cedula")+"','"+sesion_usuario.getAttribute("id_usuario")+"');");
                            if(r.next()){
                                if(r.getInt("valido")==1){
                                    response.sendRedirect("sRedirect?redirect=6&msj="+r.getString("msj"));
                                }else{
                                    response.sendRedirect("sRedirect?redirect=7&msj="+r.getString("msj"));
                                }                            
                            }else{
                                response.sendRedirect("sRedirect?redirect=0");
                            }
                        }   
                    }catch(SQLException e){
                        out.print(e);
                    }                    
            }else{
                response.sendRedirect("index.jsp?msj=Acceso Denegado");
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
