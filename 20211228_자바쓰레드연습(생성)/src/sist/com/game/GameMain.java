package sist.com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ������
public class GameMain extends JFrame {
	JMenuItem startItem = new JMenuItem("���");
	JMenuItem endItem = new JMenuItem("����");
	GameView g = new GameView();

	public GameMain() {
		JMenu menu = new JMenu("����");
		menu.add(startItem);

		menu.addSeparator(); // ���м�

		menu.add(endItem);
		JMenuBar bar = new JMenuBar();
		bar.add(menu);

		setJMenuBar(bar); // ������ ���� �޴� ����

		// ���� �߰�
		add("Center", g);

		// ũ�� ����
		setSize(1000, 750);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X Ŭ���� �޸� ����

		startItem.addActionListener((e) -> {
			g.start();
		});

		endItem.addActionListener((e) -> {
			g.end();
		});

	}

	public static void main(String[] args) {
		// ȣ��
		new GameMain(); // ������ ȣ��ÿ��� �ݵ�� new ������();
	}

}
