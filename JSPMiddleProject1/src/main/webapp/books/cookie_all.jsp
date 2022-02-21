<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>

<%
// 데이터베이스 연결
BooksDAO dao = new BooksDAO();
// 쿠키 읽기
Cookie[] cookies = request.getCookies();
List<BooksVO> list = new ArrayList<BooksVO>();
if (cookies != null) {
	for (int i = cookies.length - 1; i >= 0; i--) {
		if (cookies[i].getName().startsWith("m")) {
	String no = cookies[i].getValue();
	BooksVO vo = dao.booksDetailData(Integer.parseInt(no));
	String s = vo.getTitle();
	if (s.length() > 12) {
		s = s.substring(0, 12) + "...";
		vo.setTitle(s);
	}
	vo.setTitle(s);
	list.add(vo);
		}
	}
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
		margin-top: 50px;
}

.row {
		margin: 0px auto;
		width: 960px;
}
</style>
</head>
<body>
		<div class="container">
				<div class="row">
						<%
						for (BooksVO vo : list) {
						%>
						<div class="col-md-3">
								<div class="thumbnail">
										<a href="detail_before.jsp?no=<%=vo.getNo()%>"> <img src="<%=vo.getPoster()%>" alt="Lights" style="width: 220px; height: 300px;">
												<div class="caption">
														<p><%=vo.getTitle()%></p>
												</div>
										</a>
								</div>
						</div>
						<%
						}
						%>
				</div>
		</div>
</body>
</html>