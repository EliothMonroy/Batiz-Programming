package Logica;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Elioth
 */
@WebServlet(name = "sRedirect2", urlPatterns = {"/sRedirect2"})
public class sRedirect2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                        HttpSession sesion_usuario=request.getSession();
            if(sesion_usuario.getAttribute("id_usuario")!=null && sesion_usuario.getAttribute("tipo")!=null)
            {
                if(request.getParameter("redirect")!=null){
                    int redireccion=Integer.parseInt(request.getParameter("redirect"));
                    String msj=request.getParameter("msj");
                    out.print("<!DOCTYPE html>");
                    out.print("<head>");                    
                    out.print("</head>");
                    out.print("<body>");
                    switch(redireccion){
                        case 0://Error Inesperado
                            response.sendRedirect("login.jsp&msj=Algo inesperado sucedio, toda tu informacion esta asalvo no te preocupes");
                            break;
                        case 1://Login exitoso
                            response.sendRedirect("MenuPrincipal?redirect="+redireccion+"&msj="+msj);
                            break;
                        case 2://Registro de Usuario Exitoso
                            response.sendRedirect("ConsultarUsuario?redirect="+redireccion+"&msj="+msj);
                            break;
                        case 3://Registro de usuario no exitoso
                            response.sendRedirect("AltaUsuario?redirect="+redireccion+"&msj="+msj);
                            break;
                        case 4://Baja usuario exitosa
                            response.sendRedirect("ConsultarUsuario?redirect="+redireccion+"&msj="+msj);
                            break;
                        case 5://Baja usuario no exitosa usuario no encontrado
                            response.sendRedirect("BorrarUsuario?redirect="+redireccion+"&msj="+msj);
                            break;
                        case 6://Usuario modificado con exito
                            response.sendRedirect("ConsultarUsuario?redirect="+redireccion+"&msj="+msj);
                            break;
                        case 7://Usuario no modificado
                            response.sendRedirect("ModificarUsuario?redirect="+redireccion+"&msj="+msj);
                            break;
                        case 8://Busqueda de Usuario no exitosa
                            response.sendRedirect("ConsultarUsuario?redirect="+redireccion+"&msj="+msj);
                            break;
                        case 9://Redireccion a RECETA despues de una consulta externa
                            response.sendRedirect("sReceta?tipo=0");
                            break;
                        case 10://Redireccion a JUSTIFICANTE despues de una consulta externa
                            response.sendRedirect("sJustificante?tipo=4");
                            break;
                        case 11://Redireccion a EXPEDIENTE despues de una consulta externa
                            response.sendRedirect("MenuPrincipal");
                            break;
                        case 12://Redireccion a RECETA despues de una consulta no agendada
                            response.sendRedirect("sReceta?tipo=0");
                            break;
                        case 13://Redireccion a JUSTIFICANTE despues de una consulta no agendada
                            response.sendRedirect("sJustificante?tipo=4");
                            break;
                        case 14://Redireccion a EXPEDIENTE despues de una consulta no agendada
                            response.sendRedirect("MenuPrincipal");
                            break;
                        case 15://ERROR retorno a Consulta
                            response.sendRedirect("sConsulta");
                            break;
                        case 16://Redirección Consulta de recetas
                            response.sendRedirect("sReceta?tipo=2");
                            break;
                        case 17://ERROR retorno a Receta
                            response.sendRedirect("sReceta");
                            break;
                        case 18://Redirección a mis Justificantes para que se pueda hacer su impresion
                            response.sendRedirect("sJustificante?tipo=1");
                            break;
                        case 19://ERROR retorno a Justificante
                            response.sendRedirect("sJustificante");
                            break;
                        case 20://Modificacion de una consulta
                            response.sendRedirect("sConsulta?redireccion=3");
                            break;
                        case 21://Modificacion de una receta
                            response.sendRedirect("sConsulta?redireccion=3");
                            break;
                        case 22://Modificacion de un justificante
                            response.sendRedirect("sJustificante?tipo=1");
                            break;
                        case 23://Eliminando consulta
                            response.sendRedirect("MenuPrincipal");
                            break;
                        case 24://Eliminando justificante
                            response.sendRedirect("sJustificante?tipo=1");
                            break;
                        case 25:
                            response.sendRedirect("sConsulta?redireccion=3");
                            break;
                        case 26:
                            response.sendRedirect("sConsulta?redireccion=3");
                            break;
                        case 27:
                            response.sendRedirect("sConsulta?redireccion=3");
                            break;
                        default:
                            response.sendRedirect("login.jsp");
                            break;
                    }
                    out.print("</body>");
                    out.print("</html>");
                }else{
                    response.sendRedirect("MenuPrincipal");
                }                    
            }else{
                response.sendRedirect("login.jsp");
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
