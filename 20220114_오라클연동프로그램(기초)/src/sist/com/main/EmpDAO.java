package sist.com.main;

// ����Ŭ ����
/*
 * 1. ����̹� ���		: 	oracle.jdbc.driver . OracleDriver
 * 		=> Class.forName()  => ����̹��� Ŭ������ ����
 *      => Class.forName("��Ű����.Ŭ������")
 *      : �ѹ��� ����ǹǷ� �ַ� �����ڿ� ���
 *      
 * 2. ����Ŭ ����
 * 		1) URL(����Ŭ�ּ�) �ʿ�
 * 			==> jdbc:oracle:thin:@IP(localhost):1521:XE
 * 		2) USER	�ʿ�
 * 			==> smincy
 * 		3) Password	�ʿ�
 * 			==> 134679
 * 		= Connection => getConnection(url, "smincy", "134679")
 * 		
 * 3. SQL ���� ����
 * 	=> PreparedStatement => conn.preparedStatement(sql)
 * 
 * 4. ���� ��� �޾ƿ���
 *  => ResultSet rs = ps.executeQuery()		=> SELECT ���� ����� ����� rs�� �����ض�
 *  
 * 5. �ݱ� (��������)
 * 	=> ps.close(), conn.close()
 * 
 *  	����� ������ => ����Ŭ ���� / ����Ŭ ���� ���ֱ�
 *  				�ݺ��� ���� ��� �޼ҵ�ȭ (getConnection, disConnection) 
 */

// 3������ �ʼ�, ���� �ʿ�

// PreparedStatement, Connection, ResultSet => java.sql

import java.sql.*;
import java.util.*;

public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	// ����Ŭ URL�ּ�
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 1. ����̹� ���
	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {

		}
	}

	// 2. ����Ŭ ����
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "smincy", "134679");
			// conn smincy/134679
		} catch (Exception e) {

		}
	}

	// 3. ����Ŭ ��������
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

	// 4. ��� (Emp �� �Ѹ� ���� ����, 14���� ��Ƽ� List�� ����
	public List<Emp> empListData() {
		List<Emp> list = new ArrayList<Emp>();

		try {
			// 1. ����Ŭ ���� (�����͸� ������ �غ�)
			getConnection();

			// 2. SQL ���� ����
			String sql = "SELECT empno, ename, job, hiredate, sal " + "FROM emp";
			// 3. SQL������ ����Ŭ�� ����
			ps = conn.prepareStatement(sql);

			// 4. �ʿ��� �����Ͱ� ���� ��� (? �� ���� ���) => �����û�� �Ѵ�
			// ���� ����� �޾ƺ���
			ResultSet rs = ps.executeQuery();
			// ������� list�� �����ؼ� ����ڿ��� ����
			while (rs.next()) {
				Emp e = new Emp();
				e.setEmpno(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setJob(rs.getNString(3));
				e.setHiredate(rs.getDate(4));
				e.setSal(rs.getInt(5));

				list.add(e);

			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ����Ŭ ���� ����
			disConnection();
		}
		return list;
	}

	// �Ѹ� ���� ��� ���� ����
	public Emp empDetailData(int empno) { // ����� ����
		Emp emp = new Emp(); // ��� �Ѹ��� ������ �ִ� ������ ����

		try {
			// 1. ����Ŭ ����
			getConnection();
			// 2. SQL���� ����
			String sql = "SELECT empno, ename, job, hiredate, sal, comm " + "FROM emp " + "WHERE empno=?";
			// 3. SQL���� ����Ŭ�� ���� �� ? ���� ä���ش�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			// 4. ����Ŭ�� ���� ��û �� ������� �޸𸮿� ����
			ResultSet rs = ps.executeQuery();
			// Ŀ���� ������� ��µ� ��ġ�� �̵�
			rs.next();

			// ResultSet�� �ִ� �����͸� Emp�� ����
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getNString(2));
			emp.setJob(rs.getString(3));
			emp.setHiredate(rs.getDate(4));
			emp.setSal(rs.getInt(5));
			emp.setComm(rs.getInt(6));

			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ����Ŭ ����
			disConnection();
		}
		return emp;
	}

	// ��� ã��
	public List<Emp> empFindData(String ename) {

		List<Emp> list = new ArrayList<Emp>();

		try {
			getConnection();

			String sql = "SELECT empno, ename, job, hiredate, sal "
					+ "FROM emp "
					+ "WHERE ename LIKE '%'||?||'%'";	// ����Ŭ���� || �� ���ڿ� ���� => �����ϸ�  %?% 

			ps = conn.prepareStatement(sql);
			// ? �� ���� ä���ش�
			ps.setString(1, ename.toUpperCase());
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Emp e = new Emp();
				e.setEmpno(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setJob(rs.getString(3));
				e.setHiredate(rs.getDate(4));
				e.setSal(rs.getInt(5));
				
				list.add(e);
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
