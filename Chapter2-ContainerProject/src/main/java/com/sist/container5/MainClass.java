package com.sist.container5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(
				com.sist.container5.SawonConfig.class);

		Sawon sa = (Sawon) app.getBean("sa");
		// Sawon sa = app.getBean("sa", Sawon.class) => ���� �ڵ�, �ٸ� ���

		sa.setName("�ڹ���");
		sa.setDept("���ߺ�");
		sa.setLoc("����");

		System.out.println(sa.getName());
		System.out.println(sa.getDept());
		System.out.println(sa.getLoc());

		Sawon sa1 = (Sawon) app.getBean("sa");
		// Sawon sa = app.getBean("sa", Sawon.class) => ���� �ڵ�, �ٸ� ���

		sa1.setName("�̼���");
		sa1.setDept("�ѹ���");
		sa1.setLoc("�λ�");

		System.out.println(sa1.getName());
		System.out.println(sa1.getDept());
		System.out.println(sa1.getLoc());

		System.out.println(sa.getName());
		System.out.println(sa.getDept());
		System.out.println(sa.getLoc());

	}

}
