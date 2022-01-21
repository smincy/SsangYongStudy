package com.sist.dao;

import java.sql.*;

public class DataBase {
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	public void DataBase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Connection getConnection(Connection conn) {
		try {
			conn = DriverManager.getConnection(URL, "smincy", "134679");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}

	public void disConnection(Connection conn, PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
