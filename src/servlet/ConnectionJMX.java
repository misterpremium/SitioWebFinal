package servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.*;  

import amqlib.*;




/**
 * Servlet implementation class ConnectionJMX
 */
@WebServlet("/ConnectionJMX")
public class ConnectionJMX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   /* public ConnectionJMX() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String saludo = "hola", despedida = "adios";
		//test v4
		//Producctor.enviaMensajeCola("Hola");
		//Main test = new Main();
	
		//test.Main.ejecutarCola("Hola", "Adios");
		
		//this.ejecutarCola(saludo, despedida);
		
		
		Class<Main> c=Main.class;  
		Object obj = null;
		try {
			obj = c.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		Method m = null;
		try {
			m = c.getDeclaredMethod("ejecutarCola",new Class[]{String.class,String.class});
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		m.setAccessible(true);
		try {
			m.invoke(obj,saludo, despedida);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		ProcessBuilder builder = new ProcessBuilder("java", "-jar", "AMQ.jar");		
		Process proces = builder.start();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + proces + "</h1>");
		
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
}
