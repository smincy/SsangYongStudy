package sist.com.oper;

// �޸� (����), ������(����)
// �޼ҵ�(����,������,���)
// �ֿ켱������ : (), [], .

public class Oper1 {

	public int firstOper1(int a, int b, int c) {
		return a + b * c;
	}

	public int firstOper2(int a, int b, int c) {
		return a > b ? (a + b * c) : b < c ? ((a - b) * c) : ((a + b) * c);
	}
	// �޼ҵ� �̸��� �Ȱ���, (��������)Ÿ���� �ٸ� ��츦 "�����ε�"
	public int firstOper2(int a, int b) {
		return 0;
	}

	public boolean firstOper3(int a, int b, int c) {
		return a > b ? a == b : a < c;
	}

	public int firstOper4(int a, int b, int c) {
		return a > b && b < c ? a + b * c : (a + b) * c;
		// && : and = a>b, b<c �Ѵ� �����ؾ� True
	}

	public int firstOper5(int a, int b, int c) {
		return a > b || b < c ? a + b * c : (a + b) * c;
		// && : or = a>b, b<c �� �߿� �ϳ��� �����ص� True
	}

	public static void main(String[] args) {

		Oper1 o = new Oper1(); // Heap (����)


		int rs = o.firstOper1(5, 6, 7);
		int rs2 = o.firstOper2(5, 6, 7);
		boolean rs3 = o.firstOper3(5, 6, 7);

		System.out.printf("firstOper1 Result = %d\n", rs);
		System.out.printf("firstOper2 Result = %d\n", rs2);
		System.out.printf("firstOper3 Result = %s\n", rs3); // boolean ����� %s

	}

}
