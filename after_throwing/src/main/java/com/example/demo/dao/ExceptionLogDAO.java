package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.ExceptionLog;

//dao μλμ€μΊ
@Repository
public class ExceptionLogDAO {
	
	public void insert(ExceptionLog log) {
		DBManager.insertLog(log);
	}
}
