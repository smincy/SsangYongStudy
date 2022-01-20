package sist.com.server;

import java.io.*;
import java.util.*;

import sist.com.music.Music;

// 클라이언트프로그램 : 내가 가지고있는 파일을 가지고 만드는 프로그램
public class MainClass {

	public static void main(String[] args) {
		// io 가 나왔기 때문에 일단 예외처리
		try {

			// 1. 파일에서 읽어서 메모리에 저장해놓고 제어를 시작
			// 서버에 파일을 저장해 두고, 모든 접속자가 데이터를 공유할 수 있게 만들기

			ArrayList<Music> mList = new ArrayList<Music>();
			// 파일 읽어서 mList 에 저장
			FileInputStream fis = new FileInputStream("C:\\SY\\자료\\java_data\\music_object.txt");

			// 읽은 파일을 객체로 저장 (=역직렬화)
			// 메모리 > 파일 > 오라클 : 제어하기 쉽다 => CURD 프로그램
			// 오라클의 장점으로는 : 여러개의 데이터를 혼합해서 데이터 읽기 가능 >> JOIN, SUBQUERY

			ObjectInputStream ois = new ObjectInputStream(fis); // 파일에 있는 데이터를 객체단위로 받기

			mList = (ArrayList<Music>) ois.readObject();

			// 메모리에 저장된 데이터를 출력
			System.out.println(" = Music Top 200 = ");
			for (Music m : mList) {
				System.out.println(m.getNo() + "." + m.getTitle());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}