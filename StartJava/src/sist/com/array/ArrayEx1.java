package sist.com.array;
// �迭(����)   / �ϰ�ó�� ����

public class ArrayEx1 {

	public void arrEx1() {
		(new int[5])[0] = 10;
		System.out.println((new int[5])[0]);
	}
	
	public static void main(String[] args) {

		ArrayEx1 a = new ArrayEx1();
		
		a.arrEx1();
		
	}

}
