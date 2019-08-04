  //Redireccionamiento con SweetaAlert y metodo Get para la Url
function redireccion(pag, msj){
	if(pag===1){
		swal({   
                            title: msj,
			    text: "Sistema de Administracion para Clínicas",
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Continuar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/MenuPrincipal";
			}
		});
	}//if
        //Usuarios 
        //ALTA  
        if(pag===2){
		swal({   
                            title: "Usuario dado de alta con éxito",
			    text: msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Continuar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/ConsultarUsuario?redirect="+redireccion+"&msj="+msj;
			}
		});
	}
        //ALTA ERROR    
        if(pag===3){
		swal({   
                            title: "Ops algo salio mal!",
			    text: msj,
			    type: "error",   
			    showCancelButton: false,  
			    confirmButtonColor: "#9A2817", 
			    confirmButtonText: "Regresar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/AltaUsuario?redirect="+redireccion+"&msj="+msj;
			}
		});
	}
        //BAJA USUARIO      
        if(pag===4){
		swal({   
                            title: "Usuario dado de baja",
			    text: msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Continuar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/ConsultarUsuario?redirect="+redireccion+"&msj="+msj;
			}
		});
	}
        //BAJA ERROR    
        if(pag===5){
		swal({   
                            title: "Ops algo salio mal!",
			    text: msj,
			    type: "error",   
			    showCancelButton: false,  
			    confirmButtonColor: "#9A2817", 
			    confirmButtonText: "Regresar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	    window.location="http://localhost:8080/SAC/BorrarUsuario?redirect="+redireccion+"&msj="+msj;
			}
		});
	}
        //MODIF 
        if(pag===6){
		swal({   
                            title: "Usuario modificado",
			    text: msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Continuar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/ConsultarUsuario?redirect="+redireccion+"&msj="+msj;
			}
		});
	}       
        //MODIF ERROR
        if(pag===7){
		swal({   
                            title: "Ops algo salio mal!",
			    text: msj,
			    type: "error",   
			    showCancelButton: false,  
			    confirmButtonColor: "#9A2817", 
			    confirmButtonText: "Regresar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	    window.location="http://localhost:8080/SAC/ModificarUsuario?redirect="+redireccion+"&msj="+msj;
			}
		});
	}
        //BUSQUEDA ERROR
        if(pag===8){
		swal({   
                            title: "Ops algo salio mal!",
			    text: msj,
			    type: "error",   
			    showCancelButton: false,  
			    confirmButtonColor: "#9A2817", 
			    confirmButtonText: "Regresar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	    window.location="http://localhost:8080/SAC/ConsultarUsuario?redirect="+redireccion+"&msj="+msj;
			}
		});
	}
        //Redireccion a RECETA despues de una consulta externa
        if(pag===9){
            swal({   
                            title: "Consulta Realizada",
			    text: msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Creacion de Recetas", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/sReceta?tipo=0";
			}
		});
        }
        //Redireccion a JUSTIFICANTE despues de una consulta externa
        if(pag===10){
            swal({   
                            title: "Consulta Realizada",
			    text: msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Creacion de Justificantes", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/sJustificante?tipo=4";
			}
		});
        }
        //Redireccion a EXPEDIENTE despues de una consulta externa
        if(pag===11){
            swal({   
                            title: "Consulta Realizada",
			    text: msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Finalizar Consulta", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/MenuPrincipal";
			}
		});
        }
        //Redireccion a RECETA despues de una consulta no agendada
        if(pag===12){
            swal({   
                            title: "Consulta Realizada",
			    text: msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Crear Receta", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	      window.location="http://localhost:8080/SAC/sReceta?tipo=0";
			} 
		});
        }
        //Redireccion a JUSTIFICANTE despues de una consulta no agendada
        if(pag===13){
            swal({   
                title: "Consulta Realizada",
			    text: msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Crear Justificante", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/sJustificante?tipo=4";
			}
		});
        }
        //Redireccion a EXPEDIENTE despues de una consulta no agendada
        if(pag===14){
            swal({   
                            title: "Consulta Realizada",
			    text: msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Finalizar Consulta", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/MenuPrincipal";
			}
		});
        }
        //ERROR retorno a Consulta
        if(pag===15){
            swal({   
                            title: "Error al ingresar los datos",
			    text: msj,
			    type: "error",   
			    showCancelButton: false,  
			    confirmButtonColor: "#9A2817", 
			    confirmButtonText: "Regresar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     history.back();
			}
		});
        }
        //Redirección Consulta de recetas
        if(pag===16){
            swal({   
                            title: "Receta Creada",
			    text:msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Mis Recetas", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/sReceta?tipo=2";
			}
		});
        }
        //ERROR retorno a Receta
        if(pag===17){
            swal({   
                            title: "Error al ingresar los datos",
			    text:"No se pudo realizar tu consulta por favor reviza los datos que ingresaste",
			    type: "error",   
			    showCancelButton: false,  
			    confirmButtonColor: "#9A2817", 
			    confirmButtonText: "Regresar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	    history.back();
			}
		});
        }
        //Redirección a mis Justificantes para que se pueda hacer su impresion
        if(pag===18){
            swal({   
                            title: "Justificantes Creado",
			    text:msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Mis justificantes", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/sJustificante?tipo=1";
			}
		});
        }
        //ERROR retorno a Jsutificante
        if(pag===19){
            swal({   
                            title: "Error al ingresar los datos",
			    text:msj,
			    type: "error",   
			    showCancelButton: false,  
			    confirmButtonColor: "#9A2817", 
			    confirmButtonText: "Regresar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     history.back();
			}
		});
        }
        //Modificacion de una consulta
        if(pag===20){
            swal({   
                            title: "Consulta Modificada",
			    text:msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Verificar Cambios", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/sConsulta?redireccion=3";
			}
		});
        }
        //Modificacion de una receta
        if(pag===21){
            swal({   
                            title: msj,
			    text:"La descripción de la receta fue modificada con éxito!",
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Verificar Cambios", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/sConsulta?redireccion=3";
			}
		});
        }
        //Modificacion de un justificante
        if(pag===22){
            swal({   
                            title: msj,
			    text:"El justificante fue modificado con éxito!",
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Verificar Cambios", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/sJustificante?tipo=1";
			}
		});
        }
        //Eliminando consulta
        if(pag===23){
            swal({   
                            title:"Consulta Eliminada",
			    text:msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Inicio", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/MenuPrincipal";
			}
		});
        }
        //Eliminando justificante
        if(pag===24){
            swal({   
                            title:"Justificante Eliminado",
			    text:msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Mis Justificantes", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/sJustificante?tipo=1";
			}
		});
        }
        //Eliminando justificante
        if(pag===25){
            swal({   
                            title:"Solicitud Aceptada",
			    text:msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Guardar Cambios", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/login.jsp";
			}
		});
        }
        //Eliminando consulta
        if(pag===26){
            swal({   
                            title:"Ops hubo un error en la Solicitud!",
			    text:msj,
			    type: "error",   
			    showCancelButton: false,  
			    confirmButtonColor: "#9A281", 
			    confirmButtonText: "Inicio", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/login.jsp";
			}
		});
        }
        if(pag===27){
            swal({   
                            title:"Solicitud Rechazada",
			    text:msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Guardar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/login.jsp";
			}
		});
        }
        if(pag===28){
            swal({   
                            title:"Cuenta Personal Activada",
			    text:msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Guardar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/login.jsp";
			}
		});
        }
        if(pag===29){
            swal({   
                            title:"Cuenta Familiar Activada",
			    text:msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Guardar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/login.jsp";
			}
		});
        }
         if(pag===30){
            swal({   
                            title:"Solicitud Familiar Enviada",
			    text:msj,
			    type: "success",   
			    showCancelButton: false,  
			    confirmButtonColor: "#095A1E", 
			    confirmButtonText: "Guardar", 
			    closeOnConfirm: false,   
			    closeOnCancel: false }, 
			    function(isConfirm){
			    	if (isConfirm) {
			    	     window.location="http://localhost:8080/SAC/login.jsp";
			}
		});
        }
}
//FINAL DE LA FUNCTION REDIRECCION
function correoBD(correo){
    $.post('sInteractividad', {
        tipo_interaccion : "correo",
	mail: correo
        }, function(responseText) {
            $('#relacion').html(responseText);
	});
}
function solicitud(correo){
    $.post('sInteractividad', {
        tipo_interaccion : "solicitud",
	mail: correo
        }, function(responseText) {
            $('#relacion').html(responseText);
	});
}