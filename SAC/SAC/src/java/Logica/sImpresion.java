 package Logica;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/*** @author JuanDaniels*/
@WebServlet(name = "sImpresion", urlPatterns = {"/sImpresion"})
public class sImpresion extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
		      Document document = new Document(PageSize.LETTER);
                      ByteArrayOutputStream baos = new ByteArrayOutputStream();
		      PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);
		      document.open();
		      document.addAuthor("LIFE-SOFT Company");
		      document.addCreator("SAC Sistema de Administración de Cínicas");
		      document.addSubject("Expediente Médico");
		      document.addCreationDate();
		      document.addTitle("Expediente Médico Personalizado.");

		      XMLWorkerHelper worker = XMLWorkerHelper.getInstance();

		      String str = "<html><head></head><body>"+
		        "<a href='#'><b>SAC.com</b></a>" +
		        "<h1 style='text-align:center;'></h1>"
                      + "<h3>Ejercicio para vver que tags y estilos se aceptan</h3>" +
		        "<p>Esto es un etiqueta. p</p>" +
		        "<p>Contributions via PayPal are accepted in any amount</p>" +
		        "<P><br/><table border='1' style='text-align:center;'><tr><td>Java HowTo</td></tr><tr>" +
		        "<td style='background-color:red;'>Javascript HowTo</td></tr>" +
		        "<tr><td></td></tr></table></p>" +
		        "<article style='background-color:gray;'>"
                              + "<h3>Desarrollado por: <p><i>Lifesoft </i></p></h3>"
                              + "</article></body></html>";
		      worker.parseXHtml(pdfWriter, document, new StringReader(str));
		      document.close();
                      //Mandar el documento por medio de un response al cliente
                        response.setHeader("Expires", "0");
                        response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
                        response.setHeader("Pragma", "public");

                        response.setContentType("application/pdf");
                        
                        response.setContentLength(baos.size());

                        ServletOutputStream out = response.getOutputStream();
                        baos.writeTo(out);
                        out.flush();
		      }
		    catch (Exception e) {
		      e.printStackTrace();
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
