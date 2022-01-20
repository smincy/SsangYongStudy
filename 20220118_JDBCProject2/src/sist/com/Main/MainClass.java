package sist.com.Main;

import java.util.*;

public class MainClass {
	// 1. 오라클 연결
	static StudentDAO dao = new StudentDAO();

	public static void main(String[] args) {

		{
			// 2. 사용자 입력
			Scanner sc = new Scanner(System.in);

			System.out.println("이름 입력 : ");
			String name = sc.next();
			System.out.println("국어 점수 : ");
			int kor = sc.nextInt();
			System.out.println("영어 점수 : ");
			int eng = sc.nextInt();
			System.out.println("수학 점수 : ");
			int math = sc.nextInt();

			// 사용자가 입력한 값을 묶어서 오라클로 전송
			StudentVO vo = new StudentVO();
			vo.setName(name);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMath(math);
			// 오라클에 INSERT 요청
			dao.studentInsert(vo);
			System.out.println("===== 오라클 데이터 추가 완료 =====");
			studentPrint();
		}

		/*
		 * // 3. 출력 List<StudentVO> list = dao.studentListData(); // 사용자에게 출력 for
		 * (StudentVO vo2 : list) { System.out.println(vo2.getHakbun() + " " +
		 * vo2.getName() + " " + vo2.getKor() + " " + vo2.getEng() + " " +
		 * vo2.getMath()); }
		 */

		{
			// 4. 업데이트
			Scanner sc = new Scanner(System.in);
			System.out.println("수정할 학번 입력 : ");
			int hakbun = sc.nextInt();
			System.out.println("국어 변경 : ");
			int kor = sc.nextInt();
			System.out.println("영어 변경 : ");
			int eng = sc.nextInt();
			System.out.println("수학 변경 : ");
			int math = sc.nextInt();

			StudentVO vo = new StudentVO();
			vo.setHakbun(hakbun);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMath(math);

			dao.studentUpdate(vo);

			System.out.println("===== 수정 완료 =====");
			studentPrint();
		}

		{
			// 5. 삭제
			Scanner sc = new Scanner(System.in);
			System.out.println("삭제할 학번 선택 : ");
			int hakbun = sc.nextInt();
			dao.studentDelete(hakbun);
			System.out.println("===== 삭제 완료 =====");
			studentPrint();
		}

	}

	public static void studentPrint() { // 반복되는 출력문을 메소드로
		List<StudentVO> list = dao.studentListData();
		for (StudentVO vo : list) {
			System.out.println(
					vo.getHakbun() + " " + vo.getName() + " " + vo.getKor() + " " + vo.getEng() + " " + vo.getMath());
		}
	}
}