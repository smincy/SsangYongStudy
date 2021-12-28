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

	// 기본생성자가 private 이라서 main에서 new 할 수 없음
	private Card() {
		super();
	}

}
