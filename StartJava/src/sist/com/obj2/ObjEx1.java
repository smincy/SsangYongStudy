package sist.com.obj2;

//	OOP(��ü����) ��ü�� ����ó���ϴ°� ��ǥ
//	class, object(instance), classArray, overloading, constructor, this, this(),
//	Object(�繰 ����ü,this,instance), static, final,

public class ObjEx1 {
	// �ڷ��� ������; > �ڷ���(�⺻, ����), class����, heap����

	// �⺻ instance �޼ҵ�� static�޼ҵ�� ��� ������ �ٸ� / ���Ӽ��� �ٸ���

	private int data; // instance���� / heap����
	private static int classVariable; // class����

	public void instanceMethod() {
		System.out.println("instanceMethod");
		int local = 10; // �������� / �ҷ����� stack����
		data = 500;
	}

	public static void staticMethod() { // static �޼ҵ� : new(��ü����) ���� �ʾƵ� ���������(ȣ�Ⱑ��)�޼ҵ�
		// �޼ҵ尡 �ҷ����� stack�� �÷����� ��
		System.out.println("staticMethod");
		// �ٸ� Ŭ�������� [Ŭ������.�޼ҵ�()] �� ȣ�� ����
		// �� : ' ObjEx2.staticMethod() '

	//	data = 99;
		// data�� new(��ü����)�� �ؾ� �޸𸮰� �����Ǵ� ����
		// ���� new ���� ���� ��� �޸𸮰� �������� �ʱ� ������ ����
	//	this.data = 99;
		// static ���������� this ��� �� �� ����
	}

	public static void main(String[] args) {
		staticMethod();
	}
}
