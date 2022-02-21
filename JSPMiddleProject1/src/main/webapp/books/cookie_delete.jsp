<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
// 쿠키를 가지고 온다
Cookie[] cookies = request.getCookies();
if (cookies != null) {

	for (int i = 0; i < cookies.length; i++) {
		if (cookies[i].getName().startsWith("m")) {
	cookies[i].setMaxAge(0);
	response.addCookie(cookies[i]);
		}
	}
}

response.sendRedirect("list.jsp");

%>