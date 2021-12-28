package sist.com.obj2;

public class ObjEx3 {// scope
	private String value;
	private static String maker = "Oralce";

	public ObjEx3(String value) {
		this.value = value;
		// this.maker="Sun";
	}

	public void setMaker(String maker) {
		ObjEx3.maker = maker;
	}

	public static String getMaker() {
		return ObjEx3.maker;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static void main(String[] args) {
		ObjEx3 o1 = new ObjEx3("A");// value(A)
		ObjEx3 o2 = new ObjEx3("B");// value(Xml)
		o1.setMaker("Ms");
		System.out.println(o2.getMaker());

	}
}