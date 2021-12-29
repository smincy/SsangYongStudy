package sist.com.common;
// 서버와 클라이언트 의 약속 (번호)

// 목록 요청 시 어떤 (번호)를 보낼것인지
// 검색 요청
// 상세 보기 요청

public class Function {
	
	public static final int LOGIN = 100;// 로그인 요청시 100 / 이미 접속한 사람 처리
	public static final int MYLOG = 110;				// 로그인 하는 사람 처리
	public static final int LIST = 200;	// 목록을 요청하면 200 / 사용자 요청시 목록을 보여준다
	public static final int FIND = 300;	// 검색 요청시 300	/ 사용자 검색시 검색내용을 보여준다
	
}
