package sist.com.array;
//upper, lower, initcap, reverse, substring, startWith, indexOf

// 중복되는건 하나로 뭉쳐보고, 재귀, 간결하게 만들어보기

import java.util.Scanner;

public class arrEx14 { // 강사님 ArrayEx3

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

		System.out.println("upper 문자열 : ");
		String str = sc.next();
		// a.strUp(str);
		a.lower(str);

		sc.close();

	}

}
