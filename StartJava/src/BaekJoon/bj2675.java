package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2675 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String temp[] = br.readLine().split(" ");
			
			int R = Integer.parseInt(temp[0]);
			
			String S = temp[1];
			
			for (int j = 0; j < S.length(); j++) {
				for (int k = 0; k < R; k++) {
					System.out.print(S.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
