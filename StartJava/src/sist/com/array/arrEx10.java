package sist.com.array;

import java.util.Arrays;

// 

public class arrEx10 {
	public boolean isEmpty() {
		return index == 0;
	}

	public boolean isFull() {
		return index == m.length;
	}

	public void add(int data) {
		if (isFull()) {
			// Full �̸� �ٷ� ���� �ʰ� ������ ����
			increment();
		}
		m[index++] = data;
	}

	public void add(int fdata, int sdata) {
		// �ΰ��� ���� �Է½� ���� add�޼ҵ带 Ȱ���Ͽ� �Է� �� �� ����
		add(fdata);
		add(sdata);
	}

	public void printArray() {
		for (int i = 0; i < m.length; i++) {
			System.out.printf("%5d", m[i]);
		}
		System.out.println();
	}

	/* ��ũ����Ʈ */
	// �����÷ο� �� ��� ũ�� ����
	public void increment() {
		int[] temp = new int[m.length * 2]; // ũ��� ���ϴ� ��ŭ
		for (int i = 0; i < m.length; i++) {
			temp[i] = m[i];
		}
		m = temp;
		System.out.println(Arrays.toString(temp));
	}

	int index; // �ۿ� ���� �� ��� �⺻�� 0 ������
	int[] m = new int[5];

	public static void main(String[] args) {
		arrEx10 a = new arrEx10();
		// System.out.println(a.isEmpty());
		// System.out.println(a.isFull());
		a.add(10);
		a.add(20);
		a.add(30, 55);
		a.add(80);
		a.add(15);

		a.printArray();
	}

}
