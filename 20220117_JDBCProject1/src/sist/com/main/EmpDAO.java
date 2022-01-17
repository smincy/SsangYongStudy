package sist.com.main;

import java.util.*;
import java.sql.*;

//����Ŭ ���� => �ۼ���
public class EmpDAO {

	private Connection conn;
	private PreparedStatement ps;
	private String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void GetConnection() {
		try {
			conn = DriverManager.getConnection(URL, "smincy", "134679");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void disConnection() {
		try {
			if (ps != null) { // ps �� �����ִٸ�
				ps.close(); // ps �� �ݾ����
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<EmpVO> empListData() {

		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. ����
			GetConnection();
			// 2. SQL ���� ����
			String sql = "SELECT * FROM emp";
			// 3. SQL ������ ����ũ�� ����
			ps = conn.prepareStatement(sql);
			// 4. ���� �� ������� ������ �´�
			ResultSet rs = ps.executeQuery();

			while (rs.next()) { // 5. Ŀ�� ��ġ �̵�
				// �Ʒ��� �������鼭 ���پ� �о����

				// ������ ������� ���ÿ� �÷�/������ ���� �����ϱ� ����
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setMgr(rs.getInt(4));
				vo.setHiredate(rs.getDate(5));
				vo.setSal(rs.getInt(6));
				vo.setComm(rs.getInt(7));
				vo.setDeptno(rs.getInt(8));

				list.add(vo);
				/*
				 * ��ü ��� => list �Ѹ�, �Ѱ� ���� => �ش� ~VO
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}

	// 2. �μ� ��� ����
	public List<DeptVO> deptListData() {
		List<DeptVO> list = new ArrayList<DeptVO>();

		try {
			GetConnection();
			String sql = "SELECT * FROM dept";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeptVO vo = new DeptVO();
				vo.setDeptno(rs.getInt(1));
				vo.setDname(rs.getString(2));
				vo.setLoc(rs.getString(3));
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

	// ��� ��� ���
	public List<SalGradeVO> salgradeListData() {
		List<SalGradeVO> list = new ArrayList<SalGradeVO>();

		try {
			GetConnection();
			String sql = "SELECT * FROM salgrade";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SalGradeVO vo = new SalGradeVO();
				vo.setGrade(rs.getInt("grade")); // �÷������� �޾ƿü�������
				vo.setLosal(rs.getInt("losal")); // �Լ��� ��Ī�� ���ÿ���
				vo.setHisal(rs.getInt("hisal")); // �ε����� ����ϴ� ��찡 ����
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}

	// ���, �μ� => JOIN
	public List<EmpVO> empDeptJoinData() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			GetConnection();
			String sql = "SELECT empno, ename, job, hiredate, sal, dname, loc " + "FROM emp, dept "
					+ "WHERE emp.deptno = dept.deptno";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setSal(rs.getInt(5));
				vo.getDvo().setDname(rs.getString(6));
				vo.getDvo().setLoc(rs.getString(7));

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

	// ���, ��� (BETWEEN ~ AND, INNER JOIN)
	public List<EmpVO> empSalgradeJoinData() {

		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			GetConnection();
			String sql = "SELECT empno, ename, job, hiredate, sal, grade " + "FROM emp JOIN salgrade "
					+ "ON sal BETWEEN losal AND hisal";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setSal(rs.getInt(5));
				vo.getSvo().setGrade(rs.getInt(6));
				;
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

	/*
	 * INNER JOIN : ���� ���� ���Ǵ� ���� EQUI_JOIN(������ =)
	 * 
	 * SELECT ~ FROM A,B WHERE A.col=B.col
	 * 
	 * SELECT ~ FROM A JOIN B ON A.col=B.col
	 * 
	 * NON_EQUI_JOIN(������ =�� �ƴ� �ٸ� ������:BETWEEN,IN,��,��)
	 * 
	 * SELECT ~ FROM A,B WHERE sal BETWEEN �� AND ��
	 * 
	 * SELECT ~ FROM A JOIN B ON sal BETWEEN �� AND ��
	 * 
	 * OUTER JOIN => NULL�� �ִ� ��쿡 ������ �б� LEFT OUTER JOIN SELECT ~ FROM A,B WHERE
	 * A.col=B.col(+)
	 * 
	 * SELECT ~ FROM A LEFT OUTER JOIN B ON A.col=B.col
	 * 
	 * 
	 * RIGTH OUTER JOIN SELECT ~ FROM A,B WHERE A.col(+)=B.col
	 * 
	 * SELECT ~ FROM A RIGTH OUTER JOIN B ON A.col=B.col
	 * 
	 */

	// ���, �μ� ��� => JOIN
	public List<EmpVO> empDeptSalgradeJoinData() {
		List<EmpVO> list = new ArrayList<EmpVO>();

		try {
			GetConnection();
			String sql = "SELECT empno, ename, job, hiredate, sal, dname, loc, grade " + "FROM emp, dept, salgrade "
					+ "WHERE emp.deptno = dept.deptno " + "AND sal BETWEEN losal AND hisal";

			/*
			 * ANSI ���� "SELECT empno, ename, job, hiredate, sal, dname, loc, grade FROM emp
			 * JOIN dept ON emp.deptno = dept.deptno JOIN salgrade ON sal BETWEEN losal AND
			 * hisal;"
			 * 
			 */
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setSal(rs.getInt(5));
				vo.getDvo().setDname(rs.getString(6));
				vo.getDvo().setLoc(rs.getString(7));
				vo.getSvo().setGrade(rs.getInt(8));

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

	// ����� ��û���� �ִ� ���
	// 7788 ����� ������ �ִ� ����� ���, �̸�, ����, �Ի���, �ٹ���, �μ���, ���
	public EmpVO empDetailData(int empno) {
		EmpVO vo = new EmpVO();
		try {
			GetConnection();
			String sql = "SELECT empno, ename, job, hiredate, loc, dname, grade, sal "
					+ "FROM emp, dept, salgrade WHERE emp.deptno = dept.deptno AND sal BETWEEN losal AND hisal AND empno = ?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, empno); // 1 => ù��° ? �� ���� ä���ش�

			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.getDvo().setLoc(rs.getString(5));
			vo.getDvo().setDname(rs.getString(6));
			vo.getSvo().setGrade(rs.getInt(7));
			vo.setSal(rs.getInt(8));

			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return vo;
	}

	// 7. SubQuery
	/*
	 * ��Ʈ��ũ ��� ���� : ����Ŭ => ���� Ŭ���̾�Ʈ : �ڹ� => ��û (JDBC) ------- �ӵ��� ���� : ����Ŭ���� (DBCP)
	 * ------- �ڵ��� �ʹ� ������� => ORM (MyBatis,Hibernate) => Spring+Mybatis �������� :
	 * SQL+SQL => SQL�� �Ѱ��� ����� ��� ��Ʈ��ũ => �ѹ��� ��Ƽ� ���� ------ SELECT�� : �÷����� =>
	 * ��Į�󼭺����� (���̺� ���������� ������ ����) ����) SELECT (SELECT~ ), (SELECT~ ) FROM table_name
	 * 
	 * FROM�� : ���̺� ��� ��� => �ζ��� �� => Top-N(rownum) , ������ ������ ����) SELECT ~ FROM
	 * (SELECT~) --------- ������ �÷��� ����� ����
	 * 
	 * SELECT ~ FROM (SELECT ~ FROM (SELECT ~) WHERE�� : ���ǰ� ��� ��� ����) ������ �������� :
	 * ���������� ������� 1���� ��� SELECT ~ FROM table_name WHERE �÷��� ������ (SELECT~~)
	 * ---------------- ---------- �������� �������� ������ �������� : �������� ������� �������� ��� SELECT ~
	 * FROM table_name WHERE �÷��� IN,ANY,ALL,SOME (SELECT~~) ----------------
	 * ---------- �������� ��������
	 * 
	 * IN(10,20,30) => ���� ���� > ANY(10,20,30) => 10 >10 < ANY(10,20,30) => 30 <30 =
	 * ANY(10,20,30) => IN(10,20,30) > ALL(10,20,30) => 30 >30 < ALL(10,20,30) => 10
	 * <10 --------------------------- MIN/MAX
	 * 
	 * WHERE deptno > (�ּҰ�) => 10,20,30) deptno > ANY(SELECT DISTINCT deptno FROM
	 * emp) 10 deptno > (SELECT MIN(deptno) FROM emp) 10
	 * 
	 * deptno < ANY(SELECT DISTINCT deptno FROM emp) 30 deptno < (SELECT MAX(deptno)
	 * FROM emp) 30
	 */
	// �޿��� ��պ��� ���� �޴� ����� �̸�, ����, �Ի���, �޿�, �μ���, �ٹ���
	// �������� => ����
	public List<EmpVO> empSubQueryData() {
		List<EmpVO> list = new ArrayList<EmpVO>();

		try {
			GetConnection();
			String sql = "SELECT ROUND(AVG(sal)) FROM emp";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int avg = rs.getInt(1);
			rs.close();
			ps.close();

			sql = "SELECT ename, job, hiredate, sal, dname, loc " + "FROM emp, dept "
					+ "WHERE emp.deptno = dept.deptno " + "AND sal>? " + "ORDER BY ename ASC";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, avg);

			rs = ps.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString(1));
				vo.setJob(rs.getString(2));
				vo.setHiredate(rs.getDate(3));
				vo.setSal(rs.getInt(4));
				vo.getDvo().setDname(rs.getString(5));
				vo.getDvo().setLoc(rs.getString(6));

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

	// ��������2
	public List<EmpVO> empSubQueryData2() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. ����Ŭ ����
			GetConnection();
			String sql = "SELECT ename,job,hiredate,sal,dname,loc " 
					+ "FROM emp,dept " 
					+ "WHERE emp.deptno=dept.deptno "
					+ "AND sal>(SELECT ROUND(AVG(sal)) FROM emp) " 
					+ "ORDER BY ename ASC";
			ps = conn.prepareStatement(sql);

			// 5. ����� �ޱ�
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString(1));
				vo.setJob(rs.getString(2));
				vo.setHiredate(rs.getDate(3));
				vo.setSal(rs.getInt(4));
				vo.getDvo().setDname(rs.getString(5));
				vo.getDvo().setLoc(rs.getString(6));

				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			// ���� ó��
			ex.printStackTrace();
		} finally {
			// �ݱ�
			disConnection();
		}
		return list;
	}

	// ��Į�� ��������
	/*
	 * SELECT ename, job, hiredate,sal, 
	 * (SELECT dname FROM dept WHERE deptno=emp.deptno) dname, 
	 * (SELECT loc FROM dept WHERE deptno=emp.deptno) loc
	 * FROM emp;
	 */
	// -> JOIN���� ���������� => ������ ���� (�̸�,����,�Ի���, �޿�, �μ���,�ٹ���)
	public List<EmpVO> empSubQueryListData() {
		// 1. ������
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. ����Ŭ ����
			GetConnection(); // LIKE '%A%' ==> LIKE '%'||'A'||'%'
			// �ڹٿ��� => ����Ŭ�� ���� (���ڿ�) => ����
			// String sql="SELECT ename,job,(SELECT~)"
			// 2. SQL����
			// SQLDevloper =>
			String sql = "SELECT ename,job,hiredate,sal," + "(SELECT dname FROM dept WHERE deptno=emp.deptno),"
					+ "(SELECT loc FROM dept WHERE deptno=emp.deptno) " + "FROM emp";
			// 3. ����Ŭ�� SQL���� ����
			ps = conn.prepareStatement(sql);
			// 4. ������� �޴´�
			ResultSet rs = ps.executeQuery();
			// 5. ������� List�� ��´�
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString(1));
				vo.setJob(rs.getString(2));
				vo.setHiredate(rs.getDate(3));
				vo.setSal(rs.getInt(4));
				vo.getDvo().setDname(rs.getString(5));
				vo.getDvo().setLoc(rs.getString(6));

				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();// �ݱ�
		}
		return list;
	}

	// �ζ��κ�
	/*
	 * SELECT : ��� 
	 * 	1) ��ü ��� (��� ���) 
	 * 	2) ���� => 1�� (�󼼺���) 
	 * 	3) ���� 
	 * 	4) �������� : 
	 * 		1) ��Į�� 
	 * 		2) �ζ��κ�
	 */
	
	// Top-N (������ �~~ �α�˻��� , �α� �������� ~ �α� �Խù� )
	// 1. �޿��� ���� ������ ���� 5���� ���� => �̸�,�Ի���, ����, �޿�
	/*
	 * SELECT ----> 3) 
	 * FROM ----- 1) 
	 * WHERE ----- 2) 
	 * ORDER BY --> 4)
	 * 
	 * ==> �߰��� �����͸� ���� �� �� ���� rownum BETWEEN 6 AND 10 ==> (X)
	 */
	public List<EmpVO> empTon5Data() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// ����
			GetConnection();
			// SQL����
			String sql = "SELECT ename,job,hiredate,sal,rownum " 
					+ "FROM (SELECT ename,job,hiredate,sal "
							+ "FROM emp ORDER BY sal DESC) " 
					+ "WHERE rownum<=5";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString(1));
				vo.setJob(rs.getString(2));
				vo.setHiredate(rs.getDate(3));
				vo.setSal(rs.getInt(4));

				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}

}
