package servlet;

/*
 * uploadFichero.java
 *
 * Created on 4 de agosto de 2003, 22:26
 */

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import java.util.*;
/**
 *
 * @author  Roberto Canales
 * @version
 */

@WebServlet("/GetFile")
public class GetFile extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();
		        out.println("<html>");
		        out.println("<head>");
		        out.println("<title>Servlet</title>");
		        out.println("</head>");
		        out.println("<body>");

		        System.out.println("Comenzamos procesamiento ficheros");

		        procesaFicheros(request,out);

		        out.println("</body>");
		        out.println("</html>");

		        out.close();
		    }


		    void depura(String cadena)
		    {
		        System.out.println("El error es " + cadena);
		    }

		    public boolean procesaFicheros(HttpServletRequest req, PrintWriter out ) {
		        try {
		            // construimos el objeto que es capaz de parsear la perición
		            DiskFileUpload fu = new DiskFileUpload();

		            		// maximo numero de bytes</font>
		            fu.setSizeMax(1024*512); // 512 K

		            depura("Ponemos el tamaño máximo");
		            // tamaño por encima del cual los ficheros son escritos directamente en disco</font>
		            fu.setSizeThreshold(4096);

		            // directorio en el que se escribirán los ficheros con tamaño superior al soportado en memoria</font>
		            fu.setRepositoryPath("/tmp");

		            // ordenamos procesar los ficheros</font>
		            List fileItems = fu.parseRequest(req);

		            if(fileItems == null)
		            {
		                depura("La lista es nula");
		                return false;
		            }

		            out.print("<br>El número de ficheros subidos es: " +  fileItems.size());

		      // Iteramos por cada fichero</font>
		 Iterator i = fileItems.iterator();
         FileItem actual = null;
         depura("estamos en la iteración");

         while (i.hasNext())
         {
             actual = (FileItem)i.next();
             String fileName = actual.getName();
             out.println("<br>Nos han subido el fichero" + fileName);

           // construimos un objeto file para recuperar el trayecto completo</font>
             File fichero = new File(fileName);
             depura("El nombre del fichero es " + fichero.getName());

             // nos quedamos solo con el nombre y descartamos el path</font>
             fichero = new  File("<b>c:\\ficherossubidos\\</b>" + fichero.getName());

             // escribimos el fichero colgando del nuevo path</font>
             actual.write(fichero);
         }

     }
     catch(Exception e) {
         depura("Error de Aplicación " + e.getMessage());
         return false;
     }

     return true;
 }

 /** Handles the HTTP <code>POST</code> method.
  * @param request servlet request
  * @param response servlet response
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
     processRequest(request, response);
 }
}