<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	label{
		display : inline-block;
		width : 150px;
	}
</style>
</head>
<body>
<h1>직원 상세정보</h1>
<form action="empinsert" method="post">
	<label>직원번호 </label> <input type="number" name="employee_id"><br>
	<label>직원 성 </label> <input type="text" name="first_name"><br>
	<label>직원 이름 </label> <input type="text" name="last_name"><br>
	<label>직원 이메일 </label> <input type="text" name="email" placeholder="aa@bb.cc"><br>
	<label>직원 전화번호 </label> <input type="text" name="phone_number" pattern="\d{3}-\d{4}\-\d{4}" placeholder="000-0000-0000"><br>
	<label>입사일 </label> <input type="date" name="hire_date"><br>
	<label>직무 </label>
	<select name="job_id">
		<c:forEach var="job" items="${joblist }">
			<option value="${job }">${job }</option>
		</c:forEach>
	</select>
	<label>급여 </label> <input type="number" name="salary"><br>
	<label>커미션 </label> <input type="text" name="commission_pct"><br>
	<label>매니저 </label>
	<select name="manager_id">
		<c:forEach var="manager" items="${mlist }">
			<option value="${manager }">${manager }</option>
		</c:forEach>
	</select>
	<label>부서번호 </label> 
	<select name="department_id">
		<c:forEach var="dept" items="${deptlist }">
			<option value="${dept.department_id }">${dept.department_name }</option>
		</c:forEach>
	</select>
	<input type="submit" value="입력하기">
</form>
</body>
</html>