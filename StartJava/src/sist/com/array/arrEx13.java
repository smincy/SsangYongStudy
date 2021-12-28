package sist.com.array;

// 달력
import java.util.Scanner;

public class arrEx13 {

	Scanner scanner = new Scanner(System.in);

	public boolean yunDal(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	public void weekDay() {
		int year = 0, month = 0; // 2021/11
		System.out.println("Year:");
		year = scanner.nextInt();
		System.out.println("Month:");
		month = scanner.nextInt();
		int total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		int[] lastDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (yunDal(year)) {
			lastDay[1]++;
		}
		for (int i = 0; i < month - 1; i++) {
			total += lastDay[i];
		}
		total++;
		int week = total % 7;
		String[] strWeek = { " 일", " 월", " 화", " 수", " 목", " 금", " 토" };
		System.out.println(year + "년" + " " + month + "월");
		for (int i = 0; i < strWeek.length; i++) {
			System.out.print(strWeek[i] + "\t");
		}
		System.out.println();

		for (int i = 1; i <= lastDay[month - 1]; i++) {
			if (i == 1) {
				for (int j = 0; j < week; j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t", i);
			week++;
			if (week > 6) {
				week = 0;
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		arrEx13 a = new arrEx13();
		a.weekDay();
	}
}
