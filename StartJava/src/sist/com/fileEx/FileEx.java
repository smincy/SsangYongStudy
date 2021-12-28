package sist.com.fileEx;

// 21.12.23
import java.io.*;
import java.util.*;
import java.text.*;

public class FileEx {
	public static void main(String[] args) {

		try {
			// 1. 파일 가지고 오기				***
			File file = new File("C:\\SY\\자료\\movie.txt");

			// 1-1. 파일 이름 읽기				***
			System.out.println("파일명 : " + file.getName());

			// 1-2. 경로를 포함해서 읽기			***
			System.out.println("경로포함 : " + file.getPath());

			// 1-3. 경로명 읽기
			System.out.println("경로 : " + file.getParent());

			// 1-4. 수정한 날짜 확인
			System.out.println("수정일 : " + file.lastModified()); // long형으로 출력

			Date d = new Date(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println(sdf.format(d)); // 변환 한 날짜 출력

			// 1-5. 파일의 크기 확인				***
			System.out.println("파일 크기 : " + file.length() + " Bytes");
			String tmp = file.length() > 1024 ? (file.length() / 1024) + "KB" : (file.length()) + "Bytes";
			System.out.println("파일 크기 : " + tmp);

			// 1-6. 특성 => 읽기전용,숨김파일,쓰기전용
			System.out.println("숨김파일 : " + file.isHidden());
			System.out.println("읽기전용 : " + file.canRead());
			System.out.println("쓰기전용 : " + file.canWrite());

			// 1-7. 파일인지 디렉토리인지 확인		***
			System.out.println("파일여부 : " + file.isFile());
			System.out.println("디렉토리여부 : " + file.isDirectory());

			// 1-8. 절대경로
			System.out.println("절대경로 : " + file.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
