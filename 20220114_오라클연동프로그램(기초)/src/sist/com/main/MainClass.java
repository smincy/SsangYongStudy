package sist.com.main;

// JSP (��)
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

		System.out.println("��� �Է� : ");
		int empno = sc.nextInt();

		Emp emp = dao.empDetailData(empno);

		System.out.println("-----------���� ���-----------");

		System.out.println("��� : " + emp.getEmpno());
		System.out.println("�̸� : " + emp.getEname());
		System.out.println("���� : " + emp.getJob());
		System.out.println("�Ի��� : " + emp.getHiredate().toString());
		System.out.println("�޿� : " + emp.getSal());
		System.out.println("������ : " + (emp.getComm() == 0 ? "����" : emp.getComm()));
		*/
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�˻��� ����� �̸� : ");
		String ename = sc.next();

		List<Emp> list = dao.empFindData(ename);

		System.out.println("----------�˻� ���----------");

		for (Emp e : list) {
			System.out.println("��� : " + e.getEmpno());
			System.out.println("�̸� : " + e.getEname());
			System.out.println("���� : " + e.getJob());
			System.out.println("�Ի��� : " + e.getHiredate().toString());
			System.out.println("�޿� : " + e.getSal());
			System.out.println("������ : " + (e.getComm() == 0 ? "����" : e.getComm()));
		}

	}
}
