package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.CustomerVO;

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
	
	public static List<CustomerVO> findAll(){
		SqlSession session = factory.openSession();
		List<CustomerVO> list = session.selectList("customer.findAll");
		session.close();
		return list;
	}
	
	public static CustomerVO findByNo(int custid) {
		SqlSession session = factory.openSession();
		CustomerVO c = session.selectOne("customer.findByNo", custid);
		session.close();
		return c;
	}
	
	public static int update(CustomerVO c) {
		SqlSession session = factory.openSession();
		int re = session.update("customer.update", c);
		session.commit();
		session.close();
		return re;
	}
	
	public static int delete(int custid) {
		SqlSession session = factory.openSession();
		int re = session.delete("customer.delete", custid);
		session.commit();
		session.close();
		return re;
	}
	
	public static int insert(CustomerVO c) {
		SqlSession session = factory.openSession();
		int re = session.insert("customer.insert", c);
		session.commit();
		session.close();
		return re;
	}
}
