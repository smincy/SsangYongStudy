package sist.com.obj5;

// 추상클래스
public abstract class Dao { // 미완성된 설계도
	public void connectProcess() {
		System.out.println("Data Access Connect!");
	}

	public abstract void select(); // 미완성된 기능

	public abstract void update();

	public abstract void delete();

	public abstract void info();

}
