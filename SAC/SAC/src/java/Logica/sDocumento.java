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
@WebServlet(name = "sConsultaData", urlPatterns = {"/sDocumento"})
public class sDocumento extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Obteniendo variables de sesion
            HttpSession sesion= request.getSession();
            String id_doc=(String)sesion.getAttribute("id_usuario");
            String tipo_usuario=(String)sesion.getAttribute("tipo");
        //Obteniendo paramteros por URL
            String doc=request.getParameter("doc");
            String id_pac=request.getParameter("id_pac");
        //Obteniendo UI
            cHTML UI=new cHTML();
            String head=UI.head("Mi Consulta", "Mi Consulta, SAC, Doctor en Línea ", "Descripción de a Pagina");
            String header=UI.header(tipo_usuario);
            String footer=UI.footer();
         //Manejando la BD
            BD.cDatos BD= new BD.cDatos();
        try (PrintWriter out = response.getWriter()) {
            /*Conecatandome a la BD dentro de try para agregar una clausula catch*/
            BD.Conexion();
            if(id_doc!=null){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(head);
                out.println("<body>");
                out.println(header);
                out.println("<h1>DOCUMENTOS SAC</h1>");
                //Datos Personales del Doctor
                        ResultSet doctor=BD.Consulta("call sp_DatosPersonales("+id_doc+");");
                            //--------------DATOS PERSONALES---------------------
                            out.println("<h4>Doctor</h4>");
                            if(doctor.next()){

                                    out.println("<p>Correo: "+doctor.getString("correo")+"</p>");
                                    out.println("<p>Doctor: "+doctor.getString("nombre")+"</p>");

                                   out.println("<p>Instituto de Egreso: "+doctor.getString("inst")+"</p>");
                                   out.println("<p>Grado de Estudios: "+doctor.getString("grado")+"</p>");
                                   out.println("<p>Cedula Profesional: "+doctor.getString("ced")+"</p>");
                                   out.println("<p>Especialidad: "+doctor.getString("esp")+"</p>");
                            }else{out.println("<p>El paciente fue dado de baja.</p>");}
                                //Telefonos
                                    ResultSet tel=BD.Consulta("select * from telefonos where id_usuario="+id_doc+";");
                                    out.println("<ol><h4>Teléfonos del Doctor</h4>");
                                    if(tel.next()){
                                        do{
                                            out.println("<li>Teléfono: "+tel.getString("telefono")+"<br> Tipo de teléfono: "+tel.getString("tipo")+"</li>");
                                        }while(tel.next());
                                    }else{
                                        out.println("<p>El paciente no tiene telefonos registrados</p>");
                                    }
                                    out.println("</ol>");
                                 //Direcciones
                                    ResultSet dir=BD.Consulta("select * from direcciones where id_usuario="+id_doc+";");
                                    out.println("<ol><h4>Direcciones del Doctor</h4>");
                                    if(dir.next()){
                                        do{
                                            out.println("<li>Dirección: "+dir.getString("direccion")+"<br> Tipo de dirección: "+dir.getString("tipo")+"</li>");
                                        }while(dir.next());
                                    }else{
                                        out.println("<p>El paciente no tiene telefonos registrados</p>");
                                    }
                                    out.println("</ol>");
                        //Datos Personales del Paciente
                            ResultSet paciente=BD.Consulta("call sp_DatosPersonalesPaciente("+id_pac+");");
                            //--------------DATOS PERSONALES---------------------
                            out.println("<h4>Paciente</h4>");
                            if(paciente.next()){
                                    out.println("<p>Curp: "+paciente.getString("curp")+"</p>");
                                    out.println("<p>Correo: "+paciente.getString("correo")+"</p>");
                                    out.println("<p>Paciente: "+paciente.getString("nombre")+"</p>");
                                    out.println("<p>Fecha de Nacimiento: "+paciente.getString("fecha_nac")+"</p>");
                                    out.println("<p>Sexo:");
                                    if(paciente.getString("sexo").equals("0")){out.println("Masculino");}else{out.println("Femenino");}
                            }else{out.println("<p>El paciente fue dado de baja.</p>");}
                                    //Telefonos
                                    ResultSet telp=BD.Consulta("select * from telefonos where id_usuario="+id_pac+";");
                                    out.println("<ol><h4>Teléfonos del paciente</h4>");
                                    if(telp.next()){
                                        do{
                                            out.println("<li>Teléfono: "+telp.getString("telefono")+"<br> Tipo de teléfono: "+telp.getString("tipo")+"</li>");
                                        }while(telp.next());
                                    }else{
                                        out.println("<p>El paciente no tiene telefonos registrados</p>");
                                    }
                                    out.println("</ol>");
                                 //Direcciones
                                    ResultSet dirp=BD.Consulta("select * from direcciones where id_usuario="+id_pac+";");
                                    out.println("<ol><h4>Direcciones del paciente</h4>");
                                    if(dirp.next()){
                                        do{
                                            out.println("<li>Dirección: "+dirp.getString("direccion")+"<br> Tipo de dirección: "+dirp.getString("tipo")+"</li>");
                                          }while(dirp.next());
                                    }else{
                                        out.println("<p>El paciente no tiene telefonos registrados</p>");
                                    }
                                    out.println("</ol>");
    //D O C U M E N T O D O C U M E N T O D O C U M E N T O D O C U M E N T O D O C U M E N T O D O C U M E N T O D O C U M E N T O D O C U M E N T O D O C U M E N T O
                //Imprimiendo los datos de un consulta en especifico
                    if(doc.equals("1")){
                        String id_con=request.getParameter("id_con");
                        ResultSet consulta=BD.Consulta("call  sp_ConsultaDoc("+id_con+");");
                        if(consulta.next()){
                            out.println("<h2>Consulta Médica</h2>");
                            out.println("<p>Tipo de Consulta: ");
                            if(consulta.getString("tipo").equals("0")){
                                out.println("Consulta Agendada");
                            }if(consulta.getString("tipo").equals("1")){
                                out.println("Consulta No Agendada");
                            }if(consulta.getString("tipo").equals("2")){
                                out.println("Consulta Externa");
                            }
                            out.println("</p>");
                            out.println("<p>Fecha de la Consulta: "+consulta.getString("fec")+"</p>");
                            out.println("<p>Tipo de Enfermedad Tratada: "+consulta.getString("enf")+"</p>");
                            out.println("<p>Edad del Paciente: "+consulta.getString("edad")+"</p>");
                            out.println("<p>Peso del Paciente: "+consulta.getString("pes")+"</p>");
                            out.println("<p>Estatura del Paciente: "+consulta.getString("estatura")+"</p>");
                            out.println("<p>Anotaciones: "+consulta.getString("anotacion")+"</p>");
                            //Revisando existencia de una receta
                            if(consulta.getString("receta").equals("0")){
                                out.println("<h3>La Actual Consulta carece de Recetas expedidas a su nombre.</h3>");
                            }else{
                                String id_receta=consulta.getString("id_rec");
                                ResultSet receta_c=BD.Consulta("call sp_RecetaDoc("+id_receta+");");
                                if(receta_c.next()){
                                    out.println("<h2>Receta Médica</h2>");
                                    //Revisando validez de la receta
                                    if(receta_c.getString("estado").equals("1")){
                                        out.println("<p>Prescripción de la Receta: "+receta_c.getString("descripcion_receta")+"</p>");
                                        //Boton para modificar una receta
                                        out.println("<form method='POST' action='sDocumentoM?doc=2'>");
                                        out.println("<input type='hidden' name='id_receta' value='"+id_receta+"'/>");
                                        out.println("<input type='submit' value='Modificar Receta'/>");
                                        out.println("</form>");
                                    }else{
                                        out.println("<p>La receta fue dad de baja!</p>");
                                    }
                                }else{
                                    out.println("<p>La receta fue dad de baja.</p>");
                                }
                            }//Termina la receta
                        //Botón para dar de baja una consulta con su d_evento
                            out.println("<form method='POST' action='sLogicaAltas'>");
                            out.println("<input type='hidden' name='id_evento' value='"+consulta.getString("evento")+"'/>");
                            out.println("<input type='hidden' name='servlet' value='BajaConsulta'/>");
                            out.println("<input type='submit' value='Eliminar Consulta'/>");
                            out.println("</form>");
                        //Boton para modificar una consulta
                            out.println("<form method='POST' action='sDocumentoM?doc=1'>");
                            out.println("<input type='hidden' name='id_consul' value='"+id_con+"'/>");
                            out.println("<input type='submit' value='Modificar Consulta'/>");
                            out.println("</form>");
                        //Botón para generar un PDF
                            out.println("<form method='POST' action='sImpresion'>");
                            out.println("<input type='hidden' name='id_evento' value='"+consulta.getString("evento")+"'/>");
                            out.println("<input type='hidden' name='servlet' value='BajaConsulta'/>");
                            out.println("<input type='submit' value='Generar PDF'/>");
                            out.println("</form>");
                            out.println("</form>");
                        }else{
                            out.println("<p>La consulta ha sido eliminada</p>");
                        }
                    }
                //Imprimiendo los datos de un justificante
                    if(doc.equals("3")){
                        String id_just=request.getParameter("id_just");
                        ResultSet justificante=BD.Consulta("call sp_JustificanteDoc("+id_just+");");
                        if(justificante.next()){
                            out.println("<h2>Justificante Médico</h2>");
                            if(justificante.getString("estado").equals("1")){
                                out.println("<p>Fecha de Expedición: "+justificante.getString("fecha_expedicion")+"</p>");
                                out.println("<p>Teléfono de Referencia: "+justificante.getString("telefono")+"</p>");
                                out.println("<p>Edad del Paciente: "+justificante.getString("edad")+"</p>");
                                out.println("<p>Justificación Médica "+justificante.getString("justificacion")+"</p>");
                        //Botón para dar de baja un justificante con su d_evento
                            out.println("<form method='POST' action='sLogicaAltas'>");
                            out.println("<input type='hidden' name='id_justificante' value='"+id_just+"'/>");
                            out.println("<input type='hidden' name='servlet' value='BajaJustificante'/>");
                            out.println("<input type='submit' value='Eliminar Justificante'/>");
                            out.println("</form>");
                        //Boton para modificar un justificante
                            out.println("<form method='POST' action='sDocumentoM?doc=3'>");
                            out.println("<input type='hidden' name='id_justificante' value='"+id_just+"'/>");
                            out.println("<input type='submit' value='Modificar Justficante'/>");
                            out.println("</form>");
                        //Botón para generar un PDF
                            out.println("<form method='POST' action='sImpresion'>");
                            out.println("<input type='hidden' name='id_justificante' value='"+id_just+"'/>");
                            out.println("<input type='hidden' name='servlet' value='BajaConsulta'/>");
                            out.println("<input type='submit' value='Generar PDF'/>");
                            out.println("</form>");
                            out.println("</form>");
                            }else{
                                out.println("El justificante fue dado de baja!");
                            }
                        }else{
                            out.println("El justificante fue dado de baja!");
                        }
                    }
                out.println(footer);
                out.println("</body>");
                out.println("</html>");
            }else{
                response.sendRedirect("login.jsp?salida=0");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(sDocumento.class.getName()).log(Level.SEVERE, null, ex);
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
