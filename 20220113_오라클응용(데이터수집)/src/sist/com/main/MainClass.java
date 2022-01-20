package sist.com.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainClass {

	public static void main(String[] args) {
		try {
			// 데이터베이스 연결 
			FoodDAO dao = new FoodDAO();
			// Jsoup => Html Parser
        	// 웹 사이트에 연결 
			Document doc = Jsoup.connect("https://www.mangoplate.com/").get();

			Elements title = doc.select("div.info_inner_wrap span.title");
			Elements subject = doc.select("div.info_inner_wrap p.desc");
			Elements poster = doc.select("ul.list-toplist-slider img.center-croping");
			Elements link = doc.select("ul.list-toplist-slider a");

			for (int i = 0; i < title.size(); i++) {
				Category c = new Category();
				c.setTitle(title.get(i).text());
				c.setSubfect(subject.get(i).text());
				c.setPoster(poster.get(i).attr("data-lazy").replace("&", "^"));
				c.setLink("https://www.mangoplate.com" + link.get(i).attr("href"));

				// 데이터를 읽을때 마다 오라클에 첨부
				dao.categoryInsert(c);
				// 자바에서 오라클 연결시 insert, update, delete 수행 시 AutoCommit(), 따라서 문제가 생길 경우 심각할 수 있음
			}
			System.out.println("����Ŭ�� ���� �Ϸ�");
		} catch (Exception e) {

		}

	}

}
