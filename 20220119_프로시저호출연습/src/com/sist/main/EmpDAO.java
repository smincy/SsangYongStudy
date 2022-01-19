package com.sist.main;

import java.sql.*;
import oracle.jdbc.internal.OracleTypes;

public class EmpDAO {
	// 연결 객체
	private Connection conn;

	// 프로시저 호출
	private CallableStatement cs;

	// 주소
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 드라이버 등록
	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
	}

	// 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "smincy", "134679");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 연결 해제
	public void disConnection() {
		try {
			if (cs != null) {
				cs.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void empAllData() {
		try {
			getConnection();

			// SQL 문장
			String sql = "{CALL empAllData(?)}";
			cs = conn.prepareCall(sql);

			// ? 에 값을 채운다
			cs.registerOutParameter(1, OracleTypes.CURSOR); // 임시기억장소에 값을 채워라

			// 실행
			cs.executeUpdate();

			// 값을 받는다
			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + " " 
						+ rs.getString(2) + " "
						+ rs.getString(3) + " "
						+ rs.getDate(4).toString() + " "
						+ rs.getInt(5) + " "
						+ rs.getString(6) + " "
						+ rs.getString(7) + " "
						+ rs.getInt(8)
				);

			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}

}
