package sist.com.test;

public class VariableEx1 {

	// ���� : DATA�� ��� ���� (�޸�)
	// DATA : �⺻�� | ������

	// ���� �� final �ٿ��� ��� ����� ����
	// ��κ��� �������� �빮�ڷ� ǥ��

	public void �޼ҵ��̸�1( /* �������� */ ) {
		// ����� ���� �޼ҵ�
		�޼ҵ��̸�2();
		System.out.println("methodAction1");
	}

	public void �޼ҵ��̸�2( /* �������� */ ) {
		// ����� ���� �޼ҵ�
		int temp = �޼ҵ��̸�3() + 300;
		System.out.println(temp); // �޼ҵ��̸�3 �޼ҵ��� ��ȯ���� ���
	}

	public int �޼ҵ��̸�3( /* �������� */ ) {
		// ����� ���� �޼ҵ�
		System.out.println("methodAction3");
		return 100;
		// �޼ҵ��̸� ���� ��ȯ�� = return Ÿ��

	}

	public static void main(String[] args) throws Exception {

		// �ٸ� �޼ҵ���� ȣ�� �ϱ����ؼ� �װ͵��� ����ִ� Ŭ������ �ּҸ� ���� �Ҵ�
		// �޼ҵ带 ȣ���ϸ� �ش�޼ҵ� ���� �� ȣ���� ������ return
		// ���� ���� �� �޼ҵ� ������ ��������

		VariableEx1 v = new VariableEx1();

		v.�޼ҵ��̸�1();

	}

}
