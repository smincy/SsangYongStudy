package BaekJoon;

// 피보나치수 : 바로 앞 두 피보나치수의 합
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj10870 {

	static BufferedReader br;
	public static int N;

	public static int pibo(int N) {

		int arr[] = new int[N + 1];

		if (N == 0)
			return 0;
		if (N == 1)
			return 1;

		/* 배열 + for문으로 풀이 */
		/*
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				arr[0] = 0;
			}else if (i==1) {
				arr[1]=1;
			}else
				arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[N];
		*/
		return pibo(N - 1) + pibo(N - 2);

	}

	public static void main(String[] args) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		System.out.println(pibo(N));

	}

}
