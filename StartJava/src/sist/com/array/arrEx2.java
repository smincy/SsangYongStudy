package sist.com.array;

public class arrEx2 {

	public int random() {
		int tmp = (int) (Math.random() * 10);
		return tmp;
	}

	public void arrEx1() {
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random();
		}
		dis(arr);
	}

	public int[] arr2() {
		int x = 15;
		int y = 20;
		int z = 25;
		return new int[] { x, y, z };
	}

	public void dis(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		arrEx2 a = new arrEx2();

		a.arrEx1();
		int[] rs = a.arr2();
		for (int i = 0; i < rs.length; i++) {
			System.out.println(a.arr2()[i]);
		}

	}

}
