package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/board/notice/detail")
public class DetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		NoticeService service = new NoticeService();
		
		Notice p_notice = service.getprevNotice(id);
		Notice notice = service.getNotice(id);
		Notice n_notice = service.getNextNotice(id);
		
		req.setAttribute("pn", p_notice);
		req.setAttribute("n", notice);
		req.setAttribute("nn", n_notice);
		
		//redirect
		//아예 다른 페이지로 가버리는 방법 -> 아예 로그인 페이지로 가거나, 게시글 등록 후 목록 페이지로 가기
		
		//foward
		//작업했던 내용들 이어줘서 계속 작업할 수 있게
		req.getRequestDispatcher("/WEB-INF/view/admin/board/notice/detail.jsp").forward(req, resp);
		
	}
}
