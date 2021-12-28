package sist.com.contr;
// 조건문 , 반복문

public class Control2 {

	public void conEx1() {
		// elseif 문은 위 조건문이 참일 경우 하위식은 확인 안함

	}

	public void conEx2(int a, int b) {
		switch (a) {
		case 1:
			System.out.println("1");
			switch (b) {
			case 10:
				System.out.println("10");
				break; // 해당 break 는 포함된 switch 문만 탈출
						// 다음 switch 는 break 가 없기 때문에 수행
			case 20:
				System.out.println("20");
			}
		case 2:
			System.out.println("2");

		}

	}

	public void conEx3(int a, int b) {
		switch (a) {
		case 1:
			System.out.println("1");
			switch (b) {
			case 10:
				System.out.println("10");
				return; // 리턴의 경우 전체 메소드 탈출
			case 20:
				System.out.println("20");
			}
		case 2:
			System.out.println("2");

		}

	}

	public static void main(String[] args) {

		Control2 c = new Control2();

		c.conEx2(1, 10);
		System.out.println();
		c.conEx3(1, 10);

	}

}
