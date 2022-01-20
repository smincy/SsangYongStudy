package sist.com.main;
// 오라클 연동

/*
 * 1. 드라이버 등록		: 	oracle.jdbc.driver . OracleDriver
 * 		=> Class.forName()  => 드라이버를 클래스로 제작
 *      => Class.forName("패키지명.클래스명")
 *      : 한번만 수행되므로 주로 생성자에 등록
 *      
 * 2. 오라클 연결
 * 		1) URL(오라클주소) 필요
 * 			==> jdbc:oracle:thin:@IP(localhost):1521:XE
 * 		2) USER	필요
 * 			==> smincy
 * 		3) Password	필요
 * 			==> 134679
 * 		= Connection => getConnection(url, "smincy", "134679")
 * 		
 * 3. SQL 문장 전송
 * 	=> PreparedStatement => conn.preparedStatement(sql)
 * 
 * 4. 실행 결과 받아오기
 *  => ResultSet rs = ps.executeQuery()		=> SELECT 에서 실행된 결과를 rs에 저장해라
 *  
 * 5. 닫기 (연결종료)
 * 	=> ps.close(), conn.close()
 * 
 *  	기능이 많을때 => 오라클 연결 / 오라클 해제 해주기
 *  				반복이 많을 경우 메소드화 (getConnection, disConnection) 
 */

// 3번까지 필수, 숙지 필요

// PreparedStatement, Connection, ResultSet => java.sql

import java.sql.*;
import java.util.*;

public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	// 오라클 URL주소
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 1. 드라이버 등록
	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {

		}
	}

	// 2. 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "smincy", "134679");
			// conn smincy/134679
		} catch (Exception e) {

		}
	}

	// 3. 오라클 연결해제
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

	// 4. 기능 (Emp 는 한명에 대한 정보, 14명을 모아서 List로 전송
	public List<Emp> empListData() {
		List<Emp> list = new ArrayList<Emp>();

		try {
			// 1. 오라클 연결 (데이터를 가져올 준비)
			getConnection();

			// 2. SQL 문장 제작
			String sql = "SELECT empno, ename, job, hiredate, sal " + "FROM emp";
			// 3. SQL문장을 오라클로 전송
			ps = conn.prepareStatement(sql);

			// 4. 필요한 데이터가 없는 경우 (? 가 없는 경우) => 실행요청을 한다
			// 실행 결과를 받아본다
			ResultSet rs = ps.executeQuery();
			// 결과값을 list에 저장해서 사용자에게 전송
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
			// 오라클 연결 종료
			disConnection();
		}
		return list;
	}

	// 한명에 대한 사원 정보 보기
	public Emp empDetailData(int empno) { // 사번에 대한
		Emp emp = new Emp(); // 사원 한명이 가지고 있는 데이터 모음

		try {
			// 1. 오라클 연결
			getConnection();
			// 2. SQL문장 제작
			String sql = "SELECT empno, ename, job, hiredate, sal, comm " + "FROM emp " + "WHERE empno=?";
			// 3. SQL문장 오라클로 전송 후 ? 값을 채워준다
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			// 4. 오라클에 실행 요청 후 결과값을 메모리에 저장
			ResultSet rs = ps.executeQuery();
			// 커서를 결과값이 출력된 위치로 이동
			rs.next();

			// ResultSet에 있는 데이터를 Emp에 저장
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
			// 오라클 종료
			disConnection();
		}
		return emp;
	}

	// 사원 찾기
	public List<Emp> empFindData(String ename) {

		List<Emp> list = new ArrayList<Emp>();

		try {
			getConnection();

			String sql = "SELECT empno, ename, job, hiredate, sal " + "FROM emp "
			+ "WHERE ename LIKE '%'||?||'%'"; 
			// 오라클에서 || 은 문자열 결합 => 결합하면  %?% 

			ps = conn.prepareStatement(sql);
			// ? 에 값을 채워준다
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
