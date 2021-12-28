package sist.com.oper;

public class Oper2 {

	public int unaryOper(int x) {
		return x;
	}

	public int unaryOper2(int x) {
		return !(x > 10) ? -x : +x;
	}

	public int unaryOper3(int x) {
		return (x != 10) ? x + 3 : 10;
	}

	public static void main(String[] args) {

		Oper2 o = new Oper2();

		System.out.println("unaryOper " + o.unaryOper(10));
		System.out.println("unaryOper2 " + o.unaryOper2(8));
		System.out.println("unaryOper3 " + o.unaryOper3(3));

	}

}
