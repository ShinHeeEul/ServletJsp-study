package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * 한글이 깨지는 이유
 * 서버에서 한글을 지원하지 않는 문자코드로 인코딩을 했거나 브라우저가 다른 문자코드로 이해한 경우
 * 
 * Get request * query string
 * - http://localhost/hello?cnt=3 -> 쿼리문을 get 방식으로 보낼 수 있다.
 * 	-> 동적인 문서를 제작할 수 있다.
 * */

@WebServlet("/hello")
public class Nana extends HttpServlet {
		
		@Override
		protected void service(
				//사용자로부터 요청을 받는 패킷
				HttpServletRequest request, 
				//사용자에게 보내주는 패킷
				HttpServletResponse response) throws ServletException, IOException {
			
			//사용자에게 보내는 문자 코드 지정
			response.setCharacterEncoding("UTF-8");
			//어떻게 해석할 것인가를 지정(html문서이며, UTF-8 문자 코드로 읽는다)
			
			/*
			 * HTML로 출력시 : setContentType("text/html");
			 * 일반 TEXT로 출력시 : setContentType("text/plain");
			 * 이미지 GIF로 출력시 : setContentType("image/gif");
			 * 이미지 JPG, JPEG로 출력시 : setContentType("image/jpeg");
			 **/
			
			response.setContentType("text/html; charset=UTF-8");
			
			
			PrintWriter out = response.getWriter();
			
			//request로부터 쿼리문을 가져옴
			int cnt = Integer.parseInt(request.getParameter("cnt"));
			
			for(int i = 0; i<cnt; i++) {
				
				out.println((i+1) + " : 안녕 서블릿!@@ <br>");
				
//				out.println((i+1) + " : 안녕 서블릿!@@");

			}
		}
}
