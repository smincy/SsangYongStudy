package sist.com.array;

// �������� 
import java.util.Random;

public class arrEx8 {
	int[] m = new int[10];

	public void initArray() {
		Random random = new Random();
		// random.nextInt(***); *** �̸� ���� ���
		for (int i = 0; i < m.length; i++) {
			m[i] = random.nextInt(100);
		}
	}

	public void swap(int j) {
		int temp = 0;
		temp = m[j + 1];
		m[j + 1] = m[j];
		m[j] = temp;
	}

	public void buble(int order) { // ��������
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < (m.length - 1) - i; j++) {
// �ѹ� ���� ���� �� ���� ū ���� ���� �ڿ� ���� �Ϸ�Ǿ� ������ ũ�Ⱑ �ϳ��� �۾����Ƿ�
				if (order == 0) {
					if (m[j] < m[j + 1]) {
						swap(j);
					}
				} else {
					if (m[j] > m[j + 1]) {
						swap(j);
					}
				}
			}
		}
	}

	public void sortDisp() { // ���� ���
		for (int i : m) {
			System.out.printf("%3d", i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		arrEx8 a = new arrEx8();
		a.initArray();
		a.buble(1);
		a.sortDisp();

	}

}
