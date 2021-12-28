package sist.com.obj;

public class StudentScore {

	private int kor;
	private int eng;
	private int math;
	private double avg;
	private int rank;

	public StudentScore() {
		super();
	}

	public StudentScore(int kor, int eng, int math, int avg, int rank) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.avg = avg;
		this.rank = rank;
	}

	public double getAvg() {
		return avg;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	
	public void avgPro() {
		this.avg = (kor + eng + math) / 3.;
	}

	
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

}
