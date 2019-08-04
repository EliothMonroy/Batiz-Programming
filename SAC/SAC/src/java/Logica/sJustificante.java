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
@WebServlet(name = "sJustificante", urlPatterns = {"/sJustificante"})
public class sJustificante extends HttpServlet {

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
        //USANDO Clases para html
        cHTML UI= new cHTML();
        String head= UI.head("SAC-JustificanteA", "Clinicas, SAC, Admisnitración de Clinicas, Palabras clave","Descripcion de la pagina");
        String header=UI.header(tipo_usuario);
        String footer=UI.footer();
        String recibo=request.getParameter("tipo");
        String id_doc=(String)sesion_usuario.getAttribute("id_usuario");
        String id_pac=(String)sesion_usuario.getAttribute("id_paciente");
        String id_con=(String)sesion_usuario.getAttribute("id_consulta");
        BD.cDatos ConsultaBD = new cDatos();
         if(tipo_usuario!=null){
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>"); 
            out.println(head);
            out.println("<body>");
            out.println(header);
            if(recibo.equals("0")){
                out.println("<h1>Creacion de Justificantes</h1>");
                    //Formulario para dar de alta un justificante
                    out.println("<form action='sLogicaAltas' method='POST'>"
                            +"<article class='form-article'><h2>Datos del Paciente</h2>");
                            out.println("<span class='form-span'><p>Curp del Paciente:</p><input type='text' placeholder='CURPXXXXX' name='r_curp' class='form-input' maxlength='60' required/></span>");
                            out.print("<span class='form-span'><p>Edad:</p><input type='number' placeholder='Edad' name='r_edad' class='form-input' maxlength='3' required/></span>"
                            + "<span class='form-span'><p>Telefono:</p><input type='number' placeholder='0445500112233' name='r_telefono' class='form-input' maxlength='4' required/></span>"
                            + "<span class='form-span'><p>Justificante Médico:</p><textarea cols='80' rows='10' name='r_justificante' class='form-input'></textarea></span>"
                            +"<input type='hidden' value='justificante' name='servlet'/>"
                            + "<span class='form-span'><input type='submit' value='Crear Justificante' name='btnredirect' class='button-formulario'/></span>"
                            +"</article>"
                            + "</form>");
            }
             if(recibo.equals("1")){
                out.println("<h1>Mis Justificantes</h1>");
                ConsultaBD.Conexion();
                ResultSet justificantes=ConsultaBD.Consulta("select * from justificantes where id_doctor="+id_doc+";");
                //Existen justificantes
                if(justificantes.next()){
                    do{
                        //Validando que los justificantes tengan un estado activo
                        if(justificantes.getString("estado").equals("1")){
                            //Obteniendo el id del justificante
                              String id_just=justificantes.getString("id_justificante");
                              out.println("<article class='vista_previa'>");
                              out.println("<h4>Justificante Médico</h4>");
                              out.println("<p>Fecha: "+justificantes.getString("fecha_expedicion")+"</p>");
                            //Obteniendo los nombre con el proceudre sp__nombre
                              ResultSet doctor=ConsultaBD.Consulta("call sp_Nombres("+id_doc+")");
                              if(doctor.next()){
                                  out.println("<p>Doctor: "+doctor.getString("nombre")+" "+doctor.getString("apellido_p")+" "+doctor.getString("apellido_m")+"</p>");
                              }
                              //Obteniendo los nombre con el proceudre sp__nombre
                              ResultSet paciente=ConsultaBD.Consulta("call sp_Nombres("+justificantes.getString("id_paciente")+")");
                              if(paciente.next()){
                                  out.println("<p>Paciente: "+paciente.getString("nombre")+" "+paciente.getString("apellido_p")+" "+paciente.getString("apellido_m")+"</p>");
                              }
                            //Agregando el form a consulta
                                out.println("<form action='sDocumento?doc=3' method='POST'>");
                                   out.println("<input type='hidden' value='"+id_just+"' name='id_just'/>");
                                   out.println("<input type='hidden' value='"+justificantes.getString("id_paciente")+"' name='id_pac'/>");
                                   out.println("<input type='submit' value='Ver Justificante'/>");
                                out.println("</form>");
                                out.println("</article>");
                        }
                    }while(justificantes.next());
                }else{
                    out.println("<p>Usted no ha expedido ninún Justificante.</p>");
                }
            }
             //Alta de justificante despues de una consulta
               if(recibo.equals("4")){
                    //Consulta a la bd para obtener datos auxiliares
                   ConsultaBD.Conexion();
                    ResultSet datos=ConsultaBD.Consulta("call sp_DatosAuxiliares("+id_pac+","+id_doc+","+id_con+");");
                    if(datos.next()){
                    //Datos del doctor
                        out.println("<p>"+datos.getString("instituto")+"</p>");
                        out.println("<p>Cedula Profesional: "+datos.getString("cedula_profesional")+"</p>");
                        out.println("<p>Doctor: "+datos.getString("nombre_doctor")+" "+datos.getString("paterno_doctor")+" "+datos.getString("materno_doctor")+"</p>");
                        out.println("<p>Especialidad: "+datos.getString("especialidades")+"</p>");
                    //Datos del Paciente
                        out.println("<h2>Datos del Paciente</h2>");
                        out.println("<p>Nombre del Paciente: "+datos.getString("nombre_paciente")+" "+datos.getString("paterno_paciente")+" "+datos.getString("materno_paciente")+"</p>");
                        out.println("<p>Sexo: ");
                            String sexo=datos.getString("sexo");
                            if(sexo.equals("1")){
                                out.println("Masculino");
                            }else{
                                out.println("Fememnino");
                            }
                        out.println("</p>");
                        out.println("<p>Fecha Nacimiento: "+datos.getString("fecha_nac")+"</p>");
                        out.println("<p>Edad: "+datos.getString("edades")+" años</p>");
                        out.println("<p>Peso: "+datos.getString("peso")+" gramos</p>");
                        out.println("<p>Estatura: "+datos.getString("estatura")+"cm</p>");
                    //Datos de la Consulta
                        out.println("<h2>Consulta</h2>");
                        out.println("<p>Fecha de Expedición: "+datos.getString("fecha_exp")+"</p>");
                        //enfermedad
                        out.println("<p>Tipo de Enfermedad: "+datos.getString("id_enf")+"</p>");
                        //tipo consulta
                            out.println("<p>Tipo de Consulta: ");
                            String tipo=datos.getString("tipo_con");
                            if(tipo.equals("0")){
                                out.println("Agendada.");
                            }if(tipo.equals("1")){
                                out.println("No Agendada.");
                            }if(tipo.equals("2")){
                                out.println("Consulta Externa.");
                            }
                        //descripcion
                        out.println("<p>Anotaciones de la Consulta: "+datos.getString("descripcion")+"</p>");
                        //consulta frmulario
                         out.println("<form action='sLogicaAltas' method='POST'>");
                            ResultSet curp=ConsultaBD.Consulta("select curp from usuario where id_usuario="+id_pac+";");
                            if(curp.next()){out.println("<input type='hidden' value='"+curp.getString("curp")+"' name='r_curp'/>");}
                            out.print("<span class='form-span'><p>Edad:</p><input type='number' placeholder='Edad' name='r_edad' class='form-input' maxlength='3' required/></span>"
                            + "<span class='form-span'><p>Telefono:</p><input type='number' placeholder='0445500112233' name='r_telefono' class='form-input' maxlength='4' required/></span>"
                            + "<span class='form-span'><p>Justificante Médico:</p><textarea cols='80' rows='10' name='r_justificante' class='form-input'></textarea></span>"
                            +"<input type='hidden' value='justificante' name='servlet'/>"
                            + "<span class='form-span'><input type='submit' value='Crear Justificante' name='btnredirect' class='button-formulario'/></span>"
                            +"</article>"
                            + "</form>");
                    }
               }
            out.println(footer);
            out.println("</body>");
            out.println("</html>");
        }   catch (SQLException ex) {
                Logger.getLogger(sJustificante.class.getName()).log(Level.SEVERE, null, ex);
            }
    }else{ response.sendRedirect("login.jsp?salida=0");}
    
    
    
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
