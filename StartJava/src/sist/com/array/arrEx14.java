package sist.com.array;
//upper, lower, initcap, reverse, substring, startWith, indexOf

// �ߺ��Ǵ°� �ϳ��� ���ĺ���, ���, �����ϰ� ������

import java.util.Scanner;

public class arrEx14 { // ����� ArrayEx3

	public void strUp(String str) {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char tmp = str.charAt(i);
			System.out.print((char) (tmp - 32));
		}
	}

	public void lower(String str) {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char tmp = str.charAt(i);
			System.out.print((char) (tmp + 32));
		}
	}

	public static void main(String[] args) {
		arrEx14 a = new arrEx14();
		Scanner sc = new Scanner(System.in);

		System.out.println("upper ���ڿ� : ");
		String str = sc.next();
		// a.strUp(str);
		a.lower(str);

		sc.close();

	}

}
