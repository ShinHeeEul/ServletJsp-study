package com.newlecture.web.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/calc")

public class Calc extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		PrintWriter out = res.getWriter();
		String str_x = req.getParameter("x");
		String str_y = req.getParameter("y");
		String op = req.getParameter("operator");
		
		
		
		int x = 0;
		int y = 0;
		
		
		
		if(!str_x.equals("") && !str_y.equals("")) {
			x = Integer.parseInt(str_x);
			y = Integer.parseInt(str_y);

			
		}
		
		if(op.equals("덧셈"))
			out.println(x+ "+"+ y + "=" + (x+y) + "입니다.");
		
		else
			out.println(x+ "-"+ y + "=" + (x-y) + "입니다.");
		
		
	}

}
