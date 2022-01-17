package sist.com.main;

import java.util.*;

// �ڹ�(Main) => JSP(������)
public class ClientMain {

	public static void main(String[] args) {

		// ����Ŭ ���� DAO
		EmpDAO dao = new EmpDAO();

		// 1. ��� ���� ��ü�� ���
		List<EmpVO> list = dao.empListData();

		// 2. ���
		System.out.println("====== ��� ��� ======");
		for (EmpVO vo : list) {
			System.out.println(vo.getEmpno() + " " + vo.getEname() + "    " + vo.getJob() + "\t" + vo.getMgr() + "\t"
					+ vo.getHiredate().toString() + "\t" + vo.getSal() + "\t" + vo.getComm() + "\t" + vo.getDeptno());
		}
		System.out.println("\n");
		System.out.println("====== �μ� ���� ��� ======");
		List<DeptVO> dlist = dao.deptListData();
		for (DeptVO vo : dlist) {
			System.out.println(vo.getDeptno() + " " + vo.getDname() + "\t" + vo.getLoc());
		}

		System.out.println("\n");
		System.out.println("====== �޿� ���� ��� ======");
		List<SalGradeVO> slistd = dao.salgradeListData();
		for (SalGradeVO vo : slistd) {
			System.out.println(vo.getGrade() + "  " + vo.getLosal() + "\t" + vo.getHisal());
		}

		System.out.println("\n");
		System.out.println("====== EMP�� DEPT ���� ��� ======");
		List<EmpVO> eList = dao.empDeptJoinData();
		for (EmpVO vo : eList) {
			System.out.println(
					vo.getEmpno() + " " + vo.getEname() + "  " + vo.getJob() + "\t" + vo.getHiredate().toString() + "\t"
							+ vo.getSal() + "\t" + vo.getDvo().getDname() + "\t" + vo.getDvo().getDeptno());
		}

		System.out.println("\n");
		System.out.println("====== Emp�� Salgrade ���� ��� ======");
		List<EmpVO> esList = dao.empSalgradeJoinData();
		for (EmpVO vo : esList) {
			System.out.println(vo.getEmpno() + "  " + vo.getEname() + "\t" + vo.getJob() + "   "
					+ vo.getHiredate().toString() + "\t" + vo.getSal() + "\t" + vo.getSvo().getGrade());
		}

		System.out.println("\n");
		System.out.println("====== Emp, Dept, Salgrade ���� ��� ======");
		List<EmpVO> edsList = dao.empDeptSalgradeJoinData();
		for (EmpVO vo : edsList) {
			System.out.println(vo.getEmpno() + " " + vo.getEname() + " " + vo.getJob() + " "
					+ vo.getHiredate().toString() + " " + vo.getSal() + " " + vo.getDvo().getDname() + " "
					+ vo.getDvo().getLoc() + " " + vo.getSvo().getGrade());
		}

		System.out.println("\n");
		System.out.println("====== ����� ��û ������ ÷�� �� ����� ��� ======");
		Scanner sc = new Scanner(System.in);
		System.out.println("��� �Է� : ");
		int empno = sc.nextInt();
		EmpVO vo = dao.empDetailData(empno);
		System.out.println("��� :" + "\t" + vo.getEmpno());
		System.out.println("�̸� :" + "\t" + vo.getEname());
		System.out.println("���� : " + vo.getJob());
		System.out.println("�Ի��� : " + vo.getHiredate());
		System.out.println("�޿� : " + vo.getSal());
		System.out.println("�μ��� : " + vo.getDvo().getDname());
		System.out.println("�ٹ��� : " + vo.getDvo().getLoc());
		System.out.println("ȣ�� : " + vo.getSvo().getGrade());
		
		
		
		System.out.println("\n");
		System.out.println("====== JDBC���� �������� �̿� ======");
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
		System.out.println("==== JDBC���� ��������2 �̿� =====");
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
		System.out.println("===== JOIN ��� ��Į�󼭺����� ��� =====");
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
		System.out.println("===== �ζ��κ並 �̿��� ������ �ڸ��� =====");
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
