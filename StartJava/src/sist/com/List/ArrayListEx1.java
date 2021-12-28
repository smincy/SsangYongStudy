package sist.com.List;

import java.util.*;

// �÷���
// ������ �ְ�, ������ �ߺ� ���
// add(�߰�), remove(����), set(����), size(ũ��), clear(�ʱ�ȭ), get(�б�)
public class ArrayListEx1 {

	public static void main(String[] args) {
		// 1. ArrayList ��ü ����
		ArrayList<String> List = new ArrayList<String>();

		List.add("ȫ�浿"); // index �� �ڵ����� ���� . 0 ����
		List.add("�̼���");
		List.add("��û��");
		List.add("������");
		List.add("�������");

		System.out.println(List.size());

		List.add(3, "�����"); // ���ϴ� ��ġ�� ����

		System.out.println(List.size());
		System.out.println();
		
		List.set(5, "����");	// ����

		for (int i = 0; i < List.size(); i++) {
			String name = List.get(i);
			// ����ȯ ���� (<Ÿ��>�� ���� ��� �� ū object������ �޾ƿ��Ƿ� ����ȯ ����)
			System.out.println(i + " " + name);
		}
		System.out.println();
		
		List.remove(4);
		
		for (int i = 0; i < List.size(); i++) {
			String name = List.get(i);
			System.out.println(i + " " + name);
		}
		System.out.println();
		
		// == �迭�� �ִ� �����͸� ArrayList�� ���� ����
		String[] name = {"ȫ�浿", "�̼���", "������", "��������"};
		List<String> nameList = Arrays.asList(name);
		for (int i = 0; i < List.size(); i++) {
			String ne = List.get(i);
			System.out.println(i + " " + ne);
		}
	}
}
