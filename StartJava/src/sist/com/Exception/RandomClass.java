package sist.com.Exception;

// ChoiceFormat »ç¿ë
import java.text.ChoiceFormat;
import java.util.*;

public class RandomClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] hak = { 50, 60, 70, 80, 90 };
		int[] student = new int[10];

		Random r = new Random();
		for (int i = 0; i < student.length; i++) {
			student[i] = r.nextInt(51) + 50;
		}

		for (int i = 0; i < student.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		String[] score = { "F", "D", "C", "B", "A" };

		ChoiceFormat cf = new ChoiceFormat(hak, score);

		for (int i = 0; i < student.length; i++) {
			System.out.println(student[i] + " " + cf.format(student[i]));
		}
	}

}
