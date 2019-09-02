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
<form action="empdetail" method="post">
	직원번호 : <input type="number" name="employee_id" value="${emp.employee_id }" readonly><br>
	<!-- readonly로 해도되는데 css로 바탕색을 바까줘야함 -->
	직원 성 : <input type="text" name="first_name" value="${emp.first_name }"><br>
	직원 이름 : <input type="text" name="last_name" value="${emp.last_name }"><br>
	직원 이메일 : <input type="text" name="email" value="${emp.email }"><br>
	직원 전화번호 : <input type="text" name="phone_number" value="${emp.phone_number }"><br>
	입사일 : <input type="date" name="hire_date" value="${emp.hire_date }"><br>
	직무 : 
	<select name="job_id">
		<c:forEach var="job" items="${joblist }">
			<option value="${job }" ${(emp.job_id==job)?"selected":""}>${job }</option>
		</c:forEach>
	</select>
	급여 : <input type="number" name="salary" value="${emp.salary }"><br>
	커미션 : <input type="text" name="commission_pct" value="${emp.commission_pct }"><br>
	매니저 : 
	<select id="manager_id">
		<c:forEach var="manager" items="${mlist }">
			<option value="${manager }" ${(emp.manager_id==manager)?"selected":"" }>${manager }</option>
		</c:forEach>
	</select>
	부서번호 : 
	<select id="department_id">
		<c:forEach var="dept" items="${deptlist }">
			<option value="${dept.department_id }">${dept.department_name }</option>
		</c:forEach>
	</select>
	<input type="submit" value="입력하기">
</form>
</body>
</html>