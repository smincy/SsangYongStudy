package sist.com.Exception;

//vcandjava@nate.com 
import java.util.Scanner;

public class pro2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		/* 1번 */
		System.out.println("<1번>");
		System.out.println("정수입력 : ");
		int N = sc.nextInt();

		if (N < 0) {
			System.out.println("음수입니다");
		} else
			System.out.println("양수입니다");

		//
		//
		/* 2번 */
		System.out.println("<2번>");
		if (N % 3 == 0) {
			System.out.println("3의 배수 입니다");
		} else
			System.out.println("3의 배수가 아닙니다");

		//
		//
		/* 3번 */
		System.out.println("<3번>");
		if (N < 0) {
			System.out.println(N * -1);
		} else
			System.out.println(N);

		//
		//
		/* 4번 */
		System.out.println("<4번>");
		if (N % 4 == 0 && N % 100 != 0 || N % 400 == 0) {
			System.out.println("윤년입니다");
		} else
			System.out.println("윤년이 아닙니다");

		//
		//
		/* 5번 */
		System.out.println("<5번>");
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
		/* 6번 */
		System.out.println("<6번>");
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

		/* 7번 */
		System.out.println("<7번>");
		System.out.println("정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("+,-,*,/ 입력 : ");
		String c = sc.next();
		System.out.println("정수 입력 : ");
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
		/* 8번 */
		System.out.println("<8번>");
		int sum = 0;
		for (int i = 2; i <= 100; i += 2) {
			sum += i;
		}
		System.out.println(sum);

		//
		//
		/* 9번 */
		System.out.println("<9번>");
		for (int i = 1; i <= 50; i++) {
			if (i % 5 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		//
		//
		/* 10번 */
		System.out.println("<10번>");
		for (int i = 65; i <= 78; i++) {
			if (i % 2 == 0) {
				System.out.print((char) i + " ");
			}
		}
		System.out.println();

		//
		//
		/* 11번 */
		System.out.println("<11번>");
		int sum2 = 0;
		for (int i = 1; i <= N; i++) {
			sum2 += i;
		}
		System.out.println(sum2);

		//
		//
		/* 12번 */
		System.out.println("<12번>");
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
		/* 13번 */
		System.out.println("<13번>");
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
		/* 14번 */
		System.out.println("<14번>");
		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) {
				continue;
			}
			System.out.print(i + " ");
		}

	}
}
