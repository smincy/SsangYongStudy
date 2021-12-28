package sist.com.List;

import java.util.*;

// 컬렉션
// 순서가 있고, 데이터 중복 허용
// add(추가), remove(삭제), set(수정), size(크기), clear(초기화), get(읽기)
public class ArrayListEx1 {

	public static void main(String[] args) {
		// 1. ArrayList 객체 생성
		ArrayList<String> List = new ArrayList<String>();

		List.add("홍길동"); // index 는 자동으로 생성 . 0 부터
		List.add("이순신");
		List.add("심청이");
		List.add("유관순");
		List.add("세종대왕");

		System.out.println(List.size());

		List.add(3, "김두한"); // 원하는 위치에 삽입

		System.out.println(List.size());
		System.out.println();
		
		List.set(5, "세종");	// 수정

		for (int i = 0; i < List.size(); i++) {
			String name = List.get(i);
			// 형변환 주의 (<타입>이 없을 경우 더 큰 object형으로 받아오므로 형변환 주의)
			System.out.println(i + " " + name);
		}
		System.out.println();
		
		List.remove(4);
		
		for (int i = 0; i < List.size(); i++) {
			String name = List.get(i);
			System.out.println(i + " " + name);
		}
		System.out.println();
		
		// == 배열에 있는 데이터를 ArrayList로 변경 가능
		String[] name = {"홍길동", "이순신", "강감찬", "을지문덕"};
		List<String> nameList = Arrays.asList(name);
		for (int i = 0; i < List.size(); i++) {
			String ne = List.get(i);
			System.out.println(i + " " + ne);
		}
	}
}
