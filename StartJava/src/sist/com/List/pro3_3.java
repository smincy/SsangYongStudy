package sist.com.List;

import java.util.Scanner;

public class pro3_3 {
	public static int N;

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("년도 입력 : ");

		N = sc.nextInt();
		yunDal(N);
	}

	public void yunDal(int N) {
		boolean yd = false;
		if (N % 4 == 0 && N % 100 != 0 || N % 400 == 0) {
			yd = true;
		} else
			yd = false;
		dis(yd);
	}

	public void dis(boolean yd) {
		if (yd) {
			System.out.printf("%d 년도는 윤년이 맞습니다.", N);
		} else
			System.out.printf("%d 년도는 윤년이 아닙니다.", N);
		boolean T = yd ? System.out.printf("%d 년도는 윤년입니다.", N) != null : System.out.printf("%d 년도는 윤년이 아닙니다.", N) != null;
	}

	public static void main(String[] args) {
		pro3_3 p3 = new pro3_3();
		p3.input();
	}
}
