package sist.com.obj6;

public class AbstractMain extends AbstractSub {

	@Override
	public void abstractSubMethod() {
		// TODO Auto-generated method stub

	}

	@Override
	public void abstrackSuperMethod() {
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) {
		AbstrackSuper am = new AbstractMain();

		System.out.println(am.toString());
		am.toString();
	}
}
