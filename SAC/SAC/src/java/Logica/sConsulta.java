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

/*** @author JuanDaniel*/
@WebServlet(name = "sConsulta", urlPatterns = {"/sConsulta"})
public class sConsulta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession sesion_usuario=request.getSession();
            String tipo_usuario=(String)sesion_usuario.getAttribute("tipo");
            String id_doc=(String)sesion_usuario.getAttribute("id_usuario");
            //CONEXION A LA BASE DE DATOS
            BD.cDatos  ConsultaBD = new BD.cDatos();
            ConsultaBD.Conexion();
            //USANDO Clases para html
            cHTML UI= new cHTML();
            String head= UI.head("SAC-Consulta", "Clinicas, SAC, Admisnitración de Clinicas, Palabras clave","Descripcion de la pagina");
            String header=UI.header(tipo_usuario);
            String footer=UI.footer();
            //validacion para la sesion
            if(id_doc!=null){
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(head);
                out.println("<body>");
                out.println(header);
                out.println("<section class='section-data'>");
                out.println("<h1>CONSULTA</h1>");
                out.println("</section>");
                out.println("<section>");
                //--------------------------A L T A USUARIO EXTERNO------------------------------
                if(request.getParameter("redireccion").equals("1")){
                    out.println("<form action='sLogicaAltas' method='POST'>"
                            +"<article class='form-article'><h2>Datos del Paciente</h2>"
                            + "<span class='form-span'><p>CURP:</p><input type='text' placeholder='CURPXXXXXX' name='r_curp' class='form-input' maxlength='60' required/></span>"
                            + "<span class='form-span'><p>Correo Electrónico:</p><input type='email' placeholder='correo@eletronico' name='r_correo' class='form-input' maxlength='60' id='email' required/></span>"
                            + "<span class='form-span'><p>Contraseña:</p><input type='text' placeholder='Contraseña' name='r_contra' class='form-input' maxlength='50' required/></span>"
                            + "<span class='form-span'><p>Edad:</p><input type='number' placeholder='Edad' name='r_edad' class='form-input' maxlength='3' required/></span>"
                            + "<span class='form-span'><p>Estatura:</p><input type='number' placeholder='Estatura' name='r_estatura' class='form-input' maxlength='4' required/></span>"
                            + "<span class='form-span'><p>Peso:</p><input type='number' placeholder='Peso' name='r_peso' class='form-input' maxlength='4' required/></span>"
                            + "<span class='form-span'><p>Nombre:</p><input type='text' placeholder='Nombre del Paciente' name='r_nombre' class='form-input' maxlength='50' required/></span>"
                            + "<span class='form-span'><p>Apellido Paterno:</p><input type='text' placeholder='Apellido Paterno' name='r_paterno' class='form-input' maxlength='50' required/></span>"
                            + "<span class='form-span'><p>Apellido Materno:</p><input type='text' placeholder='Apellido Materno' name='r_materno' class='form-input' maxlength='50' required/></span>"
                            +"<span class='form-span'><p>Sexo:</p><select name='r_sexo'>"
                            + "<option value='1'>Hombre</option>"
                            + "<option value='0'>Mujer</option>"
                            + "</select></span>"
                            + "<span class='form-span'><p>Observaciones Generales:</p><textarea cols='80' rows='10' name='r_desc' class='form-input'></textarea></span>");
                            out.print("<span class='form-span'><p>Tipo de Enfermedad:</p>"
                            + "<select name='r_enfermedad' required>");
                            ResultSet enfermedades=ConsultaBD.Consulta("select * from enfermedades;");
                            while(enfermedades.next()){
                                out.print("<option value="+enfermedades.getString("id_enfermedad")+">"+enfermedades.getString("enfermedad")+"</option>");
                            }
                            out.print("<select></span>");
                            out.print("<input type='hidden' value='consultaNR' name='servlet'/>"//Manda el procedure a utilizar
                            + "<span class='form-span'><input type='submit' value='Generar Receta' name='btnredirect' class='button-formulario'/></span>"
                            + "<span class='form-span'><input type='submit' value='Generar Expediente' name='btnredirect' class='button-formulario'/></span>"
                            + "<span class='form-span'><input type='submit' value='Generar Justificante' name='btnredirect' class='button-formulario'/></span>"
                            +"</article>");
                            out.print("</form>");
                            //Interactividad con AJAX
                            out.println("<script type='text/javascript' src='JS/SAC.js'></script>");
                            
                }
                //--------------------------A L T A USUARIO REGISITRADO------------------------------
                if(request.getParameter("redireccion").equals("0")){
                    out.println("<form action='sLogicaAltas' method='POST'>"
                            +"<article class='form-article'><h2>Datos del Paciente</h2>"
                            + "<span class='form-span'><p>CURP:</p><input type='text' placeholder='Ingresa el CURP del Paciente' name='r_correo' class='form-input' maxlength='60' required/></span>"
                            + "<span class='form-span'><p>Edad:</p><input type='number' placeholder='Edad' name='r_edad' class='form-input' maxlength='3' required/></span>"
                            + "<span class='form-span'><p>Estatura:</p><input type='number' placeholder='Estatura' name='r_estatura' class='form-input' maxlength='4' required/></span>"
                            + "<span class='form-span'><p>Peso:</p><input type='number' placeholder='Peso' name='r_peso' class='form-input' maxlength='4' required/></span>"
                            + "<span class='form-span'><p>Observaciones Generales:</p><textarea cols='80' rows='10' name='r_receta' class='form-input'></textarea></span>");
                            out.print("<span class='form-span'><p>Tipo de Enfermedad:</p><select name='r_enfermedad'>");
                            ResultSet enfermedades=ConsultaBD.Consulta("select * from enfermedades;");
                            while(enfermedades.next()){
                                out.print("<option value="+enfermedades.getString("id_enfermedad")+">"+enfermedades.getString("enfermedad")+"</option>");
                            }
                            out.print("<select></span>");
                            out.print("<input type='hidden' value='consultaR' name='servlet'/>"
                            + "<span class='form-span'><input type='submit' value='Generar Receta' name='btnredirect' class='button-formulario'/></span>"
                            + "<span class='form-span'><input type='submit' value='Generar Expediente' name='btnredirect' class='button-formulario'/></span>"
                            + "<span class='form-span'><input type='submit' value='Generar Justificante' name='btnredirect' class='button-formulario'/></span>"
                            +"</article>"
                            + "</form>");
                }
                //--------------------------LISTA DE EXPEDIENTES------------------------------
                if(request.getParameter("redireccion").equals("3")){
                    out.println("<h1>Mis Pacientes</h1>");
                    ResultSet pacientes=ConsultaBD.Consulta("call sp_PacienteDoctor(0,"+id_doc+");");
                    if(pacientes.next()){
                            //Verifico que el doctor tenga pacientes asignados
                            do{
                                //Reviso  los datos de los pacientes asignados
                                ResultSet vista=ConsultaBD.Consulta("call vistaExpedientes("+pacientes.getString("id_paciente")+");");
                                if(vista.next()){
                                    do{
                                        if(vista.getString("valido").equals("1")){
                                            out.print("<article class='center vista_previa'>");
                                            out.println("<h4>Expediente Médico</h4>");
                                            out.println("<p>Paciente: "+vista.getString("nombres")+" "+vista.getString("paterno")+" "+vista.getString("materno")+"</p>");
                                            out.println("<p>Curp del Paciente: "+vista.getString("curp")+"</p>");
                                            out.println("<p>Sexo: ");
                                                if(vista.getString("sexo").equals("1")){
                                                    out.println("Masculino");
                                                }else{
                                                    out.println("Femenino");
                                                }
                                            out.println("</p>");
                                            out.println("<form action='sExpediente' method='POST'>");
                                            out.println("<input type='hidden' value='"+pacientes.getString("id_paciente")+"' name='id_paciente'/>");
                                            out.println("<input type='submit' value='Ver Expediente'/>");
                                            out.println("</form>");
                                            out.print("</article>");
                                        }
                                    }while(vista.next());
                                }
                                 
                            }while(pacientes.next());
                    }else{
                        out.print("<h2>No has realizado ninguna Consulta.</h2>");
                    }
                }
                out.println("</section>");
                out.println(footer);
                out.println("<script>"
                                    + "$('#email').keyup(function(){"
                                    + "var correo=$('#email').val();"
                                    + "var mail= new correoBD(correo);});"
                                    + "</script>");
                out.println("</body>");
                out.println("</html>");
            } catch (SQLException ex) {
                Logger.getLogger(sConsulta.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }//Final del if  
        else{ response.sendRedirect("login.jsp?salida=0");         }
        }
        catch (SQLException ex) {
            Logger.getLogger(sConsulta.class.getName()).log(Level.SEVERE, null, ex);
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
