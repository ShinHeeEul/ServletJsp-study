package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = 0;
		String result;
		
		
		String num_ = req.getParameter("n");
		if (num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);

		if (num % 2 != 0)
			result = "홀수";
		else
			result = "짝수";
		
		//redirect
		//-새로운 요청
		//forward
		//-현재 작업한 내용을 이어가도록
		//- 이를 위해 dispatcher가 필요함.
		
		//server 내의 또하나의 저장소 request
		req.setAttribute("result", result);
		
		//Array List
		String[] names = {"newlec", "dragon"};
		req.setAttribute("names", names);
		
		//Map
		Map<String , Object> notice = new HashMap<String, Object>();
		
		notice.put("id", 1);
		notice.put("title", "EL은 조아요");
		
		req.setAttribute("notice", notice);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/spag.jsp");
		//servlet 파일의 request, response를 jsp 파일의 request, response로 할 수 있게 된다.
		dispatcher.forward(req, resp);
		
		// 이제 실행은 전부 controller에서 실행해야 한다.
	}
}
