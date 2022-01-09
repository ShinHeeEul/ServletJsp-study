package com.newlecture.web.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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

@WebServlet("/calc3")

public class Calc3 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			/*ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = (String) engine.eval(exp);
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		} 
		else if ((operator != null) && operator.equals("C")) {
			exp = "";
		}
		else {
			exp += (value == null) ? "" : value;
			exp += (operator == null) ? "" : operator;
			exp += (dot == null) ? "" : dot;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		 if ((operator != null) && operator.equals("C")) {
			 //쿠키가 남지 않고 바로 없어짐.
				expCookie.setMaxAge(0);
		 }
		resp.addCookie(expCookie);
		resp.sendRedirect("/calcpage");
	}
}
