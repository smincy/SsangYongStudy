package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// �ϳ���ž �̵� ����
// ù��° ��� ������ ����° ��� ���� �ű�鼭 ������ Ƚ��
// ��� �˰���
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

		int N = Integer.parseInt(br.readLine()); // ù��° ��� ���� ���� ���� ����

		arr = initStart(N);
		
		swap(arr);
		
		
		/*
		 * for (int i = 0; i < arr.length; i++) { for (int j = 0; j < arr[i].length;
		 * j++) { System.out.print(arr[i][j]); } System.out.println(); }
		 */

	}

}
