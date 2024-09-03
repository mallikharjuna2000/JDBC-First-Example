package com.codegnan.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateEmployeeTable {
	// JDBC URL,user name and password of MYSQL Server
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		String sql = "CREATE TABLE IF NOT EXISTS EMPLOYEE(" + "ENO INT AUTO_INCREMENT PRIMARY KEY,"
				+ "ENAME VARCHAR(100)," + "ESAL DECIMAL(10,2)," + "EADDR VARCHAR(255)" + ")";
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			statement.execute(sql);
			System.out.println("Employee table created successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
