package com.hanwha.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDAO_Mybatis {
	
	@Autowired
	SqlSession session;
	String namespace = "com.hanwha.dept.";
	
	public List<DeptDTO> selectAll(){
		return session.selectList(namespace+"selectall");
	}
	
	public DeptDTO selectById(int deptid) {
		return session.selectOne(namespace+"selectbyid", deptid);
	}
	
	public int insertDept(DeptDTO dept) {
		return session.insert(namespace+"insert", dept);
	}
	
	public int updateDept(DeptDTO dept) {
		return session.update(namespace+"update", dept);
	}
	
	public int deleteDept(int deptid) {
		return session.delete(namespace+"delete", deptid);
	}
	
	
}
