package sist.com.contr;

import java.util.Scanner;

public class Control8 {
	Scanner sc = new Scanner(System.in);

	String name = null;
	int age = 0;
	String tmp = null;

	public void con1() {
		while (true) {
			do {
				System.out.println("Nmae : ");
				name = sc.next();
			} while (!(name.length() > 1 && name.length() <= 6));
			do {
				System.out.println("Age : ");
				age = sc.nextInt();
			} while (!(age >= 20 && age <= 100));
			do {
				System.out.println("계속하시겠습니까?  yes / no");
				tmp = sc.next();
			} while (!(tmp.equals("yes") || tmp.equals("no")));
			if (tmp.equals("yes")) {
				name = null;
				age = 0;
				tmp = null;
			}else if (tmp.equals("no")) {
				break;
			}
		
		}

		System.out.println(name + " " + age);
		
	}

	public static void main(String[] args) {

		Control8 c = new Control8();

		c.con1();

	}

}
