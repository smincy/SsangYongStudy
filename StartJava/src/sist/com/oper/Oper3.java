package sist.com.oper;

public class Oper3 {

	public void calcOper(int x) {

		if (x != 0 && x % 3 == 0) {
			System.out.println("3의 배수 ");
		} else if (x != 0 && x % 5 == 0) {
			System.out.println("5의 배수 ");
		} else if (x != 0 && x % 7 == 0) {
			System.out.println("7의 배수 ");
		} else
			System.out.println("기타 배수... ");
	}

	public static void main(String[] args) {

		Oper3 o = new Oper3();

		o.calcOper(25);

	}

}
