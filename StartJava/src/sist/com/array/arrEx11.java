package sist.com.array;

import java.util.Arrays;

// 1차 배열 search, delete, modify(update), 
public class arrEx11 {

	public boolean[] search(int[] a, int b) {
		boolean[] search = new boolean[a.length];

		for (int i = 0; i < search.length; i++) {
			if (a[i] == b) {
				search[i] = true;
			} else {
				search[i] = false;
			}
		}
		return search;
	}

	public void delete(int[] a, int b) {
		// a : 대상 배열 , b : 지울 타겟
		int[] tmp = new int[a.length];
		boolean[] stm = search(a, b);
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (stm[i] == true) {
				if (index == 0) {
					for (int j = 0; j < i; j++) {
						tmp[j] = a[j];
						index = i + 1;
					}
				} else {
					for (int j = index; j < i; j++) {
						tmp[j] = a[j + 1];
					}
				}
				for (int j = i; j < stm.length - 1; j++) {
					tmp[j] = a[j + 1];
				}
			}
		}

		System.arraycopy(tmp, 0, a, 0, tmp.length);
		// 제대로 삭제 되었는지 한번 더 확인
		for (int i = 0; i < a.length; i++) {
			if (a[i] == b) {
				delete(a, b);
			}
		}
	}

	public static void main(String[] args) {
		arrEx11 a = new arrEx11();
		int[] m = { 45, 95, 33, 40, 95 };
		System.out.println(Arrays.toString(a.search(m, 95)));
		a.delete(m, 95);

		for (int i = 0; i < m.length; i++) {
			System.out.print(m[i] + " ");
		}
	}
}
