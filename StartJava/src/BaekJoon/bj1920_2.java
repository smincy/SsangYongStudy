package BaekJoon;
//이분탐색
//BufferedReader , StringTokenizer 사용하여 풀이
//메모리, 시간 단출 됨

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1920_2 {

	public static int A[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int tmpM[] = new int[M];

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			if (binSearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}

	public static int binSearch(int key) {
		// 전달인자 : 찾으려는 값 key
		// 반환형(결과형)

		int lo = 0; // 왼쪽
		int hi = A.length - 1; // 오른쪽

		while (lo <= hi) {

			int mid = (lo + hi) / 2; // 중간값
			
			// 찾으려는 key 값은 A배열의 인댁스값 이므로 A[mid]
			if (key < A[mid]) {
				hi = mid - 1;
			} else if (key > A[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		// 찾고자 하는 값이 없는 경우
		return -1;
	}

}
