package com.cg.osce.logging.repository;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionFactory {
	private static BasicDataSource dataSource;

	private ConnectionFactory() {
	}

	public static Connection getConnection() throws SQLException {
		if (dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setUrl("jdbc:mysql://localhost:3306/nikhil?useSSL=false");
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUsername("gangadhar");
			dataSource.setPassword("varshini@123");
		}
		return dataSource.getConnection();
	}
}
