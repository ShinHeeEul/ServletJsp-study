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
 *   ?cnt= -> 빈 문자열이 온다
 *   ?cnt -> null
 *   ?    -> null
 *   
 *   Servlet Filter
 *   - 여러 Servlet의 사전/사후에 사용가능한 필터
 *   - Servlet을 실행하기 전에 servlet filter를 거쳐간다. 그리고 그 다음에 servlet을 실행할지 말지도 결정한다.
 *   - 한글 인코딩 방식부터 시작해 인증과 권한 같은 것도 체크할 수 있따.
 * */

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
		
		@Override
		protected void service(
				//사용자로부터 요청을 받는 패킷
				HttpServletRequest request, 
				//사용자에게 보내주는 패킷
				HttpServletResponse response) throws ServletException, IOException {
			
		//사용자에게 보내는 문자 코드 지정
			//response.setCharacterEncoding("UTF-8");
		//어떻게 해석할 것인가를 지정(html문서이며, UTF-8 문자 코드로 읽는다)
			
		//POST로 전달하는 경우 요청 받는 패킷도 문자코드를 지정해주어야 함
		//TOMCAT 서버의 기본 문자 코드가 UTF-8이 아니기 떄문
			//request.setCharacterEncoding("UTF-8");
		/*
			 * HTML로 출력시 : setContentType("text/html");
			 * 일반 TEXT로 출력시 : setContentType("text/plain");
			 * 이미지 GIF로 출력시 : setContentType("image/gif");
			 * 이미지 JPG, JPEG로 출력시 : setContentType("image/jpeg");
		**/
			
			//response.setContentType("text/html; charset=UTF-8");
			
			
			PrintWriter out = response.getWriter();
			
			//request로부터 쿼리문을 가져옴
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			out.println(title);
			out.println(content);
		}
}
