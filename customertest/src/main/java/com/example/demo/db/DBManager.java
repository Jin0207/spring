package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.CustomerVO;

//mybatis의 설정파일에 있는 sql을 요청하는 클래스
public class DBManager {
	
	//mybatis 설정파일에 있는 sql을 요청하려면 SqlSession객체가 필요하다.
	// 이 SqlSession을 만들어주는 SqlSessionFactory 변수를 멤버로 선언
	// DBManager 객체 없이도 사용할 수 있도록 static으로 만듦
	private static SqlSessionFactory factory;
	
	//mybatis 설정파일인 sqlmapConfig파일을 읽어들여
	//sqlSessionFactory 객체를 생성
	//사용자의 어떤 메소드 요청 없이도
	//서버가 가동되면서 자동으로 동작하도록 하기위하여
	//static 블럭에 내용을 작성한다.
	// 파일의 내용을 읽어들여야하니 예외처리 해준다.
	static {
		try {
			// mybatis 설정파일인 sqlMapConfig파일을 스트림으로 읽어들임
			///스트림: 순서있는 자료의 흐름
			//			파일의 내용을 읽고 쓰려면 자료(데이터)가 순서있게 나가고 들어와야한다.
			// 			즉, 파일의 처리는 모두 스트림
			// 환경설정파일이 문자로 되어 있으므로 문자단위의 최상위 스트림객체인 Reader 객체생성
			//Resources : mybatis가 제공해주는 객체
			//mybatis 설정파일을 스트림으로 읽어오기 위하여
			//Resources클래스의 static 메소드인 getResourceAsReader 메소드를 이용한다.
			// 이때,getResourceAsReader 매개변수로 설정파일의 경로가 포함된 이름을 전달
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			//위에서 생성한 스트림을 매개변수로 하여
			//SqlSessionFactory 객체 생성
			factory = new SqlSessionFactoryBuilder().build(reader);
			
			//사용했던 스트림을 닫아준다.
			reader.close();
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}
	
	//마이바티즈 설정파일에 등록한 customerMapper파일에 있는
	//sql중 모든 고객목록을 검색하는 sql을 요청하는 메소드 정의
	// DBManager객체를 생성하지 않고 사용할 수 있도록 static 메소드로 정의
	public static List<CustomerVO> findAll(){
		
		//마이바티즈 설정파일에 있는 sql을 요청하기위하여 
		//sqlSessionFactory를 통하여 SqlSession을 얻어와야한다.
		SqlSession session = factory.openSession();
		//마이바티즈 설정파일에 있는 sql을 요청한다.
		//설정파일의 네임스페이스와 아이디를 통해 sql 요청
		List<CustomerVO> list = session.selectList("customer.findAll");
		//세션의 사용이 끝나면 닫아준다.
		session.close();
		return list;
	}
}
