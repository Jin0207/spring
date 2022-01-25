package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BoardVO;

public class DBManager {
	
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}
	
	public static List<BoardVO> findAll() {
		SqlSession session = factory.openSession();
		List<BoardVO> list = session.selectList("board.findAll");
		session.close();
		return list;
	}
	
	public static int getNextNo() {
		SqlSession session = factory.openSession();
		int no = session.selectOne("board.getNextNo");
		session.close();
		return no;
	}
	
	
	public static int insert(BoardVO b) {
		b.setNo(getNextNo());
		
		SqlSession session = factory.openSession();
		int re = session.insert("board.insert", b);
		session.commit();
		session.close();
		return re;
	}
	
	public static int update(BoardVO b) {
		SqlSession session = factory.openSession(true);
		int re = session.update("board.update", b);
		session.close();
		return re;
	}
	
	public static BoardVO findByNo(int no) {
		SqlSession session = factory.openSession();
		BoardVO b = session.selectOne("board.findByNo", no);
		session.close();
		return b;
	}
}
