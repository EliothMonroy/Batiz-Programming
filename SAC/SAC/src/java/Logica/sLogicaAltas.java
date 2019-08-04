package Logica;

import BD.cDatos;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "sLogicaAltas", urlPatterns = {"/sLogicaAltas"})
public class sLogicaAltas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            //Sesiones
            HttpSession sesion_usuario=request.getSession();
            //Obteniendo el servlet que manda los datos
            String servlet= request.getParameter("servlet");
            String id_doc=(String)sesion_usuario.getAttribute("id_usuario");
            if(id_doc!=null){
                //Creando CONEXION a la base para aplicar los procedures...
                 BD.cDatos BD= new cDatos();
                try {
                    BD.Conexion();
                    } catch (SQLException ex) {
                    Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Condicionales para ver que procedure aplicar
                //--------SERVLET CONSULTA------------
                if(servlet.equals("consultaR")){
                    //Consulta para un usuario que ya ha sido dado de alta dentro del sistema
                    try {
                        String correo=request.getParameter("r_correo");
                        String edad=request.getParameter("r_edad");
                        String estatura=request.getParameter("r_estatura");
                        String peso=request.getParameter("r_peso");
                        String boton=request.getParameter("btnredirect");
                        String id_enfermedad=request.getParameter("r_enfermedad");
                        String anotaciones=request.getParameter("r_receta");
           
                        ResultSet query=BD.Consulta("call sp_ConsultaAltaModificacion('"+anotaciones+"','"+correo+"',1,"+id_doc+","+estatura+","+peso+", "+edad+",1,"+id_enfermedad+",1000);");
                        if(query.next()){//El query regreso algo...
                            if(query.getString("valido").equals("1")){//El curp ingresado es valido
                                //variable de sesion que guardara el id de la consulta
                                    sesion_usuario.setAttribute("id_consulta",query.getString("consulta"));
                                //variable para almacenar el id_ del paciente
                                    sesion_usuario.setAttribute("id_paciente",query.getString("paciente"));
                                if(boton.equals("Generar Receta")){
                                    response.sendRedirect("sRedirect?redirect=12&msj="+query.getString("msj")); 
                                }
                                if(boton.equals("Generar Justificante")){
                                    response.sendRedirect("sRedirect?redirect=13&msj="+query.getString("msj"));
                                }
                                if(boton.equals("Generar Expediente")){
                                    response.sendRedirect("sRedirect?redirect=14&msj="+query.getString("msj"));
                                }
                                BD.CloseConexion();
                            }//if valido
                            else{
                                if(boton.equals("Generar Receta")){
                                    response.sendRedirect("sRedirect?redirect=15&msj="+query.getString("msj")+"&extra=Curp Invalido"); 
                                }
                                if(boton.equals("Generar Justificante")){
                                    response.sendRedirect("sRedirect?redirect=15&msj="+query.getString("msj")+"&extra=Curp Invalido");
                                }
                                if(boton.equals("Generar Expediente")){
                                    response.sendRedirect("sRedirect?redirect=15&msj="+query.getString("msj")+"&extra=Curp Invalido");
                                }
                                BD.CloseConexion();
                            }//else valido 0
                        }
                         else{
                        response.sendRedirect("sConsulta?redireccion=0");
                        }
                } catch (SQLException ex) {
                    Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    //-------SERVLET CONSULTA------
                if(servlet.equals("consultaNR")){
                    //Uusario no registrado
                    try {
                        String curp=request.getParameter("r_curp");
                        String correo=request.getParameter("r_correo");
                        String edad=request.getParameter("r_edad");
                        String estatura=request.getParameter("r_estatura");
                        String peso=request.getParameter("r_peso");
                        String boton=request.getParameter("btnredirect");
                        String nombre=request.getParameter("r_nombre");
                        String paterno=request.getParameter("r_paterno");
                        String materno=request.getParameter("r_materno");
                        String contra=request.getParameter("r_contra");
                        String sexo=request.getParameter("r_sexo");
                        String id_enfermedad=request.getParameter("r_enfermedad");
                        String anotaciones=request.getParameter("r_desc");
                        ResultSet query=BD.Consulta("call sp_ConsultaExpressAM('"+curp+"',"+sexo+",'"+contra+"','"+anotaciones+"','"+correo+"',"+id_doc+","+estatura+","+peso+", "+edad+", '"+nombre+"','"+paterno+"','"+materno+"',1,1000,"+id_enfermedad+");");
                        if(query.next()){
                            //Variable de sesion que almacena el id de la consulta creada
                                sesion_usuario.setAttribute("id_consulta",query.getString("consulta"));
                            //Variable de sesion que guarda el id del paciente, EN ESTE CASO NO EXISTE EL PACIENTE
                                String paciente=query.getString("paciente");
                                System.out.println(paciente);
                                sesion_usuario.setAttribute("id_paciente",paciente);
                            //Revisar relación con lagun correo familiar
                                String relacion=request.getParameter("relacion");
                                if(relacion!=null){
                                    String tipo_relacion=request.getParameter("r_relacion");
                                    ResultSet ids=BD.Consulta("call sp_obtenercorreos('"+correo+"');");
                                    if(ids.next()){
                                        do{
                                            //Creo vinculacion
                                            ResultSet vincula=BD.Consulta("call sp_vincularcorreos('"+correo+"',"+ids.getString("id_usuario")+", "+tipo_relacion+");");
                                        }while(ids.next());
                                    }
                                }
                            if(boton.equals("Generar Receta")){
                            response.sendRedirect("sRedirect?redirect=9&msj="+query.getString("msj"));
                            }
                            if(boton.equals("Generar Justificante")){
                                response.sendRedirect("sRedirect?redirect=10&msj="+query.getString("msj"));
                            }
                            if(boton.equals("Generar Expediente")){
                                response.sendRedirect("sRedirect?redirect=11&msj="+query.getString("msj"));
                            }
                            BD.CloseConexion();
                        }else{
                       response.sendRedirect("sConsulta?redireccion=1");
                        }
                    } catch (SQLException e) {
                        Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }
                //------------SERVLET CONSULTA MODIFICACION------MODIFICACION------------MODIFICACION-------------MODIFICACION
                if(servlet.equals("ConsultaModificacion")){
                     try {
                         String correo=request.getParameter("r_correo");
                         String edad=request.getParameter("r_edad");
                         String estatura=request.getParameter("r_estatura");
                         String peso=request.getParameter("r_peso");
                         String id_enfermedad=request.getParameter("r_enfermedad");
                         String anotaciones=request.getParameter("r_receta");
                         String id_consulta=request.getParameter("id_cons");
                         
                         //Creando el query para modificar una consulta
                         ResultSet query=BD.Consulta("call sp_ConsultaAltaModificacion('"+anotaciones+"','"+correo+"',1,"+id_doc+","+estatura+","+peso+", "+edad+",0,"+id_enfermedad+","+id_consulta+");");
                         if(query.next()){
                             response.sendRedirect("sRedirect?redirect=20&msj="+query.getString("msj"));
                         }else{
                             response.sendRedirect("sConsulta?redireccion=1");
                         }
                     } catch (SQLException ex) {
                         Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
                //------------SERVLET CONSULTA BAJA-----------------BAJA--------------------BAJA---------------BAJA
                if(servlet.equals("BajaConsulta")){
                     try {
                         //Obteniendo el id_evento ha eliminar
                         String id_evento =request.getParameter("id_evento");
                         //Creando el query para eliminar consulta
                         ResultSet query=BD.Consulta("call sp_bajaConsulta("+id_evento+");");
                         if(query.next()){
                             response.sendRedirect("sRedirect?redirect=23&msj="+query.getString("msj"));
                         }else{
                             response.sendRedirect("sRedirect?redirect=19&msj="+query.getString("msj"));
                         }
                     } catch (SQLException ex) {
                         Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
                //------------SERVLET RECETA-------------
                if(servlet.equals("receta"))
                {
                     try {
                         String receta=request.getParameter("r_receta");
                         String id_paciente=request.getParameter("id_paciente");
                         String id_consulta=request.getParameter("id_consulta");
                         ResultSet query=BD.Consulta("call sp_RecetaAltaModificacion('"+receta+"',"+id_consulta+","+id_paciente+", "+id_doc+",1,1000);");
                            if(query.next()){
                                if(query.getString("valido").equals("1")){
                                    response.sendRedirect("sRedirect?redirect=16&msj="+query.getString("msj"));

                                }else{
                                    response.sendRedirect("sRedirect?redirect=17&msj="+query.getString("msj"));
                                }
                            }
                        } catch (SQLException ex) {
                        Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
                if(servlet.equals("RecetaModificacion")){
                    try {
                         String receta=request.getParameter("r_receta");
                         String id_paciente=request.getParameter("id_paciente");
                         String id_consulta=request.getParameter("id_consulta");
                         String id_receta=request.getParameter("id_rec");
                         ResultSet query=BD.Consulta("call sp_RecetaAltaModificacion('"+receta+"',"+id_consulta+","+id_paciente+", "+id_doc+",0,"+id_receta+");");
                            if(query.next()){
                                if(query.getString("valido").equals("0")){
                                    response.sendRedirect("sRedirect?redirect=21&msj="+query.getString("msj"));

                                }else{
                                    response.sendRedirect("sRedirect?redirect=17&msj="+query.getString("msj"));

                                }
                            }
                        } catch (SQLException ex) {
                        Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
                //------------SERVLET JUSTIFICANTE-------------
                if(servlet.equals("justificante")){
                    //Alta para Justificantes
                    String curp=request.getParameter("r_curp");
                    String edad=request.getParameter("r_edad");
                    String tel=request.getParameter("r_telefono");
                    String just=request.getParameter("r_justificante");
                    try {
                        ResultSet query=BD.Consulta("call sp_JustAM('"+id_doc+"','"+curp+"',"+tel+","+edad+",'"+just+"',1,1000);");                                                    
                        if(query.next()){
                            if(query.getString("valido").equals("1")){
                                response.sendRedirect("sRedirect?redirect=18&msj="+query.getString("msj"));
                            } else{
                                response.sendRedirect("sRedirect?redirect=19&msj="+query.getString("msj"));
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                }
                //Modificando Justificcante
                if(servlet.equals("justificanteM")){
                    //Alta para Justificantes
                    String curp=request.getParameter("r_curp");
                    String edad=request.getParameter("r_edad");
                    String tel=request.getParameter("r_telefono");
                    String just=request.getParameter("r_justificante");
                    String id_just=request.getParameter("id_just"); 
                    try {
                        ResultSet query=BD.Consulta("call sp_JustAM('"+id_doc+"','"+curp+"',"+tel+","+edad+",'"+just+"',0,"+id_just+");");                                                    
                        if(query.next()){
                            if(query.getString("valido").equals("2")){
                                response.sendRedirect("sRedirect?redirect=22&msj="+query.getString("msj"));
                            } else{
                                response.sendRedirect("sRedirect?redirect=19&msj="+query.getString("msj"));
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                }
                //Eliminando Justificcante
                if(servlet.equals("BajaJustificante")){
                    //Baja para Justificantes
                    String id_just=request.getParameter("id_justificante"); 
                    try {
                        ResultSet query=BD.Consulta("call sp_bajaJustificante("+id_just+");");                                                    
                        if(query.next()){
                            if(query.getString("valido").equals("1")){
                                response.sendRedirect("sRedirect?redirect=24&msj="+query.getString("msj"));
                            } else{
                                response.sendRedirect("sRedirect?redirect=19&msj="+query.getString("msj"));
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                }
                //Baja de una Cuenta Familiar
                if(servlet.equals("familiaA")){
                     try {
                         //Variables para aceptar una solicitud
                         String email=request.getParameter("correus");
                         String paciente=request.getParameter("id_pac");
                         ResultSet aceptar=BD.Consulta("call sp_aceptarSolicitud('"+email+"', "+paciente+");");
                         if(aceptar.next()){
                             if(aceptar.getString("valido").equals("1")){
                                 response.sendRedirect("sRedirect?redirect=25&msj="+aceptar.getString("msj"));
                             } else{
                                 response.sendRedirect("sRedirect?redirect=26&msj="+aceptar.getString("msj"));
                             }
                         }
                     } catch (SQLException ex) {Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);}
                }
                if(servlet.equals("familiaR")){
                     try {
                         //Variables para aceptar una solicitud
                         String email=request.getParameter("correus");
                         String paciente=request.getParameter("id_pac");
                         ResultSet aceptar=BD.Consulta("call sp_rechazarSolicitud('"+email+"', "+paciente+");");
                         if(aceptar.next()){
                             if(aceptar.getString("valido").equals("1")){
                                 response.sendRedirect("sRedirect?redirect=27&msj="+aceptar.getString("msj"));
                             } else{
                                 response.sendRedirect("sRedirect?redirect=26&msj="+aceptar.getString("msj"));
                             }
                         }
                     } catch (SQLException ex) {Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);}
                }
                if(servlet.equals("familiaN")){
                    String tipo_relacion=request.getParameter("r_relacion");
                        try {
                            //Creo vinculacion
                            String id_paciente=(String)sesion_usuario.getAttribute("id_usuario");
                            String correo=request.getParameter("r_correo");
                            ResultSet ids=BD.Consulta("call sp_obtenercorreos('"+correo+"');");
                                if(ids.next()){
                                    do{
                                        //Creo vinculacion
                                        ResultSet vincula=BD.Consulta("call sp_vincularcorreos('"+correo+"',"+ids.getString("id_usuario")+", "+tipo_relacion+");");
                                        }while(ids.next());
                                    }
                                ResultSet vincula1=BD.Consulta("call sp_vincularcorreos('"+correo+"',"+id_paciente+", "+tipo_relacion+");");
                                if(vincula1.next()){
                                    if(vincula1.getString("valido").equals("1")){
                                        response.sendRedirect("sRedirect?redirect=30&msj="+vincula1.getString("msj")); 
                                    }
                                   
                                }
                                
                        } 
                        catch (SQLException ex) {
                            Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                if(servlet.equals("familiaB")){
                     try {
                         String correon=request.getParameter("mailn");
                         String contran=request.getParameter("contran");
                         String id_paciente=(String)sesion_usuario.getAttribute("id_usuario");
                         String correo=(String)sesion_usuario.getAttribute("correo");
                         ResultSet baja=BD.Consulta("call sp_borrarparentescos('"+correo+"','"+correon+"','"+contran+"',"+id_paciente+");");
                         if(baja.next()){
                             if(baja.getString("valido").equals("1")){
                                 response.sendRedirect("sRedirect?redirect=28&msj="+baja.getString("msj"));
                             } else{
                                 response.sendRedirect("sRedirect?redirect=26&msj="+baja.getString("msj"));
                             }
                         }
                     } catch (SQLException ex) {
                         Logger.getLogger(sLogicaAltas.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
        }         else{
            response.sendRedirect("login.jsp?salida=Sesion expirada");
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
