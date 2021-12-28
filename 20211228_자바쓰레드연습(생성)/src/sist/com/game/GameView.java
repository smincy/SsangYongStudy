package sist.com.game;

import java.awt.*;
import javax.swing.*;

// JFrame / JDialog / JWindow => ��� ���� �÷���, ��� �����ϰ� ����°� JPanel
// JPanel�� �ܵ� ������ �Ұ����ϴ� (������Ʈ ��� ����) => ȭ��, ��ư�� ����

public class GameView extends JPanel {
	private HorseThread h = new HorseThread();

	private Image horse;

	public GameView() {
		// �̹��� ��������
		horse = Toolkit.getDefaultToolkit().getImage("C:\\SY\\ĸ��\\i013521632353.gif");
	}

	// �׸��� �׸���
	public void paint(Graphics g) { // Graphics => �׸��� �׸��� ����

		// ������ ����
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.drawImage(horse, h.x, h.y, 150, 80, this); // �׸�, ������ġ, ������ġ, ũ��, ����, this
	}

	public void start() { // ����
		h.start();
	}

	public void end() { // ����
		h.interrupt();
	}

	
	class HorseThread extends Thread {
		int x = 500;
		int y = 600;

		public void run() {
			while (true) {
				try {
					x -= 5;
					if (x < 0) { // x �� 0 ���� �۾����� ����������
						x = -100;
						interrupt();
						break;
					}
					Thread.sleep(200); // ��� ���߰�
					repaint(); // �׸��� �ٽ� �׸���
				} catch (Exception e) {
				}
			}
		}
	}
}
