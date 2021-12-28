package sist.com.obj4;

public class NoteBook {
	// 전체 : 맴버변수
	// 인스턴스변수
	private int screenSize;
	private String cpu;
	private String ram;
	// 정적변수
	static String nation;
	// 종단변수
	private final int COUNT = 100;

	static {
		System.out.println("staticBlock");
		// 생성자 보다 먼저 실행 되는게 static 영역
	}

	public NoteBook() {
		// 생성자
		System.out.println("NoteBook()");
		// new 하여 생성자 호출 시에 실행
	}

	public static void main(String[] args) {
		System.out.println("MainMethod");
		NoteBook nb = new NoteBook();
	}
}
