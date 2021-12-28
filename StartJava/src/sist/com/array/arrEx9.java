package sist.com.array;

import java.util.Random;

// ��������
// Ÿ���� �����ϰ� Ÿ���� ���� ���� ���� ũ�� ������ Ȯ���ϸ鼭 �� ��ġ Ȯ��
// ����Ÿ���� �ι�° ������ m[1]
public class arrEx9 {

	int[] m = new int[10];

	public void initArr() { // ���� �Է�
		Random r = new Random();
		for (int i = 0; i < m.length; i++) {
			m[i] = r.nextInt(100);
		}
	}

	public void inSort() { // �������� ����
		int temp = 0, j;
		
		for (int i = 1; i < m.length; i++) {
			int target = m[i]; // Ÿ�ټ���
			
			j = i-1; // Ÿ���� ���� ������ġ
			while (j>=0 && m[j] > target) {
				temp = m[j + 1];
				m[j + 1] = m[j];
				m[j] = temp;
				j--; // �տ� ���ڿ� ���ϸ鼭 �̵��ϱ� ���� --
			}
		}
	}

	public void disP() { // ���� �迭 ���
		for (int i : m) {
			System.out.printf("%3d", i);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		arrEx9 a = new arrEx9();
		a.initArr();
		a.inSort();
		a.disP();
	}
}
