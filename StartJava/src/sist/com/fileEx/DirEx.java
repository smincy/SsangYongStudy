package sist.com.fileEx;

// 21.12.23
import java.io.*;
import java.util.*;
public class DirEx {
// 폴더 정보 => 폴더 모든 파일 읽기

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			File dir = new File("C:\\SY\\자료");
			System.out.println(dir.getName());
			System.out.println(dir.getPath());
			System.out.println(dir.length());
			System.out.println(dir.lastModified());

			System.out.println("==== 돌더 안에 있는 모든 파일 읽기 ====");

			File[] files = dir.listFiles();

			HashSet<String> set = new HashSet<String>();

			for (File f : files) {
				if (f.isFile()) { // 파일 인 경우에만 출력
					System.out.println(f.getName());

					String name = f.getName();
					String ext = name.substring(name.lastIndexOf(".") + 1); // . 이후부터 출력
					System.out.println(ext);
					set.add(ext);
				}
			}

			// 중복이 없는 확장자를 출력 => HashSet 사용 (중복제거)
			System.out.println("=== 중복 없는 확장자 출력 ===");
			for (String s : set) {
				System.out.println(s);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
