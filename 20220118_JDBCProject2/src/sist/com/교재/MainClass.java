package sist.com.교재;

// ���� 289page
import java.util.*;

public class MainClass {

	static BookDAO dao = new BookDAO();

	public static void main(String[] args) {
		/*
		 * List<BookVO> list = dao.bookListData(); for (BookVO vo : list) {
		 * System.out.println(vo.getBookid() + " " + vo.getBookname() + " " +
		 * vo.getPublisher() + " " + vo.getPrice()); }
		 */
		bookPrint();
	}

	public static void bookPrint() {
		List<BookVO> list = dao.bookListData();
		for (BookVO vo : list) {
			System.out.println(vo.getBookid() + " " + vo.getBookname() + " " + vo.getPublisher() + " " + vo.getStrPrice() + "��");
		}
	}

}
