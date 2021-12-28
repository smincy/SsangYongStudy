package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 하노이탑 이동 순서
// 첫번째 장대 위에서 세번째 장대 위로 옮기면서 움직인 횟수
// 재귀 알고리즘
public class bj11729 {

	public static int[][] arr;

	public static int[][] initStart(int N) {
		int array[][] = new int[3][N];
		for (int i = 0; i < N; i++) {
			array[0][i] = N - i;
		}
		return array;
	}
	
	public static void swap(int[][] arr){
		
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 첫번째 장대 위에 놓인 원판 개수

		arr = initStart(N);
		
		swap(arr);
		
		
		/*
		 * for (int i = 0; i < arr.length; i++) { for (int j = 0; j < arr[i].length;
		 * j++) { System.out.print(arr[i][j]); } System.out.println(); }
		 */

	}

}
