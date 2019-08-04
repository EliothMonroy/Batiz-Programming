<%-- 
    Document   : registro
    Created on : 10/05/2015, 09:41:43 PM
    Author     : LifeSoft
--%>

<%@page import="Logica.cHTML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <%
        cHTML UI=new cHTML();
        out.print(UI.head("Registro SAC", "Sistema de administración para Clinicas", "Sistema que aumenta el rendimiendo de las clinicas"));
    %>
    <body>
        <header class="header">
            <p>SAC | Sistema de Administración de Clínicas</p>
        </header>
        <%
            if(request.getParameter("msj")!=null){
                String msj=request.getParameter("msj");
                out.print("<h3>"+msj+"</h3><br>");
            }
        %>
        <div class="row">
            <div class="col-md-3 center-block no-float">
                <h1>Registrate</h1><br><br>
                <p>Pero antes nos gustaría saber que tan grande es tu negocio.</p>               
                <form action="subirLogo.jsp" method="post">
                    <label for="TipoCliente">Eres un particular o una clínica</label>
                    <select name="TipoCliente" id="TipoCliente" required autofocus>
                        <option value=''>Selecciona el tipo de cliente que eres</option>
                        <option value='1'>Clínica</option>
                        <option value='0'>Doctor Independiente</option>
                    </select><br/><br>
                    <h3>Formulario de Registro</h3>
                      <br>
                      <fieldset>
                        <legend>Datos para Inicio de Sesión en el Sistema</legend>
                        <label for="Email">Correo Electrónico:</label>
                        <input type="email" name="Email" id="Email" placeholder="ejemplo@servicio.com" required maxlength="50">
                        <br/>
                        <label for="Contra">Contraseña</label>
                        <input type="text" name="Contra" id="Contra" placeholder="Contraseña Secreta" required maxlength="50">
                      </fieldset>
                      <br>
                  <br>
                  <fieldset>
                    <legend>Datos del Cliente</legend>
                    <label for="NombreServicio">Nombre Servicio:</label>
                    <input type="text" name="NombreServicio" id="NombreServicio" maxlength="50" placeholder="Mi Clinica es Genial" required>
                    <br>
                    <label for="Direccion">Dirección:</label>
                    <textarea name="Direccion" id="Direccion" maxlength="100" placeholder="Su dirección, avenida 123 colonia X" required></textarea>
                    <br>
                    <label for="Telefono">Teléfono Principal:</label>
                    <input type="tel" name="Telefono" id="Telefono" maxlength="50" placeholder="58909490" required>
                    <!--      Si es una clínica          -->
                    <br>
                    <label for="Slogan">Su slongan (Si aplica):</label>
                    <input type="text" name="Slogan" id="Slogan" maxlength="50" placeholder="Somos Los Mejores">
                  </fieldset>
                  <br>
                  <a href="index.jsp" class="button info left">Volver</a>
                  <input type="submit" class="button right" value="Take me to the next level !" name="Registro" />
                </form>
            </div>
        </div>
        <%
            out.print(UI.footer());
        %>
    </body>
</html>
