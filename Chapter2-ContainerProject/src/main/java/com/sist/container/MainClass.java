package com.sist.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. �����̳� ���
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		// => �Ľ� (XML�� �о ��ϵ� Ŭ������ �޸� �Ҵ��� �Ϸ�

		// 2. ���α׷��� �ʿ��� ��ü�� �� ���
		Sawon s = (Sawon) app.getBean("sa");
		s.setName("ȫ�浿");
		s.setDept("���ߺ�");
		s.setJob("���");

		System.out.println("�̸� : " + s.getName());
		System.out.println("�μ� : " + s.getDept());
		System.out.println("���� : " + s.getJob());

		// 3. ��ü�� ��� �´�
		Sawon s1 = (Sawon) app.getBean("sa");
		s1.setName("��û��");
		s1.setDept("��ȹ��");
		s1.setJob("�븮");

		System.out.println("�̸� : " + s1.getName());
		System.out.println("�μ� : " + s1.getDept());
		System.out.println("���� : " + s1.getJob());

		System.out.println("�̸� : " + s.getName());
		System.out.println("�μ� : " + s.getDept());
		System.out.println("���� : " + s.getJob());

	}

}
