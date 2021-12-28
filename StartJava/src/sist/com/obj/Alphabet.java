package sist.com.obj;

public class Alphabet {
	public static void main(String[] args) {
		A a = new A(10);
		System.out.println("초기값 = " + a.getA());
		A a2 = new A(50);
		a.setA(1000);
		System.out.println("set후 값 = " + a.getA());
		System.out.println(a2.getA());

		System.out.println();

		B b = new B(22, new A(10));

		System.out.println(b.getA());
		// b.getA() 경우 a의 주소로 이동

		System.out.println(b.getA().getA());
		// 다음 b.getA() 를 하여서 a의 값을 출력

		C c = new C(10, new B(20, new A(30)));
		// new를 하면서 c 초기값으로 10을 넣어주고, B를 같이 생성

		System.out.println("c 출력 : " + c.getC());
		// C클래스 안에 c의 값을 출력
		System.out.println("C 안에 B 안에 b 출력 : " + c.getB().getB());
		// C클래스 안에 B 안에 b의 값을 출력
		System.out.println("C클래스 안에 B 안에 A의 주소 : " + c.getB().getA());
		// C클래스 안에 B 안에 A의 주소
		System.out.println("C클래스 안에 B 안에 A 안에 a 값을 출력 : " + c.getB().getA().getA());
		// C클래스 안에 B 안에 A 안에 a 값을 출력
		System.out.println();

		c.setC(9876);
		System.out.println(c.getC());
		c.setB(new B(456465)); // C 클래스 안에서 B를 수정 하는 방법 확인필요
		System.out.println(c.getB().getB());

		c.getB().setB(1234);
		System.out.println(c.getB().getB());

		b.setA(new A(10000));
		System.out.println(b.getB());
	}

}
