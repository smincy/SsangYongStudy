package sist.com.test;

public class VariableEx4 {

	public int action;	
	// 전역변수 (Heap 영역에 생성, main에서 new 를 사용하여 불렀을 경우)
	
	public void vM1() {
		int i = 10; // 지역변수
		System.out.println(i);
	}

	public void vM2(double value) {	// 매개변수 double value (Paramter)
		// 지역변수, auto변수
	}

	public static void main(String[] args) {

		// 다이나믹로딩 그때그때 필요한 클래스를 메모리할당
		VariableEx4 v = new VariableEx4();
		v.action  = 500;   // 전역변수가 static 영역으로 선언되어 있지 않으면 
						   // 할당변수? 를 이용하여 변수사용
		v.vM1();
		v.vM2(10.5);	// 10.5  < 전달인자(Arguments)

	}

}
