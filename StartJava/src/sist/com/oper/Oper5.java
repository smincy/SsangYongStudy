package sist.com.oper;

public class Oper5 {

	public boolean yunDal(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		// 4�⸶�� ���� + 100�⸶�� ���� �ƴ� ��� ����
	}

	public void logicOper1(int year) {
		System.out.println(yunDal(year) ? "����" : "������");
	}

	public static void main(String[] args) {
		Oper5 o = new Oper5();
		
		o.logicOper1(2020);
	}

}
