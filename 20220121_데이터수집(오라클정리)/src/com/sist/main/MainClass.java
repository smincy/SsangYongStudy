package com.sist.main;
// 사용자 요청 메인 클래스 (검색, 목록)

import java.util.*;
import com.sist.dao.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FoodDAO dao = new FoodDAO();

		List<CategoryVO> list = dao.categoryListData();

		for (CategoryVO vo : list) {
			System.out.println(vo.getCno() + ". " + vo.getTitle() + "\t" + vo.getLink());
		}

	}

}
