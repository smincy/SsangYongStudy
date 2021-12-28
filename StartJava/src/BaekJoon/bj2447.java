package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ��� �˰��� , ����� (���̵�� ���� ���� �ʿ� 21.11.22 )
public class bj2447 {

	static char[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new char[N][N]; // �Է¹��� N ũ�� ��ŭ�� �迭 ����

		// ����� �޼ҵ�� arr�迭 ���
		star(0, 0, N, false);

		// StringBuilder �� ����Ͽ� ���ڿ��� �ٿ��� �Է�?�ϰ� sb�� ��±���
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// sb�� ����� arr �� ���� �Է�
				sb.append(arr[i][j]);
			}
			// �ٹٲ�
			sb.append('\n');
		}
		// sb ��ü ���
		System.out.println(sb);
	}

	public static void star(int x, int y, int N, boolean blank) {
		// ����,����,size,���鿩��
		// ������ ��� arr�� ���� �־��ֱ�
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}

		// ���̻� N�� �ɰ� �� ���� ��� �� �� * �Է��ϰ� ����
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}

		// ����� �� ĭ�� ���� ���� size (27�� ��ĭ�� 9, 9�� ��ĭ�� 3) ���� �ɰ� �� ���� ���� �϶� ����
		int size = N / 3;
		// �� ��� Ƚ�� Ȯ�� (blank Ȯ��)
		int cnt = 0;

		// ��� size ��ŭ ������Ű�鼭 ��� ȣ��
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				cnt++;
				// ����ĭ �� ��� true�� ���ȣ��
				if (cnt == 5) {
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
			}
		}
	}
}
