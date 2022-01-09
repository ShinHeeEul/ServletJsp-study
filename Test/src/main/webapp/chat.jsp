<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>아놔 진짜</title>
<style>
input {
	width: 50px;
	height: 50px;
}

.output {
	height: 50px;
	background: #e9e9e9;
	font-size: 24px;
	font-weight: bold;
	text-align: right;
	padding: 0px 5px;
}
</style>
</head>
<body>
	<form  method="get">
		<div>
			<label> hey hey </label>
		</div>
		<div>
			 <br><label>write text in here</label>
			<input type="text" name="y">
			
		</div>
		<div>
			<input type="submit" value="보내기">
		</div>
		<div>
			<textarea><%=request.getParameter("y") %></textarea>
		</div>
		
	</table>
		</form>
</body>
</html>
