package com.example.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	public int insert() {
		System.out.println("등록하였습니다.");
		System.out.println(4/0);
		return 1;
		
	}
	
	public void list() {
		System.out.println("목록입니다.");
	}
}
