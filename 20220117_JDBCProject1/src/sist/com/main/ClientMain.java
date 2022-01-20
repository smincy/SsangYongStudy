package sist.com.main;

import java.util.*;

// 자바(Main) => JSP(브라우저)
public class ClientMain {

	public static void main(String[] args) {

		// 오라클 연결 DAO
		EmpDAO dao = new EmpDAO();

		// 1. 사원 정보 전체를 출력
		List<EmpVO> list = dao.empListData();

		// 2. 출력
		System.out.println("====== 사원 목록 ======");
		for (EmpVO vo : list) {
			System.out.println(vo.getEmpno() + " " + vo.getEname() + "    " + vo.getJob() + "\t" + vo.getMgr() + "\t"
					+ vo.getHiredate().toString() + "\t" + vo.getSal() + "\t" + vo.getComm() + "\t" + vo.getDeptno());
		}
		System.out.println("\n");
		System.out.println("====== 부서 정보 목록 ======");
		List<DeptVO> dlist = dao.deptListData();
		for (DeptVO vo : dlist) {
			System.out.println(vo.getDeptno() + " " + vo.getDname() + "\t" + vo.getLoc());
		}

		System.out.println("\n");
		System.out.println("====== 급여 정보 목록 ======");
		List<SalGradeVO> slistd = dao.salgradeListData();
		for (SalGradeVO vo : slistd) {
			System.out.println(vo.getGrade() + "  " + vo.getLosal() + "\t" + vo.getHisal());
		}

		System.out.println("\n");
		System.out.println("====== EMP와 DEPT 조인 목록 ======");
		List<EmpVO> eList = dao.empDeptJoinData();
		for (EmpVO vo : eList) {
			System.out.println(
					vo.getEmpno() + " " + vo.getEname() + "  " + vo.getJob() + "\t" + vo.getHiredate().toString() + "\t"
							+ vo.getSal() + "\t" + vo.getDvo().getDname() + "\t" + vo.getDvo().getDeptno());
		}

		System.out.println("\n");
		System.out.println("====== Emp와 Salgrade 조인 목록 ======");
		List<EmpVO> esList = dao.empSalgradeJoinData();
		for (EmpVO vo : esList) {
			System.out.println(vo.getEmpno() + "  " + vo.getEname() + "\t" + vo.getJob() + "   "
					+ vo.getHiredate().toString() + "\t" + vo.getSal() + "\t" + vo.getSvo().getGrade());
		}

		System.out.println("\n");
		System.out.println("====== Emp, Dept, Salgrade 조인 목록 ======");
		List<EmpVO> edsList = dao.empDeptSalgradeJoinData();
		for (EmpVO vo : edsList) {
			System.out.println(vo.getEmpno() + " " + vo.getEname() + " " + vo.getJob() + " "
					+ vo.getHiredate().toString() + " " + vo.getSal() + " " + vo.getDvo().getDname() + " "
					+ vo.getDvo().getLoc() + " " + vo.getSvo().getGrade());
		}

		System.out.println("\n");
		System.out.println("====== 사용자 요청 데이터 첨부 후 결과값 출력 ======");
		Scanner sc = new Scanner(System.in);
		System.out.println("사번 입력 : ");
		int empno = sc.nextInt();
		EmpVO vo = dao.empDetailData(empno);
		System.out.println("사번 :" + "\t" + vo.getEmpno());
		System.out.println("이름 :" + "\t" + vo.getEname());
		System.out.println("직위 : " + vo.getJob());
		System.out.println("입사일 : " + vo.getHiredate());
		System.out.println("급여 : " + vo.getSal());
		System.out.println("부서명 : " + vo.getDvo().getDname());
		System.out.println("근무지 : " + vo.getDvo().getLoc());
		System.out.println("호봉 : " + vo.getSvo().getGrade());
		
		
		
		System.out.println("\n");
		System.out.println("====== JDBC에서 서브쿼리 이용 ======");
		List<EmpVO> subList = dao.empSubQueryData();
		for (EmpVO s : subList) {
			System.out.println(s.getEname() + " "
					+ s.getJob() + " " 
					+ s.getHiredate().toString() + " "
					+ s.getSal() + " " 
					+ s.getDvo().getDname() + " "
					+ s.getDvo().getLoc());
		}
		
		
		
		System.out.println("\n");
		System.out.println("==== JDBC에서 서브쿼리2 이용 =====");
		List<EmpVO> subList2=dao.empSubQueryData2();
		for(EmpVO s:subList2)
		{
			System.out.println(s.getEname()+" "
					+s.getJob()+" "
					+s.getHiredate().toString()+" "
					+s.getSal()+" "
					+s.getDvo().getDname()+" "
					+s.getDvo().getLoc());
		}
		
		System.out.println("\n");
		System.out.println("===== JOIN 대신 스칼라서브쿼리 사용 =====");
		subList2=dao.empSubQueryListData();
		for(EmpVO s:subList2)
		{
			System.out.println(s.getEname()+" "
					+s.getJob()+" "
					+s.getHiredate().toString()+" "
					+s.getSal()+" "
					+s.getDvo().getDname()+" "
					+s.getDvo().getLoc());
		}
		
		
		System.out.println("\n");
		System.out.println("===== 인라인뷰를 이용한 데이터 자르기 =====");
		subList2=dao.empTon5Data();
		for(EmpVO s:subList2)
		{
			System.out.println(s.getEname()+" "
					+s.getJob()+" "
					+s.getHiredate().toString()+" "
					+s.getSal());
		}
		
	}
}
