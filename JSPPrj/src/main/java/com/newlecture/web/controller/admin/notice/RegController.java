package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String isOpen = req.getParameter("open");
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		//notice.setPub();
		
		
		PrintWriter out = resp.getWriter();
		out.printf("title %s <br>", title);
		out.printf("content %s <br>", content);
		out.printf("isopen %s <br>", isOpen);
	}
}
