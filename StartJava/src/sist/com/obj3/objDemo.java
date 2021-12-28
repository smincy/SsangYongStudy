package sist.com.obj3;

// 상속 
public class objDemo {

	public void inheritanceEx1() {
		String s = new String(); // object 가 만들어지고 확장이 되어 String 이 만들어지는 구조
		Object o = s; // 부모클래스에 자손클래스를 넣는것. [UpCast] , s 앞에 (Object) 가 생략되어 있음
		s = (String) o; // DownCast 부모클래스를 가리키는 것을 자손 클래스를 가리키도록 바꿔 주는것을 다운캐스트 라고 한다
		System.out.println(s.concat("test"));
	}

	public void inheritanceEx2(Object obj) {
		// main에서 호출은 형태는 Object obj = new String("abc" 과 같은 형태

		if (obj instanceof String) { // instanceof : obj 자손클래스로 String 이 있는가
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
		// object가 만들어지고 확장되어 String이 만들어지고 가리키는것은 object 인 상태

		o.inheritanceEx2(o);
		// object 가 만들어지고 확장되어 objDemo 가 만들어져 있고, object를 가리키는 상태
		// String으로 다운캐스트 하는 곳에 object 'o' 넣으면 캐스트에러
		
		System.out.println(o.inheritanceEx3() instanceof String);
		
	}
}
