package BaekJoon;
// 스택 연습

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj10828 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // N 개의 정수

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			if (tmp.startsWith("push")) {
				stack.push(Integer.parseInt(tmp.substring(5)));
			} else if (tmp.equals("top")) {
				System.out.println(stack.peek());
			} else if (tmp.equals("size")) {
				System.out.println(stack.size());
			} else if (tmp.equals("empty")) {
				if (stack.empty()) {
					System.out.println(1);
				} else
					System.out.println(0);
			} else if (tmp.equals("pop")) {
				if (stack.empty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
					stack.pop();
				}
				
			}

		}

	}

}
