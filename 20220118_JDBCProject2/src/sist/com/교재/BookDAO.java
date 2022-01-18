package sist.com.교재;

import java.util.*;
import java.sql.*;

// 오라클 / 웹서버(크롤링) 연결 
// 파일 입출력

public class BookDAO {

	private Connection conn;
	private PreparedStatement ps;

	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 드라이버 등록
	public BookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "smincy", "134679");
			System.out.println("오라클 연결");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 해제
	public void disConnection() {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
			System.out.println("오라클 연결 해제 완료");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 오라클에서 데이터 읽기
	public List<BookVO> bookListData() {
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			getConnection();
			String sql = "SELECT bookid, bookname, publisher, "
					+ "TO_CHAR(price, 'L999,999') "
					+ "FROM book";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookid(rs.getInt(1));
				vo.setBookname(rs.getString(2));
				vo.setPublisher(rs.getString(3));
				vo.setStrPrice(rs.getString(4));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}

}
