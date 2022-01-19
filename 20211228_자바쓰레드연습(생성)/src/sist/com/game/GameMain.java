package sist.com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//말이 자동으로 움직이게 하기위해 쓰레드

//윈도우
public class GameMain extends JFrame {
	// 상태표시줄에 메뉴들 만드는 과정
	// 드롭다운 메뉴 안에 항목들이 JMenuItem

	JMenuItem startItem = new JMenuItem("���");
	JMenuItem endItem = new JMenuItem("����");

	GameView g = new GameView();	// GameView 가져오기

	public GameMain() {
		JMenu menu = new JMenu("����"); // '게임' 이라는 메뉴를 만들고
		menu.add(startItem); // 그 메뉴를 누르면 하위항목으로 Item들 표시하도록 추가

		menu.addSeparator(); // 구분선

		menu.add(endItem);
		JMenuBar bar = new JMenuBar(); // 메뉴들 전체를 묶어 주는(상태표시줄)것을 JMenuBar
		bar.add(menu);

		setJMenuBar(bar); // 이걸 줘야 윈도우 위에 메뉴가 올라감

		// 게임 추가
		add("Center", g);

		// 윈도우 크기 설정
		setSize(700, 750);
		setVisible(true); // 윈도우를 보여줘라
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 우상단 닫기버튼 [X] 클릭시 종료 - 메모리 해제

		// 람다
		startItem.addActionListener((e) -> {
			g.start();		
		});
		endItem.addActionListener((e) -> {
			g.end();
		});

	}

	public static void main(String[] args) {
		// 호출
		new GameMain(); // 생성자 호출시에는 반드시 new 생성자();
	}

}
