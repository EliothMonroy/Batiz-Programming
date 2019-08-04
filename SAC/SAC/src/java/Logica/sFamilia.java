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

/*** @author JuanDaniel */
@WebServlet(name = "sFamilia", urlPatterns = {"/sFamilia"})
public class sFamilia extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Sesiones
        HttpSession sesiones=request.getSession();
        String tipo_usuario=(String)sesiones.getAttribute("tipo");
        String id_pac=(String)sesiones.getAttribute("id_usuario");
        String email=(String)sesiones.getAttribute("correo");
        //Usando clase para html
        cHTML html= new cHTML();
        String head= html.head("SAC-Consulta", "Clinicas, SAC, Admisnitración de Clinicas, Palabras clave","Descripcion de la pagina");
        String header=html.header(tipo_usuario);
        String footer=html.footer();
        try (PrintWriter out = response.getWriter()) {
             //Conexion a la BD
                BD.cDatos BD= new BD.cDatos();
                BD.Conexion();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(head);
            out.println("<body>");
            out.println(header);
            out.println("<h1>Control Familiar</h1>");
               //Familia
                ResultSet familia=BD.Consulta("call sp_familia('"+email+"');");
                    if(familia.next()){
                        out.println("<h3>Tipo de Cuenta: Familiar</h3>");
                        out.println("<p>Estimado Paciente usted esta dado de alta en una cuenta Familiar si quiere que el acceso a sus datos sea personal valla a la Sección 'Desvinculación de la Cuenta'</p>");
                        out.println("<p>A continuación tendrás una listado de todos los miembros de tu familia:</p>");
                        do{
                            out.println("<article class='vista_previa'>");
                             ResultSet llenado=BD.Consulta("call sp_DatosPersonales("+familia.getString("id_paciente")+");");
                             out.println("<h3>Datos del Familiar</h3>");
                             ResultSet relacion=BD.Consulta("select parentesco from parentescos where id_parentesco="+familia.getString("id_parentesco")+";");
                             if(relacion.next()){
                                 out.println("<h4>Perfil: "+relacion.getString("parentesco")+"</h4>");
                             }
                             if(llenado.next()){
                                out.println("<p>Nombre: "+llenado.getString("nombre")+"</p>");
                                out.println("<p>Fecha de Nacimiento: "+llenado.getString("fecha_nac")+"</p>");
                                out.println("<p>Curp: "+llenado.getString("curp")+"</p>");
                                out.println("<p>Correo: "+llenado.getString("correo")+"</p>");
                             }
                            out.println("</article>");                    
                        }while(familia.next());
                        
                         //Obtener mi cuenta individual
                        out.println("<h3>Desvinculación de la Cuenta</h3>");
                        out.println("<h4>Permite obtener una Cuenta Personal y dejar de pertenecer a una Cuenta Familiar</h4>");
                        out.println("<p>Esta sección permite desvincularme de una cuenta de correo electrónico, para tener un acceso personal a mis datos.</p>");
                        out.println("<p>Para tener una Cuenta Personal ingresa los siguientes datos.</p>");
                        out.println("<ol>"
                        + "<li>Correo Electrónico Nuevo.</li>"
                        + "<li>Contraseña nueva.</li>"
                        + "</ol>");
                        //Formulario para desvinculacion
                        out.println("<form method='post' action='sLogicaAltas'>");
                            out.println("Correo Electrónico Nuevo: <input type='mail' name='mailn' placeholder='nuevo@sac.com' maxlength='60' required/><br><br>");
                            out.println("Contraseña nueva: <input type='text' name='contran' placeholder='Security' maxlength='60' required/><br><br>");
                            out.println("<input type='hidden' value='familiaB' name='servlet'/>");//Manda el procedure a utilizar
                            out.println("<input type='submit' value='Obtener Mi Cuenta Personal'/>");
                        out.println("</form>");
                //CUENTA PERSONAL
                    }else{
                        out.println("<h3>Tipo de Cuenta: Personal</h3>");
                        out.println("<p>Estimado usuario usted no esta vinculado a una cuenta de correo familiar, si usted tener acceso a los archivos de su familia siga las instrucciones de la Sección 'Cuenta Familiar'.</p>");
                        //Asociarme a una cuenta de correo
                        out.println("<h3>Cuenta Familiar</h3>");
                        out.println("<p>Una Cuenta Familiar permite tener acceso a los expedientes médicos de los integrantes de una familia desde un solo correo eletrónico.</p>");
                        out.println("<p>Para ser miembro de una cuenta familiar deberás mandar una solicitud al correo al cual quieres vincularte. Posteriormente el dueño del correo deberá aprobar tu solicitud.</p>");
                        out.println("<form action='sLogicaAltas' method='post'>");
                         out.println("Correo Electrónico:</p><input type='mail' placeholder='correo@eletronico' name='r_correo' class='form-input' maxlength='60' id='email' required/>");
                         out.println("<div id='relacion'></div>");
                        out.println("</form>");
                        out.println("<script type='text/javascript' src='JS/SAC.js'></script>");
                            out.println("<script>"
                                    + "$('#email').keyup(function(){"
                                    + "var correo=$('#email').val();"
                                    + "var mail= new solicitud(correo);});"
                                    + "</script>");
                    }   
            out.println(footer);
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {Logger.getLogger(sFamilia.class.getName()).log(Level.SEVERE, null, ex);}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
