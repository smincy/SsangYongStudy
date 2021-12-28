package sist.com.main;

import java.sql.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 오라클 연결
			String url = "jdbc:oracle:thin:@172.20.10.2:1521:XE";
			Connection conn = DriverManager.getConnection(url, "smincy", "134679");

			// 3. 오라클 명령어 전송
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept");

			// 4. 실행결과값을 가지고 온다
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}


		} catch (Exception e) {

		}
	}

}
