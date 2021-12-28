package sist.com.fileEx;

// 21.12.23

// 사용자가 사용 가능하게 만들어 줄 Main 클래스
import java.util.*;
public class NewsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NewsSystem ns = new NewsSystem();
		
		Scanner sc =  new Scanner(System.in);
		
		System.out.println("검색어 입력 : ");
		String fd = sc.next();
		ns.newsGetData(fd);
		
		ArrayList<News> list = ns.newsAllData();
		System.out.println("===== 검색 결과 =====");
		for (News n : list) {
			System.out.println(n.getTitle());
			System.out.println(n.getDescription());
			System.out.println(n.getAuthor());
			System.out.println("\n");
		}
		
		
		
		
	}

}
