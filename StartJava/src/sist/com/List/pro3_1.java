package sist.com.List;

import java.util.Scanner;

public class pro3_1 {

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("0~32767 까지의 정수 입력 : ");
		int N = sc.nextInt();
		numCheck(N);

	}

	public void numCheck(int N) {

		String bi = Integer.toBinaryString(N);
		dis(bi);
	}

	public void dis(String bi) {
		System.out.printf(String.format("%016d", Integer.parseInt(bi)));
	}

	public static void main(String[] args) {

		pro3_1 p = new pro3_1();

		p.input();
	}
}
