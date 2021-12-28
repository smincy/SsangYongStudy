package sist.com.fileEx;

// 21.12.23
// BufferedReader

import java.util.*;
import java.io.*;

public class Ex7_buf {

	public static void main(String[] args) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\SY\\자료\\java_data\\news.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			while (true) {
				String data = br.readLine();
				if (data == null) {
					break;	// 값이 없는 경우 종료
				}
				System.out.println(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
			}
		}

	}

}
