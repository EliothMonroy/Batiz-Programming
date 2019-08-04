package Logica;

import BD.cDatos;
import Objetos.Empleado;
import Objetos.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
 * @author ELITH
 */
@WebServlet(name = "sRegistrandoUsuario", urlPatterns = {"/RegistrandoUsuario"})
public class sRegistrandoUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion_usuario=request.getSession();
            /* TODO output your page here. You may use following sample code. */
            if(sesion_usuario.getAttribute("id_usuario")!=null && sesion_usuario.getAttribute("tipo")!="4" && request.getParameter("Enviar").equals("Enviar"))
            {
                cDatos BD= new cDatos();
                try{
                    BD.Conexion();
                        String correo=request.getParameter("Correo");
                        String contra=request.getParameter("r_contra");
                        String nombre=request.getParameter("Nombre");
                        String paterno=request.getParameter("Apellido_p");
                        String materno=request.getParameter("Apellido_m");
                        String tipo=request.getParameter("Tipo");
                        //Ver si no son nulls.
                    if(correo==null || contra==null || nombre==null || paterno==null || materno==null || tipo==null){
                        response.sendRedirect("logout");
                    }
                    String validacion=correo+contra+tipo+nombre+paterno+materno;
                    int valido = 0;
                    if(validacion.contains("/")||validacion.contains("<")||validacion.contains(">")||validacion.contains("\\")||validacion.contains("'")||validacion.contains("+")||validacion.contains("|")){
                        System.out.println("Inyeccion en Agregar Usuario");                        
                        response.sendRedirect("AltaUsuario?msj=Caractér o caracteres invalidos.");//Trato de  meter una inyection
                    }
                    if(tipo.equals("0")){//Registrando a un administrador
                        Empleado empleado=new Empleado(correo, contra, Integer.parseInt(tipo), nombre, paterno, materno);
                        valido=empleado.registrarAdmi();
                    }else{
                        if(tipo.equals("1")){//Registrando a un doctor.
                            String estudios=request.getParameter("Estudios");
                            String especialidad=request.getParameter("Especialidad");
                            String institucion=request.getParameter("Institucion");
                            String cedula=request.getParameter("Cedula");
                            if(estudios==null || institucion==null || cedula==null){
                                response.sendRedirect("logout");
                            }
                            //Validación pos si especialidad es null.
                            if(especialidad!=null){//Tiene especialidad
                                validacion=estudios+especialidad+institucion+cedula;
                                if(validacion.contains("/")||validacion.contains("<")||validacion.contains(">")||validacion.contains("\\")||validacion.contains("'")||validacion.contains("+")||validacion.contains("|")){
                                    System.out.println("Inyección en Agregar Usuario Doctor con especialidad");                        
                                    response.sendRedirect("AltaUsuario?msj=Caractér o caracteres invalidos.");//Trato de  meter una inyection
                                }
                                Empleado empleado=new Empleado(correo, contra, Integer.parseInt(tipo), nombre, paterno, materno);
                                valido=empleado.registrarDoctor(estudios, especialidad, institucion, cedula); 
                            }else{//No tiene especialidad.
                                validacion=estudios+institucion+cedula;
                                if(validacion.contains("/")||validacion.contains("<")||validacion.contains(">")||validacion.contains("\\")||validacion.contains("'")||validacion.contains("+")||validacion.contains("|")){
                                    System.out.println("Inyección en Agregar Usuario Doctor sin especialidad");                        
                                    response.sendRedirect("AltaUsuario?msj=Caractér o caracteres invalidos.");//Trato de  meter una inyection
                                }
                                Empleado empleado=new Empleado(correo, contra, Integer.parseInt(tipo), nombre, paterno, materno);
                                valido=empleado.registrarDoctor(estudios, "", institucion, cedula);
                            }                         
                        }else{
                            if(tipo.equals("2")){//Registrando a un secretaria
                                Empleado empleado=new Empleado(correo, contra, Integer.parseInt(tipo), nombre, paterno, materno);
                                valido=empleado.registrarSecretaria();
                            }else{
                                if(tipo.equals("3")){//Registrando a un enfermera.
                                    String estudios=request.getParameter("Estudios");
                                    String especialidad=request.getParameter("Especialidad");
                                    String institucion=request.getParameter("Institucion");
                                    String cedula=request.getParameter("Cedula");
                                    if(estudios==null || institucion==null || cedula==null){
                                        response.sendRedirect("logout");
                                    }
                                    if(especialidad!=null){//Tiene especialidad
                                        validacion=estudios+especialidad+institucion+cedula;
                                        if(validacion.contains("/")||validacion.contains("<")||validacion.contains(">")||validacion.contains("\\")||validacion.contains("'")||validacion.contains("+")||validacion.contains("|")){
                                            System.out.println("Inyección en Agregar Usuario Doctor con especialidad");                        
                                            response.sendRedirect("AltaUsuario?msj=Caractér o caracteres invalidos.");//Trato de  meter una inyection
                                        }
                                        Empleado empleado=new Empleado(correo, contra, Integer.parseInt(tipo), nombre, paterno, materno);
                                        valido=empleado.registrarEnfermera(estudios, especialidad, institucion, cedula); 
                                    }else{//No tiene especialidad.
                                        validacion=estudios+institucion+cedula;
                                        if(validacion.contains("/")||validacion.contains("<")||validacion.contains(">")||validacion.contains("\\")||validacion.contains("'")||validacion.contains("+")||validacion.contains("|")){
                                            System.out.println("Inyección en Agregar Usuario Doctor sin especialidad");                        
                                            response.sendRedirect("AltaUsuario?msj=Caractér o caracteres invalidos.");//Trato de  meter una inyection
                                        }
                                            Empleado empleado=new Empleado(correo, contra, Integer.parseInt(tipo), nombre, paterno, materno);
                                            valido=empleado.registrarEnfermera(estudios, "", institucion, cedula);
                                    } 
                                }else{
                                    if(tipo.equals("4")){//Registrando a un paciente.
                                        String curp=request.getParameter("Curp");
                                        String nacimiento=request.getParameter("Nacimiento");
                                        String sexo=request.getParameter("Sexo");
                                        String sangre=request.getParameter("Sangre");
                                        if(curp==null || nacimiento==null || sexo==null || sangre==null){
                                            response.sendRedirect("logout");                                            
                                        }
                                        validacion=curp+nacimiento+sexo+sangre;
                                        if(validacion.contains("/")||validacion.contains("<")||validacion.contains(">")||validacion.contains("\\")||validacion.contains("'")||validacion.contains("+")||validacion.contains("|")){
                                            System.out.println("Inyección en Agregar a paciente");                        
                                            response.sendRedirect("AltaUsuario?msj=Caractér o caracteres invalidos.");//Trato de  meter una inyection
                                        }
                                        Paciente empleado=new Paciente(correo, contra, Integer.parseInt(tipo), nombre, paterno, materno);
                                        valido=empleado.registrarPaciente(curp, nacimiento, Integer.parseInt(sexo), sangre);
                                    }
                                }
                            }
                        }
                    }                  
                    
                            if(valido==1){
                                //Revisar relación con lagun correo familiar
                                    String tipo_relacion=request.getParameter("r_relacion");
                                    if(tipo_relacion!=null){
                                        ResultSet ids=BD.Consulta("call sp_obtenercorreos('"+correo+"');");
                                    if(ids.next()){
                                        do{
                                            //Creo vinculacion
                                            ResultSet vincula=BD.Consulta("call sp_vincularcorreos('"+correo+"',"+ids.getString("id_usuario")+", "+tipo_relacion+");");
                                        }while(ids.next());
                                    }
                                    }
                                response.sendRedirect("sRedirect?redirect=2&msj=Usuario ya registrado");
                            }else{
                                response.sendRedirect("sRedirect?redirect=3&msj=Usuario ya existe");
                            }                            
                       
                }catch(SQLException e){
                    System.err.print(e);
                    response.sendRedirect("sRedirect?redirect=0");
                }                    
            }else{
                response.sendRedirect("index.jsp?msj=Acceso Denegado");
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sRegistrandoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sRegistrandoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
