package com.newlecture.web.controller;

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

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"\"Weed\"", "southkorea1");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			rs.next();
			
			String title = rs.getString("TITLE");
			Date regDate = rs.getDate("REGDATE");
			String writerId = rs.getString("WRITER_ID");
			String hit = rs.getString("HIT");
			String files = rs.getString("FILES");
			String content = rs.getString("CONTENT");
			
			/*
			req.setAttribute("title", title);
			req.setAttribute("regDate", regDate);
			req.setAttribute("writerId", writerId);
			req.setAttribute("hit", hit);
			req.setAttribute("files", files);
			req.setAttribute("content", content);
			*/
			
			Notice notice = new Notice(id,
					title,
					regDate,
					writerId,
					hit,
					files,
					content);
			
			
			req.setAttribute("n", notice);

			rs.close();
			st.close();
			con.close();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		//redirect
		//아예 다른 페이지로 가버리는 방법 -> 아예 로그인 페이지로 가거나, 게시글 등록 후 목록 페이지로 가기
		
		//foward
		//작업했던 내용들 이어줘서 계속 작업할 수 있게
		req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, resp);
		
	}
}
