package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2007 {

	// substring , equals 사용 ✔

	public static int N;
	public static String[] str;
	public static int index;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
			strCheck(str[i]);
			System.out.println("#" + (i + 1) + " " + index);
		}
	}

	public static void strCheck(String str) {
		for (int j = 1; j < 30; j++) {
			String tmp = str.substring(0, j);
			if (tmp.equals(str.substring(j, j * 2))) {
				index = j;
				break;
			}
		}
	}
}
