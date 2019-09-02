package com.hanwha.model;

import org.springframework.web.multipart.MultipartFile;

/*
 * DTO(Data Transfer Object)
 * VO(Value Object)
 * Java Beans 기술에서는 기본생성자 및 getter/setter를 만들어야함
 */

public class DeptDTO {
	
	private int department_id;
	private String department_name;
	MultipartFile uploadFile;
	String fileName; 
	
	public DeptDTO() {
		
	}

	public DeptDTO(int department_id, String department_name) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
	}

		
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("부서정보...DeptDTO [department_id=").append(department_id).append(", department_name=")
				.append(department_name).append("]");
		return builder.toString();
	}

	
	
}
