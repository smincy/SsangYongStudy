package sist.package2;

import sist.package1.Super;

public class instanceClass {

	public void action() {
		
		Super s = new Super();
		// ��Ű��1 �� publicData ���� ����
		s.publicData = 10;
		
		// default ���������ڴ� ��Ű���� �ٸ� ��� ������ �� ����
		// �����ڵ� ���� >> super() �⺻������ ����* (public, protected �� ���� �����ϵ��� ����� ��)
	}

}
