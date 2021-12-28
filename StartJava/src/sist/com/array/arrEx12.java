package sist.com.array;
// �迭 input, search, modify, delete

import java.util.Arrays;
import java.util.Scanner;

public class arrEx12 {
	Scanner sc = new Scanner(System.in);
	int[] arN;

	public void start() {
		while (true) {
			System.out.println("1.�Է�  2.�˻�  3.��üȮ��  4.����  5.����  6.����");
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
				System.out.println("�����ϰڽ��ϴ�.");
				return;
			default:
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				break;

			}
		}
	}

	public void input() {
		System.out.println("�� ���� �����͸� �Է��Ͻðھ��?");
		int N = sc.nextInt();
		arN = new int[N];
		System.out.printf("%d���� �����͸� �Է����ּ���.\n", N);
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
		System.out.println("ã�� ������ : ");
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
			System.out.println("�ش� �����Ͱ� �����ϴ�.");
			return;
		}
		System.out.println("��° �������Դϴ�.");
		System.out.printf("%d���� �����Ͱ� �ֽ��ϴ�.\n", cnt);
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
		System.out.println("������ Ÿ�� : ");
		int T = sc.nextInt();
		if (searchMo(T) == -1) {
			System.out.println("�ش� ���� �����ϴ�.");
			return;
		}
		System.out.println("�Է��� ������ : ");
		int cV = sc.nextInt();
		System.out.println("�ߺ������� �߰� �� 1.��ü����  2.ù��°�� ����");
		int state = sc.nextInt();

		modi2(T, cV, state);
	}

	public void delete() {
		System.out.println("������ ������ : ");
		int d = sc.nextInt();
		if (searchMo(d) == -1) {
			System.out.println("�ش� ���� �����ϴ�.");
			return;
		}
		System.out.println("1.�ߺ��� ��ü  2.ù��° �����͸� ����");
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
