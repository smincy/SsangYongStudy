package sist.com.array;
// 최대값, 최소값, 평균, 근사값, 평균이상개수 

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
		int cn = 0; // 최빈값
		
		
		return cn;
	}
	
	public void dis(int arr[]) {
		// 최대값
		System.out.println("최대값 = " + max(arr));

		// 최소값
		System.out.println("최소값 = " + min(arr));

		// 평균값
		System.out.println("평균값 = " + avg(arr));

		// 평균 기준 근사값
		System.out.println("평균근사값 = " + mate(arr));

		// 평균이상개수
		System.out.println("평균 이상 개수 = " + cnt(arr));
	}

	public static void main(String[] args) {

		arrEx3 a = new arrEx3();

		int[] temp = { 95, 100, 27, 54, 45 };
		a.dis(temp);
		// 최대, 최소, 근사, 평균, 평균이상개수

	}
}
