package sist.com.obj3;

public class Sub1 extends Parent {	// parent를 상속
	private int sub1Value;

	public Sub1() { // 기본 생성자
		// super(); 생성자가 생략되어 있기 때문에 Parent가 먼저 출력
		System.out.println("Sub1 생성자");
	}
	
	public Sub1(int parentValue, int sub1Value) { // 인자가 있는 생성자
		super(parentValue);
		this.sub1Value = sub1Value;
		System.out.println("Sub1 생성자");
		System.out.println(sub1Value);
	}
}
