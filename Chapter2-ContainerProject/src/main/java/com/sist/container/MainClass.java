package com.sist.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 컨테이너 등록
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		// => 파싱 (XML을 읽어서 등록된 클래스의 메모리 할당이 완료

		// 2. 프로그램에 필요한 객체를 얻어서 사용
		Sawon s = (Sawon) app.getBean("sa");
		s.setName("홍길동");
		s.setDept("개발부");
		s.setJob("사원");

		System.out.println("이름 : " + s.getName());
		System.out.println("부서 : " + s.getDept());
		System.out.println("직위 : " + s.getJob());

		// 3. 객체를 얻어 온다
		Sawon s1 = (Sawon) app.getBean("sa");
		s1.setName("심청이");
		s1.setDept("기획부");
		s1.setJob("대리");

		System.out.println("이름 : " + s1.getName());
		System.out.println("부서 : " + s1.getDept());
		System.out.println("직위 : " + s1.getJob());

		System.out.println("이름 : " + s.getName());
		System.out.println("부서 : " + s.getDept());
		System.out.println("직위 : " + s.getJob());

	}

}
