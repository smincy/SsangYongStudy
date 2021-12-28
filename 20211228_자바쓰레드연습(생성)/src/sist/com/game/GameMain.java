package sist.com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// ���� �ڵ����� �����̰� �ϱ����� ������

// ������
public class GameMain extends JFrame {
	// ����ǥ���ٿ� �޴��� ����� ����
	// ��Ӵٿ� �޴� �ȿ� �׸���� JMenuItem

	JMenuItem startItem = new JMenuItem("���");
	JMenuItem endItem = new JMenuItem("����");

	GameView g = new GameView();	// GameView ��������

	public GameMain() {
		JMenu menu = new JMenu("����"); // '����' �̶�� �޴��� �����
		menu.add(startItem); // �� �޴��� ������ �����׸����� Item�� ǥ���ϵ��� �߰�

		menu.addSeparator(); // ���м�

		menu.add(endItem);
		JMenuBar bar = new JMenuBar(); // �޴��� ��ü�� ���� �ִ�(����ǥ����)���� JMenuBar
		bar.add(menu);

		setJMenuBar(bar); // �̰� ��� ������ ���� �޴��� �ö�

		// ���� �߰�
		add("Center", g);

		// ������ ũ�� ����
		setSize(700, 750);
		setVisible(true); // �����츦 �������
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ���� �ݱ��ư [X] Ŭ���� ���� - �޸� ����

		// ����
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
