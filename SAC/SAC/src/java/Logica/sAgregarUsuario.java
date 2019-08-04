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
@WebServlet(name = "sAgregaUsuario", urlPatterns = {"/AltaUsuario"})
public class sAgregarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion_usuario=request.getSession();
        String tipo_usuario=(String)sesion_usuario.getAttribute("tipo");
        cHTML UI= new cHTML();
        String head= UI.head("Agregar Usuario", "Clinicas, SAC, Admisnitración de Clinicas, Palabras clave","SAC te permite agregar de una manera fácil a todo aquel que este relacionado con tu clínica.");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(sesion_usuario.getAttribute("id_usuario")!=null && sesion_usuario.getAttribute("tipo")!="4")
            {
                String header=UI.header(tipo_usuario);
                String footer=UI.footer();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(head);
                out.println("<body>");
                out.println(header); 
                if(request.getParameter("msj")!=null){                    
                    out.print("<h4>"+request.getParameter("msj")+"</h4><br><br>");
                }
                out.print("<div class='row col-md-3 center-block'><form action=\"RegistrandoUsuario\" method=\"post\">\n" +
"            <fieldset>"+
"            <legend>Datos Personales</legend>"+
"            <label for='Nombre'>Nombre:</label>\n" +
"            <input type=\"text\" name=\"Nombre\" id='Nombre' required maxlength=\"50\" placeholder=\"Ejemplo: Juan\" autofocus><br>\n" +
"            <label for='Paterno'>Apellido Paterno:</label>\n" +
"            <input type=\"text\" name=\"Apellido_p\" id='Paterno' required maxlength=\"50\" placeholder=\"Ejemplo: Pérez\"><br>\n" +
"            <label for='Materno'>Apellido Materno:</label>\n" +
"            <input type=\"text\" name=\"Apellido_m\" id='Materno' required maxlength=\"50\" placeholder=\"Ejemplo: García\">" +
"            </fieldset><br><fieldset>"+
"            <legend>Datos para Inicio de Sesión</legend>"+
"            <label for='Correo'>Correo electronico:</label>\n" +
"            <input type=\"email\" name=\"Correo\" id='Correo' maxlength=\"100\" placeholder=\"Ejemplo: example@example.com\" required>\n"+
"            <div id='relacion'></div><br>" +//Interactividad con el correo
"            <label for='Contra'>Contraseña para accesar al sistema</label>"+
"            <input type='text' name='r_contra' id='Contra' placeholder='Ejemplo: Patito1' required maxlenght='30'><br>   "+
"            <label for='Tipo'>Tipo de Usuario: \n" +
"            <select name=\"Tipo\" required onchange=\"usuario_alta()\" id='Tipo'>\n" +
"                <option value=''>Seleccione Algun tipo</option>"+                       
"                <option value=\"4\">Paciente</option>\n" +
"                <option value=\"0\">Administrativo</option>\n" +
"                <option value=\"1\">Doctor</option>\n" +
"                <option value=\"2\">Secretaria</option>\n" +
"                <option value=\"3\">Enfermera</option>" +
"            </select>\n"+
"            </fieldset>"+
"            <div id='datos_paciente' class='ocultar'>"+
"            <fieldset>"+
             "<legend>Datos del Paciente</legend>"+           
"            <label for='Curp'>Curp:</label> \n" +
"            <input type=\"text\" name=\"Curp\" id='Curp' maxlength=\"20\" placeholder=\"Ejemplo: XXXX12344XXX\"><br>\n" +
"            <label for='Nacimiento'>Fecha de nacimiento:</label>\n" +
"            <input type=\"date\" name=\"Nacimiento\" id='Nacimiento'><br>\n" +
"            <label for='Sexo'>Sexo:</label>\n" +
"            <select name=\"Sexo\" id='Sexo'>\n" +
                 "<option value=''>Seleccione Algun tipo</option>"+  
"                <option value=\"0\">Hombre</option>\n" +
"                <option value=\"1\">Mujer</option>\n" +
"            </select><br>\n" +
"            <label for='Sangre'>Tipo de Sangre:</label>\n" +
"            <input type=\"text\" name=\"Sangre\" id='Sangre' maxlength=\"5\" placeholder=\"Ejemplo: AB+\">\n" +
"            </fieldset>"+
"            </div>" +
"            <div id=\"datos_empleado\" class='ocultar'>\n" +
"                <fieldset>"+
"                <legend>Datos del Empleado</legend>"+
"                <label for='Estudios'>Grado de Estudios:</label>\n" +
"                <select name=\"Estudios\" id=\"Estudios\">\n" +
"                   <option value=\"\">Seleccione una opción</option>\n" +
"                   <option value=\"Licenciatura\" >Licenciatura</option>\n" +
"                   <option value=\"Doctorado\">Doctorado</option>\n" +
"                </select><br>\n" +
"                <label for='Especialidad'>Especialidad: (Si aplica)</label>\n" +
"                <input type=\"text\" name=\"Especialidad\" id='Especialidad' maxlength=\"50\" placeholder=\"Ejemplo: Pediatra\">\n" +
"                <label for='Institucion'>Institución:</label>\n" +
"                <input type=\"text\" name=\"Institucion\" id='Institucion' maxlength=\"50\" placeholder=\"Ejemplo: Instituto Politécnico Nacional\"><br>\n" +
"                <label for='Cedula'>Cedula Profesional:</label>\n" +
"                <input type=\"text\" name=\"Cedula\" id='Cedula' maxlength=\"10\" placeholder=\"Ejemplo: 123456\" required><br>\n" +
"                </fieldset>"+
"                </div>\n" +
"                <input type='submit' class='button sucess' name='Enviar' value='Enviar'>"+
"        </form></div>");
                out.print(footer);
                //Interactividad con AJAX
                            out.print("<script>"
                                    + "$('#Correo').keyup(function(){"
                                    + "var correo=$('#Correo').val();"
                                    + "var mail= new correoBD(correo);});"
                                    + "</script>");
                out.println("</body>");
                out.println("</html>");
            }else{
                response.sendRedirect("login.jsp?msj=Acceso Denegado");
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
