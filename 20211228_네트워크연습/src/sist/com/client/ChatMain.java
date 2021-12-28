package sist.com.client;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// ��Ʈ��ũ ���� 
import java.io.*;
import java.net.*;
import sist.com.common.*;

/*
 *   ���� ���� (���) : implements Runnable,ActionListener
 *   => �������̽������� ����� ���� 
 *   => ���� �ٸ� Ŭ������ �����ؼ� ��� 
 *   => ���õ� Ŭ������ ��� �Ѱ��� �̸����� ���� 
 *   => 
 *      interface A
 *      {
 *          --------- int a=10;
 *          public static final 
 *          --------- void display();
 *          public abstract
 *          
 *          public 
 *          ----default void aaa(){
 *             ���� 
 *          }
 *          
 *          ���� => ����� 
 *          �޼ҵ�� ������ public 
 *      }
 *      ==> Ŭ���� ���� (Ŭ���� ������ => ������(�������̽�))
 *          �� => �������̽��� �̿��ؼ� ���� 
 *          Model 1
 *          Model 2 ===> �ֱٿ� ������ (MVC) => domain(�л�)
 *      1.8 => ������ �޼ҵ� ����� ���� : default
 */
public class ChatMain extends JFrame implements Runnable, ActionListener {
	Login login = new Login();
	WaitRoom wr = new WaitRoom();
	CardLayout card = new CardLayout();
	//// ȭ�� UI
	//// ��Ʈ��ũ�� ���õ� Ŭ����
	// ���� ����
	Socket s;
	// ����� => ���� �۽� , ���� ����
	OutputStream out; // �۽�
	BufferedReader in; // ���� ==> ������ (�ǽð�)
	// ����� => ���� (�ܹ���)
	// id����
	String id;

	public ChatMain() {
		setLayout(card);
		add("LOGIN", login);
		add("WR", wr);
		setSize(1000, 750);
		setVisible(true);

		// �α��� ��ư ó�� ==> ��� (�̺�Ʈ ��� => �ݹ��Լ�)
		login.b1.addActionListener(this);// actionPerformed
		login.b2.addActionListener(this);// actionPerformed
		wr.tf.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatMain();
	}

	// ��û => ��ư Ŭ����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == login.b2) {
			// e.getSource() => Ŭ���� ��ư�� ����?
			System.exit(0);// �����ض�
		} else if (e.getSource() == login.b1) // �α��� ��ư�� Ŭ�� �ߴٸ�
		{
			// 1. �Է��� ���� �д´�
			// 1-1 ID�б�
			String id = login.tf1.getText();
			// ��ȿ�� �˻�
			if (id.length() < 1)// id �Է��� ���� ���
			{
				JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���");
				// �� (alert())
				login.tf1.requestFocus();
				return;
			}
			// 1-2 �̸� �б�
			String name = login.tf2.getText();
			if (name.length() < 1)// id �Է��� ���� ���
			{
				JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���");
				// �� (alert())
				login.tf2.requestFocus();
				return;
			}
			// 1-3 ����
			String sex = "";
			if (login.rb1.isSelected()) {
				sex = "����";
			} else {
				sex = "����";
			}
			// ���������ؼ� �����͸� ���� ==> �����
			try {
				// 1. ��ȭ�� ���� => ����
				s = new Socket("localhost", 3355);
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				// �������� �����ִ� ������ �д� ��ü
				out = s.getOutputStream();
				// ������ �����͸� ������

				out.write((Function.LOGIN + "|" + id + "|" + name + "|" + sex + "\n").getBytes());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			// ����� �о�Ͷ�
			new Thread(this).start();
			// ===== ChatMain�� �ִ� run()�� ȣ���϶�
		}
		// ä��
		else if (e.getSource() == wr.tf) {
			// enter
			try {
				// 1-1 �Էµ� ä�� ���ڿ� �б�
				String msg = wr.tf.getText();
				if (msg.length() < 1) {
					// �Է��� �ȵ� ���
					wr.tf.requestFocus();
					return;
				}

				// �Է��� �� ��쿡�� ������ ���� => ������ü�� ���� ����
				out.write((Function.CHAT + "|" + msg + "\n").getBytes());

				// �Էµ� ���� �����ش�
				wr.tf.setText("");

			} catch (Exception ex) {
			}
		}
	}

	// �������� ���䰪�� �޾Ƽ� ���
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				// 1.�������� ����� �����͸� �д´�
				String msg = in.readLine();
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				switch (protocol) {
				/*
				 * messageAll(Function.LOGIN+"|" +id+"|"+name+"|"+sex);
				 */
				case Function.LOGIN: {
					String[] data = { st.nextToken(), st.nextToken(), st.nextToken() };
					wr.model.addRow(data);// ���̺� ���

				}
					break;
				case Function.MYLOG: {
					// ȭ�� �̵� => �α���â => ���Ƿ� ����
					card.show(getContentPane(), "WR");
					setTitle(st.nextToken());
				}
					break;
				case Function.CHAT: {
					wr.ta.append(st.nextToken() + "\n");
				}
				}
			}
		} catch (Exception ex) {
		}

	}

}
