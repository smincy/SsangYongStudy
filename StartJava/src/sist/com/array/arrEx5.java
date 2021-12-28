package sist.com.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
// 배열(선형), 같은 기억 장소의 모임
// 최대, 최소, 근사값, 석차, 중복값, 정렬
// 라이브러리 arrayCount(배열) : 배열의 최댓값
import java.util.Scanner;

public class arrEx5 {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> ALS = new ArrayList<>();

	public void start() {
		switch (sc.nextInt()) {
		case 1:
			System.out.println("int형 숫자 5개 입력해주세요. (1000 이하)");
			inInt();
			break;
		case 2:
			System.out.println("String형 문자열을 입력해주세요.");
			inStr();
			break;
		}
	}

	public void inInt() {
		int[] N = new int[5];
		for (int i = 0; i < N.length; i++) {
			N[i] = sc.nextInt();
		}
		System.out.println("최댓값 : " + Max(N));
		System.out.println("최솟값 : " + Min(N));
		System.out.println("평균값 : " + Avg(N));
		System.out.println("평균근사값 : " + gab(N));
		cnt(N); // 최빈값
		System.out.println("입력횟수 : " + cntMax(N));
		System.out.print("정렬된 배열 : ");
		for (int i : Sort(N)) {
			System.out.print(i + " ");
		}

	}

	public void inStr() {
		System.out.println("입력 : ");
		ALS.add(sc.next());
		while (true) {
			System.out.println("1.계속 입력? 2.현재 Size 3.전체출력 4.종료");
			int tmp = sc.nextInt();
			if (tmp == 1) {
				System.out.println("입력 : ");
				ALS.add(sc.next());
			} else if (tmp == 2) {
				System.out.println("현재 Size : " + ALS.size());
			} else if (tmp == 3) {
				System.out.println(ALS);
			} else {
				System.out.println("종료되었습니다.");
				break;
			}
		}
	}

	public int Max(int[] N) {
		int max = 0;
		for (int i = 0; i < N.length; i++) {
			if (max < N[i]) {
				max = N[i];
			}
		}
		return max;
	}

	public int Min(int[] N) {
		int min = 999999;
		for (int i = 0; i < N.length; i++) {
			if (min > N[i]) {
				min = N[i];
			}
		}
		return min;
	}

	public int Avg(int[] N) {
		int avg = 0;
		for (int i = 0; i < N.length; i++) {
			avg += N[i];
		}
		return avg / N.length;
	}

	public int[] Sort(int[] N) {
		int[] sort = new int[N.length];
		for (int i = 0; i < sort.length; i++) {
			sort[i] = N[i];
		}
		Arrays.sort(sort);

		/*
		 * for문 1개만 사용할 경우 
		 * int i = 0, index = 0, cnt = 0; while (true) { if (i == 5) {
		 * break; } index = N[i]; for (int j = 0; j < N.length; j++) { if (index < N[j])
		 * { cnt++; } } if (sort[cnt] != 0) { sort[cnt + 1] = index; } else { sort[cnt]
		 * = index; } cnt = 0; i++; }
		 */
		return sort;
	}

	public int gab(int[] N) {
		int max = 999999, g = 0; // 비교값, 근사값
		int target = Avg(N);
		for (int i = 0; i < N.length; i++) {
			int tmp = N[i] - target;
			if (tmp < 0) {
				tmp = tmp * (-1);
			}
			if (max > tmp) {
				max = tmp;
				g = N[i];
			}
		}
		return g;
	}

	public int cnt2(int[] N) {
		int cn = 0, t = 0;
		int[] tmp = new int[1000];
		for (int i = 0; i < N.length; i++) {
			tmp[N[i]]++;
		}
		int max = Max(tmp);
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] == max) {
				t = i;
			}
			if (t != cn) {
				cn = i;
			}
		}
		return cn;
	}

	public void cnt(int[] N) {
		int cn = 0;
		int[] tmp = new int[1000];
		for (int i = 0; i < N.length; i++) {
			tmp[N[i]]++;
		}
		int max = 0, cnt2 = 0;
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] != 0 && tmp[i] == max) {
				cnt2 = cnt2(N);
			} else if (tmp[i] > max) {
				max = tmp[i];
				cn = i;
			}
		}
		System.out.println("최빈값 : " + cn + " " + cnt2);
	}

	public int cntMax(int[] N) {
		int cn = 0;
		int[] tmp = new int[1000];
		for (int i = 0; i < N.length; i++) {
			tmp[N[i]]++;
		}
		int max = 0;
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] > max) {
				max = tmp[i];
				cn = i;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		arrEx5 a = new arrEx5();

		System.out.println("입력 타입 선택");
		System.out.println("1.int  2.String");
		a.start();

	}

}
