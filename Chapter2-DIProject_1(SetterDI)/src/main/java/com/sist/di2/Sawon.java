package com.sist.di2;

public class Sawon {
	private String name;

	public Sawon(String name) {
		this.name = name;
		System.out.println("생성자를 통해 값을 입력..");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void init() {
		System.out.println("Sawon 객체 생성 완료");
	}

	public void destroy() {
		System.out.println("Sawon 객체 메모리 해제");
	}

}
