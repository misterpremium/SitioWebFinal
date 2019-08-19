package servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.*;  
import javax.jms.JMSException;
import amqlib.Main;




/**
 * Servlet implementation class ConnectionJMX
 */
@WebServlet("/ConnectionJMX")
public class ConnectionJMX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws JMSException 
     * @see HttpServlet#HttpServlet()
     */
   public ConnectionJMX() throws JMSException {
        super();
        // TODO Auto-generated constructor stub		
		
    }


	

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
	
		//test v
		
		System.out.println("testv1");
	/*	
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
			String a = e.printStackTrace();
			out.println("<h1>"e.printStackTrace() "</h1>");
		}  
		m.setAccessible(true);
		try {
			m.invoke(obj,saludo, despedida);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		*/
		String saludo = "hola", despedida = "adios";
		
		//Main test = new Main();
	//	Main.ejecutarCola(saludo, despedida);
		System.out.println("test linea 38 antes Main.ejecutarCola");
		out.println("<h1> Test linea 39 </h1>");
		try {
			Main.ejecutarCola(saludo, despedida);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("<h1>faild to connect Error de Aplicación " + e.getMessage()+"</h1>");
			
		}
		
		
		/*ProcessBuilder builder = new ProcessBuilder("java", "-jar", "AMQ.jar");		
		Process proces = builder.start();
		*/
		response.setContentType("text/html");
		
		//out.println("<h1>" + proces + "</h1>");
		
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
}
