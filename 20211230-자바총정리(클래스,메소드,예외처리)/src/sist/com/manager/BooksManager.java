package sist.com.manager;
import java.net.*;
import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import sist.com.dao.Books;
import sist.com.dao.BooksDAO;
public class BooksManager {
    // ����Ŭ�� ���� => BooksDAO
	private BooksDAO dao=new BooksDAO(); // �����͸� ����Ŭ�� �߰� 
	// try~catch (���ܺ���), throws(����ȸ��=>����)
	// ������ �����߻��� �����ϴ� ���α׷� => ������ ����ִ� ���� �ƴϰ� 
	// ������ �κ��� �����ؼ� => ������������ �̵� 
	// ������ �κ��� Ȯ�� => getMessage(),printStackTrace()
	public void booksGetData()
	{
		try
		{
			// ���� �б� => ���� 
			StringBuffer sb=new StringBuffer();
			FileInputStream fis=
					new FileInputStream("c:\\javaDev\\books.txt");
			BufferedReader br=
					new BufferedReader(new InputStreamReader(fis,"UTF-8"));
			// ���� ��ü�� �о => �ӽ����� 
			// UTF-8  ==> EUC-KR 
			while(true)
			{
				String data=br.readLine();
				if(data==null) break;
				sb.append(data);
			}
			
			//System.out.println(sb.toString());// �޸𸮿� ����� �����͸� ���
			// <> => �ױ׺� ������ ����  
			// <div id="a"> => div:eq(0)
			// <div class="b"> => div:eq(1)
			// <div> => HTML
			// Jsoup => HTML Parser => �ʿ��� �����͸� ã���ִ� ���� 
			Document doc=Jsoup.parse(sb.toString());
			/*
			 *   connect() => ���� URL�� �̿��ؼ� �������� ���� 
			 *   parse() => HTML���ڿ� , ����
			 */
			/*
			 *  <div class="col-md-11 book-list-detail">
					<a class="book-url" href="https://wikibook.co.kr/tf">
					<h4 class="main-title">��Ȱ�ڵ� �ӽŷ��� with ���̽� �ټ��÷�(�ǽ���)</h4>
					</a>
					
			    <div class="col-md-1 book-list-image">
				<a href="https://wikibook.co.kr/tf/">
				<img src="https://wikibook.co.kr/images/cover/s/9791158392994.jpg">
                 
                 <div class="sub-title">���� ���� �ȷο��ϰ� �Ͱ� �����</div>
                 <div class="book-info">
				<span class="author">������ <small>����</small></span> |
				22,000�� |
				<span class="pub-date">2022�� 01�� 12�� | </span>
				<span class="isbn"><small>ISBN: </small>9791158392956</span>
				<span class="tag" style="display:none">�귣��,�ν�Ÿ�׷�,�ν�Ÿ�׷� �귣��,instagram,branding</span>
				</div>
				<span id="tags">
				<i class="fas fa-tags"></i>
				<a href="https://wikibook.co.kr/tag/%eb%b8%8c%eb%9e%9c%eb%94%a9/"><span class="label label-default">�귣��</span></a>
				<a href="https://wikibook.co.kr/tag/%ec%9d%b8%ec%8a%a4%ed%83%80%ea%b7%b8%eb%9e%a8/"><span class="label label-default">�ν�Ÿ�׷�</span></a>
				<a href="https://wikibook.co.kr/tag/%ec%9d%b8%ec%8a%a4%ed%83%80%ea%b7%b8%eb%9e%a8-%eb%b8%8c%eb%9e%9c%eb%94%a9/"><span class="label label-default">�ν�Ÿ�׷� �귣��</span></a>
				<a href="https://wikibook.co.kr/tag/instagram/"><span class="label label-default">instagram</span></a>
				<a href="https://wikibook.co.kr/tag/branding/"><span class="label label-default">branding</span></a>
				</span>
				</div>
			 */
			Elements title=doc.select("h4.main-title");
			Elements poster=doc.select("div.book-list-image img");
			Elements content=doc.select("div.sub-title");
			Elements author=doc.select("div.book-info span.author");
			Elements price=doc.select("div.book-info");
			Elements regdate=doc.select("div.book-info span.pub-date");
			Elements isbn=doc.select("div.book-info span.isbn");
			Elements tags=doc.select("div.book-info span.tag");
			/*
			 *    <div>��</div> ==> text() 
			 *    <img src="��"> ==> attr("src")
			 */
			for(int i=0;i<title.size();i++)
			{
				String title_data=title.get(i).text();
				String poster_data=poster.get(i).attr("src");
				String author_data=author.get(i).text();
				String regdate_data=regdate.get(i).text()
						           .replace("|", "");
				String isbn_data=isbn.get(i).text();
				String tags_data=tags.get(i).text();
				
				String cd="";
				try
				{
				   String content_data=content.get(i).text();
				   cd=content_data;
				}catch(Exception ex){}
				
				String price_data=price.get(i).text();
				String p="";
				StringTokenizer st=new StringTokenizer(price_data,"|");
				int count=st.countTokens();
				if(count==4)
				{
					String[] ss=price_data.split("\\|");
					p=ss[1];
				}
				else
				{
					String[] ss=price_data.split("\\|");
					p=ss[2];
				}
				
				System.out.println("��ȣ:"+(i+1));
				System.out.println("����:"+title_data);
				System.out.println("�׸�:"+poster_data);
				System.out.println("�Ұ�:"+cd);
				System.out.println("����:"+p);
				System.out.println("�����:"+regdate_data);
				System.out.println("isbn:"+isbn_data);
				System.out.println("�±�:"+tags_data);
				
				// ����Ŭ�� ������ ÷�� 
				Books book=new Books();
				book.setNo(i+1);
				book.setTitle(title_data);
				book.setPoster(poster_data);
				book.setContent(cd);
				book.setPrice(p);
				book.setRegdate(regdate_data);
				book.setIsbn(isbn_data);
				book.setTags(tags_data);
				
				dao.dbInsert(book);
				
				// ���� �ӵ� != ����Ŭ ���� 
				Thread.sleep(300);
			}
			System.out.println("*******����Ŭ ���� �Ϸ�!!*******");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		BooksManager bm=new BooksManager();
		bm.booksGetData();
	}
}

