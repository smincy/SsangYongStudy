package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2005 {

	public static int N, arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SWEA2005 a = new SWEA2005();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			System.out.println("#" + (i + 1));
			a.pas(arr[i]);
		}

	}

	public void pas(int arr) {
		int[][] tmp = new int[arr + 1][arr + 1];
		for (int i = 1; i <= arr; i++) {
			tmp[0][0] = 1;
			for (int j = 1; j <= arr; j++) {
				if (j == tmp[i].length - 1) {
					tmp[i][j] = 1; // ³¡ÀÚ¸® = 1
				} else if (tmp[i - 1].length <= 1) {
					tmp[i][j] = 1;
					continue;
				}
				tmp[i][j] = tmp[i - 1][j - 1] + tmp[i - 1][j];
				if (tmp[i][j] != 0) {
					dis(tmp[i][j]);
				}
			}
			System.out.println();
		}
	}

	public void dis(int t) {
		System.out.print(t + " ");
	}
}
