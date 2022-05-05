package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnection.DBConnection;
import model.login;

public class LoginDao {
	public boolean validate(login loginBean) throws ClassNotFoundException {
		boolean status = false;
		
		Class.forName("com.mysql.jdbc.Driver");
		//kiem tra connection xem co van de gi ko
		try (Connection connection = DBConnection.GET_CONNECTION();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ? and password = ?")){
				preparedStatement.setString(1,  loginBean.getUsername());
				preparedStatement.setString(2,  loginBean.getPassword());
						
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
				status = rs.next();
	} catch (SQLException e) {
		System.out.println(e);
	}
	return status;
}
}
