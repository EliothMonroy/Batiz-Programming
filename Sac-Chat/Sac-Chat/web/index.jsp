<%-- 
    Document   : index
    Created on : 1/06/2015, 03:08:57 PM
    Author     : LifeSoft
--%>

<%@page import="logica.cHTML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%
        HttpSession sesion_usuario=request.getSession();
        sesion_usuario.setAttribute("tipo", "1");
        String tipo_usuario=(String)sesion_usuario.getAttribute("tipo");
        //USANDO Clases para html
        cHTML UI= new cHTML();
        String head= UI.head("SAC-Chat", "Clinicas, SAC, Admisnitración de Clinicas, Palabras clave","Descripcion de la pagina");
        String header=UI.header(tipo_usuario);
        String footer=UI.footer();
    %>
<html>
    <%
        out.print(head);
    %>
    <body>
        <%
            out.print(header);
        %>
        <h1>Bienvenido al Prototipo de Chat</h1>
        <%
            out.print(footer);
        %>
    </body>
</html>
