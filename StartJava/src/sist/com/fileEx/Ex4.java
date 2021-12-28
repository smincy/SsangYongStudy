package sist.com.fileEx;

// 21.12.23
// ���� �����

// ���� �б� => InputStream, Reader
import java.io.*;

public class Ex4 {

	public static void main(String[] args) {

		FileInputStream fis = null;	// 1 byte �� �о���� Ŭ����, [�׸�����, zip����]
		// �ѱ��� 2byte => �ַ� FileReader ���
		
		FileReader fis2 = null;

		try {

			fis = new FileInputStream("C:\\SY\\eclipse\\StartJava\\StartJava\\src\\sist\\com\\fileEx\\FileEx.java");

			// 1byte�� �д´� => �ѱ��ھ� => int(������ ��ȣ�� �о�´�) 'A' => 65�� �ν�
			int i = 0; // ���� �Ѱ��� �޾Ƽ� ���� �� ����
			// ������ ������ �д´� (EOF, End Of File)
			while ((i = fis.read()) != -1) { // ��� �����͸� �о�Ͷ�
				System.out.print((char) i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �����ݱ�, ���� �ݱ�, ����Ŭ �ݱ�
			try {
				fis.close(); // ���� ó���� �ʿ��� �޼ҵ�� try�� �ȿ�
			} catch (Exception e2) {
			}

		}
	}

}
