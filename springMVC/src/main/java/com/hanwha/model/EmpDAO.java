package com.hanwha.model;

import java.sql.Connection;
import java.sql.Date;
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
import com.hanwha.util.DateUtil;

@Repository
public class EmpDAO {
	
	@Autowired
	DataSource ds;
	
	public List<Integer> selectAllManager(){
		List<Integer> list = new ArrayList<>();
		Connection conn = null;
		Statement st = null;
		String sql = "SELECT distinct manager_id FROM employees";
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				list.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return list;
	}
	
	public List<String> selectAllJob(){
		List<String> list = new ArrayList<>();
		Connection conn = null;
		Statement st = null;
		String sql = "SELECT * FROM jobs";
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return list;
	}
	
	public List<EmpVO> selectAll(){
		List<EmpVO> list = new ArrayList<>();
		Connection conn = null;
		Statement st = null;
		String sql = "SELECT * FROM employees";
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				Date hire_date = rs.getDate("hire_date");
				String job_id = rs.getString("job_id");
				int salary = rs.getInt("salary");
				double commission_pct = rs.getDouble("commission_pct");
				int manager_id = rs.getInt("manager_id");
				int department_id = rs.getInt("department_id");
				
				EmpVO emp = new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id);
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return list;
	}

	public EmpVO selectById(int empid) {
		EmpVO emp = null;
		Connection conn = null;
		Statement st = null;
		String sql = "SELECT * FROM employees WHERE employee_id = "+empid;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				Date hire_date = rs.getDate("hire_date");
				String job_id = rs.getString("job_id");
				int salary = rs.getInt("salary");
				double commission_pct = rs.getDouble("commission_pct");
				int manager_id = rs.getInt("manager_id");
				int department_id = rs.getInt("department_id");
				
				emp = new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return emp;
	}
	
	public List<EmpVO> selectByDept(int deptid){
		List<EmpVO> list = new ArrayList<>();
		Connection conn = null;
		Statement st = null;
		String sql = "SELECT * FROM employees WHERE department_id = "+deptid;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				Date hire_date = rs.getDate("hire_date");
				String job_id = rs.getString("job_id");
				int salary = rs.getInt("salary");
				double commission_pct = rs.getDouble("commission_pct");
				int manager_id = rs.getInt("manager_id");
				int department_id = rs.getInt("department_id");
				
				EmpVO emp = new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id);
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return list;
	}
	
	public List<EmpVO> selectByJob(String jobid, int sal){
		List<EmpVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "SELECT * FROM employees WHERE job_id = ? AND salary >= ?";
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, jobid);
			st.setInt(2, sal);
			rs = st.executeQuery();
			
			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				Date hire_date = rs.getDate("hire_date");
				String job_id = rs.getString("job_id");
				int salary = rs.getInt("salary");
				double commission_pct = rs.getDouble("commission_pct");
				int manager_id = rs.getInt("manager_id");
				int department_id = rs.getInt("department_id");
				
				EmpVO emp = new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id);
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return list;
	}

	public int insertEmp() {
		Connection conn = null;
		PreparedStatement st = null;
		Date d = DateUtil.transDate("2019-08-01");
		String sql = "insert into employees values "
				+ "(?,?,?,?,?,?,?,?,?,?,?)";
		ResultSet rs = null;
		int result=0;
		
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, 1005);
			st.setString(2, "Dead");
			st.setString(3, "Pool");
			st.setString(4, "Iron@Man.com");
			st.setString(5, "111-1111");
			st.setDate(6, d);
			st.setString(7, "IT_PROG");
			st.setInt(8, 1000);
			st.setDouble(9, 0.1);
			st.setInt(10, 109);
			st.setInt(11, 10);
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return result;
	}
	
	public int insertEmp(EmpVO vo) {
		Connection conn = null;
		PreparedStatement st = null;
		
		String sql = "insert into employees values "
				+ "(?,?,?,?,?,?,?,?,?,?,?)";
		ResultSet rs = null;
		int result=0;
		
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, vo.getEmployee_id());
			st.setString(2, vo.getFirst_name());
			st.setString(3, vo.getLast_name());
			st.setString(4, vo.getEmail());
			st.setString(5, vo.getPhone_number());
			st.setDate(6, vo.getHire_date());
			st.setString(7, vo.getJob_id());
			st.setInt(8, vo.getSalary());
			st.setDouble(9, vo.getCommission_pct());
			st.setInt(10, vo.getManager_id());
			st.setInt(11, vo.getDepartment_id());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return result;
	}

	public int updateEmp() {
		Connection conn = null;
		PreparedStatement st = null;
		
		String sql = "UPDATE employees SET first_name = ?, last_name = ? WHERE employee_id = ?";
		int result = 0;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, "Captain");
			st.setString(2, "America");
			st.setInt(3, 1004);
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return result;
	}
	
	public int updateEmp(EmpVO vo) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "UPDATE employees SET "
				+ "first_name = ?, "
				+ "last_name = ?, email = ?, phone_number=?, "
				+ "hire_date = ?, job_id = ?, salary = ?,"
				+ "commission_pct = ?, manager_id = ?,"
				+ "department_id = ?"
				+ "WHERE employee_id = ?";
		int result = 0;
		
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, vo.getFirst_name());
			st.setString(2, vo.getLast_name());
			st.setString(3, vo.getEmail());
			st.setString(4, vo.getPhone_number());
			st.setDate(5, vo.getHire_date());
			st.setString(6, vo.getJob_id());
			st.setInt(7, vo.getSalary());
			st.setDouble(8, vo.getCommission_pct());
			st.setInt(9, vo.getManager_id());
			st.setInt(10, vo.getDepartment_id());
			st.setInt(11, vo.getEmployee_id());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return result;
	}

	public int deleteEmp() {
		Connection conn = null;
		PreparedStatement st = null;
		
		String sql = "DELETE FROM employees WHERE employee_id = ?";
		int result=0;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, 1004);
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		
		return result;
	}
	
	public int deleteEmp(int empid) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "DELETE FROM employees WHERE employee_id = ?";
		int result=0;
		
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, empid);
			
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
