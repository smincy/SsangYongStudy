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

// �������̵� : ������ �޼ҵ带 �ļ��� Ȯ���Ͽ� ����ϴ� �� (�̸�,���� �״�� �Ȱ��� ����°�)
