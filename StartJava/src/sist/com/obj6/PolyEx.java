package sist.com.obj6;

public class PolyEx {
	
	public void classCastAction(Object obj) {
		if (obj instanceof StringAction) {
			((StringAction)obj).stringAction();
		}
		if (obj instanceof NumberAction) {
			((NumberAction)obj).numberAction();
		}
	}
	
	public static void main(String[] args) {
		PolyEx e = new PolyEx();
		
		e.classCastAction(new NumberAction());
	}
}
