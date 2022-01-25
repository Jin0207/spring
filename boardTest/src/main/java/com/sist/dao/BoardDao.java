package com.sist.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.db.DBManager;
import com.sist.vo.BoardVO;

@Repository
public class BoardDao {
	
	public List<BoardVO> listAll(){
		return DBManager.listAll();
	}
	
	public int insert(BoardVO b) {
		return DBManager.insert(b);
	}
	
	public BoardVO getByNo(int no) {
		return DBManager.getByNo(no);
	}
}
