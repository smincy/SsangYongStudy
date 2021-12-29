package sist.com.client;

// ���⼭ ����� ������â�� >> ���߿� HTML �� �ٲ�鼭 ��¥ �� ���α׷��� 

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

import sist.com.common.Function;

public class MusicMain extends JFrame implements Runnable, ActionListener {

	CardLayout card = new CardLayout();

	Login login = new Login();

	MusicView mv = new MusicView();
	// ��Ʈ��ũ ���õ� Ŭ����
	Socket s; // ������(��ȭ��)
	// �۽�, ����
	OutputStream out;
	BufferedReader in;

	public MusicMain() {
		setLayout(card);
		// �ʿ��� ȭ�� ��Ƶα� (Login, Music)

		add("LOGIN", login);
		add("MV", mv);

		// ũ��
		setSize(800, 600);

		// �����츦 �����޶� ��û
		setVisible(true);

		// �����ư Ŭ���� ������ ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ��ư Ŭ���� => ��� �ؾ� => �ڵ����� ȣ�� (CallBack)
		login.b1.addActionListener(this);// �α���
		login.b2.addActionListener(this);// ���
		mv.b1.addActionListener(this);// �˻�
		mv.b2.addActionListener(this);// ���

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �����ڸ� ȣ��
		new MusicMain();
	}

// ��ư Ŭ���� ó�� 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// ����� ��û
		if (e.getSource() == login.b1) {
			// ������ ����
			// ID�б� ==> ������ �Է� => ��(��ȿ�� �˻�)
			String id = login.tf1.getText();
			if (id.length() < 1) // �Է��� �ȵ� ���
			{
				JOptionPane.showMessageDialog(this, "���̵� �Է�");
				login.tf1.requestFocus();
				return;
			}
			// �̸� �б�
			String name = login.tf2.getText();
			if (name.length() < 1) // �Է��� �ȵ� ���
			{
				JOptionPane.showMessageDialog(this, "�̸��� �Է�");
				login.tf2.requestFocus();
				return;
			}
			// ������ ����
			try {
				s = new Socket("localhost", 3355);// ������ ����
				// Socket("�����ּ�(IP)",�������� ������ PORT)
				// �ۼ��� ��ġ Ȯ��
				out = s.getOutputStream();// ������ �����͸� ����
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				/*
				 * Ŭ���̾�Ʈ: Socket(��������) => ���� IP ���� : Socket(Ŭ���̾�Ʈ ����)=> Ŭ���̾�Ʈ IP
				 */
				// �α��� ��û
				out.write((Function.LOGIN + "|" + id + "|" + name + "\n").getBytes());
			} catch (Exception ex) {
			}
			// ID,�̸� => Login�� ��û
			// �������� ������ �����͸� �޾Ƽ� ����Ѵ�
			new Thread(this).start();
		} else if (e.getSource() == login.b2) {
			// ��� => ���α׷� ����
			System.exit(0); // 0 => ���� ����
		} else if (e.getSource() == mv.b1) {
			// �˻�� �о �˻��� ������ ã�� �޶� ��û
			String ss = mv.tf.getText(); // �Է��� ���ڸ� �о� �´�
			if (ss.length() < 1) {
				JOptionPane.showMessageDialog(this, "�˻��� �Է�");
				mv.tf.requestFocus();
				return;
			}
			// ������ ����
			try {
				out.write((Function.FIND + "|" + ss + "\n").getBytes());
			} catch (Exception ex) {
			}
			// �˻�� �����ش�
			mv.tf.setText("");
		} else if (e.getSource() == mv.b2) {
			// ��ü ��� ��û
			try {
				out.write((Function.LIST + "|\n").getBytes());
			} catch (Exception ex) {
			}
		}

	}

// �������� ������ ������ ��� 
// switch => ��Ʈ��ũ , ������ , ���� 
// �� => if�� �ַ� ��� (���� ó��) => ���� , ���� ,�����ڽ� 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				// �����κ��� ������ �ޱ�
				String msg = in.readLine();
				System.out.println("Server=>" + msg);
				// ����
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				// Function.MYLOG , Function.LIST,Function.FIND
				switch (protocol) {
				case Function.MYLOG: {
					card.show(getContentPane(), "MV");
					setTitle(st.nextToken());
				}
					break;
				case Function.LIST: {
					// ���̺� ������ ����� �ٽ� ä���
					for (int i = mv.model.getRowCount() - 1; i >= 0; i--) {
						mv.model.removeRow(i);
					}
					String data = st.nextToken();
					String[] music = data.split("\\^");
					for (String m : music) {
						String[] mdata = m.split("\\%");
						mv.model.addRow(mdata);
					}
				}
					break;
				case Function.FIND: {
					for (int i = mv.model.getRowCount() - 1; i >= 0; i--) {
						mv.model.removeRow(i);
					}
					String data = st.nextToken();
					String[] music = data.split("\\^");
					for (String m : music) {
						String[] mdata = m.split("\\%");
						mv.model.addRow(mdata);
					}
				}
				}
			}
		} catch (Exception ex) {
		}
	}
}