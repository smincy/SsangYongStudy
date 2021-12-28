package sist.com.obj;

public class C {
	private int c;
	private B b; // B�� ���� ���� b�� ����

	public C() {
		// �⺻ ������
	}

	public C(int c) {
		this.c = c;
	}

	public C(int c, B b) {
		this.c = c;
		this.b = b;
	}

	public C(B b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public B getB() {
		return this.b;
	}

	public void setB(B b) {
		this.b = b;
	}
}
