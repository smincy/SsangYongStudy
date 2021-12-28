package sist.com.obj3;

public class ParentMain {
	public static void main(String[] args) {

		//new Sub1(); // Sub1만 호출 했지만 상속클래스도 같이 호출되어 짐
		
		new Sub1(10, 20);	// Sub1클래스에 인자가 있는 생성자를 만들어줘 함
		
		new Sub2();
	}
}
