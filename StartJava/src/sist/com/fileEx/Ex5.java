package sist.com.fileEx;

import java.io.*;
import java.util.*;
// 21.12.23

// ���� ����
// FileOutputStream (1byte) => ����Ʈ��Ʈ�� (�ѱ�)
// FileWriter (2byte) => ���ڽ�Ʈ�� => String

public class Ex5 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			// ��������� > ���ϸ���� > ���� ���� > ���� �б�

			File dir = new File("C:\\SY\\�ڷ�\\java_data");
			if (!dir.exists()) {
				dir.mkdir();
				System.out.println("���������Ϸ�");
			}

			File file = new File("C:\\\\SY\\\\�ڷ�\\\\java_data\\student.txt");
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("���ϻ����Ϸ�");
			}

			// �����Է�
			fos = new FileOutputStream(file, true);
			// String hong = "ȫ�浿|80|90|70\n";
			// fos.write(hong.getBytes());

			Scanner sc = new Scanner(System.in);
			System.out.println("�̸� �Է� : ");
			String name = sc.next();
			System.out.println("���� �Է� : ");
			int kor = sc.nextInt();
			System.out.println("���� �Է� : ");
			int eng = sc.nextInt();
			System.out.println("���� �Է� : ");
			int math = sc.nextInt();

			String data = name + "|" + kor + "|" + eng + "|" + math + "\n";
			fos.write(data.getBytes());
			System.out.println("��ϿϷ�");

			// �������
			FileReader fr = new FileReader(file);
			int i = 0;
			String msg = "";
			while ((i = fr.read()) != -1) { // int ������ �о���� ������
				msg += String.valueOf((char) i); // char ������ ����ȯ ����
			}
			System.out.println(msg);

			// ������ ���� (���� ���� ���)
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
