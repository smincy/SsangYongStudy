package sist.com.common;

//서버 / 클라이언트에서 공통으로 사용되는 파일

// 내부 프로토콜 => 서버/클라이언트 약속 
// 클라이언트에서 100 을 보내면 => 서버 (로그인처리) => 요청번호 
// 클라이언트	 200		 => 서버 (채팅처리)
// 클라이언트 	 300 		 => 서버 (나가기)
// 웹 ==> 구분이 되는 것이 없다 (유일하게 '파일명'으로)

public class Function {

	// 만드는 프로그램의 기능 설정 =(우리는)> 로그인 , 채팅 , 나가기
	public static final int LOGIN = 100; // 이미 들어와 있는 접속자 처리
	public static final int MYLOG = 110; // 로그인하고 들어가는 사람
	public static final int CHAT = 200;
	public static final int EXIT = 300; // 남아 있는 접속자 처리
	public static final int MYEXIT = 310; // 실제 나가는 사람 처리

	// 필요시에 기능 첨부

}