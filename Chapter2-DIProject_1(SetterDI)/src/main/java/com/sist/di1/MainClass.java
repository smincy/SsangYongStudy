package com.sist.di1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app1.xml");

		Sawon s1 = (Sawon) app.getBean("s1");
		s1.display();
		System.out.println();
		Sawon s2 = (Sawon) app.getBean("s2");
		s2.display();
		System.out.println();
		Sawon s3 = (Sawon) app.getBean("s3");
		s3.display();
		System.out.println();
		Sawon s4 = (Sawon) app.getBean("s4");
		s4.display();
	}

}
