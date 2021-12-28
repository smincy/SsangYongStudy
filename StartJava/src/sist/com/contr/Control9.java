package sist.com.contr;

import java.util.Scanner;
//생년 월 일 나이 띠 요일

public class Control9 {
	Scanner sc = new Scanner(System.in);

	int year = 0;
	int month = 0;
	int day = 0;
	final int nowYear = 2021;

	public void year1() {
		System.out.println("만나이 계산");
		while (true) {
			do {
				System.out.println("Year : (예:1994)");
				year = sc.nextInt();
			} while (!(year >= 1950 && year <= 2021));
			do {
				System.out.println("Month : (예:1~12)");
				month = sc.nextInt();
			} while (!(month >= 1 && month <= 12));
			do {
				System.out.println("Day : (예:1~31)");
				day = sc.nextInt();
			} while (!(day >= 1 && day <= 30));
			if (day != 0) {
				break;
			}
		}
		System.out.printf("만 %d세 입니다.\n", nowYear - year);
		sign(year);
		birD();
	}

	public void sign(int year) {
		String[] str = { "원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양" };
		System.out.println("띠는 '" + str[year % 12] + "' 띠 입니다.");

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
		String[] tmp = { "일", "월", "화", "수", "목", "금", "토" };
		System.out.println(" " + tmp[week] + " 요일에 태어나셨군요.");

		System.out.println();
	}

	public static void main(String[] args) {
		Control9 c = new Control9();

		c.year1();

	}

}
