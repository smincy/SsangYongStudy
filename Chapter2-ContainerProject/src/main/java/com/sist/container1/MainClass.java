package com.sist.container1;

public class MainClass {

	public static void main(String[] args) {
		String path = "C:\\springDev\\springStudy\\Chapter2-ContainerProject\\src\\main\\java";

		ApplicationContext app = new ApplicationContext(path);

		Sawon sa = (Sawon) app.getBean("sa");
		sa.setName("�ڹ���");
		sa.setDept("������");
		sa.setJob("���");

		System.out.println(sa.getName());
		System.out.println(sa.getDept());
		System.out.println(sa.getJob());

	}

}
