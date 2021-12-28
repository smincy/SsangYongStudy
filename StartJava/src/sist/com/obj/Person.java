package sist.com.obj;

// �ɹ�����, static, private, 
public class Person {
	// �ν��Ͻ�(��ü) ������ ���ο��� 'new' �Ͽ� ������ ��� stack �� ����
	// static ������ static������ ��������� ���� (main�� ����Ǹ�) 
	private String name;
	private int age;
	private double height;

	// overloading (�����ε�)
	public void set(String name) {
		this.name = name; // this�� �ٿ� ������ �ɹ������ּҷ� ����
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
		Person p1 = new Person(); // name|age|height p1 �� ����
		Person p2 = new Person(); // name|age|height p2 �� ����

		p1.set("����", 30, 175);
		p1.disP();

	}

}
