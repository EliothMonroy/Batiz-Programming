<%-- 
    Document   : configuracionesCliente.jsp
    Created on : 16/06/2015, 09:38:09 PM
    Author     : Alumno
--%>

<%@page import="Objetos.Cliente"%>
<%@page import="Logica.cHTML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        cHTML UI=new cHTML();
        out.print(UI.head("Configuracion Inicial Cliente - Sac", "Sistema de administración para Clinicas", "Sistema que aumenta el rendimiendo de las clinicas"));
        HttpSession sesion_usuario=request.getSession();
        String correo=(String)sesion_usuario.getAttribute("correo");
        String contraseña=(String)sesion_usuario.getAttribute("contraseña");
        if(correo==null || contraseña==null){
            response.sendRedirect("logout");
        }
        Cliente cliente=new Cliente(correo, contraseña);
        int tipo=cliente.getTipo();
    %>
    <link rel='stylesheet' type='text/css' href='bower_components/sweetalert/dist/sweetalert.css'/>
    <body>
        <%
            String msj=request.getParameter("msj");
            if(msj!=null){
                out.println("<h2>"+msj+"</h2>");
            }
            if(tipo==0){//Doctor by first time
                %>
                <div id="formulario" class="col-md-3 center-block no-float row"> 
                    <form class="form-control" action="ConfiguracionCliente" method="post">
                        <h2>Configuración Inicial</h2><br>
                        <fieldset>
                            <legend>Información Personal</legend>
                            <label for="Nombre">Ingrese su Nombre:</label>
                            <input type="text" name="Nombre" id="Nombre" placeholder="Ejemplo: Juan" maxlength="50" required autofocus><br>
                            <label for="Paterno">Apellido Paterno</label>
                            <input type="text" name="Paterno" id="Paterno" placeholder="Ejemplo: Pérez" maxlength="50" required><br>
                            <label for="Materno">Apellido Materno</label>
                            <input type="text" name="Materno" id="Materno" placeholder="Ejemplo: García" maxlength="50" required><br>                            
                        </fieldset>
                        <fieldset>
                            <legend>Información sobre su carrera</legend>
                            <label for="Grado_Estudios">Seleccione su grado de estudios</label>
                            <select name="Grado_Estudios" id="Grado_Estudios" required>
                                <option value="">Seleccione una opción</option>
                                <option value="Licenciatura" >Licenciatura</option>
                                <option value="Doctorado">Doctorado</option>                                
                            </select><br>
                            <label for="Especialidad">Escriba su especialidad (Si aplica):</label>
                            <input type="text" name="Especialidad" id="Especialidad" placeholder="Ejemplo: Pediatra" maxlenght="50"><br>
                            <label for="Institucion">Institución de procedencia de su último grado de estudios:</label>
                            <input type="text" name="Institucion" id="Institucion" placeholder="Ejemplo: Instituto Politécnico Nacional" maxlength="50" required><br>
                            <label for="Cedula">Ingrese su cédula profesional</label>
                            <input type="text" name="Cedula" id="Cedula" placeholder="Ejemplo: 12345" maxlength="10" required><br>
                        </fieldset>
                        <input type="submit" name="Terminar" value="Terminar Registro" class="button success">
                    </form>
                </div>
                <%
            }
        %>
        
        <%
            out.print(UI.footer());
        %>
        <script type='text/javascript' src='bower_components/sweetalert/dist/sweetalert.min.js'></script>
        <script>
            $(document).ready(function(){
                <% 
                    if(tipo==0){//Es un doctor by first time.
                %>
                    swal({   
                                    title: "Bienvenido :)",
                                    text: "Para comenzar, por favor llene estos últimos datos, para que pueda empezar a atender  a sus pacientes :)",
                                    type: "info",   
                                    showCancelButton: false,  
                                    confirmButtonColor: "#095A1E", 
                                    confirmButtonText: "Continuar", 
                                    closeOnConfirm: false,   
                                    closeOnCancel: false });
                    <%
                    }else{
                        if(tipo==1){//Es una clinica by firt time.
                        %>
                            swal({   
                                    title: "Bienvenido :)",
                                    text: "Para comenzar, por favor registre a un médico, para que pueda empezar a atender a sus pacientes :)",
                                    type: "info",   
                                    showCancelButton: false,  
                                    confirmButtonColor: "#095A1E", 
                                    confirmButtonText: "Continuar", 
                                    closeOnConfirm: false,   
                                    closeOnCancel: false });
                        <%
                            response.sendRedirect("ConfiguracionCliente");
                        }else{
                            System.out.println("Algo raro paso en jsp configuraciones cliente");
                            response.sendRedirect("logout");//Algo raro paso.
                        }
                    }
                    %>    
            });
            
        </script>
    </body>
</html>
