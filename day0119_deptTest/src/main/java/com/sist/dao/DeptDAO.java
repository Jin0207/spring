package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.DeptVO;

public class DeptDAO {
	
	public int insert(DeptVO d) {
		int re = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into dept values(?,?,?)";
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getDloc());
			re = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			ConnectionProvider.close(conn, pstmt);
		}
		return re;
	}
	
	public ArrayList<DeptVO> listDept(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		String sql = "select * from dept order by dno";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				DeptVO d = new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(d);
			}
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			ConnectionProvider.close(conn, stmt, rs);
		}
		
		return list;
	}
}
