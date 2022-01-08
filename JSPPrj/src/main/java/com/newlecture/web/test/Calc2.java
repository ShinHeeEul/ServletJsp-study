package com.newlecture.web.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/calc2")

public class Calc2 extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		PrintWriter out = res.getWriter();
		String v_ = req.getParameter("value");
		String op = req.getParameter("operator");
		
		ServletContext application = req.getServletContext(); //application 저장소
		
		int v = 0;
		
		if(!v_.equals("")) v= Integer.parseInt(v_);
		
		if(op.equals("=")) {
			
			int x = (Integer) application.getAttribute("value");
			int y = v;
			String operator = (String) application.getAttribute("op");
			int result = 0;
			
			if(operator.equals("+"))
				result = x+y;
			
			else
				result = x-y;
			

			out.println("result = " + result);
			
		}
		else {
			application.setAttribute("value", v); //map 컬렉션과 비슷한 느낌
			application.setAttribute("op", op);
		}
		
	}	

}
