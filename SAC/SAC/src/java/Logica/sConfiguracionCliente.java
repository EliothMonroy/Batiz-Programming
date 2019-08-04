/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import Objetos.Cliente;
import Objetos.Empleado;
import Objetos.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "sConfiguracionCliente", urlPatterns = {"/ConfiguracionCliente"})
public class sConfiguracionCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion_usuario=request.getSession();
        cHTML UI= new cHTML();
        String head= UI.head("Configuración", "Clinicas, SAC, Administración de Clinicas, Palabras clave","SAC te permite configurar de una manera fácil a todo aquel que este relacionado con tu clínica.");
        String footer=UI.footer();
        String correo=(String)sesion_usuario.getAttribute("correo");
        String contraseña=(String)sesion_usuario.getAttribute("contraseña");
        if(correo!=null && contraseña!=null)
        {
            Cliente cliente=new Cliente(correo, contraseña);
            int tipo=cliente.getTipo();
                //Dependiendo del tipo de cliente es el formulario a desplegar
                if(tipo==0){//Cliente Doctor Recien registrado
                    System.out.println("Creando Objeto Doctor");
                    String nombre=request.getParameter("Nombre");
                    String paterno=request.getParameter("Paterno");
                    String materno=request.getParameter("Materno");
                    String estudios=request.getParameter("Grado_Estudios");
                    String especialidad=request.getParameter("Especialidad");
                    String institucion=request.getParameter("Institucion");
                    String cedula=request.getParameter("Cedula");
                    if(nombre==null || paterno==null || materno==null || estudios==null || institucion==null || cedula==null){
                        response.sendRedirect("logout");
                    }
                    String validacion="";
                    int valido=0;
                    Empleado empleado=new Empleado(correo, contraseña, 5, nombre, paterno, materno);
                    if(especialidad!=null){
                        validacion=nombre+paterno+materno+estudios+especialidad+institucion+cedula;
                        if(validacion.contains("/")||validacion.contains("<")||validacion.contains(">")||validacion.contains("\\")||validacion.contains("'")||validacion.contains("+")||validacion.contains("|")){
                            System.out.println("Inyeccion");                        
                            response.sendRedirect("configuracionesCliente.jsp?msj=Caracter Invalido, por favor omita: <>, ', /");//Trato de  meter una inyection
                        }                        
                        valido=empleado.registrarDoctorAdmi(estudios, especialidad, institucion, cedula);
                    }else{//No ingreso una especialidad
                        validacion=nombre+paterno+materno+estudios+institucion+cedula;
                        if(validacion.contains("/")||validacion.contains("<")||validacion.contains(">")||validacion.contains("\\")||validacion.contains("'")||validacion.contains("+")||validacion.contains("|")){
                            System.out.println("Inyeccion");                        
                            response.sendRedirect("configuracionesCliente.jsp?msj=Caracter Invalido, por favor omita: <>, ', /");//Trato de  meter una inyection
                        }
                        valido=empleado.registrarDoctorAdmi(estudios, "", institucion, cedula);
                    }
                    if(valido==1){
                        sesion_usuario.setAttribute("tipo", "5");
                        int id_usuario=empleado.getId();
                        if(id_usuario!=0){
                            sesion_usuario.setAttribute("id_usuario", String.valueOf(id_usuario));                          
                        }else{
                            System.out.println("Id del usuario igual a 0");
                        }
                        System.out.println("Registró al doctor admi");
                        response.sendRedirect("sRedirect?redirect=34&msj=Registro Finalizado");
                    }else{
                        System.out.println("Fue registrado en usuario pero no empleado");
                        response.sendRedirect("logout");
                     }
                }else{
                    if(tipo==1){//Clínica recien registrada.
                        System.out.println("Creando objeto Clínica");
                        Usuario usuario=new Usuario(correo, contraseña, 0);
                        int val=usuario.registrarUsuario();//Registramos a la clinica como admi.
                        if(val==1){//Registro exitoso.
                            sesion_usuario.setAttribute("tipo", "0");
                            int id_usuario=usuario.getId();//Obtenemos el id del usuario.
                            if(id_usuario!=0){
                                sesion_usuario.setAttribute("id_usuario", String.valueOf(id_usuario));
                                response.sendRedirect("AltaUsuario");
                            }else{
                                System.out.println("Id del usuario igual a 0");
                                response.sendRedirect("logout");
                            }                          
                        }else{//No deberia de llegar aquí.
                            System.out.println("Algo raro con el método registrarAdmi");
                            response.sendRedirect("logout");
                        }
                    }else{//Mucho menos aquí.
                        System.out.println("");
                        response.sendRedirect("logout");//NO es ni clinica ni doc, quien rayos es ?

                    }
                }
        }else{
            response.sendRedirect("index.jsp?msj=Entro a config");
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
