package sist.com.server;

import java.io.*;
import java.util.*;

import sist.com.music.Music;
// Ŭ���̾�Ʈ���α׷� : ���� �������ִ� ������ ������ ����� ���α׷�
public class MainClass {

	public static void main(String[] args) {
		// io �� ���Ա� ������ �ϴ� ����ó��
		try {

			// 1. ���Ͽ��� �о �޸𸮿� �����س��� ��� ����
			// ������ ������ ������ �ΰ�, ��� �����ڰ� �����͸� ������ �� �ְ� �����

			ArrayList<Music> mList = new ArrayList<Music>();
			// ���� �о mList �� ����
			FileInputStream fis = new FileInputStream("C:\\SY\\�ڷ�\\java_data\\music_object.txt");

			// ���� ������ ��ü�� ���� (=������ȭ)
			// �޸� > ���� > ����Ŭ : �����ϱ� ���� => CURD ���α׷�
			// ����Ŭ�� �������δ� : �������� �����͸� ȥ���ؼ� ������ �б� ���� >> JOIN, SUBQUERY

			ObjectInputStream ois = new ObjectInputStream(fis); // ���Ͽ� �ִ� �����͸� ��ü������ �ޱ�

			mList = (ArrayList<Music>) ois.readObject();
			
			// �޸𸮿� ����� �����͸� ���
			System.out.println(" = Music Top 200 = ");
			for (Music m : mList) {
				System.out.println(m.getNo() + "." + m.getTitle());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
