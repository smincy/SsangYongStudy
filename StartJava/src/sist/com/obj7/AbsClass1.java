package sist.com.obj7;

// 인터페이스 (완전추상)클래스 1
// 구현이 있을 수 없다



public interface AbsClass1 {
	// 명시적 선언만 가능 , (static블럭도 사용 불가)
	final int data = 100; // (내부적으로 static 이 숨겨져 있어서, 기본instance 변수가 아님)

	// 추상 메소드 (일반 메소드는 들어올 수 없다.)
	// 따라서 abstract 를 생략해도 추상메소드로 자동인식
	public abstract void interMethod1();

	public void interMethod2();
}
