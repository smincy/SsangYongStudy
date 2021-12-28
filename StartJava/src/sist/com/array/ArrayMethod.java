package sist.com.array;

import java.util.Arrays;

// 배열 카피
public class ArrayMethod {

	public void arrayCopyEx1() {

		int[] a = { 10, 20, 30, 40, 50 };
		int[] b = new int[a.length];
		// 복사 (원본, 시작인덱스, 복사대상, 복사대상의 시작인덱스, 실제복사갯수)
		System.arraycopy(a, 1, b, 0, a.length - 1);

		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}

	public void arrayCopyEx2(int[] x) {
		int[] temp = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			temp[i] = x[x.length - (i + 1)];
		}
		// 정렬한 temp 배열을 입력변수의 주소 x 에 카피해주면 메인에 적용
		System.arraycopy(temp, 0, x, 0, temp.length);
	}

	public int[] arrayCopyEx3(int[] x) {
		int[] temp = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			temp[i] = x[x.length - (i + 1)];
		}
		return temp;
	}

	public static void main(String[] args) {
		ArrayMethod a = new ArrayMethod();
		int[] m = { 10, 20, 40, 30, 50 };
		System.out.println(Arrays.toString(m));
		a.arrayCopyEx2(m); // copy를 할 경우 m배열이 계속 바뀐 형태로 사용
		a.arrayCopyEx3(m); // 리턴 받은 배열은 그 장소에서만 사용됨 
		System.out.println(Arrays.toString(m));
		// System.out.println(Arrays.toString(a.arrayCopyEx3(m)));
		a.arrayCopyEx1();
		//System.out.println(Arrays.toString(m));
	}

}
