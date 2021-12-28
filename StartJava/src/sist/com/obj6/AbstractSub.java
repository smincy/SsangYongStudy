package sist.com.obj6;

public abstract class AbstractSub extends AbstrackSuper {
	private int abstractSub;

	public AbstractSub() {
		super();
	}
	
	public AbstractSub(int superValue, int subValue) {
		super(superValue);
	}

	public abstract void abstractSubMethod();

	@Override
	public String toString() {
		return "AbstractSub [abstractSub=" + abstractSub + "]";
	}

	
	
}
