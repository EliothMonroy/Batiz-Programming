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
@WebServlet(name = "sExpediente", urlPatterns = {"/sExpediente"})
public class sExpediente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Obnteniendo sesiones
        String id_pac=request.getParameter("id_paciente");
        HttpSession session= request.getSession();
        String id_doc=(String) session.getAttribute("id_usuario");
        String tipo_usuario=(String)session.getAttribute("tipo");
        //Obteniendo html preestablecido
        cHTML UI= new cHTML();
            String head= UI.head("SAC-Consulta", "Clinicas, SAC, Admisnitración de Clinicas, Palabras clave","Descripcion de la pagina");
            String header=UI.header(tipo_usuario);
            String footer=UI.footer();
        //Imprimiendo pagina
        try (PrintWriter out = response.getWriter()) {
            if(id_doc!=null){
                 /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(head);
            out.println("<body>");
            out.println(header);
            out.println("<h1>Historial Médico</h1>");
            //Obteniendo los datos de los pacientes 
            BD.cDatos BD=new BD.cDatos();
            BD.Conexion();
            //Obteniendo los datos personales del paciente
            ResultSet datos=BD.Consulta("select * from usuario, paciente where id_usuario= "+id_pac+" and id_paciente="+id_pac+";");
            if(datos.next()){
                out.println("<h2>Datos del Paciente</h2>");
                out.println("<p>Curp: "+datos.getString("curp")+"</p>");
                out.println("<p>Nombre del Paicente: "+datos.getString("nombre")+" "+datos.getString("apellido_p")+" "+datos.getString("apellido_m")+"</p>");
                out.println("<p>Fecha de Nacimiento: "+datos.getString("fecha_nacimiento")+"</p>");
                out.println("<p>Estado: ");
                    if(datos.getString("estado").equals("1")){
                        out.println("Activo");
                    }else{
                        out.println("Inactivo");
                    }
                    out.println("</p>");
                    if(datos.getString("sexo").equals("1")){
                        out.println("Masculino");
                    }else{
                        out.println("Femenino");
                    }
                    out.println("</p>");
                    out.println("<p>Tipo de Sangre: "+datos.getString("tipo_sangre")+"</p>");
                    //Telefonos
                        ResultSet tel=BD.Consulta("select * from telefonos where id_usuario="+id_pac+";");
                        out.println("<ol><h4>Teléfonos del paciente</h4>");
                        if(tel.next()){
                            do{
                                out.println("<li>Teléfono: "+tel.getString("telefono")+"<br> Tipo de teléfono: "+tel.getString("tipo")+"</li>");
                            }while(tel.next());
                        }else{
                            out.println("<p>El paciente no tiene telefonos registrados</p>");
                        }
                        out.println("</ol>");
                     //Direcciones
                        ResultSet dir=BD.Consulta("select * from direcciones where id_usuario="+id_pac+";");
                        out.println("<ol><h4>Direcciones del paciente</h4>");
                        if(dir.next()){
                            do{
                                out.println("<li>Dirección: "+dir.getString("direccion")+"<br> Tipo de dirección: "+dir.getString("tipo")+"</li>");
                            }while(dir.next());
                        }else{
                            out.println("<p>El paciente no tiene telefonos registrados</p>");
                        }
                        out.println("</ol>");
            }
            //Obteniendo la lista de consultas del paciente
            out.println("<h2>Consultas del Paciente</h2>");
            ResultSet consultas=BD.Consulta("select * from consulta where id_paciente="+id_pac+" and id_doctor="+id_doc+";");
                if(consultas.next()){
                    do{
                       String id_con=consultas.getString("id_consulta");
                       ResultSet vista=BD.Consulta("call sp_vistaConsulta("+id_pac+","+id_doc+","+id_con+");");
                       if(vista.next()){
                           //validando que el evento de la consulta tenga estadoa activo
                           if(vista.getString("valido").equals("1")){
                               //Imprimiendo cada vista previa
                               do{
                               out.println("<article class='vista_previa'>");
                               out.println("<h4>Consulta Médica</h4>");
                               out.println("<p>Fecha: "+vista.getString("fecha_exp")+"</p>");
                               out.println("<p>Doctor: "+vista.getString("nombred")+"</p>");
                               out.println("<p>Paciente: "+vista.getString("nombrep")+"</p>");
                               out.println("<p>Enfermedad: "+vista.getString("enfermedad")+"</p>");
                               out.println("<p>Tipo de Consulta:");
                                if(vista.getString("tipos").equals("0")){out.println("Consulta Agendada");}
                                if(vista.getString("tipos").equals("1")){out.println("Consulta No Agendada");}
                                if(vista.getString("tipos").equals("2")){out.println("Consulta Externa");}
                               out.println("</p>");
                               if(vista.getString("receta").equals("1")){
                                   out.println("<p>Receta Expedida</p>");
                               }else{
                                   out.println("Sin Receta");
                               }
                               //Agregando el form a consulta
                               out.println("<form action='sDocumento?doc=1' method='POST'>");
                                out.println("<input type='hidden' value='"+id_con+"' name='id_con'/>");
                                out.println("<input type='hidden' value='"+id_pac+"' name='id_pac'/>");
                                out.println("<input type='submit' value='Ver más...'/>");
                               out.println("</form>");
                               out.println("</article>");
                           }while(vista.next());
                           }
                       }  
                    }while(consultas.next());
                }else{
                    out.println("<p>El Paciente no tiene consultas.</p>");
                }
            //Obteniendo los Justificante del paciente
            out.println("<h2>Justificantes del Paciente</h2>");
            ResultSet justificantes=BD.Consulta("select * from justificantes where id_paciente="+id_pac+" and id_doctor="+id_doc+";");
                if(justificantes.next()){
                    do{
                        if(justificantes.getString("estado").equals("1")){
                            //Obteniendo el id del justificante
                              String id_just=justificantes.getString("id_justificante");
                              out.println("<article class='vista_previa'>");
                              out.println("<h4>Justificante Médico</h4>");
                              out.println("<p>Fecha: "+justificantes.getString("fecha_expedicion")+"</p>");
                            //Obteniendo los nombre con el proceudre sp__nombre
                              ResultSet paciente=BD.Consulta("call sp_Nombres("+id_doc+")");
                              if(paciente.next()){
                                  out.println("<p>Doctor: "+paciente.getString("nombre")+" "+paciente.getString("apellido_p")+" "+paciente.getString("apellido_m")+"</p>");
                              }
                              ResultSet doctor=BD.Consulta("call sp_Nombres("+id_pac+")");
                              if(doctor.next()){
                                 out.println("<p>Doctor: "+doctor.getString("nombre")+" "+doctor.getString("apellido_p")+" "+doctor.getString("apellido_m")+"</p>");
                              }
                            //Agregando el form a consulta
                                   out.println("<form action='sDocumento?doc=3' method='POST'>");
                                   out.println("<input type='hidden' value='"+id_just+"' name='id_just'/>");
                                   out.println("<input type='hidden' value='"+id_pac+"' name='id_pac'/>");
                                   out.println("<input type='submit' value='Ver más...'/>");
                                   out.println("</form>");
                                   out.println("<p></article></p>");
                        }
                    }while(justificantes.next());
                }else{
                    out.println("<p>El paciente no tiene Justificantes a su nombre</p>");
                }
            out.println(footer);
            out.println("</body>");
            out.println("</html>");
            }
            else{
                response.sendRedirect("login.jsp?salida=0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(sExpediente.class.getName()).log(Level.SEVERE, null, ex);
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
