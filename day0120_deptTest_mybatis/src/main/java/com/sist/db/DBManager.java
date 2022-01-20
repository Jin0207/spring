package com.sist.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

public class DBManager {
	
	//mybatis 설정파일에 접근하기 위한 SqlSessionFactory 변수를 선언
	//이 변수에 객체없이도 접근 할 수 있도록 static변수로 선언
	private static SqlSessionFactory sqlMapper;
	
	//프로그램 실행됨과 동시에 자동으로 실행하여 
	//mybatis 설정파일을 읽어들이기 위하여 static 블록에 코딩한다.
	static {
		try {// 파일을 읽어들이기위해 예외처리해줌
			
			//mybatis 설정파일을 스트림으로 읽어들인다.
			Reader reader
			= Resources.getResourceAsReader("com/sist/db/sqlMapConfig.xml");
			
			//mybatis 설정파일의 stream을 통하여
			//mybatis를 통해 sql을 사용할 수 있는 sqlSessionFactory 객체를 생성한다.
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			
			//스트림을 닫아준다.
			reader.close();
			
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}
	
	//mybatis 설정파일의 특정 sql(dept라는 네임스페이스의 selectAll이라는 아이디를 갖는 sql)을 요청하는 메소드를 정의한다.
	public static List<DeptVO> listAll(){
		
		//mybatis 설정파일에 있는 sql을 사용하기 위하여
		//sqlSessionFactory를 통하여 SqlSession객체를 얻어온다.
		SqlSession session = sqlMapper.openSession();
		
		//sqlSession을 통해 sql 실행
		//sqlSession에는 crud를 위한 insert,update,delete, select 메소드들이 있다.
		//지금은 selectList를 이용함
		//이때 매개변수로 mybatis설정파일에 있는 네임스페이스와 id를 전달해 준다.(네임스페이스.id)
		List<DeptVO> list = session.selectList("dept.selectAll");
		
		//session을 사용한 후에는 session을 닫아준다.
		session.close();
		
		return list;
	}
	
	public static DeptVO getDept(int dno) {
		SqlSession session = sqlMapper.openSession();
		DeptVO d = session.selectOne("dept.selectDept", dno);
		session.close();
		return d;
	}
	
	public static int insert(DeptVO d) {
		int re = -1;
		SqlSession session = sqlMapper.openSession();
		re = session.insert("dept.insert", d);
		//데이터베이스에 변경이 있는 sql(insert, update, delete)을 실행할 땐,
		//반드시 session.commit() 이거나 rollback()메소드를 호출해야한다.
		if(re==1) {
			session.commit();
		}
		
		session.close();
		return re;
	}
	
	public static int update(DeptVO d) {
		int re = -1;
		//boolean 기본: false / true:자동커밋
		SqlSession session = sqlMapper.openSession(true);
		re = session.update("dept.update", d);
		
		//session.commit();
		session.close();
		
		return re;
	}
	
	public static int delete(int dno) {
		int re = -1;
		SqlSession session = sqlMapper.openSession(true);
		re = session.delete("dept.delete", dno);
		
		//session.commit();
		session.close();
		return re;
	}
	
	public static List<EmpVO> listEmp(){
		SqlSession session = sqlMapper.openSession();
		List<EmpVO> list = session.selectList("emp.selectAll");
		session.close();
		return list;
		
	}
}
