package sist.com.array;

import java.util.Random;

// 1차원 석차, 중복검사
public class arrEx15 {		// (sist.com.core.array) ArrayEx4
	int[] m = new int[6];
	int[] rank = new int[m.length];

	public void initArray() {
		for (int i = 0; i < m.length; i++) {
			m[i] = (int) (Math.random() * 100);
		}
	}

	public void rank() {
		for (int i = 0; i < m.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < m.length; j++) {
				if (m[i] < m[j]) {
					rank[i]++;
				}
			}
		}
		disp(m);
		disp(rank);
	}

	public void disp(int[] m) {
		for (int i : m) {
			System.out.printf("%5d", i);
		}
		System.out.println();
	}

	public int rdPro() {

		return (int) (Math.random() * 100 % 45) + 1; // 1~45 까지
	}

	public void lottoPro() {
		for (int i = 0; i < m.length; i++) {
			m[i] = rdPro();
			for (int j = 0; j < i; j++) {
				if (m[i] == m[j]) {				// 중복 검사해서 중복 일 경우 i 인덱스 -- 해주기
					i--;
				}
			}
		}
		disp(m);
	}

	public static void main(String[] args) {
		arrEx15 a = new arrEx15();
		a.initArray();
		// a.rank();

		a.lottoPro();

	}

}
