package sist.com.main2;
//2022.01.14

//사용자가 요청했을 때 오라클 처리 (DML : CURD)

import java.util.*;
import java.sql.*;

/*
*  1. 드라이버 등록 Class.forName()
*  2. 오라클 연결 Connection getConnection(URL, "user", "password")
*  3. SQL문장 전송 : PreparedStatement => conn.preparedStatement(sql)
*  4. SQL문장 실행 요청
*  	= SELECT => executeQuery()
*  	= INSERT, UPDATE, DELETE => executeUpdate() 
*/

public class ZipcodeDAO {

	// 오라클 연결 객체 생성
	private Connection conn;
	// 오라클로 송수신하는 객체 생성
	private PreparedStatement ps;
	// URL 주소
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 드라이버 등록
	public ZipcodeDAO() {
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
		}
	}

	// 오라클 종료
	public void disConnection() {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {

		}
	}

	// 기능 - 1.찾기 2.검색 갯수 확인
	public int zipcodeFindCount(String dong) {
		int count = 0;
		try {
			getConnection();
			String sql = "SELECT  COUNT(*) " + "FROM zipcode " + "WHERE dong LIKE '%'||?||'%'";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dong);
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return count;
	}

	// 실제 우편번호를 찾아 온다
	public List<Zipcode> zipcodeListData(String dong) {
		List<Zipcode> list = new ArrayList<Zipcode>();
		try {
			getConnection();
			String sql = "SELECT zipcode, sido, gugun, dong, NVL(bunji,' ') " + "FROM zipcode " + "WHERE dong LIKE '%'||?||'%'";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dong);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Zipcode z = new Zipcode();
				z.setZipcode(rs.getString(1));
				z.setSido(rs.getString(2));
				z.setGugun(rs.getString(3));
				z.setDong(rs.getString(4));
				z.setBunji(rs.getString(5));
				list.add(z);
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}

		return list;
	}
}
