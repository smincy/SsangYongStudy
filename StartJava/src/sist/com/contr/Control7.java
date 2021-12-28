package sist.com.contr;

import java.util.Scanner;

public class Control7 {
	Scanner sc = new Scanner(System.in);

	public void contro1() {
		System.out.print("cnt : ");
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			System.out.println("A" + (i + 1));
		}
	}

	public void yang() {
		for (int i = 0; i < 100; i++) {
			if (i % 7 == 0)
				System.out.println();
			System.out.print(i + 1 + " ");
		}
	}

	public void em() {
		for (int i = 0; i > -100; i--) {
			if (i % 7 == 0)
				System.out.println();
			System.out.print(i - 1 + " ");
		}
	}

	public void showInt() {
		System.out.println("1.양수  2.음수  3.뒤로가기");
		if (sc.nextInt() == 1) {
			yang();
		} else if (sc.nextInt() == 2) {
			em();
		} else
			return;

	}

	public void showAp() {
		System.out.println("show Ap");
	}

	public void contorl2() {
		System.out.println("1.정수입력  2.알파벳출력  3.나가기");
		while (true) {
			switch (sc.nextInt()) {
			case 1:
				showInt();
				break;
			case 2:
				showAp();
				break;
			case 3:
				System.out.println("종료");
				return;
			}
		}
	}

	public static void main(String[] args) {
		Control7 c = new Control7();
		// c.contro1();
		c.contorl2();
	}

}
