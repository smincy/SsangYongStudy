package sist.com.obj4;

public class CardMain {
	public static void main(String[] args) {

		//Card card = new Card();	
		// 객체 생성, Card클래스 내 기본생성자가 private라서 에러
		
		Card.getInstance().setName("성민");
		System.out.println(Card.getInstance().getName());
		
	}
}
