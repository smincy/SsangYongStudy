package sist.com.array;
// �ִ밪, �ּҰ�, ���, �ٻ簪, ����̻󰳼� 

public class arrEx3 {

	public int max(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public int min(int[] arr) {
		int min = 100000;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public int avg(int[] arr) {
		int avg = 0;
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {
			tmp += arr[i];
		}
		avg = tmp / arr.length;
		return avg;
	}

	public int cnt(int[] arr) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (avg(arr) < arr[i]) {
				cnt++;
			}
		}
		return cnt;
	}

	public int mate(int[] arr) {
		int max = 100000;
		int tmp = 0;
		int mate = 0;
		for (int i = 0; i < arr.length; i++) {
			tmp = arr[i] - avg(arr);
			if (tmp < 0) {
				tmp = tmp * (-1);
			}
			if (max > tmp) {
				max = tmp;
				mate = arr[i];
			}
		}
		return mate;
	}
	
	public int cnt() {
		int cn = 0; // �ֺ�
		
		
		return cn;
	}
	
	public void dis(int arr[]) {
		// �ִ밪
		System.out.println("�ִ밪 = " + max(arr));

		// �ּҰ�
		System.out.println("�ּҰ� = " + min(arr));

		// ��հ�
		System.out.println("��հ� = " + avg(arr));

		// ��� ���� �ٻ簪
		System.out.println("��ձٻ簪 = " + mate(arr));

		// ����̻󰳼�
		System.out.println("��� �̻� ���� = " + cnt(arr));
	}

	public static void main(String[] args) {

		arrEx3 a = new arrEx3();

		int[] temp = { 95, 100, 27, 54, 45 };
		a.dis(temp);
		// �ִ�, �ּ�, �ٻ�, ���, ����̻󰳼�

	}
}
