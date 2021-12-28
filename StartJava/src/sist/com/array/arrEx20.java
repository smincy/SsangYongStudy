package sist.com.array;

import java.util.Arrays;

// ������ �迭 �߰�, ����, ����, �˻�
public class arrEx20 {
	int[][] arr = new int[2][3];
	int row = 0, col = -1; // ��, ��

	public void init() {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = ++cnt;
			}
		}
	}

	public boolean isEmpty() {
		return row == 0 && col == -1;
	}

	public boolean isFull() {
		return row == arr.length - 1 && col == arr[0].length - 1;
	}

	public void disP() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d", arr[i][j]);
			}
			System.out.println();
		}
	}

	public void increment() {
		int tmp[][] = new int[arr.length + 2][arr[0].length];
		System.arraycopy(arr, 0, tmp, 0, arr.length);
		arr = tmp;
	}

	public void add(int data) {
		if (isFull())
			increment();
		if (col < arr[0].length - 1) {
			col++;
		} else {
			col = 0;
			row++;
		}
		arr[row][col] = data;
	}


	public void delete2(int T, char state) { // ����� �ڵ�
		int[] rs = search(T);
		if (rs == null) {
			return;
		}
		for (int i = rs[0]; i < arr.length; i++) {
			for (int j = rs[1]; j < arr[i].length; j++) {
				// ��+�� ������ Ȯ��
				// ���� ������ Ȯ��
				// �Ѵ� ���� �ƴ� ���
				if (i == arr.length - 1 && j == arr[i].length - 1) {
					arr[i][j] = 0;
					break;
				}
				if (j == arr[i].length - 1) { // ũ������ Ȯ�� �߿�
					arr[i][j] = arr[i + 1][0];
					rs[1] = 0;
				} else {
					arr[i][j] = arr[i][j + 1];
				}
			}
		}
		if (col == 0) {
			row--;
			col = arr[0].length - 1;
		} else
			col--;

		if (state == 'a') {
			delete2(T, state);
		}
	}

	public int[] search(int data) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == data)
					return new int[] { i, j };
			} // for
		} // for
		return null;
	}

	public static void main(String[] args) {
		arrEx20 a = new arrEx20();

		a.add(1);
		a.add(2);
		a.add(3);
		a.add(44);
		a.add(54);
		a.add(64);
		a.add(74);
		a.add(84);
		a.add(3);
		a.add(94);
		a.disP();
		System.out.println();
		System.out.println(Arrays.toString(a.search(3)));
		System.out.println();
		a.delete2(3, 'a');
		// a.delete2(84, 'a');
		// a.delete2(1, 'a');
		a.add(11);
		a.disP();

	}

}
