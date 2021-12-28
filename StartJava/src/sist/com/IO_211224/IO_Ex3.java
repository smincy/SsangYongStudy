package sist.com.IO_211224;
// FileReader

import java.io.*;
import java.util.*;

public class IO_Ex3 {
	// 읽어와서 > ArrayList 에 첨부 > list 에 있는 데이터 출력

	public static void main(String[] args) {
		ArrayList<Member> list = new ArrayList<Member>();

		try {
			FileReader fr = new FileReader("C:\\SY\\자료\\java_data\\address.txt");

			String data = "";
			int i = 0;

			while ((i = fr.read()) != -1) {

				System.out.println();
				data += String.valueOf((char) i); // 문자열 결합

			}
			fr.close();

			// 분리
			String[] member = data.split("\n"); // 한줄 단위로 짤라서
			for (String line : member) {
				String[] info = line.split("\\|"); // '|' 문자 단위로 분해

				Member m = new Member(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4]);
				list.add(m);
			}
			
			
			// 데이터 출력
			for (Member m : list) {
				System.out.println("회원번호 : " + m.getNo());
				System.out.println("이름 : "+ m.getName());
				System.out.println("성별 : " + m.getSex());
				System.out.println("주소 : "+m.getAddr());
				System.out.println("전화번호 : "+m.getTel());
				System.out.println("====================");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
