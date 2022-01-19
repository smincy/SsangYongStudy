package sist.com.temp;

// 비동기
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainClass2 extends JFrame {

	JLabel la;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6;
	JButton b1, b2;

	public MainClass2() {
		la = new JLabel("�ζ� ����", JLabel.CENTER);
		la.setFont(new Font("�ϴ�ä", Font.BOLD, 35));
		add("North", la);
		JPanel p = new JPanel();

		tf1 = new JTextField("", JLabel.CENTER);
		tf1.setFont(new Font("�ü�ü", Font.BOLD, 35));

		tf2 = new JTextField("", JLabel.CENTER);
		tf2.setFont(new Font("�ü�ü", Font.BOLD, 35));

		tf3 = new JTextField("", JLabel.CENTER);
		tf3.setFont(new Font("�ü�ü", Font.BOLD, 35));

		tf4 = new JTextField("", JLabel.CENTER);
		tf4.setFont(new Font("�ü�ü", Font.BOLD, 35));

		tf5 = new JTextField("", JLabel.CENTER);
		tf5.setFont(new Font("�ü�ü", Font.BOLD, 35));

		tf6 = new JTextField("", JLabel.CENTER);
		tf6.setFont(new Font("�ü�ü", Font.BOLD, 35));

		p.add(tf1);
		p.add(tf2);
		p.add(tf3);
		p.add(tf4);
		p.add(tf5);
		p.add(tf6);

		add("Center", p);

		JPanel p2 = new JPanel();
		p2.add(b1);
		p2.add(b2);

		setSize(450, 350);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainClass2();

	}

	class LottoThread extends Thread {

		JTextField tf;

		public LottoThread(JTextField tf) {
			this.tf = tf;
		}

		public void run() {
			int n = 1;
			while (true) {
				n++;

			}
		}
	}
}