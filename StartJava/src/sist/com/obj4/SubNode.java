package sist.com.obj4;

public class SubNode extends SuperNode {
	
	public void saySuper() {
		// 오버라이딩, SuperNode에 있는 메소드
		// 선조에도 있고 후손에도 있으면 후손메소드 출력
		System.out.println("SubNode saySuper");
	}
	
	// static 메소드는 오버라이드 할 수 없음
	// 같은 이름의 메소드를 쓸 수는 있지만 그것을 오버라이드로 보지는 않는다.
	
	// static 은 추상메소드가 있을 수 없다.
	
	
}
