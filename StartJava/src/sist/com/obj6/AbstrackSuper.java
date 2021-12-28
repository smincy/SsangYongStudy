package sist.com.obj6;

// 추상클래스
public abstract class AbstrackSuper {
	// 추상클래스는 객체를 생성할 수 없다
	// 확장을 목적으로 만들어지는 클래스 = 추상클래스
	// 생성자는 있음

	private int abstractSuper;

	public AbstrackSuper() {

	}

	public AbstrackSuper(int superValue) {
		// 확장을 목적으로 만들어진 클래스 이므로 후손에서 타고 들어올 경우를 위해 생성자 있음
		super();
		this.abstractSuper = superValue;
	}

	public abstract void abstrackSuperMethod();
	// 추상클래스에는 final 이 들어갈 수 없다

	public void superinstanceMethod() {
		// 일반 메소드 >> 오버라이드 금지
	}

	@Override
	public String toString() {
		return "AbstrackSuper [abstractSuper=" + abstractSuper + "]";
	}

}
