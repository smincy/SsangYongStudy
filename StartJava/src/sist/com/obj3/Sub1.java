package sist.com.obj3;

public class Sub1 extends Parent {	// parent�� ���
	private int sub1Value;

	public Sub1() { // �⺻ ������
		// super(); �����ڰ� �����Ǿ� �ֱ� ������ Parent�� ���� ���
		System.out.println("Sub1 ������");
	}
	
	public Sub1(int parentValue, int sub1Value) { // ���ڰ� �ִ� ������
		super(parentValue);
		this.sub1Value = sub1Value;
		System.out.println("Sub1 ������");
		System.out.println(sub1Value);
	}
}
