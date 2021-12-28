package sist.com.obj;

// alt + shift + s) + r  : getter/setter
// alt + shift + s) + o  : Construc»ö
// alt + shift + s) + s  : toString (Ãâ·Â)
public class Student {

	private String name;
	private int age;
	private String stdID;
	private String schoolName;
	private StudentScore score;

	public Student() {
		super();
	}

	public Student(StudentScore score) {
		super();
		this.score = score;
	}

	public Student(String name, int age, String stdID, String schoolName) {
		super();
		this.name = name;
		this.age = age;
		this.stdID = stdID;
		this.schoolName = schoolName;
	}

	public Student(String name, int age, String stdID, String schoolName, StudentScore score) {
		super();
		this.name = name;
		this.age = age;
		this.stdID = stdID;
		this.schoolName = schoolName;
		this.score = score;
	}

	public StudentScore getScore() {
		return score;
	}

	public void setScore(StudentScore score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStdID() {
		return stdID;
	}

	public void setStdID(String stdID) {
		this.stdID = stdID;
	}

	public String getSchoolName() {
		return schoolName;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", stdID=" + stdID + ", schoolName=" + schoolName + "]";
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public void setName(String name) {
		this.name = name;
	}

}
