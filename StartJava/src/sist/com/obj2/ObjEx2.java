package sist.com.obj2;

// overload (메소드이름이 같아야 함. 인자 개수 또는 타입이 달라야 함)
public class ObjEx2 {
	public void add() {
		System.out.println("add()");
	}

	public void add(byte value) {
		System.out.println("public void add(byte value)");
	}

	public void add(short value) {
		System.out.println("public void add(short value)");
	}

	public void add(int value) {
		System.out.println("public void add(int value)");
	}

	public void add(String s, int value) {
		System.out.println("add(String s,int value)");
	}

	public void add(int value, String s) {
		System.out.println("add(int value,String s)");
	}
	/*
	 * public void add(int ...a) { System.out.println("add(int ...a)"); } public
	 * void add(int []a) { System.out.println("add(int ...a)"); }
	 */

	/*
	 * public int add(int value) { System.out.println("public void add(int value)");
	 * return 0; }
	 */

	public static void main(String[] args) {
		ObjEx2 o = new ObjEx2();
		// o.add(10);//byType
		// 가변배열 타입 메소드가 있어도 기본 int형이 우선순위가 높다
		
	}
}