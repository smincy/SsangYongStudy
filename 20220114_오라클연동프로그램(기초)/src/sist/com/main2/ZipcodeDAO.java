package sist.com.main2;
// 2022.01.14

// ����ڰ� ��û���� �� ����Ŭ ó�� (DML : CURD)

import java.util.*;
import java.sql.*;

/*
 *  1. ����̹� ��� Class.forName()
 *  2. ����Ŭ ���� Connection getConnection(URL, "user", "password")
 *  3. SQL���� ���� : PreparedStatement => conn.preparedStatement(sql)
 *  4. SQL���� ���� ��û
 *  	= SELECT => executeQuery()
 *  	= INSERT, UPDATE, DELETE => executeUpdate() 
 */

public class ZipcodeDAO {

	// ����Ŭ ���� ��ü ����
	private Connection conn;
	// ����Ŭ�� �ۼ����ϴ� ��ü ����
	private PreparedStatement ps;
	// URL �ּ�
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// ����̹� ���
	public ZipcodeDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
	}

	// ����Ŭ ����
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "smincy", "134679");
		} catch (Exception e) {
		}
	}

	// ����Ŭ ����
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

	// ��� - 1.ã�� 2.�˻� ���� Ȯ��
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

	// ���� �����ȣ�� ã�� �´�
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
