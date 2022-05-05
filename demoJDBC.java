package dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dbConnection.DBConnection;

public class demoJDBC {
	public static void main(String a[]) {
		try {
			getListSinhVien();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public static void getListSinhVien() throws SQLException {
	        // establish the connection
			Connection connection = DBConnection.GET_CONNECTION();
		    // prepare SQL query
			String sqlQuery = "select * from sinhvien";
   	        // create JDBC statement object
			Statement sta = connection.createStatement();
		    // send and execute SQL query in Database software
			ResultSet rs = sta.executeQuery(sqlQuery);
			
			while (rs.next()) {
				System.out.println(rs.getString(1) + " - " +
			rs.getString(2) + " - " + rs.getString(3));
			}
		}
	
}
