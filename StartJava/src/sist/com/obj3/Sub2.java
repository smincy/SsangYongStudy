package sist.com.obj3;

public class Sub2 extends Parent {
	// Parent(부모) 클래스에 기본생성자가 없을 경우 에러날 수 있음
	public Sub2() { // sub2 기본생성자는 생략되어 있고,
		super(); 	// 그 안에 super() 생성자가 생략되어 있는데
					// 기본 생성자 이기때문에 부모클래스에 기본생성자가 있어야 함
	}
}
