package sist.com.server;

/*
 * 	1. 서버구동				> ServerSocket
 * 	2. 접속자 정보 저장			> ArrayList
 * 	3. 음악 정보 저장			> ArrayList	> ObjectInputStream
 * 	4. 통신 (송신:결과값, 수신:요청을받는다)	> OutputStream / BufferedReader
 */
//-------------------------------------------------------------------------------
//	1. 소켓을 생성
//	2. 대기상태
//	3. 접속자 접속대기 
//		- 접속자의 정보를 받는다
//		- 접속자마다 따로 통신이 가능하게 만든다 (프로그램을 별도로 수행 = 쓰레드)
//	4. 접속자의 통신 (쓰레드)		==> 이부분이 '웹프로그램'. 앞으로 이 부분을 중심으로 만들어나가야되는 부분

import java.util.*;

import java.io.*;
import java.net.*;
import sist.com.music.*;
import sist.com.common.*;

public class Server implements Runnable {

	private static ArrayList<Music> mList = new ArrayList<Music>();
	// 뮤직 데이터를 (클라이언트정보) 저장할 공간

	private ArrayList cList = new ArrayList<>();
	// 접속자의 정보를 저장한다 (ID, Name, IP, Port)

	private ServerSocket ss; // 기지국 > 접속을 받아서 연결

	// 1. 변수의 초기화
	static {
		// 파일을 읽어서 Arraylist에 저장 후 사용
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {

			fis = new FileInputStream("C:\\SY\\자료\\java_data\\music_object.txt");
			// 읽은 파일을 객체 단위로 저장
			ois = new ObjectInputStream(fis);

			mList = (ArrayList<Music>) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				ois.close();
			} catch (Exception e2) {
			}
		}
	}

	public Server() {
		// 서버 구동
		try {

			ss = new ServerSocket(3355); // port 는 반드시 고정
			// 서버 구동 알림
			// bind() (예 : 개통) => listen() : (대기상태)
			System.out.println("Music Server Start...");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 접속 시 처리

	public void run() {
		try {
			Socket s = ss.accept(); // 접속이 되면 => 사용자의 정보(Socket)를 얻어와야한다
			// Socket 을 쓰레드로 전송해서 접속자마다 통신이 가능하게 만들어준다

			Client client = new Client(s);
			client.start(); // 소켓을 넘겨주고 해당 접속자와 통신을 시작한다

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		// 구동
		Server server = new Server(); // 생성자 호출 (구동)
		new Thread(server).start(); // run 호출 > 접속자 접속 처리

	}

	// 통신 담당 클래스 => 반드시 (접속자마다 따로 생성) => 프로그램을 별도로 수행할 수 있게 만들어줘야함 >> '쓰레드'
	// 프로그램(프로세스) 안에서 여러개의 다른 프로그램을 수행 => 쓰레드
	// 쓰레드를 이용해서 통신을 시작 (접속자 정보가 필요) => Server / Client > 이 둘이 서로 데이터공유가 되어야함 (이때
	// 내부클래스 사용)

	class Client extends Thread {
		Socket s;

		// 송신 (요청처리 결과값을 보내줄때 사용)
		OutputStream out;
		// 수신 (사용자의 요청을 받는 경우에 사용)
		BufferedReader br;

		// 접속자 구분
		String id, name; // 로그인 할 때 전송 받음

		public Client(Socket s) {
			try {
				this.s = s;

				// 입출력(통신)을 할 수 있게 연결
				// 입력 / 소켓 안에서 값을 바로 읽어오도록
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));

				// 출력
				out = s.getOutputStream();

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		// 통신을 시작 => run
		public void run() {
			while (true) {
				try {

					// 1. 사용자가 요청을 했을 때
					String msg = br.readLine();

					// 2. 기능별로 처리하기 위해 나눠주기
					StringTokenizer st = new StringTokenizer(msg, "|");

					// 3. 어떤 요청인지 확인
					int protocol = Integer.parseInt(st.nextToken());

					switch (protocol) {
					case Function.LOGIN: {
						// 로그인 처리 > 화면 변경 > 음악 데이터 전송

						id = st.nextToken();
						name = st.nextToken();

						// 받은 정보를 접속자정보에 저장
						cList.add(this); // id, name, s, in, out

						// 로그인창 다음으로 음악 화면으로 변경
						messageTo(Function.MYLOG + "|" + name);

						// 음악 데이터를 전송
						StringBuffer sb = new StringBuffer();
						for (Music m : mList) {
							String music = m.getNo() + "%" + m.getTitle() + "%" + m.getSinger() + "%" + m.getAlbum()
									+ "^";
							sb.append(music);
						}
						// 목록을 출력해라
						messageTo(Function.LIST + "|" + sb.toString());
					}
						break;

					case Function.LIST: {
						StringBuffer sb = new StringBuffer();
						for (Music m : mList) {
							String music = m.getNo() + "%" + m.getTitle() + "%" + m.getSinger() + "%" + m.getAlbum()
									+ "^";
							sb.append(music);
						}
						// 목록을 출력해라
						messageTo(Function.LIST + "|" + sb.toString());
					}
						break;

					case Function.FIND: {
						// 음악 검색어를 받아서 > 찾은 데이터를 전송
						StringBuffer sb = new StringBuffer();

						// 검색어를 받는다
						String ss = st.nextToken();

						// 찾기
						for (Music m : mList) {
							if (m.getTitle().contains(ss)) {
								String music = m.getNo() + "%" + m.getTitle() + "%" + m.getSinger() + "%" + m.getAlbum()
										+ "^";
								sb.append(music);
							}
						}
						// 찾은 내용을 사용자에게 보낸다
						messageTo(Function.FIND + "|" + sb.toString());
					}
						/*
						 * 서버 기능 1. 데이터 받기 : BufferedReader 2. 데이터 전송 : OutputStream > write() 3. 데이터 검색
						 * : conatins(), equals() 4. 데이터 추가 : Login 5. 데이터 수정 6. 데이터 삭제
						 * 
						 * 오라클, 웹서버
						 */

						break;
					}

				} catch (Exception e) {
				}
			}
		}

		// 데이터를 전송 (out)
		public void messageTo(String msg) {
			try {
				out.write((msg + "\n").getBytes());
			} catch (Exception e) {

			}
		}
	}
}