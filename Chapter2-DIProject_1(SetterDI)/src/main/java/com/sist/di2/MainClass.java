package com.sist.di2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app = new ClassPathXmlApplicationContext("app2.xml");
		Sawon sa = (Sawon) app.getBean("sa");

		GenericXmlApplicationContext app1 = new GenericXmlApplicationContext("app2.xml");

		Sawon sa1 = (Sawon) app1.getBean("sa");
		app1.close();

	}

}
