package servlet;
import lib.ConnectSQL;
//import lib.Variables;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
//import java.sql.SQLException;
//import java.lang.Throwable;
//import java.sql.*;
@WebServlet("/Logs")

	
public class Log extends HttpServlet {

	private static final long serialVersionUID = 2L;
	
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)//RESPONSE Y REQUEST SE PUEDE SUSTITUIR POR CUALQUIER COSA
    throws ServletException, IOException
{
		
		String ok;
		
		//ConnectSQL mensage = new ConnectSQL();
		//String mensage;
			
		
			
// Set response content type
response.setContentType("text/html");
//request.setAttribute("unEntero", new Integer(22));
/*Integer valor1 = (Integer) request.getAttribute("PRUEBA");
Integer valor2 = (Integer) request.getAttribute("PRUEBA2	");
String variable = request.getParameter("variable");
response.getWriter().print("<p> La variable vale " + variable + "</p>");
response.getWriter().print("<p> La variable vale " + valor1 + "</p>");
response.getWriter().print("<p> La variable vale " + valor2 + "</p>");*/
PrintWriter out = response.getWriter();
String DBname = request.getParameter("DBname");
ok = ConnectSQL.Connect(DBname);
out.println("<h1>" + ok + "</h1>");
out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\">");

}

	public static void main(String[] args) {
		//String ok;
		
		//Throwable = t;
		//ConnectSQL mensage = new ConnectSQL();
		//String mensage;
			/*ok = ConnectSQL.Connect(Variables.DBname());
			System.out.println(ok);
			String cadema = ConnectSQL.printString();
			System.out.println(cadema);
			
		if ( ok == "not ok"){
		try {	
		System.out.println(ok);
		}
		catch (Exception e){ 
		ConnectSQL.printSQLException(e);  
		}
		
		}*/
			}
}
