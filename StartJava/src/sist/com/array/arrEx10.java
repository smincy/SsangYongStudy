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
			// Full 이면 바로 넣지 않고 사이즈 조정
			increment();
		}
		m[index++] = data;
	}

	public void add(int fdata, int sdata) {
		// 두개의 원소 입력시 기존 add메소드를 활용하여 입력 할 수 있음
		add(fdata);
		add(sdata);
	}

	public void printArray() {
		for (int i = 0; i < m.length; i++) {
			System.out.printf("%5d", m[i]);
		}
		System.out.println();
	}

	/* 인크리먼트 */
	// 오버플로우 될 경우 크기 조정
	public void increment() {
		int[] temp = new int[m.length * 2]; // 크기는 원하는 만큼
		for (int i = 0; i < m.length; i++) {
			temp[i] = m[i];
		}
		m = temp;
		System.out.println(Arrays.toString(temp));
	}

	int index; // 밖에 선언 할 경우 기본값 0 들어가있음
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
