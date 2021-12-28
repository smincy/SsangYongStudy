package sist.com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class arrEx20_2 {

	int[][] arr = new int[5][5]; // 기본배열 5 5
	int h = 0, y = -1; // 행, 열

	public boolean isEmpty() { // 비어있는지 확인
		return h == 0 && h == -1;
	}

	public boolean isFull() { // 가득인지 확인 (크기 확인)
		return h == arr.length - 1 && y == arr[0].length - 1;
	}

	public void increment() { // 가득인때 추가 입력 시 크기 수정
		int[][] tmp = new int[arr.length + 2][arr[0].length];
		System.arraycopy(tmp, 0, arr, 0, tmp.length);
		arr = tmp;
	}

	public void add(int data) {
		if (isFull()) {
			increment();
		}
		if (y < arr[0].length - 1) {
			y++;
		} else {
			h++;
			y = 0;
		}
		arr[h][y] = data;
	}

	public int[] search(int sdata) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == sdata) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	public void dis() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
	}

	public void delete(int data) {
		int[] p = search(data); // 데이터 위치
		if (p == null) {
			return;
		}
		for (int i = p[0]; i < arr.length; i++) {
			for (int j = p[1]; j < arr[i].length; j++) {
				if (i == arr.length - 1 && j == arr[i].length - 1) {
					arr[i][j] = 0;
					break;
				}
				if (j == arr[i].length - 1) {
					arr[i][j] = arr[i + 1][0];
					p[1] = 0;
				} else {
					arr[i][j] = arr[i][j + 1];
				}
			}
		}
		if (y == 0) { // 첫번째 칸 일 경우 윗줄 마지막 칸으로 이동해야 하므로
			h--;
			y = arr[0].length;
		} else
			y--;
	}

	public void modi(int Target, int Change) {

	}

	public static void main(String[] args) throws Exception {
		arrEx20_2 a = new arrEx20_2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("1.입력  2.검색  3.삭제  4.수정  5.확인  6.종료");
			switch (Integer.parseInt(br.readLine())) {
			case 1:
				System.out.println("입력 : ");
				a.add(Integer.parseInt(br.readLine()));
				break;
			case 2:
				System.out.println("찾을 데이터 : ");
				if (a.search(Integer.parseInt(br.readLine())) == null) {
					System.out.println("없음");
					break;
				}
				Arrays.toString(a.search(Integer.parseInt(br.readLine())));
				break;
			case 3:
				System.out.println("삭제 할 데이터 : ");
				a.delete(Integer.parseInt(br.readLine()));
				break;
			case 4:
				System.out.println("수정할 데이터 : ");
				int T = Integer.parseInt(br.readLine());
				System.out.println("입력 : ");
				int CV = Integer.parseInt(br.readLine());
				a.modi(T, CV);
				break;
			case 5:
				a.dis();
				break;
			default:
				System.out.println("종료");
				return;
			}
		}

	}
}
