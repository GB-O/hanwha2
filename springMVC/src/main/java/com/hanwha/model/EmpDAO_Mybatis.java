package com.hanwha.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO_Mybatis {
	
	@Autowired
	SqlSession session;
	String namespace = "com.hanwha.emp.";
	
	public List<Integer> selectAllManager(){
		return session.selectList(namespace+"selectallmanager");
	}
	
	public List<String> selectAllJob(){
		return session.selectList(namespace+"selectalljob");
	}
	
	public List<EmpVO> selectAll(){
		return session.selectList(namespace+"selectall");
	}

	public EmpVO selectById(int empid) {
		return session.selectOne(namespace+"selectbyid", empid);
	}
	
	public int insertEmp(EmpVO vo) {
		return session.insert(namespace+"insert", vo);
	}
	
	public int updateEmp(EmpVO vo) {
		return session.update(namespace+"update", vo);
	}
	
	public int deleteEmp(int empid) {
		return session.delete(namespace+"delete", empid);
	}
}
