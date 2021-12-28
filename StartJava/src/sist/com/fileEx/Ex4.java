package sist.com.fileEx;

// 21.12.23
// 파일 입출력

// 파일 읽기 => InputStream, Reader
import java.io.*;

public class Ex4 {

	public static void main(String[] args) {

		FileInputStream fis = null;	// 1 byte 씩 읽어오는 클래스, [그림파일, zip파일]
		// 한글은 2byte => 주로 FileReader 사용
		
		FileReader fis2 = null;

		try {

			fis = new FileInputStream("C:\\SY\\eclipse\\StartJava\\StartJava\\src\\sist\\com\\fileEx\\FileEx.java");

			// 1byte로 읽는다 => 한글자씩 => int(문자의 번호를 읽어온다) 'A' => 65로 인식
			int i = 0; // 문자 한개를 받아서 저장 할 변수
			// 파일의 끝까지 읽는다 (EOF, End Of File)
			while ((i = fis.read()) != -1) { // 모든 데이터를 읽어와라
				System.out.print((char) i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 서버닫기, 파일 닫기, 오라클 닫기
			try {
				fis.close(); // 예외 처리가 필요한 메소드라 try절 안에
			} catch (Exception e2) {
			}

		}
	}

}
