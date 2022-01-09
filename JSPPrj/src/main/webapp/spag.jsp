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
	${param.n}
	${header.cookie}
	${pageContext.request.method}
</body>
</html>