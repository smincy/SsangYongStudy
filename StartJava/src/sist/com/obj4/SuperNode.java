package sist.com.obj4;

public class SuperNode {

	public void saySuper() {
		// new �� �� ���� ��������� �ν��Ͻ��޼ҵ�
		System.out.println("saySuper1");
		System.out.println("saySuper2");
		System.out.println("saySuper3");
		System.out.println("saySuper4");
	}

	public final void saySuperNotOver() {
		// final �� �ٿ� �� ��� �������̵� �Ұ���

		System.out.println("saySuper1");
		System.out.println("saySuper2");
	}

	public static void superMethod() {
		// static �޼ҵ�
		System.out.println("superMethod");
	}

}
