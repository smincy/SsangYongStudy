package sist.com.obj4;

public class SuperNode {

	public void saySuper() {
		// new 할 때 마다 만들어지는 인스턴스메소드
		System.out.println("saySuper1");
		System.out.println("saySuper2");
		System.out.println("saySuper3");
		System.out.println("saySuper4");
	}

	public final void saySuperNotOver() {
		// final 을 붙여 줄 경우 오버라이드 불가능

		System.out.println("saySuper1");
		System.out.println("saySuper2");
	}

	public static void superMethod() {
		// static 메소드
		System.out.println("superMethod");
	}

}
