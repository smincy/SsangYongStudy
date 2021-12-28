package sist.com.server;

// ==> Server ���α׷��� '����� ��û' �� �޾Ƽ� => ó�� => ������� '����'  ���ִ°� �������α׷�
// ==> '���ӽ� ó��' �ϴ� ���α׷� / '����ڸ��� ��� (Thread)' �ϴ� ���α׷�

import java.util.*; // StringTokenizer, ���� (����� ����) ArrayList  �̿�

import sist.com.common.Function;

import java.net.*; // ��Ʈ��ũ ���� 
import java.io.*; // �б� (readLine)/ ���� (write) 

// ���ӽ� ó�� => ������ Runnable => ������ �ȵ� �޼ҵ� (run())

public class Server implements Runnable {
	// ���� ���� : ServerSocket
	// ������ ���� ���� => ArrayList
	// ���� => �����ϴ� ���μ� ==> ��Ʈ��ȣ => ���� = 3355

	private ServerSocket ss;
	private ArrayList<Client> waitVc = new ArrayList<Client>(); // ���ǿ� �ִ� ����

	// 1. ���� ���� => �ѹ��� ��� => �ѹ��� �����ϴ� �޼ҵ� (������)
	public Server() {
		try {
			ss = new ServerSocket(3355); // ���� ���� �Ϸ�
			// bind() : ���� , listen() : ������
			System.out.println("Server Start...");
		} catch (Exception ex) {
		}
	}

	// ���ӽÿ� ó���ϴ� �޼ҵ� (������)
	public void run() {
		while (true) // ������ �����ϱ� ������ ������ �޴´�
		{
			try {
				// Server:Socket=>Client����
				Socket s = ss.accept(); // ���ӽÿ� ȣ��Ǵ� �޼ҵ� => ������ Ŭ���̾�Ʈ�� ���� ����
				// Ŭ���̾�Ʈ ���� (Ŭ���̾�Ʈ : IP , PORT)
				// Socket ==> �����忡 �����ϸ� => ������� �ѻ���� ����� �����ϰ� �����
				// Client:Socket=>Server����
				Client client = new Client(s);
				client.start();
			} catch (Exception ex) {
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		new Thread(server).start();
	}

	/////////////////// ���ӽ� ó�� ==> ������(��ȯ)
	// ������ ������ ������ �Ŀ�(���� �ڵ�) ==> Thread�� ������ �ִ� ����(�Ʒ�)
	// ��� => �α��� ó�� , ä�� ó�� , ������ ó��
	class Client extends Thread {
		// ������ Ȯ��
		private String id;
		private String sex;
		private String name;
		/// ������ �⺻ ���� ====> �α��νÿ� Ŭ���̾�Ʈ�� ����
		/// ��Ʈ��ũ ����
		private OutputStream out; // => ��û�ÿ� ó�� ������� �����ִ� ����
		private BufferedReader in;// => Ŭ���̾�Ʈ ��û
		private Socket s; // ��ŵ���

		public Client(Socket s) {
			// �����ڿ� ����
			try {
				// ��ȭ�� �޴´�
				this.s = s;
				// �۽�
				out = s.getOutputStream();
				// ����
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				/*
				 * char => 1byte(�̱۹���Ʈ) => ASC(�ƽ�Ű) 0~256 (C/C++) char => 2byte(��Ƽ����Ʈ) =>
				 * Unicode 0~65535(Java,C#) *** ASC VS Unicode
				 */
			} catch (Exception ex) {
			}
		}

		// ��� ���� => ������ 1�� ==> Ŭ���̾�Ʈ�� �������̱� ������
		// �����ڸ��� => ����� ���� �� �� �ְ� �����
		public void run() {
			try {
				while (true) {
					// 1. �������� ��û�� �޴´�
					String msg = in.readLine();

					// 100|hong|ȫ�浿|����\n

					System.out.println("Client=>" + msg);

					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					
					// 1. ����ڰ� ������ ���� �ް�,
					// 2. �̹� �ִ� ����ڿ��� �Ѹ���, 
					// 3. �����ϰ�, 
					// 4. ����Ǿ��ִ� ��ü�� �űԻ���ڿ��� �Ѹ���
					
					// ������
					switch (protocol) { 		// ����ڰ� �ѱ� ����������
					case Function.LOGIN: { 		// 100 ���̸� �α���ó��
						// �α��� ��û�ϸ� ���۹��� �����͸� ����
						id = st.nextToken();
						name = st.nextToken();
						sex = st.nextToken();

						// ������ ������ ����鿡�� ������ ����
						messageAll(Function.LOGIN + "|" + id + "|" + name + "|" + sex);
						messageAll(Function.CHAT + "|[�˸� ��] " + name + "���� �����ϼ̽��ϴ�");

						// �α����� ����� ArrayList�� �߰�
						waitVc.add(this);

						// ȭ�� ����
						messageTo(Function.MYLOG + "|" + name);

						// ������ ������ ������ �α��� �ϴ� ������� ����
						for (Client c : waitVc) {
							messageTo(Function.LOGIN + "|" + c.id + "|" + c.name + "|" + c.sex);
						}
					}
						break;

					case Function.CHAT: { 		// 200 ���̸� ä��ó��
						messageAll(Function.CHAT + "|[" + name + "]" + st.nextToken());
					}
						break;
						
					case Function.EXIT: { 		// 300 ���̸� ����ó��

					}
						break;
					}
				}
			} catch (Exception ex) {
			}
		}

		// ������ 2����
		// => ������ ��ü�� �޼��� ���� (������)
		// ����ȭ ���� synchronized
		/*
		 * | | ====> | ====> | ====> �񵿱�ȭ |
		 * 
		 * | | ======> | =======> | ========> |
		 */
		public synchronized void messageAll(String msg) // ����ȭ
		{
			for (int i = 0; i < waitVc.size(); i++) // waitVc�� ������ ��� �����
			{
				try {
					Client c = waitVc.get(i);
					c.messageTo(msg);
				} catch (Exception ex) {
					waitVc.remove(i);// �޼����� ���� �ʴ� ������� ����
				}
			}

		}

		// => ������ ������� �޼��� ���� (�Ѹ�)
		public void messageTo(String msg) // �񵿱�ȭ
		{
			try {
				out.write((msg + "\n").getBytes());// byte[]�� ����(���ڵ�)
				// decoding => InputStreamReader => ���ͽ�Ʈ��
			} catch (Exception ex) {
			}
		}
	}

}
