package sist.com.fileEx;

import java.io.*;
import java.util.*;
// 21.12.23

// 파일 쓰기
// FileOutputStream (1byte) => 바이트스트림 (한글)
// FileWriter (2byte) => 문자스트림 => String

public class Ex5 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			// 폴더만들기 > 파일만들기 > 파일 쓰기 > 파일 읽기

			File dir = new File("C:\\SY\\자료\\java_data");
			if (!dir.exists()) {
				dir.mkdir();
				System.out.println("폴더생성완료");
			}

			File file = new File("C:\\\\SY\\\\자료\\\\java_data\\student.txt");
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("파일생성완료");
			}

			// 파일입력
			fos = new FileOutputStream(file, true);
			// String hong = "홍길동|80|90|70\n";
			// fos.write(hong.getBytes());

			Scanner sc = new Scanner(System.in);
			System.out.println("이름 입력 : ");
			String name = sc.next();
			System.out.println("국어 입력 : ");
			int kor = sc.nextInt();
			System.out.println("영어 입력 : ");
			int eng = sc.nextInt();
			System.out.println("수학 입력 : ");
			int math = sc.nextInt();

			String data = name + "|" + kor + "|" + eng + "|" + math + "\n";
			fos.write(data.getBytes());
			System.out.println("등록완료");

			// 파일출력
			FileReader fr = new FileReader(file);
			int i = 0;
			String msg = "";
			while ((i = fr.read()) != -1) { // int 형으로 읽어오기 때문에
				msg += String.valueOf((char) i); // char 형으로 형변환 주의
			}
			System.out.println(msg);

			// 데이터 조절 (점수 총점 평균)
			String[] student = msg.split("\n");
			for (String s : student) {
				String[] info = s.split("\\|");
				System.out.println(info[0] + " " + info[1] + " " + info[2] + " " +
				info[3]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
