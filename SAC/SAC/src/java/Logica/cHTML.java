package Logica;

/*** @author LifeSoft */
public class cHTML {
     //Creando metodo para <head></head>
    public String head(String title, String keywords, String desc){
        String head="<head>"
                + "<meta charset='UTF-8'/>"
                + "<title>"+title+"</title>"
                + "<meta name='description' content="+desc+"/>"
                + "<meta name='keywords' content="+keywords+"/>"
                + "<meta name='viewport' content='width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0'/>"
                + "<link rel=\"shortcut icon\" href='images/logo.jpg'/>"
                + "<link rel='stylesheet' type='text/css' href='bower_components/normalize.css/normalize.css'/>"
                + "<link rel='stylesheet' type='text/css' href='CSS/sac.css'/>"
                + "<link rel='stylesheet' type='text/css' href='bower_components/bootstrap-tour/build/css/bootstrap-tour-standalone.min.css'/>"
                + "<link rel='stylesheet' type='text/css' href='bower_components/foundation/css/foundation.css'/>"
                + "</head>";
        return head;
    }
    //Menu de arriba
    public String header(String tipo_usuario){
        String headerFinal="";
        if(tipo_usuario.equals("5")){//Admi Doctor
        headerFinal="" +
"        <p>SAC | Sistema de Adminsitración de Clínicas</p>\n" +
"    <nav class=\"top-bar\" data-topbar role=\"navigation\" data-options=\"dropdown_autoclose: false\">"  
                + "<section class=\"top-bar-section\">"
                + "<ul class=\"right\">"
                    +"<li id='li' class='has-dropdown not-click'><a href='' id='a'>Usuarios</a>"
                        + "<ul class=\"dropdown\">"
                        + "<li><a href='AltaUsuario'>Agregar Usuario</a></li>"
                        + "<li><a href='ConsultarUsuario'>Consulta de Datos</a></li>"
                        + "<li><a href='ModificarUsuario'>Modificar Usuario</a></li>"
                        + "<li><a href='BorrarUsuario'>Borrar Usuario</a></li>"
                + "</ul>"
                + "</li>"
                + "<ul>"//FIN DE USUARIO
                //consulta
                //
                + "<ul class=\"right\">"
                        + "<li class='has-dropdown not-click'><a href='sConsulta' class=''>Consulta</a>"
                            + "<ul class=\"dropdown\">"
                                + "<li><a href='sConsulta?redireccion=0'>Consulta No Agendada</a></li>"
                                + "<li><a href='sConsulta?redireccion=1'>Consulta Externa</a></li>"
                                + "<li><a href='sConsulta?redireccion=3'>Mis Expedientes</a></li>"
                            + "</ul>"
                         + "</li>"//crea una nueva consulta 
                + "</ul>"
                    + "<li><a href='sReceta?tipo=2'>Recetas</a></li>"//fin de recetas                
                + "<ul class=\"right\">"
                    + "<li class='has-dropdown not-click'><a href='' class=''>Justificantes</a>"
                            + "<ul class=\"dropdown\">"
                            + "<li><a href='sJustificante?tipo=0'>Crear Justificante</a></li>"
                            + "<li><a href='sJustificante?tipo=1'>Mis Justificantes</a></li>"
                            + "</ul>"
                     + "</li>"//fin de justificantes
                 + "</ul>"           
                + "</section>"
                + "</nav>"                
                + "<h2>SAC Sistema de Administración de Clínicas</h2>"
                + "<p><a class='button info' href='MenuPrincipal'>Volver a Menu</a></p>"
                + "<p><a class='button alert' href='logout' >Salir</a></p>";
        }
        else if(tipo_usuario.equals("0")){//Administrador.
             headerFinal="<nav class=\"top-bar\" data-topbar role=\"navigation\" data-options=\"dropdown_autoclose: false\">"  
                + "<section class=\"top-bar-section\">"
                + "<ul class=\"right\">"
                    + "<li class='right'><a href='MiConfiguracion'>Configuracion de la Cuenta</a></li>" 
                    +"<li id='li' class='has-dropdown not-click'><a href='' id='a'>Usuarios</a>"
                        + "<ul class=\"dropdown\">"
                        + "<li><a href='AltaUsuario'>Agregar Usuario</a></li>"
                        + "<li><a href='ConsultarUsuario'>Consulta de Datos</a></li>"
                        + "<li><a href='ModificarUsuario'>Modificar Usuario</a></li>"
                        + "<li><a href='BorrarUsuario'>Borrar Usuario</a></li>"
                + "</ul>"
                + "</li>"
                + "<ul>"//FIN DE USUARIO
                //consulta
                + "<li><a href='sEstadisticas'>Estadísticas</a></li>"
                 + "<li><a href='sEmergencia'>Emergencia</a></li>"//FIN EMERGENCIA 
                 + "</ul>"             
                + "</section>"
                + "</nav>"                
                + "<h2>SAC Sistema de Administración de Clínicas</h2>"
                + "<p><a class='button info' href='MenuPrincipal'>Volver a Menu</a></p>"
                + "<p><a class='button alert' href='logout' >Salir</a></p>";
        }else if(tipo_usuario.equals("1")){//Doctor
         headerFinal="<nav class=\"top-bar\" data-topbar role=\"navigation\" data-options=\"dropdown_autoclose: false\">"  
                + "<section class=\"top-bar-section\">"
                + "<ul class=\"right\">"
                    +"<li id='li' class='has-dropdown not-click'><a href='' id='a'>Usuarios</a>"
                        + "<ul class=\"dropdown\">"
                        + "<li><a href='AltaUsuario'>Agregar Usuario</a></li>"
                        + "<li><a href='ConsultarUsuario'>Consulta de Datos</a></li>"
                        + "<li><a href='ModificarUsuario'>Modificar Usuario</a></li>"
                        + "<li><a href='BorrarUsuario'>Borrar Usuario</a></li>"
                + "</ul>"
                + "</li>"
                + "<ul>"//FIN DE USUARIO
                //consulta
                + "<li><a href='sAgenda'>Agenda</a></li>"//FIN DE AGENDA
                //
                + "<ul class=\"right\">"
                        + "<li class='right'><a href='MiConfiguracion'>Configuracion de la Cuenta</a></li>"  
                        + "<li class='has-dropdown not-click'><a href='sConsulta' class=''>Consulta</a>"
                            + "<ul class=\"dropdown\">"
                                + "<li><a href='sAgenda?tipo=0'>Consulta Agendada</a></li>"
                                + "<li><a href='sConsulta?redireccion=0'>Consulta No Agendada</a></li>"
                                + "<li><a href='sConsulta?redireccion=1'>Consulta Externa</a></li>"
                                + "<li><a href='sConsulta?redireccion=3'>Mis Expedientes</a></li>"
                            + "</ul>"
                         + "</li>"//crea una nueva consulta 
                + "</ul>"
                    + "<li><a href='sReceta?tipo=2'>Recetas</a></li>"//fin de recetas                
                + "<ul class=\"right\">"
                    + "<li class='has-dropdown not-click'><a href='' class=''>Justificantes</a>"
                            + "<ul class=\"dropdown\">"
                            + "<li><a href='sJustificante?tipo=0'>Crear Justificante</a></li>"
                            + "<li><a href='sJustificante?tipo=1'>Mis Justificantes</a></li>"
                            + "</ul>"
                     + "</li>"//fin de justificantes
                 + "<li><a href='sEmergencia'>Emergencia</a></li>"//FIN EMERGENCIA 
                 + "</ul>"           
                + "</section>"
                + "</nav>"                
                + "<h2>SAC Sistema de Administración de Clínicas</h2>"
                + "<p><a class='button info' href='MenuPrincipal'>Volver a Menu</a></p>"
                + "<p><a class='button alert' href='logout' >Salir</a></p>";
        }else if(tipo_usuario.equals("2")){//Secretaría.
            headerFinal="<nav class=\"top-bar\" data-topbar role=\"navigation\" data-options=\"dropdown_autoclose: false\">"  
                + "<section class=\"top-bar-section\">"
                + "<ul class=\"right\">"
                    + "<li class='right'><a href='MiConfiguracion'>Configuracion de la Cuenta</a></li>" 
                    +"<li id='li' class='has-dropdown not-click'><a href='' id='a'>Usuarios</a>"
                        + "<ul class=\"dropdown\">"
                        + "<li><a href='AltaUsuario'>Agregar Usuario</a></li>"
                        + "<li><a href='ConsultarUsuario'>Consulta de Datos</a></li>"
                        + "<li><a href='ModificarUsuario'>Modificar Usuario</a></li>"
                        + "<li><a href='BorrarUsuario'>Borrar Usuario</a></li>"
                + "</ul>"
                + "</li>"
                + "<ul>"//FIN DE USUARIO
                //consulta
                 + "<li><a href='sEmergencia'>Emergencia</a></li>"//FIN EMERGENCIA 
                 + "</ul>"             
                + "</section>"
                + "</nav>"                
                + "<h2>SAC Sistema de Administración de Clínicas</h2>"
                + "<p><a class='button info' href='MenuPrincipal'>Volver a Menu</a></p>"
                + "<p><a class='button alert' href='logout' >Salir</a></p>";
        }else if(tipo_usuario.equals("3")){//Enfermera.
            headerFinal="<nav class=\"top-bar\" data-topbar role=\"navigation\" data-options=\"dropdown_autoclose: false\">"  
                + "<section class=\"top-bar-section\">"
                + "<ul class=\"right\">"
                    +"<li id='li' class='has-dropdown not-click'><a href='' id='a'>Usuarios</a>"
                        + "<ul class=\"dropdown\">"
                        + "<li><a href='AltaUsuario'>Agregar Usuario</a></li>"
                        + "<li><a href='ConsultarUsuario'>Consulta de Datos</a></li>"
                        + "<li><a href='ModificarUsuario'>Modificar Usuario</a></li>"
                        + "<li><a href='BorrarUsuario'>Borrar Usuario</a></li>"
                + "</ul>"
                + "</li>"
                + "<ul>"//FIN DE USUARIO
                //
                    + "<li class='right'><a href='MiConfiguracion'>Configuracion de la Cuenta</a></li>"  
                    + "<li><a href='sReceta?tipo=2'>Recetas</a></li>"//fin de recetas                
                + "<ul class=\"right\">"
                    + "<li class='has-dropdown not-click'><a href='' class=''>Justificantes</a>"
                            + "<ul class=\"dropdown\">"
                            + "<li><a href='sJustificante?tipo=0'>Crear Justificante</a></li>"
                            + "<li><a href='sJustificante?tipo=1'>Mis Justificantes</a></li>"
                            + "</ul>"
                     + "</li>"//fin de justificantes
                 + "<li><a href='sEmergencia'>Emergencia</a></li>"//FIN EMERGENCIA 
                 + "</ul>"           
                + "</section>"
                + "</nav>"                
                + "<h2>SAC Sistema de Administración de Clínicas</h2>"
                + "<p><a class='button info' href='MenuPrincipal'>Volver a Menu</a></p>"
                + "<p><a class='button alert' href='logout' >Salir</a></p>";
        }else if(tipo_usuario.equals("4")){//Paciente
        headerFinal="<nav class=\"top-bar\" data-topbar role=\"navigation\" data-options=\"dropdown_autoclose: false\">"  
                + "<section class=\"top-bar-section\">"
                //consulta
                + "<li><a href='sAgenda'>Agenda</a></li>"//FIN DE AGENDA
                //
                        + "<li class='right'><a href='MiConfiguracion'>Configuracion de la Cuenta</a></li>"               
                + "<ul class=\"right\">"
                    + "<li class='has-dropdown not-click'><a href='' class=''>Justificantes</a>"
                            + "<ul class=\"dropdown\">"
                            + "<li><a href='sJustificante?tipo=1'>Mis Justificantes</a></li>"
                            + "</ul>"
                     + "</li>"//fin de justificantes
                 + "<li><a href='sEmergencia'>Emergencia</a></li>"//FIN EMERGENCIA 
                 + "</ul>"           
                + "</section>"
                + "</nav>"                
                + "<h2>SAC Sistema de Administración de Clínicas</h2>"
                + "<p><a class='button info' href='MenuPrincipal'>Volver a Menu</a></p>"
                + "<p><a class='button alert' href='logout' >Salir</a></p>";
        }
        return headerFinal;
    }
    //Footer
    public String footer(){
        String footer="<footer class=\"footer\" id='Footer'>\n" +
"		<section class=\"redes\">\n" +
"			<ol>\n" +
"				<li>\n" +
"					<a href=\"http://bit.ly/FacebookLifeSoft\">Facebook</a>\n" +
"				</li>\n" +
"				<li>\n" +
"					<a href=\"#\">Twitter</a>\n" +
"				</li>\n" +
"				<li>\n" +
"					<a href=\"https://github.com/LifeSoftMX\">GitHub</a>\n" +
"				</li>\n" +
"			</ol>\n" +
"		</section>\n" +
"		<section class=\"benefits\">\n" +
"			<p class=\"name\"></p>\n" +
"			<article class=\"item\">\n" +
"				<img src=\"images/rec_blanca.png\" width=\"30px\" />\n" +
"				<span>Administra tus documentos</span>\n" +
"			</article>\n" +
"			<article class=\"item\">\n" +
"				<img src=\"images/medica.png\" width=\"30px\" />\n" +
"				<span>Organiza tus recetas</span>\n" +
"			</article>\n" +
"			<article class=\"item\">\n" +
"				<img src=\"images/logo.png\" width=\"30px\" />\n" +
"				<span>Descarga la app!</span>\n" +
"			</article>\n" +
"			<article class=\"item\">\n" +
"				<img src=\"images/clock.png\" width=\"30px\" />\n" +
"				<span>Ahorra tiempo</span>\n" +
"			</article>\n" +
"		</section>\n" +
"	</footer>"
                + "<script src='bower_components/jquery/dist/jquery.min.js'></script>"
                + "<script src='bower_components/bootstrap-tour/build/js/bootstrap-tour-standalone.min.js'></script>"
                + "<script src='bower_components/foundation/js/foundation.min.js'></script>"
                + "<script src='bower_components/SlidesJS/source/jquery.slides.min.js'></script>"
                + "<script src='JS/SAC.js'></script>"; 
        return footer;
    }
}