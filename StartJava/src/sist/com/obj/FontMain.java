package sist.com.obj;

public class FontMain {
	static String nation;
	
	public static void main(String[] args) {
		//new Font().fontFace = "굴림"; 
		// private 이라서 접근 불가
		// 메소드를 이용하여 접근할 수 있음
		
		new Font().nation = "내수";
		
		// static은 같은 Class 내에 static 영역이라 [주소.nation]을 이용해야 함
		// '클래스이름' 이 곧 주소. 따라서 [클래스이름.nation]
		nation = "우간다";	
		// 이렇게 넣을 경우 FontMain 클래스에 생성된 'nation'에 들어감
		
		
		
		System.out.println(Integer.MAX_VALUE);
		// Integer 가 클래스이름
		// MAX_VALUE 가 변수이름 (static + final)
		System.out.println(nation);
		System.out.println(new Font().nation);
		Font f = new Font();
		f.Face("궁서");
		f.dis();

	}
}
