package sist.com.core;

public class VariableAppEx2 {

	public char vEx2() {
		return 97;
	}
	
	public int vEx3() {
		return 'A';
	}
	
	public void vEx4() {
		char c = 99;	// �ƽ�Ű�� �Է�
		System.out.println(c);
		int j = 'B';	// B�� �ش��ϴ� �ƽ�Ű�ڵ� �Է�
		System.out.println(j);
		
		String A = "120";
		int i = Integer.parseInt(A);
		System.out.println(i+5);
		
	}
	
	public double vEx5(int a) {
		int b = 5;
		double tmp = (double)(a + b) / 3;
		
		return tmp;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VariableAppEx2 v = new VariableAppEx2();
		//v.vEx4();
		System.out.println(v.vEx5(5));
	}

}
