package sist.com.main;

import java.util.*;

public class MainClass2 {

	public static void main(String[] args) {
		FoodDAO dao = new FoodDAO();

		List<Category> list = dao.categoryListData();

		for (Category c : list) {
			System.out.println(c.getCno() + " " + c.getTitle() + " " + c.getLink());
		}
	}

}
