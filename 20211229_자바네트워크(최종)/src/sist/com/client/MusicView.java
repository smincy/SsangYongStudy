package sist.com.client;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class MusicView extends JPanel {

	JTable table;
	DefaultTableModel model;
	JButton b1, b2;
	JTextField tf;

	public MusicView() {
		b1 = new JButton("�˻�");
		b2 = new JButton("���");
		tf = new JTextField(20);
		JPanel p = new JPanel();

		p.add(tf);
		p.add(b1);
		p.add(b2);

		String[] col = { "����", "���", "������", "�ٹ�" };
		String[][] row = new String[0][4];
		model = new DefaultTableModel(row, col);
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);

		// ��ġ
		setLayout(new BorderLayout());
		// => North , South , East , West , Center
		add("North", p);
		add("Center", js);

	}
}
