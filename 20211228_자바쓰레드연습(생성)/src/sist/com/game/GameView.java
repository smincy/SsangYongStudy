package sist.com.game;

import java.awt.*;
import javax.swing.*;
// JFrame / JDialog / JWindow => 위에 올려서 사용
// JPanel은 단독 수행이 불가능하다 (컴포넌트 묶어서 관리) => 화상

public class GameView extends JPanel {
	private HorseThread h = new HorseThread();

	private Image horse;

	public GameView() {
		horse = Toolkit.getDefaultToolkit().getImage("C:\\SY\\캡쳐\\i013521632353.gif"); // 이미지 가져오기
	}

	// 그림을 그린다
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(horse, h.x, h.y, 100, 60, null);
	}

	public void start() { // 시작
		h.start();
	}

	public void end() { // 종료
		h.interrupt();
	}

	class HorseThread extends Thread {

		int x = 850;
		int y = 600;

		public void run() {
			while (true) {

				try {
					x -= 5;
					if (x < 0) { // x 가 0 보다 작아지면 쓰레드종료
						x = -100;
						interrupt();
						break;
					}
					Thread.sleep(300); // 잠깐씩 멈추게
					repaint(); // 그림을 다시 그린다
				} catch (Exception e) {

				}

			}
		}
	}
}
