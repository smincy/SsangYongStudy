package sist.com.obj;

// 맴버변수, static, private, 
public class Person {
	// 인스턴스(객체) 변수는 메인에서 'new' 하여 생성할 경우 stack 에 생성
	// static 변수는 static영역에 만들어지는 변수 (main이 실행되면) 
	private String name;
	private int age;
	private double height;

	// overloading (오버로딩)
	public void set(String name) {
		this.name = name; // this를 붙여 줌으로 맴버변수주소로 연결
	}

	public void set(String name, int age) {
		set(name);
		this.age = age;
	}

	public void set(String name, int age, double height) {
		set(name, age);
		this.height = height;
	}

	public void disP() {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("height " + " " + height);
	}

	public static void main(String[] args) {
		Person p1 = new Person(); // name|age|height p1 로 생성
		Person p2 = new Person(); // name|age|height p2 로 생성

		p1.set("성민", 30, 175);
		p1.disP();

	}

}
