package sist.com.client;

import java.awt.*;
import javax.swing.*;

public class Login extends JPanel {

	JLabel la1, la2;
	JTextField tf1, tf2;
	JButton b1, b2;

	public Login() {
		la1 = new JLabel("���̵�");
		la2 = new JLabel("�̸�");

		tf1 = new JTextField();
		tf2 = new JTextField();
		b1 = new JButton("�α���");
		b2 = new JButton("���");

		setLayout(null);
		// ��ġ
		la1.setBounds(10, 15, 50, 30);
		tf1.setBounds(65, 15, 150, 30);

		la2.setBounds(10, 50, 50, 30);
		tf2.setBounds(65, 50, 150, 30);

		// ��ư�� ������ ��� > JPanel
		JPanel p = new JPanel();
		p.add(b1);
		p.add(b2);

		// �����쿡 �ø���
		add(la1);
		add(tf1);
		add(la2);
		add(tf2);
		add(p);

	}
}
