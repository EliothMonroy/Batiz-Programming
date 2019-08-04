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

/*** @author LifeSoft */
@WebServlet(name = "sLogin", urlPatterns = {"/sLogin"})
public class sLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(request.getParameter("Email")!=null && request.getParameter("Contra")!=null){
            String email=request.getParameter("Email");
            String pass=request.getParameter("Contra");
            String validacion=email+pass;
            if(validacion.contains("/")||validacion.contains("<")||validacion.contains(">")||validacion.contains("\\")||validacion.contains("'")||validacion.contains("+")||validacion.contains("|")){
                response.sendRedirect("login.jsp?msj=Porfa Comportese ;)");//Trato de  meter una inyection
                System.out.println("Metieron simbolo raro");
            }else{
                System.out.println("No hay simbolos raros");
                //CONEXION a la BD
                BD.cDatos BD= new cDatos();
                try {
                    BD.Conexion();
                    ResultSet ingresa= BD.Consulta("call sp_login('"+email+"', '"+pass+"', 0);");
                    if(ingresa.next()){
                        int valido=ingresa.getInt("valido");
                        if(valido==1){
                            System.out.println("Entro usuario");
                     //Correo y contraseña resgitrados
                            //Revisando si el correo es familiar
                            ResultSet familia= BD.Consulta("call sp_familia('"+email+"');");
                            //Si el correo es familiar muesto los perfiles
                            if(familia.next()){
                                response.sendRedirect("sLoginFamiliar?correo="+email+"&tipo=0");
                            }else{
                                System.out.println("No tiene familia");
                                //Si no es correo familiar todo sigue igual
                                HttpSession sesion_usuario=request.getSession();
                                sesion_usuario.setMaxInactiveInterval(14400);//segundos=4 horas
                                ResultSet sesionesDB=BD.Consulta("call sp_sesiones('"+email+"', '"+pass+"');");
                                if(sesionesDB.next()){
                                    sesion_usuario.setAttribute("correo",email);
                                    sesion_usuario.setAttribute("id_usuario",String.valueOf(sesionesDB.getInt("id_usuario")));
                                    sesion_usuario.setAttribute("contraseña",sesionesDB.getString("contraseña"));
                                    sesion_usuario.setAttribute("tipo",String.valueOf(sesionesDB.getInt("tipo")));
                                    response.sendRedirect("sRedirect?redirect=1&msj="+ingresa.getString("msj"));//Todo bien
                                    System.out.println("Bienvenido");
                                //sesiones
                                }else{
                                    System.out.println("Procedure sesiones no retorno nada");
                                    response.sendRedirect("sRedirect?redirect=0");
                                }
                            //Familia
                            }
                        }else{
                            if(valido==2){
                                System.out.println("Entro cliente first time");
                                HttpSession sesion_usuario=request.getSession();
                                
                                sesion_usuario.setAttribute("correo", email);
                                sesion_usuario.setAttribute("contraseña", pass);
                                response.sendRedirect("configuracionesCliente.jsp");
                            }else{
                                if(valido==0){
                                    System.out.println("No esta registrado");
                                    response.sendRedirect("login.jsp?msj=No estas registrado :/");
                                }else{
                                    System.out.println("Valido regreso algo extraño");
                                    response.sendRedirect("login.jsp?msj=Algo extraño paso :(");
                                }
                            }
                        }  
                    }else{
                        response.sendRedirect("login.jsp?val=1");//No estas registrado
                    }
                }catch (SQLException ex) {
                    System.out.println(ex);
                    response.sendRedirect("sRedirect?redirect=0");
                }
        //--BD
            }
        }else{
            response.sendRedirect("index.jsp?msj=Llene los campos");
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