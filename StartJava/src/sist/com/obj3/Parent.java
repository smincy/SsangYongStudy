package sist.com.obj3;

public class Parent {
	private int parentValue;

	public Parent() { // 기본 생성자
		System.out.println("Parent 기본 생성자");
	}

	public Parent(int parentValue) { // 인자가 있는 생성자
		this.parentValue = parentValue;
		System.out.println("Parent 생성자");
		System.out.println(parentValue);
	}
}
