package com.hanwha.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
	
	@Autowired
	EmpDAO_Mybatis dao;
	
	public List<Integer> selectAllManager(){
		return dao.selectAllManager();
	}
	
	public List<String> selectAllJob(){
		return dao.selectAllJob();
	}
	
	public List<EmpVO> selectAll(){
		return dao.selectAll();
	}

	public EmpVO selectById(int empid) {
		return dao.selectById(empid);
	}
	
	public List<EmpVO> selectByJob(String jobid, int sal){
		return selectByJob(jobid, sal);
	}
	
	public int insertEmp(EmpVO vo) {
		return dao.insertEmp(vo);
	}
	
	public int updateEmp(EmpVO vo) {
		return dao.updateEmp(vo);
	}
	
	public int deleteEmp(int empid) {
		return dao.deleteEmp(empid);
	}
	
}
