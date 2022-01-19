package com.sist.exam07;

public class OracleArticleDao implements ArticleDao{

	@Override
	public void insert() {
		System.out.println("dbms oracle를 이용하여 등록하였습니다.");
	}

}
