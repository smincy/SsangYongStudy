package sist.com.fileEx;

// 21.12.23

// ����ڰ� ��� �����ϰ� ����� �� Main Ŭ����
import java.util.*;
public class NewsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NewsSystem ns = new NewsSystem();
		
		Scanner sc =  new Scanner(System.in);
		
		System.out.println("�˻��� �Է� : ");
		String fd = sc.next();
		ns.newsGetData(fd);
		
		ArrayList<News> list = ns.newsAllData();
		System.out.println("===== �˻� ��� =====");
		for (News n : list) {
			System.out.println(n.getTitle());
			System.out.println(n.getDescription());
			System.out.println(n.getAuthor());
			System.out.println("\n");
		}
		
		
		
		
	}

}
