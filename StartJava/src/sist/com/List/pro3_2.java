package sist.com.List;

import java.util.Scanner;

public class pro3_2 {
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정렬 전 정수 입력 : (5개)");
		int N[] = new int[5];

		for (int i = 0; i < N.length; i++) {
			N[i] = sc.nextInt();
		}
		sort(N);
	}

	public void sort(int[] N) {
		int temp = 0;
		for (int i = 0; i < N.length; i++) {
			for (int j = i + 1; j < N.length; j++) {
				if (N[i] < N[j]) {
					temp = N[j];
					N[j] = N[i];
					N[i] = temp;
				}
			}
		}
		dis(N);
	}

	public void dis(int[] N) {
		for (int i = 0; i < N.length; i++) {
			System.out.print(N[i] + " ");
		}
	}

	public static void main(String[] args) {
		pro3_2 p2 = new pro3_2();

		p2.input();
	}
}
