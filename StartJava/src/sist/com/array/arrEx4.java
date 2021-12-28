package sist.com.array;

public class arrEx4 {
	public String[] add() {

		return "A B CD EF".split(" ");
	}

	public static void main(String[] args) {
		arrEx4 a = new arrEx4();
		String[] tmp = a.add();

		for (int i = 0; i < tmp.length; i++) {
			System.out.println(tmp[i]);
		}

		System.out.println(a.add(0)[1]);

	}
	
	// 아래부터 강사님 코드
	public String[] add(int x) {
		System.out.println("A b# c".split("#")[x]);
		return "Ajax Value Data".split(" ");
	}
	public void add(double x) {
	}
	public void add(String x) {
	}
	public void add(int [] x) {
	}
	
}