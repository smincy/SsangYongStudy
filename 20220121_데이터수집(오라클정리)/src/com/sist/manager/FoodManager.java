package com.sist.manager;

import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.*;

public class FoodManager {

	public static void main(String[] args) {
		FoodManager m = new FoodManager();
		m.foodWebData();
	}

	public void foodWebData() {
		try {
			// 오라클에 있는 link 데이터 읽기
			FoodDAO dao = new FoodDAO();
			List<CategoryVO> list = dao.categoryListData();
			FoodHouseVO fvo = new FoodHouseVO();

			for (CategoryVO vo : list) {
				System.out.println("======== " + vo.getTitle() + " ========");
				// 웹 연결 => 데이터를 읽어 온다
				Document doc = Jsoup.connect(vo.getLink()).get();

				Elements link = doc.select("span.title a");
				
				fvo.setCno(vo.getCno());
				
				for (int i = 0; i < link.size(); i++) {
					// System.out.println((i + 1) + ". " + link.get(i).attr("href"));
					Document doc2 = Jsoup.connect("https://www.mangoplate.com"
								+ link.get(i).attr("href")).get();
					Elements poster = doc2.select("figure.restaurant-photos-item img.center-croping");

					String img = "";

					for (int j = 0; j < poster.size(); j++) {
						System.out.println(poster.get(j).attr("src"));
						img += poster.get(j).attr("src") + "^";
					}
					img = img.substring(0, img.lastIndexOf("^"));
					img = img.replace("&", "#");
					
					fvo.setPoster(img);
					
					/*
					 * 	<img src = "aaa"> => attr 
					 * 	<td> aaa </td> => text
					 */

					Element name = doc2.selectFirst("span.title h1.restaurant_name");
					System.out.println(name.text());
					fvo.setName(name.text());

					Element score = doc2.selectFirst("strong.rate-point span");
					System.out.println(score.text());
					fvo.setScore(Double.parseDouble(score.text().trim()));

					Element address = doc2.select("tr.only-desktop td").get(0);
					System.out.println(address.text());
					fvo.setAddress(address.text());
					
					try {
						Element tel = doc2.select("tr.only-desktop td").get(1);
						System.out.println(tel.text());
						fvo.setTel(tel.text());
					} catch (Exception e) {
						System.out.println("전화번호 없음");
						fvo.setTel("no");
					}

					try {
						Element type = doc2.select("table.info tr td span").get(2);
						System.out.println(type.text());
						fvo.setType(type.text());
					} catch (Exception e) {
						System.out.println("등록된 음식 종류 없음");
						fvo.setType("no");
					}

					try {
						Element price = doc2.select("table.info tr td").get(3);
						System.out.println(price.text());
						fvo.setPrice(price.text());
					} catch (Exception e) {
						System.out.println("가격대 미등록");
						fvo.setPrice("no");
					}

					try {
						Element parking = doc2.select("table.info tr td").get(4);
						System.out.println(parking.text());
						fvo.setParking(parking.text());
					} catch (Exception e) {
						System.out.println("주차 미등록");
						fvo.setParking("no");
					}

					try {
						Element time = doc2.select("table.info tr td").get(5);
						System.out.println(time.text());
						fvo.setTime(time.text());
					} catch (Exception e) {
						System.out.println("영업시간 미등록");
						fvo.setTime("no");
					}

					try {
						Element menu = doc2.selectFirst("table.info td.menu_td");
						System.out.println(menu.text());
						fvo.setTime(menu.text());
					} catch (Exception e) {
						System.out.println("메뉴 미등록");
						fvo.setTime("no");
					}

					dao.foodInsert(fvo);
					System.out.println("=================================================");
				}

			}
			System.out.println("저장완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
