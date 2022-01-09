<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String temp = request.getParameter("cnt");

//그 쿼리문이 빈 문자열이나 null 값이 들어올 경우 default value로 설정
int cnt = 1;
if(temp != null && !temp.equals("")) {
	cnt = Integer.parseInt(temp);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%for (int i = 0; i < cnt; i++) {%>
	안녕 서블릿!@@ <br>
	<%}%>
</body>
</html>