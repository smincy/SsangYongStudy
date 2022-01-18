package sist.com.Main;

import java.util.*;

public class MainClass {
	// 1. ����Ŭ ����
	static StudentDAO dao = new StudentDAO();

	public static void main(String[] args) {

	
		{
			// 2. ����� �Է�
			Scanner sc = new Scanner(System.in);

			System.out.println("�̸� �Է� : ");
			String name = sc.next();
			System.out.println("���� ���� : ");
			int kor = sc.nextInt();
			System.out.println("���� ���� : ");
			int eng = sc.nextInt();
			System.out.println("���� ���� : ");
			int math = sc.nextInt();

			// ����ڰ� �Է��� ���� ��� ����Ŭ�� ����
			StudentVO vo = new StudentVO();
			vo.setName(name);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMath(math);
			// ����Ŭ�� INSERT ��û
			dao.studentInsert(vo);
			System.out.println("===== ����Ŭ ������ �߰� �Ϸ� =====");
			studentPrint();
		}

		/*
		 * // 3. ��� List<StudentVO> list = dao.studentListData(); // ����ڿ��� ��� for
		 * (StudentVO vo2 : list) { System.out.println(vo2.getHakbun() + " " +
		 * vo2.getName() + " " + vo2.getKor() + " " + vo2.getEng() + " " +
		 * vo2.getMath()); }
		 */

		{
		// 4. ������Ʈ
			Scanner sc = new Scanner(System.in);
			System.out.println("������ �й� �Է� : ");
			int hakbun = sc.nextInt();
			System.out.println("���� ���� : ");
			int kor = sc.nextInt();
			System.out.println("���� ���� : ");
			int eng = sc.nextInt();
			System.out.println("���� ���� : ");
			int math = sc.nextInt();

			StudentVO vo = new StudentVO();
			vo.setHakbun(hakbun);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMath(math);

			dao.studentUpdate(vo);

			System.out.println("===== ���� �Ϸ� =====");
			studentPrint();
		}	
		
		{
			// 5. ����
			Scanner sc = new Scanner(System.in);
			System.out.println("������ �й� ���� : ");
			int hakbun = sc.nextInt();
			dao.studentDelete(hakbun);
			System.out.println("===== ���� �Ϸ� =====");
			studentPrint();
		}
		

	}

	public static void studentPrint() { // �ݺ��Ǵ� ��¹��� �޼ҵ��
		List<StudentVO> list = dao.studentListData();
		for (StudentVO vo : list) {
			System.out.println(
					vo.getHakbun() + " " + vo.getName() + " " + vo.getKor() + " " + vo.getEng() + " " + vo.getMath());
		}
	}
}
