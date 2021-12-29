package sist.com.server;

/*
 * 	1. ��������				> ServerSocket
 * 	2. ������ ���� ����			> ArrayList
 * 	3. ���� ���� ����			> ArrayList	> ObjectInputStream
 * 	4. ��� (�۽�:�����, ����:��û���޴´�)	> OutputStream / BufferedReader
 */
//-------------------------------------------------------------------------------
//	1. ������ ����
//	2. ������
//	3. ������ ���Ӵ�� 
//		- �������� ������ �޴´�
//		- �����ڸ��� ���� ����� �����ϰ� ����� (���α׷��� ������ ���� = ������)
//	4. �������� ��� (������)		==> �̺κ��� '�����α׷�'. ������ �� �κ��� �߽����� �������ߵǴ� �κ�

import java.util.*;

import java.io.*;
import java.net.*;
import sist.com.music.*;
import sist.com.common.*;

public class Server implements Runnable {

	private static ArrayList<Music> mList = new ArrayList<Music>();
	// ���� �����͸� (Ŭ���̾�Ʈ����) ������ ����

	private ArrayList cList = new ArrayList<>();
	// �������� ������ �����Ѵ� (ID, Name, IP, Port)

	private ServerSocket ss; // ������ > ������ �޾Ƽ� ����

	// 1. ������ �ʱ�ȭ
	static {
		// ������ �о Arraylist�� ���� �� ���
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {

			fis = new FileInputStream("C:\\SY\\�ڷ�\\java_data\\music_object.txt");
			// ���� ������ ��ü ������ ����
			ois = new ObjectInputStream(fis);

			mList = (ArrayList<Music>) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				ois.close();
			} catch (Exception e2) {
			}
		}
	}

	public Server() {
		// ���� ����
		try {

			ss = new ServerSocket(3355); // port �� �ݵ�� ����
			// ���� ���� �˸�
			// bind() (�� : ����) => listen() : (������)
			System.out.println("Music Server Start...");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ���� �� ó��

	public void run() {
		try {
			Socket s = ss.accept(); // ������ �Ǹ� => ������� ����(Socket)�� ���;��Ѵ�
			// Socket �� ������� �����ؼ� �����ڸ��� ����� �����ϰ� ������ش�

			Client client = new Client(s);
			client.start(); // ������ �Ѱ��ְ� �ش� �����ڿ� ����� �����Ѵ�

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		// ����
		Server server = new Server(); // ������ ȣ�� (����)
		new Thread(server).start(); // run ȣ�� > ������ ���� ó��

	}

	// ��� ��� Ŭ���� => �ݵ�� (�����ڸ��� ���� ����) => ���α׷��� ������ ������ �� �ְ� ���������� >> '������'
	// ���α׷�(���μ���) �ȿ��� �������� �ٸ� ���α׷��� ���� => ������
	// �����带 �̿��ؼ� ����� ���� (������ ������ �ʿ�) => Server / Client > �� ���� ���� �����Ͱ����� �Ǿ���� (�̶�
	// ����Ŭ���� ���)

	class Client extends Thread {
		Socket s;

		// �۽� (��ûó�� ������� �����ٶ� ���)
		OutputStream out;
		// ���� (������� ��û�� �޴� ��쿡 ���)
		BufferedReader br;

		// ������ ����
		String id, name; // �α��� �� �� ���� ����

		public Client(Socket s) {
			try {
				this.s = s;

				// �����(���)�� �� �� �ְ� ����
				// �Է� / ���� �ȿ��� ���� �ٷ� �о������
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));

				// ���
				out = s.getOutputStream();

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		// ����� ���� => run
		public void run() {
			while (true) {
				try {

					// 1. ����ڰ� ��û�� ���� ��
					String msg = br.readLine();

					// 2. ��ɺ��� ó���ϱ� ���� �����ֱ�
					StringTokenizer st = new StringTokenizer(msg, "|");

					// 3. � ��û���� Ȯ��
					int protocol = Integer.parseInt(st.nextToken());

					switch (protocol) {
					case Function.LOGIN: {
						// �α��� ó�� > ȭ�� ���� > ���� ������ ����

						id = st.nextToken();
						name = st.nextToken();

						// ���� ������ ������������ ����
						cList.add(this); // id, name, s, in, out

						// �α���â �������� ���� ȭ������ ����
						messageTo(Function.MYLOG + "|" + name);

						// ���� �����͸� ����
						StringBuffer sb = new StringBuffer();
						for (Music m : mList) {
							String music = m.getNo() + "%" + m.getTitle() + "%" + m.getSinger() + "%" + m.getAlbum()
									+ "^";
							sb.append(music);
						}
						// ����� ����ض�
						messageTo(Function.LIST + "|" + sb.toString());
					}
						break;

					case Function.LIST: {
						StringBuffer sb = new StringBuffer();
						for (Music m : mList) {
							String music = m.getNo() + "%" + m.getTitle() + "%" + m.getSinger() + "%" + m.getAlbum()
									+ "^";
							sb.append(music);
						}
						// ����� ����ض�
						messageTo(Function.LIST + "|" + sb.toString());
					}
						break;

					case Function.FIND: {
						// ���� �˻�� �޾Ƽ� > ã�� �����͸� ����
						StringBuffer sb = new StringBuffer();

						// �˻�� �޴´�
						String ss = st.nextToken();

						// ã��
						for (Music m : mList) {
							if (m.getTitle().contains(ss)) {
								String music = m.getNo() + "%" + m.getTitle() + "%" + m.getSinger() + "%" + m.getAlbum()
										+ "^";
								sb.append(music);
							}
						}
						// ã�� ������ ����ڿ��� ������
						messageTo(Function.FIND + "|" + sb.toString());
					}
						/*
						 * ���� ��� 1. ������ �ޱ� : BufferedReader 2. ������ ���� : OutputStream > write() 3. ������ �˻�
						 * : conatins(), equals() 4. ������ �߰� : Login 5. ������ ���� 6. ������ ����
						 * 
						 * ����Ŭ, ������
						 */

						break;
					}

				} catch (Exception e) {
				}
			}
		}

		// �����͸� ���� (out)
		public void messageTo(String msg) {
			try {
				out.write((msg + "\n").getBytes());
			} catch (Exception e) {

			}
		}
	}
}
