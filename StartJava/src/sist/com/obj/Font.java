package sist.com.obj;

// �ɹ�����, Final, static
public class Font {

	private String fontFace; // instance ����
	private int size;
	private String color;
	static String nation; // new ���� �ʾƵ� �޸𸮿� ��������� ����(static)
	private static final int weight = 20; // �Ǵ� Ŭ��������

	public void Face(String fontFace) {
		this.fontFace = fontFace;
	}

	public void dis() {
		System.out.println("fontFace = " + fontFace);
	}

}
