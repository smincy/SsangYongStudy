package sist.com.array;

import java.util.Random;

// ��������, ��������, ��������, ������
// �� ���Ŀ� ���ؼ�, �� ������ ����� / �׸�?
public class arrEx7 {

	int[] m = new int[10];

	public void initArray() {
		Random random = new Random();
		// random.nextInt(***); *** �̸� ���� ���
		for (int i = 0; i < m.length; i++) {
			m[i] = random.nextInt(100);
		}
	}

	public void swap(int i, int j) {
		int temp = 0;
		temp = m[i];
		m[i] = m[j];
		m[j] = temp;
	}

	public void selecSort(int order) { // ��������
		int min = 10000, temp = 0, index = 0;
		for (int i = 0; i < m.length - 1; i++) { // �������� �ȵ��Ƶ� �Ǵϱ� -1
			for (int j = i + 1; j < m.length; j++) {
				/*
				 * if (order == 0) { if (m[i] < m[j]) { // '<' �������� '>' �������� swap(i, j); } }
				 * else { if (m[i] > m[j]) { swap(i, j); } // ����, ���� ���� / �ߺ��ڵ�� �޼ҵ�� ���� �����ϰ�
				 * ��������� }
				 */
				if (min > m[j]) {
					min = m[j];
					index = j;
				}
			}
			swap(i, index);
		}
	}

	public void sortDisp() { // ���� ���
		for (int i : m) {
			System.out.printf("%3d", i);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		arrEx7 a = new arrEx7();
		a.initArray(); // �迭 �ʱ�ȭ
		a.selecSort(0); // �������� ���� / 0, 1 : ��������, ��������
		a.sortDisp(); // ���
	}
}
