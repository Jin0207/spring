package com.sist.vo;


import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String content;
	private java.util.Date regdate;
	private int hit;
	private String fname;
	private MultipartFile uploadFile;
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public BoardVO(int no, String title, String writer, String content, Date regdate, int hit, String fname,
			MultipartFile uploadFile) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.fname = fname;
		this.uploadFile = uploadFile;
	}




	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}


	public java.util.Date getRegdate() {
		return regdate;
	}


	public void setRegdate(java.util.Date regdate) {
		this.regdate = regdate;
	}
	
	
}
