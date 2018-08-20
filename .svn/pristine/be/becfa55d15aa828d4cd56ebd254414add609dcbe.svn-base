package lib;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Count {

	public static String CountRow(String DBName) {
		Statement stmt = null;
		String mensage =null;
Connection con = ConnectSQL.realConnect(DBName);
String query = "select COUNT(*) "+
"from" + DBName;
try {
	stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 while (rs.next()) {
		 String rows = rs.getString("COUNT(*)");
		 mensage = "Numero de filas" + rows;
		 return mensage;
	 }

}
catch (SQLException e){
	ConnectSQL.printSQLException(e);
}
finally {
	//stmt.close();
}
return mensage;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("i");
		
	     
		String db = scanner.scannerString(1);
		System.out.println("Filas contadas");
		System.out.println("Numero de filas: " + CountRow(db));
	}

}
