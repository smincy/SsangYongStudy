package sist.com.array;

import java.util.Arrays;

// �迭 ī��
public class ArrayMethod {

	public void arrayCopyEx1() {

		int[] a = { 10, 20, 30, 40, 50 };
		int[] b = new int[a.length];
		// ���� (����, �����ε���, ������, �������� �����ε���, �������簹��)
		System.arraycopy(a, 1, b, 0, a.length - 1);

		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}

	public void arrayCopyEx2(int[] x) {
		int[] temp = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			temp[i] = x[x.length - (i + 1)];
		}
		// ������ temp �迭�� �Էº����� �ּ� x �� ī�����ָ� ���ο� ����
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
		a.arrayCopyEx2(m); // copy�� �� ��� m�迭�� ��� �ٲ� ���·� ���
		a.arrayCopyEx3(m); // ���� ���� �迭�� �� ��ҿ����� ���� 
		System.out.println(Arrays.toString(m));
		// System.out.println(Arrays.toString(a.arrayCopyEx3(m)));
		a.arrayCopyEx1();
		//System.out.println(Arrays.toString(m));
	}

}
