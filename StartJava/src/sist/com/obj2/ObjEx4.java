package sist.com.obj2;

import java.util.Calendar;

//	�̸�, ����, ���û���, ����, ����, ��, ��ȭ��ȣ

// Ŭ������ �Ӽ� ����� ����, ������, get,set ������
// �����͸� ��Ŭ������ ������
// ������ ������ ����..

public class ObjEx4 {
	String[] data = { "�ּ���#881210-1010547#031)457-1280", "������#981202-1012947#02)457-1980",
			"������#990210-2010547#061)957-1280", "���μ�#580510-1010547#02)657-1280" };

	final int Today = 1202;
	String[] str = { "������", "��", "��", "����", "��", "��", "ȣ����", "�䳢", "��", "��", "��", "��" };

	Man[] man = new Man[data.length]; // Man Ŭ����

	public void stringProcess() {
		for (int i = 0; i < data.length; i++) {
			String[] tmp = data[i].split("#");
			man[i] = new Man(); // index ������ ��ü�� ����
			for (int j = 0; j < tmp.length; j++) {
				switch (j) {
				case 0:
					man[i].setName(tmp[j]);
					break;
				case 1:
					// ����
					man[i].setAge((Calendar.getInstance().get(Calendar.YEAR)
							- (Integer.parseInt(tmp[j].substring(0, 2)) + 1900)) + 1);
					// ����
					System.out.println(tmp[j].substring(2, 6));
					String month = String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1); // MONTH �� '��' ǥ�� ,
																									// int���� string ������

					int number = Calendar.getInstance().get(Calendar.DATE); // DATE�� '��' ǥ�� , concat() : �� ���ڿ� �ٿ���
					String day = String.valueOf(
							number >= 0 && number <= 9 ? "0".concat(String.valueOf(number)) : String.valueOf(number));
					// 0~9 ���� '��' �̸� 0 �ٿ��ֱ�
					// �ƴ϶�� �׳� string���� ��ȯ
					System.out.println(month.concat(day));

					if (Integer.parseInt(tmp[j].substring(2, 6)) == Today) {
						man[i].setBrith(true);
					}
					// ����
					if (tmp[j].charAt(7) == '2') {
						man[i].setZender("Woman");
					} else {
						man[i].setZender("Man");
					}
					// ��

					man[i].setDdi(str[(Integer.parseInt(tmp[j].substring(0, 2)) + 1900) % 12]);

					break;
				case 2:
					// ����
					System.out.println(tmp[j].substring(0, tmp[j].indexOf(")")));
					if (tmp[j].charAt(1) == '2') { // 2�ڸ�, 3�ڸ� ��ȣ ���� �Է�,Ȯ�� �ϴ� ���... / ��ȣ ������ Ȯ�� indexOf(")")
						man[i].setLocation("����");
					} else if (tmp[j].charAt(1) == '3' && tmp[j].charAt(2) == '1') {
						man[i].setLocation("���");
					} else if (tmp[j].charAt(1) == '6' && tmp[j].charAt(2) == '1') {
						man[i].setLocation("����");
					}
					// Tel
					man[i].setTel(tmp[j]);
					break;
				}
			}
		}
		disp();
	}

	public void disp() {
		for (Man i : man) {
			System.out.println(i.toString());
		}
	}

	public static void main(String[] args) {
		ObjEx4 o = new ObjEx4();
		o.stringProcess();
	}
}
