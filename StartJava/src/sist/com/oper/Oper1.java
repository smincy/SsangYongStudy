package sist.com.oper;

// 메모리 (공간), 연산자(도구)
// 메소드(변수,연산자,제어문)
// 최우선연산자 : (), [], .

public class Oper1 {

	public int firstOper1(int a, int b, int c) {
		return a + b * c;
	}

	public int firstOper2(int a, int b, int c) {
		return a > b ? (a + b * c) : b < c ? ((a - b) * c) : ((a + b) * c);
	}
	// 메소드 이름은 똑같고, (전달인자)타입이 다를 경우를 "오버로드"
	public int firstOper2(int a, int b) {
		return 0;
	}

	public boolean firstOper3(int a, int b, int c) {
		return a > b ? a == b : a < c;
	}

	public int firstOper4(int a, int b, int c) {
		return a > b && b < c ? a + b * c : (a + b) * c;
		// && : and = a>b, b<c 둘다 만족해야 True
	}

	public int firstOper5(int a, int b, int c) {
		return a > b || b < c ? a + b * c : (a + b) * c;
		// && : or = a>b, b<c 둘 중에 하나만 만족해도 True
	}

	public static void main(String[] args) {

		Oper1 o = new Oper1(); // Heap (동적)


		int rs = o.firstOper1(5, 6, 7);
		int rs2 = o.firstOper2(5, 6, 7);
		boolean rs3 = o.firstOper3(5, 6, 7);

		System.out.printf("firstOper1 Result = %d\n", rs);
		System.out.printf("firstOper2 Result = %d\n", rs2);
		System.out.printf("firstOper3 Result = %s\n", rs3); // boolean 출력은 %s

	}

}
