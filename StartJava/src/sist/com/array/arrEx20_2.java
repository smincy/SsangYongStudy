package sist.com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class arrEx20_2 {

	int[][] arr = new int[5][5]; // �⺻�迭 5 5
	int h = 0, y = -1; // ��, ��

	public boolean isEmpty() { // ����ִ��� Ȯ��
		return h == 0 && h == -1;
	}

	public boolean isFull() { // �������� Ȯ�� (ũ�� Ȯ��)
		return h == arr.length - 1 && y == arr[0].length - 1;
	}

	public void increment() { // �����ζ� �߰� �Է� �� ũ�� ����
		int[][] tmp = new int[arr.length + 2][arr[0].length];
		System.arraycopy(tmp, 0, arr, 0, tmp.length);
		arr = tmp;
	}

	public void add(int data) {
		if (isFull()) {
			increment();
		}
		if (y < arr[0].length - 1) {
			y++;
		} else {
			h++;
			y = 0;
		}
		arr[h][y] = data;
	}

	public int[] search(int sdata) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == sdata) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	public void dis() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
	}

	public void delete(int data) {
		int[] p = search(data); // ������ ��ġ
		if (p == null) {
			return;
		}
		for (int i = p[0]; i < arr.length; i++) {
			for (int j = p[1]; j < arr[i].length; j++) {
				if (i == arr.length - 1 && j == arr[i].length - 1) {
					arr[i][j] = 0;
					break;
				}
				if (j == arr[i].length - 1) {
					arr[i][j] = arr[i + 1][0];
					p[1] = 0;
				} else {
					arr[i][j] = arr[i][j + 1];
				}
			}
		}
		if (y == 0) { // ù��° ĭ �� ��� ���� ������ ĭ���� �̵��ؾ� �ϹǷ�
			h--;
			y = arr[0].length;
		} else
			y--;
	}

	public void modi(int Target, int Change) {

	}

	public static void main(String[] args) throws Exception {
		arrEx20_2 a = new arrEx20_2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("1.�Է�  2.�˻�  3.����  4.����  5.Ȯ��  6.����");
			switch (Integer.parseInt(br.readLine())) {
			case 1:
				System.out.println("�Է� : ");
				a.add(Integer.parseInt(br.readLine()));
				break;
			case 2:
				System.out.println("ã�� ������ : ");
				if (a.search(Integer.parseInt(br.readLine())) == null) {
					System.out.println("����");
					break;
				}
				Arrays.toString(a.search(Integer.parseInt(br.readLine())));
				break;
			case 3:
				System.out.println("���� �� ������ : ");
				a.delete(Integer.parseInt(br.readLine()));
				break;
			case 4:
				System.out.println("������ ������ : ");
				int T = Integer.parseInt(br.readLine());
				System.out.println("�Է� : ");
				int CV = Integer.parseInt(br.readLine());
				a.modi(T, CV);
				break;
			case 5:
				a.dis();
				break;
			default:
				System.out.println("����");
				return;
			}
		}

	}
}
