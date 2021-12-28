package BaekJoon;
// 재귀 기초알고리즘 , 팩토리얼
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10872 {

	public static int fac(int N) {
		if (N <= 1)
			return 1; // 종료조건

		return N * fac(N - 1);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int sum = fac(N);
		System.out.println(sum);

	}

}
