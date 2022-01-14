package sist.com.main;
/*
 *	오라클 연결 : JDBC
 *	1. 오라클 연결
 *	2. SQL문장 전송
 *	3. 결과값 받기
 *	4. 오라클 연결 해제 
 */

import java.sql.*;
import java.util.*;

public class FoodDAO {

	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 1. 드라이버 등록 (1번만등록) => 생성자
	public FoodDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {

		}
	}

	// 2. 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "smincy", "134679");
		} catch (Exception e) {
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
			// TODO: handle exception
		}
	}

	// 4. 기능 -> Category에 데이터 추가
	public void categoryInsert(Category c) {

		try {
			// 1. 오라클 연결
			getConnection();
			// 2. SQL문장 제작
			String sql = "INSERT INTO category VALUES(cate_cno_seq.nextval,?,?,?,?)";
			// 3. 오라클로 전송
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getTitle());
			ps.setString(2, c.getSubfect());
			ps.setString(3, c.getPoster());
			ps.setString(4, c.getLink());

			// 실행 명령
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}

	/*
	 * 22.01.14
	 * 
	 * 
	 */

	// 맛집 저장
	public void foodInsert(FoodHouse food) {
		try {
			getConnection(); // 연결
			// 1. SQL문장 제작
			String sql = "INSERT INTO food_house VALUES(" + "fh_no_seq.nectval,?,?,?,?,?," + "?,?,?,?,?,?)";

			// 2. SQL에 필요한 데이터값 채우기( ? 에 값 채우기)
			ps = conn.prepareStatement(sql);
			ps.setInt(1, food.getCno());
			ps.setString(2, food.getName());
			ps.setDouble(3, food.getScore());
			ps.setString(4, food.getAddress());
			ps.setString(5, food.getTel());
			ps.setString(6, food.getType());
			ps.setString(7, food.getPrice());
			ps.setString(8, food.getParking());
			ps.setString(9, food.getTime());
			ps.setString(10, food.getMenu());
			ps.setString(11, food.getPoster());

			// 3. 오라클에 명령문 실행 요청
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection(); // 연결 해제
		}
	}

	// 데이터 읽기 => Category의 link, cno, title 필요
	public List<Category> categoryListData() {
		List<Category> list = new ArrayList<Category>();
		try {
			// 1. 연결
			getConnection();
			// 2. SQL문장 제작
			String sql = "SELECT cno, title, link " + "FROM category";

			// 3. 필요한 데이터를 전송 (없을수도있음)
			// X

			// 4. 오라클에 명령문 실행 요청
			ps = conn.prepareStatement(sql); // sql문장을 오라클로 보낸다

			// 5. 결과값을 받는다
			ResultSet rs = ps.executeQuery(); // 실행된 결과를 rs에 넣어라

			// 6. 받은 결과값을 리스트에 첨부
			while (rs.next()) { // 결과의 위에서부터 아래로 한줄씩 읽어옴
				/*
				 *  
				 */

				Category c = new Category();
				c.setCno(rs.getInt(1));
				c.setTitle(rs.getString(2));
				c.setLink(rs.getString(3));
				list.add(c);
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 연결 해제
			disConnection();
		}
		return list;
	}

}
