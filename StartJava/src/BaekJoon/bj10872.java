package BaekJoon;
// ��� ���ʾ˰��� , ���丮��
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10872 {

	public static int fac(int N) {
		if (N <= 1)
			return 1; // ��������

		return N * fac(N - 1);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int sum = fac(N);
		System.out.println(sum);

	}

}
