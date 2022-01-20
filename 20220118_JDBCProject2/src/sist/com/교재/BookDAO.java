package sist.com.교재;

import java.util.*;
import java.sql.*;

// ����Ŭ / ������(ũ�Ѹ�) ���� 
// ���� �����

public class BookDAO {

	private Connection conn;
	private PreparedStatement ps;

	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// ����̹� ���
	public BookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ����
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "smincy", "134679");
			System.out.println("����Ŭ ����");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ����
	public void disConnection() {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
			System.out.println("����Ŭ ���� ���� �Ϸ�");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ����Ŭ���� ������ �б�
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
