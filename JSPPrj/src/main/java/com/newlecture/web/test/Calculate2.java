package com.newlecture.web.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/add2")

public class Calculate2 extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = res.getWriter();
		String[] num_ = req.getParameterValues("num");
		
		
		int result = 0;
		
		for(int i = 0; i<num_.length; i++) {
			int num = Integer.parseInt(num_[i]);
			result += num;
		}
		
		
//		if(str_x != null && str_y != null) {
//			x = Integer.parseInt(str_x);
//			y = Integer.parseInt(str_y);
//
//			out.println(x+ "+"+ y + "=" + (x+y) + "입니다.");
//			
//		}
		

		out.println("result is" + result);
		
		
	}

}
