package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {
	//page 보이게 구현하는 내용
	public List<Notice> getNoticeList(){
		
		return getNoticeList("title","",1);
	}
	
	public List<Notice> getNoticeList(int page){
		
		return getNoticeList("title", "", page);
	}

	//1, 11, 21, 31 -> an = 1+(page-1)*10
	//10, 20, 30, 40 -> page * 10
	
	//검색 기능
	public List<Notice> getNoticeList(String field/*title, writer_id*/, String query/*A*/, int page){
		String sql = "select * from("
				+ "    select row_number() over (order by regdate desc) num,"
				+ "    notice.* from notice where " + field +" like ?"
				+ ") where num between ? and ?";
		
		
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		List<Notice> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"\"Weed\"", "southkorea1");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, 1+(page-1)*10);
			st.setInt(3, page*10);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regDate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				Notice notice = new Notice(id,
						title,
						regDate,
						writerId,
						hit,
						files,
						content);
				list.add(notice);
			
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public int getNoticeCount() {
		
		return getNoticeCount("title", "");
	}
	
	public int getNoticeCount(String field, String query) {
		
		String sql = "select * from("
				+ "    select row_number() over (order by regdate desc) num,"
				+ "    notice.* from notice"
				+ ") where num between 6 and 10;";
		
		
		
		return 0;
	}
	
	public Notice getNotice(int id) {
		String sql = "select * from notice where id=?";
		return null;
	}
	
	public Notice getNextNotice(int id) {
		String sql = "select id from "
				+ "(select * from notice order by id) "
				+ "where id>3 and rownum = 1";
		
		return null;
	}
	
	public Notice getprevNotice(int id) {
		String sql = "select id from notice "
				+ "where id = (select id from "
				+ "(select * from notice order by id desc) "
				+ "where id<3 and rownum = 1)";
		return null;
	}

}
