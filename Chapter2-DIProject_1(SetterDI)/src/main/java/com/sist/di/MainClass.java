package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");

		// ����� ��ü�� ��� �´�
		Sawon sa = (Sawon) app.getBean("sa");

		System.out.println(sa.getName());
		System.out.println(sa.getDept());
		System.out.println(sa.getJob());
		System.out.println(sa.getAge());
		System.out.println(sa.getPay());

	}

}
