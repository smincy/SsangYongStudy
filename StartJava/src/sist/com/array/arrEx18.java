package sist.com.array;

// 다차원 배열 문제
public class arrEx18 {

	public void disP(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("%5d", m[i][j]);
			}
			System.out.println();
		}
	}

	public void sum(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length - 1; j++) {
				m[i][m[i].length - 1] += m[i][j];
				m[m[i].length - 1][i] += m[j][i];
			}
		}
		disP(m);
	}

	public static void main(String[] args) {
		arrEx18 a = new arrEx18();
		int[][] m = { { 10, 20, 30, 0 }, { 40, 50, 60, 0 }, { 70, 80, 90, 0 }, { 0, 0, 0, 0 } };

		a.sum(m);
	}
}
