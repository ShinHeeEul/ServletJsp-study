package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet{


	//get과 post를 나눌 수 있는 방법??
	
	/*//구분할 방법1 - service 내에서 get, post를 사용
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//반드시 대문자로 비교해야 함!
		if(req.getMethod().equals("GET")) {
			System.out.println("GET 요청이 왔습니다.");
		}
		else if(req.getMethod().equals("POST")) {
			System.out.println("POST 요청이 왔습니다.");
		}
		
		//이를 없애면 doGet, doPost를 사용할 수 없다. - 이를 통해 doGet, doPost의 부모 클래스에 req, resp를 전달하기 때문
		super.service(req, resp);
	}*/
	
	//구분할 방법2 -doGet, doPost함수를 이용해서 서비스할 수 있다.

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("doPOST 메소드가 호출되었습니다.");
		}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("doGet 메소드가 호출되었습니다.");
		
	}
	
	
	
}
