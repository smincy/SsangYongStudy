package sist.com.obj3;

public class Parent {
	private int parentValue;

	public Parent() { // �⺻ ������
		System.out.println("Parent �⺻ ������");
	}

	public Parent(int parentValue) { // ���ڰ� �ִ� ������
		this.parentValue = parentValue;
		System.out.println("Parent ������");
		System.out.println(parentValue);
	}
}
