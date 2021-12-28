package sist.com.movie;

// 데이터 제어 클래스 => 메소드
//
import java.util.*;
import java.io.*;

public class MovieSystem {
	// 공유할 데이터 선언
	private static MovieVO[] movie_data = new MovieVO[1938];
	// 클래스 배열 , String[] => 객체 배열
	// static 으로 모두가 공유 할 수 있도록 선언
	static {
		// static 초기화 블록
		try {
			FileReader fr = new FileReader("C:\\SY\\자료\\movie.txt");
			// 파일 읽기
			// 속도를 좀더 빠르게 하기 위해 스트링버퍼 사용
			StringBuffer sb = new StringBuffer();

			int i = 0;
			while ((i = fr.read()) != -1) { // -1 EOF => End of file
				sb.append(String.valueOf((char) i));
			}
			// System.out.println(sb.toString());
			String movie = sb.toString();
			// 한줄 씩 저장 하기 위해 \n 으로 나누기
			String[] m = movie.split("\n");
			for (int j = 0; j < m.length; j++) {

				String[] rm = m[j].split("\\|");
				// split 에서 ^ $ + * | . 사용 시 '\\' 붙여줘야 사용가능
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

	// 메소드
	// 1. 찾기(제목, 출연, 장르)
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
		System.out.println("영화 제목 입력 : ");
		String title = sc.next();
		ms.titleFind(title);
		System.out.println("배우 이름 : ");
		String actor = sc.next();
		ms.actorFind(actor);
		System.out.println("장르 : ");
		String genre = sc.next();
		ms.genreFind(genre);
	}
}