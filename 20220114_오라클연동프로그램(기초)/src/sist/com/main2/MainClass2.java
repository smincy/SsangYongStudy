package sist.com.main2;

import java.util.*;

public class MainClass2 {

	public static void main(String[] args) {
		ZipcodeDAO dao = new ZipcodeDAO();

		Scanner sc = new Scanner(System.in);

		System.out.print("동 입력 : ");
		String dong = sc.next();

		int count = dao.zipcodeFindCount(dong);
		List<Zipcode> list = dao.zipcodeListData(dong);

		if (count == 0) {
			System.out.println(" 검색 결과 없음 ");
		} else {
			System.out.println(" 검색결과 : " + count + " 건 ");
			for (Zipcode z : list) {
				System.out.println(z.getZipcode() + " " + z.getAddress());
			}
		}

	}
}
