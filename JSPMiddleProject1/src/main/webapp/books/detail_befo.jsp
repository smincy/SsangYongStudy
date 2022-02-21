<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 쿠키 저장 --%>

<%
// 사용자가 보내준 데이터를 받는다
String no = request.getParameter("no");

// 쿠키는 클라이언트에 저장 / 세션은 서버에 저장
// 단점 : 문자열만 저장이 가능, 세션은 Object로 저장

// 1. 쿠키 생성				Cookie cookie = new Cookie(쿠키명, 값);
Cookie cookie = new Cookie("m" + no, no);

// 1-1. 저장기간				setMaxAge(초)
cookie.setMaxAge(60 * 60 * 24);

// 2. response 를 이용해서 전송 => 서버에서 클라이언트로 전송
response.addCookie(cookie);
//	addCookie()

// 3. detail 화면으로 이동		sendRedirect()
response.sendRedirect("detail.jsp?no=" + no);
%>