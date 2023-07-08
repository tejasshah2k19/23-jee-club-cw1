package com.google.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getConnection() {

		String driveName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/23cw1";
		String userName = "root";
		String password = "root";

		try {
			Class.forName(driveName);

			Connection con = DriverManager.getConnection(url, userName, password);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
