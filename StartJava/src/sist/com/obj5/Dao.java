package sist.com.obj5;

// �߻�Ŭ����
public abstract class Dao { // �̿ϼ��� ���赵
	public void connectProcess() {
		System.out.println("Data Access Connect!");
	}

	public abstract void select(); // �̿ϼ��� ���

	public abstract void update();

	public abstract void delete();

	public abstract void info();

}
