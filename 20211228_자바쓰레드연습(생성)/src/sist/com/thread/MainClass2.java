package sist.com.thread;

//�������� ���ÿ� ���� 
class MyThread2 extends Thread {
	// ������ ����
	public void run() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.println(getName() + "=>" + c);
			try {
				// �Ͻ� ����
				Thread.sleep(100); // ��� ���� (1/1000)
				// 0.1 �����
				// �Ѿ� �߻�
			} catch (Exception ex) {
			}
		}
	}
}

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3���� �����尡 ���� => �ú��� (�ð��� ������ �ѹ��� ����)
		MyThread2 m1 = new MyThread2();
		MyThread2 m2 = new MyThread2();
		MyThread2 m3 = new MyThread2();

		// ���� �����Ѵ� (�۾�������)
		m1.start();// Thread-0
		m2.start();// Thread-1
		m3.start();// Thread-2
	}

}