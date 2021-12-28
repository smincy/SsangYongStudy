package sist.com.test;

public class VariableEx3 {
	
	public void localValueEx1() {
		int a = 5;
		a += 1;
		System.out.println(a);
	}
	
	int x = 5;
	
	public void localValueEx2() {
		x = x + 5;
		//a += 1;
		System.out.println("x" + " " + x);
		
	}
	
	public void localValueEx3() {
		
		System.out.print((char)65);
		System.out.print((char)66);
		System.out.print((char)67);
	}
	
	public char actionChar(int x) {
		x = x+2;
		return (char)x;
	}
	
	public char actionChar2(int x) {
		return (char)x;
	}
	
	public boolean actionBoolean(int x) {
		return x>5;
	}
	
	public static void main(String[] args) {
	
		VariableEx3 v = new VariableEx3();
	//사용자정의자료형  변수		주소
	
		//v.localValueEx3();
		System.out.println(v.actionChar(95));
		System.out.println((int)v.actionChar2('a'));
		
		if (v.actionBoolean((int)v.actionChar2('a'))) {
			System.out.println("yes");
		}else {
			System.out.println("NO");
		}
		System.out.println(v.actionBoolean(3));
		
	}

	
}
