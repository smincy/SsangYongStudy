package com.sist.container5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(
				com.sist.container5.SawonConfig.class);

		Sawon sa = (Sawon) app.getBean("sa");
		// Sawon sa = app.getBean("sa", Sawon.class) => 같은 코드, 다른 방식

		sa.setName("박문수");
		sa.setDept("개발부");
		sa.setLoc("서울");

		System.out.println(sa.getName());
		System.out.println(sa.getDept());
		System.out.println(sa.getLoc());

		Sawon sa1 = (Sawon) app.getBean("sa");
		// Sawon sa = app.getBean("sa", Sawon.class) => 같은 코드, 다른 방식

		sa1.setName("이순신");
		sa1.setDept("총무부");
		sa1.setLoc("부산");

		System.out.println(sa1.getName());
		System.out.println(sa1.getDept());
		System.out.println(sa1.getLoc());

		System.out.println(sa.getName());
		System.out.println(sa.getDept());
		System.out.println(sa.getLoc());

	}

}
