package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀 알고리즘 , 별찍기 (아이디어 좀더 이해 필요 21.11.22 )
public class bj2447 {

	static char[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new char[N][N]; // 입력받은 N 크기 만큼의 배열 생성

		// 별찍기 메소드로 arr배열 계산
		star(0, 0, N, false);

		// StringBuilder 를 사용하여 문자열을 붙여서 입력?하고 sb로 출력까지
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// sb에 계산한 arr 별 문자 입력
				sb.append(arr[i][j]);
			}
			// 줄바꿈
			sb.append('\n');
		}
		// sb 전체 출력
		System.out.println(sb);
	}

	public static void star(int x, int y, int N, boolean blank) {
		// 가로,세로,size,공백여부
		// 공백인 경우 arr에 공백 넣어주기
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}

		// 더이상 N을 쪼갤 수 없는 블록 일 때 * 입력하고 리턴
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}

		// 블록의 한 칸을 담을 변수 size (27의 한칸은 9, 9의 한칸은 3) 위에 쪼갤 수 없는 볼록 일때 까지
		int size = N / 3;
		// 별 출력 횟수 확인 (blank 확인)
		int cnt = 0;

		// 블록 size 만큼 증가시키면서 재귀 호출
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				cnt++;
				// 공백칸 일 경우 true로 재귀호출
				if (cnt == 5) {
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
			}
		}
	}
}
