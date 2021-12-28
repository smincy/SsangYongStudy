package sist.com.contr;

public class Control5 {

	public void looping1() {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public void looping2() {
		int i = 0; // 루프문 밖에 초기화 해놓았기 때문에 while문 끝나면 인덱스는 그대로 (초기화x)
		while (i < 5) {
			System.out.println("A");
			i++;
		}
	}

	public void looping3() {
		int i = 0;
		do {
			System.out.print("B" + " ");
			// i++;
		} while (i++ < 5);
	}

	public void looping4() {
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			if (i == 5)
				break;
			cnt++;
		}
		System.out.println(cnt);
	}

	public void looping5() {
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				continue;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {

		Control5 c = new Control5();
//		c.looping1();
//		c.looping2();
//		c.looping3();
		c.looping4();
		c.looping5();

	}

}
