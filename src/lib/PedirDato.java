package lib;

import lib.ConnectSQL;
import lib.Variables;

import java.sql.*;

public class PedirDato {

	public static String pedirDato(String DBName) throws SQLException {
		Statement stmt = null;
		String mensage = null;
		Connection con = ConnectSQL.realConnect(DBName);
		String query = "select EQ_NOMBRE ,ESTADIO " + "from" + Variables.DBname(DBName) + "EQUPOS";

		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String equipo = rs.getString("EQ_NOMBRE");

				String estadio = rs.getString("ESTADIO");
				mensage = "Equipo: " + equipo + "Estadio: " + estadio;
				//return DBname;

			}

		} catch (SQLException e) {

			ConnectSQL.printSQLException(e);
		} finally {
			stmt.close();
		}
		return mensage;
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//String DBname;
		System.out.println("J");
		//PedirDato.pedirDato(Variables.DBname(DBName));

	}
}
