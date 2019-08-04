<%-- 
    Document   : login
    Created on : 17/02/2015, 11:26:38 PM
    Author     : LifeSoft
--%>

<%@page import="Logica.cHTML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        cHTML UI=new cHTML();
        out.print(UI.head("Login SAC", "Sistema de administración para Clinicas", "Sistema que aumenta el rendimiendo de las clinicas"));        
    %>
    <body>
        <section class='section-top'>
            <h1>SISTEMA DE ADMINISTRACIÓN DE CONSULTAS</h1>
            <h2>SAC</h2>
        </section>
        <%
           if(request.getParameter("val")!=null){
              if(request.getParameter("val").equals("0")){
               out.print("<h2>No estas registrado :/</h2>");
              } 
              if(request.getParameter("val").equals("1")){
               out.print("<h2>Mejor suerte para la proxima!</h2>");
              } 
           }           
           if(request.getParameter("msj")!=null){
               out.print("<h2 class='alert-close'>"+request.getParameter("msj")+"</h2>");
           }
        %>
        <section class='section-form'>
            <article class='article-form'>
              <div class="row">
                <div class="col-md-3 center-block no-float">
                    <a href="index.jsp" class='linker center'><span class='button'>Regresa al Inicio</span></a>
                    <a href="registro.jsp" class="linker center"><span class="button">Ó Registrate aquí</span></a>
                    <form id='login' action='sLogin' method='post'>
                        <fieldset>
                            <legend><h3>Iniciar Sesión</h3></legend>
                            <div class="form-group">
                                <label for="idMail">Correo Electrónico</label><br/>
                                <input type='email' class="form-control" name='Email' placeholder="Dirección de Correo Eletrónico" id='idMail' maxlength='50' required autofocus step="0"/>
                            </div>
                            <div class="form-group">
                              <label for="idPassword">Contraseña</label>
                              <input type='password' class="form-control" name='Contra' placeholder='password' id='idPassword' maxlength='50' required step="0"/>
                            </div>
                            <div class="text-center">
                            <input type="submit" class='button success' value='Entrar'/>
                            </div>
                        </fieldset>    
                    </form>
                </div>
              </div>
            </article>
            <article class='article-forgot'>
                <a href='sContra?action=recover'>¿Olvidaste tu Contraseña?</a>
            </article>
        </section>
        <%
           out.print(UI.footer());
        %>
    </body>
</html>