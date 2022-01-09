package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {

	// get과 post를 나눌 수 있는 방법??

	/*
	 * //구분할 방법1 - service 내에서 get, post를 사용
	 * 
	 * @Override protected void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * 
	 * 
	 * //반드시 대문자로 비교해야 함! if(req.getMethod().equals("GET")) {
	 * System.out.println("GET 요청이 왔습니다."); } else
	 * if(req.getMethod().equals("POST")) { System.out.println("POST 요청이 왔습니다."); }
	 * 
	 * //이를 없애면 doGet, doPost를 사용할 수 없다. - 이를 통해 doGet, doPost의 부모 클래스에 req, resp를
	 * 전달하기 때문 super.service(req, resp); }
	 */

	// 구분할 방법2 -doGet, doPost함수를 이용해서 서비스할 수 있다.

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = resp.getWriter();

		String value = req.getParameter("value");
		String operator = req.getParameter("operator");
		String dot = req.getParameter("dot");

		String exp = "";
		Cookie[] cookies = req.getCookies();

		if (cookies != null) {

			for (Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}

		if ((operator != null) && operator.equals("=")) {
			// engine 삭제됨
			/*
			 * ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			 * try { exp = (String) engine.eval(exp); } catch (ScriptException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */

		} else if ((operator != null) && operator.equals("C")) {
			exp = "";
		} else {
			exp += (value == null) ? "" : value;
			exp += (operator == null) ? "" : operator;
			exp += (dot == null) ? "" : dot;
		}

		Cookie expCookie = new Cookie("exp", exp);
		if ((operator != null) && operator.equals("C")) {
			// 쿠키가 남지 않고 바로 없어짐.
			expCookie.setMaxAge(0);
		}
		expCookie.setPath("/calculator");
		resp.addCookie(expCookie);
		resp.sendRedirect("/calculator");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("doGet 메소드가 호출되었습니다.");


		PrintWriter out = resp.getWriter();

		String exp = "0";
		Cookie[] cookies = req.getCookies();

		if (cookies != null) {

			for (Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}

		out.write("");
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("	<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>calculate</title>");
		out.write("<style>");
		out.write("input{");
		out.write("	width:50px;");
		out.write("height:50px;");
		out.write("	}");
		out.write(".output {");
		out.write("height: 50px;");
		out.write("background : #e9e9e9;");
		out.write("	font-size : 24px;");
		out.write("font-weight : bold;");
		out.write("text-align: right;");
		out.write("padding: 0px 5px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		//action이 없으면 자기 페이지를 요청하는 것
		out.write("<form method=\"post\">");
		out.write("<!-- div = Division의 약자로 보통 레이아웃 배치를 할 때 사용함 -->");

		out.write("<table>");
		out.write("<tr>");
		out.printf("<td class=\"output\" colspan=\"4\">%s</td>", exp);
		out.write("</tr>");
		out.write("<tr>");
		out.write("	<td><input type=\"submit\" name =\"operator\" value=\"CE\"></td>");
		out.write(" <td><input type=\"submit\" name =\"operator\" value=\"C\"></td>");
		out.write("	<td><input type=\"submit\" name =\"operator\" value=\"BS\"></td>");
		out.write("	<td><input type=\"submit\" name =\"operator\" value=\"/\"></td>");
		out.write("</tr>");
		out.write("	<tr>");
		out.write("		<td><input type=\"submit\" name =\"value\" value=\"7\"></td>");
		out.write("		<td><input type=\"submit\" name =\"value\" value=\"8\"></td>");
		out.write("		<td><input type=\"submit\" name =\"value\" value=\"9\"></td>");
		out.write("		<td><input type=\"submit\" name =\"operator\" value=\"*\"></td>");
		out.write("	</tr>");
		out.write("	<tr>");
		out.write("		<td><input type=\"submit\" name =\"value\" value=\"4\"></td>");
		out.write("		<td><input type=\"submit\" name =\"value\" value=\"5\"></td>");
		out.write("		<td><input type=\"submit\" name =\"value\" value=\"6\"></td>");
		out.write("		<td><input type=\"submit\" name =\"operator\" value=\"-\"></td>");
		out.write("	</tr>");
		out.write("	<tr>");
		out.write("		<td><input type=\"submit\" name =\"value\" value=\"1\"></td>");
		out.write("		<td><input type=\"submit\" name =\"value\" value=\"2\"></td>");
		out.write("		<td><input type=\"submit\" name =\"value\" value=\"3\"></td>");
		out.write("		<td><input type=\"submit\" name =\"operator\" value=\"+\"></td>");
		out.write("	</tr>");
		out.write("	<tr>");
		out.write("		<td><input type=\"submit\" name =\"value\" value=\"0\"></td>");
		out.write("		<td><input type=\"submit\" name =\"dot\" value=\".\"></td>");
		out.write("		<td><input type=\"submit\" name =\"operator\" value=\"=\"></td>");
		out.write("	</tr>");
		out.write("	</table>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
	}

}
