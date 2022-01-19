package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

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
		boolean pub = false;
		
		if(isOpen != null)
			pub = true;
		
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		//현재 접속한 사용자
		notice.setWriterId("newlec");
		
		
		NoticeService service = new NoticeService();
		int result = service.insertNotice(notice);
		
		resp.sendRedirect("list");
	}
}
