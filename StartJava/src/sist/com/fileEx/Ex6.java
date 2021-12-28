package sist.com.fileEx;
// 21.12.23

// FileWriter (2byte) => 문자스트림 => String
import java.io.*;
import java.util.*;

public class Ex6 {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {

			File file = new File("C:\\SY\\자료\\java_data\\news.txt");
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("파일생성완료");
			}
			/*
			 * // 파일에 데이터 입력 fw = new FileWriter(file, true); String news =
			 * "2022년 등판 '닥터 스트레인지:대혼돈의 멀티버스'\n"; fw.write(news);
			 * System.out.println("데이터 입력 완료");
			 */
			
			// 데이터 읽어오기 => 2byte씩 읽어와야 한글이 정상적으로 출력
			FileReader fr = new FileReader(file);
			int i = 0;
			String msg = "";
			while ((i = fr.read()) != -1) {
				msg+=String.valueOf((char)i);
			}
			System.out.println(msg);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e2) {
			}
		}
	}
}
