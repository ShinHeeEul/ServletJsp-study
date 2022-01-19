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
import com.newlecture.web.entity.Noticeview;

public class NoticeService {
	//page 보이게 구현하는 내용
	
	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	
	public int removeNoticeAll(int[] ids) {
		
		return 0;
	}
	
	public int pubNoticeAll(int[] ids) {
		return 0;
	}
	
	public int insertNotice(Notice notice) {
		
		
		String sql = "insert into (TITLE, CONTENT, WRITER_ID, PUB) VALUES(?,?,?,?)";
		
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"\"Weed\"", "southkorea1");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,  notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getWriterId());
			st.setBoolean(4, notice.getPub());
			
			result = st.executeUpdate(); // insert, update, delete 할 때 사용
			
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	
	public int deleteNotice(int id) {
		
		return 0;
	}
	
	public int updateNotice(Notice notice) {
		
		return 0;
	}
	
	public List<Notice> getNoticeNewestList() {
		return null;
	}
	
	public List<Noticeview> getNoticeList(){
		
		return getNoticeList("title", "", 1);
	}
	
	public List<Noticeview> getNoticeList(int page){
		
		return getNoticeList("title", "", page);
	}

	//1, 11, 21, 31 -> an = 1+(page-1)*10
	//10, 20, 30, 40 -> page * 10
	
	//검색 기능
	public List<Noticeview> getNoticeList(String field/*title, writer_id*/, String query/*A*/, int page){
		/*String sql = "select * from("
				+ "    select row_number() over (order by regdate desc) num,"
				+ "    notice.* from notice where " + field +" like ?"
				+ ") where num between ? and ? order by id";
		*/
		
		String sql = "select * from (select * from notice_view where " + field + " like ?)"
				+ "where id between ? and ? order by id";
		
		
		
		List<Noticeview> list = new ArrayList<>();
		
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
				//String content = rs.getString("CONTENT");
				int cmtCount = rs.getInt("CMT_COUNT");
				boolean pub = rs.getBoolean("pub");
			
				Noticeview notice = new Noticeview (id,
						title,
						regDate,
						writerId,
						hit,
						files,
						pub,
						//content,
						cmtCount);
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
		
		String sql = "select count(ID) count from ("
				+ "select * from notice where " + field +" like ?"
				+ ")";
		
		int count = 0;

		List<Notice> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"\"Weed\"", "southkorea1");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%"+query+"%");
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				count = rs.getInt("count");
			
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
		
		
		return count;
	}
	
	
	//클릭한 공지의 세부 사항을 가져오는 함수
	public Notice getNotice(int id) {
		
		Notice notice = null;
		String sql = "select * from notice where id=?";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"\"Weed\"", "southkorea1");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regDate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				boolean pub = rs.getBoolean("pub");
				
				notice = new Notice(nid,
						title,
						regDate,
						writerId,
						hit,
						files,
						content,
						pub);
			
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
		
		return notice;
	}
	
	public Notice getNextNotice(int id) {
		String sql = "select * from "
				+ "(select * from notice order by id) "
				+ "where id>? and rownum = 1";
		
		Notice notice = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"\"Weed\"", "southkorea1");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regDate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				boolean pub = rs.getBoolean("pub");
				
				notice = new Notice(nid,
						title,
						regDate,
						writerId,
						hit,
						files,
						content,
						pub);
			
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
		
		return notice;
	}
	
	public Notice getprevNotice(int id) {
		String sql = "select * from notice "
				+ "where id = (select id from "
				+ "(select * from notice order by id desc) "
				+ "where id<? and rownum = 1)";


		Notice notice = null;

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"\"Weed\"", "southkorea1");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regDate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				boolean pub = rs.getBoolean("pub");
				
				notice = new Notice(nid,
						title,
						regDate,
						writerId,
						hit,
						files,
						content,
						pub);
			
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
		
		return notice;
	}

	public int deleteNoticeAll(int[] ids) {
		// TODO Auto-generated method stub
		
		String params = "";
		
		for(int i =0; i<ids.length;i++) {
			params += ids[i];
			if(i < ids.length-1)
				params+=",";
		}
		
		
		String sql = "delete notice where id in ("+ params +")";
		
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"\"Weed\"", "southkorea1");
			Statement st = con.createStatement();
			result = st.executeUpdate(sql); // insert, update, delete 할 때 사용
			
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
