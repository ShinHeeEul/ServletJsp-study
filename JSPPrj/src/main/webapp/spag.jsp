<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--Controller --%>
<%
int num = 0;
String result;
String num_ = request.getParameter("n");
if (num_ != null && !num_.equals(""))
	num = Integer.parseInt(num_);

if (num % 2 != 0)
	result = "홀수";
else
	result = "짝수";
%>

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

	<%=result%>입니다.

</body>
</html>