package com.sist.di2;
import java.util.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(LocationConfig.class);
		LocationDAO dao = (LocationDAO) app.getBean("dao");
		
		List<LocationVO> list = dao.locationListData();
		for (LocationVO vo : list) {
			System.out.println(vo.getTitle());
		}
		
		
	}
}
