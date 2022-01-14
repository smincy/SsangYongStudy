package sist.com.main;
/*
 *	����Ŭ ���� : JDBC
 *	1. ����Ŭ ����
 *	2. SQL���� ����
 *	3. ����� �ޱ�
 *	4. ����Ŭ ���� ���� 
 */

import java.sql.*;
import java.util.*;

public class FoodDAO {

	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 1. ����̹� ��� (1�������) => ������
	public FoodDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {

		}
	}

	// 2. ����Ŭ ����
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "smincy", "134679");
		} catch (Exception e) {
		}
	}

	// 3. ����Ŭ ����
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

	// 4. ��� -> Category�� ������ �߰�
	public void categoryInsert(Category c) {

		try {
			// 1. ����Ŭ ����
			getConnection();
			// 2. SQL���� ����
			String sql = "INSERT INTO category VALUES(cate_cno_seq.nextval,?,?,?,?)";
			// 3. ����Ŭ�� ����
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getTitle());
			ps.setString(2, c.getSubfect());
			ps.setString(3, c.getPoster());
			ps.setString(4, c.getLink());

			// ���� ���
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

	// ���� ����
	public void foodInsert(FoodHouse food) {
		try {
			getConnection(); // ����
			// 1. SQL���� ����
			String sql = "INSERT INTO food_house VALUES(" + "fh_no_seq.nectval,?,?,?,?,?," + "?,?,?,?,?,?)";

			// 2. SQL�� �ʿ��� �����Ͱ� ä���( ? �� �� ä���)
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

			// 3. ����Ŭ�� ��ɹ� ���� ��û
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection(); // ���� ����
		}
	}

	// ������ �б� => Category�� link, cno, title �ʿ�
	public List<Category> categoryListData() {
		List<Category> list = new ArrayList<Category>();
		try {
			// 1. ����
			getConnection();
			// 2. SQL���� ����
			String sql = "SELECT cno, title, link " + "FROM category";

			// 3. �ʿ��� �����͸� ���� (������������)
			// X

			// 4. ����Ŭ�� ��ɹ� ���� ��û
			ps = conn.prepareStatement(sql); // sql������ ����Ŭ�� ������

			// 5. ������� �޴´�
			ResultSet rs = ps.executeQuery(); // ����� ����� rs�� �־��

			// 6. ���� ������� ����Ʈ�� ÷��
			while (rs.next()) { // ����� ���������� �Ʒ��� ���پ� �о��
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
			// ���� ����
			disConnection();
		}
		return list;
	}

}
