package servlet;
//import lib.AddTable;
import lib.TableImport;
import lib.Variables;

//import lib.ConnectSQL;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Table")
public class Table extends HttpServlet {

	private static final long serialVersionUID = 2L;
	 public void init() throws ServletException
	  {
	    
	  }
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)//RESPONSE Y REQUEST SE PUEDE SUSTITUIR POR CUALQUIER COSA
    throws ServletException, IOException{
		response.setContentType("text/html");
		//String TableName = null;
		//String dato;
		String DBname = request.getParameter("DBname");
		String TableName =  request.getParameter("TableName");
		String ColumnName = request.getParameter("nameColumn");		
		Variables.DBname(DBname);
		Variables.NameTable(TableName);
		Variables.NameColumn(ColumnName);
		
		
		
		PrintWriter out = response.getWriter();
		out.println("<h1>" + TableName + "</h1>");
		out.println("<h1><//h1");
		try {
			TableImport.createTable(TableName, DBname, ColumnName);
			//AddTable.columnName(TableName, ColumnName, DBname);
			out.println("<p> Succed!!! </p>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("<p> Faild </p>");

		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}