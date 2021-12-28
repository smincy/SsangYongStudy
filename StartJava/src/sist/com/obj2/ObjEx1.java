package sist.com.obj2;

//	OOP(객체지향) 객체를 집단처리하는게 목표
//	class, object(instance), classArray, overloading, constructor, this, this(),
//	Object(사물 그자체,this,instance), static, final,

public class ObjEx1 {
	// 자료형 변수명; > 자료형(기본, 참조), class영역, heap영역

	// 기본 instance 메소드와 static메소드는 사는 영역이 다름 / 쓰임세가 다르다

	private int data; // instance변수 / heap영역
	private static int classVariable; // class영역

	public void instanceMethod() {
		System.out.println("instanceMethod");
		int local = 10; // 지역변수 / 불려지면 stack영역
		data = 500;
	}

	public static void staticMethod() { // static 메소드 : new(객체생성) 하지 않아도 만들어지는(호출가능)메소드
		// 메소드가 불려지면 stack에 올려지긴 함
		System.out.println("staticMethod");
		// 다른 클래스에서 [클래스명.메소드()] 로 호출 가능
		// 예 : ' ObjEx2.staticMethod() '

	//	data = 99;
		// data는 new(객체생성)를 해야 메모리가 생성되는 변수
		// 따라서 new 하지 않을 경우 메모리가 생성되지 않기 때문에 에러
	//	this.data = 99;
		// static 영역에서는 this 사용 할 수 없음
	}

	public static void main(String[] args) {
		staticMethod();
	}
}
