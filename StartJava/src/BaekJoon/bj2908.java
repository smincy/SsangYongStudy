package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2908 {

	public static String str[] = new String[2];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine().split(" ");

		check();

	}

	public static void check() {
		int[] tmp = new int[2];

		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = Integer.parseInt(str[i]);
		}

		for (int i = 0; i < 2; i++) {
			int t = 0;
			t = t + ((tmp[i] % 10) * 100);
			tmp[i] = tmp[i] / 10;
			t = t + ((tmp[i] % 10) * 10);
			tmp[i] /= 10;
			t = t + (tmp[i] % 10);
			tmp[i] = t;
		}
		System.out.println(tmp[0] < tmp[1] ? tmp[1] : tmp[0]);
	}
}
