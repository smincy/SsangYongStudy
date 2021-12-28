package sist.com.contr;

public class Control6 {

	public void gugu() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {

				System.out.print(i + "*" + j + "=" + i * j);
				System.out.print("  ");
			}
			System.out.println();
		}
	}

	public void gugu2() {
		int i = 0, j = 0;
		while (i++ < 9) {
			while (j++ < 9) {
				System.out.print(i + "*" + j + "=" + i * j);
				System.out.print("  ");
			}
			System.out.println();
			j = 1;
		}
	}

	public static void main(String[] args) {
		Control6 c = new Control6();

		// c.gugu();
		c.gugu2();

	}
}
