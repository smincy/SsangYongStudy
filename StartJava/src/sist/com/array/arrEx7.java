package sist.com.array;

import java.util.Random;

// 선택정렬, 삽입정렬, 버블정렬, 퀵정렬
// 각 정렬에 대해서, 각 정렬의 장단점 / 그림?
public class arrEx7 {

	int[] m = new int[10];

	public void initArray() {
		Random random = new Random();
		// random.nextInt(***); *** 미만 난수 출력
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

	public void selecSort(int order) { // 선택정렬
		int min = 10000, temp = 0, index = 0;
		for (int i = 0; i < m.length - 1; i++) { // 마지막은 안돌아도 되니까 -1
			for (int j = i + 1; j < m.length; j++) {
				/*
				 * if (order == 0) { if (m[i] < m[j]) { // '<' 내림차순 '>' 오름차순 swap(i, j); } }
				 * else { if (m[i] > m[j]) { swap(i, j); } // 오름, 내림 선택 / 중복코드는 메소드로 빼서 간결하게
				 * 만들수있음 }
				 */
				if (min > m[j]) {
					min = m[j];
					index = j;
				}
			}
			swap(i, index);
		}
	}

	public void sortDisp() { // 정렬 출력
		for (int i : m) {
			System.out.printf("%3d", i);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		arrEx7 a = new arrEx7();
		a.initArray(); // 배열 초기화
		a.selecSort(0); // 선택정렬 실행 / 0, 1 : 내림차순, 오름차순
		a.sortDisp(); // 출력
	}
}
