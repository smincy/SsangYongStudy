package sist.com.test;

public class VariableEx2 {

	public void byteValue() { // << void�� �޼ҵ��� �����

		System.out.println(Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
	}

	public void intValue() { // << void�� �޼ҵ��� �����

		System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		VariableEx1 vv = new VariableEx1();
		VariableEx2 v = new VariableEx2();
		
		// VariableEx1()�� �޼ҵ带 ����ϱ� ���ؼ� �ּҸ� �Ҵ�, ����Ϸ��� Ŭ���� �ּ� �Ҵ�
		// main �ۿ�, Class �ȿ� �ִ� �޼ҵ带 ����ϱ� ���ؼ�

		vv.�޼ҵ��̸�1();

		v.byteValue();
		v.intValue();

	}

}
