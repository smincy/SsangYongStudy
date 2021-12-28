package sist.com.obj2;
//이름, 나이, 오늘생일, 성별, 지역, 띠, 전화번호

public class Man {
	private String Name;
	private int Age;
	private boolean brith;
	private String zender;
	private String location;
	private String ddi;
	private String tel;
	
	public Man() {
		super();
	}

	public Man(String name, int age, boolean brith, String zender, String location, String ddi, String tel) {
		super();
		Name = name;
		Age = age;
		this.brith = brith;
		this.zender = zender;
		this.location = location;
		this.ddi = ddi;
		this.tel = tel;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public boolean isBrith() {
		return brith;
	}

	public void setBrith(boolean brith) {
		this.brith = brith;
	}

	public String getZender() {
		return zender;
	}

	public void setZender(String zender) {
		this.zender = zender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Man [Name=" + Name + ", Age=" + Age + ", brith=" + brith + ", zender=" + zender + ", location="
				+ location + ", ddi=" + ddi + ", tel=" + tel + "]";
	}

}
