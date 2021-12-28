package sist.com.array;

// 다차원 배열 문제 2
// [4][3] >> [3][4]
public class arrEx19 {

	public void disP(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("%5d", m[i][j]);
			}
			System.out.println();
		}
	}

	public void change(int[][] x) {
		int[][] tmp = new int[3][4];
		int h = 0, y = 0;
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				tmp[i][j] = x[h][y];
				y++;
				if (y == x[i].length) {
					h += 1;
					y = 0;
				}
			}
		}
		disP(tmp);
	}

	public static void main(String[] args) {
		arrEx19 a = new arrEx19();

		int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

		a.change(m);

	}
}
