package sist.com.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainClass {

	public static void main(String[] args) {
		try {
			// �����ͺ��̽� ����
			FoodDAO dao = new FoodDAO();

			// ������Ʈ ����
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

				// �����͸� ������ ���� ����Ŭ�� ÷��
				dao.categoryInsert(c);
				// �ڹٿ��� ����Ŭ ����� insert, update, delete ���� �� AutoCommit(), ���� ������ ���� ��� �ɰ��� �� ����
			}
			System.out.println("����Ŭ�� ���� �Ϸ�");
		} catch (Exception e) {

		}

	}

}
