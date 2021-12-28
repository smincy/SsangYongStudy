package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10809 {

	public static String S;
	public static int[] n = new int[26];

	public void init() {
		for (int i = 0; i < n.length; i++) {
			n[i] = -1;
		}
	}

	public void dis() {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		bj10809 a = new bj10809();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a.init();

		S = br.readLine();

		for (int i = 0; i < S.length(); i++) {
			n[S.charAt(i) - 97] = S.indexOf(S.charAt(i));
		}
		a.dis();
	}
}
