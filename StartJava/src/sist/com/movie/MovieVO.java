package sist.com.movie;

// movie.txt ���� ����
// �����͸� ����
// ����� ���� ��������
// �������� Ŭ���� => ĸ��ȭ ��� (�����͸� ��ȣ) => ������ �޼ҵ�
public class MovieVO {

	private int no;
	private String title;
	private String genre; // �帣

	private String poster;
	private String actor;
	private String regdate;
	private String grade;
	private String director;

	// ĸ��ȭ �Ǿ� �ִ� �����͸� �޼ҵ�� ���� �ϱ� ���� gett/sett ����
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
