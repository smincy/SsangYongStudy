package sist.com.array;
// ArrayList ����
import java.util.ArrayList;
import java.util.Scanner;

public class arrEx6 {

	ArrayList<Integer> AL = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void input() {
		while (true) {
			System.out.println("1.�Է� 2.��� 3.Size 4.����");
			int t = sc.nextInt();
			if (t == 1) {
				System.out.println("�Է� : ");
				AL.add(sc.nextInt());
			} else if (t == 2) {
				System.out.println("���");
				System.out.println(AL);
			} else if (t == 3) {
				System.out.println("Size : " + AL.size());
				
			} else {
				System.out.println("����Ǿ����ϴ�.");
				break;
			}
		}

	}

	public static void main(String[] args) {

		arrEx6 a = new arrEx6();
		a.input();

	}

}
