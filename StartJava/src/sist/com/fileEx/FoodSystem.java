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

	// 1. 실행 => 파일(오라클)에 저장
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

			File file = new File("C:\\SY\\자료\\java_data\\category.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			// 파일에 카테고리 저장하기
			FileWriter fw = new FileWriter(file);
			fw.write(sb.toString());
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 2. 사용자가 요청 => 파일(오라클) 읽어서 => ArrayList에 저장 후 전송

}
