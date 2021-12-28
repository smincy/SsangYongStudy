package sist.com.fileEx;
// 21.12.23

// FileWriter (2byte) => ���ڽ�Ʈ�� => String
import java.io.*;
import java.util.*;

public class Ex6 {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {

			File file = new File("C:\\SY\\�ڷ�\\java_data\\news.txt");
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("���ϻ����Ϸ�");
			}
			/*
			 * // ���Ͽ� ������ �Է� fw = new FileWriter(file, true); String news =
			 * "2022�� ���� '���� ��Ʈ������:��ȥ���� ��Ƽ����'\n"; fw.write(news);
			 * System.out.println("������ �Է� �Ϸ�");
			 */
			
			// ������ �о���� => 2byte�� �о�;� �ѱ��� ���������� ���
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
