package sist.com.array;
// ArrayList 연습
import java.util.ArrayList;
import java.util.Scanner;

public class arrEx6 {

	ArrayList<Integer> AL = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void input() {
		while (true) {
			System.out.println("1.입렵 2.출력 3.Size 4.종료");
			int t = sc.nextInt();
			if (t == 1) {
				System.out.println("입력 : ");
				AL.add(sc.nextInt());
			} else if (t == 2) {
				System.out.println("출력");
				System.out.println(AL);
			} else if (t == 3) {
				System.out.println("Size : " + AL.size());
				
			} else {
				System.out.println("종료되었습니다.");
				break;
			}
		}

	}

	public static void main(String[] args) {

		arrEx6 a = new arrEx6();
		a.input();

	}

}
