package sist.com.Exception;

//vcandjava@nate.com 
import java.util.Scanner;

public class pro2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		/* 1�� */
		System.out.println("<1��>");
		System.out.println("�����Է� : ");
		int N = sc.nextInt();

		if (N < 0) {
			System.out.println("�����Դϴ�");
		} else
			System.out.println("����Դϴ�");

		//
		//
		/* 2�� */
		System.out.println("<2��>");
		if (N % 3 == 0) {
			System.out.println("3�� ��� �Դϴ�");
		} else
			System.out.println("3�� ����� �ƴմϴ�");

		//
		//
		/* 3�� */
		System.out.println("<3��>");
		if (N < 0) {
			System.out.println(N * -1);
		} else
			System.out.println(N);

		//
		//
		/* 4�� */
		System.out.println("<4��>");
		if (N % 4 == 0 && N % 100 != 0 || N % 400 == 0) {
			System.out.println("�����Դϴ�");
		} else
			System.out.println("������ �ƴմϴ�");

		//
		//
		/* 5�� */
		System.out.println("<5��>");
		if (N >= 90) {
			System.out.println("A");
		} else if (N >= 80) {
			System.out.println("B");
		} else if (N >= 70) {
			System.out.println("C");
		} else if (N >= 60) {
			System.out.println("D");
		} else
			System.out.println("F");

		//
		//
		/* 6�� */
		System.out.println("<6��>");
		switch (N / 10) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
			break;
		}

		//
		//

		/* 7�� */
		System.out.println("<7��>");
		System.out.println("���� �Է� : ");
		int num1 = sc.nextInt();
		System.out.println("+,-,*,/ �Է� : ");
		String c = sc.next();
		System.out.println("���� �Է� : ");
		int num2 = sc.nextInt();
		switch (c) {
		case "+":
			System.out.println(num1 + num2);
			break;
		case "-":
			System.out.println(num1 - num2);
			break;
		case "*":
			System.out.println(num1 * num2);
			break;
		case "/":
			System.out.println(num1 / num2);
			break;
		}

		//
		//
		/* 8�� */
		System.out.println("<8��>");
		int sum = 0;
		for (int i = 2; i <= 100; i += 2) {
			sum += i;
		}
		System.out.println(sum);

		//
		//
		/* 9�� */
		System.out.println("<9��>");
		for (int i = 1; i <= 50; i++) {
			if (i % 5 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		//
		//
		/* 10�� */
		System.out.println("<10��>");
		for (int i = 65; i <= 78; i++) {
			if (i % 2 == 0) {
				System.out.print((char) i + " ");
			}
		}
		System.out.println();

		//
		//
		/* 11�� */
		System.out.println("<11��>");
		int sum2 = 0;
		for (int i = 1; i <= N; i++) {
			sum2 += i;
		}
		System.out.println(sum2);

		//
		//
		/* 12�� */
		System.out.println("<12��>");
		int cnt = 0;
		for (int i = 1; i <= 30; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
				cnt++;
				if (cnt == 3) {
					System.out.println();
					cnt = 0;
				}
			}
		}

		//
		//
		/* 13�� */
		System.out.println("<13��>");
		int sum3 = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum3 -= i;
			} else
				sum3 += i;
		}
		System.out.println(sum3);

		//
		//
		/* 14�� */
		System.out.println("<14��>");
		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) {
				continue;
			}
			System.out.print(i + " ");
		}

	}
}
