package logica;

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
                + "<link rel='stylesheet' type='text/css' href='CSS/normalize.css'/>"
                + "<link rel='stylesheet' type='text/css' href='CSS/SAC.css'/>"
                + "<!-- Latest compiled and minified CSS -->"
                + "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>"
                + "<!-- Optional theme -->"
                + "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css'>"
                + "</head>";
        return head;
    }
    public String header(String tipo_usuario){
        String headerFinal;
        if(tipo_usuario.equals("0")||tipo_usuario.equals("1")){//DOCTOR O ADMINISTRADOR
        headerFinal="<header class='header'>"
                + "<h1>SAC Sistema de Administración de Clínicas</h1>"
                + "<p><a href='MenuPrincipal'>Volver a Menu</a></p>"
                + "<p><a href='index.jsp' >Salir</a></p>"
                + "<nav id='cbp-hrmenu' class='header-nav'>"  
                + "<ul>"
                + "<li id='li'><a href='' id='a'>Usuarios</a>"
                + "<div class='header-span'>"
                + "<div>"
                    + "<div>"
                        + "<ol class='sub-menu'>"
                        + "<li><a href='AltaUsuario'>Agregar Usuario</a></li>"
                        + "<li><a href='ConsultarUsuario'>Consulta de Datos</a></li>"
                        + "<li><a href='ModificarUsuario'>Modificar Usuario</a></li>"
                        + "<li><a href='BorrarUsuario'>Borrar Usuario</a></li>"
                        + "</ol>"
                    + "</div>"
                + "</div></div>"
                + "</li>"//FIN DE USUARIO
                + "<li><a href='sAgenda'>Agenda</a></li>"//FIN DE AGENDA
                 + "<li><a href='sEstadisticas'>Estadísticas</a></li>"//FIN DE ESTADISTICAS
                //consulta
                + "<li id='li'><a href='' id='a'>Consulta</a>"
                + "<div class='header-span'>"
                    + "<div class='header-div-contenedor'>"
                    + "<div>"
                        + "<ul>"
                        + "<li><a href='sConsulta' class=''>Crear Consulta</a>"
                            + "<ol class='sub-menu'>"
                            + "<li><a href='sAgenda?tipo=0'>Consulta Agendada</a></li>"
                            + "<li><a href='sConsulta?redireccion=0'>Consulta No Agendada</a></li>"
                            + "<li><a href='sConsulta?redireccion=1'>Consulta Externa</a></li>"
                            + "<li><a href='sConsulta?redireccion=3'>Mis Expedientes</a></li>"
                            + "</ol>"
                        + "</li>"//crea una nueva consulta
                        + "<li><a href='sReceta?tipo=2'>Recetas</a>"//recetas
                        + "</li>"//fin de recetas
                        + "<li><a href=''>Justificantes</a>"//justificantes
                            + "<ol class='sub-menu'>"
                            + "<li><a href='sJustificante?tipo=0'>Crear Justificante</a></li>"
                            + "<li><a href='sJustificante?tipo=1'>Mis Justificantes</a></li>"
                            + "</ol>"
                        + "</li>"//fin de justificantes
                        + "</ul>"
                    + "</div>"
                + "</div></div>"
                + "</li>"//FIN DE CONSULTA
                + "<li><a href='sEmergencia'>Emergencia</a></li>"//FIN EMERGENCIA
                + "<li id='li'><a href='' id='a'>Chat</a>"
                + "<div class='header-span'>"
                + "<div>"
                    + "<div>"
                        + "<ol class='sub-menu'>"
                        + "<li><a href='sOnline?c=1'>Chat En vivo</a></li>"
                        + "<li><a href='sOnline?c=0'>Chat Escrito</a></li>"
                        + "</ol>"
                    + "</div>"
                + "</div></div>"
                + "</li>"//FIN DE Chat
                + "</ul></nav>"
                + "</header>";
        }
        else if(tipo_usuario.equals("3")||tipo_usuario.equals("2")){//ENFERMERA O SECRETARIA
             headerFinal="<header class='header'>"
                + "<h1>SAC Sistema de Administración de Clínicas</h1>"
                + "<p><a href='MenuPrincipal' >Volver a Menu</a></p>"
                + "<p><a href='index.jsp' >Salir</a></p>"
                + "<nav id='cbp-hrmenu' class='header-nav'>"  
                + "<ul class='header-lista'>"
                + "<li class='lista-item'><a href=''>Usuarios</a>"
                + "<div class='header-span'>"
                + "<div class='header-div-contenedor'>"
                    + "<div>"
                        + "<ul>"
                        + "<li><a href='AgregarUsuario'>Agregar Usuario</a></li>"
                        + "<li><a href='ConsultarUsuario'>Consulta de Datos</a></li>"
                        + "<li><a href='ModificarUsuario'>Modificar Usuario</a></li>"
                        + "<li><a href='BorrarUsuario'>Borrar Usuario</a></li>"
                        + "</ul>"
                    + "</div>"
                + "</div></div>"
                + "</li>"//FIN DE USUARIO
                + "<li class='lista-item'><a href='sAgenda'>Agenda</a></li>"//FIN DE AGENDA
                 + "<li class='lista-item'><a href='sEstadisticas'>Estadísticas</a></li>"//FIN DE ESTADISTICAS
                //consulta
                + "<li class='lista-item'><a href=''>Consulta</a>"
                + "<div class='header-span'>"
                    + "<div class='header-div-contenedor'>"
                    + "<div>"
                        + "<ul>"
                        + "<li><a href=''>Expedientes</a>"//expedientes
                            +"<ul>"
                            + "<li><a href='sExpedienteC'>Consulta de Expedientes</a></li>"
                            + "</ul>"
                        + "</li>"//fin de expedientes
                        + "</ul>"
                    + "</div>"
                + "</div></div>"
                + "</li>"//FIN DE CONSULTA
                + "<li class='lista-item'><a href='sEmergencia'>Emergencia</a></li>"//FIN EMERGENCIA
                + "</ul></nav>"
                + "</header>";
        }else{//Paciente
         headerFinal="<header class='header'>"
                + "<h1>SAC Sistema de Administración de Clínicas</h1>"
                + "<p><a href='MenuPrincipal' >Volver a Menu</a></p>"
                + "<p><a href='index.jsp' >Salir</a></p>"
                + "<nav id='cbp-hrmenu' class='header-nav'>"  
                + "<ul class='header-lista'>"
                + "<li class='lista-item'><a href=''>Usuarios</a>"//USUARIO
                + "<div class='header-span'>"
                + "<div class='header-div-contenedor'>"
                    + "<div>"
                        + "<ul>"
                        + "<li><a href='ConsultarUsuario'>Consulta de Datos</a></li>"
                        + "<li><a href='ModificarUsuario'>Modificar Usuario</a></li>"
                        + "</ul>"
                    + "</div>"
                + "</div></div>"
                + "</li>"//FIN DE USUARIO
                + "<li class='lista-item'><a href='sAgenda'>Agenda</a></li>"//FIN DE AGENDA
                + "<li class='lista-item'><a href='sEstadisticas'>Estadísticas</a></li>"//FIN DE ESTADISTICAS
                + "<li class='lista-item'><a href='sEmergencia'>Emergencia</a></li>"//FIN EMERGENCIA
                + "<li class='lista-item'><a href='sOnline'>Video-consulta</a></li>"//FIN DE ONLINE
                + "<li class='lista-item'><a href='sFamilia'>Control Familiar</a></li>"//FIN DE ONLINE
                + "</ul></nav>"
                + "</header>";
        }
        return headerFinal;
    }

    public String footer(){
        String footer="<footer>"
                + "<h5>El footer chido</h5>"
                + "</footer>"
                + "<script src='JS/SAC.js'></script>"
                + "<script>$(function() {header.init();});</script>"
                + "<!-- Latest compiled and minified JavaScript -->"
                +"<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>"
                + "<script src='JS/jquery-2.1.1.min.js'></script>";
        return footer;
    }
}
