package sist.com.test;

public class VariableEx4 {

	public int action;	
	// �������� (Heap ������ ����, main���� new �� ����Ͽ� �ҷ��� ���)
	
	public void vM1() {
		int i = 10; // ��������
		System.out.println(i);
	}

	public void vM2(double value) {	// �Ű����� double value (Paramter)
		// ��������, auto����
	}

	public static void main(String[] args) {

		// ���̳��ͷε� �׶��׶� �ʿ��� Ŭ������ �޸��Ҵ�
		VariableEx4 v = new VariableEx4();
		v.action  = 500;   // ���������� static �������� ����Ǿ� ���� ������ 
						   // �Ҵ纯��? �� �̿��Ͽ� �������
		v.vM1();
		v.vM2(10.5);	// 10.5  < ��������(Arguments)

	}

}
