package sist.com.obj4;

public class NoteBook {
	// ��ü : �ɹ�����
	// �ν��Ͻ�����
	private int screenSize;
	private String cpu;
	private String ram;
	// ��������
	static String nation;
	// ���ܺ���
	private final int COUNT = 100;

	static {
		System.out.println("staticBlock");
		// ������ ���� ���� ���� �Ǵ°� static ����
	}

	public NoteBook() {
		// ������
		System.out.println("NoteBook()");
		// new �Ͽ� ������ ȣ�� �ÿ� ����
	}

	public static void main(String[] args) {
		System.out.println("MainMethod");
		NoteBook nb = new NoteBook();
	}
}
