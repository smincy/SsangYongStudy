package com.sist.dao;

/*
 *  JDBC 프로그래밍 : 주로 DML (select, insert, update, delete)
 *  				=> 사용자 요청시마다 직접 SQL문장을 만들어서 결과값을 사용자에 보내주는 역할
 *  
 *  	
 */
import java.util.*;
import java.sql.*;

public class FoodDAO {

	// 연결 객체 선언
	private Connection conn;
	// 전송 객체 선언
	private PreparedStatement ps;
	// 오라클 연결 주소
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 1. 드라이버 등록
	public FoodDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2. 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "smincy", "134679");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 3. 오라클 해제
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

	// 기능1. 카테고리 읽기
	public List<CategoryVO> categoryListData() {
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		try {
			getConnection();
			String sql = "SELECT cno, title, link " + "FROM category";
			ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryVO vo = new CategoryVO();
				vo.setCno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setLink(rs.getString(3));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}

	// 수집된 데이터를 오라클에 저장
	public void foodInsert(FoodHouseVO vo) {
		try {
			getConnection();
			String sql = "INSERT INTO foodHouse VALUES (" 
					+ "(SELECT NVL(MAX(no)+1,1) FROM foodHouse), "
					+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			// ? 에 값을 채운다
			ps.setInt(1, vo.getCno());
			ps.setString(2, vo.getPoster());
			ps.setString(3, vo.getName());
			ps.setDouble(4, vo.getScore());
			ps.setString(5, vo.getAddress());
			ps.setString(6, vo.getTel());
			ps.setString(7, vo.getType());
			ps.setString(8, vo.getPrice());
			ps.setString(9, vo.getTime());
			ps.setString(10, vo.getMenu());
			ps.setInt(11, vo.getGood());
			ps.setInt(12, vo.getSoso());
			ps.setInt(13, vo.getBad());
			ps.setString(14, vo.getParking());
			
			// 실행 명령
			ps.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}

	}
}
