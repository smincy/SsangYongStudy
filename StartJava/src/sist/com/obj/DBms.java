package sist.com.obj;

//Constructor(생성자)
//목적:instance변수 초기화 
public class DBms {
	private String url;
	private String account;
	private String password;
	private int connectMax;
	private boolean isStart;

	public DBms() {
		this("");
		System.out.println("Dbms()");
	}

	public DBms(String url) {
		this(url, "");
		System.out.println("Dbms(String url)");

	}

	public DBms(String url, String account) {
		this(url, account, "");
		System.out.println("Dbms(String url,String account)");
	}

	public DBms(String url, String account, String password) {
		this(url, account, password, 0);
		System.out.println("Dbms(String url,String account,String password)");

	}

	public DBms(String url, String account, String password, int connectMax) {
		this(url, account, password, connectMax, false);
		 System.out.println("Dbms(String url,String account,String password,int connectMax)");

	}

	public DBms(String url, String account, String password, int connectMax, boolean isStart) {
		this.url = url;
		this.account = account;
		this.password = password;
		this.connectMax = connectMax;
		this.isStart = isStart;
		System.out.println("Dbms(String url,String account,String password,int connectMax,boolean isStart)");
	}

	public DBms(DBms db) {
		this.url = db.url;
		this.account = db.account;
		this.password = db.password;
		this.connectMax = db.connectMax;
		this.isStart = db.isStart;
	}

	public void disp(DBms this) {
		System.out.println("url:" + this.url + " account:" + this.account + " password:" + password + "  connectMax:"
				+ connectMax + " isStart:" + isStart);
	}

	public static void main(String[] args) {
		DBms d = new DBms();
		System.out.println(d.url);
		System.out.println(d.account);
		System.out.println(d.password);
		System.out.println(d.connectMax);
		System.out.println(d.isStart);
	}
}
