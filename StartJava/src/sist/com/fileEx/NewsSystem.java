package sist.com.fileEx;

// 21.12.23 pm
// ����ڰ� ��û�� ����� ���� ó���ϴ� ����� Ŭ���� (�׼� Ŭ����)
import java.util.*;

import javax.swing.text.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;

public class NewsSystem {
	public static void main(String[] args) {
		NewsSystem ns = new NewsSystem();
		ns.newsGetData("�౸");

	}

	// 1. ������ �о�ͼ� => ����
	public void newsGetData(String fd) {
		try {
			// 1. ����Ʈ�� ����
			String strUrl = "http://newssearch.naver.com/search.naver?where=rss" + "&query="
					+ URLEncoder.encode(fd, "UTF-8");

			// 2. �����͸� �о News�� ������ ����
			Document doc = Jsoup.connect(strUrl).get();

			Elements title = doc.select("rss channel item title");
			Elements desc = doc.select("rss channel item description");
			Elements author = doc.select("rss channel item author");

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < title.size(); i++) {
				String msg = title.get(i).text() + "|" + desc.get(i).text() + "|" + author.get(i).text() + "\n";
				sb.append(msg);
			}

			FileWriter fw = new FileWriter("C:\\SY\\�ڷ�\\java_data\\naver_news.txt");
			fw.write(sb.toString());
			fw.close();

		} catch (Exception e) {

		}
	}
	// 2. ������ ����ڿ��� ������

	public ArrayList<News> newsAllData() {

		ArrayList<News> list = new ArrayList<News>();

		try {

			FileInputStream fis = new FileInputStream("C:\\SY\\�ڷ�\\java_data\\naver_news.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			while (true) {

				String data = br.readLine();
				if (data == null) {
					break;
				}
				StringTokenizer st = new StringTokenizer(data, "|");
				News nn = new News();
				nn.setTitle(st.nextToken());
				nn.setDescription(st.nextToken());
				nn.setAuthor(st.nextToken());

				list.add(nn);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
