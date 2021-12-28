package BaekJoon;

public class test_Àç±Í {

	public static void mt(int n) {

		if (n == 0) {
			System.out.println("End");
		} else {
			mt(n - 1);
			System.out.printf("2 * %d = %d", n, 2 * n);
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mt(10);

	}

}
