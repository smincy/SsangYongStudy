package sist.com.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
// �迭(����), ���� ��� ����� ����
// �ִ�, �ּ�, �ٻ簪, ����, �ߺ���, ����
// ���̺귯�� arrayCount(�迭) : �迭�� �ִ�
import java.util.Scanner;

public class arrEx5 {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> ALS = new ArrayList<>();

	public void start() {
		switch (sc.nextInt()) {
		case 1:
			System.out.println("int�� ���� 5�� �Է����ּ���. (1000 ����)");
			inInt();
			break;
		case 2:
			System.out.println("String�� ���ڿ��� �Է����ּ���.");
			inStr();
			break;
		}
	}

	public void inInt() {
		int[] N = new int[5];
		for (int i = 0; i < N.length; i++) {
			N[i] = sc.nextInt();
		}
		System.out.println("�ִ� : " + Max(N));
		System.out.println("�ּڰ� : " + Min(N));
		System.out.println("��հ� : " + Avg(N));
		System.out.println("��ձٻ簪 : " + gab(N));
		cnt(N); // �ֺ�
		System.out.println("�Է�Ƚ�� : " + cntMax(N));
		System.out.print("���ĵ� �迭 : ");
		for (int i : Sort(N)) {
			System.out.print(i + " ");
		}

	}

	public void inStr() {
		System.out.println("�Է� : ");
		ALS.add(sc.next());
		while (true) {
			System.out.println("1.��� �Է�? 2.���� Size 3.��ü��� 4.����");
			int tmp = sc.nextInt();
			if (tmp == 1) {
				System.out.println("�Է� : ");
				ALS.add(sc.next());
			} else if (tmp == 2) {
				System.out.println("���� Size : " + ALS.size());
			} else if (tmp == 3) {
				System.out.println(ALS);
			} else {
				System.out.println("����Ǿ����ϴ�.");
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
		 * for�� 1���� ����� ��� 
		 * int i = 0, index = 0, cnt = 0; while (true) { if (i == 5) {
		 * break; } index = N[i]; for (int j = 0; j < N.length; j++) { if (index < N[j])
		 * { cnt++; } } if (sort[cnt] != 0) { sort[cnt + 1] = index; } else { sort[cnt]
		 * = index; } cnt = 0; i++; }
		 */
		return sort;
	}

	public int gab(int[] N) {
		int max = 999999, g = 0; // �񱳰�, �ٻ簪
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
		System.out.println("�ֺ� : " + cn + " " + cnt2);
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

		System.out.println("�Է� Ÿ�� ����");
		System.out.println("1.int  2.String");
		a.start();

	}

}
