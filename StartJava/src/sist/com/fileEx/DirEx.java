package sist.com.fileEx;

// 21.12.23
import java.io.*;
import java.util.*;
public class DirEx {
// ���� ���� => ���� ��� ���� �б�

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			File dir = new File("C:\\SY\\�ڷ�");
			System.out.println(dir.getName());
			System.out.println(dir.getPath());
			System.out.println(dir.length());
			System.out.println(dir.lastModified());

			System.out.println("==== ���� �ȿ� �ִ� ��� ���� �б� ====");

			File[] files = dir.listFiles();

			HashSet<String> set = new HashSet<String>();

			for (File f : files) {
				if (f.isFile()) { // ���� �� ��쿡�� ���
					System.out.println(f.getName());

					String name = f.getName();
					String ext = name.substring(name.lastIndexOf(".") + 1); // . ���ĺ��� ���
					System.out.println(ext);
					set.add(ext);
				}
			}

			// �ߺ��� ���� Ȯ���ڸ� ��� => HashSet ��� (�ߺ�����)
			System.out.println("=== �ߺ� ���� Ȯ���� ��� ===");
			for (String s : set) {
				System.out.println(s);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
