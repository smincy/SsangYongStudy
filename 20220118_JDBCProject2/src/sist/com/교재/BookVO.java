package sist.com.교재;

/*
   	BOOKID    	NOT NULL NUMBER(2)
 	BOOKNAME    VARCHAR2(40)
 	PUBLISHER   VARCHAR2(40)
 	PRICE    	NUMBER(8)
 */
public class BookVO {

	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	private String strPrice;

	public String getStrPrice() {
		return strPrice;
	}

	public void setStrPrice(String strPrice) {
		this.strPrice = strPrice;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
