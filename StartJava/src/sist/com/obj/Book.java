package sist.com.obj;

public class Book {
	String bookName; // �ν��Ͻ� ���� , ���ο��� 'new' �� �ؾ� ����� �� �ִ� ����
	String author;
	String publisher;
	int price;
	String isbn;
	static int value; 	// static ������ new �ص� ���Ӱ� �������� �ʰ� ���� ���� ���

	public static void main(String[] args) {

		new Book().bookName = "Java�� ����";
		Book b = new Book(); // b�� stack , new ���Ĵ� ���ο� �ν��Ͻ� ���� (Heap)
		System.out.println(b.bookName);
		b.bookName = "Java�� ����..";
		System.out.println(b.bookName);
		Book a = new Book();
		a.bookName = "�ڹ��� ��������";
		System.out.println(b.bookName);
		b.bookName = "�ѱ��ڹ�";
		System.out.println(b.bookName);
		System.out.println(a.bookName);
	}
}
