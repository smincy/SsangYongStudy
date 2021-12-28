package sist.com.obj4;

public class Card {
	private String name;
	private static Card card = null;

	public static Card getInstance() {
		if (card == null) {
			card = new Card();
		}
		return card;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// �⺻�����ڰ� private �̶� main���� new �� �� ����
	private Card() {
		super();
	}

}
