package BaekJoon;
//�̺�Ž��
//BufferedReader , StringTokenizer ����Ͽ� Ǯ��
//�޸�, �ð� ���� ��

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1920_2 {

	public static int A[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int tmpM[] = new int[M];

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			if (binSearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}

	public static int binSearch(int key) {
		// �������� : ã������ �� key
		// ��ȯ��(�����)

		int lo = 0; // ����
		int hi = A.length - 1; // ������

		while (lo <= hi) {

			int mid = (lo + hi) / 2; // �߰���
			
			// ã������ key ���� A�迭�� �δ콺�� �̹Ƿ� A[mid]
			if (key < A[mid]) {
				hi = mid - 1;
			} else if (key > A[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		// ã���� �ϴ� ���� ���� ���
		return -1;
	}

}
