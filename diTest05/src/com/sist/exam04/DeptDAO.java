package com.sist.exam04;

import com.sist.exam02.Dept;

public class DeptDAO {
	private Dept dept;
	
	public DeptDAO(Dept dept) {
		super();
		this.dept = dept;
	}

	public void insert() {
		System.out.println("������ �μ��� ����Ͽ����ϴ�.");
		System.out.println(dept);
	}
}
