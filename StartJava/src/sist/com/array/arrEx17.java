package sist.com.array;

// 1��, ������, �����迭
public class arrEx17 {

	public void arrEx(char[] x) {
		System.out.println((x[0]));
	}

	public void arrEx2(char[][] x) {
		for (char[] cs : x) {
			System.out.println(cs.length); // �����迭 ������
		}
	}

	public void arrEx3() {
		int[][] m = { new int[9], new int[2], new int[8], new int[1] };
		for (int[] i : m) {
			for (int j : i) {
				System.out.printf("%5d", j);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		arrEx17 a = new arrEx17();

		String s1 = "Ajax";
		String s2 = "SpringData";
		String s3 = "HtmlReAct";

		// a.arrEx(s1.toCharArray()); // ���ڿ��� �ɰ��� char �迭�� �Է�
		// a.arrEx2(new char[][] { s1.toCharArray(), s2.toCharArray(), s3.toCharArray()
		// });
		a.arrEx3();
	}

}
