package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1926 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			int cnt = 0;

			if (i < 10) {
				if (i % 3 == 0) {
					System.out.print("- ");
				} else
					System.out.print(i + " ");
			} else {

				String a = Integer.toString(i);
				String tmp[] = a.split("");

				for (int j = 0; j < tmp.length; j++) {
					// && : and    || : or
					if (tmp[j].contains("3") || tmp[j].contains("6") || tmp[j].contains("9")) {
						cnt++;	// contains 공부필요
					}
				}
				
				if (cnt==0) {
					System.out.print(i + " ");
				}else {
					for (int j = 1; j <= cnt; j++) {
						System.out.print('-');
						
					}
					System.out.print(" ");
					
				}
				
			}

		}

	}

}
