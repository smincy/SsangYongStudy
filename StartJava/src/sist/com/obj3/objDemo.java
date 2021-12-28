package sist.com.obj3;

// ��� 
public class objDemo {

	public void inheritanceEx1() {
		String s = new String(); // object �� ��������� Ȯ���� �Ǿ� String �� ��������� ����
		Object o = s; // �θ�Ŭ������ �ڼ�Ŭ������ �ִ°�. [UpCast] , s �տ� (Object) �� �����Ǿ� ����
		s = (String) o; // DownCast �θ�Ŭ������ ����Ű�� ���� �ڼ� Ŭ������ ����Ű���� �ٲ� �ִ°��� �ٿ�ĳ��Ʈ ��� �Ѵ�
		System.out.println(s.concat("test"));
	}

	public void inheritanceEx2(Object obj) {
		// main���� ȣ���� ���´� Object obj = new String("abc" �� ���� ����

		if (obj instanceof String) { // instanceof : obj �ڼ�Ŭ������ String �� �ִ°�
			System.out.println(((String) obj).charAt(0));
		} else if (obj instanceof objDemo) {
			((objDemo) obj).inheritanceEx1();
		}

	}

	public Object inheritanceEx3() {
		// String s=(String)new Object();
		// System.out.println(s.charAt(0));
		return "25.5";
	}

	public static void main(String[] args) {
		objDemo o = new objDemo();

		o.inheritanceEx1();
		o.inheritanceEx2(new String("abc"));
		// object�� ��������� Ȯ��Ǿ� String�� ��������� ����Ű�°��� object �� ����

		o.inheritanceEx2(o);
		// object �� ��������� Ȯ��Ǿ� objDemo �� ������� �ְ�, object�� ����Ű�� ����
		// String���� �ٿ�ĳ��Ʈ �ϴ� ���� object 'o' ������ ĳ��Ʈ����
		
		System.out.println(o.inheritanceEx3() instanceof String);
		
	}
}
