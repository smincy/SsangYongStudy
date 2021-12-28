package sist.com.array;

import java.util.Arrays;

// 2�� �迭 ����
public class arrEx16 {

	int[][] m = new int[6][6];

	public void arrEx1() {
		int[][] m = new int[2][3];

		for (int i = 0; i < m.length; i++) { // �迭�� �̸�.length : �� ����
			for (int j = 0; j < m[i].length; j++) { // �迭������.length : �� ���� , �����迭 �� ��� m[i].length �� �� ���� Ȯ��
				// m[i][j] = (int) (Math.random() * 100 % 45);
				System.out.printf("%5d", m[i][j]);
			}
			System.out.println();
		}
		disp2(m);
	}

	public void disp(int[][] m) {
		for (int[] is : m) {
			for (int j : is) { // 2���迭 �ȿ� 1���迭, 1���迭 �ȿ� ���
				System.out.printf("%5d", j);
			}
			System.out.println();
		}
	}

	// �پ��� ������� ��� ����
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
		return (int) (Math.random() * 100 % 45) + 1; // 1~45 ����
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
					if (m[j] == m[k]) { // �ߺ� �˻��ؼ� �ߺ� �� ��� i �ε��� -- ���ֱ�
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
