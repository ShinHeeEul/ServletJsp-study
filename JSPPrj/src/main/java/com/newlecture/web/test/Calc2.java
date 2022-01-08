package com.newlecture.web.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")

public class Calc2 extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		PrintWriter out = resp.getWriter();
		String v_ = req.getParameter("value");
		String op = req.getParameter("operator");
		
		ServletContext application = req.getServletContext(); //application 저장소
		HttpSession session = req.getSession(); // session 저장소
		Cookie[] cookies = req.getCookies();
				
		int v = 0;
		
		if(!v_.equals("")) v= Integer.parseInt(v_);
		
		if(op.equals("=")) {
			
			//int x = (Integer) application.getAttribute("value");
			//int x = (Integer) session.getAttribute("value");
			int x = 0;
			for(Cookie c : cookies) {
			if(c.getName().equals("value")) {
				x = Integer.parseInt(c.getValue());
				break;
				}
			}
			int y = v;
			//String operator = (String) application.getAttribute("op");
			//String operator = (String) session.getAttribute("op");
			String operator = "";
			for(Cookie c : cookies) {
			if(c.getName().equals("op")) {
				operator = c.getValue();
				break;
				}
			}
			int result = 0;
			
			if(operator.equals("+"))
				result = x+y;
			
			else
				result = x-y;
			

			out.println("result = " + result);
			
		}
		else {
			//application.setAttribute("value", v); //map 컬렉션과 비슷한 느낌
			//application.setAttribute("op", op);
			
			//session.setAttribute("value", v); //map 컬렉션과 비슷한 느낌
			//session.setAttribute("op", op);
			
			Cookie value_cookie = new Cookie("value", String.valueOf(v)); //쿠키는 반드시 url에 사용가능한 문자열로만 보내야 한다. JSON을 통해 변해서 전달 가능
			Cookie op_cookie = new Cookie("op",op);
			value_cookie.setPath("/calc2");// 해당 servlet에만 가져오라고 설정가능
			op_cookie.setPath("/calc2");
			
			value_cookie.setMaxAge(24*60*60); // 초단위, 만료 날짜를 설정 가능
			
			resp.addCookie(value_cookie);
			resp.addCookie(op_cookie);
		}
	}
}
