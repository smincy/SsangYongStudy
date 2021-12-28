package sist.com.IO_211224;

// FileReader / FileWriter  => �ѱ��� �ִ� �����͸� �аų�, ���Ͽ� ������ �� (���� ��� ��Ʈ��) 
import java.io.*;
import java.util.*;

class Member {
	private int no;
	private String name;
	private String sex;
	private String addr;
	private String tel;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Member(int no, String name, String sex, String addr, String tel) {
		super();
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.addr = addr;
		this.tel = tel;
	}

}

public class IO_Ex2 {

	public static void main(String[] args) {

		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member(1, "ȫ�浿", "����", "����", "010-1111-1111"));
		list.add(new Member(2, "�̼���", "����", "���", "010-2222-1211"));
		list.add(new Member(3, "��û��", "����", "�뱸", "010-3333-1311"));
		list.add(new Member(4, "ö��", "����", "�λ�", "010-4444-1141"));

		try {

			StringBuffer sb = new StringBuffer();
			File file = new File("C:\\SY\\�ڷ�\\java_data\\address.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file); // ���Ͽ� ����
			for (Member m : list) {
				String data = m.getNo() + "|" + m.getName() + "|" + m.getSex() + "|" + m.getAddr() + "|" + m.getTel()
						+ "\n";

				sb.append(data);
			}

			// ���Ͽ� ����
			fw.write(sb.toString()); // sb �� ����� ��� �����͸� ���(����/����)
			fw.close();
			System.out.println("��� ���� �Ϸ�");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
