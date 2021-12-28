package sist.com.contr;
// ¹Ýº¹¹®

public class Control3 {

	public void cntEx1() {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {

		Control3 c = new Control3();

		c.cntEx1();

	}

}
