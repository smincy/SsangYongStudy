package sist.package2;

import sist.package1.Super;

public class Sub extends Super {
	public Sub() {
		// 패키지1 의 publicData 접근 가능
		this.publicData = 10;

	}

}
