package com.newlecture.web.entity;

import java.sql.Date;

public class Noticeview extends Notice {

	private int cmtCount;

	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

	public Noticeview() {

	}

	public Noticeview(int id, String title, Date regDate, String writerId, String hit, String files, int cmtCount) {
		// TODO Auto-generated constructor stub
		super(id, title, regDate, writerId, hit, files, "");
		this.cmtCount = cmtCount;
	}

}
