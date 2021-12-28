package sist.com.obj;

public class Book {
	String bookName; // 인스턴스 변수 , 메인에서 'new' 를 해야 사용할 수 있는 변수
	String author;
	String publisher;
	int price;
	String isbn;
	static int value; 	// static 변수는 new 해도 새롭게 생성되지 않고 기존 변수 사용

	public static void main(String[] args) {

		new Book().bookName = "Java의 정석";
		Book b = new Book(); // b는 stack , new 이후는 새로운 인스턴스 생성 (Heap)
		System.out.println(b.bookName);
		b.bookName = "Java의 정석..";
		System.out.println(b.bookName);
		Book a = new Book();
		a.bookName = "자바의 정석정석";
		System.out.println(b.bookName);
		b.bookName = "한글자바";
		System.out.println(b.bookName);
		System.out.println(a.bookName);
	}
}
