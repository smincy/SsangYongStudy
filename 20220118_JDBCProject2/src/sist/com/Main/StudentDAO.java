package sist.com.Main;

// ����Ŭ ����

import java.util.*;
import java.sql.*;

public class StudentDAO {

	private Connection conn;
	private PreparedStatement ps;

	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// ����̹� ���
	public StudentDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ����
	public void getConnection() {
		try {

			conn = DriverManager.getConnection(URL, "smincy", "134679");
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
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ���
	// INSERT
	public void studentInsert(StudentVO vo) {
		try {
			// 1. ����
			getConnection();
			// 2. SQL ����
			String sql = "INSERT INTO student VALUES(" + "(SELECT NVL(MAX(hakbun)+1,1) FROM student)," + "?,?,?,?)";
			// 3. SQL ���� ����
			ps = conn.prepareStatement(sql);
			// 4. ? �� �� ä���
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getKor());
			ps.setInt(3, vo.getEng());
			ps.setInt(4, vo.getMath());

			// 5. �����û
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}

	// ��ü ���
	public List<StudentVO> studentListData() {
		List<StudentVO> list = new ArrayList<StudentVO>();
		try {
			getConnection();
			String sql = "SELECT * FROM student";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// �й�, �̸�, ��, ��, ��
				StudentVO vo = new StudentVO();
				vo.setHakbun(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setKor(rs.getInt(3));
				vo.setEng(rs.getInt(4));
				vo.setMath(rs.getInt(5));

				list.add(vo);
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}

	// 4. UPDATE
	public void studentUpdate(StudentVO vo) {

		try {
			getConnection();
			String sql = "UPDATE student SET " + "kor = ?, eng = ?, math = ? " + "WHERE hakbun = ?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, vo.getKor());
			ps.setInt(2, vo.getEng());
			ps.setInt(3, vo.getMath());
			ps.setInt(4, vo.getHakbun());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}

	}

	// 5. DELETE
	public void studentDelete(int hakbun) {
		try {
			getConnection();
			String spl = "DELETE FROM student " 
						+ "WHERE hakbun = ?";
			ps = conn.prepareStatement(spl);
			ps.setInt(1, hakbun);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}

}
