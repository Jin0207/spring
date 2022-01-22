package com.sist.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.GoodsVO;

public class DBManager {
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader
			= Resources.getResourceAsReader("com/sist/db/sqlMapConfig.xml");
			
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage() );
		}
	}
	
	public static List<GoodsVO> findAll(){
		SqlSession session= factory.openSession();
		List<GoodsVO> list = session.selectList("goods.findAll");
		session.close();
		return list;
	}
	
	public static int insert(GoodsVO g) {
		SqlSession session = factory.openSession();
		int re = session.insert("goods.insert", g);
		session.commit();
		session.close();
		return re;
	}
	
	public static int update(GoodsVO g) {
		//마이바티스 설정에 있는의 sql 을요청하기위해서는 sqlSession이 필요
		//sqlsessionfactory를 통하여 session 얻어오기
		SqlSession session = factory.openSession();
		
		int re = session.update("goods.update",g);
		
		//데이터베이스의 변동이 있는 세션이기때문에
		session.commit();
		session.close();
		return re;
	}
	
	public static int delete(int no) {
		SqlSession session = factory.openSession();
		int re = session.delete("goods.delete",no);
		session.commit();
		session.close();
		return re;
	}
	
	public static GoodsVO findByNo(int no) {
		SqlSession session = factory.openSession();
		//select한 결과가 1건
		GoodsVO g = session.selectOne("goods.findByNo",no);
		session.close();
		return g;
	}
}
