package com.sist.di2;

public class Sawon {
	private String name;

	public Sawon(String name) {
		this.name = name;
		System.out.println("�����ڸ� ���� ���� �Է�..");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void init() {
		System.out.println("Sawon ��ü ���� �Ϸ�");
	}

	public void destroy() {
		System.out.println("Sawon ��ü �޸� ����");
	}

}
