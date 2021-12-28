package sist.com.array;

// 버블정렬 
import java.util.Random;

public class arrEx8 {
	int[] m = new int[10];

	public void initArray() {
		Random random = new Random();
		// random.nextInt(***); *** 미만 난수 출력
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

	public void buble(int order) { // 버블정렬
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < (m.length - 1) - i; j++) {
// 한번 정렬 수행 후 가장 큰 수가 가장 뒤에 정렬 완료되어 집합의 크기가 하나씩 작아지므로
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

	public void sortDisp() { // 정렬 출력
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
