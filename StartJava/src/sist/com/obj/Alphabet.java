package sist.com.obj;

public class Alphabet {
	public static void main(String[] args) {
		A a = new A(10);
		System.out.println("�ʱⰪ = " + a.getA());
		A a2 = new A(50);
		a.setA(1000);
		System.out.println("set�� �� = " + a.getA());
		System.out.println(a2.getA());

		System.out.println();

		B b = new B(22, new A(10));

		System.out.println(b.getA());
		// b.getA() ��� a�� �ּҷ� �̵�

		System.out.println(b.getA().getA());
		// ���� b.getA() �� �Ͽ��� a�� ���� ���

		C c = new C(10, new B(20, new A(30)));
		// new�� �ϸ鼭 c �ʱⰪ���� 10�� �־��ְ�, B�� ���� ����

		System.out.println("c ��� : " + c.getC());
		// CŬ���� �ȿ� c�� ���� ���
		System.out.println("C �ȿ� B �ȿ� b ��� : " + c.getB().getB());
		// CŬ���� �ȿ� B �ȿ� b�� ���� ���
		System.out.println("CŬ���� �ȿ� B �ȿ� A�� �ּ� : " + c.getB().getA());
		// CŬ���� �ȿ� B �ȿ� A�� �ּ�
		System.out.println("CŬ���� �ȿ� B �ȿ� A �ȿ� a ���� ��� : " + c.getB().getA().getA());
		// CŬ���� �ȿ� B �ȿ� A �ȿ� a ���� ���
		System.out.println();

		c.setC(9876);
		System.out.println(c.getC());
		c.setB(new B(456465)); // C Ŭ���� �ȿ��� B�� ���� �ϴ� ��� Ȯ���ʿ�
		System.out.println(c.getB().getB());

		c.getB().setB(1234);
		System.out.println(c.getB().getB());

		b.setA(new A(10000));
		System.out.println(b.getB());
	}

}
