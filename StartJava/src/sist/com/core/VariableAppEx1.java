package sist.com.core;

public class VariableAppEx1 {

	public void byteMethod1() {
		byte byteValue1 = Byte.MAX_VALUE;
		System.out.println(byteValue1);
	}

	public float byteMethod2() {
		byte byteValue1 = 100;
		byte byteValue2 = 100;
		System.out.println(byteValue1);
		return byteValue1 + byteValue2;
	}

	public void byteMethod3(int v1) {
		int v2 = Integer.MAX_VALUE;
		long rs = v1 + (long)v2; // int형으로 연산 후 rs로 들어가기 때문에 형변환 필요
		System.out.println(rs);
	}

	public void bM1(int value) {
		String a = Integer.toBinaryString(value);	//	2진수화한걸 문자열로 입력
		String b = Integer.toOctalString(value);	//	8진수화한걸 문자열로 입력
		String c = Integer.toHexString(value);		//	16진수화한걸 문자열로 입력
		
		System.out.println(a + " " + b + " " + c);
		
		System.out.println("2진수" + " " + ":" + Integer.valueOf(a,2));
		System.out.println("8진수" + " " + ":" + Integer.valueOf(b,8));
		System.out.println("16진수" + " " + ":" + Integer.valueOf(c,16));
	}
	
	public static void main(String[] args) {

		VariableAppEx1 v = new VariableAppEx1();

		//v.byteMethod3(1);
		//System.out.println(Integer.toBinaryString(24));  // 2진수로 출력
		//System.out.println(v.byteMethod2());
		v.bM1(15);
	
		
	}

}
