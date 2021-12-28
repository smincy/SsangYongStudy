package sist.com.IO_211224;
// FileReader

import java.io.*;
import java.util.*;

public class IO_Ex3 {
	// �о�ͼ� > ArrayList �� ÷�� > list �� �ִ� ������ ���

	public static void main(String[] args) {
		ArrayList<Member> list = new ArrayList<Member>();

		try {
			FileReader fr = new FileReader("C:\\SY\\�ڷ�\\java_data\\address.txt");

			String data = "";
			int i = 0;

			while ((i = fr.read()) != -1) {

				System.out.println();
				data += String.valueOf((char) i); // ���ڿ� ����

			}
			fr.close();

			// �и�
			String[] member = data.split("\n"); // ���� ������ ©��
			for (String line : member) {
				String[] info = line.split("\\|"); // '|' ���� ������ ����

				Member m = new Member(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4]);
				list.add(m);
			}
			
			
			// ������ ���
			for (Member m : list) {
				System.out.println("ȸ����ȣ : " + m.getNo());
				System.out.println("�̸� : "+ m.getName());
				System.out.println("���� : " + m.getSex());
				System.out.println("�ּ� : "+m.getAddr());
				System.out.println("��ȭ��ȣ : "+m.getTel());
				System.out.println("====================");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
