package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;
// 이분탐색

public class bj1920 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int A[] = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		Arrays.sort(A);

		int M = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		// 찾으려는 값이 있을 경우 1, 없을 경우 0 출력
		for (int i = 0; i < M; i++) {
			if (binSearch(A, sc.nextInt()) >= 0) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		sc.close();
		System.out.println(sb);
	}

	public static int binSearch(int[] A, int key) {

		int lo = 0; // 탐색 범위의 왼쪽 끝 인덱스
		int hi = A.length - 1; // 탐색 범위의 오른쪽 끝 인덱스

		// lo (왼쪽 인덱스) 가 hi(오른쪽인덱스) 보다 커지기 전까지 반복
		while (lo <= hi) { // lo 가 hi 보다 작거나 같을 때 반복문 수행
							// lo 가 hi 보다 커지면 탈출

			int mid = (lo + hi) / 2; // 중간위치

			// 찾으려는 key 값이 중간값 보다 작을 경우
			if (key < A[mid]) {
				// 오른쪽 위치에서 왼쪽으로 한칸 이동
				hi = mid - 1;
			} else if (key > A[mid]) { // key 값이 중간값 보다 클 경우
				// 왼쪽 위치에서 오른쪽으로 한칸 이동
				lo = mid + 1;
			} else {
				// key 값과 중간값이 같을 경우
				return mid;
			}

		}
		// 찾고자 하는 값이 없을 경우
		return -1;
	}

}
