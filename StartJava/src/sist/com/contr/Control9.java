package sist.com.contr;

import java.util.Scanner;
//���� �� �� ���� �� ����

public class Control9 {
	Scanner sc = new Scanner(System.in);

	int year = 0;
	int month = 0;
	int day = 0;
	final int nowYear = 2021;

	public void year1() {
		System.out.println("������ ���");
		while (true) {
			do {
				System.out.println("Year : (��:1994)");
				year = sc.nextInt();
			} while (!(year >= 1950 && year <= 2021));
			do {
				System.out.println("Month : (��:1~12)");
				month = sc.nextInt();
			} while (!(month >= 1 && month <= 12));
			do {
				System.out.println("Day : (��:1~31)");
				day = sc.nextInt();
			} while (!(day >= 1 && day <= 30));
			if (day != 0) {
				break;
			}
		}
		System.out.printf("�� %d�� �Դϴ�.\n", nowYear - year);
		sign(year);
		birD();
	}

	public void sign(int year) {
		String[] str = { "������", "��", "��", "����", "��", "��", "ȣ����", "�䳢", "��", "��", "��", "��" };
		System.out.println("��� '" + str[year % 12] + "' �� �Դϴ�.");

	}

	public boolean yundal(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	public void birD() {
		int cnt = 0;
		cnt = (year - 1) * 365;
		for (int i = 1; i < year; i++) {
			if (yundal(i)) {
				cnt++;
			}
		}
		for (int i = 1; i < month; i++) {
			int[] tmp = { 0, 31, yundal(i) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

			cnt += tmp[i];
		}

		cnt += day;
		int week = cnt % 7;
		String[] tmp = { "��", "��", "ȭ", "��", "��", "��", "��" };
		System.out.println(" " + tmp[week] + " ���Ͽ� �¾�̱���.");

		System.out.println();
	}

	public static void main(String[] args) {
		Control9 c = new Control9();

		c.year1();

	}

}
