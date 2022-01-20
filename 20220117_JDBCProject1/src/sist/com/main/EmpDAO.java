package sist.com.main;

import java.util.*;
import java.sql.*;

//오라클 연결 => 송수신
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
			if (ps != null) { // ps 가 열려있다면
				ps.close(); // ps 를 닫아줘라
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
			// 1. 연결
			GetConnection();
			// 2. SQL 문장 제작
			String sql = "SELECT * FROM emp";
			// 3. SQL 문장을 오라크롤 전송
			ps = conn.prepareStatement(sql);
			// 4. 실행 후 결과값을 가지고 온다
			ResultSet rs = ps.executeQuery();

			while (rs.next()) { // 5. 커서 위치 이동
				// 아래로 내려가면서 한줄씩 읽어오기

				// 가져온 결과값을 동시에 컬럼/변수에 각각 저장하기 위해
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
				 * 전체 목록 => list 한명, 한개 정보 => 해당 ~VO
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}

	// 2. 부서 목록 전송
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

	// 등급 목록 출력
	public List<SalGradeVO> salgradeListData() {
		List<SalGradeVO> list = new ArrayList<SalGradeVO>();

		try {
			GetConnection();
			String sql = "SELECT * FROM salgrade";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SalGradeVO vo = new SalGradeVO();
				vo.setGrade(rs.getInt("grade")); // 컬럼명으로 받아올수도있음
				vo.setLosal(rs.getInt("losal")); // 함수나 별칭을 사용시에는
				vo.setHisal(rs.getInt("hisal")); // 인덱스를 사용하는 경우가 많음
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}

	// 사원, 부서 => JOIN
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

	// 사원, 등급 (BETWEEN ~ AND, INNER JOIN)
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
	    *      INNER JOIN : 가장 많이 사용되는 조인 
	    *        EQUI_JOIN(연산자 =)
	    *        
	    *        SELECT ~ 
	    *        FROM A,B
	    *        WHERE A.col=B.col
	    *        
	    *        SELECT ~
	    *        FROM A JOIN B
	    *        ON A.col=B.col 
	    *        
	    *        NON_EQUI_JOIN(연산자 =이 아닌 다른 연산자:BETWEEN,IN,비교,논리)
	    *      
	    *        SELECT ~
	    *        FROM A,B
	    *        WHERE sal BETWEEN 값 AND 값 
	    *        
	    *        SELECT ~
	    *        FROM A JOIN B
	    *        ON sal BETWEEN 값 AND 값 
	    *        
	    *      OUTER JOIN => NULL이 있는 경우에 데이터 읽기 
	    *        LEFT OUTER JOIN
	    *        SELECT ~ 
	    *        FROM A,B
	    *        WHERE A.col=B.col(+)
	    *        
	    *        SELECT ~
	    *        FROM A LEFT OUTER JOIN B
	    *        ON A.col=B.col 
	    *        
	    *        
	    *        RIGTH OUTER JOIN 
	    *        SELECT ~ 
	    *        FROM A,B
	    *        WHERE A.col(+)=B.col
	    *        
	    *        SELECT ~
	    *        FROM A RIGTH OUTER JOIN B
	    *        ON A.col=B.col 
	    */

	// 사원, 부서 등급 => JOIN
	public List<EmpVO> empDeptSalgradeJoinData() {
		List<EmpVO> list = new ArrayList<EmpVO>();

		try {
			GetConnection();
			String sql = "SELECT empno, ename, job, hiredate, sal, dname, loc, grade " + "FROM emp, dept, salgrade "
					+ "WHERE emp.deptno = dept.deptno " + "AND sal BETWEEN losal AND hisal";

			/*String sql="SELECT empno,ename,job,hiredate,sal,"//emp
		     +"dname,loc," // dept 
		     +"grade " // salgrade
		     +"FROM emp,dept,salgrade "
		     +"WHERE emp.deptno=dept.deptno "
		     +"AND sal BETWEEN losal AND hisal";*/
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

	// 사용자 요청값이 있는 경우
	// 7788 사번을 가지고 있는 사원의 사번, 이름, 직위, 입사일, 근무지, 부서명, 등급
	public EmpVO empDetailData(int empno) {
		EmpVO vo = new EmpVO();
		try {
			GetConnection();
			String sql = "SELECT empno, ename, job, hiredate, loc, dname, grade, sal "
					+ "FROM emp, dept, salgrade WHERE emp.deptno = dept.deptno AND sal BETWEEN losal AND hisal AND empno = ?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, empno); // 1 => 첫번째 ? 에 값을 채워준다

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
	    *   네트워크 통신 
	    *   서버 : 오라클 => 응답 
	    *   클라이언트 : 자바 => 요청 (JDBC) 
	    *                        ------- 속도의 문제 : 오라클연결 (DBCP)
	    *                        ------- 코딩이 너무 길어진다 
	    *                                => ORM (MyBatis,Hibernate)
	    *                                => Spring+Mybatis
	    *   서브쿼리 : SQL+SQL => SQL을 한개로 만드는 경우 
	    *            네트워크 => 한번에 모아서 전송 
	    *   ------
	    *     SELECT절 : 컬럼형식 => 스칼라서브쿼리 (테이블 여러개에서 데이터 추출)
	    *        형식) 
	    *             SELECT (SELECT~ ),
	    *                    (SELECT~ )
	    *             FROM table_name
	    *              
	    *     FROM절 : 테이블 대신 사용 => 인라인 뷰 
	    *              => Top-N(rownum) , 페이지 나누기 
	    *        형식)
	    *             SELECT ~
	    *             FROM (SELECT~) 
	    *                  --------- 실행한 컬럼만 사용이 가능 
	    *                  
	    *             SELECT ~
	    *             FROM (SELECT ~
	    *                   FROM (SELECT ~)
	    *     WHERE절 : 조건값 대신 사용 
	    *        형식) 
	    *              단일행 서브쿼리 : 서브쿼리의 결과값이 1개인 경우
	    *              SELECT ~
	    *              FROM table_name
	    *              WHERE 컬럼명 연산자 (SELECT~~)
	    *              ---------------- ----------
	    *                 메인쿼리          서브쿼리 
	    *              다중행 서브쿼리 : 서브쿼리 결과값이 여러개인 경우 
	    *              SELECT ~
	    *              FROM table_name
	    *              WHERE 컬럼명 IN,ANY,ALL,SOME (SELECT~~)
	    *              ---------------- ----------
	    *                 메인쿼리          서브쿼리 
	    *                 
	    *              IN(10,20,30) => 동시 적용 
	    *              > ANY(10,20,30) => 10  >10
	    *              < ANY(10,20,30) => 30  <30
	    *              = ANY(10,20,30) => IN(10,20,30)
	    *              > ALL(10,20,30) => 30  >30
	    *              < ALL(10,20,30) => 10  <10
	    *              --------------------------- MIN/MAX
	    *              
	    *              WHERE deptno > (최소값) => 10,20,30)
	    *                    deptno > ANY(SELECT DISTINCT deptno
	    *                                 FROM emp) 10
	    *                    deptno > (SELECT MIN(deptno) FROM emp) 10
	    *                    
	    *                    deptno < ANY(SELECT DISTINCT deptno
	    *                                 FROM emp) 30
	    *                    deptno < (SELECT MAX(deptno) FROM emp) 30
	    *              
	    */
	   // 급여의 평균보다 많이 받는 사원의 이름,직위,입사일,급여,부서명,근무지 
	   // 서브쿼리 => 조인 
	   // 한명=> EmpVO  , 여러명 => List<EmpVO> 
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

	// 서브쿼리2
	public List<EmpVO> empSubQueryData2() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. 오라클 연결
			GetConnection();
			String sql = "SELECT ename,job,hiredate,sal,dname,loc " 
					+ "FROM emp,dept " 
					+ "WHERE emp.deptno=dept.deptno "
					+ "AND sal>(SELECT ROUND(AVG(sal)) FROM emp) " 
					+ "ORDER BY ename ASC";
			ps = conn.prepareStatement(sql);

			// 5. 결과값 받기
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
			// 오류 처리
			ex.printStackTrace();
		} finally {
			// 닫기
			disConnection();
		}
		return list;
	}

	// 스칼라 서브쿼리
	/*
	 * SELECT ename, job, hiredate,sal, 
	 * (SELECT dname FROM dept WHERE deptno=emp.deptno) dname, 
	 * (SELECT loc FROM dept WHERE deptno=emp.deptno) loc
	 * FROM emp;
	 */
	// -> JOIN없이 서브쿼리로 => 데이터 추출 (이름,직위,입사일, 급여, 부서명,근무지)
	public List<EmpVO> empSubQueryListData() {
		// 1. 리턴형
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. 오라클 연결
			GetConnection(); // LIKE '%A%' ==> LIKE '%'||'A'||'%'
			// 자바에서 => 오라클로 전송 (문자열) => 공백
			// String sql="SELECT ename,job,(SELECT~)"
			// 2. SQL문장
			// SQLDevloper =>
			String sql = "SELECT ename,job,hiredate,sal," + "(SELECT dname FROM dept WHERE deptno=emp.deptno),"
					+ "(SELECT loc FROM dept WHERE deptno=emp.deptno) " + "FROM emp";
			// 3. 오라클로 SQL문장 전송
			ps = conn.prepareStatement(sql);
			// 4. 결과값을 받는다
			ResultSet rs = ps.executeQuery();
			// 5. 결과값을 List에 담는다
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
			disConnection();// 닫기
		}
		return list;
	}

	// 인라인뷰
	/*
	 * SELECT : 사용 
	 * 	1) 전체 목록 (목록 출력) 
	 * 	2) 조건 => 1개 (상세보기) 
	 * 	3) 조인 
	 * 	4) 서브쿼리 : 
	 * 		1) 스칼라 
	 * 		2) 인라인뷰
	 */
	
	// Top-N (위에서 몇개~~ 인기검색어 , 인기 공지사항 ~ 인기 게시물 )
	// 1. 급여가 많은 순서로 상위 5명을 추출 => 이름,입사일, 직위, 급여
	/*
	 * SELECT ----> 3) 
	 * FROM ----- 1) 
	 * WHERE ----- 2) 
	 * ORDER BY --> 4)
	 * 
	 * ==> 중간에 데이터를 추출 할 수 없다 rownum BETWEEN 6 AND 10 ==> (X)
	 */
	public List<EmpVO> empTon5Data() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 연결
			GetConnection();
			// SQL문장
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
