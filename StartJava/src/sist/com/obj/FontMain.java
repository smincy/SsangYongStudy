package sist.com.obj;

public class FontMain {
	static String nation;
	
	public static void main(String[] args) {
		//new Font().fontFace = "����"; 
		// private �̶� ���� �Ұ�
		// �޼ҵ带 �̿��Ͽ� ������ �� ����
		
		new Font().nation = "����";
		
		// static�� ���� Class ���� static �����̶� [�ּ�.nation]�� �̿��ؾ� ��
		// 'Ŭ�����̸�' �� �� �ּ�. ���� [Ŭ�����̸�.nation]
		nation = "�찣��";	
		// �̷��� ���� ��� FontMain Ŭ������ ������ 'nation'�� ��
		
		
		
		System.out.println(Integer.MAX_VALUE);
		// Integer �� Ŭ�����̸�
		// MAX_VALUE �� �����̸� (static + final)
		System.out.println(nation);
		System.out.println(new Font().nation);
		Font f = new Font();
		f.Face("�ü�");
		f.dis();

	}
}
