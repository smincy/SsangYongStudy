package sist.com.fileEx;

// 21.12.23
import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class FoodSystem {
	public static void main(String[] args) {
		FoodSystem f = new FoodSystem();
	}

	// 1. ���� => ����(����Ŭ)�� ����
	public FoodSystem() {
		try {

			Document doc = Jsoup.connect("https://www.mangoplate.com/\r\n" + "").get();

			Elements title = doc.select("div.top_list_slide span.title");
			Elements subject = doc.select("div.top_list_slide p.desc");

			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < title.size(); i++) {

				String data = (i + 1) + "|" + title.get(i).text() + "|" + subject.get(i).text() + "\n";

				sb.append(data);
			}

			File file = new File("C:\\SY\\�ڷ�\\java_data\\category.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			// ���Ͽ� ī�װ� �����ϱ�
			FileWriter fw = new FileWriter(file);
			fw.write(sb.toString());
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 2. ����ڰ� ��û => ����(����Ŭ) �о => ArrayList�� ���� �� ����

}
