package sist.com.game;

import java.awt.*;
import javax.swing.*;

// JFrame / JDialog / JWindow => 얘들 위에 올려서, 사용 가능하게 만드는게 JPanel
// JPanel은 단독 수행이 불가능하다 (컴포넌트 묶어서 관리) => 화상, 버튼을 묶는

public class GameView extends JPanel {
	private HorseThread h = new HorseThread();

	private Image horse;

	public GameView() {
		// 이미지 가져오기
		horse = Toolkit.getDefaultToolkit().getImage("C:\\SY\\캡쳐\\i013521632353.gif");
	}

	// 그림을 그린다
	public void paint(Graphics g) { // Graphics => 그림을 그리는 도구

		// 바탕색 설정
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.drawImage(horse, h.x, h.y, 150, 80, this); // 그림, 가로위치, 세로위치, 크기, 높이, this
	}

	public void start() { // 시작
		h.start();
	}

	public void end() { // 종료
		h.interrupt();
	}

	
	class HorseThread extends Thread {
		int x = 500;
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
					Thread.sleep(200); // 잠깐씩 멈추게
					repaint(); // 그림을 다시 그린다
				} catch (Exception e) {
				}
			}
		}
	}
}
