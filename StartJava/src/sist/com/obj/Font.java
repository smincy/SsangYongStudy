package sist.com.obj;

// 맴버변수, Final, static
public class Font {

	private String fontFace; // instance 변수
	private int size;
	private String color;
	static String nation; // new 하지 않아도 메모리에 만들어지는 변수(static)
	private static final int weight = 20; // 또는 클래스변수

	public void Face(String fontFace) {
		this.fontFace = fontFace;
	}

	public void dis() {
		System.out.println("fontFace = " + fontFace);
	}

}
