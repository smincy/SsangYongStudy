package sist.com.obj4;

public class Me extends Fath {
	public Me() {

	}

	public void game() {
		
		System.out.println("game");
	}
	
	public static void main(String[] args) {
		Me m = new Me();
		m.sleep();
		m.work();
		m.game();
		Object o = new GranFa();
		((GranFa)o).sleep();
		
	}
}

// 오버라이드 : 선조의 메소드를 후손이 확장하여 사용하는 것 (이름,인자 그대로 똑같이 만드는것)
