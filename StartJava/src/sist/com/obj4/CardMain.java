package sist.com.obj4;

public class CardMain {
	public static void main(String[] args) {

		//Card card = new Card();	
		// ��ü ����, CardŬ���� �� �⺻�����ڰ� private�� ����
		
		Card.getInstance().setName("����");
		System.out.println(Card.getInstance().getName());
		
	}
}
