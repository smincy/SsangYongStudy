package sist.com.array;

import java.util.Random;

// 삽입정렬
// 타겟을 설정하고 타겟이 이전 원소 보다 크기 전까지 확인하면서 들어갈 위치 확인
// 시작타겟은 두번째 원소인 m[1]
public class arrEx9 {

	int[] m = new int[10];

	public void initArr() { // 난수 입력
		Random r = new Random();
		for (int i = 0; i < m.length; i++) {
			m[i] = r.nextInt(100);
		}
	}

	public void inSort() { // 삽입정렬 실행
		int temp = 0, j;
		
		for (int i = 1; i < m.length; i++) {
			int target = m[i]; // 타겟설정
			
			j = i-1; // 타겟의 이전 원소위치
			while (j>=0 && m[j] > target) {
				temp = m[j + 1];
				m[j + 1] = m[j];
				m[j] = temp;
				j--; // 앞에 숫자와 비교하면서 이동하기 위해 --
			}
		}
	}

	public void disP() { // 정렬 배열 출력
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
