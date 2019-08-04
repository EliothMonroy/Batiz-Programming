<%-- 
    Document   : subirLogo
    Created on : 6/06/2015, 06:21:28 PM
    Author     : LifeSoft
--%>

<%@page import="Objetos.Cliente"%>
<%@page import="Logica.cHTML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        cHTML UI=new cHTML();
        out.print(UI.head("Subir Logo - Sac", "Sistema de administración para Clinicas", "Sistema que aumenta el rendimiendo de las clinicas"));        
    %>
    <link rel='stylesheet' type='text/css' href='bower_components/sweetalert/dist/sweetalert.css'/>
    <body>
        <header class="header">
            <p>SAC | Sistema de Administración de Clínicas</p>
        </header>
        <%
            if(request.getParameter("Registro")!=null){
                if(request.getParameter("Registro").equals("Take me to the next level !")){
                    System.out.println("Entro y viene del formulario valido");
                    String email=request.getParameter("Email");
                    String contra=request.getParameter("Contra");
                    String nombre=request.getParameter("NombreServicio");
                    String tipo=request.getParameter("TipoCliente");
                    String direccion=request.getParameter("Direccion");
                    String telefono=request.getParameter("Telefono");
                    String slogan="";
                    if(request.getParameter("Slogan")!=null){
                        slogan=request.getParameter("Slogan");
                        System.out.println("Tiene su propio slogan");
                    }
                    String validacion=email+contra+tipo+nombre+direccion+telefono+slogan;
                    if(validacion.contains("/")||validacion.contains("<")||validacion.contains(">")||validacion.contains("\\")||validacion.contains("'")||validacion.contains("+")||validacion.contains("|")){
                        System.out.println("Inyeccion");                        
                        response.sendRedirect("registro.jsp?msj=Porfa Comportese ;)");//Trato de  meter una inyection
                    }
                    else{
                        System.out.println("Crea sesion para registrar al usuario");
                        HttpSession sesion_cliente=request.getSession();
                        sesion_cliente.setMaxInactiveInterval(3600);//segundos=1 hora
                        sesion_cliente.setAttribute("correo", email);
                        sesion_cliente.setAttribute("contra", contra);
                        sesion_cliente.setAttribute("nombre", nombre);
                        sesion_cliente.setAttribute("tipo", tipo);
                        sesion_cliente.setAttribute("direccion", direccion);
                        sesion_cliente.setAttribute("telefono", telefono);
                        sesion_cliente.setAttribute("slogan", slogan);
                    }
                }else{
                    if(request.getParameter("Registro").equals("Logo")){
                        out.print("<h3 class=''><div data-alert class='alert-box alert round'>"+
                                    "La imagen deber ser .png ó .jpg."+
                                    "<a href='#' class='close'>&times;</a>"+
                                    "</div></h3>");
                    }else{
                        response.sendRedirect("index.jsp");//No viene de un formulario
                    }
                }
            }else{
                response.sendRedirect("index.jsp");//No viene de un formulario
            }

        %>
        <div class="row body">
            <div class="col-md-3 center-block no-float">
                <form action="sRegistrarCliente" method="post" enctype="multipart/form-data">
                    <fieldset>
                        <legend>Tus clientes se sentirán más seguros, si pueden verte ;)</legend>
                        <label for="Imagen">Sube tu imagen</label>
                        <input type="file" class="button secondary" name="Archivo" id="Imagen" required/><br>
                    </fieldset>
                    <a href="registro.jsp" class="button info left">Volver</a>
                    <input type="submit" class="button right success" value="Terminar Registro" name="Registro" />
                </form>
            </div>
        </div>
        <%
            out.print(UI.footer());
        %>
        <script type='text/javascript' src='bower_components/sweetalert/dist/sweetalert.min.js'></script>
        <script>
            $(document).ready(function(){
            swal({   
                            title: "YA CASI ACABA",
			    text: "Solo falta subir una imagen",
			    type: "info",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Continuar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false });
                    });
            
        </script>
        <noscript>
            
        </noscript>
    </body>  
</html>
