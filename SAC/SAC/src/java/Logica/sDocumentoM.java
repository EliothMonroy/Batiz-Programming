/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author JuanDaniel
 */
@WebServlet(name = "sDocumentoM", urlPatterns = {"/sDocumentoM"})
public class sDocumentoM extends HttpServlet {

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
        //Obteniendo variables de sesion
            HttpSession sesion= request.getSession();
            String id_doc=(String)sesion.getAttribute("id_usuario");
            String tipo_usuario=(String)sesion.getAttribute("tipo");
        //Obteniendo valor del request
            String doc=request.getParameter("doc");
        //HTML Base
            cHTML UI=new cHTML();
            String head=UI.head("SAC ModificacionDoc", "Mi Consulta, SAC, Doctor en Línea ", "Descripción de a Pagina");
            String header=UI.header(tipo_usuario);
            String footer=UI.footer();
        //Conexion a la base
             BD.cDatos BD= new BD.cDatos();
        //Impresion de la pagina
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            BD.Conexion();
        //Validando la sesion
            if(id_doc!=null){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(head);
                out.println("<body>");
                out.println(header);
                    //Modificando una consulta
                        if(doc.equals("1")){
                            String id_con=request.getParameter("id_consul");
                            //Imprimiendo los valores actuales de la consulta
                            ResultSet consulta=BD.Consulta("select * from consulta where id_consulta="+id_con+";");
                            if(consulta.next()){
                                out.println("<form method='POST' action='sLogicaAltas'/>");
                                out.println("<input type='hidden' name='servlet' value='ConsultaModificacion'/>");
                                out.println("<input type='hidden' name='id_cons' value='"+id_con+"'/>");
                                out.println("<input type='hidden' name='id_paciente' value='"+consulta.getString("id_paciente")+"'/>");
                                 ResultSet curps=BD.Consulta("select curp from paciente where id_paciente="+consulta.getString("id_paciente")+";");
                                 if(curps.next()){
                                     out.println("<input type='hidden' name='r_correo' value='"+curps.getString("curp")+"'/>");
                                 }
                                out.println("<p>Descripción de la Consulta</p><textarea cols='80' rows='10' name='r_receta' class='form-input'>"+consulta.getString("descripcion")+"</textarea>");
                                out.println("<p>Edad del Paciente: </p><input type='number' value='"+consulta.getString("edad")+"' placeholder='Edad' name='r_edad' class='form-input' maxlength='3' required/>");
                                out.println("<p>Estatura del Paciente:</p><input type='number' value='"+consulta.getString("estatura")+"' placeholder='Estatura' name='r_estatura' class='form-input' maxlength='4' required/>");
                                out.println("<p>Peso del Paciente:</p><input type='number' value='"+consulta.getString("peso")+"' placeholder='Peso' name='r_peso' class='form-input' maxlength='4' required/>");
                            //Obteniendo la enfermedad
                                ResultSet enfermedades=BD.Consulta("select * from enfermedades;");
                                    out.println("<p>Enfermedad: </p><select name='r_enfermedad'>");
                                    while(enfermedades.next()){
                                        //Validando que enfeermedad fu seleecionada
                                        if(consulta.getString("id_enfermedad").equals(enfermedades.getString("id_enfermedad"))){
                                            out.print("<option value="+enfermedades.getString("id_enfermedad")+" selected>"+enfermedades.getString("enfermedad")+"</option>");
                                        }else{
                                            out.print("<option value="+enfermedades.getString("id_enfermedad")+">"+enfermedades.getString("enfermedad")+"</option>");
                                        }
                                    }
                                out.println("<select>");
                                out.println("<input type='submit' value='Modificar Datos de la Consulta'/>");
                                out.println("</form>");
                            }else{
                                out.println("<p>La consulta no puede ser modificada por asusntos de seguridad Nacional</p>");
                            }
                            
                        }
                    //Modificando una receta
                         if(doc.equals("2")){
                            String id_rec=request.getParameter("id_receta");
                            ResultSet receta=BD.Consulta("select * from receta where id_receta="+id_rec+";");
                            if(receta.next()){
                                 out.println("<form method='POST' action='sLogicaAltas'>");
                                            out.println("<input type='hidden' name='servlet' value='RecetaModificacion'/>");
                                            out.println("<input type='hidden' value='"+id_rec+"' name='id_rec'/>");
                                            out.println("<input type='hidden' value='"+receta.getString("id_consulta")+"' name='id_consulta'/>");
                                            out.println("<input type='hidden' value='"+receta.getString("id_paciente")+"' name='id_paciente'/>");
                                            out.println("<textarea name='r_receta'>"+receta.getString("descripcion_receta")+"</textarea>");
                                            out.println("<input type='submit' value='Modificar Receta'/>");
                                        out.println("</form>");
                            }
                        }
                    //Modificando un justificante
                         if(doc.equals("3")){
                            String id_just=request.getParameter("id_justificante");
                            ResultSet justificantes=BD.Consulta("select * from justificantes where id_justificante="+id_just+";");
                            if(justificantes.next()){
                                //Formulario para dar de alta un justificante
                                ResultSet curp=BD.Consulta("select curp from paciente where id_paciente="+justificantes.getString("id_paciente")+";");
                                if(curp.next()){
                                    out.println("<p>Fecha de Expedición: "+justificantes.getString("fecha_expedicion")+"</p>");
                                out.println("<form action='sLogicaAltas' method='POST'>");
                                out.print("<p>Edad:</p><input type='number' placeholder='Edad' name='r_edad' value='"+justificantes.getString("edad")+"' class='form-input' maxlength='3' required/>"
                                + "<p>Telefono:</p><input type='number' placeholder='0445500112233' name='r_telefono' value='"+justificantes.getString("telefono")+"' class='form-input' maxlength='4' required/>"
                                + "<p>Justificante Médico:</p><textarea cols='80' rows='10' name='r_justificante' class='form-input'>v"+justificantes.getString("justificacion")+"</textarea>"
                                + "<input type='hidden' value='justificanteM' name='servlet'/>"
                                +"<input type='hidden' value='"+id_just+"' name='id_just'/>"
                                + "<input type='hidden' value='"+curp.getString("curp")+"' name='r_curp'/>"
                                + "<span class='form-span'><input type='submit' value='Modificar Justificante' name='btnredirect' class='button-formulario'/></span>"
                                +"</article>"
                                + "</form>");
                                }
                                }
                                //Fin de obteniendo curp
                        }
                out.println(footer);
                out.println("</body>");
                out.println("</html>");
            }else{
                response.sendRedirect("login.jsp?salida=0");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(sDocumentoM.class.getName()).log(Level.SEVERE, null, ex);
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
