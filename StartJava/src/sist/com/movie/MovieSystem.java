package sist.com.movie;

// ������ ���� Ŭ���� => �޼ҵ�
//
import java.util.*;
import java.io.*;

public class MovieSystem {
	// ������ ������ ����
	private static MovieVO[] movie_data = new MovieVO[1938];
	// Ŭ���� �迭 , String[] => ��ü �迭
	// static ���� ��ΰ� ���� �� �� �ֵ��� ����
	static {
		// static �ʱ�ȭ ���
		try {
			FileReader fr = new FileReader("C:\\SY\\�ڷ�\\movie.txt");
			// ���� �б�
			// �ӵ��� ���� ������ �ϱ� ���� ��Ʈ������ ���
			StringBuffer sb = new StringBuffer();

			int i = 0;
			while ((i = fr.read()) != -1) { // -1 EOF => End of file
				sb.append(String.valueOf((char) i));
			}
			// System.out.println(sb.toString());
			String movie = sb.toString();
			// ���� �� ���� �ϱ� ���� \n ���� ������
			String[] m = movie.split("\n");
			for (int j = 0; j < m.length; j++) {

				String[] rm = m[j].split("\\|");
				// split ���� ^ $ + * | . ��� �� '\\' �ٿ���� ��밡��
				MovieVO vo = new MovieVO();
				vo.setNo(Integer.parseInt(rm[0]));
				vo.setTitle(rm[1]);
				vo.setGenre(rm[2]);
				vo.setPoster(rm[3]);
				vo.setActor(rm[4]);
				vo.setRegdate(rm[5]);
				vo.setGrade(rm[6]);
				vo.setDirector(rm[7]);
				movie_data[j] = vo;

			}

		} catch (Exception ex) {
		}
	}

	// �޼ҵ�
	// 1. ã��(����, �⿬, �帣)
	public void titleFind(String title) {
		for (MovieVO vo : movie_data) {
			if (vo.getTitle().contains(title)) {
				System.out.println(vo.getTitle());
			}
		}
	}

	public void actorFind(String name) {
		for (MovieVO vo : movie_data) {
			if (vo.getActor().contains(name)) {
				System.out.println(vo.getActor());
			}
		}
	}

	public void genreFind(String genre) {
		for (MovieVO vo : movie_data) {
			if (vo.getGenre().contains(genre)) {
				System.out.println(vo.getGenre());
			}
		}
	}

	public static void main(String[] args) {
		MovieSystem ms = new MovieSystem();
//		for (MovieVO vo : MovieSystem.movie_data) {
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getGenre());
//			System.out.println("===========");
//		}
		Scanner sc = new Scanner(System.in);
		System.out.println("��ȭ ���� �Է� : ");
		String title = sc.next();
		ms.titleFind(title);
		System.out.println("��� �̸� : ");
		String actor = sc.next();
		ms.actorFind(actor);
		System.out.println("�帣 : ");
		String genre = sc.next();
		ms.genreFind(genre);
	}
}