package sist.com.fileEx;

// 21.12.23
import java.io.*;
import java.util.*;
import java.text.*;

public class FileEx {
	public static void main(String[] args) {

		try {
			// 1. ���� ������ ����				***
			File file = new File("C:\\SY\\�ڷ�\\movie.txt");

			// 1-1. ���� �̸� �б�				***
			System.out.println("���ϸ� : " + file.getName());

			// 1-2. ��θ� �����ؼ� �б�			***
			System.out.println("������� : " + file.getPath());

			// 1-3. ��θ� �б�
			System.out.println("��� : " + file.getParent());

			// 1-4. ������ ��¥ Ȯ��
			System.out.println("������ : " + file.lastModified()); // long������ ���

			Date d = new Date(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println(sdf.format(d)); // ��ȯ �� ��¥ ���

			// 1-5. ������ ũ�� Ȯ��				***
			System.out.println("���� ũ�� : " + file.length() + " Bytes");
			String tmp = file.length() > 1024 ? (file.length() / 1024) + "KB" : (file.length()) + "Bytes";
			System.out.println("���� ũ�� : " + tmp);

			// 1-6. Ư�� => �б�����,��������,��������
			System.out.println("�������� : " + file.isHidden());
			System.out.println("�б����� : " + file.canRead());
			System.out.println("�������� : " + file.canWrite());

			// 1-7. �������� ���丮���� Ȯ��		***
			System.out.println("���Ͽ��� : " + file.isFile());
			System.out.println("���丮���� : " + file.isDirectory());

			// 1-8. ������
			System.out.println("������ : " + file.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
