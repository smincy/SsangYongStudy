package sist.com.main;

/*
 *    1. 자바 총정리 
 *    1) 자바 실행 과정(컴파일 / 인터프리터)
 *       컴파일 : 컴퓨터가 인식하는 언어로 변경 
 *              (프로그램 언어) 
 *       인터프리터 : 한줄씩 읽어서 번역 (HTML,XML ,자바)
 *       => 에러 : 컴파일에러(문법에러) , 실행시 에러(사용자 입력값):UnCheckException
 *                ================ CheckException  
 *       A.java ======================= A.class =========== 출력
 *       ======       컴파일 (javac)     바이트 코드     JVM(java)
 *       프로그래머만 아는 언어 (원시소스)     => 컴퓨터가 인식
 *       *** 컴파일 VS 인터프리터 (기술면접)
 *    2) 프로그램을 개발 
 *      ========================================================
 *       데이터 저장  =======  데이터 가공 ========= 가공된 데이터를 출력 
 *         |
 *        변수 : 메모리 한개의 값을 저장하는 공간 
 *        배열 : 메모리 연속적으로 여러개를 저장하는 공간
 *                   ===== (데이터의 크기가 동일) 
 *        클래스 : 메모리에 여러개를 저장 => 데이터 크기가 동일하지 않는 경우 
 *        ===================================================== 메모리에 저장 
 *        파일 : 영구적인 저장 저장 장치 (보안,취급) => 비정형화 
 *        오라클(RDBMS) : 영구적인 저장 장치 (보안,취급이 간결) => 정형화 (형식)
 *      ======================================================== 클래스 (재사용)
 *      
 *      저장된 데이터를 활용 
 *      ===============
 *      데이터 가공 : 연산자 / 제어문 => 소스가 너무 많다 (묶어서 처리 => 메소드) 
 *      
 *      가공된 데이터를 출력 
 *      = 도스 (Output)
 *      = 윈도우 
 *      ===============> Application Program : exe파일 (C/C++,MFC)
 *      = 브라우저 
 *      ===============> Web Application Program(***) : 유선이 발전 (웹)
 *      = 핸드폰 
 *      ===============> Mobile Application Program : 브라질, 일본 
 *                       ===========================
 *                         자바 ==> 유료화 ==> 코틀린 
 *      ***** 소스 코딩 
 *      => 여러개 클래스가 공통으로 사용 => 공통모듈(스프링)
 *      ================ 
 *      => 반복이 되는 부분 
 *      => 재사용 하는 부분
 *      ================ 메소드를 만든다 
 *      ***** 프로그램을 잘 만든다 
 *      1. 반복이 없는 소스 
 *      2. 패턴 사용 
 *      3. 메모리 절약 
 *      4. 재사용을 할 수 있게 제작 
 *      5. 속도가 빠른게 만든다 (최적화) ==> 퍼포먼트 
 *      =======================================================
 *      *** 자바 소스 (암기(X)) => 순서 (알고리즘) => 주석 => 자바로 번역 
 *      *** 겁(X) ==> 있는 그대로 => 초등,중,고등 
 *          문법을 생각하지 않는다 (한국어 => 말할때 문법)
 *          *** 객체지향 , 문법 (X) => 체계 (로직)
 *          *** 사수 => 참조 책 , 사이트 
 *          *** 고정 관념 (X) 
 *      *** 라이브러리 / 변수 / 클래스 ==> 용도
 *      1) 데이터 저장 방법 => 2장 (1,2,5) 
 *         변수: 한개의 데이터를 저장하는 장소  
 *         메모리 크기 (데이터형,자료형) 
 *         => 데이터형 
 *            = 기본 자료형 => 컴퓨터가 메모리 크기를 알고 있다 
 *              int a=10;
 *              => 4byte메모리를 만든다
 *              => 10을 저장한다 
 *              => 10이 저장된 위치를 a라는 이름으로 사용 
 *                 ===
 *                 메모리 => 주소를 알 수가 없기때문에 별칭을 부여   
 *              ============================
 *               정수형
 *                 ***byte => 파일 관련 , 네트워크 관련(파일 업로드 , 파일 다로운드) 
 *                 short => C언어 호환의 문제 (사용빈도가 거의 없다)
 *                 ***int => default (정수를 사용하면 => 컴퓨터는 무조건 int인식)
 *                 ***long => int와 구분 (L,l) => 은행(금융권)
 *              ============================
 *               실수형
 *                 float 
 *                 ***double : default 
 *              ============================
 *               논리형
 *                 ***true/false => boolean 
 *              ============================
 *               문자형 
 *                 char => Unicode(2byte) => 사용빈도가 작다 (문자열=> String)
 *              ============================
 *              
 *              ***** 크기 => 데이터형을 변경 (형변환) => 수 표현법에 따라 달라진다 
 *               byte < short < int < long < float < double
 *                      char 
 *               ============
 *                int이하는 연산처리가 되면 결과값은 int
 *                
 *                byte b1=127;
 *                byte b2=40;
 *                byte b3=b1+b2; // 오류 => 범위를 벗어났다 (int)
 *                
 *                => int b3=b1+b2; ==> 167
 *                   byte b3=(byte)(b1+b2) ==> (X) ==> 39 
 *                                 ======= 167 
 *                   
 *                   128 + 39
 *                         32 + 7 
 *                              =
 *                              4 + 3
 *                                  =
 *                                  2 + 1
 *                                  
 *                   128 64 32 16 8 4 2 1(0)
 *                    1   0  1  0 0 1 1 1
 *                    =====================
 *                    10100111 => 167에 대한 2진법 (byte)
 *                     =======
 *                       32+4+2+1 ==> -89 
 *              
 *            = 참조 자료형 (메모리 주소 저장) ==> 주소(스택) <==> 실제 데이터형(힙)
 *              => 배열 , 클래스 (사용자 정의 데이터형)
 *      
 *            *** 한개씩 => 변수, 셋트 (영화정보,음악정보,맛집...)=>클래스 처리
 *            
 *            ================== 데이터 가공
 *            연산자 / 제어문 
 *            ============
 */
public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(10000000000000L);
		byte b1 = 127;
		byte b2 = 40;
		byte b3 = (byte) (b1 + b2);
		System.out.println(0b10100111);
	}
}