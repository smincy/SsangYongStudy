package com.sist.di1;

public class Sawon {
	private String name;
	private String dept;
	private String loc;

	// �����ڸ� �̿��� ������� �� ����
	public Sawon(String name, String dept, String loc) {
		this.name = name;
		this.dept = dept;
		this.loc = loc;
	}
	
	public void display() {
		System.out.println(name);
		System.out.println(dept);
		System.out.println(loc);
	}
}
