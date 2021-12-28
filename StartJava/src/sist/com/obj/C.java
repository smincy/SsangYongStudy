package sist.com.obj;

public class C {
	private int c;
	private B b; // B를 쓰기 위해 b를 생성

	public C() {
		// 기본 생성자
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
