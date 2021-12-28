package sist.com.game;

import java.awt.*;
import javax.swing.*;
// JFrame / JDialog / JWindow => ���� �÷��� ���
// JPanel�� �ܵ� ������ �Ұ����ϴ� (������Ʈ ��� ����) => ȭ��

public class GameView extends JPanel {
	private HorseThread h = new HorseThread();

	private Image horse;

	public GameView() {
		horse = Toolkit.getDefaultToolkit().getImage("C:\\SY\\ĸ��\\i013521632353.gif"); // �̹��� ��������
	}

	// �׸��� �׸���
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(horse, h.x, h.y, 100, 60, null);
	}

	public void start() { // ����
		h.start();
	}

	public void end() { // ����
		h.interrupt();
	}

	class HorseThread extends Thread {

		int x = 850;
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
					Thread.sleep(300); // ��� ���߰�
					repaint(); // �׸��� �ٽ� �׸���
				} catch (Exception e) {

				}

			}
		}
	}
}
