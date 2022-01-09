<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--Controller --%>


<%-------------------------------------------------------------- --%>

<%--View --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
pageContext.setAttribute("result", "hello");
%>

<body>
	<form method="post">
		<div>
			<input type="text" name="n">
		</div>
		<div>
			<input type="submit" value="확인">
		</div>
	</form>

	<!-- request 한정 범위 특정 -->
	${requestScope.result}입니다.<br >
	${names[1]}<br >
	${notice.title}<br>
	${result}<br >
	<!-- empty는 spag or spag?n= 의 경우 true -->
	${empty param.n?'값이 비어있습니다':param.n} <br>
	${header.cookie} <br>
	${pageContext.request.method} 
</body>
</html>