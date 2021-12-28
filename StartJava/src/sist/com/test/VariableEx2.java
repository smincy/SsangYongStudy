package sist.com.test;

public class VariableEx2 {

	public void byteValue() { // << void는 메소드의 결과형

		System.out.println(Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
	}

	public void intValue() { // << void는 메소드의 결과형

		System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		VariableEx1 vv = new VariableEx1();
		VariableEx2 v = new VariableEx2();
		
		// VariableEx1()의 메소드를 사용하기 위해서 주소를 할당, 사용하려는 클래스 주소 할당
		// main 밖에, Class 안에 있는 메소드를 사용하기 위해서

		vv.메소드이름1();

		v.byteValue();
		v.intValue();

	}

}
