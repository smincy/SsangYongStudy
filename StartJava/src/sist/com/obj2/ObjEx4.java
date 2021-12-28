package sist.com.obj2;

import java.util.Calendar;

//	이름, 나이, 오늘생일, 성별, 지역, 띠, 전화번호

// 클래스에 속성 만들어 놓고, 생성자, get,set 만들어보고
// 데이터를 위클래스에 보내줌
// 데이터 꺼내기 가능..

public class ObjEx4 {
	String[] data = { "주석영#881210-1010547#031)457-1280", "장태훈#981202-1012947#02)457-1980",
			"최은영#990210-2010547#061)957-1280", "김인수#580510-1010547#02)657-1280" };

	final int Today = 1202;
	String[] str = { "원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양" };

	Man[] man = new Man[data.length]; // Man 클래스

	public void stringProcess() {
		for (int i = 0; i < data.length; i++) {
			String[] tmp = data[i].split("#");
			man[i] = new Man(); // index 마다의 객체를 생성
			for (int j = 0; j < tmp.length; j++) {
				switch (j) {
				case 0:
					man[i].setName(tmp[j]);
					break;
				case 1:
					// 나이
					man[i].setAge((Calendar.getInstance().get(Calendar.YEAR)
							- (Integer.parseInt(tmp[j].substring(0, 2)) + 1900)) + 1);
					// 생일
					System.out.println(tmp[j].substring(2, 6));
					String month = String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1); // MONTH 는 '월' 표시 ,
																									// int형을 string 형으로

					int number = Calendar.getInstance().get(Calendar.DATE); // DATE는 '일' 표시 , concat() : 두 문자열 붙여줌
					String day = String.valueOf(
							number >= 0 && number <= 9 ? "0".concat(String.valueOf(number)) : String.valueOf(number));
					// 0~9 사이 '일' 이면 0 붙여주기
					// 아니라면 그냥 string으로 변환
					System.out.println(month.concat(day));

					if (Integer.parseInt(tmp[j].substring(2, 6)) == Today) {
						man[i].setBrith(true);
					}
					// 성별
					if (tmp[j].charAt(7) == '2') {
						man[i].setZender("Woman");
					} else {
						man[i].setZender("Man");
					}
					// 띠

					man[i].setDdi(str[(Integer.parseInt(tmp[j].substring(0, 2)) + 1900) % 12]);

					break;
				case 2:
					// 지역
					System.out.println(tmp[j].substring(0, tmp[j].indexOf(")")));
					if (tmp[j].charAt(1) == '2') { // 2자리, 3자리 번호 각각 입력,확인 하는 방법... / 기호 전까지 확인 indexOf(")")
						man[i].setLocation("서울");
					} else if (tmp[j].charAt(1) == '3' && tmp[j].charAt(2) == '1') {
						man[i].setLocation("경기");
					} else if (tmp[j].charAt(1) == '6' && tmp[j].charAt(2) == '1') {
						man[i].setLocation("제주");
					}
					// Tel
					man[i].setTel(tmp[j]);
					break;
				}
			}
		}
		disp();
	}

	public void disp() {
		for (Man i : man) {
			System.out.println(i.toString());
		}
	}

	public static void main(String[] args) {
		ObjEx4 o = new ObjEx4();
		o.stringProcess();
	}
}
