package sist.com.array;
// 배열 input, search, modify, delete

import java.util.Arrays;
import java.util.Scanner;

public class arrEx12 {
	Scanner sc = new Scanner(System.in);
	int[] arN;

	public void start() {
		while (true) {
			System.out.println("1.입력  2.검색  3.전체확인  4.수정  5.삭제  6.종료");
			switch (sc.nextInt()) {
			case 1:
				input();
				break;
			case 2:
				search();
				break;
			case 3:
				check();
				break;
			case 4:
				modify();
				break;
			case 5:
				delete();
				break;
			case 6:
				System.out.println("종료하겠습니다.");
				return;
			default:
				System.out.println("잘못 입력 하셨습니다.");
				System.out.println("다시 입력해주세요.");
				break;

			}
		}
	}

	public void input() {
		System.out.println("몇 개의 데이터를 입력하시겠어요?");
		int N = sc.nextInt();
		arN = new int[N];
		System.out.printf("%d개의 데이터를 입력해주세요.\n", N);
		for (int i = 0; i < arN.length; i++) {
			arN[i] = sc.nextInt();
		}
	}

	public void check() {
		for (int i = 0; i < arN.length; i++) {
			System.out.print(" " + arN[i]);
		}
		System.out.println();
	}

	public void search() {
		System.out.println("찾을 데이터 : ");
		int sear = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < arN.length; i++) {
			if (arN[i] == sear) {
				if (cnt != 0)
					System.out.print(",");
				cnt++;
				System.out.print(i + 1);
			}
		}
		if (cnt == 0) {
			System.out.println("해당 데이터가 없습니다.");
			return;
		}
		System.out.println("번째 데이터입니다.");
		System.out.printf("%d개의 데이터가 있습니다.\n", cnt);
	}

	public int searchMo(int Target) {
		int index = 0;
		for (int i = 0; i < arN.length; i++) {
			if (arN[i] == Target) {
				index = i;
				return index;
			}
		}
		return -1;
	}

	public void modi2(int T, int cV, int state) {
		arN[searchMo(T)] = cV;
		if (state == 1) {
			if (searchMo(T) == -1) {
				return;
			}
			modi2(T, cV, state);
		}
		check();
	}

	public void modify() {
		System.out.println("수정할 타겟 : ");
		int T = sc.nextInt();
		if (searchMo(T) == -1) {
			System.out.println("해당 값이 없습니다.");
			return;
		}
		System.out.println("입력할 데이터 : ");
		int cV = sc.nextInt();
		System.out.println("중복데이터 발견 시 1.전체수정  2.첫번째만 수정");
		int state = sc.nextInt();

		modi2(T, cV, state);
	}

	public void delete() {
		System.out.println("삭제할 데이터 : ");
		int d = sc.nextInt();
		if (searchMo(d) == -1) {
			System.out.println("해당 값이 없습니다.");
			return;
		}
		System.out.println("1.중복값 전체  2.첫번째 데이터만 삭제");
		int sta = sc.nextInt();
		de2(d, sta);
	}

	public void de2(int d, int sta) {
		int[] temp = new int[arN.length];

		for (int i = 0; i < arN.length; i++) {
			if (arN[i] == d) {
				for (int j = 0; j < i; j++) {
					temp[j] = arN[j];
				}
				for (int j = i; j < arN.length - 1; j++) {
					temp[j] = arN[j + 1];
				}
			}
		}
		System.arraycopy(temp, 0, arN, 0, temp.length);

		if (sta == 1) {
			if (searchMo(d) == -1) {
				check();
				return;
			}
			de2(d, sta);
		}
		check();
	}

	public static void main(String[] args) {
		arrEx12 a = new arrEx12();

		a.start();
	}

}
