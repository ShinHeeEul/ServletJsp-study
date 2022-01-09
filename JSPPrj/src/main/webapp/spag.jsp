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
<body>
	<form>
		<div>
			<input type="text" name="n">
		</div>
		<div>
			<input type="submit" value="확인">
		</div>
	</form>

	<%=request.getAttribute("result")%>입니다.

</body>
</html>