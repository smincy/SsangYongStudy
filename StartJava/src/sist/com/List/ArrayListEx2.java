package sist.com.List;

import java.util.*;

class Student {
	private int hakbun;
	private String name;
	private int kor, eng, math;

	public int getHakbun() {
		return hakbun;
	}

	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public Student(int hakbun, String name, int kor, int eng, int math) {
		super();
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}

public class ArrayListEx2 {

	public static void main(String[] args) {

		ArrayList list = new ArrayList();
		list.add(new Student(1, "홍길동", 89, 90, 87));
		list.add(new Student(2, "박문수", 59, 60, 67));
		list.add(new Student(3, "소서노", 69, 50, 27));
		list.add(new Student(4, "이순신", 39, 40, 82));

		for (int i = 0; i < list.size(); i++) {
			Student std = (Student) list.get(i);
			System.out.printf("%-3d%-6s%-5d%-5d%-5d%-5d%-7.2f\n", std.getHakbun(), std.getName(), std.getKor(),
					std.getEng(), std.getMath(), (std.getKor() + std.getEng() + std.getMath()),
					(std.getKor() + std.getEng() + std.getMath()) / 3.0);
		}
		
		// ArrayList는 원하는 만큼 추가 가능
		
		
	}
}
