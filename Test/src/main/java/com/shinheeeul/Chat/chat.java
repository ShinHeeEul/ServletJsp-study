package com.shinheeeul.Chat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chat")
public class chat extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		String ans = req.getParameter("y");
		
		//ServletContext app =  req.getServletContext();
		
		System.out.println("chat : " + ans);
		
		//out.println(app.getAttribute("h"));

		
		res.sendRedirect("/Test/chat.html");
	}

}
