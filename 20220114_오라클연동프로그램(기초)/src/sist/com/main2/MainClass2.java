package sist.com.main2;

import java.util.*;

public class MainClass2 {

	public static void main(String[] args) {
		ZipcodeDAO dao = new ZipcodeDAO();

		Scanner sc = new Scanner(System.in);

		System.out.print("�� �Է� : ");
		String dong = sc.next();

		int count = dao.zipcodeFindCount(dong);
		List<Zipcode> list = dao.zipcodeListData(dong);

		if (count == 0) {
			System.out.println(" �˻� ��� ���� ");
		} else {
			System.out.println(" �˻���� : " + count + " �� ");
			for (Zipcode z : list) {
				System.out.println(z.getZipcode() + " " + z.getAddress());
			}
		}

	}
}
