package sist.com.test;

public class VariableEx1 {

	// 변수 : DATA를 담는 공간 (메모리)
	// DATA : 기본형 | 참조형

	// 변수 앞 final 붙여줄 경우 상수로 선언
	// 대부분의 상수명들은 대문자로 표기

	public void 메소드이름1( /* 전달인자 */ ) {
		// 사용자 정의 메소드
		메소드이름2();
		System.out.println("methodAction1");
	}

	public void 메소드이름2( /* 전달인자 */ ) {
		// 사용자 정의 메소드
		int temp = 메소드이름3() + 300;
		System.out.println(temp); // 메소드이름3 메소드의 반환값을 출력
	}

	public int 메소드이름3( /* 전달인자 */ ) {
		// 사용자 정의 메소드
		System.out.println("methodAction3");
		return 100;
		// 메소드이름 왼쪽 반환형 = return 타입

	}

	public static void main(String[] args) throws Exception {

		// 다른 메소드들을 호출 하기위해서 그것들이 들어있는 클래스의 주소를 먼저 할당
		// 메소드를 호출하면 해당메소드 실행 후 호출한 곳으로 return
		// 메인 실행 후 메소드 구조는 스텍형식

		VariableEx1 v = new VariableEx1();

		v.메소드이름1();

	}

}
