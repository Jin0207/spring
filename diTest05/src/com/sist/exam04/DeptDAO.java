package com.sist.exam04;

import com.sist.exam02.Dept;

public class DeptDAO {
	private Dept dept;
	
	public DeptDAO(Dept dept) {
		super();
		this.dept = dept;
	}

	public void insert() {
		System.out.println("다음의 부서를 등록하였습니다.");
		System.out.println(dept);
	}
}
