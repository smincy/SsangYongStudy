package sist.com.main;

//JSP (웹)
import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpDAO dao = new EmpDAO();

		/*
		 * List<Emp> list = dao.empListData();
		 * 
		 * for (Emp e : list) { System.out.println(e.getEmpno() + " " + e.getEname() +
		 * " " + e.getJob() + " " + e.getHiredate().toString() + " " + e.getSal()); }
		 */
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("사번 입력 : ");
		int empno = sc.nextInt();
		Emp emp = dao.empDetailData(empno);
		System.out.println("-----------실행 결과-----------");
		System.out.println("사번 : " + emp.getEmpno());
		System.out.println("이름 : " + emp.getEname());
		System.out.println("직위 : " + emp.getJob());
		System.out.println("입사일 : " + emp.getHiredate().toString());
		System.out.println("급여 : " + emp.getSal());
		System.out.println("성과급 : " + (emp.getComm() == 0 ? "없음" : emp.getComm()));
		*/
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 사원의 이름 : ");
		String ename = sc.next();

		List<Emp> list = dao.empFindData(ename);

		System.out.println("----------검색 결과----------");

		for (Emp e : list) {
			System.out.println("사번 : " + e.getEmpno());
			System.out.println("이름 : " + e.getEname());
			System.out.println("직위 : " + e.getJob());
			System.out.println("입사일 : " + e.getHiredate().toString());
			System.out.println("급여 : " + e.getSal());
			System.out.println("성과급 : " + (e.getComm() == 0 ? "없음" : e.getComm()));
		}

	}
}