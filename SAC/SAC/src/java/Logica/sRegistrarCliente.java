/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Objetos.Cliente;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author LifeSoft
 */
@WebServlet(name = "sRegistrarCliente", urlPatterns = {"/sRegistrarCliente"})
public class sRegistrarCliente extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "Images";
    private final String Path="G:\\GitHub\\SAC\\SAC\\src";
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB


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
        response.sendRedirect("index.jsp");
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
                PrintWriter writer = response.getWriter();
        if (request.getSession().getAttribute("correo") != null && request.getSession().getAttribute("contra")!=null){
        
            if (!ServletFileUpload.isMultipartContent(request)){

                writer.println("<script>alert ('Formulario invalido');</script>");
                // Si no, aquí paramos.                
                writer.println("Error: Form must has enctype=multipart/form-data.");
                writer.flush();
                response.sendRedirect("index.jsp");
                return;
            }
            // configures upload settings
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // sets memory threshold - beyond which files are stored in disk
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            // sets temporary location to store files
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);

            // sets maximum size of upload file
            upload.setFileSizeMax(MAX_FILE_SIZE);

            // sets maximum size of request (include file + form data)
            upload.setSizeMax(MAX_REQUEST_SIZE);

            // constructs the directory path to store upload file
            // this path is relative to application's directory

            String url = "http://localhost:8080/SAC"+ File.separator + UPLOAD_DIRECTORY;
            //NO olviden cambiar la url
            String uploadPath = Path + File.separator + UPLOAD_DIRECTORY; 
            // creates the directory if it does not exist
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                // parses the request's content to extract file data
                @SuppressWarnings("unchecked")
                List<FileItem> formItems = upload.parseRequest(request);

                if (formItems != null && formItems.size() > 0) {
                    // iterates over form's fields
                    for (FileItem item : formItems) {
                        // processes only fields that are not form fields
                        if (!item.isFormField()) {                        
                            String fileName = new File(item.getName()).getName();
                            if(fileName.endsWith(".png")||fileName.endsWith("jpg")){
                                HttpSession sesion_cliente=request.getSession();
                                String email=(String) sesion_cliente.getAttribute("correo");
                                if(fileName.endsWith(".png")){
                                    fileName=email+".png";
                                }else{
                                    fileName=email+".jpg";
                                }
                                String filePath = uploadPath + File.separator + fileName;
                                filePath=filePath.replace("\\", "/");
                                //String filePath=uploadPath+"\\"+fileName;
                                try{
                                    //Obtenemos las variables de sesion
                                    
                                    String contra=(String) sesion_cliente.getAttribute("contra");
                                    String nombre=(String) sesion_cliente.getAttribute("nombre");
                                    String tipo=(String) sesion_cliente.getAttribute("tipo");
                                    int tipob=Integer.parseInt(tipo);
                                    String direccion=(String) sesion_cliente.getAttribute("direccion");
                                    String telefono=(String) sesion_cliente.getAttribute("telefono");
                                    String slogan=(String) sesion_cliente.getAttribute("slogan");
                                    //Creamos un objeto cliente.
                                    Cliente cliente=new Cliente(email, contra, nombre, tipob, direccion, telefono, filePath, slogan);
                                    //Tratamos de registrar al cliente.
                                    int val=cliente.registrarCliente();
                                    //Vemos que trae val.
                                    if(val==1){//Entonces el cliente fue registrado bien.
                                        File storeFile = new File(filePath);
                                        // saves the file on disk
                                        item.write(storeFile);
                                        response.sendRedirect("sRedirect?redirect=31&msj=Ahora puede Iniciar Sesion, y cambiar su vida para siempre");
                                    }else{
                                        if(val==0){
                                            item.delete();
                                            response.sendRedirect("sRedirect?redirect=32&msj=Al parecer ya estas registrado, o al menos tu correo :D");
                                        }else{
                                            item.delete();
                                            response.sendRedirect("sRedirect?redirect=0");
                                        }                                        
                                    }

                                }catch(Exception e){
                                    response.sendRedirect("sRedirect?redirect=0&msj="+e+"");
                                }
                        }else{
                                response.sendRedirect("sRedirect?redirect=33&msj=Formato de imagen invalido, debe ser .png ó .jpg");
                            }
                    }
                }
                }
            }catch (FileUploadException ex) {
                response.sendRedirect("sRedirect?redirect=0");
            }
        }else{
            response.sendRedirect("index.jsp");
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
