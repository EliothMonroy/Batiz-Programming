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
@WebServlet(name = "sReceta", urlPatterns = {"/sReceta"})
public class sReceta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession sesion_usuario=request.getSession();
            String tipo_usuario=(String)sesion_usuario.getAttribute("tipo");
            String id_doc=(String)sesion_usuario.getAttribute("id_usuario");
            String id_pac=(String)sesion_usuario.getAttribute("id_paciente");
            String id_con=(String)sesion_usuario.getAttribute("id_consulta");
            int id_doctor=Integer.parseInt(id_doc);
            BD.cDatos  ConsultaBD = new BD.cDatos();
            ConsultaBD.Conexion();
            //USANDO Clases para html
            cHTML UI= new cHTML();
            String head= UI.head("SAC-RecetaA", "Clinicas, SAC, Admisnitración de Clinicas, Palabras clave","Descripcion de la pagina");
            String header=UI.header(tipo_usuario);
            String footer=UI.footer();
            String recibo=request.getParameter("tipo");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                if(id_doc!=null){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(head);
                out.println("<body>");
                out.println(header);
                //----------------------SECCION ALTA DE RECETAS-----------------------------
                if(recibo.equals("0")){
                    out.println("<h3>Los datos de la consulta fueron guardados!</h3>");
                    out.println("<section class='section-data'>");
                    out.println("<h1>Expedición de Recetas</h1>");
                    //Mostrar los datos del paciente al que se le expedira la receta
                    ResultSet datos=ConsultaBD.Consulta("call sp_DatosAuxiliares("+id_pac+","+id_doc+","+id_con+");");
                    if(datos.next()){
                    //Datos del doctor
                        out.println("<h2>Receta</h2>");
                        out.println("<h2>"+id_pac+"</h2>");
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
                    }
                    out.println("</section>");
                    //Formulario para dara de alta
                    out.println("<section>");
                    out.println("<form action='sLogicaAltas' method='POST'>"
                            + "<h2>Receta</h2>"
                            + "<p>Ingresa la prescripción médica para el paciente.</p> "
                            + "<span class='form-span'><p>Prescripción:</p><textarea cols='80' rows='10' name='r_receta' class='form-input'></textarea></span>");
                            //id paciente
                            out.println("<input type='hidden' value='"+id_pac+"' name='id_paciente'/>");
                            //id_consulta
                            out.println( "<input type='hidden' value='"+id_con+"' name='id_consulta'/>");
                            out.println("<input type='hidden' value='receta' name='servlet'/>"
                            + "<span class='form-span'><input type='submit' value='Crear receta' class='form-input button-formulario'/></span>"
                            +"</article>"
                            + "</form>");
                    out.println("</section>");
                }
                //tipo=2 Consulta de Recetas
                if(recibo.equals("2")){
                    out.println("<h1>Mis Recetas</h1>");
                    ResultSet recetas=ConsultaBD.Consulta("call sp_ConsultaDoctor("+id_doctor+", 2);");
                    if(recetas.next()){
                     //Obteniendo la lista de las recetas del doctor
                         do{
                                //Obteniendo vistas previas de las recetas
                                 ResultSet previa=ConsultaBD.Consulta("call sp_vistaConsulta("+recetas.getString("id_paciente")+","+recetas.getString("id_doctor")+","+recetas.getString("id_consulta")+");");
                                 if(previa.next()){
                                     //Obteniendo las vistas previas de las consultas activas
                                     if(previa.getString("valido").equals("1")){
                                        out.print("<article class='vista_previa'>");
                                        out.println("<h3>Receta Médica</h3>");
                                        out.println("<p>Fecha de Expedición de la Receta: "+previa.getString("fecha_exp")+"</p>");
                                        out.println("<p>Doctor que expidió la Receta: "+previa.getString("nombred")+"</p>");
                                        out.println("<p>Paciente: "+previa.getString("nombrep")+"</p>");
                                        out.println("<p>Enfermedad: "+previa.getString("enfermedad")+"</p>");
                                        out.println("<form method='POST' action='sDocumento?doc=1'>");
                                            out.println("<input type='hidden' value='"+previa.getString("consulta")+"' name='id_con'/>");
                                            out.println("<input type='hidden' value='"+recetas.getString("id_paciente")+"' name='id_pac'/>");
                                            out.println("<input type='submit' value='Ver Receta'/>");
                                        out.println("</form>");
                                        out.print("</article>");   
                                     }
                                 }else{
                                   out.println("La Consulta fue dada de baja");   
                                 }
                             } while(recetas.next());   
                    }else{
                        out.print("<h2>No has realizado ninguna Consulta.</h2>");
                    }
                }
                out.println(footer);
                out.println("</body>");
                out.println("</html>");
            }else{
                //redirección si s sesion es nula
                     response.sendRedirect("login.jsp?salida=0");                  
                    }
            }}   catch (SQLException ex) {
            Logger.getLogger(sReceta.class.getName()).log(Level.SEVERE, null, ex);
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
