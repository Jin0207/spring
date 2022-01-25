package com.sist.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.BoardVO;

public class DBManager {
	
	public static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/sist/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
	}
	
	public static List<BoardVO> listAll(){
		SqlSession session = factory.openSession();
		List<BoardVO> list = session.selectList("board.findAll");
		session.close();
		return list;
	}
	
	public static int insert(BoardVO b) {
		SqlSession session = factory.openSession();
		int re = session.insert("board.insert",b);
		session.commit();
		session.close();
		return re;
	}
	
	public static BoardVO getByNo(int no) {
		SqlSession session = factory.openSession();
		BoardVO b = session.selectOne("board.getByNo", no);
		session.close();
		return b;
	}
}
