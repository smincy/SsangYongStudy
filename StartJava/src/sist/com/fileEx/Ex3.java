package sist.com.fileEx;
// 21.12.23

import java.util.*;
import java.io.*;

// 파일, 폴더 제어 (만들기, 삭제)
// 파일 입출력

public class Ex3 {

	public static void main(String[] args) {
		try {

			File dir = new File("C:\\SY\\자료\\Down");
			// 폴더의 유무 먼저 확인
			if (!dir.exists()) { // 존재하냐/ !붙이면 존재하지않으면
				dir.mkdir(); // 폴더를 만든다
				System.out.println("폴더 생성 완료");
			}

			File file = new File("C:\\SY\\자료\\Down\\food.txt");
			if (!file.exists()) { // 파일이 없으면
				file.createNewFile(); // 파일 만들기
				System.out.println("파일 생성 완료");
			}

			// 삭제
			file.delete();
			System.out.println("파일 삭제 완료");
			dir.delete();
			System.out.println("폴더 삭제 완료");

		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

}
