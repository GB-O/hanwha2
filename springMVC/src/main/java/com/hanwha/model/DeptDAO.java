package com.hanwha.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanwha.util.DBUtil_Oracle;

/*
 * DAO(Data Access Object) : Business logic
 */
//<bean id="deptDAO" class="com.hanwha.model.DeptDAO"/>

@Repository
public class DeptDAO {
	
	@Autowired
	DataSource ds;
	
	public List<DeptDTO> selectAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM departments";
		
		List<DeptDTO> list = new ArrayList<>();
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int deptid = rs.getInt("department_id");
				String dname = rs.getString("department_name");
				// System.out.println(deptid + "\t" + dname);
				// 여기서 뽑으면 안되고 클래스를 이용하여 넘긴다.
				DeptDTO dept = new DeptDTO(deptid, dname);
				list.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return list;
	}
	
	public DeptDTO selectById(int deptid) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		DeptDTO dept = null;
		
		String sql = "SELECT * FROM departments WHERE department_id = "+deptid;
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
		    
			if(rs.next()) {
				int department_id = rs.getInt("department_id");
				String department_name = rs.getString("department_name");
				dept = new DeptDTO(department_id, department_name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		return dept;
	}

	public int insertDept(DeptDTO dept) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "insert into departments (department_id, department_name)"
				+ "values (?,?)";
		
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, dept.getDepartment_id());
			st.setString(2, dept.getDepartment_name());
			result = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return result;
	}
	
	public int updateDept(DeptDTO dept) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "UPDATE departments"
				+ " set department_name = ?"
				+ " WHERE department_id = ?";
		
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(2, dept.getDepartment_id());
			st.setString(1, dept.getDepartment_name());
			result = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return result;
	}

	public int deleteDept(int deptid) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "DELETE FROM departments WHERE department_id = ?";
		
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, deptid);
			result = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return result;
	}
	
}
