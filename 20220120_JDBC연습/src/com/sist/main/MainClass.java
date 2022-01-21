package com.sist.main;

import java.util.*;
import com.sist.dao.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("페이지 입력 : ");
		
		int page = sc.nextInt();
		
		BooksDAO dao = new BooksDAO();
		List<BooksVO> list = dao.booksListData(page);
		for (BooksVO vo : list) {
			System.out.println(vo.getNo() + "."
				+ vo.getTitle() + "(" + vo.getPrice() + ")");
		}

	}

}
