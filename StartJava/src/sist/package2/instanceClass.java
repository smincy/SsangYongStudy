package sist.package2;

import sist.package1.Super;

public class instanceClass {

	public void action() {
		
		Super s = new Super();
		// 패키지1 의 publicData 접근 가능
		s.publicData = 10;
		
		// default 접근제어자는 패키지가 다를 경우 접근할 수 없음
		// 생성자도 포함 >> super() 기본생성자 주의* (public, protected 로 접근 가능하도록 해줘야 함)
	}

}
