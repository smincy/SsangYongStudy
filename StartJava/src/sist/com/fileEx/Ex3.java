package sist.com.fileEx;
// 21.12.23

import java.util.*;
import java.io.*;

// ����, ���� ���� (�����, ����)
// ���� �����

public class Ex3 {

	public static void main(String[] args) {
		try {

			File dir = new File("C:\\SY\\�ڷ�\\Down");
			// ������ ���� ���� Ȯ��
			if (!dir.exists()) { // �����ϳ�/ !���̸� ��������������
				dir.mkdir(); // ������ �����
				System.out.println("���� ���� �Ϸ�");
			}

			File file = new File("C:\\SY\\�ڷ�\\Down\\food.txt");
			if (!file.exists()) { // ������ ������
				file.createNewFile(); // ���� �����
				System.out.println("���� ���� �Ϸ�");
			}

			// ����
			file.delete();
			System.out.println("���� ���� �Ϸ�");
			dir.delete();
			System.out.println("���� ���� �Ϸ�");

		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

}
