package sist.com.obj2;

// overload (�޼ҵ��̸��� ���ƾ� ��. ���� ���� �Ǵ� Ÿ���� �޶�� ��)
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
		// �����迭 Ÿ�� �޼ҵ尡 �־ �⺻ int���� �켱������ ����
		
	}
}