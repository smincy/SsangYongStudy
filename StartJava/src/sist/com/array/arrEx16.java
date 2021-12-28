package sist.com.array;

import java.util.Arrays;

// 2차 배열 구조
public class arrEx16 {

	int[][] m = new int[6][6];

	public void arrEx1() {
		int[][] m = new int[2][3];

		for (int i = 0; i < m.length; i++) { // 배열의 이름.length : 행 갯수
			for (int j = 0; j < m[i].length; j++) { // 배열시작행.length : 열 갯수 , 가변배열 일 경우 m[i].length 로 열 갯수 확인
				// m[i][j] = (int) (Math.random() * 100 % 45);
				System.out.printf("%5d", m[i][j]);
			}
			System.out.println();
		}
		disp2(m);
	}

	public void disp(int[][] m) {
		for (int[] is : m) {
			for (int j : is) { // 2차배열 안에 1차배열, 1차배열 안에 요소
				System.out.printf("%5d", j);
			}
			System.out.println();
		}
	}

	// 다양한 방법으로 출력 가능
	public void disp2(int[][] m) {
		for (int[] is : m) {
			System.out.println(Arrays.toString(is));
		}
	}

	public void disp1(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("%-3d", m[i][j]);
			}
			System.out.println();
		}
	}

	public void arEx2() {
		int[][] a = { { 1, 2, 3, 4, 5 }, { 6, 7, 8 }, { 9 }, { 10, 11, 12, 13, 14, 15 } };
		disp1(a);
	}

	public int rdPro() {
		return (int) (Math.random() * 100 % 45) + 1; // 1~45 까지
	}

	public void initArray() {
		for (int i = 0; i < m.length; i++) {
			m[0][i] = (int) (Math.random() * 100);
		}
	}

	public void db() {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = rdPro();
				for (int k = 0; k < j; k++) {
					if (m[j] == m[k]) { // 중복 검사해서 중복 일 경우 i 인덱스 -- 해주기
						j--;
					}
				}
			}
		}
		disp1(m);
	}

	public static void main(String[] args) {
		arrEx16 a = new arrEx16();
		a.db();
	}

}
