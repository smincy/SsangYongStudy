package sist.com.contr;
// ���ǹ� , �ݺ���

public class Control2 {

	public void conEx1() {
		// elseif ���� �� ���ǹ��� ���� ��� �������� Ȯ�� ����

	}

	public void conEx2(int a, int b) {
		switch (a) {
		case 1:
			System.out.println("1");
			switch (b) {
			case 10:
				System.out.println("10");
				break; // �ش� break �� ���Ե� switch ���� Ż��
						// ���� switch �� break �� ���� ������ ����
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
				return; // ������ ��� ��ü �޼ҵ� Ż��
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
