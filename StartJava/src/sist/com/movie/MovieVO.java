package sist.com.movie;

// movie.txt 파일 참조
// 데이터만 관리
// 사용자 정의 데이터형
// 데이터형 클래스 => 캡슐화 방식 (데이터를 보호) => 접근은 메소드
public class MovieVO {

	private int no;
	private String title;
	private String genre; // 장르

	private String poster;
	private String actor;
	private String regdate;
	private String grade;
	private String director;

	// 캡슐화 되어 있는 데이터를 메소드로 접근 하기 위해 gett/sett 생성
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

}
