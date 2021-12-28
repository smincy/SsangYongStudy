package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;
// �̺�Ž��

public class bj1920 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int A[] = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		Arrays.sort(A);

		int M = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		// ã������ ���� ���� ��� 1, ���� ��� 0 ���
		for (int i = 0; i < M; i++) {
			if (binSearch(A, sc.nextInt()) >= 0) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		sc.close();
		System.out.println(sb);
	}

	public static int binSearch(int[] A, int key) {

		int lo = 0; // Ž�� ������ ���� �� �ε���
		int hi = A.length - 1; // Ž�� ������ ������ �� �ε���

		// lo (���� �ε���) �� hi(�������ε���) ���� Ŀ���� ������ �ݺ�
		while (lo <= hi) { // lo �� hi ���� �۰ų� ���� �� �ݺ��� ����
							// lo �� hi ���� Ŀ���� Ż��

			int mid = (lo + hi) / 2; // �߰���ġ

			// ã������ key ���� �߰��� ���� ���� ���
			if (key < A[mid]) {
				// ������ ��ġ���� �������� ��ĭ �̵�
				hi = mid - 1;
			} else if (key > A[mid]) { // key ���� �߰��� ���� Ŭ ���
				// ���� ��ġ���� ���������� ��ĭ �̵�
				lo = mid + 1;
			} else {
				// key ���� �߰����� ���� ���
				return mid;
			}

		}
		// ã���� �ϴ� ���� ���� ���
		return -1;
	}

}
