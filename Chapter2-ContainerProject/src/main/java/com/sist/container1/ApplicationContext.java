package com.sist.container1;

import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.*;

public class ApplicationContext {
	private Map map = new HashMap();

	public ApplicationContext(String path) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(path));
			Element beans = doc.getDocumentElement();

			NodeList list = beans.getElementsByTagName("bean");
			for (int i = 0; i < list.getLength(); i++) {
				Element bean = (Element) list.item(i);
				String cls = bean.getAttribute("class");
				String id = bean.getAttribute("id");
				Class clsName = Class.forName(cls);
				Object obj = clsName.getDeclaredConstructor().newInstance();
				map.put(id, obj);
			}

		} catch (Exception e) {

		}
	}

	public Object getBean(String id) {
		return map.get(id);
	}
}
