<%-- 
    Document   : index
    Created on : 17/02/2015, 11:22:24 PM
    Author     : LifeSoft
--%>
<%@page import="Logica.cHTML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <%
        cHTML UI=new cHTML();
        out.print(UI.head("Inicio SAC", "Sistema de administración para Clinicas", "Sistema que aumenta el rendimiendo de las clinicas"));        
    %>

    <body>
        <header class="header">
            <p>SAC | Sistema de Administración de Clínicas</p>
        </header>
        <section class="body">
                <article class="please" id="Acciones">
                        <a href="login.jsp"><button class="boto" id="Ingresar">Ingresar</button></a>
                        <a href="registro.jsp"><button class="boto">Registrarse</button></a>
                </article>
                        <h2 id="SAC">¿Qué es SAC?</h2>
                        <p class="desc">Sistema de Administración de Clínicas, denominado así por sus siglas SAC, es un sistema con el cual las clínicas podrán tener un mejor manejo de su administración y dándole la importancia que requiere al paciente para darle un mejor servicio por parte de la clínica en que éste esté registrado.
                        Contamos con la sección de Gestión de usuarios, la cual es una muy importante porque de aquí es donde tendrá toda la funcionalidad el sistema, dado que se registran todos los usuarios (pacientes, administradores, doctores y secretariado), recuerda que es muy importante llenar bien todos los datos que te piden de ellos.
                </p>
        </section>
        <%
            out.println(UI.footer());
        %>
    </body>
</html>
