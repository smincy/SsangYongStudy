package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1427 {

	public static int temp[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String A = br.readLine();

		temp = new int[10];

		for (int i = 0; i < A.length(); i++) {
			temp[A.charAt(i) - '0']++;	// '0' 부분 확인필요
		}

		for (int i = 9; i >= 0; i--) {
			while (temp[i]-- > 0) {
				System.out.print(i);
			}

		}

	}

}
